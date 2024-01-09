package exemplojavacombancodados;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ExemploJavaComBancoDados {

    public static void main(String[] args) {
       
       Conexao conexao = new Conexao();
       conexao.conectar();
       conexao.desconectar();
    }
}
