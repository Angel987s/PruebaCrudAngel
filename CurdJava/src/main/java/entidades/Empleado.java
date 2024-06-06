/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author MINEDUCYT
 */
public class Empleado {
    private int empleadoId;
    private String nombre;
    private String apellido;
    private String cargo;
    private double salario;
    private int departamentoId;
    
    private Departamento departamento;

    public Empleado() {
    }
    
    public Empleado(int empleadoId, String nombre, String apellido,String cargo, double salario, int departamentoId, Departamento departamento) {
        this.empleadoId = empleadoId;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
        this.salario = salario;
        this.departamentoId = departamentoId;
        this.departamento = departamento;
    }
    
    public int getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(int empleadoId) {
        this.empleadoId = empleadoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
     public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getDepartamentoId() {
        return departamentoId;
    }

    public void setDepartamentoId(int departamentoId) {
        this.departamentoId = departamentoId;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}
