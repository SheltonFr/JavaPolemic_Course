/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc.Aula04;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import jdbc.Aula03.FabricaConexao;

/**
 *
 * @author Admin
 */
public class DesafioUpdate {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        Connection conexao = FabricaConexao.getConexao();
        
        System.out.println("Informe o Id: ");
        int id = sc.nextInt();
        
        
        String sql = "SELECT codigo, nome FROM pessoas "
                + "WHERE codigo = ?";
        
        PreparedStatement st = conexao.prepareStatement(sql);
        st.setInt(1, id);
        ResultSet rs = st.executeQuery();
        
        if(rs.next()){
            Pessoa p = new Pessoa(rs.getInt(1), rs.getString(2));
            
            System.out.println("O nome é: " + p.getNome());
            sc.nextLine();
            System.out.println("Informe o novo nome: ");
            String novoNome = sc.nextLine();
            
            sql = "UPDATE pessoas SET nome = ? WHERE codigo = ?";
            st.close();
            
            st = conexao.prepareStatement(sql);
            st.setString(1, novoNome);
            st.setInt(2, id);
            st.executeUpdate();
            p.setNome(novoNome);
        }
        
        
        sc.close();
        st.close();
        conexao.close();
    }
}
