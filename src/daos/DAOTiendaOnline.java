/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import Objects.Usuario;
import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

/**
 *
 * @author MULTI
 */
public class DAOTiendaOnline {

    DataSource ds;

    public DAOTiendaOnline() throws ClassNotFoundException, SQLException {
        // DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
    }

    public DAOTiendaOnline(DataSource ds) {
        this.ds = ds;
    }

    public Connection abrirConexion() throws SQLException {
        Connection conn;
        conn = ds.getConnection();
        return conn;
    }

    public void cerrarConexion(Connection conn) throws SQLException {
        conn.close();
    }

    public boolean altaUsuario(Usuario user) throws SQLException {

        Connection conn = abrirConexion();

        String sql = "Insert into USERS USUARIO,CONTRASENA values(?,?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(0, user.getUser());
            ps.setString(1, user.getPassword());
            int numRows = ps.executeUpdate();
            if (numRows > 0) {
                return true;
            }
        } catch (SQLException e) {

        }
        return false;
    }

    public Usuario verificarUsuario(String u, String p) throws SQLException {

        Connection conn = abrirConexion();

        String sql = "Select * from USERS Where USUARIO=? and CONTRASENA =?";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, u);
        ps.setString(2, p);
        System.out.println("%%%%%%%%%%%%%%%  " + sql);
        System.err.println("Usuario = " + u);
        System.err.println("Contrasena = " + p);
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
            
            return new Usuario(u, p);
        }
        return null;
    }
}
