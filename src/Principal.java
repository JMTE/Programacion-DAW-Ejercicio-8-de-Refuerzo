import java.util.ArrayList;
import java.util.Scanner;
//Importamos las clases necesarias para el funcionamiento de nuestra clase y los paquetes que contienen nuestras clases creadas
import com.itt.restaurante.CantidadIncorrectaException;
import com.itt.restaurante.Consumicion;

public class Principal {

	public static void main(String[] args) {
		/*Creamos una referencia al objeto de la clase Scanner y le pasamos el objeto predefinido
		 *  System.in, que representa el flujo de entrada estándar.
		 */
		Scanner sc = new Scanner(System.in);
		/*Creamos nuestro ArrayList que va a contener nuestra lista de objetos Consumicion, cada
		 * vez que creamos un objeto consumicion, lo agregaremos a nuestro ArrayList.
		 */
		ArrayList<Consumicion> milista = new ArrayList();
		//Defino las variables en las que guardo los datos que voy a meter por consola
		String consum;
		double precio = 0;
		int cantidad = 0;
		String otracon;//Esto es para guardar el dato de SI o NO
		boolean salir = false;
		/*Implementamos un bucle while del cual saldremos cuando se introduzca un No 
		 * al finalizar el pedido de la consumicion.
		 */
		while (!salir) {

			System.out.println("¿Qué consumicion desea?");
			consum = sc.nextLine();
			System.out.println("Precio");
			/*El enunciado nos pide que cuando se cometa una excepcion del tipo
			NumberFormatException, el programa no se caiga y podamos seguir funcionando
			Por eso, en el momento que vamos a cargar nuestra variable precio con el valor
			introducido en consola, ahi tiene que empezar nuestro bloque try-catch para esta 
			exception.*/
			try {
				precio = Double.parseDouble(sc.nextLine());
				System.out.println("Cantidad");
				cantidad = Integer.parseInt(sc.nextLine());
				/*Y en este momento, al crear nuestro nuevo objeto Consumicion es donde puede
				 * producirse nuestra excepcion propia no controlada CantidadIncorrectaException.
				 * Al ser una excepcion no controlada no deberiamos de hacer el bloque try catch
				 * pero como el enunciado nos pide que el programa no se caiga, lo implementamos
				 */
				try {
					milista.add(new Consumicion(consum, cantidad, precio));
				} catch (CantidadIncorrectaException e) {
					/*Aqui le decimos que nos imprima el mensaje de la excepcion.
					 */
					System.out.println("Se ha producido " + e.getMessage());
					System.out.println("Consumicion no válida: cantidad = " + cantidad);
				}
			} catch (NumberFormatException e) {
				//Aqui capturamos la excepcion NumberFormatException
				System.out.println("Se ha producido " + e.getClass().getTypeName());
			}
			
			System.out.println("Si desea otra consumición teclee SI");
			otracon = sc.nextLine();
			/*En este momento con la sentencia if y el metodo equals comparamos que hemos 
			 * introducido por teclado, si hemos introducido un Si, seguimos en el bucle, si es un 
			 * no, pues salimos del bucle.
			 */
			if (otracon.equalsIgnoreCase("SI")) {
				salir = false;
			} else
				salir = true;
			
		}
		sc.close();//Cerramos el Scanner para no gastar recursos
		/*Ahora es el momento de presentar en pantalla nuestra ArrayList con los objetos 
		 * Consumicion que hemos creado. Como hay que presentar tambien el total de los precios
		 * creamos una variable sumatorio que la iremos cargando con cada elemento precio de los 
		 * diferentes objetos Consumicion
		 */
		double sumatorio = 0;
		double preciocantidad=0;
		for (int i = 0; i < milista.size(); i++) {
			System.out.println(milista.get(i).toString());
			preciocantidad=milista.get(i).getCantidad()*milista.get(i).getPrecio();
			sumatorio = sumatorio + preciocantidad;
		}
		//Finalizamos presentando los siguientes mensajes.
		System.out.println("Aqui tiene su comida, que aproveche");
		System.out.println("Son " + sumatorio + " euros.");
	}

}
