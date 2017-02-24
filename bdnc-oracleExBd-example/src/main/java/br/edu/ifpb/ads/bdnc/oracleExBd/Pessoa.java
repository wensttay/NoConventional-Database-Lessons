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
public class Pessoa implements SQLData {

    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public Pessoa() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + nome + ", idade=" + idade + '}';
    }

    @Override
    public String getSQLTypeName() throws SQLException {
        return "PESSOA";
    }

    @Override
    public void readSQL(SQLInput sqli, String string) throws SQLException {
        nome = sqli.readString();
        idade = sqli.readInt();
    }

    @Override
    public void writeSQL(SQLOutput sqlo) throws SQLException {
        sqlo.writeString(nome);
        sqlo.writeInt(idade);
    }

}
