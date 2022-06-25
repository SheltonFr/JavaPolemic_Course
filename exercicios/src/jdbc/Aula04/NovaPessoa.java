package jdbc.Aula04;

import java.sql.SQLException;
import java.util.Scanner;
import jdbc.Aula03.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Admin
 */

//Inserir Registros
public class NovaPessoa {

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        Connection conexao = FabricaConexao.getConexao();

        System.out.println("Informe o nome: ");
        String nome = sc.nextLine();

        String sql = "INSERT INTO pessoas (nome) values (?)";
        PreparedStatement st = conexao.prepareStatement(sql);
        st.setString(1, nome);
        
        st.execute();
        System.out.println("Pessoa incluida com sucesso!");
        sc.close();
        conexao.close();

    }
}
