package view;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTextField;

import controller.mainMVC;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import model.ADHERENT;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Label;

import model.model;
import javax.swing.JLabel;

public class rendre {

	private JFrame frame;
	private JTextField ISBN;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					rendre window = new rendre();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public rendre() throws SQLException {
		mainMVC.getM().getAll();
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 708, 469);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea code = new JTextArea();
		code.setForeground(Color.YELLOW);
		code.setEditable(false);
		code.setText("Code Barre :");
		code.setFont(new Font("Arial", Font.PLAIN, 22));
		code.setBackground(SystemColor.menu);
		code.setBounds(85, 180, 127, 22);
		frame.getContentPane().add(code);
		code.setOpaque(false);
		
		JTextArea txtrPageDe = new JTextArea();
		txtrPageDe.setForeground(Color.YELLOW);
		txtrPageDe.setEditable(false);
		txtrPageDe.setText("Page de restitution");
		txtrPageDe.setFont(new Font("Arial", Font.PLAIN, 25));
		txtrPageDe.setBackground(SystemColor.menu);
		txtrPageDe.setBounds(249, 49, 235, 29);
		frame.getContentPane().add(txtrPageDe);
		txtrPageDe.setOpaque(false);
		
		ISBN = new JTextField();
		ISBN.setFont(new Font("Tahoma", Font.PLAIN, 22));
		ISBN.setColumns(10);
		ISBN.setBackground(Color.WHITE);
		ISBN.setBounds(249, 175, 235, 37);
		frame.getContentPane().add(ISBN);
		
		JButton btnPrcedent = new JButton("");
		btnPrcedent.setIcon(new ImageIcon("photo/precedent.png"));
		btnPrcedent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnPrcedent.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnPrcedent.setBounds(60, 338, 167, 51);
		frame.getContentPane().add(btnPrcedent);
		btnPrcedent.setOpaque(false);
		btnPrcedent.setBorderPainted(false);
		
		JTextArea verif = new JTextArea();
		verif.setEditable(false);
		verif.setForeground(Color.RED);
		verif.setBounds(183, 103, 349, 29);
		frame.getContentPane().add(verif);
		
		JButton valider = new JButton("");
		valider.setIcon(new ImageIcon("photo/valider.png"));
		valider.setFont(new Font("Tahoma", Font.PLAIN, 22));
		valider.setBorderPainted(false);
		valider.setOpaque(false);
		valider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					mainMVC.getM().retour(ISBN.getText());
					verif.setText("Le livre "+ISBN.getText()+" a bien été rendu.");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		valider.setBounds(280, 262, 137, 44);
		frame.getContentPane().add(valider);
		valider.setBorderPainted(false);

		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon("photo/Bibliothèque.jpg"));
		background.setBounds(0, -16, 692, 463);
		frame.getContentPane().add(background);
		
	}
}
