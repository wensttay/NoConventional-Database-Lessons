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
public class Filme implements SQLData {

    String titulo;
    Diretor diretor;
    double valor;

    public Filme() {
    }

    public Filme(String titulo, Diretor diretor, double valor) {
        this.titulo = titulo;
        this.diretor = diretor;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Filme{" + "titulo=" + titulo + ", diretor=" + diretor + ", valor=" + valor + '}';
    }

    @Override
    public String getSQLTypeName() throws SQLException {
        return "FILME";
    }

    @Override
    public void readSQL(SQLInput sqli, String string) throws SQLException {
        titulo = sqli.readString();
        diretor = (Diretor) sqli.readObject();
        valor = sqli.readDouble();
    }

    @Override
    public void writeSQL(SQLOutput sqlo) throws SQLException {
        sqlo.writeString(titulo);
        sqlo.writeObject(diretor);
        sqlo.writeDouble(valor);
    }

}
