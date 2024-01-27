package modelo;

import java.util.List;

import entities.Articulo;
import helpers.Escritura;
import helpers.Lectura;

public class ArticuloDaoImpl implements ArticuloDao{
	
	Lectura lectura = new Lectura();
	Escritura escritura = new Escritura();
	List<Articulo> listaArticulos = lectura.leerFichero();

	@Override
	public List<Articulo> init() {
		return listaArticulos;
	}
	
	@Override
	public Articulo añadirArticulo(Articulo articulo) {
		if(listaArticulos.size()==0) {
			articulo.setId(0);
		} else {
			articulo.setId(listaArticulos.get(listaArticulos.size()-1).getId()+1);
		}
		listaArticulos.add(articulo);
		return articulo;
	}

	@Override
	public void borrarArticulo (int id) {
		try {
			for (Articulo articulo : listaArticulos) {
				if (articulo.getId() == id) {
					listaArticulos.remove(articulo);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public Articulo consultarArticuloPorId(int id) {
		try {
			for (Articulo articulo : listaArticulos) {
				if (articulo.getId() == id) {
					return articulo;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public List<Articulo> consultarTodos() {
		return listaArticulos;
	}

	@Override
	public void guardarFichero(List<Articulo> listaArticulos) {
		escritura.guardarFichero(listaArticulos);
	}
	
}
