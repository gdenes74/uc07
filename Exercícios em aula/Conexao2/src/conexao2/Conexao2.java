package conexao2;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Conexao2 {

    public static void main(String[] args) {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("DRIVER JDBC carregado");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Driver JDBC não encontrado : "
                    + cnfe.getMessage());
        }
        Connection con = null;
        try {

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/escola", "root", "mysql");
            System.out.println("Conexao com o banco de dados estabelecida.");
        } catch (SQLException sqle) {
            System.out.println("Erro na conexao ao Bando de Dados : "
                    + sqle.getMessage());
        }
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            System.out.println("Pronto para execução de comandos sql. ");
        } catch (SQLException sqle) {
            System.out.println("Erro no acesso ao Banco de Dados ; " + sqle.getMessage());
        }
        /*inserção de dados no banco de dados 
        try {
            String sql = null;

            sql = "insert into alunos (nome, idade, endereco) values ('Ana','283','Rua 7 de setembro 826')";
            stmt.executeUpdate(sql);
            System.out.println("Dados inseridos.");
        } catch (SQLException sqle) {
            System.out.println("Erro inserindo : " + sqle.getMessage());
        }
          APÓS A INSERÇÃO IREMOS FAZER A EXCLUSÃO DE UMA LINHA */

        //AQUI ESTAMOS ESCLUINDO UM ID DE UM ALUNO "1"

        /*XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
        try{
                       String sql = null;
            sql = "delete from alunos where id = 1";
            stmt.executeUpdate(sql);
            System.out.println("Dados removidos.");
    }catch (SQLException sqle){
            System.out.println("Erro remoção: " + sqle.getMessage());
    }XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX*/
 /*XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
        try {
            //nesse momento estavamos atualizando a tabela, alterando a idade em algum id""
            String sql = null;
            sql = "update alunos set idade = '50' where id =3";
            stmt.executeUpdate(sql);
            System.out.println("Dados atualizados.");
        } catch (SQLException sqle) {
            System.out.println("Erro atualizacao : "
                    + sqle.getMessage());
        }
XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX*/
        try {
            String sql = "select id, nome, idade, endereco from alunos";

            //Executando o comando select
            ResultSet rs = stmt.executeQuery(sql);

            //Exibindo os resultados
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                int idade = rs.getInt("idade");
                String endereco = rs.getString("endereco");

                System.out.println("dados da tabela autor do banco de dados");
                System.out.println("--------------------------");
                System.out.println(id + " - " + nome + " - " + idade + " - " + endereco);
            }
        } catch (SQLException sqle) {
            System.out.println("Erro efetuando consulta : " + sqle.getMessage());
        }
        try {
            con.close();
            System.out.println("Conexão com o banco de dados fechada");
        } catch (SQLException sqle) {
            System.out.println("Erro no fechamento da conexão: " + sqle.getMessage());
        }
    }

}
