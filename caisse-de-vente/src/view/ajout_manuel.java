package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.main;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Color;

public class ajout_manuel {

	private JFrame frame;
	private JTextField prix;
	private JTextField nom;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ajout_manuel window = new ajout_manuel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public ajout_manuel() {
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
		
		JLabel lblNewLabel = new JLabel("Ajout de produit manuel");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel.setBounds(258, 26, 216, 30);
		frame.getContentPane().add(lblNewLabel);
		
		prix = new JTextField();
		prix.setBounds(289, 227, 216, 36);
		frame.getContentPane().add(prix);
		prix.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Prix :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1.setBounds(144, 223, 70, 36);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nom :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1_1.setBounds(144, 123, 70, 36);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		nom = new JTextField();
		nom.setColumns(10);
		nom.setBounds(289, 127, 216, 36);
		frame.getContentPane().add(nom);
		
		JLabel verif = new JLabel("");
		verif.setHorizontalAlignment(SwingConstants.CENTER);
		verif.setFont(new Font("Tahoma", Font.PLAIN, 19));
		verif.setBounds(67, 67, 562, 30);
		frame.getContentPane().add(verif);
		
		JButton button_retour = new JButton("");
		button_retour.setBackground(new Color(192, 192, 192));
		button_retour.setIcon(new ImageIcon("image/button_precedent.png"));
		button_retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		button_retour.setFont(new Font("Tahoma", Font.PLAIN, 19));
		button_retour.setBounds(57, 335, 157, 46);
		frame.getContentPane().add(button_retour);
		button_retour.setOpaque(false);
		button_retour.setBorderPainted(false);
		
		JComboBox quantite = new JComboBox();
		quantite.setMaximumRowCount(20);
		quantite.setBounds(554, 230, 121, 30);
		frame.getContentPane().add(quantite);
		
		for (int i=1;i!=21;i++) {
			quantite.addItem(i);
		}
		
		JLabel label = new JLabel("Quantité :");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label.setBounds(554, 177, 121, 30);
		frame.getContentPane().add(label);
		
		JButton btnValider = new JButton("");
		btnValider.setBackground(new Color(192, 192, 192));
		btnValider.setIcon(new ImageIcon("image/button_valider 2.png"));
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!prix.getText().isEmpty()&&!nom.getText().isEmpty()) {
					try {
						Float.parseFloat(prix.getText());
						float prixfloat = Float.parseFloat( prix.getText() ); 
						main.getM().ajoutticket(nom.getText(),Integer.parseInt(quantite.getSelectedItem().toString()),prixfloat);
						verif.setText("Le produit "+nom.getText()+" a bien été ajouté au ticket au prix de "+prix.getText()+" .");
						
						
					} catch (SQLException e1) {
						verif.setText("Veuillez saisir un nom de produit et un montant correct.");
						e1.printStackTrace();
					}
				}
				else {
					verif.setText("Veuillez saisir un nom de produit et un montant.");
				}
			}
		});
		btnValider.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnValider.setBounds(334, 335, 157, 46);
		frame.getContentPane().add(btnValider);
		btnValider.setOpaque(false);
		btnValider.setBorderPainted(false);
	}
}
