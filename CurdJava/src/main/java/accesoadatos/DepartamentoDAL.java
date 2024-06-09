/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesoadatos;

import entidades.Departamento;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author MINEDUCYT
 */
public class DepartamentoDAL {
    public static ArrayList<Departamento> obtenerTodos() {
        ArrayList<Departamento> departamentos = new ArrayList<>();
        try (Connection conn = ComunDB.obtenerConexion()) {
            String sql = "SELECT DepartamentoID, Nombre, Descripcion FROM Departamentos";           
            try (PreparedStatement statement = conn.prepareStatement(sql)) {                              
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        int departamentoId = resultSet.getInt("DepartamentoID");
                        String nombre = resultSet.getString("Nombre");
                        String descripcion = resultSet.getString("Descripcion");                       
                        Departamento departamento = new Departamento(departamentoId,nombre,descripcion );
                        departamentos.add(departamento);
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException("Error al obtener las categorias", e);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener la conexión a la base de datos", e);
        }
        return departamentos;
    }
    
    public static int crear(Departamento empleado) {
        try (Connection conn = ComunDB.obtenerConexion()) {

            String sql = "INSERT INTO Departamentos (Nombre, Descripcion) VALUES (?, ?)";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setString(1, empleado.getNombre());
                statement.setString(2, empleado.getDescripcion());
                int rowsAffected = statement.executeUpdate();
                return rowsAffected;
            } catch (SQLException e) {
                throw new RuntimeException("Error al crear el producto", e);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener la conexión a la base de datos", e);
        }
    }
    public static int modificar(Departamento departamento) {
        try (Connection conn = ComunDB.obtenerConexion()) {

            String sql = "UPDATE Departamentos SET Nombre=?, Descripcion=?";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setString(1, departamento.getNombre());
                statement.setString(2, departamento.getDescripcion());
                int rowsAffected = statement.executeUpdate();
                return rowsAffected;
            } catch (SQLException e) {
                throw new RuntimeException("Error al crear el producto", e);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener la conexión a la base de datos", e);
        }
    }
    
    public static int eliminar(Departamento departamento) {
        try (Connection conn = ComunDB.obtenerConexion()) {

            String sql = "DELETE FROM Empleados WHERE EmpleadoID=?";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setInt(1, departamento.getDepatamentoId());
                int rowsAffected = statement.executeUpdate();
                return rowsAffected;
            } catch (SQLException e) {
                throw new RuntimeException("Error al crear el producto", e);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener la conexión a la base de datos", e);
        }
    }
    
    public static ArrayList<Departamento> buscar(Departamento empleadoSearch) {
        ArrayList<Departamento> empleados = new ArrayList<>();
        try (Connection conn = ComunDB.obtenerConexion()) {
            String sql = "SELECT Nombre , Descripcion FROM Departamentos";
            sql+=" WHERE Nombre LIKE ? ";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setString(1, "%" + empleadoSearch.getNombre() + "%");
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        Departamento empleado = new Departamento();
                        empleado.setDepartamentoId(resultSet.getInt("EmpleadoID"));
                        empleado.setNombre(resultSet.getString("Nombre"));
                        empleado.setDescripcion(resultSet.getString("Apellido"));
                        
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
