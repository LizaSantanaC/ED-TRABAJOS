import java.awt.SystemColor;
import java.util.Scanner;

public class CadenaCaracteres {

	// Variable
	private String cadena;

	// Constructores
	public CadenaCaracteres() {

	}

	public CadenaCaracteres(String cadena) {
		super();
		this.cadena = cadena;
	}

	// Get and set
	public String getCadena() {
		return cadena;
	}

	public void setCadena(String cadena) {
		this.cadena = cadena;
	}

	// Invertir cadena
	public String invertir(String frase) {
		setCadena(frase);
		String cadenaReves = "";

		for (int i = getCadena().length() - 1; i >= 0; i--) {
			cadenaReves = cadenaReves + getCadena().charAt(i);
		}
		return cadenaReves;
	}

	// Agregar caracteres
	public String agregarCaracter(String frase, String caracter) {
		setCadena(frase);
		String cadenaCaracter = "";
		cadenaCaracter = getCadena() + caracter;
		return cadenaCaracter;
	}

	// Eliminar caracters
	public String borrarCaracter(String frase, String caracter) {
		String cadenaEliminar = "";
		cadenaEliminar = frase.replace(caracter, "");
		return cadenaEliminar;
	}

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		System.out.println("\t\t\t\t\t\t-------CADENAS-------\n");
		System.out.println("Ingrese una frase: ");
		String frase = entrada.nextLine();
		System.out.println("\n1) Invertir frase");
		System.out.println("2) Agregar Caracter");
		System.out.println("3) Borrar Caracter");
		System.out.println("Ingresa una opción:");
		int opc = entrada.nextInt();

		CadenaCaracteres cadena = new CadenaCaracteres();

		switch (opc) {
		case 1:
			System.out.println("\t-------INVERTIR CADENA-------\n");
			System.out.println(cadena.invertir(frase));
			break;

		case 2:
			System.out.println("\t-------AGREGAR CARACTER-------\n");
			System.out.println("Ingrese el caracter que desea agregar: ");
			String caracter = entrada.next();
			System.out.println(cadena.agregarCaracter(frase, caracter));
			break;

		case 3:
			System.out.println("\t-------BORRAR CARACTER-------\n");
			System.out.println("Ingrese el caracter que desea eliminar: ");
			caracter = entrada.next();
			System.out.println(cadena.borrarCaracter(frase, caracter));
			break;

		default:
			System.out.println("OPCIÓN INCORRECTA!");
			break;
		}
	}
}