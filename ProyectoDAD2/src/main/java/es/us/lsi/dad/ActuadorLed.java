package es.us.lsi.dad;

import java.util.Calendar;
import java.util.Objects;

public class ActuadorLed {

	
	private Integer idLed;
	private Double intensidad;
	private Calendar timeStamp;
	
	
	
	
	public ActuadorLed() {
		super();
	}


	public ActuadorLed(Integer idLed, Double intensidad, Calendar timeStamp) {
		super();
		this.idLed = idLed;
		this.intensidad = intensidad;
		this.timeStamp = timeStamp;
	}


	public Integer getIdLed() {
		return idLed;
	}


	public void setIdLed(Integer idLed) {
		this.idLed = idLed;
	}


	public Double getIntensidad() {
		return intensidad;
	}


	public void setIntensidad(Double intensidad) {
		this.intensidad = intensidad;
	}


	public Calendar getTimeStamp() {
		return timeStamp;
	}


	public void setTimeStamp(Calendar timeStamp) {
		this.timeStamp = timeStamp;
	}


	@Override
	public String toString() {
		return "ActuadorLed [idLed=" + idLed + ", intensidad=" + intensidad + ", timeStamp=" + timeStamp + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(idLed, intensidad, timeStamp);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ActuadorLed other = (ActuadorLed) obj;
		return Objects.equals(idLed, other.idLed) && Objects.equals(intensidad, other.intensidad)
				&& Objects.equals(timeStamp, other.timeStamp);
	}
	
	
	
	
}
