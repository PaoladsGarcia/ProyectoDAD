package es.us.lsi.dad;

import java.util.Objects;

public class PlacaEntity {

	
	private Integer idPlaca;

	public Integer getIdPlaca() {
		return idPlaca;
	}

	public void setIdPlaca(Integer idPlaca) {
		this.idPlaca = idPlaca;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idPlaca);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlacaEntity other = (PlacaEntity) obj;
		return Objects.equals(idPlaca, other.idPlaca);
	}

	@Override
	public String toString() {
		return "PlacaEntity [idPlaca=" + idPlaca + "]";
	}

	public PlacaEntity(Integer idPlaca) {
		super();
		this.idPlaca = idPlaca;
	}

	public PlacaEntity() {
		super();
	}
	
	
	
}
