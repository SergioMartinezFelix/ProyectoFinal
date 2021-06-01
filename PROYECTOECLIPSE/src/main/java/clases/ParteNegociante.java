package clases;

import enums.TipoViaje;

public abstract class ParteNegociante {

	private TipoViaje tipo;
	private int dinero;
	
	public ParteNegociante(TipoViaje tipoCliente, int dinero) {
		super();
		this.tipo = tipoCliente;
		this.dinero = dinero;
	}

	public TipoViaje getTipo() {
		return tipo;
	}

	public void setTipo(TipoViaje tipoCliente) {
		this.tipo = tipoCliente;
	}

	public int getDinero() {
		return dinero;
	}

	public void setDinero(int dinero) {
		this.dinero = dinero;
	}

	@Override
	public String toString() {
		return "ParteNegociante [tipo=" + tipo + ", dinero=" + dinero + "]";
	}
	
	
}
