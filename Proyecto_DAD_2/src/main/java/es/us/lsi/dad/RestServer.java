package es.us.lsi.dad;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;

public class RestServer extends AbstractVerticle {

	private Map<Integer, SensorEntity> users = new HashMap<Integer, SensorEntity>();
	private Gson gson;

	public void start(Promise<Void> startFuture) {
		// Creating some synthetic data
		createSomeData(25);

		// Instantiating a Gson serialize object using specific date format
		gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();

		// Defining the router object
		Router router = Router.router(vertx);

		// Handling any server startup result
		vertx.createHttpServer().requestHandler(router::handle).listen(8080, result -> {
			if (result.succeeded()) {
				startFuture.complete();
			} else {
				startFuture.fail(result.cause());
			}
		});

		// Defining URI paths for each method in RESTful interface, including body
		// handling by /api/users* or /api/users/*
		router.route("/api/users*").handler(BodyHandler.create());
		
		router.get("/api/sensor").handler(this::getAllWithParams);
		router.get("/api/sensor/:sensorid").handler(this::getOne);
		
		router.get("/api/led").handler(this::getAllWithParams);
		router.get("/api/sensor/:ledid").handler(this::getOne);
		
		router.get("/api/sensor/all").handler(this::getAll);
		
		router.post("/api/sensors").handler(this::addOne);
		router.delete("/api/sensors/:sensorid").handler(this::deleteOne);
		router.put("/api/sensors/:sensorid").handler(this::putOne);
	}

	@SuppressWarnings("unused") 
	private void getAll(RoutingContext routingContext) {
		routingContext.response().putHeader("content-type", "application/json; charset=utf-8").setStatusCode(200)
				.end(gson.toJson(new SensorEntityWrapper(users.values())));
	}

	private void getAllWithParams(RoutingContext routingContext) {
		final Integer idPlaca = routingContext.queryParams().contains("name") ? Integer.valueOf(routingContext.queryParam("idPlaca").get(0)) : null;
		final Integer luminosidad = routingContext.queryParams().contains("surname") ? Integer.valueOf(routingContext.queryParam("surname").get(0)) : null;
		final Long timeStamp = routingContext.queryParams().contains("username") ? Long.valueOf(routingContext.queryParam("username").get(0)) : null;
		
		routingContext.response().putHeader("content-type", "application/json; charset=utf-8").setStatusCode(200)
				.end(gson.toJson(new SensorEntityWrapper(users.values().stream().filter(elem -> {
					boolean res = true;
					res = res && idPlaca != null ? elem.getIdPlaca().equals(idPlaca) : true;
					res = res && luminosidad != null ? elem.getLuminosidad().equals(luminosidad) : true;
					res = res && timeStamp != null ? elem.getTimeStamp().equals(timeStamp) : true;
					return res;
				}).collect(Collectors.toList()))));
	}

	private void getOne(RoutingContext routingContext) {
		int id = Integer.parseInt(routingContext.request().getParam("userid"));
		if (users.containsKey(id)) {
			SensorEntity ds = users.get(id);
			routingContext.response().putHeader("content-type", "application/json; charset=utf-8").setStatusCode(200)
					.end(gson.toJson(ds));
		} else {
			routingContext.response().putHeader("content-type", "application/json; charset=utf-8").setStatusCode(204)
					.end();
		}
	}

	private void addOne(RoutingContext routingContext) {
		final SensorEntity user = gson.fromJson(routingContext.getBodyAsString(), SensorEntity.class);
		users.put(user.getIdSensor(), user);
		routingContext.response().setStatusCode(201).putHeader("content-type", "application/json; charset=utf-8")
				.end(gson.toJson(user));
	}

	private void deleteOne(RoutingContext routingContext) {
		int id = Integer.parseInt(routingContext.request().getParam("userid"));
		if (users.containsKey(id)) {
			SensorEntity user = users.get(id);
			users.remove(id);
			routingContext.response().setStatusCode(200).putHeader("content-type", "application/json; charset=utf-8")
					.end(gson.toJson(user));
		} else {
			routingContext.response().setStatusCode(204).putHeader("content-type", "application/json; charset=utf-8")
					.end();
		}
	}

	private void putOne(RoutingContext routingContext) {
		int id = Integer.parseInt(routingContext.request().getParam("sensorid"));
		SensorEntity ds = users.get(id);
		final SensorEntity element = gson.fromJson(routingContext.getBodyAsString(), SensorEntity.class);
		ds.setIdPlaca(element.getIdPlaca());
		ds.setLuminosidad(element.getLuminosidad());
		ds.setTimeStamp(element.getTimeStamp());
		
		users.put(ds.getIdSensor(), ds);
		routingContext.response().setStatusCode(201).putHeader("content-type", "application/json; charset=utf-8")
				.end(gson.toJson(element));
	}

	private void createSomeData(int number) {
		Random rnd = new Random();
		IntStream.range(0, number).forEach(elem -> {
			int id = elem;
			users.put(id, new SensorEntity(id, Math.abs(rnd.nextInt()), Math.abs(rnd.nextInt())));
		});
	}
	
	
}
