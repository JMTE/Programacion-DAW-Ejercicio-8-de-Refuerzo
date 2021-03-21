package com.itt.restaurante;
/*Cuando ya tenemos nuestra clase de excepcion propia creada, implementamos la clase 
 * Consumicion, que ya viene dada en su mayoria en el enunciado de la actividad.
 * Es una construccion de clase como las que hacemos habitualmente.
 */

public class Consumicion {
	// Declaramos y encapsulamos los atributos de la clase
	private String producto;
	private int cantidad;
	private double precio;

	/*
	 * Implementamos el constructor de la clase el cual al llamarlo habr� que
	 * pasarle tres parametros. A diferencia de las excepciones controladas no deben
	 * declararse en el m�todo mediante la palabra throws y que obligan al que lo
	 * llama a hacer un tratamiento de dicha excepci�n.
	 */
	public Consumicion(String producto, int cantidad, double precio) {
		this.producto = producto;
		this.cantidad = cantidad;
		this.precio = precio;
		// Aqui implementamos el codigo de en que momento se producir� la excepcion no
		// controlada
		if (cantidad <= 0) {
			throw new CantidadIncorrectaException("CantidadIncorrectaException");
		}

	}// A continuacion es la implementacion de los metodos GETTER de los atributos

	public String getProducto() {
		return this.producto;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public double getPrecio() {
		return this.precio;

	}

	@Override // Implementacion del metodo toString
	public String toString() {

		return "Consumici�n [producto=" + producto +

				", cantidad=" + cantidad

				+ ", precio=" + precio + "]";
	}

}
