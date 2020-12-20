import java.util.Arrays;
import java.util.Scanner;

/*
 *  1) Crear (instanciacion)
 *  2) Llenar (inicializacion)
 *  3) Obtener posición inicio
 *  ) Obtener posición fin
 *  5) Obtener cantidad elementos	
 *  6) Mostrar todos los elementos
 *  7) Mostrar elemento del inicio
 *  8) Mostrar elemento del fin
 *  9) Aumentar tamaño del arreglo
 *  10) Disminuir tamaño del arreglo	
 *  11) Insertar elemento en posición especifica
 *  12) Eliminar elemento de posición especifica
 *  13) Invertir el vector
 *  SALIR
 */

class VectorEspecial {
	
	//Variables
	private int edades[];
	
	//Entrada - Lectura
	Scanner entrada = new Scanner(System.in);

	//Constructor
	public VectorEspecial() {

	}

	//Creación de la instancia
	public VectorEspecial(int tamaño) {
		this.edades = new int[tamaño];
	}
	
	//Getters and setters
	public int[] getEdades() {
		return this.edades;
	}

	public void setEdades(int[] edades) {
		this.edades = edades;
	}

	//Llenar vector 
	public void llenarVector() {
		for (int i = 0; i < edades.length; i++) {
			System.out.println("Ingresa la edad: " + (i + 1) + ": ");
			edades[i] = this.validacionEntero();
		}
	}

	//Mostrar vector
	public void mostrarVector() {
		System.out.println(Arrays.toString(edades));
	}
	
	//Obtener primera posicion del vector
	public int obtenerPosicionInicio() {
		return this.edades[0];
	}

	//Obtener la ultima posicion del vector
	public int obtenerPosicionFin() {
		return this.edades[this.edades.length - 1];
	}

	//Obtener la cantidad de elementos del arreglo
	public int obtenerCantidadElementos() {
		return this.edades.length;
	}

	//Mostrar el elemento ingresado al inicio del vector
	public void mostrarElementoInicio() {
		System.out.println(this.edades[0]);
	}

	//Mostrar el elemento ingresado al final del vector
	public void mostrarElementoFin() {
		System.out.println(this.edades[this.edades.length - 1]);
	}

	//Aumentar el tamaño del vector
	public void aumentarTamañoVector(int tamaño) {
		while (tamaño < 1) {
			System.out.println("¡SI DESEA AUMENTAR EL TAMAÑO DEL VECTOR, ES NECESARIO INGRESAR UN NÚMERO ENTERO!");
			System.out.println("Ingresar nuevo tamaño del vector []: ");
			tamaño = entrada.nextInt();
		}
		int[] newArray = Arrays.copyOf(edades, edades.length + tamaño);
		this.setEdades(newArray);
		System.out.println("Se agregaron: " + tamaño + "posiciones");
	}

	//Disminuir tamaño del vector
	public void disminuirTamañoVector(int tamaño) {
		boolean errorVector = false;
		do {
			errorVector = false;
			try {
				int[] newArray = Arrays.copyOf(edades, edades.length - tamaño);
				this.setEdades(newArray);
			} catch (NegativeArraySizeException e) {
				do {
					System.out.println("¡SI DESEA DISMINUIR EL TAMAÑO DEL VECTOR, ES NECESARIO INGRESAR UN NÚMERO ENTERO DIFERENTE AL TAMAÑO ACTUAL!");
					System.out.println("Ingresar nuevo tamaño del vector []: ");
					tamaño = entrada.nextInt();
					errorVector = true;
					continue;
				} while (tamaño > this.obtenerCantidadElementos());
			}
		} while (errorVector);
		System.out.println("El vector disminuyo a: " + tamaño + "posiciones");
	}

	
	//INsertar un nuevo elemento en una posicion especifica 
	public void insertarElementoPosicionEspecifica(int posicion, int elemento) {
		boolean errorVector = false;
		do {
			errorVector = false;
			try {
				this.getEdades()[posicion - 1] = elemento;
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("¡ES NECESARIO INGRESAR UN NÚMERO ENTERO DIFERENTE!");
				System.out.println("Ingresar nuevo elemento []: ");
				System.out.println("Elemento en posicion: ");
				posicion = this.validacionEntero();
				System.out.println("EL elemento es: ");
				elemento = this.validacionEntero();
				errorVector = true;
			}
		} while (errorVector);
	}

	//Eliminar un elemento en un aposicion especifica 
	public void eliminarElementoPosicionEspecifica(int posicion) {
		boolean errorVector = false;
		do {
			errorVector = false;
			try {
				this.getEdades()[posicion - 1] = 0;
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("¡ES NECESARIO INGRESAR UNA POSICIÓN VALIDA!");
				System.out.println("Ingresar nuevo elemento []: ");
				posicion = this.validacionEntero();
				errorVector = true;
			}
		} while (errorVector);
		System.out.println("¡Elemento eliminado!");
	}

	//INvertir vector
	public void invertirVector() {
		int[] newArray = Arrays.copyOf(edades, edades.length);
		int edades[] = this.getEdades();
		for (int i = 0; i < newArray.length; i++) {
			newArray[i] = edades[edades.length - 1 - i];
		}
		this.setEdades(newArray);
		System.out.println("Vector invertido: " + edades);
	}

	//Verificacion de numero enteros en el vector
	public int validacionEntero() {
		int aux = 0;
		boolean errorVectorr = false;
		do {
			try {
				aux = entrada.nextInt();
			} catch (java.util.InputMismatchException e) {
				System.out.println("Ingresa un número entero: ");
				entrada.nextLine();
				errorVectorr = true;
				continue;
			}
			if (aux > 0) {
				errorVectorr = false;
			} else {
				System.out.println("¡Ingresa un número entero!");
				errorVectorr = true;
			}
		} while (errorVectorr);
		return aux;
	}
}

public class PruebaVectorEspecial {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		VectorEspecial vector1 = new VectorEspecial();
		System.out.println("Ingresa el tamaño del vector:");
		System.out.println();
		VectorEspecial vector2 = new VectorEspecial(vector1.validacionEntero());
		
		//Menu
		boolean salir = false;
		byte entradaOpcion = 0;
		do {
			System.out.println("---------------ELige una opción--------------- \n");
			System.out.println(
					" 1) Llenar vector \n "
			       + "2) Mostrar vector \n "
					+ "3) Obtener posicion inicio \n "
					+ "4) Obtener posicion final \n "
					+ "5) Obtener cantidad elementos \n "
					+ "6) Mostrar elemento inicio \n"
					+ " 7) Mostrar elemento final \n "
					+ "8) Aumentar tamaño del vector \n "
					+ "9) Disminuir tamaño del vector \n "
					+ "10) Insertar elemento en una posicion especifica \n"
					+ " 11) Eliminar elemento de una posicion especifica \n "
					+ "12) Invertir vector \n "
					+ "13) Salir");

			try {
				entradaOpcion = entrada.nextByte();
			} catch (java.util.InputMismatchException e) {
				System.out.println("¡Vuelve a ingresar una opción!");
				entrada.nextLine();
			}
			if (entradaOpcion < 1 || entradaOpcion > 13) {
				System.out.println("¡Vuelve a ingresar una opción!");
			}

			switch (entradaOpcion) {
			case 1:
				vector2.llenarVector();
				break;
				
			case 2:
				vector2.mostrarVector();
				break;
				
			case 3:
				System.out.println(vector2.obtenerPosicionInicio());
				break;
				
			case 4:
				System.out.println(vector2.obtenerPosicionFin());
				break;
				
			case 5:
				System.out.println(vector2.obtenerCantidadElementos());
				break;
				
			case 6:
				vector2.mostrarElementoInicio();
				break;
				
			case 7:
				vector2.mostrarElementoFin();
				break;
				
			case 8:
				System.out.println("Nuevo tamaño: ");
				int aumentarTamaño = vector1.validacionEntero();
				vector2.aumentarTamañoVector(aumentarTamaño);
				break;
				
			case 9:
				System.out.println("Nuevo tamaño: ");
				int disminuirTamaño = vector1.validacionEntero();
				vector2.disminuirTamañoVector(disminuirTamaño);
				break;
				
			case 10:
				System.out.println("Elemento en posición: ");
				int posicion = vector1.validacionEntero();
				System.out.println("Ingresa el nuevo elemento: ");
				int elementoPosicion = vector1.validacionEntero();
				vector2.insertarElementoPosicionEspecifica(posicion, elementoPosicion);
				break;
				
			case 11:
				System.out.println("Ingresa el elemento que deseas eliminar");
				int elementoEliminar = vector1.validacionEntero();
				vector2.eliminarElementoPosicionEspecifica(elementoEliminar);
				break;
				
			case 12:
				vector2.invertirVector();
				break;
				
			case 13:
				salir = true;
				break;
				
			default:
				break;
			}

		} while (!salir);
		System.out.println("------------------------------------------------------------");
	}
}
