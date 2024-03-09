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
import java.awt.Color;
import javax.swing.ImageIcon;

public class modif_tva {

	private JFrame frame;
	private JTextField tva;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					modif_tva window = new modif_tva();
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
	public modif_tva() {
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
		
		JLabel lblModificationDeLa = new JLabel("Modification de la TVA");
		lblModificationDeLa.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificationDeLa.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblModificationDeLa.setBounds(246, 44, 205, 23);
		frame.getContentPane().add(lblModificationDeLa);
		
		JLabel verif = new JLabel("");
		verif.setFont(new Font("Tahoma", Font.PLAIN, 15));
		verif.setBounds(72, 100, 583, 23);
		frame.getContentPane().add(verif);
		
		JLabel lblTvaActuelle = new JLabel("TVA actuelle :");
		lblTvaActuelle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTvaActuelle.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblTvaActuelle.setBounds(139, 139, 177, 36);
		frame.getContentPane().add(lblTvaActuelle);
		
		JLabel tva_actuelle = new JLabel("--");
		tva_actuelle.setHorizontalAlignment(SwingConstants.CENTER);
		tva_actuelle.setFont(new Font("Tahoma", Font.PLAIN, 19));
		tva_actuelle.setBounds(371, 139, 66, 36);
		frame.getContentPane().add(tva_actuelle);
		
		tva = new JTextField();
		tva.setColumns(10);
		tva.setBounds(324, 225, 216, 36);
		frame.getContentPane().add(tva);
		
		JLabel tva_actuelle_1 = new JLabel("%");
		tva_actuelle_1.setHorizontalAlignment(SwingConstants.CENTER);
		tva_actuelle_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		tva_actuelle_1.setBounds(440, 139, 29, 36);
		frame.getContentPane().add(tva_actuelle_1);
		
		tva_actuelle.setText(String.valueOf(main.getM().getTVA().get(0).getTva()));
		
		JButton btnValider = new JButton("");
		btnValider.setBackground(new Color(192, 192, 192));
		btnValider.setIcon(new ImageIcon("image/button_valider 2.png"));
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Float.parseFloat(tva.getText())<100) {
					try {
						main.getM().modifTVA(Float.parseFloat(tva.getText()));
						verif.setText("La TVA a bien été changé à hauteur de : "+tva.getText()+" %");
						tva_actuelle.setText(String.valueOf(main.getM().getTVA().get(0).getTva()));
					} catch (NumberFormatException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						verif.setText("Une ERREUR est survenue veuillez contacter le support.");
					}
				}
				else {
					verif.setText("Veuillez entrer un chiffre entre 0 et 100.");
				}
			}
		});
		btnValider.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnValider.setBounds(350, 342, 157, 46);
		frame.getContentPane().add(btnValider);
		btnValider.setOpaque(false);
		btnValider.setBorderPainted(false);
	}
}
