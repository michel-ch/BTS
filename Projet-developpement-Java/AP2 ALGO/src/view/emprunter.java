package view;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.mainMVC;

import java.awt.BorderLayout;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

import model.LIVRE;
import model.ADHERENT;

public class emprunter {

	private JFrame frame;
	private JTextField ISBN;
	private JTextField emprunteur;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					emprunter window = new emprunter();
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
	public emprunter() throws SQLException {
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

		ISBN = new JTextField();
		ISBN.setBackground(new Color(255, 255, 255));
		ISBN.setBounds(235, 136, 296, 60);
		frame.getContentPane().add(ISBN);
		ISBN.setColumns(10);

		JTextArea code = new JTextArea();
		code.setForeground(Color.YELLOW);
		code.setEditable(false);
		code.setBackground(new Color(240, 240, 240));
		code.setFont(new Font("Arial", Font.PLAIN, 25));
		code.setText("Code Barre :");
		code.setBounds(25, 145, 165, 44);
		frame.getContentPane().add(code);
		code.setOpaque(false);
		
		JTextArea txtrPageDemprunt = new JTextArea();
		txtrPageDemprunt.setForeground(Color.YELLOW);
		txtrPageDemprunt.setEditable(false);
		txtrPageDemprunt.setFont(new Font("Arial", Font.PLAIN, 26));
		txtrPageDemprunt.setText("Page d'emprunt");
		txtrPageDemprunt.setBackground(new Color(240, 240, 240));
		txtrPageDemprunt.setBounds(259, 11, 195, 43);
		frame.getContentPane().add(txtrPageDemprunt);
		txtrPageDemprunt.setOpaque(false);

		emprunteur = new JTextField();
		emprunteur.setColumns(10);
		emprunteur.setBackground(Color.WHITE);
		emprunteur.setBounds(235, 236, 296, 60);
		frame.getContentPane().add(emprunteur);

		JTextArea t = new JTextArea();
		t.setForeground(Color.YELLOW);
		t.setEditable(false);
		t.setText("Emprunteur : ");
		t.setFont(new Font("Arial", Font.PLAIN, 25));
		t.setBackground(new Color(243, 243, 243));
		t.setBounds(25, 245, 144, 49);
		frame.getContentPane().add(t);
		t.setOpaque(false);

		JTextArea resultat = new JTextArea();
		resultat.setForeground(Color.YELLOW);
		resultat.setFont(new Font("Monospaced", Font.PLAIN, 17));
		resultat.setEditable(false);
		resultat.setBackground(SystemColor.control);
		resultat.setBounds(235, 65, 301, 44);
		frame.getContentPane().add(resultat);
		resultat.setOpaque(false);

		JButton btnPrcedent = new JButton("");
		btnPrcedent.setIcon(new ImageIcon("photo/precedent.png"));
		btnPrcedent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnPrcedent.setFont(new Font("Dialog", Font.PLAIN, 17));
		btnPrcedent.setBounds(54, 339, 171, 49);
		frame.getContentPane().add(btnPrcedent);
		btnPrcedent.setOpaque(false);
		btnPrcedent.setBorderPainted(false);

		JButton valider = new JButton("");
		valider.setIcon(new ImageIcon("photo/valider.png"));
		valider.setFont(new Font("Tahoma", Font.PLAIN, 17));
		valider.setOpaque(false);
		valider.setBorderPainted(false);
		valider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					resultat.setText(null);
					System.out.println(mainMVC.getM().verif(ISBN.getText()));
					if (mainMVC.getM().verif(ISBN.getText())=="libre") {
						mainMVC.getM().emprunt(ISBN.getText(), emprunteur.getText());
						resultat.setText("Vous avez emprunté le livre "+ISBN.getText()+" avec succès.");
					}
					else if(mainMVC.getM().verif(ISBN.getText())=="dejaemprunte") {
						resultat.setText("Le livre "+ISBN.getText()+" a déjà été emprunté.");
					}
					else if(mainMVC.getM().verif(ISBN.getText())=="erreur"){
						resultat.setText("Les informations saisies ne sont pas corrects.");
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		valider.setBounds(330, 339, 132, 49);
		frame.getContentPane().add(valider);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon("photo/Bibliothèque.jpg"));
		background.setBounds(0, -33, 692, 463);
		frame.getContentPane().add(background);
	}
}
