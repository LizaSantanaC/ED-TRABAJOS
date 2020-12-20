import java.util.InputMismatchException;
import java.util.Scanner;

class Nodo {
	private Nodo nodoAnterior;
	private int dato;
	private Nodo nodoSiguiente;

	public Nodo() {
	}

	public Nodo(int info) {
		this.dato = info;
		nodoAnterior = nodoSiguiente = null;
	}

	public int getInfo() {
		return dato;
	}

	public void setInfo(int info) {
		this.dato = info;
	}

	public Nodo getNodoSiguiente() {
		return nodoSiguiente;
	}

	public void setNodoSiguiente(Nodo nodoSiguiente) {
		this.nodoSiguiente = nodoSiguiente;
	}

	public Nodo getNodoAnterior() {
		return nodoAnterior;
	}

	public void setNodoAnterior(Nodo nodoAnterior) {
		this.nodoAnterior = nodoAnterior;
	}

	@Override
	public String toString() {
		return "Nodo [nodoAnterior=" + nodoAnterior + ", info=" + dato + ", nodoSiguiente=" + nodoSiguiente + "]";
	}
}

class ListaDoblementeEnlazada {
	Nodo nodoInicio;
	Nodo nodoFin;

	public ListaDoblementeEnlazada() {
	}

	public ListaDoblementeEnlazada(Nodo nodoInicio, Nodo nodoFin) {
		this.nodoInicio = null;
		this.nodoFin = null;
	}

	public boolean vacia() {
		return nodoInicio == null;
	}
	
	public void agregarAlInicio(int dato) {
		Nodo nuevoNodo = new Nodo(dato);
		if (vacia()) {
			nodoInicio = nodoFin = nuevoNodo;
		} else {
			nuevoNodo.setNodoSiguiente(nodoInicio);
			nodoInicio.setNodoAnterior(nuevoNodo);
			nodoInicio = nuevoNodo;
		}
	}

	public void agregarAlFinal(int dato) {
		Nodo nuevoNodo = new Nodo(dato);
		if (vacia()) {
			agregarAlInicio(dato);
		} else {
			Nodo nodoActual;
			nodoActual = nodoInicio;
			while (nodoActual.getNodoSiguiente() != null) {
				nodoActual = nodoActual.getNodoSiguiente();
			}
			nodoActual.setNodoSiguiente(nuevoNodo);
			nuevoNodo.setNodoAnterior(nodoActual);
		}

	}

	public void eliminarAlInicio() {
		if (vacia()) {
			System.out.println("La lista está vacía");
		} else if (nodoInicio == nodoFin) {
			nodoInicio = nodoFin = null;
		} else {
			Nodo nodoActual = nodoInicio;
			nodoInicio = nodoActual.getNodoSiguiente();
			nodoInicio.setNodoAnterior(null);
		}
	}

	public void eliminarAlFinal() {
		if (vacia()) {
			System.out.println("La lista está vacía");
		} else if (nodoInicio == nodoFin) {
			nodoInicio = nodoFin = null;
		} else {
			Nodo nodoAnterior;
			Nodo nodoSiguiente;

			nodoAnterior = nodoInicio;
			nodoSiguiente = nodoInicio.getNodoSiguiente();

			if (nodoSiguiente == null) {
				nodoInicio = nodoFin = null;
			} else {
				while (nodoSiguiente.getNodoSiguiente() != null) {
					nodoAnterior = nodoAnterior.getNodoSiguiente();
					nodoSiguiente = nodoSiguiente.getNodoSiguiente();
				}
				nodoAnterior.setNodoSiguiente(null);
			}
		}

	}

	public int eliminarDatoEspecifico(int dato) {
		if (vacia()) {
			return -1;
		} else if (nodoInicio == nodoFin && nodoInicio.getInfo() == dato) {
			System.out.println("Encontrado en el primer nodo");
			int n = nodoInicio.getInfo();
			nodoInicio = nodoInicio.getNodoSiguiente();
			if (nodoInicio != null)
				nodoInicio.setNodoAnterior(null);
			nodoFin = nodoInicio;
			return n;
		} else {
			Nodo nodoAnterior;
			Nodo nodoSiguiente;
			nodoAnterior = nodoInicio;
			nodoSiguiente = nodoInicio.getNodoSiguiente();

			if (nodoAnterior != null && nodoAnterior.getInfo() == dato) {
				int n = nodoAnterior.getInfo();
				nodoInicio = nodoAnterior.getNodoSiguiente();
				nodoInicio.setNodoAnterior(null);
				return n;
			} else {
				while (nodoSiguiente != null && nodoSiguiente.getInfo() != dato) {
					nodoAnterior = nodoAnterior.getNodoSiguiente();
					nodoSiguiente = nodoSiguiente.getNodoSiguiente();
				}
				if (nodoSiguiente != null && nodoSiguiente.getInfo() == dato) {
					int n = nodoSiguiente.getInfo();
					nodoSiguiente = nodoSiguiente.getNodoSiguiente();
					if (nodoSiguiente != null)
						nodoSiguiente.setNodoAnterior(nodoAnterior);

					nodoAnterior.setNodoSiguiente(nodoSiguiente);
					return n;
				} else {
					return -2;
				}
			}
		}
	}

	public void mostrarElementos() {
		Nodo nodoActual = nodoInicio;
		while (nodoActual != null) {
			System.out.print("<--[" + nodoActual.getInfo() + "]-->");
			nodoActual = nodoActual.getNodoSiguiente();
		}
		System.out.println();
	}
}

public class PruebaListaDoblementeEnlazada{

	public static void main(String[] args) {
		ListaDoblementeEnlazada le = new ListaDoblementeEnlazada();
		Scanner entrada = new Scanner(System.in);
		boolean salir = false;

		do {

			System.out.println("1) Insertar elemento");
			System.out.println("2) Eliminar elemento");
			System.out.println("3) Mostrar elementos");
			System.out.println("4) Salir ");

			try {
				System.out.println("Ingresa una opción: \n");
				int opcion = entrada.nextInt();

				switch (opcion) {
				case 1:

					boolean salir1 = false;

					do {

						System.out.println("1) Insertar elemento al inicio");
						System.out.println("2) Insertar elemento al final");
						System.out.println("3) Salir");

						try {
							System.out.println("Ingresa una opción: \n");
							int opcion1 = entrada.nextInt();

							switch (opcion1) {
							case 1:
								System.out.println("INgresa un elemento: ");
								int info = entrada.nextInt();
								le.agregarAlInicio(info);
								break;
							case 2:
								System.out.println("Ingresa un elemento: ");
								int info1 = entrada.nextInt();
								le.agregarAlFinal(info1);
								break;
							case 3:
								salir1 = true;
								break;
							default:
								System.out.println("Elege una opción valida");
							}

						} catch (InputMismatchException e) {
							System.out.println("Ingresa un número");
							entrada.next();
						}

					} while (!salir1);// while

					break;
				case 2:

					boolean salir2 = false;

					do {

						System.out.println("1) Eliminar elemento al inicio");
						System.out.println("2) Eliminar elemento al final");
						System.out.println("3) Eliminar dato específico");
						System.out.println("4) Salir");

						try {
							System.out.println("Ingresa una opción: \n");
							int opcion1 = entrada.nextInt();

							switch (opcion1) {
							case 1:
								le.eliminarAlInicio();
								break;
							case 2:
								le.eliminarAlFinal();
								break;
							case 3:
								System.out.println("Ingresa un elemento: ");
								int info2 = entrada.nextInt();

								int num = le.eliminarDatoEspecifico(info2);
								System.out.println(num == -1 ? "Lista vacía" : "Se eliminó correctamente");

								if (num == -1)
									System.out.println("Lista vacía");
								else if (num == -2)
									System.out.println("No se encontró el dato");
								else
									System.out.println("Se eliminó el " + num + " correctamente");

								break;
							case 4:
								salir2 = true;
								break;
							default:
								System.out.println("Elige una opción valida");
							}

						} catch (InputMismatchException e) {
							System.out.println("Ingresa un número");
							entrada.next();

						}

					} while (!salir2);// while

					break;
				case 3:
					le.mostrarElementos();
					break;
				case 4:
					salir = true;
					break;
				default:
					System.out.println("Elige una opción valida");
				}

			} catch (InputMismatchException e) {
				System.out.println("Ingresa un número");
				entrada.next();
			}
		} while (!salir);// while
	}
}