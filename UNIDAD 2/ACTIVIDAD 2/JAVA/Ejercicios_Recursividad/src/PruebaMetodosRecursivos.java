import java.util.Scanner;

class NumerosDivisores {

	private int n = 0;
	// Metodo Iterativo
	public void divisoresIterativos(int n) {
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				System.out.print(i + ", ");
			}
		}
	}
	
	// Clase Numeros Divisores
	// Metodo Recursivo
	public void divisoresRecursivo(int a, int n) {
		if (a > 0) {
			if (n % a == 0) {
				System.out.print(a + ", ");
			}
			divisoresRecursivo((a - 1), n);
		}
	}
}

class NumeroFactorial {
	// Metodo Iterativo
	public long factorialIterativo(long t) {
		long factorial = 1;

		for (long i = t; i > 1; i--) {
			factorial = factorial * (i);
		}
		return factorial;
	}
	
	// Metodo Recursivo
	public long factorialRecursivo(long factorial, long t) {
		if (t > 1) {
			factorial = factorialRecursivo(factorial, (t - 1)) * (t);
		}
		return factorial;
	}
}

class CocientesEnteros {
	// Metodo Iterativo
	public void cocientesEnterosIterativo(int dividendo, int divisor) {
		while (dividendo % divisor == 0) {
			System.out.print(dividendo / divisor + ", ");
			dividendo = (dividendo / divisor);
		}
	}

	// Metodo Recursivo
	public void cocientesEnterosRecursivo(int dividendo, int divisor) {

		if (dividendo % divisor == 0) {
			System.out.print(dividendo / divisor + ", ");
			cocientesEnterosRecursivo((dividendo / divisor), divisor);
		}
	}
}

class DivisoresEnteros {
	// Metodo Iterativo
	public int divisoresEnterosIterativo(int dividendo, int divisor) {
		int a = 0;
		while ((dividendo % divisor) == 0) {
			a++;
			dividendo = (dividendo / divisor);
		}
		return a;
	}

	// Metodo Recursivod
	public int divisoresEnterosRecursivo(int dividendo, int divisor) {
		int r = 0;
		if ((dividendo % divisor) == 0) {
			r++;
			r += divisoresEnterosRecursivo((dividendo / divisor), divisor);
		}
		return r;
	}
}

class Conversion {
	// Metodo Iterativo
	public void conversionIterativo(int n) {
		int exp = 0, digito;
		double binario = 0;
		while (n != 0) {
			digito = n % 2;
			binario = binario + digito * Math.pow(10, exp);
			exp++;
			n = n / 2;
		}
		System.out.printf("%.0f %n", binario);
	}
	
	// Metodo Recursivo
	public void conversionRecursivo(int n) {
		int exp = 0, digito;
		double binario = 0;
		if (n != 0) {
			digito = n % 2;
			binario = digito * Math.pow(10, exp);
			exp++;
			conversionRecursivo((n / 2));
		}
		System.out.printf("%.0f %n", binario);
	}
}

class Vocales {
	// Metodo Iterativo
	public void vocalesIterativo(String frase) {
		int a = 0;
		for (int i = 0; i < frase.length(); i++) {
			if (frase.substring(i, (i + 1)).equalsIgnoreCase("a") || frase.substring(i, (i + 1)).equalsIgnoreCase("e")
					|| frase.substring(i, (i + 1)).equalsIgnoreCase("i")
					|| frase.substring(i, (i + 1)).equalsIgnoreCase("o")
					|| frase.substring(i, (i + 1)).equalsIgnoreCase("u")) {
				a++;
			}
		}
		System.out.println("Tiene " + a + " vocales");
	}

	// Metodo Recursivo
	public int vocalesRecursivo(int a, String frase) {
		int b = 0;
		if (a > 0) {
			if (frase.substring((a - 1), a).equalsIgnoreCase("a") || frase.substring((a - 1), a).equalsIgnoreCase("e")
					|| frase.substring((a - 1), a).equalsIgnoreCase("i")
					|| frase.substring((a - 1), a).equalsIgnoreCase("o")
					|| frase.substring((a - 1), a).equalsIgnoreCase("u")) {
				b++;
			}
			b += vocalesRecursivo((a - 1), frase);
		}
		return b;
	}
}

class Menu {

	Scanner d = new Scanner(System.in);
	NumerosDivisores nd = new NumerosDivisores();
	NumeroFactorial nf = new NumeroFactorial();
	CocientesEnteros ce = new CocientesEnteros();
	DivisoresEnteros de = new DivisoresEnteros();
	Conversion c = new Conversion();
	Vocales v = new Vocales();

	public void numerosDivisores() {
		System.out.println("\nNUMEROS DIVISORES");
		System.out.println("Ingrese un número: ");
		int n = d.nextInt();
		System.out.println("\n\tMetodo Iterativo: ");
		nd.divisoresIterativos(n);
		System.out.println("\n\tMetodo Recursivo: ");
		nd.divisoresRecursivo(n, n);
	}

	public void numeroFactorial() {
		System.out.println("\nNUMERO FACTORIAL");
		System.out.println("Ingrese un número: ");
		int n = d.nextInt();
		System.out.println("\n\tMetodo Iterativo: ");
		System.out.println(nf.factorialIterativo(n));
		System.out.println("\n\tMetodo Recursivo: ");
		System.out.println(nf.factorialRecursivo(1, n));
	}

	public void cocientesEnteros() {
		System.out.println("\nCOCIENTES ENTEROS ENTRE DOS NUMEROS");
		System.out.println("Ingrese el numero de divisor: ");
		int divisor = d.nextInt();
		System.out.println("Ingrese el numero del dividendo: ");
		int dividendo = d.nextInt();
		System.out.println("\n\tMetodo Iterativo: ");
		ce.cocientesEnterosIterativo(dividendo, divisor);
		System.out.println("\n\tMetodo Recursivo: ");
		ce.cocientesEnterosRecursivo(dividendo, divisor);
	}

	public void divisoresEnteros() {
		System.out.println("\nDIVISORES ENTEROS ENTRE DOS NUMEROS");
		System.out.println("Ingrese el numero de divisor: ");
		int divisor = d.nextInt();
		System.out.println("Ingrese el numero del dividendo: ");
		int dividendo = d.nextInt();
		System.out.println("\nMetodo Iterativo: ");
		System.out.println(de.divisoresEnterosIterativo(dividendo, divisor));
		System.out.println("\nMetodo Recursivo: ");
		System.out.println(de.divisoresEnterosRecursivo(dividendo, divisor));
	}

	public void conversion() {
		System.out.println("\nCONVERSION DE NUMERO DECIMAL A SISTEMA BINARIO");
		System.out.println("Ingrese un numero: ");
		int n = d.nextInt();
		System.out.println("\nMetodo Iterativo: ");
		c.conversionIterativo(n);
		System.out.println("\nMetodo Recursivo: ");
		c.conversionRecursivo(n);
	}

	public void vocales() {
		System.out.println("\nCANTIDAD DE VOCALES");
		System.out.println("Ingrese una palabra o frase: ");
		String frase = d.next();
		System.out.println("\nMetodo Iterativo: ");
		v.vocalesIterativo(frase);
		System.out.println("\nMetodo Recursivo: ");
		System.out.println("Tiene " + v.vocalesRecursivo(frase.length(), frase) + " vocales");
	}

	public void menu() {
		System.out.println("\n1) Numeros Divisores");
		System.out.println("2) Numero Factorial");
		System.out.println("3) Cocientes Enteros Entre Dos Numeros");
		System.out.println("4) Divisores Enteros Entre Dos Numeros");
		System.out.println("5) Conversion De Numero Decimal A Sistema Binario");
		System.out.println("6) Cantidad De Vocales");
		System.out.println("7) Salir");
		System.out.println("Ingrese el numero de la opcion a elegir: ");
		int opc = d.nextInt();

		switch (opc) {
		case 1:
			numerosDivisores();
			menu();
			break;

		case 2:
			numeroFactorial();
			menu();
			break;

		case 3:
			cocientesEnteros();
			menu();
			break;

		case 4:
			divisoresEnteros();
			menu();
			break;

		case 5:
			conversion();
			menu();
			break;

		case 6:
			vocales();
			menu();
			break;

		case 7:
			System.out.println("------------------------");
			break;

		default:
			System.out.println("Opcion Incorrecta");
			menu();
			break;
		}
	}
}

public class PruebaMetodosRecursivos {
	public static void main(String[] args) {
		Menu m = new Menu();
		System.out.println("\n\t\t------------------------METODOS ITERATIVOS Y RECURSIVOS------------------------\n");
		m.menu();
	}
}