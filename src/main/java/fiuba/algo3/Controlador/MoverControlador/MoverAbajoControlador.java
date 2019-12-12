package fiuba.algo3.Controlador.MoverControlador;

import fiuba.algo3.Modelado.Direccion.Abajo;
import fiuba.algo3.Modelado.Entidades.Entidad;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class MoverAbajoControlador implements EventHandler<MouseEvent> {
	private Abajo abajo;
	private Entidad entidad;
	
	public MoverAbajoControlador(Entidad entidad) {
		this.entidad = entidad;
		this.abajo = new Abajo();
	}
	
	public void handle(MouseEvent click) {
		entidad.mover(this.abajo);
		Manejador.getInstancia().resetPanes();
	}
}