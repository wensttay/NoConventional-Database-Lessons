package br.edu.ifpb.ads.bdnc.oracleExBd;

import java.sql.SQLException;

/**
 * @version 1.0
 * @author Wensttay de Sousa Alencar <yattsnew@gmail.com>
 * @date 07/01/2017 - 12:01:31
 */
public class Main {

    public static void main(String[] args) {

        PessoaDao pessoaDao = new PessoaDao();
        FilmeDao filmeDao = new FilmeDao();
        
        try {
//            System.out.println(pessoaDao.list());
            System.out.println(filmeDao.list());
//            Pessoa pessoa = new Pessoa("Wensttay", 20);
//            pessoaDao.create(pessoa);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
