package view;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTextField;

import controller.mainMVC;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;

import java.awt.TextArea;

public class ajoutauteur {

	private JFrame frame;
	private JTextField nom;
	private JTextField prenom;
	private JTextField dateN;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ajoutauteur window = new ajoutauteur();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ajoutauteur() {
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

		JTextArea txtrPageDajoutAuteur = new JTextArea();
		txtrPageDajoutAuteur.setForeground(Color.YELLOW);
		txtrPageDajoutAuteur.setEditable(false);
		txtrPageDajoutAuteur.setText("Page d'ajout auteur");
		txtrPageDajoutAuteur.setFont(new Font("Dialog", Font.BOLD, 25));
		txtrPageDajoutAuteur.setBackground(SystemColor.menu);
		txtrPageDajoutAuteur.setBounds(216, 19, 347, 37);
		frame.getContentPane().add(txtrPageDajoutAuteur);
		txtrPageDajoutAuteur.setOpaque(false);

		JTextArea txtrNom = new JTextArea();
		txtrNom.setForeground(Color.YELLOW);
		txtrNom.setEditable(false);
		txtrNom.setText("Nom :");
		txtrNom.setFont(new Font("Dialog", Font.BOLD, 25));
		txtrNom.setBackground(SystemColor.menu);
		txtrNom.setBounds(10, 87, 142, 37);
		frame.getContentPane().add(txtrNom);
		txtrNom.setOpaque(false);

		JTextArea txtrPrenom = new JTextArea();
		txtrPrenom.setForeground(Color.YELLOW);
		txtrPrenom.setEditable(false);
		txtrPrenom.setText("Prenom :");
		txtrPrenom.setFont(new Font("Dialog", Font.BOLD, 25));
		txtrPrenom.setBackground(SystemColor.menu);
		txtrPrenom.setBounds(10, 139, 130, 43);
		frame.getContentPane().add(txtrPrenom);
		txtrPrenom.setOpaque(false);
		
		JTextArea txtrDateDeNaissance = new JTextArea();
		txtrDateDeNaissance.setForeground(Color.YELLOW);
		txtrDateDeNaissance.setEditable(false);
		txtrDateDeNaissance.setText("Date de naissance :");
		txtrDateDeNaissance.setFont(new Font("Dialog", Font.BOLD, 25));
		txtrDateDeNaissance.setBackground(SystemColor.menu);
		txtrDateDeNaissance.setBounds(10, 203, 238, 48);
		frame.getContentPane().add(txtrDateDeNaissance);
		txtrDateDeNaissance.setOpaque(false);

		nom = new JTextField();
		nom.setFont(new Font("Arial", Font.PLAIN, 13));
		nom.setColumns(10);
		nom.setBounds(258, 145, 379, 37);
		frame.getContentPane().add(nom);

		prenom = new JTextField();
		prenom.setFont(new Font("Arial", Font.PLAIN, 13));
		prenom.setColumns(10);
		prenom.setBounds(258, 203, 379, 37);
		frame.getContentPane().add(prenom);

		dateN = new JTextField();
		dateN.setFont(new Font("Arial", Font.PLAIN, 13));
		dateN.setColumns(10);
		dateN.setBounds(258, 91, 379, 40);
		frame.getContentPane().add(dateN);

		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("photo/valider.png"));

		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 17));
		btnNewButton.setBounds(389, 371, 130, 48);
		frame.getContentPane().add(btnNewButton);

		JButton btnPrcedent = new JButton("");
		btnPrcedent.setIcon(new ImageIcon("photo/precedent.png"));
		btnPrcedent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnPrcedent.setFont(new Font("Dialog", Font.PLAIN, 17));
		btnPrcedent.setBounds(14, 371, 171, 48);
		frame.getContentPane().add(btnPrcedent);

		JTextArea txtrDescription = new JTextArea();
		txtrDescription.setForeground(Color.YELLOW);
		txtrDescription.setText("Description :");
		txtrDescription.setFont(new Font("Dialog", Font.BOLD, 25));
		txtrDescription.setEditable(false);
		txtrDescription.setBackground(Color.WHITE);
		txtrDescription.setBounds(10, 262, 175, 48);
		frame.getContentPane().add(txtrDescription);
		txtrDescription.setOpaque(false);

		TextArea description = new TextArea();
		description.setBounds(258, 265, 379, 89);
		frame.getContentPane().add(description);
		
		JLabel enter = new JLabel("");
		enter.setBounds(42, 25, 368, 31);
		frame.getContentPane().add(enter);
		

		btnNewButton.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
			
				if (nom.getText()!=null && prenom.getText()!=null && dateN.getText()!=null && description.getText()!=null) {
					try {
						mainMVC.getM().creationAuteur(nom.getText(),prenom.getText(),dateN.getText(),description.getText());
						enter.setText("L'inscription de l'auteur "+nom.getText()+" a été effectuée");
					} catch (SQLException e1) {
						// ERREUR
						e1.printStackTrace();
						enter.setText("Une erreur est survenue lors de la saisie");
					}
					nom.setText(null);
					prenom.setText(null);
					dateN.setText(null);
					description.setText(null);
				}
			}
		});
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("photo/Bibliothèque.jpg"));
		lblNewLabel.setBounds(0, 0, 692, 430);
		frame.getContentPane().add(lblNewLabel);
	}
}
