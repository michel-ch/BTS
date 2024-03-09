package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class parametres {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					parametres window = new parametres();
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
	public parametres() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(102, 153, 204));
		frame.setBounds(100, 100, 922, 656);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton button_retour = new JButton("");
		button_retour.setBackground(new Color(192, 192, 192));
		button_retour.setIcon(new ImageIcon("image/button_precedent.png"));
		button_retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		button_retour.setFont(new Font("Tahoma", Font.PLAIN, 19));
		button_retour.setBounds(57, 531, 166, 46);
		frame.getContentPane().add(button_retour);
		button_retour.setOpaque(false);
		button_retour.setBorderPainted(false);
		
		JLabel lblParamtres = new JLabel("Paramètres");
		lblParamtres.setHorizontalAlignment(SwingConstants.CENTER);
		lblParamtres.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblParamtres.setBounds(371, 45, 216, 30);
		frame.getContentPane().add(lblParamtres);
		
		JButton btnAjoutDeProduit = new JButton("");
		btnAjoutDeProduit.setBackground(new Color(153, 102, 255));
		btnAjoutDeProduit.setIcon(new ImageIcon("image/button_ajout_produit.png"));
		btnAjoutDeProduit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ajout_produit_list vca = new ajout_produit_list();
			}
		});
		btnAjoutDeProduit.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnAjoutDeProduit.setBounds(99, 154, 264, 46);
		frame.getContentPane().add(btnAjoutDeProduit);
		btnAjoutDeProduit.setOpaque(false);
		btnAjoutDeProduit.setBorderPainted(false);
		
		JButton btnModificationProduits = new JButton("");
		btnModificationProduits.setBackground(new Color(204, 51, 51));
		btnModificationProduits.setIcon(new ImageIcon("image/button_modification-de-produit.png"));
		btnModificationProduits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modif_produit vca = new modif_produit();
			}
		});
		btnModificationProduits.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnModificationProduits.setBounds(99, 235, 264, 46);
		frame.getContentPane().add(btnModificationProduits);
		btnModificationProduits.setOpaque(false);
		btnModificationProduits.setBorderPainted(false);
		
		JButton btnSuppresionDeProduits = new JButton("");
		btnSuppresionDeProduits.setBackground(new Color(204, 51, 153));
		btnSuppresionDeProduits.setIcon(new ImageIcon("image/button_suppression-de-produit.png"));
		btnSuppresionDeProduits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				suppression_produit vca = new suppression_produit();
			}
		});
		btnSuppresionDeProduits.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnSuppresionDeProduits.setBounds(99, 319, 264, 46);
		frame.getContentPane().add(btnSuppresionDeProduits);
		btnSuppresionDeProduits.setOpaque(false);
		btnSuppresionDeProduits.setBorderPainted(false);
		
		JButton btnModificationTva = new JButton("");
		btnModificationTva.setBackground(new Color(204, 102, 255));
		btnModificationTva.setIcon(new ImageIcon("image/button_modification-tva.png"));
		btnModificationTva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modif_tva vca = new modif_tva();
			}
		});
		btnModificationTva.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnModificationTva.setBounds(460, 299, 392, 46);
		frame.getContentPane().add(btnModificationTva);
		btnModificationTva.setOpaque(false);
		btnModificationTva.setBorderPainted(false);
		
		JButton btnAjoutDeTransactions = new JButton("");
		btnAjoutDeTransactions.setBackground(new Color(255, 0, 153));
		btnAjoutDeTransactions.setIcon(new ImageIcon("image/button_ajout-de-transaction-regularisation.png"));
		btnAjoutDeTransactions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ajout_transaction vca = new ajout_transaction();
			}
		});
		btnAjoutDeTransactions.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnAjoutDeTransactions.setBounds(460, 191, 392, 46);
		frame.getContentPane().add(btnAjoutDeTransactions);
		btnAjoutDeTransactions.setOpaque(false);
		btnAjoutDeTransactions.setBorderPainted(false);
	}

}
