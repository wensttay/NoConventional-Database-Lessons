package br.edu.ifpb.ads.bdnc.oracleExBd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @version 1.0
 * @author Wensttay de Sousa Alencar <yattsnew@gmail.com>
 * @date 07/01/2017 - 12:01:31
 */
public class ConFactory {

    public static Connection conexao(String url, String user, String senha) {
        Connection conexao = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conexao = DriverManager.getConnection(url, user, senha);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return conexao;
    }
}
