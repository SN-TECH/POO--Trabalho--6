package com.poo.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class CrudAluno extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

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
		// instanciando os componetentes globalmente 
		Aluno aluno = new Aluno();
		
		AlunoController controller = new AlunoController();
		
		setTitle("CRUD - ALUNO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 598, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.BLACK);
		panel.setBounds(10, 11, 562, 384);
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
		
		textField = new JTextField();
		textField.setBounds(10, 56, 326, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Matr\u00EDcula:");
		lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel_2.setBounds(346, 31, 87, 14);
		panel.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(346, 56, 206, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("INSERT");
		btnNewButton.setBackground(new Color(50, 205, 50));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {				
					
					aluno.setNome(textField.getText());
					aluno.setMatriula(textField_1.getText());
					
					controller.create(aluno);
					JOptionPane.showMessageDialog(panel, "Aluno inserido com sucesso!");
				}
				
				 catch (Exception e1) {
					
					JOptionPane.showMessageDialog(null, "Erro ao Inserir Aluno!");
				}
			}
		});
		btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnNewButton.setBounds(10, 140, 109, 35);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Opera\u00E7\u00F5es do Crud ");
		lblNewLabel_3.setFont(new Font("Verdana", Font.BOLD, 16));
		lblNewLabel_3.setBounds(202, 87, 201, 38);
		panel.add(lblNewLabel_3);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {								
					
					aluno.setNome(textField.getText());
					aluno.setMatriula(textField_1.getText());
					
					controller.updateAluno(aluno);
					
					JOptionPane.showMessageDialog(null, "Aluno atualizado!");
				}
				catch(Exception e1) {
					
					System.out.println("Erro ao atualizar aluno");
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
					
					aluno.setMatriula(textField_1.getText());					
					controller.delete(aluno);					
				}
				
				catch(Exception e1) {
					
					JOptionPane.showMessageDialog(null, "Aluno Deletado com sucesso!");
				}
			}
		});
		btnDelete.setBackground(new Color(255, 0, 0));
		btnDelete.setForeground(new Color(192, 192, 192));
		btnDelete.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnDelete.setBounds(294, 140, 109, 35);
		panel.add(btnDelete);
		
		JButton button_2 = new JButton("LIST");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//...		
			}
		});
		button_2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		button_2.setBounds(443, 140, 109, 35);
		panel.add(button_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 187, 546, 191);
		panel.add(panel_1);
	}
}
