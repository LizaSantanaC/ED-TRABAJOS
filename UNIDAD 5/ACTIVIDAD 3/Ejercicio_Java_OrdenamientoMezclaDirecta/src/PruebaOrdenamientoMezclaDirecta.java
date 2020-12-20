import java.util.Arrays;

class OrdenamientoMezclaDirecta{
	public int[] ordenamientoMezcla(int arreglo[]) {
		int i, j, k;
		if(arreglo.length > 1) {
			int numElementoIzq= arreglo.length/2;
			int numElementoDer= arreglo.length - numElementoIzq;
			
			int arregloIzquierda[]= new int[numElementoIzq];
			int arregloDerecha[]= new int[numElementoDer];
			
			for(i=0; i < numElementoIzq; i++) {
				arregloIzquierda[i]= arreglo[i];
			}
			
			for(i= numElementoIzq; i < numElementoIzq + numElementoDer; i++) {
				arregloDerecha[i - numElementoIzq]= arreglo[i];
			}
			
			//Recursividad
			arregloIzquierda= ordenamientoMezcla(arregloIzquierda);
			arregloDerecha= ordenamientoMezcla(arregloDerecha);
			i=j=k=0;
			while (arregloIzquierda.length != j && arregloDerecha.length != k) {
				if(arregloIzquierda[j] < arregloDerecha[k]) {
					arreglo[i]= arregloIzquierda[j];
					i++;
					j++;
				}else {
					arreglo[i]= arregloDerecha[k];
					i++;
					k++;
				}	
			}
			while (arregloIzquierda.length != j) {
				arreglo[i]= arregloIzquierda[j];
				i++;
				j++;
			}
			while (arregloDerecha.length != k) {
				arreglo[i]= arregloDerecha[k];
				i++;
				k++;
			}
		}
		return arreglo;
	}
}
public class PruebaOrdenamientoMezclaDirecta {
	public static void main(String[] args) {
		OrdenamientoMezclaDirecta ordenamientoM= new OrdenamientoMezclaDirecta();
		int vector[]= {8, 45, 1, 5, 6, 78, 3, 15, 14, 10};
		System.out.println("Arreglo original: " + Arrays.toString(vector));
		int vector2[]= ordenamientoM.ordenamientoMezcla(vector);		
		System.out.println("Arreglo ordenado: " + Arrays.toString(vector2));
	}
}
