package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Abrindo uma conexao
public class Aula01_TesteConexao {
    
    public static void main(String[] args) throws SQLException{
        final String url = "jdbc:mysql://localhost:3306";
        final String usuario = "root";
        final String senha = "root";
        
        Connection conexao = DriverManager.getConnection(url, usuario, senha);
        
        System.out.println("Conexao efectuada com sucesso!");
        conexao.close();
    }
}
