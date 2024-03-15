package dad;

import java.util.Calendar;
import java.util.Objects;

public class SensorLuminosidad {

	
	private Integer idSensor;
	private Integer luminosidad;
	private Long timeStamp;
	
	
	
	
	public SensorLuminosidad() {
		super();
		this.timeStamp= Calendar.getInstance().getTimeInMillis();
	}



	public SensorLuminosidad(Integer idSensor, Integer intesidad, Long timeStamp) {
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


	public Integer getLuminosidad() {
		return luminosidad;
	}


	public void setLuminosidad(Integer intesidad) {
		this.luminosidad = intesidad;
	}


	public Long getTimeStamp() {
		return timeStamp;
	}


	public void setTimeStamp(Long timeStamp) {
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
