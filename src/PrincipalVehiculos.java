import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map.Entry;



@SuppressWarnings("unused")
public class PrincipalVehiculos {

	public static void main(String[] args) {
	
		char resp;
		char orden;
		String auxColor = "";
		@SuppressWarnings("resource")
		Scanner S = new Scanner(System.in);
		S.useDelimiter("\r\n");
		ArrayList<Vehiculo> vehiculos = new ArrayList<>();
		Map<String, Integer> diccionario = new HashMap<>();
		pedirDatos(vehiculos);
		System.out.println("Añadir datos:");
		addColor(vehiculos, diccionario);
		System.out.println("Mostrar colores");
		mostrarColores(diccionario);
		System.out.println("Numero de colores");
		numColor(diccionario);
		System.out.println("Mostrar todos los coches de cada color:");
		mostrarTodos(diccionario);
		System.out.println("Desea eliminar un vehículo (S/N)");
		resp = S.next().charAt(0);
				
		System.out.println("Introduzca el color del vehículo que va eliminar: ");
		auxColor = S.next();
		if (Character.toUpperCase(resp) == 'S') {
			borrarColor(vehiculos, diccionario, auxColor);
			for (Vehiculo v : vehiculos) {
				System.out.println(v);
			}

		}
		System.out.println("Lista de colores ordenados: ");
		ordenaColor(diccionario);
		do {
		System.out.println("En que orden desea imprimir (A/D)");
		orden = S.next().charAt(0);
		 imprimeAscDesc(diccionario,orden);
		}while(orden!='A' && orden != 'D');

	}
	@SuppressWarnings("rawtypes")
	public static void pedirDatos(ArrayList<Vehiculo> vehiculos) {
		String matricula = "";
		String color = "";
		int nVehiculos = 0;
		@SuppressWarnings("resource")
		Scanner S = new Scanner(System.in);
		S.useDelimiter("\r\n");

		do {
			System.out.println("Introduzca el número de vehículos que va ingresar: ");
			nVehiculos = S.nextInt();

		} while (nVehiculos < 0);

		for (int i = 1; i <= nVehiculos; i++) {
			Vehiculo auxVehiculo = new Vehiculo();
			System.out.println("Ingrese la matrícula del coche nº " + i);
			matricula = S.next();
			System.out.println("Ingrese el color del coche nº " + i);
			color = S.next();

			auxVehiculo.setMatricula(matricula);
			auxVehiculo.setColor(color);

			vehiculos.add(auxVehiculo);
		}
		
		
		
		

	}
	public static void addColor(ArrayList<Vehiculo> vehiculos, Map<String, Integer> diccionario) {

		for (Vehiculo v : vehiculos) {

			String color = v.getColor();
			if (!diccionario.containsKey(color) ) {
				int numVehiculos = diccionario.get(color);
					diccionario.put(color,1);
			} else {
			
				diccionario.put(color,diccionario.get(color)+1);
			}
		}

	}
	public static void mostrarColores(Map<String, Integer> diccionario) {
		
		for(String i: diccionario.keySet()) {
			System.out.println("i");
		}

	}
	public static void mostrarTodos(Map<String,Integer> diccionario) {

		for(String i: diccionario.keySet()) {
			System.out.println("Color"+i+"Número"+diccionario.get(i));
		}
	}
	public static int numColor(Map<String, Integer> diccionario) {
		
		return diccionario.size();
	}
	public static void borrarColor(ArrayList<Vehiculo> vehiculos, Map<String, Integer> diccionario,
			String auxColor) {

		Iterator<Vehiculo> it = vehiculos.iterator();
		while (it.hasNext()) {
			Vehiculo v = it.next();
			String color = v.getColor();
			if (color.equalsIgnoreCase(auxColor)) {
				it.remove();
			}

		}
		diccionario.remove(auxColor);
	}
	public static void ordenaColor(Map<String,Integer> diccionario) {
		
		TreeMap <String,Integer> tmp = new TreeMap <String,Integer> (diccionario);
		mostrarColores(diccionario);
	}
	public static void imprimeAscDesc (Map <String, Integer> diccionario, char orden) {
		if (diccionario.isEmpty())
			System.out.println("El mapa está vacio");
		else {
			TreeSet <Entry<String,Integer>> treeSet=null;
			if(Character.toUpperCase(orden)=='A')
				treeSet = new TreeSet <Entry<String,Integer>>(new Ascendente());
			else {
				if(Character.toUpperCase(orden)=='D')
					treeSet = new TreeSet <Entry<String,Integer>>(new Descendente());
				else
					System.out.println("Error introduzca un orden correcto");
			treeSet.addAll(diccionario.entrySet());
		
			Iterator it = treeSet.iterator();
			while(it.hasNext())
				System.out.println(it.next());
			}
		}
	}

}
