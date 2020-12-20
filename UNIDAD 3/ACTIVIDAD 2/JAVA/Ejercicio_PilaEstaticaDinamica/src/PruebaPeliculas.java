import java.util.Scanner;
import java.util.Stack;

class Menu {
	Scanner d = new Scanner(System.in);
	ImplementacionPilaEstatica ipe = new ImplementacionPilaEstatica();
	ImplementacionPilaDinamica ipd = new ImplementacionPilaDinamica();

	public void menu1() {
		System.out.println("1) Implementación de Pila Estatica");
		System.out.println("2) Implementación de Pila Dinámica");
		System.out.println("3) Salir");
		System.out.println("Ingrese el número de la opción a elegir: ");
		byte op = d.nextByte();

		switch (op) {
		case 1:
			System.out.println("\n--------------IMPLEMENTACIÓN DE PILA ESTATICA--------------\n");
			menu2();
			break;
		case 2:
			System.out.println("\n--------------MPLEMENTACIÓN DE PILA DINÁMICA--------------\n");
			menu2();
			break;
		case 3:
			System.out.println("\n--------------");
			break;
		default:
			System.out.println("¡Opción Incorrecta!");
			break;
		}
	}

	public void menu2() {

		System.out.println("1) Cargar BD de peliculas");
		System.out.println("2) Rentar Pelicula");
		System.out.println("3) Devolver Pelicula");
		System.out.println("4) Mostrar cantidad de peliculas disponibles para renta");
		System.out.println("5) Salir");
		System.out.println("Ingrese el número de la opción a elegir: ");
		byte opc = d.nextByte();

		switch (opc) {
		case 1:
			System.out.println("\n\t--------------CARGAR BASE DE DATOS DE PELICULAS--------------\n");
			ipe.insertarDatos();
			break;
		case 2:
			System.out.println("\n\t--------------RENTAR PELICULA--------------\n");
			ipe.rentaPeliculas();
			break;
		case 3:
			System.out.println("\n\t--------------DEVOLVER PELICULA--------------\n");
			ipe.devolverPelicula("Titulo", "Genero");
			break;
		case 4:
			System.out.println("\n\t--------------OSTRAR CANTIDAD DE PELICULAS DISPONIBLES PARA RENTA--------------\n");
			ipd.cantidadPeliculasDisponibles();
			break;
		case 5:
			System.out.println("\n\n\t\t--------------");
			break;
		default:
			System.out.println("\n¡Opción Incorrecta!");
			break;
		}
	}
}

class Pelicula {

	private String tituloPelicula;
	private String generoPelicula;

	public Pelicula() {
	}

	public Pelicula(String tituloPelicula, String generoPelicula) {
		super();
		this.tituloPelicula = tituloPelicula;
		this.generoPelicula = generoPelicula;
	}

	public String getTituloPelicula() {
		return tituloPelicula;
	}

	public String getGeneroPelicula() {
		return generoPelicula;
	}

	public void setTituloPelicula(String tituloPelicula) {
		this.tituloPelicula = tituloPelicula;
	}

	public void setGeneroPelicula(String generoPelicula) {
		this.generoPelicula = generoPelicula;
	}

	@Override
	public String toString() {
		return "Pelicula: " + tituloPelicula + "\nGenero: " + generoPelicula;
	}
}

interface RentaPeliculas {

	public abstract void insertarDatos();

	public abstract boolean pilaLlena();

	public abstract boolean pilaVacia();

	public abstract String rentarPelicula();

	public abstract boolean devolverPelicula(String titulo, String genero);

	public abstract void cantidadPeliculasDisponibles();

}
class ImplementacionPilaEstatica implements RentaPeliculas {

	static String peliculas[][] = { { "El Juego De La Fortuna", "Drama" }, { "Intesamente", "Animación" },
			{ "Más Barato Por Docena 2", "Comedia" }, { "Garfield", "Comedia" },
			{ "Cuando Un Extraño Llama", "Suspenso" } };

	private int cima;
	private int tamañoPila;
	private int calificaciones[];

	public String rentaPeliculas() {
		String titulo = "";
		String genero = "";

		if (pilaVacia() == true) {
			titulo = peliculas[cima][1];
			genero = peliculas[cima][0];
		} else {
			titulo = peliculas[cima][1];
			genero = peliculas[cima][0];
			cima--;
		}
		return titulo + " " + genero;
	}

	public boolean devolverPelicula(String titulo, String genero) {
		boolean r;
		int aux = 0;
		if (pilaLlena() == true) {
			r = false;
		} else {
			cima++;
			peliculas[cima][aux] = titulo;
			aux++;
			peliculas[cima][aux] = genero;
			r = true;
		}

		return r;
	}

	public void insertarDatos() {
		cima = -1;
	}

	public boolean pilaLlena() {
		return (cima == peliculas.length - 1) ? true : false;
	}

	public boolean pilaVacia() {
		return (cima == -1) ? true : false;
	}

	public void cantidadPeliculasDisponibles() {
	}

	@Override
	public String rentarPelicula() {
		// TODO Auto-generated method stub
		return null;
	}

}

class ImplementacionPilaDinamica implements RentaPeliculas {

	Stack<Pelicula> mStack = new Stack<Pelicula>();

	public void cargarDatos() {
		Pelicula peli1 = new Pelicula("El Juego De La Fortuna", "Drama");
		Pelicula peli2 = new Pelicula("Intensamente", "Animación");
		Pelicula peli3 = new Pelicula("Más Barato Por Docena 2", "Comedia");
		Pelicula peli4 = new Pelicula("Garfield", "Comedia");
		Pelicula peli5 = new Pelicula("Cuando Un Extraño Llama", "Suspenso");

		mStack.push(peli1);
		mStack.push(peli2);
		mStack.push(peli3);
		mStack.push(peli4);
		mStack.push(peli5);
	}

	public void cantidadPeliculasDisponibles() {
		System.out.println("Peliculas Dispnibles: " + mStack.size());
	}

	@Override
	public void insertarDatos() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean pilaLlena() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean pilaVacia() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String rentarPelicula() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean devolverPelicula(String titulo, String genero) {
		// TODO Auto-generated method stub
		return false;
	}

}

public class PruebaPeliculas {
	public static void main(String[] args) {

		Menu m = new Menu();

		System.out.println("\n\t\t\t--------------RENTA DE PELICULAS--------------");
		System.out.println("");
		m.menu1();
	}
}