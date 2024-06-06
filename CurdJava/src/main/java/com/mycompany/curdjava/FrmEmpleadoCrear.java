/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.curdjava;


import utilerias.OpcionesCRUD;
import javax.swing.JOptionPane;
import utilerias.OpcionesCRUD;
import entidades.Empleado;
import accesoadatos.EmpleadoDAL;
import accesoadatos.DepartamentoDAL;
import entidades.Departamento;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.DefaultComboBoxModel;
import static utilerias.OpcionesCRUD.CREAR;
import static utilerias.OpcionesCRUD.ELIMINAR;
import static utilerias.OpcionesCRUD.MODIFICAR;

/**
 *
 * @author MINEDUCYT
 */
public class FrmEmpleadoCrear extends javax.swing.JFrame {

    private OpcionesCRUD opcionCRUD;
    private Empleado empleadActual = new Empleado();
    private HashMap<Integer, Departamento> mapDepartamento = new HashMap<Integer,Departamento>();
    /**
     * Creates new form FrmEmpleadoCrear
     */
    public FrmEmpleadoCrear(OpcionesCRUD opcion, Empleado empleado) {
        this.opcionCRUD = opcion;
        initComponents();
        ArrayList<Departamento> departamento = DepartamentoDAL.obtenerTodos();
        DefaultComboBoxModel<Departamento> modelCombox = new DefaultComboBoxModel(departamento.toArray());
        for (Departamento cat : departamento) {
            mapDepartamento.put(cat.getDepatamentoId(), cat);
        }
        ComboDepartamento.setModel(modelCombox);
        if (opcion != OpcionesCRUD.CREAR) {
            asingarDatos(empleado);
            empleadActual = empleado;
        }
    }
    
    private Empleado ObtenerDatos() {
        Empleado producto = new Empleado();
        producto.setNombre(txtNombre.getText());
        producto.setApellido(txtApellido.getText());
        producto.setCargo(txtCargo.getText());
        producto.setSalario(Double.parseDouble(txtSalario.getText()));
        Departamento categoria = (Departamento) ComboDepartamento.getSelectedItem();
        producto.setDepartamentoId(categoria.getDepatamentoId());
        producto.setEmpleadoId(empleadActual.getEmpleadoId());
        return producto;
    }
    private void asingarDatos(Empleado empleado) {
        txtNombre.setText(empleado.getNombre());
        txtApellido.setText(empleado.getApellido());
        txtCargo.setText(empleado.getCargo());
        txtSalario.setText(Double.toString(empleado.getSalario()));
        // Categoria categoria = producto.getCategoria(); 
        Departamento departamento = mapDepartamento.get(empleado.getDepartamentoId());
        ComboDepartamento.setSelectedItem(departamento);
    }

    
    private void crearReg() {
        try {
            Empleado empleado = ObtenerDatos();
            int result = EmpleadoDAL.crear(empleado);
            if (result > 0) {
                JOptionPane.showMessageDialog(this,
                        "El producto fue registrado existosamente", "CREAR PRODUCTO",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Sucedio un error al crear el producto", "ERROR PRODUCTO",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    ex.getMessage(), "ERROR PRODUCTO",
                    JOptionPane.ERROR_MESSAGE);
        }

    }
    
    private void modificarReg() {
        try {
            Empleado empleado = ObtenerDatos();
            int result = EmpleadoDAL.modificar(empleado);
            if (result > 0) {
                JOptionPane.showMessageDialog(this,
                        "El producto fue modificado existosamente", "MODIFICAR PRODUCTO",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Sucedio un error al modificar el producto", "ERROR PRODUCTO",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    ex.getMessage(), "ERROR PRODUCTO",
                    JOptionPane.ERROR_MESSAGE);
        }

    }
     private void eliminarReg() {
        try {
            Empleado empleado = ObtenerDatos();
            int result = EmpleadoDAL.eliminar(empleado);
            if (result > 0) {
                JOptionPane.showMessageDialog(this,
                        "El producto fue eliminado existosamente", "ELIMINAR PRODUCTO",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Sucedio un error al eliminar el producto", "ERROR PRODUCTO",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    ex.getMessage(), "ERROR PRODUCTO",
                    JOptionPane.ERROR_MESSAGE);
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCargo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtSalario = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        ComboDepartamento = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nombre :");

        jLabel2.setText("Apellido :");

        jLabel3.setText("Cargo :");

        jLabel4.setText("Salario :");

        jLabel5.setText("Departamento :");

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        ComboDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboDepartamentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1)
                        .addComponent(jLabel4))
                    .addComponent(btnGuardar))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ComboDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtSalario, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                                .addComponent(txtCargo, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtApellido, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING)))))
                .addContainerGap(104, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(ComboDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
         this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
         if (null != opcionCRUD) // TODO add your handling code here:
            switch (opcionCRUD) {
                case CREAR:
                    crearReg();
                    this.setVisible(false);
                    break;
                case MODIFICAR:
                    modificarReg();
                    this.setVisible(false);
                    break;
                case ELIMINAR:
                    eliminarReg();
                    this.setVisible(false);
                    break;
                default:
                    break;
            }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void ComboDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboDepartamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboDepartamentoActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Departamento
    > ComboDepartamento;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCargo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtSalario;
    // End of variables declaration//GEN-END:variables
}
