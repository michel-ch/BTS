package view;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.TextArea;

import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.CaretListener;

import controller.mainMVC;
import model.LIVRE;

import javax.swing.event.CaretEvent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;

import model.ADHERENT;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import model.model;
import controller.mainMVC;
import java.awt.TextField;
import java.awt.List;
import java.awt.Label;
import javax.swing.JLabel;
import java.awt.SystemColor;

public class vosinfo {

	private JFrame frame;

	private static String password="";
	private static String username="root";
	private static Connection connection;
	private static Statement command;
	private static ResultSet data;
	static String BDD = "AP2prof";
	private static String connectionString = "jdbc:mysql://localhost:3306/"+BDD;

	private ArrayList <LIVRE> listelivres; // LISTE LIVRES
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vosinfo window = new vosinfo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				System.out.println("Erreur");
			}
			// System.out.println(connectionString+"-"+username+"-"+password); IMPRESSION url / username / password

			connection = DriverManager.getConnection(connectionString,username,password);
			command = connection.createStatement();
			//command.execute("INSERT INTO `PERSONNE` (`id`, `nom`, `prenom`, `age`) VALUES ('9', 'da', 'prenom', '10');");
			String requete = "SELECT * FROM livre";
			data = command.executeQuery(requete);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erreur");
		} finally {
			// System.out.println("1");
			try {
				ArrayList <LIVRE> listelivre;
				listelivre = new ArrayList<LIVRE>();
				LIVRE livre;
				while (data.next()) {
					System.out.println("ISBN : "+data.getString(1));
					System.out.println("titre : "+data.getString(2));
					System.out.println("prix : "+data.getFloat(3));
					// LIVRE livre = "livre"+data.getString(1);
					// System.out.println(livre);
					livre = new LIVRE (data.getString(1),data.getString(2),data.getFloat(3));
					listelivre.add(livre);
					for (int i=0;i<listelivre.size();i++) {
						System.out.println(listelivre.get(i).getISBN()+" "+listelivre.get(i).getTitre()+" "+listelivre.get(i).getPrix()+" "+listelivre.get(i).getAuteur()+" "+listelivre.get(i).getEmprunteur());
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Erreur");
			}
		}
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public vosinfo() throws SQLException {
		mainMVC.getM().getAll();
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.RED);
		frame.setBounds(100, 100, 708, 469);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnPrcedent_1 = new JButton("");
		btnPrcedent_1.setIcon(new ImageIcon("photo/precedent.png"));
		btnPrcedent_1.setForeground(Color.ORANGE);
		btnPrcedent_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnPrcedent_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnPrcedent_1.setBounds(34, 353, 170, 48);
		frame.getContentPane().add(btnPrcedent_1);
		btnPrcedent_1.setOpaque(false);
		btnPrcedent_1.setBackground(null);
		btnPrcedent_1.setBorderPainted(false);
		
		JTextArea txtrNom = new JTextArea();
		txtrNom.setForeground(Color.YELLOW);
		txtrNom.setOpaque(false);
		txtrNom.setEditable(false);
		txtrNom.setText("Nom :");
		txtrNom.setFont(new Font("Dialog", Font.PLAIN, 24));
		txtrNom.setBackground(new Color(240, 240, 240));
		txtrNom.setBounds(34, 177, 108, 39);
		frame.getContentPane().add(txtrNom);

		JTextArea txtrPrnom = new JTextArea();
		txtrPrnom.setForeground(Color.YELLOW);
		txtrPrnom.setEditable(false);
		txtrPrnom.setOpaque(false);
		txtrPrnom.setText("Prénom :");
		txtrPrnom.setFont(new Font("Dialog", Font.PLAIN, 24));
		txtrPrnom.setBackground(new Color(240, 240, 240));
		txtrPrnom.setBounds(34, 238, 108, 33);
		frame.getContentPane().add(txtrPrnom);

		JTextArea txtrEmail = new JTextArea();
		txtrEmail.setForeground(Color.YELLOW);
		txtrEmail.setEditable(false);
		txtrEmail.setOpaque(false);
		txtrEmail.setText("Email :");
		txtrEmail.setFont(new Font("Dialog", Font.PLAIN, 24));
		txtrEmail.setBackground(new Color(240, 240, 240));
		txtrEmail.setBounds(34, 296, 108, 33);
		frame.getContentPane().add(txtrEmail);

		JTextArea txtrNumroAdhrent = new JTextArea();
		txtrNumroAdhrent.setForeground(Color.YELLOW);
		txtrNumroAdhrent.setOpaque(false);
		txtrNumroAdhrent.setEditable(false);
		txtrNumroAdhrent.setText("Numéro adhérent :");
		txtrNumroAdhrent.setFont(new Font("Dialog", Font.PLAIN, 24));
		txtrNumroAdhrent.setBackground(new Color(240, 240, 240));
		txtrNumroAdhrent.setBounds(34, 70, 218, 34);
		frame.getContentPane().add(txtrNumroAdhrent);

		JTextArea txtrVosInformations = new JTextArea();
		txtrVosInformations.setForeground(Color.YELLOW);
		txtrVosInformations.setOpaque(false);
		txtrVosInformations.setEditable(false);
		txtrVosInformations.setBackground(new Color(243, 243, 243));
		txtrVosInformations.setFont(new Font("Dialog", Font.PLAIN, 21));
		txtrVosInformations.setText("Vos informations");
		txtrVosInformations.setBounds(257, 0, 232, 30);
		frame.getContentPane().add(txtrVosInformations);

		JTextArea nom = new JTextArea();
		nom.setEditable(false);
		nom.setFont(new Font("Monospaced", Font.PLAIN, 18));
	
		nom.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {

			}
		});
		nom.setBounds(182, 177, 209, 39);
		frame.getContentPane().add(nom);

		JTextArea prenom = new JTextArea();
		prenom.setFont(new Font("Monospaced", Font.PLAIN, 18));
		prenom.setEditable(false);
		prenom.setBounds(182, 234, 209, 37);
		frame.getContentPane().add(prenom);

		JTextArea email = new JTextArea();
		email.setFont(new Font("Monospaced", Font.PLAIN, 18));
		email.setEditable(false);
		email.setBounds(182, 296, 209, 37);
		frame.getContentPane().add(email);
		
		TextField num = new TextField();
		num.setFont(new Font("Monospaced", Font.PLAIN, 18));
		num.setBackground(SystemColor.window);
		num.setBounds(274, 65, 117, 39);
		frame.getContentPane().add(num);
		
		JTextArea verif = new JTextArea();
		verif.setFont(new Font("Monospaced", Font.PLAIN, 18));
		verif.setEditable(false);
		verif.setForeground(Color.RED);
		verif.setBounds(179, 35, 297, 33);
		frame.getContentPane().add(verif);
		verif.setOpaque(false);
		
		List list = new List();
		list.setBounds(415, 98, 247, 322);
		frame.getContentPane().add(list);
		
		JButton valider = new JButton("Valider");
		valider.setIcon(new ImageIcon("photo/valider.png"));
		valider.setForeground(Color.ORANGE);
		valider.setFont(new Font("Tahoma", Font.PLAIN, 18));
		valider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(num.getText()==null) {
					verif.setText("Erreur, aucun numero d'utilisateur saisi"); /// MARCHE PAS
				}
				else {
					ADHERENT ad;
					if (mainMVC.getM().findadherent(num.getText()) != null){
						verif.setText(null);
						ad = mainMVC.getM().findadherent(num.getText());
						nom.setText(ad.getNom());
						prenom.setText(ad.getPrenom());
						email.setText(ad.getEmail());
						list.removeAll();
						for (int i=0;i!=ad.getListelivres().size();i++) {
							list.add("ISBN : "+ad.getListelivres().get(i).getISBN()+" Titre : "+ad.getListelivres().get(i).getTitre()+" Prix : "+ad.getListelivres().get(i).getPrix());
						}
					}
					else {
						verif.setText("Le numéro d'adhérent saisi est incorrect.");
					}
				}
			}
		});
		valider.setBounds(274, 127, 117, 39);
		frame.getContentPane().add(valider);
		valider.setOpaque(false);
		valider.setBorderPainted(false);
		
		JButton btnSupprimerVosDonnes = new JButton("");
		btnSupprimerVosDonnes.setIcon(new ImageIcon("photo/supprimerinfos.png"));
		btnSupprimerVosDonnes.setForeground(Color.ORANGE);
		btnSupprimerVosDonnes.setOpaque(false);
		btnSupprimerVosDonnes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSupprimerVosDonnes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nom.setText(null);
				prenom.setText(null);
				email.setText(null);
				num.setText(null);
				list.removeAll();
				verif.setText(null);
			}
		});
		btnSupprimerVosDonnes.setBounds(11, 127, 253, 39);
		frame.getContentPane().add(btnSupprimerVosDonnes);
		btnSupprimerVosDonnes.setOpaque(false);
		btnSupprimerVosDonnes.setBorderPainted(false);
		
		JLabel lblListeDeVos = new JLabel("Liste de vos livres empruntés");
		lblListeDeVos.setForeground(Color.YELLOW);
		lblListeDeVos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblListeDeVos.setBounds(415, 62, 267, 30);
		frame.getContentPane().add(lblListeDeVos);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("photo/Bibliothèque.jpg"));
		lblNewLabel.setBounds(0, 0, 692, 430);
		frame.getContentPane().add(lblNewLabel);
		
		
	}
}
