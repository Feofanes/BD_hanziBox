
package Interfaces;

import Entradas.Hanzi;
import java.sql.Connection;
import bd_hanzibox.*;
import bd_hanzibox.ventana_principal;
import static bd_hanzibox.ventana_principal.busqueda_resultados;
import java.awt.Font;
import java.awt.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class Implementacion_metodos implements Metodos {
    
    static String auxiliar_elemento ;  
    static String auxiliar_campo;
    
    // instanciamos la conxion para acceder a esta desde los metodos
    Conexion conexion = Conexion.getInstance(); 
    

    //---------------------------- METODOS -------------------------------------
    
    //  AGREGAR ENTRADAS
    @Override
    public void agregar(Hanzi hanzi) {
        
        try{
            
            Connection conectar = conexion.conectar();
            
                PreparedStatement agregar = conectar.prepareStatement("insert into hanzi_entrada (Radical, Hanzi, Fonetica, Traduccion, Ejemplo) "
                        + "values (?,?,?,?,?)");

                agregar.setString(1, hanzi.getRadical());
                agregar.setString(2, hanzi.getIdiograma());
                agregar.setString(3, hanzi.getFonetica());
                agregar.setString(4, hanzi.getTraduccion());
                agregar.setString(5, hanzi.getEjemplo());

                agregar.executeUpdate();

                conexion.desconectar();
                
            }catch(Exception e){
                    
                    System.out.println("Error en metodo agregar");
        
        }
                
            }   //  FUNCIONANDO

    //  BORRAMOS ENTRADAS CON EL HANZI COMO UNICO PARAMETRO
    @Override
    public void borrar(Hanzi hanzi_eliminar, ventana_principal acceso) {
        
        try{
            
            Connection conectar = conexion.conectar();  //  conectamos
            
            PreparedStatement eliminar = conectar.prepareStatement("delete from hanzi_entrada where Hanzi = ?");    //  sql de eliminacion
            
            eliminar.setString(1, hanzi_eliminar.getIdiograma());   // seteamos parametros de eliminacion
            
            eliminar.executeUpdate();   //  ejecutamos
            
            conexion.desconectar(); //  desconectamos
            
        }catch(Exception e){
            
            e.printStackTrace();
            
        }
        
    }   // FUNCIONANDO

    //  MODIFICAR ENTRADAS BUSCANDO POR HANZI
    @Override
    public void modificar(Hanzi hanzi, ventana_principal acceso) {
        
        // instanciamos la conxion para acceder a esta desde los metodos
            Conexion conexion = Conexion.getInstance();
            Connection conectar = conexion.conectar();
        
        try {
            
            // instancia para recuperar los valores de las entradas
            
            String infoPinyin = acceso.getEntradaPinyin();
            String infoTraduccion = acceso.getEntradaTraduccion();
            String infoEjemplo = acceso.getEntradaEjemplo();
            String infoRadical = acceso.getEntradaRadical();
            String infoHanzi = acceso.getEntradaHanzi();
            
            // solo modificara en los campos donde se ingreso informacion
            if (infoPinyin != null && !infoPinyin.isBlank()) {

                PreparedStatement modificar = conectar.prepareStatement(
                        "update hanzi_entrada set Fonetica = ? where Hanzi = ?");

                modificar.setString(1, infoPinyin);
                modificar.setString(2, infoHanzi);
                modificar.executeUpdate();
                
            }

            if (infoTraduccion != null && !infoTraduccion.isBlank()) {

                PreparedStatement modificar = conectar.prepareStatement(
                        "update hanzi_entrada set Traduccion = ? where Hanzi = ?");

                modificar.setString(1, infoTraduccion);
                modificar.setString(2, infoHanzi);
                modificar.executeUpdate();
                
                System.out.println(infoTraduccion + " no");

            }

            if (infoEjemplo != null && !infoEjemplo.isBlank()) {

                PreparedStatement modificar = conectar.prepareStatement(
                        "update hanzi_entrada set Ejemplo = ? where Hanzi = ?");

                modificar.setString(1, infoEjemplo);
                modificar.setString(2, infoHanzi);
                modificar.executeUpdate();

            }

            if (infoRadical != null && !infoRadical.isBlank()) {

                PreparedStatement modificar = conectar.prepareStatement(
                        "update hanzi_entrada set Radical = ? where Hanzi = ?");

                modificar.setString(1, infoRadical);
                modificar.setString(2, infoHanzi);
                modificar.executeUpdate();

            }

            conexion.desconectar();

        } catch (Exception e) {
            System.out.println("Error, no existe el hanzi que se quiere modificar");
            e.printStackTrace();
        }
        
    }   //  FUNCIONANDO
    
    @Override
    public void buscar(Hanzi hanzi, ventana_principal acceso) {
        
        // Funciona a partir de la implementacion del metodo mostrarTabla();
        
        
        
        
    }   //  FUNCIONANDO

    //  CONSTATA QUE NO EXISTA PREVIAMENTE LO QUE SE QUIERE AGREGAR
    @Override
    public boolean buscarExistencia(String hanzi_ingresado) {
        
        Connection conectar = conexion.conectar();  // conectamos
        
        boolean registroExistente = false;  //  variable que retornaremos
        
        try{
            
            //  buscamos en el campo
            PreparedStatement chequeandoExistencia = conectar.prepareStatement("SELECT * FROM hanzi_entrada WHERE Hanzi = ?");
            
            //  seteamos la instancia con el parametro del metodo, que sera el parametro de busqueda tambien
            chequeandoExistencia.setString(1, hanzi_ingresado);
            
            //  la consulta en si
            ResultSet consulta = chequeandoExistencia.executeQuery();
            
            //  cambiamos el valor de la instancia de retorno segun corresponda a la busqueda
            if(consulta.next()){
                
                registroExistente = true;
                
            }else{
                
                registroExistente = false;
                
            }
            
            conexion.desconectar();
            
        }catch(SQLException e){
            
            System.out.println("entra aca");
        
        }
        
        return registroExistente;
        
    }   //  FUNCIONANDO

    //  MOSTRAR BUSQUEDA EN TABLA
    @Override
    public void mostrarTabla(String campo_busqueda, ventana_principal acceso) {
        
        try{
            
            Connection conectando = conexion.conectar();    // conectamos
            
            DefaultTableModel modelo = new DefaultTableModel(); //  modelamos la tabla
            
            busqueda_resultados.setModel(modelo);   // la tabla de la ventana_principal toma la forma del modelo
            busqueda_resultados.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
            
             auxiliar_elemento = "";  // variables auxiliares que toman el elemento a buscar y la columna donde hacerlo
             auxiliar_campo = "";
            
            String columna_de_busqueda = "";
            
            //  evaluamos desde que parametro se realiza la busqueda (hanzi, pinyin, traduccion, radical, etc)
            if(campo_busqueda.equals(acceso.getEntradaHanzi())){  // BUSQUEDA POR HANZI
                
                auxiliar_elemento = acceso.getEntradaHanzi();   // elemento a buscar
                auxiliar_campo = "Hanzi";   // campo de la tabla en la cual buscar
                
                campo_busqueda = acceso.getEntradaHanzi().trim();
                
                columna_de_busqueda = "Hanzi";
                
            }else if(campo_busqueda.equals(acceso.getEntradaPinyin())){   //  BUSQUEDA POR PINYIN
                
                auxiliar_elemento = acceso.getEntradaPinyin().trim();   
                auxiliar_campo = "Fonetica";   
                
                campo_busqueda = acceso.getEntradaPinyin().trim();
                
                columna_de_busqueda = "Fonetica";
                
            }else if(campo_busqueda.equals(acceso.getEntradaTraduccion())){   //  BUSQUEDA POR TRADUCCION
                
                auxiliar_elemento = acceso.getEntradaTraduccion().toLowerCase().trim();
                auxiliar_campo = "Traduccion"; 
                
                columna_de_busqueda = "Traduccion";
                
            }else{  //  BUSQUEDA POR RADICAL
            
                auxiliar_elemento = acceso.getEntradaRadical().trim();
                auxiliar_campo = "Radical";
                
                columna_de_busqueda = "Radical";

                    }   // (campo_busqueda.equals(acceso.getEntradaRadical()))
            
            //  esta sintaxis asegura recuperar todos los elementos "similares", no solo el que coincida exactamente con la busqueda
            PreparedStatement seleccion = conectando.prepareStatement("SELECT * FROM hanzi_entrada WHERE ? LIKE ?");
            
            seleccion.setString(1, auxiliar_campo);
            seleccion.setString(2, "%" + auxiliar_elemento + "%");
            
            
            ResultSet consulta = seleccion.executeQuery();
            
            System.out.println(" despues de la consulta auxiliar_campo es " + auxiliar_campo);
            System.out.println(" despues de la consulta auxiliar_elemento es " + auxiliar_elemento);
            
            /*
            if(!consulta.next()){
                
                acceso.getjLabel_advertencia().setText("No hay coicidencias");
                
            }
            */
            ResultSetMetaData datos = consulta.getMetaData();   // obtenemos el num de columnas
            int cantidad_columnas = datos.getColumnCount();
            
            modelo.addColumn("Codigo");
            modelo.addColumn("Radical");
            modelo.addColumn("Hanzi");
            modelo.addColumn("Fonetica");
            modelo.addColumn("Traduccion");
            modelo.addColumn("Ejemplo");
            
            while(consulta.next()){ // iteramos la busqueda para llenar cada columna del resultado
                
                Object arreglo [] = new Object [cantidad_columnas];
                
                for(int i=0; i<cantidad_columnas; i++){
                    
                    //  guardamos en el arreglo toda una fila
                    arreglo[i] = consulta.getObject(i + 1); // +1 porque las filas en BD empiezan en 1, no en 0
                    
                }
                
                modelo.addRow(arreglo); // agregamos el array resultante al modelo
                
            }
            
            System.out.println("en implementacion_metodo auxiliar_elemento: "+ auxiliar_elemento);
            System.out.println("en implementacion_metodo la columna en que busca es: " + columna_de_busqueda );
            
            conexion.desconectar();
                
        }catch(SQLException e){
            
            e.printStackTrace();
        
        }
       
}   //  FUNCIONANDO

    //  CONTAR LA CANTIDAD DE REGISTROS TOTALES
    @Override
    public int contarInput() {
        
        int registros_encontrados = 0;
        
        try{
            
            Connection conectar = conexion.conectar();
            
                PreparedStatement agregar = conectar.prepareStatement("Select COUNT(Hanzi) from hanzi_entrada");
                
                ResultSet consulta = agregar.executeQuery();
                
                
                    
                if(consulta.next()){
                    
                    registros_encontrados = consulta.getInt(1);
                    
                }
                
                conexion.desconectar();
                
                        }catch(Exception e){
                            
                            e.printStackTrace();
                            
                        }
        
        
        
        
        return registros_encontrados;
        

    }   //  FUNCIONANDO
}

            
            
            
            
        
     
