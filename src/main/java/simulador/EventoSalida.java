/** Modelos y Simulación 2020 - UNSL
 * 
 * @author Guadalupe Medina
 */

package simulador;

public class EventoSalida extends Evento {
	
   public EventoSalida(float tiempo,Item item){
       super(1,tiempo,item);
   }
        
    public void planificarEvento(Servidor servidor,Queue queue) {	            
        //planifico evento de salida
        Fel fel = Fel.getFel();
        
        if(!queue.HayCola()) {servidor.setEstado(false); //Si no hay cola, servidor=desocuapdo
            servidor.setTiempoInicioOcio(this.getTiempo());
        }
        else{
            Item aux=queue.suprimirCola();
            aux.setTiempoDuracionServicio(GeneradorTiempos.getTiempoDuracionServicio());
            fel.insertarFel(new EventoSalida((this.getTiempo()+aux.getTiempoDuracionServicio()), aux));
            servidor.setItem(aux);
        }

        //Estadisticas
        Item.setTiempoEsperaCola(this.getTiempo(), this.getItem().getTiempoDuracionServicio(),this.getItem().getTiempoArribo());
        Item.setTiempoTransito(this.getTiempo(), this.getItem().getTiempoArribo());
    }
}
