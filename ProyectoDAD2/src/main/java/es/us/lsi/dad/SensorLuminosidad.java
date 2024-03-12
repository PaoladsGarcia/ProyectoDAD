package es.us.lsi.dad;

import java.util.Calendar;
import java.util.Objects;

public class SensorLuminosidad {

	
	private Integer idSensor;
	private Double luminosidad;
	private Calendar timeStamp;
	
	
	
	
	public SensorLuminosidad() {
		super();
	}


	public SensorLuminosidad(Integer idSensor, Double intesidad, Calendar timeStamp) {
		super();
		this.idSensor = idSensor;
		this.luminosidad = intesidad;
		this.timeStamp = timeStamp;
	}


	public Integer getIdSensor() {
		return idSensor;
	}


	public void setIdSensor(Integer idSensor) {
		this.idSensor = idSensor;
	}


	public Double getIntesidad() {
		return luminosidad;
	}


	public void setIntesidad(Double intesidad) {
		this.luminosidad = intesidad;
	}


	public Calendar getTimeStamp() {
		return timeStamp;
	}


	public void setTimeStamp(Calendar timeStamp) {
		this.timeStamp = timeStamp;
	}


	@Override
	public int hashCode() {
		return Objects.hash(idSensor, luminosidad, timeStamp);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SensorLuminosidad other = (SensorLuminosidad) obj;
		return Objects.equals(idSensor, other.idSensor) && Objects.equals(luminosidad, other.luminosidad)
				&& Objects.equals(timeStamp, other.timeStamp);
	}


	@Override
	public String toString() {
		return "SensorLuminosidad [idSensor=" + idSensor + ", intesidad=" + luminosidad + ", timeStamp=" + timeStamp
				+ "]";
	}
	
	
	
	
	
}
