package es.us.lsi.dad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
public class LuminosityLogin extends HttpServlet{
	
	
	private static final long serialVersionUID = -6201150158950823811L;

	private Map<Integer, Double> userPass;

	public void init() throws ServletException {
		userPass = new HashMap<Integer, Double>();
		userPass.put(1, 435.);
		super.init();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.valueOf(req.getParameter("idSensor"));
		if (userPass.containsKey(id)) {
			response(resp, "login ok");
		} else {
			response(resp, "invalid login");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    BufferedReader reader = req.getReader();
	    
	    Gson gson = new Gson();
	    SensorLuminosidad user = gson.fromJson(reader, SensorLuminosidad.class);
		if (!user.getIdSensor().equals(null) && !user.getLuminosidad().equals(null)) {
			userPass.put(user.getIdSensor(), user.getLuminosidad());
			resp.getWriter().println(gson.toJson(user));
			resp.setStatus(201);
		}else{
			resp.setStatus(300);
			response(resp, "Fallo");
		}
	   
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    BufferedReader reader = req.getReader();
	    
	    Gson gson = new Gson();
	    SensorLuminosidad user = gson.fromJson(reader, SensorLuminosidad.class);
		if (!user.getIdSensor().equals(null) && !user.getLuminosidad().equals(null) 
				&& userPass.containsKey(user.getIdSensor()) 
				&& userPass.get(user.getIdSensor()).equals(user.getLuminosidad())) {
			userPass.remove(user.getIdSensor());
			resp.getWriter().println(gson.toJson(user));
			resp.setStatus(201);
		}else{
			resp.setStatus(300);
			response(resp, "Fallo");
		}
	   
	}

	private void response(HttpServletResponse resp, String msg) throws IOException {
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<t1>" + msg + "</t1>");
		out.println("</body>");
		out.println("</html>");
	}
	
	
}
