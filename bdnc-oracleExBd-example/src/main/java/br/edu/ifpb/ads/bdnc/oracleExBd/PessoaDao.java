package br.edu.ifpb.ads.bdnc.oracleExBd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @author Wensttay de Sousa Alencar <yattsnew@gmail.com>
 * @date 07/01/2017 - 12:01:31
 */
public class PessoaDao {

    private final String URL;
    private final String schema;
    private final String senha;
    private Connection con;

    public PessoaDao() {
        URL = "jdbc:oracle:thin:@localhost:1521:XE";
        schema = "AULA";
        senha = "12345";

        con = ConFactory.conexao(URL, schema, senha);
        
        try {
            Map map = con.getTypeMap();
            map.put("PESSOA", Pessoa.class);
            con.setTypeMap(map);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Pessoa> list() throws SQLException {
        List<Pessoa> pessoas = new ArrayList<>();
        PreparedStatement statement = con.prepareStatement("SELECT VALUE(p) FROM PESSOAS p");
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            Pessoa a = (Pessoa) rs.getObject(1);
            pessoas.add(a);
        }

        return pessoas;
    }

    public boolean create(Pessoa p) throws SQLException {
        PreparedStatement preparedStatement
                = con.prepareStatement("INSERT INTO pessoas VALUES(?)");
        preparedStatement.setObject(1, p);

        return preparedStatement.executeUpdate() > 0;
    }

}
