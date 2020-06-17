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
 * @author Arezlon
 */
public class AlumnosPorMateriaView extends javax.swing.JInternalFrame {
    private Conexion con;
    private ArrayList<Cursada> listaCursada;
    private ArrayList<Materia> listaMaterias;
    private ArrayList<Alumno> listaAlumnos;
    private CursadaData cursadaData;
    private MateriaData materiaData;
    private AlumnoData alumnoData;
    private DefaultTableModel modelo;

    /**
     * Creates new form AlumnosPorMateriaView
     */
    public AlumnosPorMateriaView() {
        initComponents();
        con = new Conexion();
        modelo = new DefaultTableModel();
        cursadaData = new CursadaData(con);
        listaCursada = (ArrayList)cursadaData.obtenerCursadas();
        materiaData = new MateriaData(con);
        listaMaterias = (ArrayList)materiaData.obtenerMaterias();
        alumnoData = new AlumnoData(con);
        listaAlumnos=(ArrayList)alumnoData.obtenerAlumnos();
        
        cargarDesplegableMaterias();
        armarEncabezadosTabla();
        cargarDatos();
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
        jCbMaterias = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTAlumnos = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Alumnos por materia");

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Listado de alumnos por materia");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Materia:");

        jCbMaterias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCbMateriasActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(113, 113, 113)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCbMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jCbMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cargarDesplegableMaterias(){
        for (Materia mat:listaMaterias) {
            jCbMaterias.addItem(mat);
        }
    }
    
    private void armarEncabezadosTabla(){
        ArrayList<Object> columnas = new ArrayList<Object>();
        columnas.add("ID Alumno");
        columnas.add("Nombre");
        columnas.add("Nota");
        
        for(Object columna:columnas){
            modelo.addColumn(columna);
        }
        jTAlumnos.setModel(modelo);
    }
    
    private void borrarFilas(){ //vaciar tabla
        int cantidadFilas = modelo.getRowCount()-1;
        for(int i=cantidadFilas; i>=0; i--){
            modelo.removeRow(i);
        }
    }
    
    private void cargarDatos(){
        borrarFilas();
        Materia mat = (Materia)jCbMaterias.getSelectedItem();
        for(Cursada m:listaCursada){
            if(m.getMateria().getId() == mat.getId()){
                modelo.addRow(new Object[]{m.getAlumno().getId(), m.getAlumno().getNombre(), m.getNota()});
            }
        }
    }
    
    private void jCbMateriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCbMateriasActionPerformed
        cargarDatos();
    }//GEN-LAST:event_jCbMateriasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Materia> jCbMaterias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTAlumnos;
    // End of variables declaration//GEN-END:variables
}
