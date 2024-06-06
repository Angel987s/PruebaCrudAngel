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
}
