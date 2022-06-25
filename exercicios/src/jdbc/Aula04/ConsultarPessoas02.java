/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc.Aula04;

import jdbc.Aula03.FabricaConexao;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
// Pesuisando por dados, a partir de partes parecidas

/* SINTAXE DO SQL (exemplo)
    '%S' -> dados que terminam com o carcter 's'
    's%' -> dados que comecao com o caracter 's'
    '%s% -> dados que contenham p caracter 's''

 */
public class ConsultarPessoas02 {

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        Connection conexao = FabricaConexao.getConexao();

        System.out.println("Informe a pesquisa: ");
        String pesquisa = sc.nextLine();

        PreparedStatement st = conexao.prepareStatement("SELECT * FROM pessoas "
                + "WHERE nome LIKE ?");
        st.setString(1, "%" + pesquisa + "%");

        List<Pessoa> list = new ArrayList<>();

        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            int cod = rs.getInt("codigo");
            String nome = rs.getString("nome");
            list.add(new Pessoa(cod, nome));
        }

        for (Pessoa p : list) {
            System.out.println(p);
        }

        sc.close();
        st.close();
        conexao.close();
    }

}
