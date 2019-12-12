package fiuba.algo3.Controlador.MoverControlador;

import fiuba.algo3.Modelado.Direccion.Arriba;
import fiuba.algo3.Modelado.Entidades.Entidad;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class MoverArribaControlador implements EventHandler<MouseEvent> {
	private Arriba arriba;
	private Entidad entidad;
	
	public MoverArribaControlador(Entidad entidad) {
		this.entidad = entidad;
		this.arriba = new Arriba();
	}
	
	public void handle(MouseEvent click) {
		entidad.mover(this.arriba);
		Manejador.getInstancia().resetPanes();
	}
}