// Nome: Michael Nascimento de Souza 
// Matricula : 0050015719
// Email: michael.souza@soulasalle.com.br
// Nome: Mona-Lee Antunes Braga
// Matricual : 0050015709
// Email: monalee.braga@soulasalle.com.br

package com.poo.view;

import java.util.Scanner;

import com.poo.controller.AlunoController;
import com.poo.model.Aluno;

public class AlunoView {
	
	public void create() {
		
		try {
			Scanner sc = new Scanner(System.in);
			
			Aluno aluno = new Aluno();
			AlunoController controller = new AlunoController();
			
			System.out.println("Entre com a matricula:\n");
			aluno.setMatriula(sc.nextLine());
			
			System.out.println("Entre com o nome:\n");
			aluno.setNome(sc.nextLine());
			
			controller.create(aluno);			
			sc.close();
			
		} catch (Exception e) {
			
			System.out.println("Erro na tela de incluir aluno");
		}
	}
	
	public void readAll() {
		
		AlunoController controller = new AlunoController();
		
		System.out.println("Listagem de Alunos");
		System.out.println("***********************************");
		
		for(Aluno aluno:controller.readAll()) {
			System.out.println("Matricula: " + aluno.getMatriula());
			System.out.println("Nome: " + aluno.getNome());
			System.out.println("-------------------------------");
		}
	}
	public void updateAluno() {
		
		try {
			Scanner sc = new Scanner(System.in);
			
			Aluno aluno = new Aluno();
			AlunoController controller = new AlunoController();
			
			
			System.out.println("Entre com a mattricula do aluno que deseja alterar: ");
			aluno.setMatriula(sc.nextLine());
			
			System.out.println("Informe o novo aluno: ");
			aluno.setNome(sc.nextLine());
			
			controller.updateAluno(aluno);
			sc.close();			
		}
		catch(Exception e) {
			System.out.println("Erro ao atualizar aluno");
		}
	}
	
	public void delete() {
		
		try {
			Scanner sc = new Scanner(System.in);
			
			Aluno aluno = new Aluno();
			AlunoController controller = new AlunoController();
			
			
			System.out.println("Entre com a mattricula do aluno que deseja deletar: ");
			aluno.setMatriula(sc.nextLine());
			
			controller.delete(aluno);
			sc.close();			
		}
		catch(Exception e) {
			System.out.println("Erro ao atualizar aluno");
		}
	}
	
	public static void main(String[] args) {		
		// Aqui é onde tudo começa 
		AlunoView crud = new AlunoView();
//		crud.create();
//		crud.readAll();	
//		crud.updateAluno();
//		crud.readAll();
		crud.delete();
		crud.readAll();
	}
}
