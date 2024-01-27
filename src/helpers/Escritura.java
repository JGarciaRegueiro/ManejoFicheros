package helpers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

import entities.Articulo;

public class Escritura {
	
	public void guardarFichero(List<Articulo> listaArticulos) {
		try(FileOutputStream file = new FileOutputStream("articulos.dat");
			ObjectOutputStream buffer = new ObjectOutputStream(file)) {
			buffer.writeObject(listaArticulos);
			System.out.println("Los artículos se han guardado con éxito");
		} catch (IOException e) {
			System.out.println("No se ha podido abrir el fichero");
			System.out.println(e.getMessage());
		}
	}

}
