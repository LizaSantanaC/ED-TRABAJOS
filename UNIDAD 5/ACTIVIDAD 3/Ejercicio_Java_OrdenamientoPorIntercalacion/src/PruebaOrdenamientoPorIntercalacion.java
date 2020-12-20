import java.io.*;
import java.util.Arrays;

class Auto implements Serializable {

	private String nombreAuto;
	private String marca;
	private int año;

	public Auto(String nombreAuto, String marca, int año) {
		super();
		this.nombreAuto = nombreAuto;
		this.marca = marca;
		this.año = año;
	}

	public int getAño() {
		return año;
	}

	@Override
	public String toString() {
		return "Auto [nombreAuto=" + nombreAuto + ", marca=" + marca + ", año=" + año + "]";
	}
}

class MetodoOrdenamientoPórIntercalacion {
	public static void imprimir(String ruta) {

		ObjectInputStream leer = null;

		try {

			leer = new ObjectInputStream(new FileInputStream(ruta));

			while (true) {
				try {

					System.out.println(leer.readObject());

				} catch (EOFException | ClassNotFoundException e) {
					break;
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				leer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static int[] metodoPorIntercalacion(int elemento1[], int elemento2[]) {
		int arrayMetodoPorIntercalacion[] = new int[elemento1.length + elemento2.length];
		int i = 0, j = 0, k = 0;
		while (i < elemento1.length && j < elemento2.length) {
			if (elemento1[i] < elemento2[j]) {
				arrayMetodoPorIntercalacion[k] = elemento1[i];
				k++;
				i++;
			} else {
				arrayMetodoPorIntercalacion[k] = elemento2[j];
				j++;
				k++;
			}
		}
		while (j < elemento2.length) {
			arrayMetodoPorIntercalacion[k] = elemento2[j];
			j++;
			k++;
		}
		while (j < elemento1.length) {
			arrayMetodoPorIntercalacion[k] = elemento1[j];
			j++;
			k++;
		}
		return arrayMetodoPorIntercalacion;
	}
	
	public void ordenarInteractivo(String autos1, String autos2, String factura) {
		try {
			ObjectInputStream leeA1= new ObjectInputStream(new FileInputStream(autos1));
			ObjectInputStream leeA2= new ObjectInputStream(new FileInputStream(autos2));
			ObjectOutputStream escribir= new ObjectOutputStream(new FileOutputStream(factura));
			
			Auto ob1= (Auto) leeA1.readObject();
			Auto ob2= (Auto) leeA2.readObject();
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

public class PruebaOrdenamientoPorIntercalacion {
	public static void main(String[] args) {
		int[] elemento1 = { 40, 4, 59, 2, 46, 300, 12, 3, 63, 1, 20 };
		int[] elemento2 = { 9, 15, 45, 2, 3, 48, 63 };
		System.out.println(
				Arrays.toString(MetodoOrdenamientoPórIntercalacion.metodoPorIntercalacion(elemento1, elemento2)));
		//
		String autos1= "./archivos/autos1.bin";
		String autos2= "./archivos/autos2.bin";
		String factura= "./archivos/factura.bin";
		
		System.out.println("Autos1");
		imprimir(autos1);
		System.out.println("Autos2");
		imprimir(autos2);
	}
}
