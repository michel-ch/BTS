package view;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

import controller.mainMVC;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;

import model.AUTEUR;
import model.LIVRE;
import javax.swing.JLabel;

public class ajoutlivre {

	private JFrame frame;
	private JTextField titre;
	private JTextField ISBN;
	private JTextArea txtrCodeBarre;
	private JTextArea txtrAuteur;
	private JTextArea r;
	private JButton btnPrcedent;
	private JTextField prix;
	private JTextArea txtrPrix;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ajoutlivre window = new ajoutlivre();
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
	public ajoutlivre() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		int auteur[]=new int[999];
		frame = new JFrame();
		frame.setBounds(100, 100, 708, 469);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		titre = new JTextField();
		titre.setBounds(214, 132, 448, 38);
		frame.getContentPane().add(titre);
		titre.setColumns(10);
		
		ISBN = new JTextField();
		ISBN.setBounds(214, 66, 448, 38);
		frame.getContentPane().add(ISBN);
		ISBN.setColumns(10);
		
		JTextArea txtrAda = new JTextArea();
		txtrAda.setForeground(Color.YELLOW);
		txtrAda.setEditable(false);
		txtrAda.setFont(new Font("Dialog", Font.BOLD, 25));
		txtrAda.setBackground(new Color(240, 240, 240));
		txtrAda.setText("Titre : ");
		txtrAda.setBounds(47, 127, 95, 38);
		frame.getContentPane().add(txtrAda);
		txtrAda.setOpaque(false);
		
		txtrCodeBarre = new JTextArea();
		txtrCodeBarre.setForeground(Color.YELLOW);
		txtrCodeBarre.setEditable(false);
		txtrCodeBarre.setFont(new Font("Dialog", Font.BOLD, 25));
		txtrCodeBarre.setBackground(new Color(240, 240, 240));
		txtrCodeBarre.setText("Code Barre :");
		txtrCodeBarre.setBounds(47, 61, 148, 43);
		frame.getContentPane().add(txtrCodeBarre);
		txtrCodeBarre.setOpaque(false);
		
		txtrAuteur = new JTextArea();
		txtrAuteur.setForeground(Color.YELLOW);
		txtrAuteur.setFont(new Font("Dialog", Font.BOLD, 25));
		txtrAuteur.setText("Auteur : ");
		txtrAuteur.setBackground(new Color(240, 240, 240));
		txtrAuteur.setBounds(47, 235, 105, 38);
		frame.getContentPane().add(txtrAuteur);
		txtrAuteur.setOpaque(false);
		
		r = new JTextArea();
		r.setForeground(Color.YELLOW);
		r.setEditable(false);
		r.setFont(new Font("Dialog", Font.BOLD, 25));
		r.setBackground(new Color(240, 240, 240));
		r.setText("Page d'ajout de livres");
		r.setBounds(253, 17, 362, 38);
		frame.getContentPane().add(r);
		r.setOpaque(false);
		
		btnPrcedent = new JButton("");
		btnPrcedent.setIcon(new ImageIcon("photo/precedent.png"));
		btnPrcedent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnPrcedent.setFont(new Font("Dialog", Font.PLAIN, 17));
		btnPrcedent.setBounds(48, 319, 168, 48);
		frame.getContentPane().add(btnPrcedent);
		
		prix = new JTextField();
		prix.setColumns(10);
		prix.setBounds(214, 181, 448, 38);
		frame.getContentPane().add(prix);
		
		txtrPrix = new JTextArea();
		txtrPrix.setForeground(Color.YELLOW);
		txtrPrix.setEditable(false);
		txtrPrix.setText("Prix : ");
		txtrPrix.setFont(new Font("Dialog", Font.BOLD, 25));
		txtrPrix.setBackground(new Color(240, 240, 240));
		txtrPrix.setBounds(47, 187, 95, 37);
		frame.getContentPane().add(txtrPrix);
		txtrPrix.setOpaque(false);
		
		JLabel sortie = new JLabel("");
		sortie.setBounds(47, 204, 336, 31);
		frame.getContentPane().add(sortie);
		
		JComboBox <String>listeauteur = new JComboBox<String>();
		listeauteur.setForeground(Color.RED);
		listeauteur.setBounds(214, 240, 448, 38);
		frame.getContentPane().add(listeauteur);
		// System.out.println(mainMVC.getM().getListAuteur().size());
		for (int i=0;i<mainMVC.getM().getListAuteur().size();i++) {
			listeauteur.addItem(mainMVC.getM().getListAuteur().get(i).getNom()+" "+mainMVC.getM().getListAuteur().get(i).getPrenom());
			auteur[i]=mainMVC.getM().getListAuteur().get(i).getNum();
		}
		
		
		JButton entrer = new JButton("");
		entrer.setIcon(new ImageIcon("photo/valider.png"));
		entrer.setFont(new Font("Arial", Font.PLAIN, 17));
		entrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int numAuteur=auteur[listeauteur.getSelectedIndex()]; /// NUMERO DE LISTE DE LA FILE DEROULANTE ENTIER
				AUTEUR lauteur=mainMVC.getM().findlAuteur(numAuteur); /// FINDLAUTEUR POUR EN TYPE AUTEUR
				System.out.println(lauteur.getDescription());
				if (ISBN.getText()!=null && ISBN.getText()!=null && prix.getText()!=null) {
					float prixfloat = Float.parseFloat(prix.getText());
					try {
						mainMVC.getM().creationlivre(ISBN.getText(),titre.getText(),prixfloat,lauteur);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else {
					
				}
			}
		});
		entrer.setBounds(370, 319, 138, 48);
		frame.getContentPane().add(entrer);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("photo/Bibliothèque.jpg"));
		lblNewLabel.setBounds(0, 0, 692, 430);
		frame.getContentPane().add(lblNewLabel);
	}
}
