/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transversal.vista;

//import com.oracle.webservices.internal.api.databinding.DatabindingModeFeature; //LO COMENTE PORQUE ME DA ERROR
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import tranversal.controlador.AlumnoData;
import tranversal.controlador.Conexion;
import tranversal.controlador.CursadaData;
import tranversal.modelo.Alumno;
import tranversal.modelo.Cursada;
import tranversal.modelo.Materia;

/**
 *
 * @author Pablo
 */
public class CargarNotasView extends javax.swing.JInternalFrame {
    
    private DefaultTableModel modelo;
    private ArrayList<Alumno> listaAlumnos;
    private ArrayList<Cursada> listaCursada;
    private CursadaData cursadaData;
    private AlumnoData alumnoData;
    private Conexion con;

    
    public CargarNotasView() {
        initComponents();
        try {
            con = new Conexion();
            
            alumnoData = new AlumnoData(con);
            listaAlumnos = (ArrayList)alumnoData.obtenerAlumnos();
            cursadaData = new CursadaData(con);
            listaCursada = (ArrayList)cursadaData.obtenerCursadas();
            
            modelo = new DefaultTableModel();
            
            cargarCbAlumnos();
            armarCabeceraTabla();
            
        } catch (Exception ex) {
            
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jCAlumnos = new javax.swing.JComboBox<>();
        jBGuardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTAlumnos = new javax.swing.JTable();
        jBCancelar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setText("Carga de Notas");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Alumno");

        jCAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCAlumnosActionPerformed(evt);
            }
        });

        jBGuardar.setText("Guardar");
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });

        jTAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTAlumnos);

        jBCancelar.setText("Cancelar");
        jBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jBGuardar)
                        .addGap(43, 43, 43)
                        .addComponent(jBCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBGuardar)
                    .addComponent(jBCancelar))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCAlumnosActionPerformed
        borrarFilasTabla();
        cargarDatosTabla();
    }//GEN-LAST:event_jCAlumnosActionPerformed

    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed
        actualizarNota();
    }//GEN-LAST:event_jBGuardarActionPerformed

    private void jBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarActionPerformed
        // TODO add your handling code here:
        borrarFilasTabla();
    }//GEN-LAST:event_jBCancelarActionPerformed

    private void cargarCbAlumnos()
    {
        for(Alumno alumno : listaAlumnos){
            jCAlumnos.addItem(alumno);
        }
    }
    
    private void armarCabeceraTabla()
    {
        ArrayList<Object> columnas = new ArrayList<>();
        columnas.add("ID");
        columnas.add("Materia");
        columnas.add("Nota");
        
        for(Object it : columnas)
            modelo.addColumn(it);
        
        jTAlumnos.setModel(modelo);
    }
    
    private void cargarDatosTabla()
    {
        Alumno a = (Alumno)jCAlumnos.getSelectedItem();
        listaCursada = (ArrayList)cursadaData.obtenerCursadasXAlumno(a.getId());
        
        for(Cursada c : listaCursada){
            modelo.addRow(new Object[]{c.getMateria().getId(), c.getMateria().getNombre(), c.getNota()});
        }
    }
    
    private void borrarFilasTabla()
    {
        int a  = modelo.getRowCount()-1;
        for(int i  = a; i>= 0; i--){
            modelo.removeRow(i);
        }
    }
    
    private void actualizarNota()
    {
        try {
            int filaSeleccionadas = jTAlumnos.getSelectedRow();
            if(filaSeleccionadas != -1){
                Alumno alumno = (Alumno)jCAlumnos.getSelectedItem();
                int idMateria = (Integer) modelo.getValueAt(filaSeleccionadas, 0);
                int nota = Integer.parseInt((String)modelo.getValueAt(filaSeleccionadas, 2));
                
                cursadaData.actualizarNotaCursada(alumno.getId(), idMateria, nota);
                JOptionPane.showMessageDialog(null, "Nota modificada para alumno: "+ alumno.toString());
                
                borrarFilasTabla();
                
            }else{
                JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
                jTAlumnos.requestFocus();
            }
        } catch (Exception e) {
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBCancelar;
    private javax.swing.JButton jBGuardar;
    private javax.swing.JComboBox<Alumno> jCAlumnos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTAlumnos;
    // End of variables declaration//GEN-END:variables
}
