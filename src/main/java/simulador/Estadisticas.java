/** Modelos y Simulación 2020 - UNSL
 * 
 * @author Guadalupe Medina
 */

package simulador;

import java.text.DecimalFormat;

public class Estadisticas {

	static DecimalFormat decimal = new DecimalFormat("#.##");

	public static void calcularEstadisticas(float tiempoEsperaCola, float tiempoTransito, float tiempoOcioso,
			float tiempoFinSimulacion, int cantidadItems) {
		System.out.println("\n----------------------------------------------------------\n"
				+ "||                     Estadísticas                     ||\n"
				+ "----------------------------------------------------------\n");
		System.out.println("> Tiempo total de espera por el descenso: " + decimal.format(tiempoEsperaCola) + " mins");
		System.out.println("> Tiempo medio de espera por el descenso: "
				+ decimal.format((tiempoEsperaCola / cantidadItems)) + " mins\n");
		System.out.println("> Tiempo ocioso total de la pista: " + decimal.format(tiempoOcioso) + " mins");
		System.out.println("> Porcentaje de tiempo ocioso de la pista: "
				+ decimal.format(((tiempoOcioso * 100) / tiempoFinSimulacion)) + " %\n");
		System.out.println("> Tiempo total de tránsito: " + decimal.format(tiempoTransito) + " mins");
		System.out.println(
				"> Tiempo medio de tránsito: " + decimal.format((tiempoTransito / cantidadItems)) + " mins\n\n");

	}
}
