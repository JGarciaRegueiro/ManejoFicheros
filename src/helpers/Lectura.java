package helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import entities.Articulo;

public class Lectura {
	
	List<Articulo> listaArticulos = new ArrayList<>();
	
	public List<Articulo> leerFichero(){
		try (FileInputStream file = new FileInputStream("articulos.dat");
				ObjectInputStream buffer = new ObjectInputStream(file);){
			
			listaArticulos = (List<Articulo>)buffer.readObject();
			
		} catch (IOException e) {
			System.out.println("No se ha podido abrir la lista de artículos");
			System.out.println(e.getMessage());
		}
		catch (ClassNotFoundException e3) {
					System.out.println("La clase Artículo no está cargada en memoria");
					System.out.println(e3.getMessage());
		}
		return listaArticulos;
		
	}
}
