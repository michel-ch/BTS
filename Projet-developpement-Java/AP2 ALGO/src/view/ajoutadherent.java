package view;
import java.awt.EventQueue;

import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;


import controller.mainMVC;

import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// import model.ADHERENT;

public class ajoutadherent {

	private JFrame frame;
	private JTextField nom;
	private JTextField prenom;
	private JTextField email;
	private JTextField num;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ajoutadherent window = new ajoutadherent();
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
	public ajoutadherent() {
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
		
		nom = new JTextField();
		nom.setBounds(301, 121, 352, 48);
		nom.setFont(new Font("Arial", Font.PLAIN, 13));
		frame.getContentPane().add(nom);
		nom.setColumns(10);
		
		prenom = new JTextField();
		prenom.setBounds(301, 185, 352, 48);
		prenom.setFont(new Font("Arial", Font.PLAIN, 13));
		prenom.setColumns(10);
		frame.getContentPane().add(prenom);
		
		email = new JTextField();
		email.setBounds(301, 258, 352, 48);
		email.setFont(new Font("Arial", Font.PLAIN, 13));
		email.setColumns(10);
		frame.getContentPane().add(email);
		
		JTextArea txtrNom = new JTextArea();
		txtrNom.setForeground(Color.YELLOW);
		txtrNom.setEditable(false);
		txtrNom.setBounds(45, 60, 158, 40);
		txtrNom.setBackground(new Color(240, 240, 240));
		txtrNom.setText("Nom :");
		txtrNom.setFont(new Font("Dialog", Font.BOLD, 25));
		frame.getContentPane().add(txtrNom);
		txtrNom.setOpaque(false);
		
		JTextArea txtrPrenom = new JTextArea();
		txtrPrenom.setForeground(Color.YELLOW);
		txtrPrenom.setEditable(false);
		txtrPrenom.setBounds(45, 185, 158, 40);
		txtrPrenom.setBackground(new Color(240, 240, 240));
		txtrPrenom.setText("Prenom  :");
		txtrPrenom.setFont(new Font("Dialog", Font.BOLD, 25));
		frame.getContentPane().add(txtrPrenom);
		txtrPrenom.setOpaque(false);
		
		JTextArea txtrEmail = new JTextArea();
		txtrEmail.setForeground(Color.YELLOW);
		txtrEmail.setEditable(false);
		txtrEmail.setBounds(45, 258, 158, 40);
		txtrEmail.setBackground(new Color(240, 240, 240));
		txtrEmail.setText("Email :");
		txtrEmail.setFont(new Font("Dialog", Font.BOLD, 25));
		frame.getContentPane().add(txtrEmail);
		txtrEmail.setOpaque(false);
		
		JTextArea txtrPageDajoutAdhrent = new JTextArea();
		txtrPageDajoutAdhrent.setForeground(Color.YELLOW);
		txtrPageDajoutAdhrent.setEditable(false);
		txtrPageDajoutAdhrent.setBounds(213, 0, 385, 49);
		txtrPageDajoutAdhrent.setBackground(new Color(240, 240, 240));
		txtrPageDajoutAdhrent.setText("Page d'ajout adhérent");
		txtrPageDajoutAdhrent.setFont(new Font("Dialog", Font.BOLD, 25));
		frame.getContentPane().add(txtrPageDajoutAdhrent);
		txtrPageDajoutAdhrent.setOpaque(false);
		
		JTextArea txtrEmail_1 = new JTextArea();
		txtrEmail_1.setForeground(Color.YELLOW);
		txtrEmail_1.setEditable(false);
		txtrEmail_1.setBounds(45, 121, 231, 40);
		txtrEmail_1.setText("Numéro adhérent : ");
		txtrEmail_1.setFont(new Font("Dialog", Font.BOLD, 25));
		txtrEmail_1.setBackground(new Color(243, 243, 243));
		frame.getContentPane().add(txtrEmail_1);
		txtrEmail_1.setOpaque(false);
		
		JLabel enter = new JLabel("");
		enter.setBounds(20, 26, 416, 30);
		frame.getContentPane().add(enter);
		
		num = new JTextField();
		num.setBounds(301, 60, 352, 48);
		frame.getContentPane().add(num);
		num.setColumns(10);
		
		JButton btnPrcedent = new JButton("");
		btnPrcedent.setIcon(new ImageIcon("photo/precedent.png"));
		btnPrcedent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnPrcedent.setFont(new Font("Dialog", Font.PLAIN, 17));
		btnPrcedent.setBounds(44, 351, 166, 48);
		frame.getContentPane().add(btnPrcedent);
		
		
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("photo/valider.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (num.getText()!=null && nom.getText()!=null && prenom.getText()!=null && email.getText()!=null) {
					
					try {
						mainMVC.getM().creationAdherent(num.getText(),nom.getText(),prenom.getText(),email.getText());
						enter.setText("L'inscription de "+nom.getText()+" a été effectuée");
					} catch (SQLException e1) {
						// ERREUR
						e1.printStackTrace();
						enter.setText("Le numero d'adhérent "+num.getText()+" est déjà utilisé");
						
					}
					
					nom.setText(null);
					prenom.setText(null);
					email.setText(null);
					num.setText(null);
					
				}
				
			}
		});
		
		btnNewButton.setBounds(400, 338, 138, 48);
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 17));
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("photo/Bibliothèque.jpg"));
		lblNewLabel.setBounds(0, 0, 692, 430);
		frame.getContentPane().add(lblNewLabel);
		
	}
}
