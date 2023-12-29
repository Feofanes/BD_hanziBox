
package bd_hanzibox;

import Entradas.Unidad_final;
import Entradas.Unidad_min;
import Interfaces.Implementacion_metodos;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class procesador_texto extends javax.swing.JFrame {
    
    static private String entradaSeleccionada;

    //  CONSTRUCTOR
    public procesador_texto() {
        
        initComponents();
        
        this.setLocationRelativeTo(null);
        this.setTitle("Procesador de Texto");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        busqueda_resultados = new javax.swing.JTable();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jButton_volver = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        pane_texto = new javax.swing.JTextPane();
        jToolBar1 = new javax.swing.JToolBar();
        Buscar = new javax.swing.JButton();
        jButton_agregar = new javax.swing.JButton();
        jButton_analisis = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jButton_agrandar_texto = new javax.swing.JButton();
        jButton_achicar_texto = new javax.swing.JButton();
        jButton_justificar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        resultados_seleccion = new javax.swing.JTable();
        mensaje_1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        busqueda_resultados.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        busqueda_resultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Radical", "Hanzi", "Fonetica", "Traduccion", "Ejemplo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(busqueda_resultados);

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton_volver.setText("Volver");
        jButton_volver.setToolTipText("Volver al inicio");
        jButton_volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_volverActionPerformed(evt);
            }
        });

        pane_texto.setDragEnabled(true);
        jScrollPane1.setViewportView(pane_texto);
        // COPIADO Y PEGADO --------------------------------------------------------

        // Crear menú emergente para copiar y pegar
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem copiar = new JMenuItem(new DefaultEditorKit.CopyAction());
        JMenuItem pegar = new JMenuItem(new DefaultEditorKit.PasteAction());

        copiar.setText("Copiar");
        pegar.setText("Pegar");

        popupMenu.add(copiar);
        popupMenu.add(pegar);

        pane_texto.setComponentPopupMenu(popupMenu);

        jToolBar1.setFloatable(true);
        jToolBar1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jToolBar1.setRollover(true);
        jToolBar1.setToolTipText("");

        Buscar.setIcon(new javax.swing.ImageIcon("/Users/nahuellaluce/NetBeansProjects/BD_hanziBox/src/main/java/bd_hanzibox/iconos/lupa.png")); // NOI18N
        //Buscar.setIcon(new ImageIcon("/Users/nahuellaluce/NetBeansProjects/BD_hanziBox/src/main/java/bd_hanzibox/iconos/lupa.png"));
        Buscar.setToolTipText("Buscar palabra seleccionada en base de datos");
        Buscar.setFocusable(false);
        Buscar.setVisible(true);
        Buscar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Buscar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });
        jToolBar1.add(Buscar);

        jButton_agregar.setIcon(new javax.swing.ImageIcon("/Users/nahuellaluce/NetBeansProjects/BD_hanziBox/src/main/java/bd_hanzibox/iconos/agregar.png")); // NOI18N
        jButton_agregar.setToolTipText("Agregar texto seleccionado a base de datos");
        jButton_agregar.setFocusable(false);
        jButton_agregar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_agregar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_agregarActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton_agregar);

        jButton_analisis.setIcon(new javax.swing.ImageIcon("/Users/nahuellaluce/NetBeansProjects/BD_hanziBox/src/main/java/bd_hanzibox/iconos/analizador.png")); // NOI18N
        jButton_analisis.setToolTipText("Resalta en rojo los hanzis nuevos");
        jButton_analisis.setFocusable(false);
        jButton_analisis.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_analisis.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton_analisis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_analisisActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton_analisis);
        jToolBar1.add(jSeparator1);

        jButton_agrandar_texto.setIcon(new javax.swing.ImageIcon("/Users/nahuellaluce/NetBeansProjects/BD_hanziBox/src/main/java/bd_hanzibox/iconos/agrandar.png")); // NOI18N
        jButton_agrandar_texto.setToolTipText("Agrandar texto");
        jButton_agrandar_texto.setFocusable(false);
        jButton_agrandar_texto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_agrandar_texto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton_agrandar_texto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_agrandar_textoActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton_agrandar_texto);

        jButton_achicar_texto.setIcon(new javax.swing.ImageIcon("/Users/nahuellaluce/NetBeansProjects/BD_hanziBox/src/main/java/bd_hanzibox/iconos/achicar.png")); // NOI18N
        jButton_achicar_texto.setToolTipText("Achicar texto");
        jButton_achicar_texto.setFocusable(false);
        jButton_achicar_texto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_achicar_texto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton_achicar_texto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_achicar_textoActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton_achicar_texto);

        jButton_justificar.setIcon(new javax.swing.ImageIcon("/Users/nahuellaluce/NetBeansProjects/BD_hanziBox/src/main/java/bd_hanzibox/iconos/justificar.png")); // NOI18N
        jButton_justificar.setToolTipText("Justificar texto");
        jButton_justificar.setFocusable(false);
        jButton_justificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_justificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton_justificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_justificarActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton_justificar);

        resultados_seleccion.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        resultados_seleccion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Radical", "Hanzi", "Fonetica", "Traduccion", "Ejemplo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane4.setViewportView(resultados_seleccion);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(mensaje_1, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_volver)
                        .addGap(14, 14, 14))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addGap(36, 36, 36))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton_volver))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mensaje_1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14))
        );

        jMenu1.setText("File");
        jMenu1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jMenu1AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    Implementacion_metodos aplicar_metodo = new Implementacion_metodos();
    
    //  ----------------------------- METODOS ----------------------------------
    
    public void limpiar_campos2(){
        
        mensaje_1.setText("");
        
        
    }   //  LIMPIAR
    
    public void agrandar_texto(JTextPane texto){
        
        StyledDocument doc = texto.getStyledDocument();
        MutableAttributeSet attrs = texto.getInputAttributes();

        // Obtiene el tamaño actual de la fuente
        int tamanioActual = StyleConstants.getFontSize(attrs);

        // Aumenta el tamaño de la fuente
        int nuevoTamanio = tamanioActual + 2; // Puedes ajustar el valor según tus preferencias
        StyleConstants.setFontSize(attrs, nuevoTamanio);

        // Aplica el nuevo AttributeSet al documento
        doc.setCharacterAttributes(0, doc.getLength(), attrs, false);
    }   // AGRANDAR TEXTO
    
    public void achicar_texto(JTextPane texto){
        
        StyledDocument doc = texto.getStyledDocument();
        MutableAttributeSet attrs = texto.getInputAttributes();

        // Obtiene el tamaño actual de la fuente
        int tamanioActual = StyleConstants.getFontSize(attrs);

        // Reduce el tamaño de la fuente
        int nuevoTamanio = Math.max(tamanioActual - 2, 1); // Evita tamaños negativos y 0
        StyleConstants.setFontSize(attrs, nuevoTamanio);

        // Aplica el nuevo AttributeSet al documento
        doc.setCharacterAttributes(0, doc.getLength(), attrs, false);
    
    }   //  ACHICAR TEXTO
    
    private static void justificarTexto(JTextPane texto) {
        StyledDocument doc = texto.getStyledDocument();
        SimpleAttributeSet attrs = new SimpleAttributeSet();
        StyleConstants.setAlignment(attrs, StyleConstants.ALIGN_JUSTIFIED);
        doc.setParagraphAttributes(0, doc.getLength(), attrs, false);
    }   //  JUSTIFICAR
        
        
    
    
    
    
    //  BOTON PARA VOLVER A MENU PRINCIPAL
    private void jButton_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_volverActionPerformed
        
        ventana_principal voler_menu = new ventana_principal();
        
        voler_menu.setVisible(true);
        
        dispose();
        
        
    }//GEN-LAST:event_jButton_volverActionPerformed

    //  BOTON BUSQUEDA DE LO SELECCIONADO EN EL JTEXTPANE
    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
        
        String texto_seleccionado = pane_texto.getSelectedText();
        
        boolean registro_nuevo = aplicar_metodo.buscarSeleccion(texto_seleccionado);
         
        if(registro_nuevo == false){
            
            mensaje_1.setText("El elemento seleccionado no está en la base de datos");
             
        }else{
        
        limpiar_campos2();
        
        }
        
    }//GEN-LAST:event_BuscarActionPerformed

    //  BOTON PARA AGREGAR ALGO SELECCIONADO
    private void jButton_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_agregarActionPerformed
        
        //  --------------------------------------------------------------------
        //  -------------------- TABLA PRINCIPAL -------------------------------
        //  --------------------------------------------------------------------
        
        String texto_seleccionado = pane_texto.getSelectedText();
        
        //  usamos "Unidad_min" para setear "Unidad_final"  --------------------
            Unidad_final entrada_final = new Unidad_final();    //  instanciamos el obj final, la sintesis de la expresion 

        
        if(texto_seleccionado.length() <= 4){
            
            // CAPTURA DE ENTRADAS  --------------------------------------------
        
            int n_hanzi_entrada = texto_seleccionado.length();    // num de hanzi introducidos
            
            //  evitamos que den null los parametros ---------------------------
            
            
            ArrayList<Unidad_min> conjunto_semantico = new ArrayList<>(); //  creamos un array con obj hanzi
        
            String [] h_coleccion = texto_seleccionado.split("");
            
            String hanzi_iterado ="";
            
            //  set del obj  "Unidad_min" --------------------------------------
            
            for(int i=0; i<h_coleccion.length; i++){    //  iteramos tantas veces como hanzi tenga la entrada
                
                Unidad_min unidad_semantica = new Unidad_min(); //  instanciamos nuevo obj
                
                hanzi_iterado = h_coleccion[i];  // aux para rescatar el hanzi en la posicion actual
               
                unidad_semantica.setSimbolo(hanzi_iterado); //  el nuevo obj seteado para hanzi
                unidad_semantica.setRadical("○");
                unidad_semantica.setPinyin("...");
                
                conjunto_semantico.add(unidad_semantica);   //  almacenamos los obj seteados en un arraylist, que sera parametro para setear el obj final
                
            }
            
            //  --------------------------------------------------------------------
            
            entrada_final.setObj(conjunto_semantico);   // esta seria la entrada en su total, con cada hanzi, pinyin y radical

            
        //  CORROBORAR QUE LA ENTRADA ACTUAL NO EXISTA PREVIAMENTE EN LA TABLA PRINCIPAL
        
        Implementacion_metodos aplicar_metodo = new Implementacion_metodos();   // para usar los metodos

        boolean hanziComprobado = aplicar_metodo.buscarExistenciaProcesador(entrada_final, this);  //  seteado el objeto le aplicamos el metodo para buscar el atributo en la BD. Devolvera true o false

        
        //  AGREGAR A LA BD HANZI_ENTRADA SI SE COMPROBO QUE NO EXISTE YA 
        
        
        //  informamos la entrada agregada -------------------------------------
        String reporteHanzi = "";
        
        for(int i = 0; i<h_coleccion.length; i++){
                
                reporteHanzi += h_coleccion[i];
                
            }
        //  --------------------------------------------------------------------
        
        if(hanziComprobado == false){
            
            // recuperamos la entrada original en su totalidad (entrada_final)
            
            aplicar_metodo.agregar(entrada_final);    //  agregamos la entrada
            
            mensaje_1.setText("Se agregó " + reporteHanzi + " a la base de datos");
            
            //  ----------------------------------------------------------------
           
        
        }else{
            
            mensaje_1.setText("El elemento seleccionado ya existe en la base de datos");
            
        }
        
        }else{
            
            mensaje_1.setText("El elemento seleccionado es demasiado grande para agregarse");
            
        
        }
        
        //  --------------------------------------------------------------------
        //  -------------------- TABLA SECUNDARIA ------------------------------
        //  --------------------------------------------------------------------
        
        
        //  iteracion recuperando cada elemento de entrada y analizandolo ------
        
        for(int i=0; i < entrada_final.getObj().size(); i++){
            
            Unidad_min auxiliar = new Unidad_min(); // aux para recuperar c/u de los obj constituyentes de entrada_final
        
            auxiliar = (Unidad_min)entrada_final.getObj().get(i);   // cast en cada iteracion
            
            auxiliar.getSimbolo();  // recuperacion de los atributos
            auxiliar.setRadical("○");
            auxiliar.setPinyin("...");
            
            //  COMPROBACION DE EXISTENCIA PREVIA EN BD ------------------------
            
            boolean comprobacion = aplicar_metodo.corroborarSingularidad(auxiliar);    // devolvera true (ya existe) o false (no existe)
            
            //  AGREGACION A BD ------------------------------------------------
            
            if(!comprobacion){
                
                aplicar_metodo.agregarSingularidades(auxiliar);
                
            }
            
            //  DE EXISTIR COMPLETA LA INFO PREEXISTENTE CON LA ENTRADA NUEVA --
            
            if(comprobacion){
                
                aplicar_metodo.compararDuplicados_singular(auxiliar);
                
            }
            
        }
        
        
    }//GEN-LAST:event_jButton_agregarActionPerformed

    private void jMenu1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jMenu1AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1AncestorAdded

    //  AGRANDAR TEXTO
    private void jButton_agrandar_textoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_agrandar_textoActionPerformed
        
        agrandar_texto(pane_texto);
        
        
        
    }//GEN-LAST:event_jButton_agrandar_textoActionPerformed

    //  ACHICAR TEXTO
    private void jButton_achicar_textoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_achicar_textoActionPerformed
        
        achicar_texto(pane_texto);
        
        
    }//GEN-LAST:event_jButton_achicar_textoActionPerformed

    //  JUSTIFICAR TEXTO
    private void jButton_justificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_justificarActionPerformed
        
        justificarTexto(pane_texto);
        
    }//GEN-LAST:event_jButton_justificarActionPerformed

    //  ANALIZADOR DE CADA HANZI DEL TEXTO
    private void jButton_analisisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_analisisActionPerformed
        
        Implementacion_metodos aplicar = new Implementacion_metodos();
        
        
        aplicar.analizadorTexto(pane_texto, this);
        
        
        
        
    }//GEN-LAST:event_jButton_analisisActionPerformed

    //  ------------------------ GETTERS and SETTERS ---------------------------
    
    public JLabel getMensaje_1() {
        return mensaje_1;
    }

    public void setMensaje_1(JLabel mensaje_1) {
        this.mensaje_1 = mensaje_1;
    }

    public JTextPane getPane_texto() {
        return pane_texto;
    }

    public void setPane_texto(JTextPane pane_texto) {
        this.pane_texto = pane_texto;
    }
    
    

    
    
    
    
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(procesador_texto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(procesador_texto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(procesador_texto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(procesador_texto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new procesador_texto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Buscar;
    public static javax.swing.JTable busqueda_resultados;
    private javax.swing.JButton jButton_achicar_texto;
    private javax.swing.JButton jButton_agrandar_texto;
    private javax.swing.JButton jButton_agregar;
    private javax.swing.JButton jButton_analisis;
    private javax.swing.JButton jButton_justificar;
    private javax.swing.JButton jButton_volver;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel mensaje_1;
    private javax.swing.JTextPane pane_texto;
    public static javax.swing.JTable resultados_seleccion;
    // End of variables declaration//GEN-END:variables
}
