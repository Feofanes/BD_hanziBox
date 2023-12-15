
package Interfaces;

import Entradas.Hanzi;
import bd_hanzibox.ventana_principal;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public interface Metodos {
    
    public void agregar(Hanzi hanzi);   // funcionalizado
    
    public void borrar(Hanzi hanzi_eliminar, ventana_principal acceso);
    
    public void modificar(Hanzi hanzi, ventana_principal acceso); // funcionalizado
    
    public void buscar(Hanzi hanzi, ventana_principal acceso);
    
    public boolean buscarExistencia(String hanzi_ingresado);    // funcionalizado
    
    public void mostrarTabla(String columna_busqueda, ventana_principal acceso);  // funcionalizado
    
    public int contarInput();
    
}
