/** Modelos y Simulación 2020 - UNSL
 * 
 * @author Guadalupe Medina
 */

package simulador;

import java.util.Random;

public class GeneradorTiempos {

    private static Random random;

    static {
        random = new Random(System.currentTimeMillis());
    }

    public static int getTiempoEntreArribos() {
        if (random.nextFloat() < 0.3)
            return 4;
        else if (random.nextFloat() < 0.6)
            return 5;
        else
            return 6;
    }

    public static int getTiempoDuracionServicio() {
        if (random.nextFloat() < 0.3)
            return 3;
        else if (random.nextFloat() < 0.7)
            return 4;
        else
            return 5;
    }
}
