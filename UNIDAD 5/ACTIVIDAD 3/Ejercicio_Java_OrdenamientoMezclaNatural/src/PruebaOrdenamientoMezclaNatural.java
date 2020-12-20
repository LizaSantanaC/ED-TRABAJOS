import java.util.Arrays;

class OrdenamientoMezclaNatural {

	// Mezcla directa 1
	public int[] ordenamientoMezclaDirecta1(int arreglo[]) {
		int i, j, k;
		if (arreglo.length > 1) {
			int numElementoIzq = arreglo.length / 2;
			int numElementoDer = arreglo.length - numElementoIzq;

			int arregloIzquierda[] = new int[numElementoIzq];
			int arregloDerecha[] = new int[numElementoDer];

			for (i = 0; i < numElementoIzq; i++) {
				arregloIzquierda[i] = arreglo[i];
			}

			for (i = numElementoIzq; i < numElementoIzq + numElementoDer; i++) {
				arregloDerecha[i - numElementoIzq] = arreglo[i];
			}

			// Recursividad
			arregloIzquierda = ordenamientoMezclaDirecta1(arregloIzquierda);
			arregloDerecha = ordenamientoMezclaDirecta1(arregloDerecha);
			i = j = k = 0;
			while (arregloIzquierda.length != j && arregloDerecha.length != k) {
				if (arregloIzquierda[j] < arregloDerecha[k]) {
					arreglo[i] = arregloIzquierda[j];
					i++;
					j++;
				} else {
					arreglo[i] = arregloDerecha[k];
					i++;
					k++;
				}
			}
			while (arregloIzquierda.length != j) {
				arreglo[i] = arregloIzquierda[j];
				i++;
				j++;
			}
			while (arregloDerecha.length != k) {
				arreglo[i] = arregloDerecha[k];
				i++;
				k++;
			}
		}
		return arreglo;
	}

	// Mezcla directa 2
	public void ordenamientoMezclaDirecta2(int arreglo[]) {
		int i, j, k;
		if (arreglo.length > 1) {
			int nElementosIzquierda = arreglo.length / 2;
			int nElementosDerecha = arreglo.length - nElementosIzquierda;
			int vectorI[] = new int[nElementosIzquierda];
			int vectorD[] = new int[nElementosDerecha];

			for (i = 0; i < nElementosIzquierda; i++) {
				vectorI[i] = arreglo[i];
			}

			for (i = nElementosIzquierda; i < nElementosIzquierda + nElementosDerecha; i++) {
				vectorD[i - nElementosIzquierda] = arreglo[i];
			}
			vectorI = ordenamientoMezclaDirecta1(vectorI);
			vectorD = ordenamientoMezclaDirecta1(vectorD);
			i = 0;
			j = 0;
			k = 0;
			while (vectorI.length != j && vectorD.length != k) {
				if (vectorI[j] < vectorD[k]) {
					arreglo[i] = vectorI[j];
					i++;
					j++;
				} else {
					arreglo[i] = vectorD[k];
					i++;
					k++;
				} // Else
			} // While

			while (vectorI.length != j) {
				arreglo[i] = vectorI[j];
				i++;
				j++;
			}
			while (vectorD.length != k) {
				arreglo[i] = vectorD[k];
				i++;
				k++;
			}
		}
	}

	// Mezcla Natural
	public void mezclaNatural(int[] numeros) {
		int izquierda = 0;
		int izq = 0;
		int derecha = numeros.length - 1;
		int der = derecha;
		boolean ordenado = false;
		do {
			ordenado = true;
			izquierda = 0;
			while (izquierda < derecha) {
				izq = izquierda;
				while (izq < derecha && numeros[izq] <= numeros[izq + 1]) {
					izq++;
				}
				der = izq + 1;
				while (der == derecha - 1 || der < derecha && numeros[der] <= numeros[der + 1]) {
					der++;
				}
				if (der <= derecha) {
					ordenamientoMezclaDirecta2(numeros);
					ordenado = false;
				}
				izquierda = izq;
			}
		} while (!ordenado);
	}
}

public class PruebaOrdenamientoMezclaNatural {
	public static void main(String[] args) {
		OrdenamientoMezclaNatural mezclaNatural = new OrdenamientoMezclaNatural();
		int[] numeros = { 40, 52, 6, 78, 63, 12, 13, 10, 47, 68, 40, 2, 1, 3, 64 };
		System.out.println("Numeros desordenados: " + Arrays.toString(numeros));
		mezclaNatural.mezclaNatural(numeros);
		System.out.println("Numeros ordenados: " + Arrays.toString(numeros));
	}
}
