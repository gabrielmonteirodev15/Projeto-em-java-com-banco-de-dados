/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc;

import java.net.ConnectException;
import javax.swing.JOptionPane;

/**
 *
 * @author gabri
 */
public class TestdeConexao {
        public static void main(String[] args){
            try {
                //Faz a conexão 
                new ConnectionFactory().getConnection();
                JOptionPane.showMessageDialog(null, "Conectado com sucesso");
            } catch (Exception erro) {
                JOptionPane.showMessageDialog(null, "ERRO: " + erro);
            }
        }
}
