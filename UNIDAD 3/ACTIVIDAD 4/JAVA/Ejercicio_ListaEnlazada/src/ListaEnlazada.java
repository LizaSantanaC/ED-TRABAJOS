public class ListaEnlazada {

	private Nodo nodoInicial;
	private Nodo nodoFinal;

	// constructor
	public ListaEnlazada() {
		nodoInicial = nodoFinal = null;

	}

	public boolean listaVacia() {
		return (nodoInicial == null) ? true : false;
	}

	// agregar elemento inicio
	public boolean agregarNodoInicio(String dato) {
		// incertar elemento
		nodoInicial = new Nodo(dato, nodoInicial);

		// si no hay elementos
		if (nodoFinal == null) {
			nodoFinal = nodoInicial;
		}

		return true;

	}

	public boolean agregarNodoFinal(String dato) {

		if (!listaVacia()) {
			// Mover referencia al nodo final
			// incsertar caja nueva
			nodoFinal.enlace = new Nodo(dato);
			// mover la referencia enlace del nodo
			// Apuntar hacia el final de la lista
			nodoFinal = nodoFinal.enlace;
		} else {
			// Si la lista eta vacia
			nodoInicial = nodoFinal = new Nodo(dato);
		}

		return true;
	}

	public String eliminarnodoInicio() {
		String dato = nodoInicial.dato;

		if (listaVacia()) {

		} else if (nodoInicial == nodoFinal) {

			nodoInicial = nodoInicial = null;

		} else {

			nodoInicial = nodoInicial.enlace;

		}

		return (dato == null) ? "Lista vacia no se puede eleiminar" : dato;
	}

	// eliminar nodo final
	public boolean eliminarnodoFinal() {

		if (listaVacia()) {
			return false;
		} else if (nodoInicial == nodoFinal) {
			nodoInicial = nodoInicial = null;
			return true;
		} else {
			Nodo nodoActual = nodoInicial;

			while (nodoActual.enlace != nodoFinal) {
				nodoActual = nodoActual.enlace;
			}
			nodoFinal = nodoActual;
			nodoFinal.enlace = null;
			return true;
		}

	}

	// mostrar elementos
	public void mostrarLista() {
		Nodo nodoActual = nodoInicial;

		while (nodoActual != null) {
			System.out.print("[Nombre: " + nodoActual.dato + "]-->");
			nodoActual = nodoActual.enlace;
		}
		System.out.println();
	}

	// metodo para buscar elemto dentro de la lista
	public boolean buscarElemento(String nombre) {
		Nodo nodoActual = nodoInicial;

		if (listaVacia()) {
			System.out.print("La lista esta vacia, no se puede buscar ");
		} else if (nodoInicial == nodoFinal) {
			if (nombre == nodoInicial.dato) {
				System.out.println("Elemento encontrado: " + nombre);
				return true;
			}

		} else {
			while (nodoActual != null) {
				if (nombre == nodoActual.dato) {
					System.out.println("Elemento encontrado: " + nombre);
					return true;
				}
				nodoActual = nodoActual.enlace;
			}

		}

		return false;
	}

	public boolean buscarElemento2(String nombre) {

		Nodo nodoActual = nodoInicial;

		if (listaVacia()) {
			System.out.println("Lista vacia no se puede buscar");
			return false;
		} else {

			while (nodoActual != null && nodoActual.dato != nombre) {

				nodoActual = nodoActual.enlace;
			}
		}

		return (nodoActual != null);
	}

	public void eliminarNodoEspecifico(String dato) {
		if (listaVacia()) {
			System.out.println("Lista vacia, imposible eliminar");
		} else {
			if (nodoInicial == nodoFinal && nodoFinal.dato == dato) {
				nodoFinal = nodoInicial = null;
				System.out.println("Elemento encontrado y eliminado con exito");
			} else if (nodoInicial.dato == dato) {
				System.out.println("Elemento encontrado en el primer nodo, eliminado con exito");
				nodoInicial = nodoInicial.enlace;
			} else {
				Nodo nodoSiguiente = nodoInicial.enlace;
				Nodo nodoAnterior = nodoInicial;

				while (nodoSiguiente != null && nodoSiguiente.dato != dato) {
					nodoAnterior = nodoAnterior.enlace;
					nodoSiguiente = nodoSiguiente.enlace;
				}
				if (nodoSiguiente != null) {
					nodoAnterior.enlace = nodoSiguiente.enlace;
					nodoSiguiente = nodoSiguiente.enlace;
				}
			}
		}
	}
}