// Nome: Michael Nascimento de Souza 
// Matricula : 0050015719
// Email: michael.souza@soulasalle.com.br
// Nome: Mona-Lee Antunes Braga
// Matricual : 0050015709
// Email: monalee.braga@soulasalle.com.br

package com.poo.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.poo.jdbc.ConnectionFactory;
import com.poo.model.Aluno;

public class AlunoDAO {
	// insere aluno no banco de dados através de um CRUD - CREATE READ UPDATE DELETE
	public void create(Aluno aluno) {
		
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = null;
		
		String sql = "INSERT INTO aluno (matricula, nome) VALUES(?, ?)";
		
		try {
			
			statement = connection.prepareStatement(sql); //instancia uma instrução SQL
			
			statement.setString(1, aluno.getMatricula());
			statement.setString(2, aluno.getNome());
			
			statement.executeUpdate();
//			System.out.println("[AlunoDAO] Aluno cadastrado com sucesso");
			JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso! ");
		}
		catch (SQLException e ){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 finally {
			ConnectionFactory.closeConnection(connection);
		}
	}
	
	// Ler todos os regsitros da tabela aluno
	public List<Aluno> readAll() {
		
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = null;
		ResultSet rs = null;
		
		String sql = "SELECT matricula, nome FROM aluno";
		List<Aluno> alunos = new ArrayList<Aluno>();
		
		try {
			statement = connection.prepareStatement(sql);
			rs = statement.executeQuery();
			
			while (rs.next()){
				
				Aluno aluno = new Aluno();
				aluno.setMatricula(rs.getString("matricula"));
				aluno.setNome(rs.getString("nome"));
				
				alunos.add(aluno);
			}
		}
		catch (SQLException e) {
			System.out.println("Erro ao tentar ler a TABELA aluno");			
		}
		finally {
			ConnectionFactory.closeConnection(connection, statement);
		}
		
		return alunos;
		
	}
	
	public void updateAluno(Aluno aluno) {
		
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = null;
		
		String sql = "update aluno set nome = ? WHERE matricula = ?";
		
		try {
			
			statement = connection.prepareStatement(sql);
			statement.setString(1, aluno.getNome());
			statement.setString(2, aluno.getMatricula());
			
			statement.executeUpdate();
			System.out.println("[AlunoDAO] Aluno alterado com sucesso");
			
		} 
		catch (SQLException e) {
				e.printStackTrace();
		}
		finally {
			ConnectionFactory.closeConnection(connection, statement);
		}
		
	}
public void delete(Aluno aluno) {
		
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = null;
		
		String sql = "DELETE FROM aluno WHERE matricula = ?";
		
		try {
			
			statement = connection.prepareStatement(sql);			
			statement.setString(1, aluno.getMatricula());
			
			statement.executeUpdate();
			System.out.println("[AlunoDAO] Aluno deletado com sucesso");
			
		} 
		catch (SQLException e) {
				e.printStackTrace();
		}
		finally {
			ConnectionFactory.closeConnection(connection, statement);
		}
		
	}

}
