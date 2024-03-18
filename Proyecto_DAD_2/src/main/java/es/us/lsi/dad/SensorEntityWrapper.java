package es.us.lsi.dad;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
public class SensorEntityWrapper {
	
	private List<SensorEntity> sensorList;

	public SensorEntityWrapper(List<SensorEntity> sensorList) {
		super();
		this.sensorList = new ArrayList<SensorEntity>(sensorList);;
	}
	public SensorEntityWrapper(Collection<SensorEntity> sensorList) {
		super();
		this.sensorList = new ArrayList<SensorEntity>(sensorList);
	}


	public SensorEntityWrapper() {
		super();
	}

	public List<SensorEntity> getsensorList() {
		return sensorList;
	}

	public void setsensorList(List<SensorEntity> sensorList) {
		this.sensorList = sensorList;
	}

	@Override
	public int hashCode() {
		return Objects.hash(sensorList);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SensorEntityWrapper other = (SensorEntityWrapper) obj;
		return Objects.equals(sensorList, other.sensorList);
	}

	@Override
	public String toString() {
		return "SensorEntityWrapper [sensorList=" + sensorList + "]";
	}
	

	

}
