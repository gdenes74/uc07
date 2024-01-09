package aplicacaoacessobd;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;


public class AplicacaoAcessoBd {

    public static void main(String[] args) {
        try {
            Connection conn; //criando um objeto do tipo connection chamado conn
            Statement st; //criando um objeto do tipo Statement chamado st para  execução de comando SQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exemplo_senac","root","abcd1234"); 
            st = conn.createStatement();
        } catch (ClassNotFoundException ex) {
            System.out.println("O Driver não está disponível na biblioteca");
        } catch (SQLException ex) {
            System.out.println("Sintaxe de comando invalida");
        }
    }
}