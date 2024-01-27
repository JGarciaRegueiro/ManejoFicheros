package modelo;

import java.util.List;

import entities.Articulo;

public interface ArticuloDao {
	
	List<Articulo> init();
	Articulo añadirArticulo(Articulo articulo);
	void borrarArticulo(int id);
	Articulo consultarArticuloPorId(int id);
	List<Articulo> consultarTodos();
	void guardarFichero(List<Articulo> listaArticulos);
}
