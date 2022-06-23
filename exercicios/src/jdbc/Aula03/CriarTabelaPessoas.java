/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc.Aula03;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;


public class CriarTabelaPessoas {
 
    public static void main(String[] args) throws SQLException{
        
        Connection conexao = FabricaConexao.getConexao();
        
        String sql = """
                     CREATE TABLE IF NOT EXISTS pessoas (
                        codigo INT AUTO_INCREMENT, 
                        nome VARCHAR(40) NOT NULL,
                        PRIMARY KEY(codigo)
                     ) DEFAULT CHARSET = utf8;
                     """;
        
        Statement st = conexao.createStatement();
        st.execute(sql);
        
        System.out.println("Tabela criada com sucesso! ");
        conexao.close();
        
        
    }
}
