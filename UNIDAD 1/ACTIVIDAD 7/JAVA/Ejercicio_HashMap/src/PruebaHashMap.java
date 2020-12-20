import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import javax.*;

class Alumno{
	private String nombre;
	private byte edad;
	private String carrera;
	private String fechaInscripcion;
	
	//Constructor
	public Alumno(String nombre, byte edad, String carrera,String fechaInscripcion) {
		this.nombre = nombre;
		this.edad = edad;
		this.carrera = carrera;
		this.fechaInscripcion = fechaInscripcion;
	}
	
	//Getters y Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public byte getEdad() {
		return edad;
	}

	public void setEdad(byte edad) {
		this.edad = edad;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public String getFechaInscripcion() {
		return fechaInscripcion;
	}

	public void setFechaInscripcion(String fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}	
}

class RegistroAlumno{
	
	HashMap <String, Alumno> inscripciones;

	public RegistroAlumno() {
		inscripciones=new HashMap<>();
	}
	
	public boolean llenarInscripciones(){
		Scanner entrada=new Scanner(System.in);
		
		System.out.println("Ingresa Num. de alumnos que deseas registrar: ");
		String x =entrada.nextLine();
		int y=Integer.parseInt(x);
		
		try {
			for(int i=0;i<y;i++){
				System.out.println("Ingresa los datos del elemento "+i);
				System.out.println("Ingresa nombre del alumno: ");
				String nombre =entrada.nextLine();
				System.out.println("Ingresa numero de control: ");
				String numControl =entrada.nextLine();
				System.out.println("Ingresa carrera del alumno: ");
				System.out.println("ISC, IIA , IM ,LA ,CP" );
				String carrera =(entrada.nextLine()).toUpperCase();
				System.out.println("Ingresa fecha de inscripcion del alumno (dd/mm/aa): ");
				String fecha =entrada.nextLine();
				System.out.println("Ingresa edad del alumno: ");
				String edad =entrada.nextLine();
				System.out.println("================================================= ");
				
				int e=Integer.parseInt(edad);
				
				inscripciones.put(numControl, new Alumno(nombre,(byte)e,carrera,fecha));
				
			}return true;
			
		}catch(Exception e){
			System.out.printf("Error en la insercion :(");
			e.printStackTrace();
			return false;
		}
	}
	
	
	public void mostrarAlumnoCarrera(String carrera){
		
		for (Iterator iterador=inscripciones.keySet().iterator(); iterador.hasNext();){
	           Alumno a = inscripciones.get( iterador.next() );//obtenemos el alumno del HashMap a traves de la clave que da it.next()
	       
			if(carrera.equals((a.getCarrera()))){
				  
				   System.out.println("NOMBRE: " + a.getNombre());
	               System.out.println("EDAD: " + a.getEdad());
	               System.out.println("CARRERA: " + a.getCarrera());
	               System.out.println("FECHA DE INCRIPCION: " + a.getFechaInscripcion());
	               System.out.println("-----------------------------------------------");
			}
		}
	}
	
	
	public void vaciarLista(){
		inscripciones.clear();
		System.out.println("Lista borrada con exito: " );
	}
	
	public double calcularpromedioEdades(){
		double sumatoria=0;
		
		for(Iterator interador=inscripciones.keySet().iterator();interador.hasNext();){
			sumatoria+=(inscripciones.get((interador.next()))).getEdad();
		}
		return (sumatoria/inscripciones.size());
	}
	
	public void revisarFechaInscripcion(String fecha){
		String f[]=fecha.split("/");
		int dia=Integer.parseInt(f[0]);
		int mes=Integer.parseInt(f[1]);
		int año=Integer.parseInt(f[2]);
		
		
		for(Iterator interador=inscripciones.keySet().iterator();interador.hasNext();){
			 Alumno a = inscripciones.get( interador.next() );//obtenemos el alumno del HashMap a traves de la clave que da it.next()
			 //obteber fecha y separarla
			 String fechaIns[]=(a.getFechaInscripcion()).split("/");
			 int dia2=Integer.parseInt(fechaIns[0]);
			 int mes2=Integer.parseInt(fechaIns[1]);
			 int año2=Integer.parseInt(fechaIns[2]);
			 
			 if(año<año2){
				   System.out.println("NOMBRE: " + a.getNombre());
	               System.out.println("EDAD: " + a.getEdad());
	               System.out.println("CARRERA: " + a.getCarrera());
	               System.out.println("FECHA DE INCRIPCION: " + a.getFechaInscripcion());
	               System.out.println("-----------------------------------------------");
			 }else if(mes<mes2 & año==año2){
				   System.out.println("NOMBRE: " + a.getNombre());
	               System.out.println("EDAD: " + a.getEdad());
	               System.out.println("CARRERA: " + a.getCarrera());
	               System.out.println("FECHA DE INCRIPCION: " + a.getFechaInscripcion());
	               System.out.println("-----------------------------------------------");
			 }else if(dia<dia2 & mes==mes2 & año==año2){
				   System.out.println("NOMBRE: " + a.getNombre());
	               System.out.println("EDAD: " + a.getEdad());
	               System.out.println("CARRERA: " + a.getCarrera());
	               System.out.println("FECHA DE INCRIPCION: " + a.getFechaInscripcion());
	               System.out.println("-----------------------------------------------");
			 }else{
				   System.out.println("Ningual alumno inscrito despues del "+fecha);
			 }
			 
		}
		
		
	}//fin metodo revisarFechaInscripcion
	
}//fin clase

public class PruebaHashMap {
	public static void main(String[] args) {
		Scanner entrada=new Scanner(System.in);
		 RegistroAlumno a1 = new RegistroAlumno();
        
         int opc=0;
         
         do{
        	 System.out.println("Elige una opcion: " );
        	 System.out.println("1) Llenar lista " );
        	 System.out.println("2) Vaciar lista " );
        	 System.out.println("3) Mostrar los alumnos por carrera " );
        	 System.out.println("4) Calcular Promedio de edades " );
        	 System.out.println("5) Mostrar los alumnos que se inscribieron despues de la fecha indicada " );
        	 System.out.println("6) SALIR" );
        	 String	x=entrada.nextLine();
        	 opc=Integer.parseInt(x);
        	 
        	 switch (opc){
        	 
        	 case 1: a1.llenarInscripciones();//Ingresar alumnos
        		 break;
        		 
        	 case 2:a1.vaciarLista();//vaciar lista
        		 break;
        		 
        	 case 3: 
        		 System.out.println("Ingresa la carrera para buscar el la lista:" );
        		 System.out.println("ISC, IIA , IM ,LA ,CP" );
        		 String carrera=(entrada.nextLine()).toUpperCase();
        		 a1.mostrarAlumnoCarrera(carrera);//mostrar alumnos 
        		 break;
        		 
        	 case 4:System.out.println("Promdio de edades= "+a1.calcularpromedioEdades());
        	 System.out.println("=======================================");
        		 break;
        		 
        	 case 5:System.out.println("Ingresa una fecha (dd/mm/aa):");
        	 		String fecha=entrada.nextLine();
        	 		a1.revisarFechaInscripcion(fecha);
        		 break;
        		 
        	 case 6:
        		 break;
        		 
        		 
        	 default:System.out.println("Opcion Incorresta ");
        		 break;
        		  
        	 }
        	 
         }while(opc!=6);

	}
}
