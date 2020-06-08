package com.poo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.poo.controller.AlunoController;
import com.poo.model.Aluno;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JList;

public class CrudAluno extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtMatricula;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrudAluno frame = new CrudAluno();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CrudAluno() {
		/**
		 * Instanciando os componetentes globalmente.
		 */
		Aluno aluno = new Aluno();
		
		AlunoController controller = new AlunoController();
		
		setTitle("CRUD - ALUNO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 598, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.BLACK);
		panel.setBounds(10, 11, 562, 358);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 31, 46, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("CRUD");
		lblNewLabel.setBounds(257, 0, 51, 21);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		txtNome = new JTextField();
		txtNome.setBounds(10, 56, 326, 28);
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Matr\u00EDcula:");
		lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel_2.setBounds(346, 31, 87, 14);
		panel.add(lblNewLabel_2);
		
		txtMatricula = new JTextField();
		txtMatricula.setBounds(346, 56, 206, 28);
		panel.add(txtMatricula);
		txtMatricula.setColumns(10);
		
		JButton btnInsert = new JButton("INSERT");
		btnInsert.setBackground(new Color(50, 205, 50));
		btnInsert.setForeground(Color.WHITE);
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {				
					
					aluno.setNome(txtNome.getText());
					aluno.setMatricula(txtMatricula.getText());
					
					controller.create(aluno);
					JOptionPane.showMessageDialog(panel, "Aluno inserido com sucesso!");
				}
				
				 catch (Exception e1) {
					
					JOptionPane.showMessageDialog(null, "Erro ao Inserir Aluno!");
				}
			}
		});
		btnInsert.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnInsert.setBounds(10, 140, 109, 35);
		panel.add(btnInsert);
		
		JLabel lblNewLabel_3 = new JLabel("Opera\u00E7\u00F5es do Crud ");
		lblNewLabel_3.setFont(new Font("Verdana", Font.BOLD, 16));
		lblNewLabel_3.setBounds(202, 87, 201, 38);
		panel.add(lblNewLabel_3);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {								
					
					aluno.setNome(txtNome.getText());
					aluno.setMatricula(txtMatricula.getText());
					
					controller.update(aluno);
					
					JOptionPane.showMessageDialog(null, "Aluno atualizado!");
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null,"Erro ao atualizar aluno!");
				}
			}
		});
		btnUpdate.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnUpdate.setBounds(150, 140, 109, 35);
		panel.add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					aluno.setMatricula(txtMatricula.getText());					
					controller.delete(aluno);	
					JOptionPane.showMessageDialog(null, "Aluno deletado com sucesso!");
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao deletar aluno!");	
				}
			}
		});
		btnDelete.setBackground(new Color(255, 0, 0));
		btnDelete.setForeground(new Color(192, 192, 192));
		btnDelete.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnDelete.setBounds(294, 140, 109, 35);
		panel.add(btnDelete);
		
		JButton btnList = new JButton("LIST");
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*for(Aluno alunoList:controller.readAll())
				{
				}*/
			}
		});
		btnList.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnList.setBounds(443, 140, 109, 35);
		panel.add(btnList);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 187, 546, 165);
		panel.add(panel_1);
		
	}
}
