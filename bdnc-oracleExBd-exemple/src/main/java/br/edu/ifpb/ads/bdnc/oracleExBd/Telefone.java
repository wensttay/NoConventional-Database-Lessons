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
public class Telefone implements SQLData {

    private int ddd;
    private String numero;

    public Telefone() {
    }

    public Telefone(int ddd, String numero) {
        this.ddd = ddd;
        this.numero = numero;
    }

    @Override
    public String getSQLTypeName() throws SQLException {
        return "TELEFONE";
    }

    @Override
    public void readSQL(SQLInput sqli, String string) throws SQLException {
        ddd = sqli.readInt();
        numero = sqli.readString();
    }

    @Override
    public void writeSQL(SQLOutput sqlo) throws SQLException {
        sqlo.writeInt(ddd);
        sqlo.writeString(numero);
    }

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

}
