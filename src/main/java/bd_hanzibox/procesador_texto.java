
package bd_hanzibox;

import Interfaces.Implementacion_metodos;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class procesador_texto extends javax.swing.JFrame {

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
        jPanel1 = new javax.swing.JPanel();
        jButton_volver = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        pane_texto = new javax.swing.JTextPane();
        jToolBar1 = new javax.swing.JToolBar();
        Buscar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        resultados_seleccion = new javax.swing.JTable();
        mensaje_1 = new javax.swing.JLabel();

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton_volver.setText("Volver");
        jButton_volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_volverActionPerformed(evt);
            }
        });

        pane_texto.setDragEnabled(true);
        jScrollPane1.setViewportView(pane_texto);

        jToolBar1.setFloatable(true);
        jToolBar1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jToolBar1.setRollover(true);

        Buscar.setText("Buscar");
        Buscar.setFocusable(false);
        Buscar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Buscar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });
        jToolBar1.add(Buscar);

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
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
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
        
        
    }
    
    
    
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

    
    
    //  ------------------------ GETTERS and SETTERS ---------------------------
    
    public JLabel getMensaje_1() {
        return mensaje_1;
    }

    public void setMensaje_1(JLabel mensaje_1) {
        this.mensaje_1 = mensaje_1;
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
    private javax.swing.JButton jButton_volver;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel mensaje_1;
    private javax.swing.JTextPane pane_texto;
    public static javax.swing.JTable resultados_seleccion;
    // End of variables declaration//GEN-END:variables
}
