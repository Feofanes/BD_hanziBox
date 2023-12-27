
package Interfaces;

import Entradas.Hanzi;
import Entradas.Hanzi_molde;
import Entradas.Unidad_final;
import Entradas.Unidad_min;
import bd_hanzibox.ventana_principal;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public interface Metodos {
        
    //  CRUD BASICO ------------------------------------------------------------
    
    public void agregar(Unidad_final hanzi_agregar, ventana_principal acceso);   // funcionalizado
    
    public void borrar(Hanzi hanzi_eliminar, ventana_principal acceso); //  funcionalizado
    
    public void modificar(Unidad_final hanzi, ventana_principal acceso); // funcionalizado
    
    public void buscar(Hanzi hanzi, ventana_principal acceso);
    
    
    
    //  OPCIONES AVANZADAS  ----------------------------------------------------
    
    public boolean buscarExistencia(Unidad_final hanzi_aCorroborar, ventana_principal acceso);    // funcionalizado
    
    public void mostrarTabla(String columna_busqueda, ventana_principal acceso);  // funcionalizado
    
    public void compararDuplicados(Unidad_final hanzi_aCorroborar, ventana_principal acceso);
        
    public int contarInput();   //  funcionalizado
    
    public int contarHanziUnicos();
    
    public String autocompletarRadicales(Unidad_min hanzi_autocompletar);
    
    
    
    //  TABLA SECUNDARIA
    
    public boolean corroborarSingularidad(Unidad_min hanzi_ingresado);
    
    public void agregarSingularidades(Unidad_min hanzi);
    
    public void compararDuplicados_singular(Unidad_min hanzi_aCorroborar, ventana_principal acceso);
    
    public void modificarSingularidad(Unidad_final hanzi, ventana_principal acceso);
    
}
