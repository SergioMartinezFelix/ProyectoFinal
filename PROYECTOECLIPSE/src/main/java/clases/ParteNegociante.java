package clases;

import enums.TipoViaje;

/**
 * Clase abstracta de la que heredan cliente y agencia
 * @author Sergio Martínez Félix
 * Version 1.0
 * since 1.0
 */


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

	
	/**
     * Devuelve una cadena con un informe sobre los atributos del objeto
     *
     * @return String con información sobre los atributos del objeto
     */
	@Override
	public String toString() {
		return "ParteNegociante [tipo=" + tipo + ", dinero=" + dinero + "]";
	}
	
	
}
