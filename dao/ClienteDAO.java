/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import models.Cliente;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import jdbc.ConnectionFactory;
import java.sql.ResultSet;

/**
 *
 * @author gabri
 */
public class ClienteDAO {
    private Connection con;
    
    public ClienteDAO(){
        //Conectar no banco de dados
        //Toda vez que instanciar essa classe ele automaticamente vai conectar no banco de dados
        this.con = new ConnectionFactory().getConnection();
    }

    //Metodos CadastrasCliente
    public void cadastrarCliente(Cliente obj){
        try {
            //1 Passo - criar o comando sql
            //Criamos um string sql com os comandos sql
            String sql = "insert into tb_clientes(nome, rg, cpf, email, telefone, celular, cep, endereco, numero, complemento, bairro, cidade, estado) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            //2 Passo - Organizar e executar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            //Vai substituir os "?" pelos os valores
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getTelefone());
            stmt.setString(6, obj.getCelular());
            stmt.setString(7, obj.getCep());
            stmt.setString(8, obj.getEndereco());
            stmt.setInt(9, obj.getNumero());
            stmt.setString(10, obj.getComplemento());
            stmt.setString(11, obj.getBairro());
            stmt.setString(12, obj.getCidade());
            stmt.setString(13, obj.getEstado());
            
            //3 Passo - Executar e Fechar a conexão 
             stmt.execute();
             stmt.close();  
             
             JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso");
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "ERRO" + erro);
        }
        
    }
    
    
    //Método Listar Todos os Clientes
    public List<Cliente> ListarClientes(){
        try {
           //1 Passo - Criar o comando SQL
           String sql = "select * from tb_clientes";
           
           //2 passo - Criar lista 
           List<Cliente> lista = new ArrayList<>();
           
           
           //Organizar e executar o comando sql
           PreparedStatement stmt = con.prepareStatement(sql);
           
           ResultSet rs = stmt.executeQuery();
           
           while(rs.next()){
               Cliente obj = new Cliente();
               
               //Montar esse objeto
               obj.setId(rs.getInt("id"));
               obj.setNome(rs.getString("nome"));
               obj.setRg(rs.getString("rg"));
               obj.setCpf(rs.getString("cpf"));
               obj.setEmail(rs.getString("email"));
               obj.setTelefone(rs.getString("telefone"));
               obj.setCelular(rs.getString("celular"));
               obj.setCep(rs.getString("cep"));
               obj.setNumero(rs.getInt("numero"));
               obj.setComplemento(rs.getString("complemento"));
               obj.setBairro(rs.getString("bairro"));
               obj.setCidade(rs.getString("cidade"));
               obj.setEstado(rs.getString("estado"));
               //Adicionar esse objeto com os dados na nosso lista
               lista.add(obj);
           }
           return lista;
        } catch (Exception erro) {
               JOptionPane.showMessageDialog(null, "ERRO: " + erro);
               return null;
        }
    }
}
