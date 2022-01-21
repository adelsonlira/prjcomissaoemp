/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.comissaoemp.dal;

import java.sql.*;

/**
 *
 * @author adels
 */
public class ModuloConexao {

    //método para estabelecer a conexão com o banco de dados
    
    public static Connection conector() {
        
        java.sql.Connection conexao = null;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/dbcomissoes";
        String user = "";
        String password = "";
        
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (Exception e) {
           // System.out.println(e);
            return null;
        }
    }

}
