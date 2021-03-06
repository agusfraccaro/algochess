package fiuba.algo3.Modelado.Tablero;

import fiuba.algo3.Modelado.Entidades.Entidad;
import fiuba.algo3.Modelado.Entidades.ObjetoNull;

public class Casillero {
	
	private Posicion posicion;
	
	private Entidad entidad = new ObjetoNull();

	public Casillero(Posicion posicion){
		this.posicion = posicion;
	}

	public void agregarEntidad(Entidad entidad) {
		this.entidad.agregar(entidad);
	}
	
	public Casillero getCasillero() {
		return this;
	}
	
	public Posicion getPosicionDeCasillero() {
		return this.getCasillero().posicion;
	}
	
	public Entidad getEntidad() {
		return this.entidad;
	}

    public void quitarEntidad() {
		this.entidad = new ObjetoNull();
    }

}
