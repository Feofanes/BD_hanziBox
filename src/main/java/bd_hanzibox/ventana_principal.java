
package bd_hanzibox;

import Entradas.Hanzi;
import Interfaces.Implementacion_metodos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ventana_principal extends javax.swing.JFrame {
    
    // tienen que ser static para poder set capturados desde implementacion_metodos
        static private String entradaHanzi;
        static private String entradaPinyin;
        static private String entradaTraduccion;
        static private String entradaEjemplo;
        static private String entradaRadical;
        static private String entradaRadical_2;
        static private String entradaRadical_3;
        static private String entradaRadical_4;
        
        static private String msj_advertencia;
        
        static private int n_hanzi_introducidos;
        
        private int n_input;
        
        
    //  CONSTRUCTOR
    public ventana_principal() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        this.setTitle("HanziBox");
        
        Implementacion_metodos aplicar = new Implementacion_metodos();
        
        n_input = aplicar.contarInput();
        
        jLabel_contador_entradas.setText("La base de datos cuenta con " + n_input + " entradas");
        
        limpiar_campos();
        
    }

    
    //  METODOS
    
    public void limpiar_campos(){
        
        jTextField_entrada.setText("");
        jTextField_pinyin.setText("");
        jTextField_traduccion.setText("");
        jTextField_ejemplo.setText("");
        jComboBox_radical.setSelectedItem("");
        jComboBox_radical_2.setSelectedItem("");
        jComboBox_radical_3.setSelectedItem("");
        jComboBox_radical_4.setSelectedItem("");
        
        //  queda pendiente limpiar el comboBox
        
        
    }   
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField3 = new javax.swing.JTextField();
        jProgressBar1 = new javax.swing.JProgressBar();
        jButton4 = new javax.swing.JButton();
        jLab_entrada = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLab_pinyin = new javax.swing.JLabel();
        jLab_traduccion = new javax.swing.JLabel();
        jTextField_entrada = new javax.swing.JTextField();
        jTextField_pinyin = new javax.swing.JTextField();
        jTextField_traduccion = new javax.swing.JTextField();
        jLab_ejemplo = new javax.swing.JLabel();
        jTextField_ejemplo = new javax.swing.JTextField();
        jComboBox_radical = new javax.swing.JComboBox<>();
        jButton_agregar = new javax.swing.JButton();
        jButton_borrar = new javax.swing.JButton();
        jButton_modificar = new javax.swing.JButton();
        jButton_buscar = new javax.swing.JButton();
        jLabel_advertencia = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        busqueda_resultados = new javax.swing.JTable();
        jLabel_contador_entradas = new javax.swing.JLabel();
        jComboBox_radical_2 = new javax.swing.JComboBox<>();
        jComboBox_radical_3 = new javax.swing.JComboBox<>();
        jComboBox_radical_4 = new javax.swing.JComboBox<>();

        jTextField3.setText("jTextField1");

        jButton4.setText("Modificar");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLab_entrada.setText("Entrada");

        jLabel2.setText("Radical");

        jLab_pinyin.setText("Pinyin");

        jLab_traduccion.setText("Traduccion");

        jTextField_entrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_entradaActionPerformed(evt);
            }
        });
        jTextField_entrada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_entradaKeyReleased(evt);
            }
        });

        jLab_ejemplo.setText("Ejemplo");

        jComboBox_radical.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"", "一", "口", "人" }));
        jComboBox_radical.setSelectedItem("");
        jComboBox_radical.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_radicalActionPerformed(evt);
            }
        });

        jButton_agregar.setText("Agregar");
        jButton_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_agregarActionPerformed(evt);
            }
        });

        jButton_borrar.setText("Borrar");
        jButton_borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_borrarActionPerformed(evt);
            }
        });

        jButton_modificar.setText("Modificar");
        jButton_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_modificarActionPerformed(evt);
            }
        });

        jButton_buscar.setText("Buscar");
        jButton_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_buscarActionPerformed(evt);
            }
        });

        busqueda_resultados.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        busqueda_resultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Radical", "Hanzi", "Fonetica", "Traduccion", "Ejemplo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        busqueda_resultados.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(busqueda_resultados);

        jLabel_contador_entradas.setText("La base de datos cuenta con:");

        jComboBox_radical_2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"", "一", "口", "人" }));
        jComboBox_radical_2.setSelectedItem("");
        jComboBox_radical_2.setEnabled(false);

        jComboBox_radical_3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"", "一", "口", "人" }));
        jComboBox_radical_3.setSelectedItem("");
        jComboBox_radical_3.setEnabled(false);

        jComboBox_radical_4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"", "一", "口", "人" }));
        jComboBox_radical_4.setSelectedItem("");
        jComboBox_radical_4.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel_contador_entradas)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel_advertencia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLab_traduccion)
                                            .addComponent(jLab_pinyin)
                                            .addComponent(jLab_entrada)
                                            .addComponent(jLab_ejemplo)
                                            .addComponent(jLabel2))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jTextField_traduccion, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                                                .addComponent(jTextField_ejemplo)
                                                .addComponent(jTextField_pinyin)
                                                .addComponent(jTextField_entrada))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jComboBox_radical, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jComboBox_radical_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jComboBox_radical_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(12, 12, 12)
                                                .addComponent(jComboBox_radical_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton_modificar)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton_buscar))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton_agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton_borrar)))))
                        .addGap(71, 71, 71))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jTextField_entrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLab_entrada)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox_radical, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox_radical_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_radical_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_radical_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLab_pinyin)
                    .addComponent(jTextField_pinyin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_agregar)
                    .addComponent(jButton_borrar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLab_traduccion)
                    .addComponent(jTextField_traduccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_buscar)
                    .addComponent(jButton_modificar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLab_ejemplo)
                    .addComponent(jTextField_ejemplo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jLabel_advertencia, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel_contador_entradas)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_entradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_entradaActionPerformed
        
        
        
        
         
        
        
        
    }//GEN-LAST:event_jTextField_entradaActionPerformed

    //  AGREGAR ENTRADAS A LA BD ---- FUNCIONANDO
    private void jButton_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_agregarActionPerformed
        
        //  PRIMERO CORROBORAR LA EXISTENCIA O NO DE LA ENTRADA ACTUAL
        
        Implementacion_metodos aplicar_metodo = new Implementacion_metodos();   // para usar los metodos
        Hanzi miHanzi = new Hanzi();    // creamos objeto
        
        entradaHanzi = jTextField_entrada.getText(); // capturamos la entrada en un string
        
        miHanzi.setIdiograma(entradaHanzi); //  usamos la captura para setear el objeto
        
        //  seteado el objeto le aplicamos el metodo para buscar el atributo en la BD. Devolvera true o false
        boolean hanziComprobado = aplicar_metodo.buscarExistencia(miHanzi.getIdiograma());  
        
        if(hanziComprobado == true){
            
            jLabel_advertencia.setText("La entrada ya existen en la Base de Datos");
            
        }else if(entradaHanzi.isBlank()){
            
            jLabel_advertencia.setText("Entrada invalida. Ingrese un Hanzi");
            
                    } else {

            //  capturamos las entradas
            entradaPinyin = jTextField_pinyin.getText();
            entradaTraduccion = jTextField_traduccion.getText();
            entradaEjemplo = jTextField_ejemplo.getText();
            entradaRadical = jComboBox_radical.getSelectedItem().toString();
            entradaRadical_2 = jComboBox_radical_2.getSelectedItem().toString();
            entradaRadical_3 = jComboBox_radical_3.getSelectedItem().toString();
            entradaRadical_4 = jComboBox_radical_4.getSelectedItem().toString();

            //  seteamos el objeto con las entradas
            miHanzi.setFonetica(entradaPinyin);
            miHanzi.setTraduccion(entradaTraduccion);
            miHanzi.setEjemplo(entradaEjemplo);
            
            //  este condicional es necesario de lo contrario los radicales quedan pegados sin saberse a que hanzi corresponden
            if(entradaRadical_2.isBlank()){ 
                
                entradaRadical_2 = "     ";
                
            }
            
            if(entradaRadical_3.isBlank()){
                
                entradaRadical_3 = "     ";
                
            }
            
            if(entradaRadical_4.isBlank()){
                
                entradaRadical_4 = "     ";
                
            }
            
            miHanzi.setRadical(entradaRadical + entradaRadical_2 + entradaRadical_3 + entradaRadical_4);

            aplicar_metodo.agregar(miHanzi);    //  agregamos la entrada

            jLabel_advertencia.setText("Entrada agregada a la Base de Datos");

        }

        limpiar_campos();
        
    }//GEN-LAST:event_jButton_agregarActionPerformed
    
    //  MODIFICAR ---- FUNCIONANDO
    private void jButton_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_modificarActionPerformed
        
        Hanzi miHanzi = new Hanzi();    // creamos objeto
        
        Implementacion_metodos aplicar_metodo = new Implementacion_metodos();   // para usar los metodos
        
        // las variables deben ser STATIC o seran NULL al ser llamadas desde la clase de metodos
        entradaHanzi = jTextField_entrada.getText(); // capturamos la entrada en un string
        entradaPinyin = jTextField_pinyin.getText();
        entradaTraduccion = jTextField_traduccion.getText();
        entradaEjemplo = jTextField_ejemplo.getText();
        entradaRadical = jComboBox_radical.getSelectedItem().toString();
        
        miHanzi.setIdiograma(entradaHanzi); //  usamos la captura para setear el objeto
        miHanzi.setFonetica(entradaPinyin);
        miHanzi.setTraduccion(entradaTraduccion);
        miHanzi.setEjemplo(entradaEjemplo);
        miHanzi.setRadical(entradaRadical);
        
        
        aplicar_metodo.modificar(miHanzi, this);  // aplicamos el metodo
        
        jLabel_advertencia.setText("Entrada " + miHanzi.getIdiograma() + " fue modificada");
        
        limpiar_campos();
        
    }//GEN-LAST:event_jButton_modificarActionPerformed

    //  BUSCAR Y MOSTRAR EN TABLA ---- FUNCIONANDO
    private void jButton_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_buscarActionPerformed
        
        //  creamos variables que seran parametros de busqueda
        entradaHanzi = jTextField_entrada.getText();
        entradaPinyin = jTextField_pinyin.getText();
        entradaTraduccion = jTextField_traduccion.getText();
        entradaRadical = jComboBox_radical.getSelectedItem().toString();
        
        String elemento_busqueda = "";
        String columna_de_busqueda = "";
        
        Implementacion_metodos aplicar_metodo = new Implementacion_metodos();   // para usar los metodos
        
        
        //  evaluamos que campo guiara la busqueda
        if(!entradaHanzi.isBlank() && entradaPinyin.isBlank() && entradaTraduccion.isBlank() && entradaRadical.isBlank()){
            
            elemento_busqueda = entradaHanzi;
            columna_de_busqueda = "Hanzi";
            
            //limpiar_campos();
            
        }else if(entradaHanzi.isBlank() && !entradaPinyin.isBlank() && entradaTraduccion.isBlank() && entradaRadical.isBlank()){
        
            elemento_busqueda = entradaPinyin;
            columna_de_busqueda = "Fonetica";
            //limpiar_campos();
            
        }else if(entradaHanzi.isBlank() && entradaPinyin.isBlank() && !entradaTraduccion.isBlank() && entradaRadical.isBlank()){
        
            elemento_busqueda = entradaTraduccion;
            columna_de_busqueda = "Traduccion";
            //limpiar_campos();
            
        }else if(entradaHanzi.isBlank() && entradaPinyin.isBlank() && entradaTraduccion.isBlank() && !entradaRadical.isBlank()){
        
            elemento_busqueda = entradaRadical;
            columna_de_busqueda = "Radical";
            //limpiar_campos();
            
        }else if(entradaHanzi.isBlank() && entradaPinyin.isBlank() && entradaTraduccion.isBlank() && entradaRadical.isBlank()){
            
            jLabel_advertencia.setText("Se muestra toda la base de datos");
            elemento_busqueda = "";
            columna_de_busqueda = "Ninguna";
            
        }else{
            
            //limpiar_campos();
            
            jLabel_advertencia.setText("Introduzca un solo parametro de busqueda");
            elemento_busqueda = null;
            
        }
        
        System.out.println("en ventana_principal elemento_busqueda: " + elemento_busqueda);
        System.out.println("en ventana_principal entradaHanzi: " + entradaHanzi);
        System.out.println("en ventana_principal la columna donde se buscara sera: " + columna_de_busqueda);
        
        
        aplicar_metodo.mostrarTabla(elemento_busqueda, this);
        
        
       
    }//GEN-LAST:event_jButton_buscarActionPerformed

    //  BORRAR ELEMENTOS DE LA TABLA
    private void jButton_borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_borrarActionPerformed
        
        //  creamos variables que seran parametros de busqueda
        entradaHanzi = jTextField_entrada.getText();
        entradaPinyin = jTextField_pinyin.getText();
        entradaTraduccion = jTextField_traduccion.getText();
        entradaEjemplo = jTextField_ejemplo.getText();
        entradaRadical = jComboBox_radical.getSelectedItem().toString();
        
        
        Hanzi miHanzi = new Hanzi();    // instanciamos el obj para setear con la entrada
        
        miHanzi.setIdiograma(entradaHanzi); //  seteamos con la entrada
        
        Implementacion_metodos aplicar_metodo = new Implementacion_metodos();   // para usar los metodos
        
        if(!entradaHanzi.isBlank() && entradaPinyin.isBlank() && entradaTraduccion.isBlank() && entradaEjemplo.isBlank() && entradaRadical.isBlank()){
            
            aplicar_metodo.borrar(miHanzi, this);   //  eliminamos con el Hanzi como unico parametro
            
        }else{
            
            jLabel_advertencia.setText("Introduzca solo el hanzi a eliminar");
            
        } 
        
        
    }//GEN-LAST:event_jButton_borrarActionPerformed

    
    //  HABILITAR LOS COMBO DE ACUERDO AL NUMERO DE HANZI INGRESADO (1-4)
    private void jTextField_entradaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_entradaKeyReleased
        
        jTextField_entrada.getDocument().addDocumentListener(new DocumentListener(){
            
            @Override
            public void insertUpdate(DocumentEvent e) {
                
                contarHanzi_introducidos();
                
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                
                contarHanzi_introducidos();
                
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                
                contarHanzi_introducidos();
                
            }
            
            private void contarHanzi_introducidos(){
                
                entradaHanzi = jTextField_entrada.getText();
                int n_hanzi_introducidos = entradaHanzi.length();
                System.out.println("El número de hanzi escritos es de " + n_hanzi_introducidos);

                if (n_hanzi_introducidos == 1) {
                    System.out.println("entradaHanzi tiene " + n_hanzi_introducidos + " caracter");
                    
                    jComboBox_radical_2.setEnabled(false);
                    jComboBox_radical_3.setEnabled(false);
                    jComboBox_radical_4.setEnabled(false);
                    
                } else if (n_hanzi_introducidos == 2) {
                    
                    jComboBox_radical_2.setEnabled(true);
                    jComboBox_radical_3.setEnabled(false);
                    jComboBox_radical_4.setEnabled(false);

                    
                    System.out.println("entradaHanzi tiene " + n_hanzi_introducidos + " caracteres");
                } else if (n_hanzi_introducidos == 3) {
                    
                    jComboBox_radical_3.setEnabled(true);
                    jComboBox_radical_4.setEnabled(false);
                    
                    System.out.println("entradaHanzi tiene " + n_hanzi_introducidos + " caracteres");
                } else if (n_hanzi_introducidos == 4) {
                    
                    jComboBox_radical_4.setEnabled(true);
                    jComboBox_radical_2.setEnabled(true);
                    jComboBox_radical_3.setEnabled(true);
                    
                    
                    
                    
                    System.out.println("entradaHanzi tiene " + n_hanzi_introducidos + " caracteres");
                }
        
        }
            
    });
        
        /*
        hay que implementar KeyEvent para que el evento sea la misma escritura, 
        caso contrario hay que presionar Enter en tras escribir algo como para que 
        empiece a registrar el input
        */
        
        
        
        
    }//GEN-LAST:event_jTextField_entradaKeyReleased

    

    private void jComboBox_radicalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_radicalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_radicalActionPerformed
    
    
    //  GETTERS AND SETTERS ----------------------------------------------------
    //--------------------------------------------------------------------------
    
    public JButton getjButton4() {
        return jButton4;
    }

    public void setjButton4(JButton jButton4) {
        this.jButton4 = jButton4;
    }

    public JButton getjButton_agregar() {
        return jButton_agregar;
    }

    public void setjButton_agregar(JButton jButton_agregar) {
        this.jButton_agregar = jButton_agregar;
    }

    public JButton getjButton_borrar() {
        return jButton_borrar;
    }

    public void setjButton_borrar(JButton jButton_borrar) {
        this.jButton_borrar = jButton_borrar;
    }

    public JButton getjButton_buscar() {
        return jButton_buscar;
    }

    public void setjButton_buscar(JButton jButton_buscar) {
        this.jButton_buscar = jButton_buscar;
    }

    public JButton getjButton_modificar() {
        return jButton_modificar;
    }

    public void setjButton_modificar(JButton jButton_modificar) {
        this.jButton_modificar = jButton_modificar;
    }

    public JComboBox<String> getjComboBox_radical() {
        return jComboBox_radical;
    }

    public void setjComboBox_radical(JComboBox<String> jComboBox_radical) {
        this.jComboBox_radical = jComboBox_radical;
    }

    public JLabel getjLab_ejemplo() {
        return jLab_ejemplo;
    }

    public void setjLab_ejemplo(JLabel jLab_ejemplo) {
        this.jLab_ejemplo = jLab_ejemplo;
    }

    public JLabel getjLab_entrada() {
        return jLab_entrada;
    }

    public void setjLab_entrada(JLabel jLab_entrada) {
        this.jLab_entrada = jLab_entrada;
    }

    public JLabel getjLab_pinyin() {
        return jLab_pinyin;
    }

    public void setjLab_pinyin(JLabel jLab_pinyin) {
        this.jLab_pinyin = jLab_pinyin;
    }

    public JLabel getjLab_traduccion() {
        return jLab_traduccion;
    }

    public void setjLab_traduccion(JLabel jLab_traduccion) {
        this.jLab_traduccion = jLab_traduccion;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public JLabel getjLabel_advertencia() {
        return jLabel_advertencia;
    }

    public void setjLabel_advertencia(JLabel jLabel_advertencia) {
        this.jLabel_advertencia = jLabel_advertencia;
    }

    public JProgressBar getjProgressBar1() {
        return jProgressBar1;
    }

    public void setjProgressBar1(JProgressBar jProgressBar1) {
        this.jProgressBar1 = jProgressBar1;
    }

    public JTextField getjTextField3() {
        return jTextField3;
    }

    public void setjTextField3(JTextField jTextField3) {
        this.jTextField3 = jTextField3;
    }

    public JTextField getjTextField_ejemplo() {
        return jTextField_ejemplo;
    }

    public void setjTextField_ejemplo(JTextField jTextField_ejemplo) {
        this.jTextField_ejemplo = jTextField_ejemplo;
    }

    public JTextField getjTextField_entrada() {
        return jTextField_entrada;
    }

    public void setjTextField_entrada(JTextField jTextField_entrada) {
        this.jTextField_entrada = jTextField_entrada;
    }

    public JTextField getjTextField_pinyin() {
        return jTextField_pinyin;
    }

    public void setjTextField_pinyin(JTextField jTextField_pinyin) {
        this.jTextField_pinyin = jTextField_pinyin;
    }

    public JTextField getjTextField_traduccion() {
        return jTextField_traduccion;
    }

    public String getEntradaHanzi() {
        return entradaHanzi;
    }

    public void setEntradaHanzi(String entradaHanzi) {
        this.entradaHanzi = entradaHanzi;
    }

    public String getEntradaPinyin() {
        return entradaPinyin;
    }

    public void setEntradaPinyin(String entradaPinyin) {
        this.entradaPinyin = entradaPinyin;
    }

    public String getEntradaTraduccion() {
        return entradaTraduccion;
    }

    public void setEntradaTraduccion(String entradaTraduccion) {
        this.entradaTraduccion = entradaTraduccion;
    }

    public String getEntradaEjemplo() {
        return entradaEjemplo;
    }

    public void setEntradaEjemplo(String entradaEjemplo) {
        this.entradaEjemplo = entradaEjemplo;
    }

    public String getEntradaRadical() {
        return entradaRadical;
    }

    public void setEntradaRadical(String entradaRadical) {
        this.entradaRadical = entradaRadical;
    }
    
    public void setjTextField_traduccion(JTextField jTextField_traduccion) {
        this.jTextField_traduccion = jTextField_traduccion;
    }

    public static JTable getBusqueda_resultados() {
        return busqueda_resultados;
    }

    public static void setBusqueda_resultados(JTable busqueda_resultados) {
        ventana_principal.busqueda_resultados = busqueda_resultados;
    }

    public static String getMsj_advertencia() {
        return msj_advertencia;
    }

    public static void setMsj_advertencia(String msj_advertencia) {
        ventana_principal.msj_advertencia = msj_advertencia;
    }
    
    
    
    
    //  GETTERS AND SETTERS ----------------------------------------------------

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
            java.util.logging.Logger.getLogger(ventana_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventana_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventana_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventana_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ventana_principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTable busqueda_resultados;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton_agregar;
    private javax.swing.JButton jButton_borrar;
    private javax.swing.JButton jButton_buscar;
    private javax.swing.JButton jButton_modificar;
    private javax.swing.JComboBox<String> jComboBox_radical;
    private javax.swing.JComboBox<String> jComboBox_radical_2;
    private javax.swing.JComboBox<String> jComboBox_radical_3;
    private javax.swing.JComboBox<String> jComboBox_radical_4;
    private javax.swing.JLabel jLab_ejemplo;
    private javax.swing.JLabel jLab_entrada;
    private javax.swing.JLabel jLab_pinyin;
    private javax.swing.JLabel jLab_traduccion;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel_advertencia;
    private javax.swing.JLabel jLabel_contador_entradas;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField_ejemplo;
    private javax.swing.JTextField jTextField_entrada;
    private javax.swing.JTextField jTextField_pinyin;
    private javax.swing.JTextField jTextField_traduccion;
    // End of variables declaration//GEN-END:variables

    
        

    


}
