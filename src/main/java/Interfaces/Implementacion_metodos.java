
package Interfaces;

import Entradas.Hanzi;
import Entradas.Hanzi_molde;
import Entradas.Unidad_final;
import Entradas.Unidad_min;
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
    Connection conectar = conexion.conectar();
    

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
            String infoHanzi = acceso.getEntradaHanzi();
            
            String infoRadical = acceso.getEntradaRadical();
            String infoRadical_2 = acceso.getEntradaRadical_2();
            String infoRadical_3 = acceso.getEntradaRadical_3(); 
            String infoRadical_4 = acceso.getEntradaRadical_4();
            
            String todos_radicales = acceso.getTotal_radicales().toString();
            
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

            //if (!todos_radicales.isBlank()) {

                PreparedStatement modificar = conectar.prepareStatement(
                        "update hanzi_entrada set Radical = ? where Hanzi = ?");

                modificar.setString(1, todos_radicales);
                modificar.setString(2, infoHanzi);
                modificar.executeUpdate();

            //}
            
            System.out.println("esto en metodos " + todos_radicales);
            

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
    public boolean buscarExistencia(Unidad_final hanzi_aCorroborar, ventana_principal acceso) {
        
        Connection conectar = conexion.conectar();  // conectamos
        
        boolean registroExistente = false;  //  variable que retornaremos
        
        try{
            
            
            String recuperandoEntrada = "";
            String simbolo = "";
            Unidad_min aux = new Unidad_min();
            
            System.out.println("el tamano es " + hanzi_aCorroborar.getObj().size());
            
            for(int i = 0; i<hanzi_aCorroborar.getObj().size(); i++){
                
                aux = (Unidad_min) hanzi_aCorroborar.getObj().get(i);
       
                // Acceder a los atributos de Unidad_min
                simbolo = aux.getSimbolo();
                
               recuperandoEntrada = recuperandoEntrada + simbolo;
                
                System.out.println("simbolo recuperado es " + recuperandoEntrada);
                
            }
            
            
             //  buscamos en el campo
            PreparedStatement chequeandoExistencia = conectar.prepareStatement("SELECT * FROM hanzi_entrada WHERE Hanzi = ?");
            
            
            //System.out.println(prueba);
            
            
             //  seteamos la instancia con el parametro del metodo, que sera el parametro de busqueda tambien
            chequeandoExistencia.setString(1, hanzi_aCorroborar.toString());
            
            //  la consulta en si
            ResultSet consulta = chequeandoExistencia.executeQuery();
            
            //  cambiamos el valor de la instancia de retorno segun corresponda a la busqueda
            if(consulta.next()){
                
                registroExistente = true;
                
                System.out.println("Encontro que ya esta");
                
            }else{
                
                registroExistente = false;
                
                System.out.println("No lo encontro");
                
            }
            
            conexion.desconectar();
            
        }catch(SQLException e){
            
            e.printStackTrace();
            
        }
        
        
        /*
        
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
        */
        
        return registroExistente;
        
    }   //  FUNCIONANDO

    //  MOSTRAR BUSQUEDA EN TABLA
    @Override
    public void mostrarTabla(String columna_busqueda, ventana_principal acceso) {
        
        try{
            
            String elemento_busqueda = acceso.getParametro_busqueda();
            
            DefaultTableModel modelo = new DefaultTableModel(); //  modelamos la tabla

            busqueda_resultados.setModel(modelo);
            
            busqueda_resultados.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            
            Connection conexionMySQL = conexion.conectar();
            
            if(columna_busqueda == null){
                
                //System.out.println("error");
                
                acceso.setMsj_advertencia("Introduzca un solo parametro de busqueda");
                
            }else if(columna_busqueda.isBlank()){
                
                try{
                
                PreparedStatement seleccion = conexionMySQL.prepareStatement("SELECT * from hanzi_entrada");
            
                ResultSet consulta = seleccion.executeQuery();
                
                    //System.out.println("Entro en el condicional de TODO");
                
                
                ResultSetMetaData datos = consulta.getMetaData();
            int cantidadColumnas = datos.getColumnCount();
            
            //modelo.addColumn("Codigo");
            modelo.addColumn("Radical");
            modelo.addColumn("Hanzi");
            modelo.addColumn("Fonetica");
            modelo.addColumn("Traduccion");
            modelo.addColumn("Ejemplo");
            
            //int anchos [] = {40, 40, 40, 40, 40};
            
            for(int i = 0; i < cantidadColumnas; i++){
                
                busqueda_resultados.getColumnModel().getColumn(i);
                
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
            
            //modelo.addColumn("Codigo");
            modelo.addColumn("Radical");
            modelo.addColumn("Hanzi");
            modelo.addColumn("Fonetica");
            modelo.addColumn("Traduccion");
            modelo.addColumn("Ejemplo");
            
            //int anchos [] = {40, 40, 40, 40, 40};
            
            for(int i = 0; i < cantidadColumnas; i++){
                
                busqueda_resultados.getColumnModel().getColumn(i);
                
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

    //  CONSTATA QUE EL HANZI INGRESADO NO EXISTA PREVIAMENTE EN LA TABLA "HANZI"
    @Override
    public boolean corroborarSingularidad(Hanzi hanzi_ingresado) {
        
        Connection conectar = conexion.conectar();  // conectamos
        
        boolean hanzi_singular = false;  //  variable que retornaremos
        
        //String aux = hanzi_ingresado.getIdiograma_conjunto().toString();
        
        try{
            
            //  buscamos en el campo
            PreparedStatement corroborando_singularidad = conectar.prepareStatement("SELECT * FROM hanzi WHERE Hanzi = ?");
            
            //  seteamos la instancia con el parametro del metodo, que sera el parametro de busqueda tambien
            corroborando_singularidad.setString(1, hanzi_ingresado.getIdiograma());
            
            //  la consulta en si
            ResultSet consulta = corroborando_singularidad.executeQuery();
            
            //  cambiamos el valor de la instancia de retorno segun corresponda a la busqueda
            if(consulta.next()){
                
                hanzi_singular = true;
                
            }else{
                
                hanzi_singular = false;
                
            }
            
            conexion.desconectar();
            
        }catch(SQLException e){
            
            e.printStackTrace();
            
        }
        
        return hanzi_singular;
        
    }   //  FUNCIONANDO

    //  AGREGA A "HANZI" DE MANERA INDIVIDUALIZADA CADA HANZI CON SU RADICAL Y PINYIN
    @Override
    public void agregarSingularidades(Hanzi hanzi) {
        
        try{
            
            Connection conectar = conexion.conectar();
            
            if(!hanzi.getRadical().isEmpty() && hanzi.getFonetica().isEmpty()){
                
                PreparedStatement agregar = conectar.prepareStatement("insert into hanzi (Hanzi, Radical) "
                        + "values (?,?)");

                agregar.setString(1, hanzi.getIdiograma());
                agregar.setString(2, hanzi.getRadical().toString());
                
                System.out.println("entro en 1");
                System.out.println("el idiograma llego como " + hanzi.getIdiograma());
                System.out.println("el radical llego al primer condicional como " + hanzi.getRadical().toString());
                
                agregar.executeUpdate();
                
            }else if(hanzi.getRadical().isEmpty() && hanzi.getFonetica().isEmpty()){
                
                PreparedStatement agregar = conectar.prepareStatement("insert into hanzi (Hanzi) "
                        + "values (?)");

                agregar.setString(1, hanzi.getIdiograma());
            
                agregar.executeUpdate();
                
                System.out.println("entro en 2");
            
            }else{
                
                PreparedStatement agregar = conectar.prepareStatement("insert into hanzi (Hanzi, Pinyin, Radical) "
                        + "values (?,?,?)");

                agregar.setString(1, hanzi.getIdiograma());
                agregar.setString(2, hanzi.getFonetica().toString());
                agregar.setString(3, hanzi.getRadical().toString());
                
                 System.out.println("el radical llego al tercer como " + hanzi.getRadical().toString());
                  System.out.println("el pinyin llego al tercer como " + hanzi.getFonetica().toString());
                
                agregar.executeUpdate();
                
                System.out.println("entro en 3");
                
            }
            
            /*
            if(!hanzi.getFonetica().isEmpty()){
                
                PreparedStatement agregar = conectar.prepareStatement("insert into hanzi (Hanzi, Pinyin) "
                        + "values (?,?)");

                agregar.setString(1, hanzi.getIdiograma());
                agregar.setString(2, hanzi.getFonetica());
                
                agregar.executeUpdate();
            */
            
            
            
                conexion.desconectar();
                
            }catch(Exception e){
                
                    e.printStackTrace();
                    
                    //System.out.println("Error en metodo agregar singularidad");
        
        }
        
        
        
        
    }   //  FUNCIONANDO

    //  CONTAR LA CANTIDAD DE HANZIS UNICOS QUE HAY
    @Override
    public int contarHanziUnicos() {
        
        int registros_encontrados = 0;
        
        try{
            
            Connection conectar = conexion.conectar();
            
                PreparedStatement agregar = conectar.prepareStatement("Select COUNT(Hanzi) from hanzi");
                
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

    //  MODIFICAR RADICAL O PINYIN EN TABLA HANZI
    @Override
    public void modificarSingularidad(Hanzi hanzi, ventana_principal acceso) {
        
        try{
            
            String infoHanzi = acceso.getEntradaHanzi();
            String infoPinyin = acceso.getEntradaPinyin();
            
            String infoRadical = acceso.getEntradaRadical();
            String infoRadical_2 = acceso.getEntradaRadical_2();
            String infoRadical_3 = acceso.getEntradaRadical_3(); 
            String infoRadical_4 = acceso.getEntradaRadical_4();
            
            System.out.println("en la ventana de metodos el hanzi introducido fue " + infoHanzi);
            
            // solo modificara en los campos donde se ingreso informacion
            if (infoPinyin != null && !infoPinyin.isBlank()) {

                PreparedStatement modificar = conectar.prepareStatement(
                        "update hanzi set Pinyin = ? where Hanzi = ?");

                modificar.setString(1, infoPinyin);
                modificar.setString(2, infoHanzi);
                modificar.executeUpdate();
                
            }
                
              if (!infoRadical.isBlank()) {

                PreparedStatement modificarRad_01 = conectar.prepareStatement(
                        "update hanzi set Radical = ? where Hanzi = ?");

                modificarRad_01.setString(1, infoRadical);
                modificarRad_01.setString(2, infoHanzi);
                modificarRad_01.executeUpdate();
                
                System.out.println("entro en el condicional para modificar radical");

            }

            if (!infoRadical_2.isBlank()) {

                PreparedStatement modificarRad_02 = conectar.prepareStatement(
                        "update hanzi set Radical = ? where Hanzi = ?");

                modificarRad_02.setString(1, infoRadical_2);
                modificarRad_02.setString(2, infoHanzi);
                modificarRad_02.executeUpdate();

            }

            if (!infoRadical_3.isBlank()) {

                PreparedStatement modificarRad_03 = conectar.prepareStatement(
                        "update hanzi set Radical = ? where Hanzi = ?");

                modificarRad_03.setString(1, infoRadical_3);
                modificarRad_03.setString(2, infoHanzi);
                modificarRad_03.executeUpdate();

            }

            if (!infoRadical_4.isBlank()) {

                PreparedStatement modificarRad_04 = conectar.prepareStatement(
                        "update hanzi set Radical = ? where Hanzi = ?");

                modificarRad_04.setString(1, infoRadical_4);
                modificarRad_04.setString(2, infoHanzi);
                modificarRad_04.executeUpdate();

            }
            
            conexion.desconectar();

        }catch(SQLException e){
            
            e.printStackTrace();;
            
        }
        
        
        
        
        
    }
}

            
            
            
            
        
     
