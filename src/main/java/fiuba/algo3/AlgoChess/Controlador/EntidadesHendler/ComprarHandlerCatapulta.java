package fiuba.algo3.AlgoChess.EntidadesHendler;

import fiuba.algo3.AlgoChess.Entidades.Catapulta;
import fiuba.algo3.AlgoChess.Tablero.Tablero;
import fiuba.algo3.AlgoChess.Ventana.PosicionarEntidadesEnTablero;
import fiuba.algo3.AlgoChess.Ventana.VistaDelTablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ComprarHandlerCatapulta implements EventHandler<ActionEvent>{
	Tablero tablero;
	
	VistaDelTablero vista;

	public ComprarHandlerCatapulta(Tablero tablero, VistaDelTablero vista) {
		this.tablero = tablero;
		this.vista   = vista;
	}

	@Override
	public void handle(ActionEvent event) {
		try {
			Catapulta catapulta = new Catapulta();
			//tablero.agergarJugador().comprarEntidad(catapulta);
			vista.setOnMousePressed(new PosicionarEntidadesEnTablero(catapulta,tablero,vista));
		}catch(RuntimeException e) {
			System.out.println("Lo sentimos, pero ya no contas con puntos suficientes para adquierir una catapulta");
		}	
	}

}