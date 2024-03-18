package es.us.lsi.dad;

import java.util.Calendar;
import java.util.Objects;

public class LedEntity {

	
	private Integer idLed;
	private Integer idPlaca;
	private Integer intensidad;
	private Long timeStamp;
	
	
	
	public Integer getIdLed() {
		return idLed;
	}
	public void setIdLed(Integer idLed) { 
		this.idLed = idLed;
	}
	public Integer getIdPlaca() {
		return idPlaca;
	}
	public void setIdPlaca(Integer idPlaca) {
		this.idPlaca = idPlaca;
	}
	public Integer getIntensidad() {
		return intensidad;
	}
	public void setIntensidad(Integer intensidad) {
		this.intensidad = intensidad;
	}
	public Long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	public LedEntity(Integer idLed, Integer idPlaca, Integer intensidad, Long timeStamp) {
		super();
		this.idLed = idLed;
		this.idPlaca = idPlaca;
		this.intensidad = intensidad;
		this.timeStamp = timeStamp;
	}
	
	public LedEntity() {
		super();
	}
	
	public LedEntity(Integer idLed, Integer idPlaca) {
		super();
		this.idLed = idLed;
		this.idPlaca = idPlaca;
	}
	
	
	public LedEntity(Integer idLed, Integer idPlaca, Integer intensidad) {
		super();
		this.idLed = idLed;
		this.idPlaca = idPlaca;
		this.intensidad = intensidad;
		this.timeStamp = Calendar.getInstance().getTimeInMillis();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(idLed, idPlaca, intensidad, timeStamp);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LedEntity other = (LedEntity) obj;
		return Objects.equals(idLed, other.idLed) && Objects.equals(idPlaca, other.idPlaca)
				&& Objects.equals(intensidad, other.intensidad) && Objects.equals(timeStamp, other.timeStamp);
	}
	@Override
	public String toString() {
		return "LedEntity [idLed=" + idLed + ", idPlaca=" + idPlaca + ", intensidad=" + intensidad + ", timeStamp="
				+ timeStamp + "]";
	}
	
	
}
