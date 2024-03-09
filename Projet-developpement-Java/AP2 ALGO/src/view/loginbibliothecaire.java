package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.mainMVC;
import model.model;
import java.awt.Color;

public class loginbibliothecaire {

	private JFrame frame;
	private JTextField motdepasse;
	private JTextField login;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginbibliothecaire window = new loginbibliothecaire();
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
	public loginbibliothecaire() throws SQLException {
		initialize();
		frame.setVisible(true);
		mainMVC.getM().getAll();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 708, 469);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnPrcedent = new JButton("");
		btnPrcedent.setIcon(new ImageIcon("photo/precedent.png"));
		btnPrcedent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnPrcedent.setFont(new Font("Dialog", Font.PLAIN, 17));
		btnPrcedent.setBounds(55, 304, 167, 50);
		frame.getContentPane().add(btnPrcedent);
		
		JLabel lblConnexionBibliothecaire = new JLabel("Connexion Bibliothécaire");
		lblConnexionBibliothecaire.setForeground(Color.YELLOW);
		lblConnexionBibliothecaire.setFont(new Font("Dialog", Font.BOLD, 18));
		lblConnexionBibliothecaire.setBounds(219, 43, 256, 28);
		frame.getContentPane().add(lblConnexionBibliothecaire);
		
		motdepasse = new JPasswordField();
		motdepasse.setBounds(299, 210, 208, 28);
		frame.getContentPane().add(motdepasse);
		motdepasse.setColumns(10);
		
		login = new JTextField();
		login.setColumns(10);
		login.setBounds(299, 128, 208, 28);
		frame.getContentPane().add(login);
		
		JButton valider = new JButton("");
		valider.setIcon(new ImageIcon("photo/valider.png"));
		valider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String login2= login.getText();
				String motdepasse2 = motdepasse.getText();
				try {
					mainMVC.getM().connexionbiblio(login2, motdepasse2);
				} catch (NoSuchAlgorithmException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		valider.setFont(new Font("Dialog", Font.PLAIN, 17));
		valider.setBounds(336, 306, 132, 48);
		frame.getContentPane().add(valider);
		
		JLabel lblEmail = new JLabel("Identifiant :");
		lblEmail.setForeground(Color.YELLOW);
		lblEmail.setFont(new Font("Dialog", Font.BOLD, 18));
		lblEmail.setBounds(81, 128, 141, 22);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblMdp = new JLabel("Mot de passe :");
		lblMdp.setForeground(Color.YELLOW);
		lblMdp.setFont(new Font("Dialog", Font.BOLD, 18));
		lblMdp.setBounds(81, 210, 157, 22);
		frame.getContentPane().add(lblMdp);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon("photo/Bibliothèque.jpg"));
		background.setBounds(0, -16, 692, 463);
		frame.getContentPane().add(background);
	}
}
