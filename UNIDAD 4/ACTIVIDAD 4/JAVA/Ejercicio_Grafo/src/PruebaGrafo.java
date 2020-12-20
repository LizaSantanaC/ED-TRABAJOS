/* AUTOR DE CÓDIGO: Luis Joyanes Aguilar */

import java.util.Scanner;

public class PruebaGrafo {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		String opc1 = "0";
		int opc = 0;

		System.out.println("Ingresa el numero maximo de vertices:");
		String x = entrada.nextLine();
		int maxVertices = Integer.parseInt(x);
		GrafoMatrizAdyacencia grafo = new GrafoMatrizAdyacencia(5);

		do {
			System.out.println("Elige un opcion:");
			System.out.println("1) Añadir un vertice");
			System.out.println("2) Añadir un arco");
			System.out.println("3) Determinar si son adyacente dos vertices");
			System.out.println("4) Cantidad de vertices");
			System.out.println("5) Posicion de un vertice");
			System.out.println("6) Salir");
			opc1 = entrada.nextLine();
			opc = Integer.parseInt(opc1);

			switch (opc) {
			case 1:
				System.out.println("Ingresa el nombre del vertice:");
				String nom = entrada.nextLine();
				grafo.nuevoVertice(nom);
				break;

			case 2:
				System.out.println("Ingresa el nombre del primer vertice:");
				String nom1 = entrada.nextLine();
				System.out.println("Ingresa el nombre del segundo vertice:");
				String nom2 = entrada.nextLine();
				try {
					grafo.nuevoArco(nom1, nom2);
					System.out.println("Arco agregado con exito");
				} catch (Exception e) {
					System.out.println("Oops algo salio mal :( "
							+ e.getMessage());

				}

				break;

			case 3:
				System.out.println("Ingresa el nombre del primer vertice:");
				nom1 = entrada.nextLine();
				System.out.println("Ingresa el nombre del segundo vertice:");
				nom2 = entrada.nextLine();
				try {
					
					System.out.println(grafo.adyacente(nom1, nom2) == true ? "Son adyasentes":"No son adyacentes");
				} catch (Exception e) {
					System.out.println(e.getMessage());

				}
				break;

			case 4:
				System.out.println("Numero de vertices:" + grafo.numVerts);
				break;

			case 5:
				System.out.println("Ingresa nombre del vertice:");
				nom = entrada.nextLine();
				System.out.println("El numero del vertice es:"
						+ grafo.numVertice(nom));
				break;

			default:
				break;
			}
			System.out.println("=========================");

		} while (opc != 6);

	}

}
