package ejercicioAnder;

import java.util.Arrays;

public class Utilidades {

	private int[] arrnumeros;
	private String orden;
	public int[] getArrnumeros() {
		return arrnumeros;
	}
	public void setArrnumeros(int[] arrnumeros) {
		this.arrnumeros = arrnumeros;
	}
	public String getOrden() {
		return orden;
	}
	public void setOrden(String orden) {
		this.orden = orden;
	}
	public Utilidades(int[] arrnumeros, String orden) {
		setArrnumeros(arrnumeros);
		setOrden(orden);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(arrnumeros);
		result = prime * result + ((orden == null) ? 0 : orden.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utilidades other = (Utilidades) obj;
		if (!Arrays.equals(arrnumeros, other.arrnumeros))
			return false;
		if (orden == null) {
			if (other.orden != null)
				return false;
		} else if (!orden.equals(other.orden))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Bailarines [arrnumeros=" + Arrays.toString(arrnumeros) + ", orden=" + orden + "]";
	}
	
	
	/*
	 * int i,j;
	 * 
	 * for (i = 0; i <= 9; i++) for (j = 0; j < 9; j++) { if (bailarines[j] >
	 * bailarines[j+1]) { aux = bailarines[j]; bailarines[j] = bailarines[j+1];
	 * bailarines[j+1] = aux; } }
	 */
}
