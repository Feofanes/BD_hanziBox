
package Interfaces;

import Entradas.Hanzi;
import Entradas.Hanzi_molde;
import Entradas.Unidad_final;
import Entradas.Unidad_min;
import bd_hanzibox.procesador_texto;
import bd_hanzibox.ventana_principal;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public interface Metodos {
        
    //  CRUD BASICO ------------------------------------------------------------
    
    public void agregar(Unidad_final hanzi_agregar);   // funcionalizado
    
    public void borrar(Hanzi hanzi_eliminar, ventana_principal acceso); //  funcionalizado
    
    public void modificar(Unidad_final hanzi, ventana_principal acceso); // funcionalizado
    
    public void buscar(Hanzi hanzi, ventana_principal acceso);
    
    
    
    //  OPCIONES AVANZADAS  ----------------------------------------------------
    
    public boolean buscarExistencia(Unidad_final hanzi_aCorroborar, ventana_principal acceso);    // funcionalizado
    
    public void mostrarTabla(String columna_busqueda, ventana_principal acceso);  // funcionalizado
    
    public void compararDuplicados(Unidad_final hanzi_aCorroborar);
        
    public int contarInput();   //  funcionalizado
    
    public int contarHanziUnicos();
    
    public String autocompletarRadicales(Unidad_min hanzi_autocompletar);
    
    
    
    //  TABLA SECUNDARIA -------------------------------------------------------
    
    public boolean corroborarSingularidad(Unidad_min hanzi_ingresado);
    
    public void agregarSingularidades(Unidad_min hanzi);
    
    public void compararDuplicados_singular(Unidad_min hanzi_aCorroborar);
    
    public void modificarSingularidad(Unidad_final hanzi, ventana_principal acceso);
    
    
    
    //  PROCESADOR DE TEXTO ----------------------------------------------------
    
    public boolean buscarSeleccion(String texto_seleccionado);
    
    public void mostrarTablaProcesador(String mostrar_texto_seleccionado);
    
    public boolean buscarExistenciaProcesador(Unidad_final hanzi_aCorroborar, procesador_texto acceso); 
    
}
