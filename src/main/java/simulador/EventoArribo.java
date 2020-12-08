/** Modelos y Simulación 2020 - UNSL
 * 
 * @author Guadalupe Medina
 */

package simulador;


public class EventoArribo extends Evento{
    
    
    public EventoArribo(float tiempo, Item item){
        super(0,tiempo,item);
		
    } 
        
    public void planificarEvento(Servidor servidor,Queue queue){		                
        //planifico el evento de arribo
        Fel fel = Fel.getFel();
        
        if(servidor.isEstado()) queue.insertarCola(this.getItem());
        else{ //Si el servidor no esta ocupado planifico salida
            servidor.setEstado(true);
            servidor.setItem(this.getItem());
            servidor.setTiempoOcioso(this.getTiempo()-servidor.getTiempoInicioOcio());
            this.getItem().setTiempoDuracionServicio(GeneradorTiempos.getTiempoDuracionServicio());
            fel.insertarFel(new EventoSalida((this.getTiempo()+this.getItem().getTiempoDuracionServicio()), this.getItem()));
        }
        // planifico proximo arribo
        float nuevoArribo=GeneradorTiempos.getTiempoEntreArribos();
        Item nuevo = new Item(this.getItem().getNumero()+1, this.getTiempo()+nuevoArribo);
        fel.insertarFel(new EventoArribo(this.getTiempo()+nuevoArribo, nuevo));

    }

    
  
}
