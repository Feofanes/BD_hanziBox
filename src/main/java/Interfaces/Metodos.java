
package Interfaces;

import Entradas.Hanzi;
import Entradas.Hanzi_molde;
import Entradas.Unidad_final;
import bd_hanzibox.ventana_principal;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public interface Metodos {
    
    public void agregar(Hanzi hanzi);   // funcionalizado
    
    public void borrar(Hanzi hanzi_eliminar, ventana_principal acceso); //  funcionalizado
    
    public void modificar(Hanzi hanzi, ventana_principal acceso); // funcionalizado
    
    public void buscar(Hanzi hanzi, ventana_principal acceso);
    
    public boolean buscarExistencia(Unidad_final hanzi_aCorroborar, ventana_principal acceso);    // funcionalizado
    
    public void mostrarTabla(String columna_busqueda, ventana_principal acceso);  // funcionalizado
    
    public boolean corroborarSingularidad(Hanzi hanzi_ingresado);
    
    public void agregarSingularidades(Hanzi hanzi);
    
    public void modificarSingularidad(Hanzi hanzi, ventana_principal acceso);
    
    public int contarInput();   //  funcionalizado
    
    public int contarHanziUnicos();
    
}
