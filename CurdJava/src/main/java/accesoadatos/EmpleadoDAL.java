/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesoadatos;

import entidades.Departamento;
import entidades.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author MINEDUCYT
 */
public class EmpleadoDAL {
    
    public static int crear(Empleado empleado) {
        try (Connection conn = ComunDB.obtenerConexion()) {

            String sql = "INSERT INTO Empleados (Nombre, Apellido, Cargo, Precio, DepartamentoID) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setString(1, empleado.getNombre());
                statement.setString(2, empleado.getApellido());
                statement.setString(3, empleado.getCargo());
                statement.setDouble(4, empleado.getSalario());
                statement.setInt(5, empleado.getDepartamentoId());
                int rowsAffected = statement.executeUpdate();
                return rowsAffected;
            } catch (SQLException e) {
                throw new RuntimeException("Error al crear el producto", e);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener la conexión a la base de datos", e);
        }
    }
    
    
    public static int modificar(Empleado empleado) {
        try (Connection conn = ComunDB.obtenerConexion()) {

            String sql = "UPDATE Empleados SET Nombre=?, Apellido=?, Cargo=? ,Salario=?, DepartamentoID=? WHERE EmpleadoID=?";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setString(1, empleado.getNombre());
                statement.setString(2, empleado.getApellido());
                statement.setString(3, empleado.getCargo());
                statement.setDouble(4, empleado.getSalario());
                statement.setInt(5, empleado.getDepartamentoId());
                statement.setInt(6, empleado.getEmpleadoId());
                int rowsAffected = statement.executeUpdate();
                return rowsAffected;
            } catch (SQLException e) {
                throw new RuntimeException("Error al crear el producto", e);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener la conexión a la base de datos", e);
        }
    }
    
    
    public static int eliminar(Empleado empledo) {
        try (Connection conn = ComunDB.obtenerConexion()) {

            String sql = "DELETE FROM Empleados WHERE EmpleadoID=?";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setInt(1, empledo.getEmpleadoId());
                int rowsAffected = statement.executeUpdate();
                return rowsAffected;
            } catch (SQLException e) {
                throw new RuntimeException("Error al crear el producto", e);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener la conexión a la base de datos", e);
        }
    }
    
    
    public static ArrayList<Empleado> buscar(Empleado empleadoSearch) {
        ArrayList<Empleado> empleados = new ArrayList<>();
        try (Connection conn = ComunDB.obtenerConexion()) {
            String sql = "SELECT p.EmpleadoID, p.Nombre, p.Apellido, p.Cargo, p.Salario, p.DepartamentoID, c.Nombre AS NombreDep FROM Empleados p";
             sql+=" INNER JOIN Departamentos c ON c.DepartamentoID= p.DepartamentoID  ";
            sql+=" WHERE p.Nombre LIKE ? ";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setString(1, "%" + empleadoSearch.getNombre() + "%");
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        Empleado empleado = new Empleado();
                        empleado.setEmpleadoId(resultSet.getInt("EmpleadoID"));
                        empleado.setNombre(resultSet.getString("Nombre"));
                        empleado.setApellido(resultSet.getString("Apellido"));
                        empleado.setCargo(resultSet.getString("Cargo"));
                        empleado.setSalario(resultSet.getDouble("Salario"));
                        empleado.setDepartamentoId(resultSet.getInt("DepartamentoID"));
                        Departamento departamento= new Departamento();
                        departamento.setNombre(resultSet.getString("NombreDep"));
                        empleado.setDepartamento(departamento);
                        empleados.add(empleado);
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException("Error al buscar productos", e);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener la conexión a la base de datos", e);
        }
        return empleados;
    }
}
