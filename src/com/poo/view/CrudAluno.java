package com.poo.view;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;


import com.poo.controller.AlunoController;
import com.poo.model.Aluno;
import javax.swing.JTextField;
import java.awt.Color;
 
public class CrudAluno extends JFrame {
 
    private JPanel painelFundo;
    private JTable tabela;
    private JScrollPane barraRolagem;
    private JLabel labelNome;
    private JLabel labelMatricula;
    private DefaultTableModel modelo = new DefaultTableModel();
    private JTextField textNome;
    private JTextField textMatricula;
    private JButton btnListarTodos;

    public CrudAluno() {
        super("Registros dos Alunos");
        criaJTable();
        criaJanela();
    }
 
    public void criaJanela() {

		Aluno aluno = new Aluno();
		AlunoController controller = new AlunoController();
		
        barraRolagem = new JScrollPane(tabela);
        barraRolagem.setBounds(154, 111, 497, 198);
        painelFundo = new JPanel();
        labelNome = new JLabel("Nome:");
        labelNome.setBounds(324, 51, 46, 14);
        labelNome.setFont(new Font("Verdana", Font.BOLD, 12));
        
        labelMatricula = new JLabel("Matr\u00EDcula:");
        labelMatricula.setBounds(6, 50, 122, 16);
        labelMatricula.setFont(new Font("Verdana", Font.BOLD, 12));
        painelFundo.setLayout(null);
        painelFundo.add(barraRolagem);
        painelFundo.add(labelMatricula);
        painelFundo.add(labelNome);
        
 
        getContentPane().add(painelFundo);
        
        textNome = new JTextField();
        textNome.setBounds(369, 44, 282, 28);
        painelFundo.add(textNome);
        textNome.setColumns(10);
        
        JLabel labelTitulo = new JLabel("CRUD ALUNO");
        labelTitulo.setBounds(6, 6, 645, 16);
        labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        labelTitulo.setFont(new Font("SansSerif", Font.BOLD, 17));
        painelFundo.add(labelTitulo);
        
        textMatricula = new JTextField();
        textMatricula.setBounds(74, 44, 216, 28);
        painelFundo.add(textMatricula);
        textMatricula.setColumns(10);
        
        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(6, 104, 112, 36);
        btnCadastrar.setFont(new Font("SansSerif", Font.BOLD, 13));
        btnCadastrar.setForeground(new Color(255, 255, 255));
        btnCadastrar.setBackground(new Color(46, 139, 87));
        btnCadastrar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {						
					aluno.setNome(textNome.getText());
					aluno.setMatricula(textMatricula.getText());
					controller.create(aluno);
					JOptionPane.showMessageDialog(painelFundo, "Aluno inserido com sucesso!");
				}				
				 catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao Inserir Aluno!");
				}	
        	}
        });
        painelFundo.add(btnCadastrar);
        
        JButton btnAtualizar = new JButton("Atualizar");
        btnAtualizar.setBounds(6, 156, 112, 36);
        btnAtualizar.setForeground(Color.WHITE);
        btnAtualizar.setFont(new Font("SansSerif", Font.BOLD, 13));
        btnAtualizar.setBackground(new Color(255, 165, 0));
        btnAtualizar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {						
        			aluno.setNome(textNome.getText());
					aluno.setMatricula(textMatricula.getText());
					controller.update(aluno);
					JOptionPane.showMessageDialog(painelFundo, "Aluno atualizado!");
				}				
				 catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao atualizar aluno!");
				}	
        	}
        });
        painelFundo.add(btnAtualizar);
        
        JButton btnDeletar = new JButton("Deletar");
        btnDeletar.setBounds(6, 213, 112, 36);
        btnDeletar.setForeground(Color.WHITE);
        btnDeletar.setFont(new Font("SansSerif", Font.BOLD, 13));
        btnDeletar.setBackground(new Color(255, 0, 0));
        btnDeletar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {						
        			aluno.setMatricula(textMatricula.getText());					
					controller.delete(aluno);	
					JOptionPane.showMessageDialog(painelFundo, "Aluno deletado com sucesso!");
				}				
				 catch (Exception e1) {
					 JOptionPane.showMessageDialog(null, "Erro ao deletar aluno!");
				}	
        	}
        });
        painelFundo.add(btnDeletar);
        
        btnListarTodos = new JButton("Listar");
        btnListarTodos.setForeground(Color.WHITE);
        btnListarTodos.setFont(new Font("SansSerif", Font.BOLD, 13));
        btnListarTodos.setBackground(new Color(30, 144, 255));
        btnListarTodos.setBounds(6, 273, 112, 36);
        btnListarTodos.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		pesquisar(modelo);			
        	}
        });
        painelFundo.add(btnListarTodos);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(673, 374);
        setVisible(true);
        
        
    }
 
    private void criaJTable() {
        tabela = new JTable(modelo);
        modelo.addColumn("Matricula");
        modelo.addColumn("Nome");
        tabela.getColumnModel().getColumn(0)
        .setPreferredWidth(10);
        tabela.getColumnModel().getColumn(1)
        .setPreferredWidth(120);
        pesquisar(modelo);
    }
    
    public static void pesquisar(DefaultTableModel modelo) {
        modelo.setNumRows(0);
        AlunoController controller = new AlunoController();
        for (Aluno alunoList : controller.readAll()) {
        	modelo.addRow(new Object[]{alunoList.getMatricula(),alunoList.getNome()});
		}
    }
	
    public static void main(String[] args) {
        CrudAluno lc = new CrudAluno();
        lc.setVisible(true);
    }
}
