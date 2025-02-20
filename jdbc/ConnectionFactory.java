/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author gabriel
 */

//Criamos uma classe para fazer a conexão ao banco de dados
public class ConnectionFactory {
        //Criamos a função para conectar
        public Connection getConnection(){
            try {
                 //Essa função DriverManager Conecta e acessa o banco de dados
                 //Na função getConnection do java.sql passamos todos os dados do nosso banco de dados
                 //Como Local e nome , usuario e senha
                  return DriverManager.getConnection("jdbc:mysql://127.0.0.1/bdcontrolevendas", "root", "");
            } catch (SQLException erro) {
               //Caso ocorra um erro na conexão, lança uma Exception para não travar o programa
                throw new RuntimeException(erro);
            }
        }
}
