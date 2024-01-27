package helpers;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import entities.Articulo;

public class ExportarCsv {

	public static void exportarCSV(List<Articulo> listaArticulos) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar CSV");
        
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos CSV (*.csv)", "csv");
        fileChooser.setFileFilter(filter);

        int seleccion = fileChooser.showSaveDialog(null);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            try (FileWriter fileWriter = new FileWriter(fileChooser.getSelectedFile())) {
                fileWriter.write("ID,Nombre,Descripcion,Stock,Precio\n");

                for (Articulo articulo : listaArticulos) {
                    fileWriter.write(articulo.getId() + "," + articulo.getNombre() + ","
                    				+ articulo.getDescripcion() + "," + articulo.getStock() + ","
                    				+ articulo.getPrecio()+ "\n");
                }

                System.out.println("Exportación a CSV exitosa.");

            } catch (IOException e) {
                System.err.println("Error al exportar a CSV: " + e.getMessage());
            }
        } else if (seleccion == JFileChooser.CANCEL_OPTION) {
            System.out.println("Operación de guardado cancelada.");
        }
    }
	
}


