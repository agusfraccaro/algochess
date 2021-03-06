package fiuba.algo3.Modelado.Jugador;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.Modelado.Bandos.Bando;
import fiuba.algo3.Modelado.Entidades.Entidad;
import fiuba.algo3.Modelado.Entidades.FabricaEntidades;
import fiuba.algo3.Modelado.Entidades.ObjetoNull;
import fiuba.algo3.Modelado.Excepciones.CantidadDePuntosInsuficientesExcepcion;
import fiuba.algo3.Modelado.Excepciones.CasilleroOcupadoExcepcion;
import fiuba.algo3.Modelado.Excepciones.ColocarEntidadEnSectorEnemigoExcepcion;
import fiuba.algo3.Modelado.Tablero.Posicion;
import fiuba.algo3.Modelado.Tablero.Tablero;

public class Jugador {
	
	private final int  PUNTOS_INICIALES = 20;
	
	private int puntosActuales = PUNTOS_INICIALES;
	
	private String nombre;
	
	private FabricaEntidades fabrica = new FabricaEntidades();
	
	private List<Entidad> entidades;
	
	private Bando bando;
	
	private Jugador otroJugador;
	
	private Tablero tablero = new Tablero();
	
	public Jugador(String nombre, Bando bando, Jugador otroJugador) {
		asignarAtributosDelJugador(nombre, bando);
		this.otroJugador = otroJugador;
	}
	
	public Jugador(String nombre, Bando bando, String nombre1, Bando bando1) {
		asignarAtributosDelJugador(nombre, bando);
		this.otroJugador = new Jugador(nombre1, bando1, this);
	}
	private void asignarAtributosDelJugador(String nombre, Bando bando) {
		this.nombre = nombre;
		this.bando = bando;
		this.entidades  = new ArrayList<Entidad>();
	}

	public Jugador obtenerSiguienteJugador() {
		return this.otroJugador;
	}
	
	public void agregarEntidad(String tipoEntidad, Posicion posicion) {
		Entidad entidad = fabrica.crearEntidad(tipoEntidad);
	}

	public void descontarPuntos(int numero) {
		if (puntosActuales <= 0) { throw new CantidadDePuntosInsuficientesExcepcion(); }
		puntosActuales -= numero;
	}

	public int cantidadPuntos(){
		return puntosActuales;
	}
	
	public int getPuntos() {
		return this.puntosActuales;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getNombreOtroJugador() {
		return this.otroJugador.getNombre();
	}
	
	public Entidad getEntidad(Posicion posicion) {
		Entidad entidadBuscada = new ObjetoNull();
		for(Entidad entidad : this.entidades) {
			if(entidad.getPosicion().mismaPosicion(posicion, entidad.getPosicion())) {
				entidadBuscada = entidad;
			}
		}
		return entidadBuscada;
	}
	
	public List<Entidad> getListDeEntidades() {
		return this.entidades;
	}
	
	public int getCantidadDeEntidades() {
		return this.getListDeEntidades().size();
	}
	
	public void estadoDeEntidad(Entidad entidad) {
		if(entidad.getVida() <= 0) {
			eliminarEntidad(entidad);
		}
	}
	private void eliminarEntidad(Entidad entidad) {
		entidades.remove(entidad);
	}

	public Bando getBando() {
		return this.bando;
	}
	
	public void setNombre(String text) {
		this.nombre = text;
	}

	public void setOtroJUgador(Jugador jugadorAux) {
		this.otroJugador = jugadorAux;
	}

	public void comprarEntidad(Entidad entidad) {
		descontarPuntos(entidad.getCosto());
	}

}
