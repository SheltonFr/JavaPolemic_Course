/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc.Aula04;

import jdbc.Aula03.FabricaConexao;
import java.sql.Connection; 
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ConsultarPessoas01 {
    public static void main(String[] args) throws SQLException {
        
        Connection conexao = FabricaConexao.getConexao();
        String sql = "SELECT * FROM pessoas";
        
        Statement st = conexao.createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        List<Pessoa> list = new ArrayList<>();
        
        while(rs.next()){
            
            list.add(new Pessoa(rs.getInt("codigo"), rs.getString("nome")));
        }
        
        for(Pessoa p: list){
            System.out.println(p);
        }
        st.close();
        conexao.close();
    }
}
