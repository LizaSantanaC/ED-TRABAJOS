import java.util.Scanner;

public class PruebaArbolBinario {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		ArbolBinario arbolBinario = new ArbolBinario();

		arbolBinario.insertarNodo(8);
		arbolBinario.insertarNodo(15);
		arbolBinario.insertarNodo(9);
		arbolBinario.insertarNodo(7);
		arbolBinario.insertarNodo(21);
		arbolBinario.insertarNodo(2);
		arbolBinario.insertarNodo(34);
		arbolBinario.insertarNodo(8);
		String opc1;
		int opc = -1;

		do {
			System.out.println("Elige un opcion:");
			System.out.println("0) Crear arbol");
			System.out.println("1) Insertar nodo");
			System.out.println("2) Recorrido en Preorden");
			System.out.println("3) Recorrido en Inorden");
			System.out.println("4) Recorrido en Posorden");
			System.out.println("5) Eliminar nodo");
			System.out.println("6) Buscar un dato");
			System.out.println("7) Mostrar cantidad nodos");
			System.out.println("8) Mostrar dato mayor ");
			System.out.println("9) Mostrar dato menor ");
			System.out.println("10) Mostrar dato menor ");

			System.out.println("11) SALIR");
			opc = entrada.nextInt();

			// opc=Integer.parseInt(opc1);

			switch (opc) {

			case 0:
				arbolBinario = new ArbolBinario();
				break;

			case 1:
				System.out.println("Ingresa dato:");
				String numero = entrada.next();
				int n = Integer.parseInt(numero);
				arbolBinario.insertarNodo(n);
				break;

			case 2:
				arbolBinario.recorridoPreorden(arbolBinario.raiz);
				System.out.println();
				break;

			case 3:
				arbolBinario.recorridoInOrden(arbolBinario.raiz);
				System.out.println();
				break;

			case 4:
				arbolBinario.recorridoPosorden(arbolBinario.raiz);
				System.out.println();
				break;

			case 5:
				System.out.println("Ingresa nodo a eliminar:");
				int nodoEliminar = entrada.nextInt();
				System.out.println((arbolBinario.borrarNodo(nodoEliminar) == true) ? "Nodo eliminado con exito"
						: "Nodo no encontrado");
				break;

			case 6:
				System.out.println("Ingresa dato a buscar:");
				int nu = entrada.nextInt();
				if (arbolBinario.buscarDato(nu)) {
					System.out.println("Dato encontrado");
				} else {
					System.out.println("Dato no encontrado");
				}
				break;

			case 7:
				System.out.println("Cantidad de nodos: " + arbolBinario.cantidadNodos(arbolBinario.raiz));
				arbolBinario.numNodos = 0;
				break;

			case 8:
				arbolBinario.buscarDatoMayor();
				break;

			case 9:
				System.out.println("Nodo menor: "
						+ (arbolBinario.buscarDatoMenor(arbolBinario.raiz) == null ? "El arbol esta vacio"
								: arbolBinario.buscarDatoMenor(arbolBinario.raiz).dato));
				break;

			case 10:
				System.out.println("Altura: " + arbolBinario.mostrarAltura());
				break;

			case 11:
				System.out.println("Saliendo...");
				break;
			default:
				System.out.println("Opcion incorrecta");
				break;
			}

		} while (opc != 11);
	}
}
