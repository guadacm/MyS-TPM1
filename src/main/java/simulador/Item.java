/** Modelos y Simulación 2020 - UNSL
 * 
 * @author Guadalupe Medina
 */

package simulador;

public class Item {
	private int numero;
	private float tiempoArribo;
	private float tiempoDuracionServicio;

	private static float tiempoEsperaCola = 0;
	private static float tiempoTransito = 0;
	private static int cantidadItems = 0;

	public Item(int numero, float tiempoArribo) {
		this.numero = numero;
		this.tiempoArribo = tiempoArribo;
		this.tiempoDuracionServicio = 0;
		if (numero != -1)
			cantidadItems++;
	}

	/**
	 * @return Returns the cantidadItems.
	 */
	public static int getCantidadItems() {
		return cantidadItems;
	}

	/**
	 * @param cantidadItems The cantidadItems to set.
	 */
	public static void setCantidadItems(int cantidadItems) {
		Item.cantidadItems = cantidadItems;
	}

	/**
	 * @return Returns the tiempoEsperaCola.
	 */
	public static float getTiempoEsperaCola() {
		return tiempoEsperaCola;
	}

	/**
	 * @param tiempoEsperaCola The tiempoEsperaCola to set.
	 */
	public static void setTiempoEsperaCola(float tiempoActual, float tiempoDuracionServicio, float tiempoArribo) {
		// calcular el tiempo de espera en cola
		tiempoEsperaCola += (tiempoActual - tiempoArribo - tiempoDuracionServicio);

	}

	/**
	 * @return Returns the tiempoTransito.
	 */
	public static float getTiempoTransito() {
		return tiempoTransito;
	}

	/**
	 * @param tiempoTransito The tiempoTransito to set.
	 */
	public static void setTiempoTransito(float tiempoActual, float tiempoArribo) {
		// calcular el tiempo de transito
		tiempoTransito += (tiempoActual - tiempoArribo);
	}

	/**
	 * @return Returns the numero.
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * @param numero The numero to set.
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	 * @return Returns the tiempoArribo.
	 */
	public float getTiempoArribo() {
		return tiempoArribo;
	}

	/**
	 * @param tiempoArribo The tiempoArribo to set.
	 */
	public void setTiempoArribo(float tiempoArribo) {
		this.tiempoArribo = tiempoArribo;
	}

	/**
	 * @return Returns the tiempoDuracionServicio.
	 */
	public float getTiempoDuracionServicio() {
		return tiempoDuracionServicio;
	}

	/**
	 * @param tiempoDuracionServicio The tiempoDuracionServicio to set.
	 */
	public void setTiempoDuracionServicio(float tiempoDuracionServicio) {
		this.tiempoDuracionServicio = tiempoDuracionServicio;
	}

	public String toString() {
		return ("Item nro: " + this.getNumero() + " | Tiempo de arribo: " + this.getTiempoArribo()
				+ " | Tiempo de duracion de servicio: " + this.getTiempoDuracionServicio());
	}
}
