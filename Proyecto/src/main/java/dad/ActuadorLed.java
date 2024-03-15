package dad;
import java.util.Calendar;
import java.util.Objects;

public class ActuadorLed {

	
	private Integer idLed;
	private Integer intensidad;
	private Long timeStamp; // para guardar cuando hacemos cambio con actuador
	
	
	
	
	public ActuadorLed() {
		super();
		this.timeStamp= Calendar.getInstance().getTimeInMillis();
	}


	public ActuadorLed(Integer idLed, Integer intensidad, Long timeStamp) {
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
