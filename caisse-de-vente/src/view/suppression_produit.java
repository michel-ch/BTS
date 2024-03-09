package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.List;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import controller.main;

import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.ImageIcon;

public class suppression_produit {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					suppression_produit window = new suppression_produit();
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
	public suppression_produit() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(102, 153, 204));
		frame.setBounds(100, 100, 720, 480);
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
		button_retour.setBounds(46, 342, 166, 46);
		frame.getContentPane().add(button_retour);
		button_retour.setOpaque(false);
		button_retour.setBorderPainted(false);
		
		JLabel lblNewLabel = new JLabel("Suppression de produit");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel.setBounds(243, 32, 205, 23);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel verif = new JLabel("");
		verif.setFont(new Font("Tahoma", Font.PLAIN, 15));
		verif.setBounds(58, 81, 583, 23);
		frame.getContentPane().add(verif);
		
		JComboBox combo = new JComboBox();
		combo.setBounds(275, 164, 386, 36);
		frame.getContentPane().add(combo);
		
		for (int i=0;i!=main.getM().getListProduits().size();i++) {
			combo.addItem(main.getM().getListProduits().get(i).getNom());
		}
		
		System.out.println(combo.getSelectedItem());
		
		JLabel lblProduitSupprimer = new JLabel("Produit à supprimer :");
		lblProduitSupprimer.setHorizontalAlignment(SwingConstants.CENTER);
		lblProduitSupprimer.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblProduitSupprimer.setBounds(46, 164, 205, 36);
		frame.getContentPane().add(lblProduitSupprimer);
		
		JButton btnValider = new JButton("");
		btnValider.setBackground(new Color(192, 192, 192));
		btnValider.setIcon(new ImageIcon("image/button_supprimer (1).png"));
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					main.getM().suppressionProduit(combo.getSelectedItem().toString());
					verif.setText("La suppression du produit a été effectuée");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					verif.setText("Une erreur est survenue");
				}
			}
		});
		btnValider.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnValider.setBounds(374, 342, 157, 46);
		frame.getContentPane().add(btnValider);
		btnValider.setOpaque(false);
		btnValider.setBorderPainted(false);
	}
}
