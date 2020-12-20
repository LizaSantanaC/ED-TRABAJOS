public class ArbolBinario {
	NodoArbol raiz;
	int numNodos = 0;

	public void crearArbol() {
		raiz = null;
	}

	public void insertarNodo(int dato) {

		NodoArbol nodoInsertado = new NodoArbol(dato);

		if (raiz == null) {
			raiz = nodoInsertado;
		} else {
			NodoArbol nodoAuxiliar = raiz;
			NodoArbol nodoPadre = null;

			while (nodoAuxiliar != null) {
				nodoPadre = nodoAuxiliar;

				if (dato < nodoAuxiliar.dato) {
					nodoAuxiliar = nodoAuxiliar.nodoIzquierdo;
					if (nodoAuxiliar == null) {
						nodoPadre.nodoIzquierdo = nodoInsertado;
					}
				} else {
					nodoAuxiliar = nodoAuxiliar.nodoDerecho;

					if (nodoAuxiliar == null) {
						nodoPadre.nodoDerecho = nodoInsertado;
					}
				}
			}

		}

	}// metodo insertar

	/* Recorrido del arbol */
	public void recorridoInOrden(NodoArbol raiz) {

		if (raiz != null) {
			recorridoInOrden(raiz.nodoIzquierdo);
			System.out.print(raiz.dato + "->");
			recorridoInOrden(raiz.nodoDerecho);
		}
	}

	// 3)
	public void recorridoPosorden(NodoArbol raiz) {

		if (raiz != null) {
			recorridoInOrden(raiz.nodoIzquierdo);
			recorridoInOrden(raiz.nodoDerecho);
			System.out.print(raiz.dato + "->");

		}
	}

	public void recorridoPreorden(NodoArbol raiz) {

		if (raiz != null) {
			System.out.print(raiz.dato + "->");
			recorridoInOrden(raiz.nodoIzquierdo);
			recorridoInOrden(raiz.nodoDerecho);

		}
	}

	// recorrido del arbol

	public boolean buscarDato(int dato) {
		NodoArbol auxiliar = raiz;

		if (auxiliar == null) {
			// System.out.println("El arbol esta vacio");
			return false;
		} else {

			while (auxiliar != null) {

				if (dato == auxiliar.dato) {
					return true;
				} else if (dato < auxiliar.dato) {
					auxiliar = auxiliar.nodoIzquierdo;
				} else if (dato > auxiliar.dato) {
					auxiliar = auxiliar.nodoDerecho;
				}

			}
			return false;
		}

	}// Metodo buscar

	/* Mostrar dato menor */
	public NodoArbol buscarDatoMenor(NodoArbol auxiliar) {

		if (auxiliar == null) {
			return null;
		} else {

			while (auxiliar.nodoIzquierdo != null) {
				auxiliar = auxiliar.nodoIzquierdo;
			}
			return auxiliar;
		}

	}// Dato menor

	public void buscarDatoMayor() {
		NodoArbol auxiliar = raiz;

		if (auxiliar == null) {
			System.out.println("Arbol vacio");
		} else {

			while (auxiliar.nodoDerecho != null) {
				auxiliar = auxiliar.nodoDerecho;
			}

			System.out.println(auxiliar.dato);
		}

	}// Dato mayor

	double promedio;

	public int cantidadNodos(NodoArbol raiz) {

		if (raiz != null) {
			cantidadNodos(raiz.nodoIzquierdo);
			cantidadNodos(raiz.nodoDerecho);
			numNodos++;
		}
		return numNodos;
	}

	/* Eliminar nodo */
	public boolean borrarNodo(int dato) {
		NodoArbol auxiliar = raiz;
		NodoArbol padre = raiz;
		boolean hijoHisquierdo = true;

		while (auxiliar.dato != dato) {
			padre = auxiliar;
			if (dato < auxiliar.dato) {
				auxiliar = auxiliar.nodoIzquierdo;
			} else if (dato > auxiliar.dato) {
				auxiliar = auxiliar.nodoDerecho;
				hijoHisquierdo = false;
			}

			if (auxiliar == null)
				return false;

		} // fin while

		if (auxiliar.nodoIzquierdo == null && auxiliar.nodoDerecho == null) {
			if (auxiliar == raiz) {
				raiz = null;
			} else if (hijoHisquierdo) {
				padre.nodoIzquierdo = null;
			} else {
				padre.nodoDerecho = null;
			}
		} else if (auxiliar.nodoDerecho == null) {
			if (auxiliar == raiz) {
				raiz = auxiliar.nodoIzquierdo;
			} else if (hijoHisquierdo) {
				padre.nodoIzquierdo = auxiliar.nodoIzquierdo;
			} else {
				padre.nodoDerecho = auxiliar.nodoIzquierdo;
			}
		} else if (auxiliar.nodoIzquierdo == null) {
			if (auxiliar == raiz) {
				raiz = auxiliar.nodoDerecho;
			} else if (hijoHisquierdo) {
				padre.nodoIzquierdo = auxiliar.nodoDerecho;
			} else {
				padre.nodoDerecho = auxiliar.nodoIzquierdo;
			}
		} else {

			NodoArbol reemplazo = obtenerNodoRemplazo(auxiliar);
			if (auxiliar == raiz) {
				raiz = reemplazo;
			} else if (hijoHisquierdo) {
				padre.nodoIzquierdo = reemplazo;
			} else {
				padre.nodoDerecho = reemplazo;
			}

			reemplazo.nodoIzquierdo = auxiliar.nodoIzquierdo;

		}

		return true;
	}/* Metodo nodo reeplazo */

	public NodoArbol obtenerNodoRemplazo(NodoArbol nodoReemplazo) {
		NodoArbol reemplazarPadre = nodoReemplazo;
		NodoArbol reeplazo = nodoReemplazo;
		NodoArbol auxiliar = nodoReemplazo.nodoDerecho;

		while (auxiliar != null) {
			reemplazarPadre = reeplazo;
			reeplazo = auxiliar;
			auxiliar = auxiliar.nodoIzquierdo;
		}

		if (reeplazo != nodoReemplazo.nodoDerecho) {
			reemplazarPadre.nodoIzquierdo = reeplazo.nodoDerecho;
			reeplazo.nodoDerecho = nodoReemplazo.nodoDerecho;
		}

		return reeplazo;

	}

	/* Metodo eliminar 2 */

	/*
	 * public void eliminar(int valor) throws Exception { raiz = eliminar(raiz,
	 * valor); }
	 * 
	 * // método interno para realizar la operación protected NodoArbol
	 * eliminar(NodoArbol raizSub, int dato) throws Exception { if (raizSub == null)
	 * throw new Exception("No encontrado el nodo con la clave"); else if (dato <
	 * raizSub.dato) { NodoArbol iz; iz = eliminar(raizSub.nodoIzquierdo, dato);
	 * raizSub.nodoIzquierdo = iz; } else if (dato < raizSub.dato) { NodoArbol dr;
	 * dr = eliminar(raizSub.nodoDerecho, dato); raizSub.nodoDerecho = dr; } else //
	 * Nodo encontrado { NodoArbol q;
	 * 
	 * q = raizSub; // nodo a quitar del árbol if (q.nodoIzquierdo == null) raizSub
	 * = q.nodoDerecho; else if (q.nodoDerecho == null) raizSub = q.nodoIzquierdo;
	 * else { // tiene rama izquierda y derecha q = reemplazar(q); } q = null; }
	 * return raizSub; }
	 * 
	 * // método interno para susutituir por el mayor de los menores private
	 * NodoArbol reemplazar(NodoArbol act) { NodoArbol a, p; p = act; a =
	 * act.nodoIzquierdo; // rama de nodos menores while (a.nodoDerecho != null) { p
	 * = a; a = a.nodoDerecho; } act.nuevoValor(a.valorNodo()); if (p == act)
	 * p.nodoIzquierdo = a.nodoIzquierdo; else p.nodoDerecho = a.nodoIzquierdo;
	 * return a; }
	 */

	public boolean eliminarNodo(int dato) {
		NodoArbol auxiliar = raiz;
		NodoArbol padre = raiz;
		boolean esSubArbolIzq = true;

		// recorrido del arbol para encontrar elemento
		while (auxiliar.dato != dato) {
			padre = auxiliar;
			if (dato > auxiliar.dato) {
				esSubArbolIzq = true;
				auxiliar = auxiliar.nodoDerecho;
			} else {
				esSubArbolIzq = false;
				auxiliar = auxiliar.nodoIzquierdo;
			}

			if (auxiliar == null)
				return false;

		}

		if (auxiliar.nodoDerecho == null && auxiliar.nodoIzquierdo == null) {
			if (auxiliar == raiz) {
				raiz = null;
			} else if (esSubArbolIzq) {
				padre.nodoIzquierdo = null;
			} else {
				padre.nodoDerecho = null;
			}
		} else if (auxiliar.nodoDerecho == null) {
			if (auxiliar == raiz) {
				raiz = auxiliar.nodoIzquierdo;
			} else if (esSubArbolIzq) {
				padre.nodoIzquierdo = auxiliar.nodoIzquierdo;
			} else {
				padre.nodoDerecho = auxiliar.nodoIzquierdo;
			}
		} else if (auxiliar.nodoIzquierdo == null) {
			if (auxiliar == raiz) {
				raiz = auxiliar.nodoDerecho;
			} else if (esSubArbolIzq) {
				padre.nodoIzquierdo = auxiliar.nodoDerecho;
			} else {
				padre.nodoDerecho = auxiliar.nodoIzquierdo;
			}
		} else {
			NodoArbol nodoReempazo = reemplazar(auxiliar);
			if (auxiliar == raiz) {
				raiz = nodoReempazo;
			} else if (esSubArbolIzq) {
				padre.nodoIzquierdo = nodoReempazo;
			} else {
				padre.nodoDerecho = nodoReempazo;
				nodoReempazo.nodoIzquierdo = auxiliar.nodoIzquierdo;
			}

		}

		return true;
	}// elimnar nodo

	public NodoArbol reemplazar(NodoArbol nodo) {
		NodoArbol reeplazoPadre = nodo;
		NodoArbol reemplazo = nodo;
		NodoArbol auxiliar = nodo.nodoDerecho;

		while (auxiliar != null) {
			reeplazoPadre = reemplazo;
			reemplazo = auxiliar;
			auxiliar = auxiliar.nodoIzquierdo;
		}

		if (reemplazo != nodo.nodoDerecho) {
			reeplazoPadre.nodoIzquierdo = reemplazo.nodoDerecho;
			reemplazo.nodoDerecho = nodo.nodoDerecho;
		}

		return reemplazo;
	}

	/* Fin de metodo eliminar 2 */

	/* altura del arbol */

	int altura; // variable de instancia

	public int mostrarAltura() {
		altura = 0;
		mostrarAltura(raiz, 0);
		return altura + 1;
	}

	private void mostrarAltura(NodoArbol auxiliar, int nivel) {

		if (auxiliar != null) {
			mostrarAltura(auxiliar.nodoIzquierdo, nivel + 1);
			mostrarAltura(auxiliar.nodoDerecho, nivel + 1);
			if (nivel > altura) {
				altura = nivel;
			}
		}
	}
}
