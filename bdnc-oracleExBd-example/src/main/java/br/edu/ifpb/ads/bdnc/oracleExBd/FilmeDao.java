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
public class FilmeDao {

    private final String URL;
    private final String schema;
    private final String senha;
    private Connection con;

    public FilmeDao() {
        URL = "jdbc:oracle:thin:@localhost:1521:XE";
        schema = "AULA";
        senha = "12345";

        con = ConFactory.conexao(URL, schema, senha);
        
        try {
            Map map = con.getTypeMap();
            map.put("FILME", Filme.class);
            map.put("DIRETOR", Diretor.class);
            map.put("TELEFONE", Telefone.class);
            con.setTypeMap(map);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Filme> list() throws SQLException {
        List<Filme> filmes = new ArrayList<>();
        PreparedStatement preparedStatement
                = con.prepareStatement("SELECT VALUE(p) FROM filmes p");
        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            Filme a = (Filme) rs.getObject(1);
            filmes.add(a);
        }

        return filmes;
    }

    public boolean create(Filme f) throws SQLException {
        PreparedStatement preparedStatement
                = con.prepareStatement("INSERT INTO filmes VALUES (?)");
        preparedStatement.setObject(1, f);
        
        return preparedStatement.executeUpdate() > 0;
    }

}
