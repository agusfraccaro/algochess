package fiuba.algo3.AlgoChess.EntidadesControlador;

import java.util.List;

import fiuba.algo3.AlgoChess.Entidades.Entidad;
import fiuba.algo3.AlgoChess.MoverControlador.Manejador;
import fiuba.algo3.AlgoChess.Ventana.VistaDelTablero;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class SoldadoControlador implements EventHandler<MouseEvent> {
	
	private Entidad entidad;
	
	private VistaDelTablero tablero;
	
	public SoldadoControlador(Entidad entidad, VistaDelTablero tablero) {
		this.entidad = entidad;
		this.tablero = tablero;
	}
	
	public void handle(MouseEvent click) {
		if(!Manejador.getInstancia().tieneEntidad()) {
			List<Pane> panes = tablero.panesAdyacentesEnTablero(entidad);
			panes.add(tablero.paneActual(entidad));
			Manejador.getInstancia().agregarEntidad(entidad, panes);
		}else {
			Manejador.getInstancia().agregarEntidad(entidad);
		}
	}
}