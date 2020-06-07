// Nome: Michael Nascimento de Souza 
// Matricula : 0050015719
// Email: michael.souza@soulasalle.com.br
// Nome: Mona-Lee Antunes Braga
// Matricual : 0050015709
// Email: monalee.braga@soulasalle.com.br

package com.poo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionFactory {
	private static final String DRIVE = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/poo_002?useTimezone=true&serverTimezone=UTC"; 
	private static final String USER = "root"; 
	private static final String SENHA = ""; 
	
	
	public static Connection getConnection() {
		
        try {  	
        	// Class.forName(DRIVER); opcional dependendo da versao
            return DriverManager.getConnection(
            		URL, USER, SENHA);
        } catch (SQLException e) {
            throw new RuntimeException("Erro na conexão com o Banco de Dados!", e);
        }
	}
	
	public static void closeConnection(Connection connection) {
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e ) {
				e.printStackTrace();
			}
		}
	}	
	public static void closeConnection( Connection connection, PreparedStatement statement) {
		
		closeConnection(connection);
		
		if(statement != null) {
			try {
				statement.close();
			} catch (SQLException e ) {
				e.printStackTrace();
			}
		}
	}
	
}