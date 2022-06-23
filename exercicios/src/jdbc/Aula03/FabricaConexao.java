package jdbc.Aula03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {
    
    private static Connection conexao;
    
    public static Connection getConexao(){
        try{
            String url = "jdbc:mysql://localhost:3306/java_polemic";
            String user = "root";
            String password = "root";
            
            conexao = DriverManager.getConnection(url, user, password);
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
        
        return conexao;
    }
    

}
