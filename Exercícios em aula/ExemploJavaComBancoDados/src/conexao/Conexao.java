package conexao;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;

public class Conexao {
    
    public Connection conn;
    public String url = "jdbc:mysql://localhost:3306/exemplo_senac"; //Nome da base de dados
    public String user = "root"; //nome do usuário do MySQL
    public String password = "mysql"; //senha do MySQL
    
  public boolean conectar(){
        
        try {
                        
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão realizada com sucesso");
            
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM usuario"); //variavel da classe ResultSet para receber o valor da consulta
            rs.next();
            System.out.println(rs.getInt("COUNT(*)"));
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Falha na conexão com o banco" +" "+ ex.getMessage());
            return false;
        }
    }
    
    public void desconectar(){
        try {
            conn.close();
        } catch (SQLException ex) {
            //posso deixar vazio para evitar uma mensagem de erro desnecessária ao usuário
        }
    }
}