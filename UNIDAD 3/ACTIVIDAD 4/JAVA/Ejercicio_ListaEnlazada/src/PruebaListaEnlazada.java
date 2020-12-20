public class PruebaListaEnlazada {

	public static void main(String[] args) {
		ListaEnlazada le = new  ListaEnlazada();
		
		le.agregarNodoFinal("Liza");
		le.agregarNodoFinal("Santana");
		le.agregarNodoFinal("Contreras");
		le.agregarNodoFinal("Aremy");
		le.agregarNodoFinal("Liza123");
		 //le.eliminarnodoFinal();
		le.mostrarLista();
		 //System.out.println("Elemento elimindado: "+le.eliminarnodoInicio());
		//le.eliminarnodoFinal();
		//le.mostrarLista();
		
		System.out.println(le.buscarElemento2("Santana") ? "Encontrado":"No encontrado");
		
		le.eliminarNodoEspecifico("Santana");
		le.mostrarLista();
		
		
		//if(!(le.buscarElemento("Jose"))){
			//System.out.println("Elemento no encontrado");
		
		//}
	}
}
