package view;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;

import controller.mainMVC;

import javax.swing.JList;
import javax.swing.JMenuBar;

import model.ADHERENT;
import model.LIVRE;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JLabel;
import java.awt.Color;

public class listelivre {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					listelivre window = new listelivre();
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
	public listelivre() throws SQLException {
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
		
		JButton btnPrcedent = new JButton("");
		btnPrcedent.setIcon(new ImageIcon("photo/precedent.png"));
		btnPrcedent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnPrcedent.setFont(new Font("Dialog", Font.PLAIN, 17));
		btnPrcedent.setBounds(64, 345, 169, 48);
		frame.getContentPane().add(btnPrcedent);
		btnPrcedent.setOpaque(false);
		btnPrcedent.setBorderPainted(false);
		
		JLabel lblListeDesLivres = new JLabel("Liste des livres");
		lblListeDesLivres.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblListeDesLivres.setBounds(255, 11, 175, 36);
		frame.getContentPane().add(lblListeDesLivres);
		
		List tableauliste = new List();
		tableauliste.setBackground(new Color(255, 250, 205));
		tableauliste.setBounds(64, 55, 575, 248);
		frame.getContentPane().add(tableauliste);
		
		for (int i=0;i!=mainMVC.getM().getListLivre().size();i++) {
			String emprunt;
			if(mainMVC.getM().getListLivre().get(i).getEmprunteur()!=null) {
				emprunt = "déjà emprunté";
			}
			else {
				emprunt = "libre";
			}
			tableauliste.add("ISBN : "+mainMVC.getM().getListLivre().get(i).getISBN()+" Titre : "+mainMVC.getM().getListLivre().get(i).getTitre()+" Prix : "+mainMVC.getM().getListLivre().get(i).getPrix()+" Disponibilité : "+emprunt);
		}
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon("photo/Bibliothèque.jpg"));
		background.setBounds(0, -33, 692, 463);
		frame.getContentPane().add(background);
	}
}
