/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transversal.vista;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
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
//        BorrarFilasTabla();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tNotas = new javax.swing.JTable();
        jbGuardar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setText("Carga de Notas");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Alumno");

        cbAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAlumnoActionPerformed(evt);
            }
        });

        tNotas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tNotas);

        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jbCancelar.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(108, 108, 108))
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbAlumno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(79, 79, 79))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(jbGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbCancelar)
                .addContainerGap(112, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbGuardar)
                    .addComponent(jbCancelar))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAlumnoActionPerformed
        CargarDatosTabla();
    }//GEN-LAST:event_cbAlumnoActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbGuardarActionPerformed

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
       
        tNotas.setModel(modelo);
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JTable tNotas;
    // End of variables declaration//GEN-END:variables
}