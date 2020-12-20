import java.util.Scanner;

class Conjuntos {

	// Variables
	// Numeros Primos
	private int conjuntoA[] = new int[30];
	// Numeros Divisores
	private int conjuntoB[] = new int[30];
	// Conjunto
	private int conjunto[] = new int[30];

	// Constructores
	public Conjuntos() {

	}

	public Conjuntos(int[] conjuntoA, int[] conjuntoB, int[] conjunto) {
		super();
		this.conjuntoA = conjuntoA;
		this.conjuntoB = conjuntoB;
		this.conjunto = conjunto;
	}

	// Getters and setters
	public int[] getConjuntoA() {
		return conjuntoA;
	}

	public int[] getConjuntoB() {
		return conjuntoB;
	}

	public int[] getConjunto() {
		return conjunto;
	}

	public void setConjuntoA(int[] conjuntoA) {
		this.conjuntoA = conjuntoA;
	}

	public void setConjuntoB(int[] conjuntoB) {
		this.conjuntoB = conjuntoB;
	}

	public void setConjunto(int[] conjunto) {
		this.conjunto = conjunto;
	}

	// Metodo Union De Conjuntos
	public void unionConjuntos() {
		int a = 0;
		for (int i = 0; i < 6; i++) {
			if (repeticion(conjuntoA[i]) == true) {
				conjunto[a] = conjuntoA[i];
				a++;
			}
			if (repeticion(conjuntoB[i]) == true) {
				conjunto[a] = conjuntoB[i];
				a++;
			}
		}
		for (int i = 0; i < conjunto.length; i++) {
			if (conjunto[i] != 0)
				System.out.print(conjunto[i] + ",");
		}
	}

	// Metodo Interseccion De Conjuntos
	public void interseccionConjuntos() {
		int a = 0;
		for (int i = 0; i < conjuntoA.length; i++) {
			for (int j = 0; j < conjuntoA.length; j++) {
				if ((conjuntoB[j] != 0) && (conjuntoA[i] == conjuntoB[j])) {
					conjunto[a] = conjuntoA[i];
					a++;
				}
			}
		}
		for (int i = 0; i < conjuntoA.length; i++) {
			for (int j = 0; j < conjuntoA.length; j++) {
				if ((conjuntoB[i] == conjuntoA[j]) && (repeticion(conjuntoB[i]) == true)) {
					conjunto[a] = conjuntoB[i];
					a++;
				}
			}
		}
		for (int i = 0; i < conjunto.length; i++) {
			if (conjunto[i] != 0)
				System.out.print(conjunto[i] + ", ");
		}
	}

	// Metodo Diferencia De Conjuntos
	public void diferenciaConjuntos() {
		int a = 0;
		int b = 0;
		for (int i = 0; i < conjuntoA.length; i++) {
			b = 0;
			for (int j = 0; j < conjuntoA.length; j++) {
				if (conjuntoA[i] == conjuntoB[j]) {
					b++;
				}
			}
			if ((b == 0) && (repeticion(conjuntoA[i]) == true)) {
				conjunto[a] = conjuntoA[i];
				a++;
			}
		}
		for (int i = 0; i < conjuntoB.length; i++) {
			b = 0;
			for (int j = 0; j < conjuntoB.length; j++) {
				if (conjuntoB[i] == conjuntoA[j]) {
					b++;
				}
			}
			if ((b == 0) && (repeticion(conjuntoB[i]) == true)) {
				conjunto[a] = conjuntoB[i];
				a++;
			}
		}
		for (int i = 0; i < conjunto.length; i++) {
			if (conjunto[i] != 0)
				System.out.print(", " + conjunto[i]);
		}
	}

	// Metodo Repeticion
	public boolean repeticion(int evaluar) {
		for (int i = 0; i < conjunto.length; i++) {
			if (conjunto[i] == evaluar)
				return false;
		}
		return true;
	}

	// Metodo Numeros Primos
	public void numerosPrimos() {
		System.out.println("Conjunto");
		System.out.println("\tPrimos");
		int a = 0;
		for (int i = 1; i <= (100 - 1 + 1); i++) {
			int divisores = 0;
			int numActual = 0;
			for (int e = 1; e <= i; e++) {
				numActual = e;

				if ((i % e) == 0)
					divisores++;
				if (divisores == 2) {
					break;
				}
			}

			if ((numActual == i) && (i != 1)) {
				System.out.print(i + ", ");
				conjuntoA[a] = i;
				a++;
			}
		}
	}

	//// Metodo Numeros Divisores
	public void numerosDivisores() {
		System.out.println("\nConjunto");
		System.out.println("\tDivisores");
		int a = 0;

		for (int i = 1; i < 351; i++) {
			if ((350 % i) == 0) {
				System.out.print(i + ", ");
				conjuntoB[a] = i;
				a++;
			}
		}
	}
}

public class PruebaConjuntos {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		Conjuntos conjunto = new Conjuntos();
		int e = 0;
		// Menu
		boolean salir = false;
		e = 0;
		
		do {
			System.out.println("\n\t\t-----------------------CONJUNTOS-----------------------\n");
			System.out.println();
			conjunto.numerosPrimos();
			System.out.println("");
			conjunto.numerosDivisores();
			System.out.println("");

			System.out.println("\n1) Union de Conjuntos");
			System.out.println("2) Intersección de Conjuntos");
			System.out.println("3) Diferencia de Conjuntos");
			System.out.println("4) Salir");
			System.out.println();
			System.out.print("Ingrese el número de la opción a elegir: ");
			System.out.println();
			int opc = entrada.nextInt();
			
			switch (opc) {
			case 1:
				System.out.println("\t---------------UNION DE CONJUNTOS---------------\n");
				conjunto.unionConjuntos();
				break;

			case 2:
				System.out.println("\t---------------INTERSECCIÓN DE CONJUNTOS---------------\n");
				conjunto.interseccionConjuntos();
				break;

			case 3:
				System.out.println("\t---------------DIFERENCIA DE CONJUNTOS---------------\n");
				conjunto.diferenciaConjuntos();
				break;

			case 4:
				salir = true;
				break;

			default:
				break;
			}
		} while (!salir);
		System.out.println("------------------------------------------------------------");
	}
}
