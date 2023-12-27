
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
    
    private static String mensaje;
    private static String mensaje_2;
    private static String mensaje_3;
    
    public static String getMensaje() {
        return mensaje;
    }

    public static void setMensaje(String mensaje) {
        Implementacion_metodos.mensaje = mensaje;
    }

    public static String getMensaje_2() {
        return mensaje_2;
    }

    public static void setMensaje_2(String mensaje_2) {
        Implementacion_metodos.mensaje_2 = mensaje_2;
    }

    public static String getMensaje_3() {
        return mensaje_3;
    }

    public static void setMensaje_3(String mensaje_3) {
        Implementacion_metodos.mensaje_3 = mensaje_3;
    }
    
    
    
    
    // instanciamos la conxion para acceder a esta desde los metodos
    Conexion conexion = Conexion.getInstance();
    Connection conectar = conexion.conectar();
    

    //---------------------------- METODOS -------------------------------------
    
    //  AGREGAR ENTRADAS
    @Override
    public void agregar(Unidad_final hanzi_agregar, ventana_principal acceso) {
        
                Connection conectar = conexion.conectar();
        
        try{
            
            String nombre_entrada = "";         //  hanzi
            String simbolo = "";                //  hanzi
            String radical = "";                //  radical
            String radical_entrada = "";        //  radical
            String pinyin = "";                 //  pinyin
            String pinyin_entrada = "";         //  pinyin
            String traduccion = "";
            String ejemplo = "";
            
            Unidad_min aux;
            
            PreparedStatement agregar = conectar.prepareStatement("insert into hanzi_entrada (Radical, Hanzi, Fonetica, Traduccion, Ejemplo) "
                        + "values (?,?,?,?,?)");
            
            for(int i=0; i<hanzi_agregar.getObj().size(); i++){
                
                 // hacemos un cast instanciando un obj tipo unidad_min tomando uno igual de la posicion i de los almacenados en unidad_final
                aux = (Unidad_min) hanzi_agregar.getObj().get(i);  
                
                simbolo = aux.getSimbolo(); // tomamos el nombre del hanzi
                radical = aux.getRadical();
                pinyin  = aux.getPinyin();
                traduccion = aux.getTraduccion();
                ejemplo = aux.getEjemplo();

                nombre_entrada = nombre_entrada + simbolo;
                radical_entrada = radical_entrada + radical;
                pinyin_entrada = pinyin_entrada + " " +pinyin;
                
                System.out.println("en metodo AGREGAR nombre_entrada es " + nombre_entrada);
                System.out.println("y su radical es " + aux.getRadical());
                System.out.println("su pinyin es " + aux.getPinyin());

                agregar.setString(1, radical_entrada);
                agregar.setString(2, nombre_entrada);
                agregar.setString(3, pinyin_entrada);
                agregar.setString(4, traduccion);
                agregar.setString(5, ejemplo);
              
            }
            
            agregar.executeUpdate();  // va fuera del for o insertara en cada iteracion
            
            conexion.desconectar();
            
        }catch(SQLException e){
            
            e.printStackTrace();
            
        }
        }
           
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
            
            //  variables aux para el for --------------------------------------
            
            String recuperandoEntrada = "";
            String simbolo = "";
            Unidad_min aux = new Unidad_min();
            
            //System.out.println("el tamano es " + hanzi_aCorroborar.getObj().size());
            
            for(int i = 0; i<hanzi_aCorroborar.getObj().size(); i++){
                
                aux = (Unidad_min) hanzi_aCorroborar.getObj().get(i);
       
                // Acceder a los atributos de Unidad_min
                simbolo = aux.getSimbolo();
                
                recuperandoEntrada = recuperandoEntrada + simbolo;
                
            }
            
            //  ----------------------------------------------------------------
            
             //  buscamos en el campo
            PreparedStatement chequeandoExistencia = conectar.prepareStatement("SELECT * FROM hanzi_entrada WHERE Hanzi = ?");
            
             //  seteamos la instancia con el parametro del metodo, que sera el parametro de busqueda tambien
            chequeandoExistencia.setString(1, recuperandoEntrada);
            
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
    public boolean corroborarSingularidad(Unidad_min hanzi_ingresado) {
        
        Connection conectar = conexion.conectar();  // conectamos
        
        boolean hanzi_singular = false;  //  variable que retornaremos
        
        try{
            
            //  buscamos en el campo
            PreparedStatement corroborando_singularidad = conectar.prepareStatement("SELECT * FROM hanzi WHERE Hanzi = ?");
            
            //  seteamos la instancia con el parametro del metodo, que sera el parametro de busqueda tambien
            corroborando_singularidad.setString(1, hanzi_ingresado.getSimbolo());
            
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
    public void agregarSingularidades(Unidad_min hanzi) {
        
        try{
            
            Connection conectar = conexion.conectar();
            
            PreparedStatement agregar = conectar.prepareStatement("insert into hanzi (Hanzi, Pinyin, Radical) "
                        + "values (?,?,?)");

                agregar.setString(1, hanzi.getSimbolo());
                agregar.setString(2, hanzi.getPinyin());
                agregar.setString(3, hanzi.getRadical());
                
                agregar.executeUpdate();
                
                conexion.desconectar();
                
            }catch(Exception e){
                
                    e.printStackTrace();
                   
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

    //  COMPARA ENTRADA NUEVA Y PREEXISTENTE, EVITANDO DUPLICADOS Y COMPLETANDO LA INFORMACION FALTANTE A PARTIR DE A NUEVA
    @Override
    public void compararDuplicados(Unidad_final hanzi_aCorroborar, ventana_principal acceso) {
        
        try{
            
            Connection conectar = conexion.conectar();  // conectamos
            
            mensaje = "La entrada ya existe. ";
            mensaje_2 = "";
            mensaje_3 = "";
            
            
            //  CAPTURA DE LA ENTRADA DE USUARIO -------------------------------
            
            String simbolo_entrada = "";
            String pinyin_entrada = "";
            String radical_entrada = "";
            String traduccion_entrada = "";
            String ejemplo_entrada = "";
            
            String simbolo = "";
            String pinyin = "";
            String radical = "";
            String traduccion = "";
            String ejemplo = "";
            
            //  instanciamos nuevo obj para setearlo con las entradas ----------
            Unidad_min aux = new Unidad_min();  //  ENTRADA NUEVA
            
            //  recuperamos los atributos ingresados ---------------------------
            
            for(int i = 0; i<hanzi_aCorroborar.getObj().size(); i++){
                
                aux = (Unidad_min) hanzi_aCorroborar.getObj().get(i);

                // Acceder a los atributos de Unidad_min
                simbolo = aux.getSimbolo();
                pinyin = aux.getPinyin();
                radical = aux.getRadical();
                traduccion = aux.getTraduccion();
                ejemplo = aux.getEjemplo();
                
                System.out.println("el radical recuperado es " + radical);

                simbolo_entrada = simbolo_entrada + simbolo;
                pinyin_entrada = pinyin_entrada + " " + pinyin;
                radical_entrada = radical_entrada + radical;

            }
            
            //  RECUPERACION DE ENTRADA PREEXISTENTE ---------------------------
            
            //  buscamos en BD y seteamos un nuevo obj con lo preexistente------
            Unidad_min entrada_antigua = new Unidad_min();  //  ENTRADA ANTIGUA
            
            //  variables aux para recuperar de la bd --------------------------
            
            String valorCampo1 = "";
            String valorCampo2 = "";
            String valorCampo3 = "";
            String valorCampo4 = "";
            
            //  buscamos la entrada en la bd -----------------------------------
            PreparedStatement recuperando_bd = conectar.prepareStatement("SELECT Radical, Fonetica, Traduccion, Ejemplo FROM hanzi_entrada WHERE Hanzi = ?");
            
            //  seteamos la instancia con el parametro del metodo, que sera el parametro de busqueda tambien
            recuperando_bd.setString(1, simbolo_entrada);
            
            //  la consulta en si
            ResultSet consulta = recuperando_bd.executeQuery();
            
            // Recuperar información de distintos campos
            while (consulta.next()) {
                
                valorCampo1 = consulta.getString("Radical");
                valorCampo2 = consulta.getString("Fonetica");
                valorCampo3 = consulta.getString("Traduccion");
                valorCampo4 = consulta.getString("Ejemplo");
            }
            
            // seteamos con lo preexistente ------------------------------------
            
            entrada_antigua.setRadical(valorCampo1);    // seteamos un obj con valores preexistentes
            entrada_antigua.setPinyin(valorCampo2);
            entrada_antigua.setTraduccion(valorCampo3);
            entrada_antigua.setEjemplo(valorCampo4);
            
            //  ----------------------------------------------------------------
            //  COMPARACION, ELEMENTO A ELEMENTO ENTRE ENTRADAS ----------------
            //  ----------------------------------------------------------------
            
            
            //          --------------------------------------------------------
            //  RADICAL --------------------------------------------------------
            //          --------------------------------------------------------
            
            String radicalAntiguo = entrada_antigua.getRadical();
            String radical_final = "";
            String auxiliar_radical = "";
            String radicales_conservados = "";
            
            for(int i=0; i<radicalAntiguo.length(); i++){
                
                char radical_test = radicalAntiguo.charAt(i);
                
                System.out.println("radical_test fue " + radical_test);
                
                if(radical_test == '○'){
                    
                    radical_final += radical_entrada.charAt(i);
                    
                }else{
                    
                    radical_final += radical_test;
                    radicales_conservados += radical_test;
                    
                }
                
                System.out.println("el radical final va siendo " + radical_final);
                
            }
            
                PreparedStatement actualizar = conectar.prepareStatement(
                        "update hanzi_entrada set Radical = ? where Hanzi = ?");
                
                actualizar.setString(1, radical_final);
                actualizar.setString(2, simbolo_entrada);
                
                actualizar.executeUpdate();
                
                //  reporte de accion ------------------------------------------
                
                if (radical_entrada.equalsIgnoreCase("○")) {

                //mensaje += "La entrada ya existe";

            } else if (radical_entrada.equalsIgnoreCase("○○")) {

                //mensaje = "La entrada ya existe";

            } else if (radical_entrada.equalsIgnoreCase("○○○")) {

                //mensaje = "La entrada ya existe";

            } else if (radical_entrada.equalsIgnoreCase("○○○○")) {

                //mensaje = "La entrada ya existe";

            } else {

                mensaje_2 += "Se agregaron los radicales " + "【" + radical_entrada + "】, conservándose " + "【" + radicalAntiguo + "】. ";

            }
                
            //          --------------------------------------------------------
            //  PINYIN  --------------------------------------------------------
            //          --------------------------------------------------------
            
            if(entrada_antigua.getPinyin().contains("...") && !aux.getPinyin().isBlank() && !aux.getPinyin().contains("...")){  // PINYIN
                
                PreparedStatement actualizar_2 = conectar.prepareStatement(
                        "update hanzi_entrada set Fonetica = ? where Hanzi = ?");
                
                actualizar_2.setString(1, pinyin_entrada);
                actualizar_2.setString(2, simbolo_entrada);
                
                actualizar_2.executeUpdate();
                
                System.out.println("entro en el if de pinyin");
                
                mensaje_2 += "Se agregó su pinyin " + pinyin_entrada;
                
            }else if(!entrada_antigua.getPinyin().isBlank() && !entrada_antigua.getPinyin().contains("...") && !aux.getPinyin().contains("...")){
                
                //  queda lo viejo, ya que esto no MODIFICA, solo agrega info sobre vacios
                
                String pinyin_viejo = entrada_antigua.getPinyin();
                
                PreparedStatement actualizar_2 = conectar.prepareStatement(
                        "update hanzi_entrada set Fonetica = ? where Hanzi = ?");
                
                actualizar_2.setString(1, pinyin_viejo);
                actualizar_2.setString(2, simbolo_entrada);
                
                actualizar.executeUpdate();
                
                //  reporte de accion ------------------------------------------
                
                mensaje_2 += "Se conservó el pinyin original " + pinyin_viejo + ". ";
                
                //  ----------------------------------------------------------------
                
                System.out.println("entro en el if else de pinyin");
                
            }
            
            //              ----------------------------------------------------
            //  TRADUCCION  ----------------------------------------------------
            //              ----------------------------------------------------
            
            if(entrada_antigua.getTraduccion().isBlank() && !aux.getTraduccion().isBlank()){
                
                PreparedStatement actualizar_3 = conectar.prepareStatement(
                        "update hanzi_entrada set Traduccion = ? where Hanzi = ?");
                
                actualizar_3.setString(1, traduccion);
                actualizar_3.setString(2, simbolo_entrada);
                
                actualizar_3.executeUpdate();
                
                //  reporte de accion ------------------------------------------
                
                mensaje_3 += "Se agregó una traducción. ";
                
            }
            
            //              ----------------------------------------------------
            //  EJEMPLO     ----------------------------------------------------
            //              ----------------------------------------------------
            
            if(entrada_antigua.getEjemplo().isBlank() && !aux.getEjemplo().isBlank()){
                
                PreparedStatement actualizar_4 = conectar.prepareStatement(
                        "update hanzi_entrada set Ejemplo = ? where Hanzi = ?");
                
                actualizar_4.setString(1, ejemplo);
                actualizar_4.setString(2, simbolo_entrada);
                
                actualizar_4.executeUpdate();
                
                //  reporte de accion ------------------------------------------
                
                mensaje_3 += "Se agregó un ejemplo. ";
                
            }
            
            conexion.desconectar();
        
        }catch(SQLException e){
            
            e.printStackTrace();
            
        }
        
        
        
        
    }   //  FUNCIONANDO

    //  SOBRE LA TABLA SECUNDARIA COMPARA ENTRADAS NUEVAS Y PREEXISTENTES, EVITANDO DUPLICADOS Y COMPLETANDO LA INFORMACION FALTANTE A PARTIR DE A NUEVA
    @Override
    public void compararDuplicados_singular(Unidad_min hanzi_aCorroborar, ventana_principal acceso) {
        
        try{
            
            Connection conectar = conexion.conectar();  // conectamos
            
            //  ENTRADA NUEVA --------------------------------------------------
            
            hanzi_aCorroborar.getSimbolo();
            hanzi_aCorroborar.getPinyin();
            hanzi_aCorroborar.getRadical();
            
            
            //  RECUPERACION DE ENTRADA PREEXISTENTE ---------------------------
            
            //  buscamos en BD y seteamos un nuevo obj con lo preexistente------
            Unidad_min entrada_antigua = new Unidad_min();  //  ENTRADA ANTIGUA
            
            //  variables aux para recuperar de la bd --------------------------
            
            String valorCampo1 = "";
            String valorCampo2 = "";
            
            //  buscamos la entrada en la bd -----------------------------------
            PreparedStatement recuperando_bd = conectar.prepareStatement("SELECT Radical, Pinyin FROM hanzi WHERE Hanzi = ?");
            
            //  seteamos la instancia con el parametro del metodo, que sera el parametro de busqueda tambien
            recuperando_bd.setString(1, hanzi_aCorroborar.getSimbolo());
            
            //  la consulta en si
            ResultSet consulta = recuperando_bd.executeQuery();
            
            // Recuperar información de distintos campos
            while (consulta.next()) {
                
                valorCampo1 = consulta.getString("Radical");
                valorCampo2 = consulta.getString("Pinyin");
                
            }
            
            // seteamos con lo preexistente ------------------------------------
            
            entrada_antigua.setRadical(valorCampo1);    // seteamos un obj con valores preexistentes
            entrada_antigua.setPinyin(valorCampo2);
            
            
            //  ----------------------------------------------------------------
            //  COMPARACION, ELEMENTO A ELEMENTO ENTRE ENTRADAS ----------------
            //  ----------------------------------------------------------------
            
            //          --------------------------------------------------------
            //  RADICAL --------------------------------------------------------
            //          --------------------------------------------------------
            
            if(entrada_antigua.getRadical().equalsIgnoreCase("○")){
                
                PreparedStatement actualizar = conectar.prepareStatement(
                        "update hanzi set Radical = ? where Hanzi = ?");
                
                actualizar.setString(1, hanzi_aCorroborar.getRadical());
                actualizar.setString(2, hanzi_aCorroborar.getSimbolo());
                
                actualizar.executeUpdate();
                
            }
            
            //          --------------------------------------------------------
            //  PINYIN  --------------------------------------------------------
            //          --------------------------------------------------------
            
            if(entrada_antigua.getPinyin().contains("...")){  // PINYIN
                
                PreparedStatement actualizar_2 = conectar.prepareStatement(
                        "update hanzi set Pinyin = ? where Hanzi = ?");
                
                actualizar_2.setString(1, hanzi_aCorroborar.getPinyin());
                actualizar_2.setString(2, hanzi_aCorroborar.getSimbolo());
                
                actualizar_2.executeUpdate();
                
                System.out.println("entro en el if de pinyin");
                
            }
                
            conexion.desconectar();
        
        }catch(SQLException e){
            
            e.printStackTrace();
            
        }
        
    }   //  FUNCIONANDO

    //  AUTOCOMPLETA EL RADICAL EN TIEMPO REAL, SI ES QUE ESE HANZI YA EXISTE EN LA BD
    @Override
    public String autocompletarRadicales(Unidad_min hanzi_autocompletar) {
        
        String radical_seleccionado= "";
        
        Unidad_min auxiliar = new Unidad_min();
        
        try{
            
            Connection conectar = conexion.conectar();  // conectamos
            
            //  buscamos la entrada en la bd -----------------------------------
            PreparedStatement recuperando = conectar.prepareStatement("SELECT Radical FROM hanzi WHERE Hanzi = ?");
            
            //  seteamos la instancia con el parametro del metodo, que sera el parametro de busqueda tambien
            recuperando.setString(1, hanzi_autocompletar.getSimbolo());
            
            //  la consulta en si
            ResultSet consulta = recuperando.executeQuery();
            
            // Verificamos si hay algún resultado antes de intentar acceder a él
            if (consulta.next()) {
                
                radical_seleccionado = consulta.getString("Radical");   // recuperamos el string del campo "Radical"
                
            } 
            
        }catch(SQLException e){
            
            e.printStackTrace();
            
        }
        
        return radical_seleccionado;    // retornamos el string del campo radical
        
    }   //  FUNCIONANDO
    
    

}
        
     
