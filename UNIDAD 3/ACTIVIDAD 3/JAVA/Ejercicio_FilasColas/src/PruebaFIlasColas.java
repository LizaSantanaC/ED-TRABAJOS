import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Impresion {

	private String identificadorImpresion;
	private int tamañoArchivo;
	private int cantidadHojas = 10;

	// COSNTRUCTOR
	public Impresion() {
	}

	public Impresion(String identificadorImpresion, int tamañoArchivo, int cantidadHojas) {
		super();
		this.identificadorImpresion = identificadorImpresion;
		this.tamañoArchivo = tamañoArchivo;
		this.cantidadHojas = cantidadHojas;
	}

	// GETTERS Y SETTERS
	public String isIdentificadorImpresion() {
		return identificadorImpresion;
	}

	public int getTamañoArchivo() {
		return tamañoArchivo;
	}

	public int getCantidadHojas() {
		return cantidadHojas;
	}

	public void setIdentificadorImpresion(String identificadorImpresion) {
		this.identificadorImpresion = identificadorImpresion;
	}

	public void setTamañoArchivo(int tamañoArchivo) {
		this.tamañoArchivo = tamañoArchivo;
	}

	public void setCantidadHojas(int cantidadHojas) {
		this.cantidadHojas = cantidadHojas;
	}

	// MÉTODO ToString
	@Override
	public String toString() {
		return "Impresion\nIdentificador Impresion: " + identificadorImpresion + "\nTamaño de Archivo:" + tamañoArchivo
				+ "\nCantidad Hojas de Impresión: " + cantidadHojas;
	}

}

interface RegistroImpresiones {

	public abstract void insertar(Impresion i);

	public abstract void extraer();

	public abstract void eliminar();

	public abstract boolean filaLlena();

	public abstract boolean filaVacia();

	public abstract void totalImpresiones();

	public abstract void tamañoBytes();

}

class ImplementacionFilaEstatica implements RegistroImpresiones {

	int max;
	int frente;
	int fin;
	private Impresion[] fila;

	public void insertar(Impresion i) {

		if (filaLlena()) {
			System.out.println("La fila esta llena");
		} else {

			fin++;
			fila[fin] = i;
		}
	}

	public void extraer() {

		if (filaLlena()) {
			System.out.println("La fila esta llena");
		} else {
			for (int i = 0; i <= fin - 1; i++) {
				fila[i] = fila[i + 1];
			}
			fin--;
		}
	}

	public void eliminar() {

	}

	public boolean filaLlena() {

		if (frente == max) {
			return true;
		} else {
			return false;
		}
	}

	public boolean filaVacia() {

		if (frente == fin) {
			return true;
		} else {
			return false;
		}
	}

	public void totalImpresiones() {

		if (filaVacia()) {
			System.out.println("La fila esta vacia");
		} else {
			String a = "";
			for (int i = frente + 1; i <= fin; i++) {
				a = a + fila[i] + "\n";
			}
			System.out.println("Total de impresiones: " + fin);
		}
	}

	public void tamañoBytes() {

	}

}
class ImplementacionFilaDinamica implements RegistroImpresiones {

	Queue<Impresion> filaImpresiones = new LinkedList<Impresion>();

	public void insertar(Impresion i) {

		int a = 0;
		int b = 0;
		filaImpresiones.add(i);
		a += i.getCantidadHojas();
		b = i.getTamañoArchivo();

		System.out.println("Total de Hojas: " + a);
		System.out.println("tamaño de archivo en bytes: " + b);
	}

	public void extraer() {
		filaImpresiones.remove();
	}

	public void eliminar() {

	}

	public boolean filaLlena() {
		return false;
	}

	public boolean filaVacia() {
		return false;
	}

	public void totalImpresiones() {

		System.out.println(filaImpresiones.size());
	}

	public void tamañoBytes() {

	}

}

class Menu {

	Scanner d = new Scanner(System.in);
	ImplementacionFilaEstatica ife = new ImplementacionFilaEstatica();
	ImplementacionFilaDinamica ifd = new ImplementacionFilaDinamica();

	public void menu() {
		Impresion i1 = new Impresion("doc1", 300, 2);
		Impresion i2 = new Impresion("doc2", 250, 4);
		Impresion i3 = new Impresion("doc3", 175, 5);
		Impresion i4 = new Impresion("doc4", 450, 6);
		Impresion i5 = new Impresion("doc5", 278, 3);

		System.out.println("\n1) Implementación Fila Estatica");
		System.out.println("2) Implementación Fila Dinámica");
		System.out.println("3) Salir");
		System.out.println("Ingrese le número de la opción a elegir:");
		byte opc = d.nextByte();

		switch (opc) {
		case 1:
			System.out.println("\n------------------IMPLEMENTACIÓN DE FILA ESTATICA------------------\n");
			System.out.println("\n1) Insertar");
			System.out.println("2) Extraer");
			System.out.println("3) Eliminar");
			System.out.println("4) Total impresiones");
			System.out.println("5) Tamaño de archivo en bytes");
			System.out.println("6) Salir");
			System.out.println("Ingrese el número de la opción a elegir:");
			opc = d.nextByte();

			switch (opc) {
			case 1:
				System.out.println("\n------------------INSERTAR------------------\n");
				ife.insertar(i1);
				ife.insertar(i2);
				ife.insertar(i3);
				ife.insertar(i4);
				ife.insertar(i5);
				break;
			case 2:
				System.out.println("\n------------------EXTRAER------------------\n");
				ife.extraer();
				break;
			case 3:
				System.out.println("\n------------------ELIMINAR------------------\n");
				ife.eliminar();
				break;
			case 4:
				System.out.println("\n------------------TOTAL DE IMPRESIONES------------------\n");
				ife.totalImpresiones();
				break;
			case 5:
				System.out.println("\n------------------TAMAÑO DE ARCHIVOS EN BYTES------------------\n");
				ife.tamañoBytes();
				break;
			case 6:
				System.out.println("------------------------------------");
				break;
			default:
				System.out.println("Opción Incorrecta");
				break;
			}
			break;
		case 2:
			System.out.println("\n------------------IMPLEMENTACIÓN DE FILA DINÁMICA------------------\n");
			System.out.println("\n1) Insertar");
			System.out.println("2) Extraer");
			System.out.println("3) Eliminar");
			System.out.println("4) Total impresiones");
			System.out.println("5) Tamaño de archivo en bytes");
			System.out.println("7) Salir");
			System.out.println("Ingrese el número de la opción a elegir:");
			opc = d.nextByte();

			switch (opc) {
			case 1:
				System.out.println("\n------------------INSERTAR------------------\n");
				ifd.insertar(i1);
				ifd.insertar(i2);
				ifd.insertar(i3);
				ifd.insertar(i4);
				ifd.insertar(i5);
				break;
			case 2:
				System.out.println("\n------------------EXTRAER------------------\n");
				ifd.extraer();
				break;
			case 3:
				System.out.println("\n------------------ELIMINAR------------------\n");
				ifd.eliminar();
				break;
			case 4:
				System.out.println("\n------------------TOTAL DE IMPRESIONES------------------\n");
				ifd.totalImpresiones();
				break;
			case 5:
				System.out.println("\n------------------TAMAÑO DE ARCHIVO EN BYTES------------------\n");
				ifd.tamañoBytes();
				break;
			case 6:
				System.out.println("------------------------------------");
				break;
			default:
				System.out.println("Opción Incorrecta");
				break;
			}
			break;
		case 3:
			System.out.println("------------------------------------");
		default:
			System.out.println("¡Opción Incorrecta!");
			break;
		}
	}
}

public class PruebaFIlasColas {
	public static void main(String[] args) {
		Menu m = new Menu();

		System.out.println("\n\t\t\t\t\t------------------IMPRESIONES------------------\n");
		m.menu();
	}
}