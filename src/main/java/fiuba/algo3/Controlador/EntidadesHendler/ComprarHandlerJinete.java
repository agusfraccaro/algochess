package fiuba.algo3.Controlador.EntidadesHendler;

import fiuba.algo3.Modelado.Entidades.Jinete;
import fiuba.algo3.Modelado.Tablero.Tablero;
import fiuba.algo3.Vista.Ventana.PosicionarEntidadesEnTablero;
import fiuba.algo3.Vista.Ventana.VistaDelTablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ComprarHandlerJinete implements EventHandler<ActionEvent>{

	Tablero tablero;
	
	VistaDelTablero vista;

	public ComprarHandlerJinete(Tablero tablero, VistaDelTablero vista) {
		this.tablero = tablero;
		this.vista   = vista;
	}

	@Override
	public void handle(ActionEvent event) {
		try {
			Jinete jinete = new Jinete();
			//tablero.agergarJugador().comprarEntidad(jinete);
			vista.setOnMousePressed(new PosicionarEntidadesEnTablero(jinete,tablero,vista));
		}catch(RuntimeException e) {
			System.out.println("Lo sentimos, pero ya no contas con puntos suficientes para adquierir un Jinete");
		}	
	}

}