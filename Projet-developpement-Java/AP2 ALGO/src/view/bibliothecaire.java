package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.mainMVC;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class bibliothecaire {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bibliothecaire window = new bibliothecaire();
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
	public bibliothecaire() throws SQLException {
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
		
		JButton ajoutadherent = new JButton("");
		ajoutadherent.setIcon(new ImageIcon("photo/ajout_adherent.png"));
		ajoutadherent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ajoutadherent vca = new ajoutadherent();
			}
		});
		ajoutadherent.setBounds(126, 126, 176, 45);
		frame.getContentPane().add(ajoutadherent);
		
		JButton ajoutauteur = new JButton("");
		ajoutauteur.setIcon(new ImageIcon("photo/ajout_auteur.png"));
		ajoutauteur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ajoutauteur vca = new ajoutauteur();
			}
		});
		ajoutauteur.setBounds(391, 302, 176, 45);
		frame.getContentPane().add(ajoutauteur);
		
		JButton ajoutlivre = new JButton("");
		ajoutlivre.setIcon(new ImageIcon("photo/ajout_livre.png"));
		ajoutlivre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ajoutlivre vca = new ajoutlivre();
			}
		});
		ajoutlivre.setBounds(391, 126, 176, 45);
		frame.getContentPane().add(ajoutlivre);
		
		JButton btnPrcedent = new JButton("");
		btnPrcedent.setIcon(new ImageIcon("photo/precedent.png"));
		btnPrcedent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnPrcedent.setFont(new Font("Dialog", Font.PLAIN, 17));
		btnPrcedent.setBounds(126, 302, 165, 45);
		frame.getContentPane().add(btnPrcedent);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("photo/Bibliothèque.jpg"));
		lblNewLabel.setBounds(0, 0, 692, 430);
		frame.getContentPane().add(lblNewLabel);
		
	}

}
