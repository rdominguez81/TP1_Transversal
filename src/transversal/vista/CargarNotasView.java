/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transversal.vista;

//import com.oracle.webservices.internal.api.databinding.DatabindingModeFeature; //LO COMENTE PORQUE ME DA ERROR
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import tranversal.controlador.AlumnoData;
import tranversal.controlador.Conexion;
import tranversal.controlador.CursadaData;
import tranversal.controlador.MateriaData;
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
    private ArrayList<Materia> listaMaterias;
    private ArrayList<Cursada> listaCursada;
    private CursadaData cursadaData;
    private AlumnoData alumnoData;
    private MateriaData materiaData;
    private Conexion con;

    
    public CargarNotasView() {
        initComponents();
        
        con = new Conexion();
        
        modelo = new DefaultTableModel();
        
        alumnoData = new AlumnoData(con);
        listaAlumnos = (ArrayList)alumnoData.obtenerAlumnos();
        
        materiaData = new MateriaData(con);
        listaMaterias = (ArrayList)materiaData.obtenerMaterias();
        
        cursadaData = new CursadaData(con);
        listaCursada = (ArrayList)cursadaData.obtenerCursadas();
        
        modelo = new DefaultTableModel();
        
        CargarAlumnos();
        ArmarCabeceraTabla();
        CargarDatosTabla();
        BorrarFilasTabla();
        
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
        cbAlumno = new javax.swing.JComboBox<>();
        jbGuardar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jbLimpiar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtNotas = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Carga de Notas");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Alumno");

        cbAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAlumnoActionPerformed(evt);
            }
        });

        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jbCancelar.setText("Cancelar");

        jbLimpiar.setText("Limpiar");
        jbLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimpiarActionPerformed(evt);
            }
        });

        jtNotas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Notas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jtNotas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbAlumno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(79, 79, 79))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addComponent(jbGuardar)
                .addGap(18, 18, 18)
                .addComponent(jbCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCancelar)
                    .addComponent(jbLimpiar)
                    .addComponent(jbGuardar))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAlumnoActionPerformed
        CargarDatosTabla();
    }//GEN-LAST:event_cbAlumnoActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        
        //FALTA TERMINAR
        /* 
        TableModel tabla = jtNotas.getModel();
        int columna = jtNotas.getSelectedColumn();
        int fila = jtNotas.getSelectedRow();
        
        Object nota = tabla.getValueAt(columna, fila);
        
        int idMateria = jtNotas.getSelectedColumn();
        
        Cursada cursada = new Cursada();
        cursadaData.actualizarNotaCursada(idAlumno, idMateria, nota);
        */
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jbLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimpiarActionPerformed
        BorrarFilasTabla();
    }//GEN-LAST:event_jbLimpiarActionPerformed

    private void CargarAlumnos()
    {
        for(Alumno alumno : listaAlumnos){
            cbAlumno.addItem(alumno);
        }
    }
    private void ArmarCabeceraTabla()
    {
        ArrayList<Object> columnas = new ArrayList();
        
        columnas.add("ID");
        columnas.add("Nombre");
        columnas.add("Nota");
        
        for(Object it : columnas)
            modelo.addColumn(it);
       
        jtNotas.setModel(modelo);
    }
    private void BorrarFilasTabla()
    {
        int a = modelo.getRowCount()-1;
        for(int i = a; i >= 0; i--)
            modelo.removeRow(i);
    }
    private void CargarDatosTabla()
    {
        BorrarFilasTabla();
        
        Alumno alumno = (Alumno)cbAlumno.getSelectedItem();
        
        for(Cursada cursada : listaCursada){
            if(cursada.getAlumno().getId()==alumno.getId()){
                modelo.addRow(new Object[]{
                    cursada.getAlumno().getId(),
                    cursada.getMateria(),
                    cursada.getNota()});
            }
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Alumno> cbAlumno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbLimpiar;
    private javax.swing.JTable jtNotas;
    // End of variables declaration//GEN-END:variables
}
