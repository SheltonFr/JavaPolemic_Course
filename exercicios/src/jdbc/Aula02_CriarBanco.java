package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Aula02_CriarBanco {

    public static void main(String[] args) throws SQLException{
        String url = "jdbc:mysql://localhost:3306";
        String user = "root";
        String password = "root";

        Connection conexao = DriverManager.getConnection(url, user, password);
        
        // Criando um statement para conexao criada
        Statement st = conexao.createStatement();
        // passando comando de criacao de banco de dados
        st.execute("CREATE DATABASE IF NOT EXISTS java_polemic");
        // passando comando para eliminar o banci de dados
        //st.execute("DROP DATABASE IF EXISTS java_polemic");
        
        System.out.println("Banco criado com sucesso! ");
        conexao.close();

    }
}
