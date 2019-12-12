package fiuba.algo3.Controlador.MoverControlador;

import fiuba.algo3.Modelado.Direccion.ArribaDerecha;
import fiuba.algo3.Modelado.Entidades.Entidad;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class MoverArribaDerechaControlador implements EventHandler<MouseEvent> {

	private ArribaDerecha diagonal;
	private Entidad entidad;
		
	public MoverArribaDerechaControlador(Entidad entidad) {
		this.entidad = entidad;
		this.diagonal = new ArribaDerecha();
	}
		
	public void handle(MouseEvent click) {
		entidad.mover(this.diagonal);
		Manejador.getInstancia().resetPanes();
	}

}