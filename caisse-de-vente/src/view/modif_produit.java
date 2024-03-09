package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import controller.main;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.ImageIcon;

public class modif_produit {

	private JFrame frame;
	private JTextField nouveau_nom;
	private JTextField nouveau_prix;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					modif_produit window = new modif_produit();
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
	public modif_produit() {
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
		button_retour.setBounds(46, 342, 157, 46);
		frame.getContentPane().add(button_retour);
		button_retour.setOpaque(false);
		button_retour.setBorderPainted(false);
		
		JLabel lblModificationDeProduit = new JLabel("Modification de produit");
		lblModificationDeProduit.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificationDeProduit.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblModificationDeProduit.setBounds(251, 11, 205, 23);
		frame.getContentPane().add(lblModificationDeProduit);
		
		JLabel verif = new JLabel("infos");
		verif.setFont(new Font("Tahoma", Font.PLAIN, 15));
		verif.setBounds(83, 99, 583, 23);
		frame.getContentPane().add(verif);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setHorizontalAlignment(SwingConstants.LEFT);
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNom.setBounds(153, 133, 63, 36);
		frame.getContentPane().add(lblNom);
		
		JLabel lblPrix = new JLabel("Prix :");
		lblPrix.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrix.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblPrix.setBounds(153, 180, 50, 36);
		frame.getContentPane().add(lblPrix);
		
		JLabel nom_produit = new JLabel("--");
		nom_produit.setHorizontalAlignment(SwingConstants.CENTER);
		nom_produit.setFont(new Font("Tahoma", Font.PLAIN, 19));
		nom_produit.setBounds(320, 133, 177, 36);
		frame.getContentPane().add(nom_produit);
		
		JLabel prix_produit = new JLabel("--");
		prix_produit.setHorizontalAlignment(SwingConstants.CENTER);
		prix_produit.setFont(new Font("Tahoma", Font.PLAIN, 19));
		prix_produit.setBounds(378, 180, 63, 36);
		frame.getContentPane().add(prix_produit);
		
		JLabel lbl€ = new JLabel("€");
		lbl€.setHorizontalAlignment(SwingConstants.CENTER);
		lbl€.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lbl€.setBounds(438, 180, 29, 36);
		frame.getContentPane().add(lbl€);
		
		nouveau_nom = new JTextField();
		nouveau_nom.setColumns(10);
		nouveau_nom.setBounds(350, 228, 216, 36);
		frame.getContentPane().add(nouveau_nom);
		
		nouveau_prix = new JTextField();
		nouveau_prix.setColumns(10);
		nouveau_prix.setBounds(350, 282, 216, 36);
		frame.getContentPane().add(nouveau_prix);
		
		JLabel lblNouveauNom = new JLabel("Nouveau nom :");
		lblNouveauNom.setHorizontalAlignment(SwingConstants.LEFT);
		lblNouveauNom.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNouveauNom.setBounds(153, 224, 166, 36);
		frame.getContentPane().add(lblNouveauNom);
		
		JLabel lblNouveauPrix = new JLabel("Nouveau prix :");
		lblNouveauPrix.setHorizontalAlignment(SwingConstants.LEFT);
		lblNouveauPrix.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNouveauPrix.setBounds(153, 278, 166, 36);
		frame.getContentPane().add(lblNouveauPrix);
		
		JComboBox combo = new JComboBox();
		combo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// System.out.println(combo.getSelectedItem());
				String a = combo.getSelectedItem().toString();
				nom_produit.setText(main.getM().findproduits(a).getNom());
				prix_produit.setText(String.valueOf(main.getM().findproduits(a).getPrix()));
			}
		});
		combo.setBounds(153, 55, 434, 36);
		frame.getContentPane().add(combo);
		
		combo.removeAllItems();
		for (int i=0;i!=main.getM().getListProduits().size();i++) {
			combo.addItem(main.getM().getListProduits().get(i).getNom());	
		}
		
		JButton btnValider = new JButton("");
		btnValider.setBackground(new Color(192, 192, 192));
		btnValider.setIcon(new ImageIcon("image/button_valider 2.png"));
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(nouveau_nom.getText()==null&&nouveau_prix.getText()==null) {
					verif.setText("Veuillez insérer au moins une donnée à modifier.");
				}
				else {
					float prix;
					String nom,origine;
					if(nouveau_nom.getText().isEmpty()&&!nouveau_prix.getText().isEmpty()) {
						prix = Float.parseFloat(nouveau_prix.getText());
						nom = main.getM().findproduits(combo.getSelectedItem().toString()).getNom();
						origine = nom;
						System.out.println("origine : "+origine+" nom : "+nom+" prix: "+prix);
						try {
							main.getM().modifProduit(nom,nom, prix);
						} catch (NumberFormatException | SQLException e1) {
							verif.setText("Une ERREUR est survenue veuillez contacter le support.");
							e1.printStackTrace();
						}
					}
					else if(!nouveau_nom.getText().isEmpty()&&nouveau_prix.getText().isEmpty()){
						nom = nouveau_nom.getText();
						prix = main.getM().findproduits(combo.getSelectedItem().toString()).getPrix();
						origine = main.getM().findproduits(combo.getSelectedItem().toString()).getNom();
						System.out.println("origine : "+origine+" nom : "+nom+" prix: "+prix);
						try {
							main.getM().modifProduit(origine,nom, prix);
						} catch (NumberFormatException | SQLException e1) {
							verif.setText("Une ERREUR est survenue veuillez contacter le support.");
							e1.printStackTrace();
						}
					}
					else {
						nom = nouveau_nom.getText();
						prix = Float.parseFloat(nouveau_prix.getText());
						origine = main.getM().findproduits(combo.getSelectedItem().toString()).getNom();
						System.out.println("origine : "+origine+" nom : "+nom+" prix: "+prix);
						try {
							main.getM().modifProduit(origine,nom, prix);
						} catch (NumberFormatException | SQLException e1) {
							verif.setText("Une ERREUR est survenue veuillez contacter le support.");
							e1.printStackTrace();
						}
					}
					
				}
			}
		});
		btnValider.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnValider.setBounds(378, 342, 157, 46);
		frame.getContentPane().add(btnValider);
		btnValider.setOpaque(false);
		btnValider.setBorderPainted(false);
	}

}
