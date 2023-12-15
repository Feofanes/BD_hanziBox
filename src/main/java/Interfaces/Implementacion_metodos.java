
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
import java.sql.*;
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
    public void mostrarTabla(String columna_busqueda, ventana_principal acceso) {
        
        try{
            
            String elemento_busqueda = acceso.getParametro_busqueda();
            
            DefaultTableModel modelo = new DefaultTableModel(); //  modelamos la tabla

            busqueda_resultados.setModel(modelo);
            
            Connection conexionMySQL = conexion.conectar();
            
            if(columna_busqueda == null){
                
                System.out.println("error");
                
                acceso.setMsj_advertencia("Introduzca un solo parametro de busqueda");
                
            }else if(columna_busqueda.isBlank()){
                
                try{
                
                PreparedStatement seleccion = conexionMySQL.prepareStatement("SELECT * from hanzi_entrada");
            
                ResultSet consulta = seleccion.executeQuery();
                
                    System.out.println("Entro en el condicional de TODO");
                
                
                ResultSetMetaData datos = consulta.getMetaData();
            int cantidadColumnas = datos.getColumnCount();
            
            modelo.addColumn("Codigo");
            modelo.addColumn("Radical");
            modelo.addColumn("Hanzi");
            modelo.addColumn("Fonetica");
            modelo.addColumn("Traduccion");
            modelo.addColumn("Ejemplo");
            
            int anchos [] = {40, 40, 40, 40, 40, 40};
            
            for(int i = 0; i < cantidadColumnas; i++){
                
                busqueda_resultados.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
                
            }
            
            while(consulta.next()){
                
                Object arreglo[] = new Object[cantidadColumnas];
                
                for(int i = 0; i < cantidadColumnas; i++){
                    
                    arreglo[i] = consulta.getObject(i + 1);
                }
                modelo.addRow(arreglo);
            }
            
            
            conexion.desconectar();
                
                }catch(SQLException e){
                    
                    e.printStackTrace();
                    
                }
                
            }else{
                
                
            PreparedStatement seleccion = conexionMySQL.prepareStatement("SELECT * from hanzi_entrada WHERE " + columna_busqueda + " LIKE ?");
            
            seleccion.setString(1, "%" + elemento_busqueda + "%");
            
            System.out.println("en el metodo la columna donde busca es " + columna_busqueda);
            System.out.println("en el metodo la columna la palabra buscada es " + elemento_busqueda);
            
            ResultSet consulta = seleccion.executeQuery();
            
                System.out.println("entro en el condicional de else");
            
            ResultSetMetaData datos = consulta.getMetaData();
            int cantidadColumnas = datos.getColumnCount();
            
            modelo.addColumn("Codigo");
            modelo.addColumn("Radical");
            modelo.addColumn("Hanzi");
            modelo.addColumn("Fonetica");
            modelo.addColumn("Traduccion");
            modelo.addColumn("Ejemplo");
            
            int anchos [] = {40, 40, 40, 40, 40, 40};
            
            for(int i = 0; i < cantidadColumnas; i++){
                
                busqueda_resultados.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
                
            }
            
            while(consulta.next()){
                
                Object arreglo[] = new Object[cantidadColumnas];
                
                for(int i = 0; i < cantidadColumnas; i++){
                    
                    arreglo[i] = consulta.getObject(i + 1);
                }
                modelo.addRow(arreglo);
            }
            }
            
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

            
            
            
            
        
     
