package fiuba.algo3.Modelado.Entidades;

import java.util.List;

import fiuba.algo3.Modelado.Bandos.Bando;
import fiuba.algo3.Modelado.Direccion.Direccion;
import fiuba.algo3.Modelado.Excepciones.BatallonYaPoseeBandoYPosicionesExcepcion;
import fiuba.algo3.Modelado.Excepciones.CasilleroOcupadoExcepcion;
import fiuba.algo3.Modelado.Tablero.Posicion;


public class Batallon implements Entidad{
	
    private List<Soldado> soldadosDelBatallon;
    
    private Bando bando;
        
    public Batallon(List<Soldado> batallon) {
    	this.soldadosDelBatallon = batallon;
    	soldadosDelBatallon.stream().forEach(x -> this.bando = x.getBando());
    }
    
    public List<Soldado> getBatallon() {
    	return this.soldadosDelBatallon;
    }
    @Override
    public Posicion getPosicion() {
    	return soldadosDelBatallon.get(2).getPosicion();
       
    }

    @Override
    public void recibirDanio(int danio) {
    	soldadosDelBatallon.stream().forEach(x -> x.recibirDanio(danio));
    }

    @Override
    public void reponerVida(int curacion) {
    	soldadosDelBatallon.stream().forEach(x -> x.reponerVida(curacion));
    }

    @Override
    public void mover(Direccion direccion) {
    	soldadosDelBatallon.stream().forEach(x -> x.mover(direccion));
    }

    @Override
    public Entidad agregar(Entidad otraEntidad) {
        throw new CasilleroOcupadoExcepcion();
    }

    @Override
    public int getCosto() {
        return 0;
    }

	@Override
	public Bando getBando() {
		return this.bando;
	}

	@Override
	public void atacarEnemigo() {
    	soldadosDelBatallon.stream().forEach(x -> x.atacarEnemigo());
	}

	@Override
	public int getVida() {
		int vida = 0;
		for(Soldado soldado : soldadosDelBatallon) {
			vida = soldado.getVida();
		}
		return vida;
	}
	@Override
	public void recibirPosicionYBando(Posicion posicion, Bando bandoJugador) {
		throw new BatallonYaPoseeBandoYPosicionesExcepcion();
	}
}
