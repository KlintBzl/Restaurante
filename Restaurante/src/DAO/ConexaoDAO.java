
package DAO;
import java.sql.*;
import javax.swing.JOptionPane;

public class ConexaoDAO {
    
    public static Connection conector() {
        java.sql.Connection Conexao = null;
        
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/restaurante_db";
        String user = "root";
        String password = "root";
        
        try{
            Class.forName(driver);
            Conexao = DriverManager.getConnection(url, user, password);
            return Conexao;
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Conexão falhou: " + e.getMessage());
            return null;
        }
    }
    
}
