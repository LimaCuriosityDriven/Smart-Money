package br.com.fintech.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.SQLException;

public class ConexaoDAO {
	
	private static ConexaoDAO conexaoDao;
	
	public ConexaoDAO () {
		super();
	}
	
	public static ConexaoDAO getInstance(){
		if (conexaoDao == null) {
			conexaoDao = new ConexaoDAO();
		}
		return conexaoDao;
	}
	
 public Connection conectaBD() {
     Connection conn = null;
     try {
    	 Class.forName("com.mysql.cj.jdbc.Driver");
         String url = "jdbc:mysql://localhost:3306/Fintech?user=root&password=&serverTimezone=UTC"; // Aqui é para testar no MySQL
         conn = DriverManager.getConnection(url);
     } catch (SQLException e) {
         System.out.println("N�o foi poss�vel se conectar ao banco Oracle");
         e.printStackTrace();
         JOptionPane.showMessageDialog(null, "Erro na Classe de Conexão" + e.getMessage());
     } catch (ClassNotFoundException e){
    	 e.printStackTrace();
         System.out.println("O Driver JDBC n�o foi encontrado");
     }
     return conn;
 }
}
