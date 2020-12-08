/** Modelos y Simulación 2020 - UNSL
 * 
 * @author Guadalupe Medina
 */

package simulador;

public class App {

        public static void main(String[] args) {
                // boolean finSimulacion = false;
                Evento actual;
                // ListIterator iterator;
                float tiempoSimulacion = 0;

                Fel fel = Fel.getFel();// Creo la lista de eventos futuros

                Queue queue = new Queue();// Creo la cola de espera
                // Queue queue = Queue.getQueue(); //Creo cola de espera

                Servidor servidor = new Servidor();// Creo el servidor
                // Servidor servidor = Servidor.getServidor();//Creo el servidor

                // Continuar con la implementación ...

                System.out.println("\n----------------------------------------------------------\n"
                                + "||\t\tMODELOS Y SIMULACION 2020\t\t||\n"
                                + "----------------------------------------------------------\n"
                                + "||------------------ Guadalupe Medina ------------------||\n"
                                + "----------------------------------------------------------\n\n");
                System.out.println("     ------------- Corriendo simulación -------------     \n");

                actual = new EventoFinSimulacion(10080); // una semana = 10080 minutos
                fel.insertarFel(actual);// Inserto el evento de fin de simulación en la FEL

                actual = new EventoArribo(0, new Item(1, 0)); // Creo primer evento de arribo, en tiempo 0
                actual.planificarEvento(servidor, queue);
                // System.out.println("\n>> Tiempo " + tiempoSimulacion + " << " +
                // actual.toString());
                // System.out.println("* FEL");
                // fel.mostrarFel();
                // System.out.println("* COLA");
                // queue.mostrarCola();

                while (actual.getItem().getNumero() != -1) {
                        actual = fel.suprimirFel();
                        if (actual.getItem().getNumero() != -1) {
                                tiempoSimulacion = actual.getTiempo();
                                //System.out.println("\n>> Tiempo " + tiempoSimulacion + " << " + actual.toString());
                                //if (actual.getTipo() == 1 && queue.HayCola())
                                //        System.out.println("\n>> Tiempo " + tiempoSimulacion + " << "
                                //                        + queue.mostrarPrimero());
                                actual.planificarEvento(servidor, queue);
                                //System.out.println("* FEL");
                                //fel.mostrarFel();
                                //System.out.println("* COLA");
                                //queue.mostrarCola();
                        } else {
                                if (!servidor.isEstado())
                                        servidor.setTiempoOcioso(actual.getTiempo() - servidor.getTiempoInicioOcio());
                                System.out.println("     ------------- Fin de la simulación -------------     \n");
                                System.out.println("\n> Tiempo de simulación: " + actual.getTiempo());

                                int aux = 0;
                                if (fel.getLista().size() > 0)// a cantidad de items le resto los que quedaron en la fel
                                        aux = fel.getLista().size();
                                System.out.println("> Cantidad de vuelvo: " + (Item.getCantidadItems() - aux) + "\n");
                                Estadisticas.calcularEstadisticas(Item.getTiempoEsperaCola(), Item.getTiempoTransito(),
                                                servidor.getTiempoOcioso(), tiempoSimulacion,
                                                Item.getCantidadItems() - aux);
                        }

                }

        }
}
