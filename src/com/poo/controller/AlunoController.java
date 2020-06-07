// Nome: Michael Nascimento de Souza 
// Matricula : 0050015719
// Email: michael.souza@soulasalle.com.br
// Nome: Mona-Lee Antunes Braga
// Matricual : 0050015709
// Email: monalee.braga@soulasalle.com.br

package com.poo.controller;

import java.util.ArrayList;
import java.util.List;

import com.poo.dao.AlunoDAO;
import com.poo.model.Aluno;

public class AlunoController {
	//define a regra do negocio para enviar os dados correspondentes ao Aluno no banco
	public  void create (Aluno aluno) {
		
		try {
			
			AlunoDAO dao = new AlunoDAO();
			
			dao.create(aluno);
			
		} catch (Exception e) {
			System.out.println("Erro no Controller");
			
		} finally {
			System.out.println("Fim da Inserção/ Sucesso!");
		}
	}
	
	public List<Aluno> readAll() {
		
		List<Aluno> alunos = new ArrayList<Aluno>();
		
		try {
			AlunoDAO dao = new AlunoDAO();
			alunos = dao.readAll();
		}
		finally {
			System.out.println("Fim da Leitura!");
		}
		
		return alunos;		
	}
	
	public void updateAluno(Aluno aluno) {
		try {
			AlunoDAO dao = new AlunoDAO();
			dao.updateAluno(aluno);
			
		} catch (Exception e) {
			System.out.println("Erro no Controller");
		} 
		finally {
			System.out.println("Fim atualizacao");
		}
	}
	public void delete(Aluno aluno) {
		try {
			AlunoDAO dao = new AlunoDAO();
			dao.delete(aluno);
			
		} catch (Exception e) {
			System.out.println("Erro no Controller");
		} 
		finally {
			System.out.println("Fim atualizacao");
		}
	}

}
