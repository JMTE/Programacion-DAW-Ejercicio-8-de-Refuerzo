package com.itt.restaurante;

/*Primero creamos nuestra clase de Exception pedida, en el enunciado se nos indica que 
 * sera una excepcion no controlada, por lo tanto debe de extender de RunTimeException.
 * Como siempre crearemos la clase con dos constructores, con el constructor por defecto y con
 * el constructor que habrá que pasarle un String por parametro que será el mensaje de error.
 */

public class CantidadIncorrectaException extends RuntimeException {
	public CantidadIncorrectaException() {

	}

	public CantidadIncorrectaException(String mensaje) {
		super(mensaje);
		
	}

}
