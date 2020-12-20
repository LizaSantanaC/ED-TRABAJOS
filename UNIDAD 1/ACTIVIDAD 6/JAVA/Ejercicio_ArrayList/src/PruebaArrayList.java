import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class Alumno {

	// Variables
	private int ficha;
	private String nombre;
	private String priApellido;
	private String segApellido;
	private byte edad;
	private String direccion;
	private String telefono;
	private String correoElectronico;
	private String redesSociales;
	private String carreraInteres;
	private String escuelaProcedencia;
	private String bachilleratoCursado;

	// COnstructores
	public Alumno() {

	}

	public Alumno(int ficha, String nombre, String priApellido, String segApellido, byte edad, String direccion,
			String telefono, String correoElectronico, String redesSociales, String carreraInteres,
			String escuelaProcedencia, String bachilleratoCursado) {
		super();
		this.ficha = ficha;
		this.nombre = nombre;
		this.priApellido = priApellido;
		this.segApellido = segApellido;
		this.edad = edad;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correoElectronico = correoElectronico;
		this.redesSociales = redesSociales;
		this.carreraInteres = carreraInteres;
		this.escuelaProcedencia = escuelaProcedencia;
		this.bachilleratoCursado = bachilleratoCursado;
	}

	// Getters and setters
	public int getFicha() {
		return ficha;
	}

	public String getNombre() {
		return nombre;
	}

	public String getPriApellido() {
		return priApellido;
	}

	public String getSegApellido() {
		return segApellido;
	}

	public byte getEdad() {
		return edad;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public String getRedesSociales() {
		return redesSociales;
	}

	public String getCarreraInteres() {
		return carreraInteres;
	}

	public String getEscuelaProcedencia() {
		return escuelaProcedencia;
	}

	public String getBachilleratoCursado() {
		return bachilleratoCursado;
	}

	public void setFicha(int ficha) {
		this.ficha = ficha;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPriApellido(String priApellido) {
		this.priApellido = priApellido;
	}

	public void setSegApellido(String segApellido) {
		this.segApellido = segApellido;
	}

	public void setEdad(byte edad) {
		this.edad = edad;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public void setRedesSociales(String redesSociales) {
		this.redesSociales = redesSociales;
	}

	public void setCarreraInteres(String carreraInteres) {
		this.carreraInteres = carreraInteres;
	}

	public void setEscuelaProcedencia(String escuelaProcedencia) {
		this.escuelaProcedencia = escuelaProcedencia;
	}

	public void setBachilleratoCursado(String bachilleratoCursado) {
		this.bachilleratoCursado = bachilleratoCursado;
	}

	public String toString() {
		return "ALUMNO:\n Ficha: " + ficha + "\n Nombre: " + nombre + "\n Primer Apellido: " + priApellido
				+ "\n Segundo Apellido: " + segApellido + "\n Edad: " + edad + "\n Direccion: " + direccion
				+ "\n Telefono: " + telefono + "\n Correo Electronico: " + correoElectronico + "\n Redes Sociales: "
				+ redesSociales + "\n Carrera Interes: " + carreraInteres + "\n Escuela Procedencia: "
				+ escuelaProcedencia + "\n Bachillerato Cursado: " + bachilleratoCursado;
	}
}

class RegistroAlumnos {
	ArrayList listadoAlumnos = new ArrayList();

	public void registrarAlumno(Alumno a) {
		listadoAlumnos.add(a);
	}

	public void mostrarAlumnos() {
		Iterator i = listadoAlumnos.iterator();
		while (i.hasNext()) {
			System.out.println("\n" + ((Alumno) i.next()).toString());
		}
	}

	// MÉTODO PARA OBTENER EL FOLIO DEL ULTIMO ALUMNO
	public int mostrarFolio() {
		System.out.println("------------------------------------------");
		Iterator i = listadoAlumnos.iterator();
		int a = 0;
		if (listadoAlumnos.isEmpty()) {
			System.out.println("No hay registro de alumno en la lista actual");
		} else {
			for (int b = 0; b < listadoAlumnos.size(); b++) {
				a++;
			}
			System.out.println("\nÚLTIMO FOLIO: " + a);
		}
		return a;
	}
}

public class PruebaArrayList {

	public static void main(String[] args) {
		Scanner d = new Scanner(System.in);
		String opc = "";
		RegistroAlumnos registroAlumnos = new RegistroAlumnos();

		System.out.println("\t\t\t\t-----------------------ALUMNOS-----------------------");

		do {
			System.out.println("Ingrese la ficha: ");
			int ficha = d.nextInt();
			System.out.println("Ingrese el nombre: ");
			String nombre = d.next();
			System.out.println("Ingrese el primer apellido: ");
			String priApellido = d.next();
			System.out.println("Ingrese el segundo apellido: ");
			String segApellido = d.next();
			System.out.println("Ingrese la edad: ");
			byte edad = d.nextByte();
			System.out.println("Ingrese la direccion: ");
			String direccion = d.next();
			System.out.println("Ingrese el telefono: ");
			String telefono = d.next();
			System.out.println("Ingrese el correo electrónico: ");
			String correoElectronico = d.next();
			System.out.println("Ingrese redes sociales: ");
			String redSocial = d.next();
			System.out.println("Ingrese carrera de interes: ");
			String carreraInteres = d.next();
			System.out.println("Ingrese escuela de procedencia: ");
			String escuelaProcedencia = d.next();
			System.out.println("Ingrese bachillerato cursado: ");
			String bachillerato = d.next();

			registroAlumnos.registrarAlumno(new Alumno(ficha, nombre, priApellido, segApellido, edad, direccion,
					telefono, correoElectronico, redSocial, carreraInteres, escuelaProcedencia, bachillerato));

			System.out.println("----------------------------------------");
			System.out.println("Desea seguir ingresando alumno (s/n)");
			opc = d.next();
		} while (!opc.toLowerCase().equals("n"));

		d.close();

		System.out.println("\n-----------------------ALUMNOS-----------------------");

		registroAlumnos.mostrarAlumnos();
		registroAlumnos.mostrarFolio();
	}
}