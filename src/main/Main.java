package main;

import java.util.List;
import java.util.Scanner;

import entities.Articulo;
import helpers.ExportarCsv;
import modelo.ArticuloDaoImpl;

public class Main {
	
	public static void main(String[] args) {
		ArticuloDaoImpl adao = new ArticuloDaoImpl();
		ExportarCsv exportar = new ExportarCsv();
		List<Articulo> listaArticulos = adao.init();
		Scanner scanner = new Scanner(System.in);
		int opcion;
		
		do {
			System.out.println("---------------------------- X ----------------------------\n");
			System.out.println("1. Añadir nuevo artículo");
			System.out.println("2. Borrar artículo por id");
			System.out.println("3. Consultar artículo por id");
			System.out.println("4. Listado de todos los artículos");
			System.out.println("5. Exportar en CSV");
			System.out.println("6. Terminar el programa\n");
			System.out.println("---------------------------- X ----------------------------");
			
			while (!scanner.hasNextInt()) {
	            System.err.println("¡Error! Seleccione una opción entre 1 y 6");
	            scanner.next();
			}
			opcion = scanner.nextInt();
			
			switch (opcion) {
				case 1:
					System.out.println("Introduce el nombre del articulo");
					String nombre = scanner.next();
					System.out.println("Introduce la descripcion del articulo");
					String descripcion = scanner.next();
					System.out.println("Introduce el stock del articulo");
					enteroValido(scanner);
					int stock = scanner.nextInt();
					System.out.println("Introduce el precio del articulo");
					doubleValido(scanner);
					double precio = scanner.nextDouble();
					Articulo articulo = new Articulo(nombre,descripcion,stock,precio);
					if (adao.añadirArticulo(articulo)!= null) {
						System.out.println("\nArtículo añadido satifactoriamente:");
						System.out.println(articulo+"\n");
					} else {
						System.err.println("Error al añadir el artículo, inténtalo de nuevo");
					}
					
					break;
				case 2:
					System.out.println("Introduce el id del articulo a borrar:");
					enteroValido(scanner);
					int id = scanner.nextInt();
					if (adao.consultarArticuloPorId(id) != null) {
						adao.borrarArticulo(id);
						System.out.println("Acticulo borrado correctamente");
					} else {
						System.err.println("El artículo introducido no existe");
					}
					break;
				case 3:
					System.out.println("Introduce el id del articulo a consultar:");
					enteroValido(scanner);
					int id1 = scanner.nextInt();
					if (adao.consultarArticuloPorId(id1) != null) {
						System.out.println(adao.consultarArticuloPorId(id1));
					} else {
						System.err.println("El artículo introducido no existe");
					}
					break;
				case 4:
					listaArticulos = adao.consultarTodos();
					for (Articulo articulo1 : listaArticulos) {
						System.out.println(articulo1);
					}
					break;
				case 5:
					ExportarCsv.exportarCSV(listaArticulos);
					break;
				case 6:
					adao.guardarFichero(adao.consultarTodos());
					System.out.println("---------------------- Fin de programa ----------------------");
					break;
				default:
					System.out.println("Seleccione una opción entre 1 y 6");
					break;
			}
			
		} while (opcion != 6);
		
		scanner.close();
	}
	
	private static void enteroValido(Scanner scanner) {
		while (!scanner.hasNextInt()) {
            System.err.println("¡Error! Ingresa un número entero válido");
            scanner.next();
		}
	}
	
	private static void doubleValido(Scanner scanner) {
		while (!scanner.hasNextDouble()) {
            System.err.println("¡Error! Ingresa un número decimal válido usando comas");
            scanner.next();
		}
	}

}
