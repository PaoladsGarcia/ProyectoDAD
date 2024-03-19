package es.us.lsi.dad;

import java.util.Calendar;
import java.util.Objects;

public class SensorEntity {

	
	private Integer idSensor;
	private Integer idPlaca;
	private Integer luminosidad;
	private Long timeStamp;
	
	public Integer getIdSensor() {
		return idSensor;
	}
	public void setIdSensor(Integer idSensor) {
		this.idSensor = idSensor;
	}
	public Integer getIdPlaca() {
		return idPlaca;
	}
	public void setIdPlaca(Integer idPlaca) {
		this.idPlaca = idPlaca;
	}
	public Integer getLuminosidad() {
		return luminosidad;
	}
	public void setLuminosidad(Integer luminosidad) {
		this.luminosidad = luminosidad;
	}
	public Long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	public SensorEntity(Integer idSensor, Integer idPlaca, Integer luminosidad, Long timeStamp) {
		super();
		this.idSensor = idSensor;
		this.idPlaca = idPlaca;
		this.luminosidad = luminosidad;
		this.timeStamp = timeStamp;
	}
	
	public SensorEntity(Integer idSensor, Integer idPlaca, Integer luminosidad) {
		super();
		this.idSensor = idSensor;
		this.idPlaca = idPlaca;
		this.luminosidad = luminosidad;
		this.timeStamp = Calendar.getInstance().getTimeInMillis();
	}
	@Override
	public int hashCode() {
		return Objects.hash(idPlaca, idSensor, luminosidad, timeStamp);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SensorEntity other = (SensorEntity) obj;
		return Objects.equals(idPlaca, other.idPlaca) && Objects.equals(idSensor, other.idSensor)
				&& Objects.equals(luminosidad, other.luminosidad) && Objects.equals(timeStamp, other.timeStamp);
	}
	@Override
	public String toString() {
		return "SensorEntity [idSensor=" + idSensor + ", idPlaca=" + idPlaca + ", luminosidad=" + luminosidad
				+ ", timeStamp=" + timeStamp + "]";
	}
	
	
	
}
