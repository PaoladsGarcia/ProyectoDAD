import java.util.Calendar;
import java.util.Objects;

public class SensorLuminosidad {
	
	private Integer idSensor;
	private Integer idPlaca;
	private Integer luminosidad;
	private Long timeStamp;
	
	public SensorLuminosidad() {
		super();
		this.timeStamp= Calendar.getInstance().getTimeInMillis();
	}

	@Override
	public int hashCode() {
		return Objects.hash(idSensor, idPlaca, luminosidad, timeStamp);
	}

	public SensorLuminosidad(Integer idSensor, Integer idPlaca, Integer luminosidad) {
		this.idSensor = idSensor;
		this.idPlaca = idPlaca;
		this.luminosidad = luminosidad;
		this.timeStamp= Calendar.getInstance().getTimeInMillis();
	}

	@Override
	public String toString() {
		return "SensorLuminosidad [idSensor=" + idSensor + ", idPlaca=" + idPlaca + ", luminosidad=" + luminosidad
				+ ", timeStamp=" + timeStamp + "]";
	}

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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SensorLuminosidad other = (SensorLuminosidad) obj;
		return Objects.equals(idPlaca, other.idPlaca) && Objects.equals(idSensor, other.idSensor)
				&& Objects.equals(luminosidad, other.luminosidad) && Objects.equals(timeStamp, other.timeStamp);
	}
	

}
