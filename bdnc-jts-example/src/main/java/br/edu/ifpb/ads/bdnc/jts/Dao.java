package br.edu.ifpb.ads.bdnc.jts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @version 1.0
 * @author Wensttay de Sousa Alencar <yattsnew@gmail.com>
 * @date 07/01/2017 - 12:01:31
 */
public class Dao {

    String url = "jdbc:postgresql://localhost:5432/TestPostGis";
    String user = "postgres";
    String password = "12345";
    String driver = "org.postgresql.Driver";
    Connection connection;

    public void conectar() throws SQLException, ClassNotFoundException {
        if (connection == null || connection.isClosed()) {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
        }
    }

    public boolean consuta(String sql) {
        boolean valid = false;
        
        try {
            conectar();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                if (rs.getBoolean("Verdadeiro")) {
                    valid = true;
                }
            }
            
            return valid;
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        
        return valid;
    }
}
