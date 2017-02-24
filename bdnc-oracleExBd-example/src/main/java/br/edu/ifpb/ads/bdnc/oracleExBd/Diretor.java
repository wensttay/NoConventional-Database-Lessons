package br.edu.ifpb.ads.bdnc.oracleExBd;

import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

/**
 * @version 1.0
 * @author Wensttay de Sousa Alencar <yattsnew@gmail.com>
 * @date 07/01/2017 - 12:01:31
 */
public class Diretor implements SQLData {

    private String nome;
    private Telefone telefone;

    public Diretor() {
    }

    public Diretor(String nome, Telefone telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    @Override
    public String getSQLTypeName() throws SQLException {
        return "DIRETOR";
    }

    @Override
    public void readSQL(SQLInput sqli, String string) throws SQLException {
        nome = sqli.readString();
        telefone = (Telefone) sqli.readObject();
    }

    @Override
    public void writeSQL(SQLOutput sqlo) throws SQLException {
        sqlo.writeString(nome);
        sqlo.writeObject(telefone);
    }

    @Override
    public String toString() {
        return "Diretor{" + "nome=" + nome + ", telefone=" + telefone + '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

}
