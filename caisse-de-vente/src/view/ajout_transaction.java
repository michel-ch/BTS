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

public class ajout_transaction {

	private JFrame frame;
	private JTextField paiement;
	private JTextField montant;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ajout_transaction window = new ajout_transaction();
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
	public ajout_transaction() {
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
		button_retour.setBounds(46, 353, 166, 46);
		frame.getContentPane().add(button_retour);
		button_retour.setOpaque(false);
		button_retour.setBorderPainted(false);
		
		JLabel lblAjoutDeTransaction = new JLabel("Ajout de transaction");
		lblAjoutDeTransaction.setHorizontalAlignment(SwingConstants.CENTER);
		lblAjoutDeTransaction.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblAjoutDeTransaction.setBounds(250, 26, 205, 23);
		frame.getContentPane().add(lblAjoutDeTransaction);
		
		JLabel verif = new JLabel("");
		verif.setHorizontalAlignment(SwingConstants.CENTER);
		verif.setFont(new Font("Tahoma", Font.PLAIN, 15));
		verif.setBounds(60, 82, 583, 23);
		frame.getContentPane().add(verif);
		
		JLabel lblTypeDePaiement = new JLabel("Type de paiement :");
		lblTypeDePaiement.setHorizontalAlignment(SwingConstants.LEFT);
		lblTypeDePaiement.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblTypeDePaiement.setBounds(103, 139, 173, 36);
		frame.getContentPane().add(lblTypeDePaiement);
		
		JLabel lblMontant = new JLabel("Montant :");
		lblMontant.setHorizontalAlignment(SwingConstants.LEFT);
		lblMontant.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblMontant.setBounds(103, 255, 125, 36);
		frame.getContentPane().add(lblMontant);
		
		paiement = new JTextField();
		paiement.setColumns(10);
		paiement.setBounds(343, 143, 216, 36);
		frame.getContentPane().add(paiement);
		
		montant = new JTextField();
		montant.setColumns(10);
		montant.setBounds(343, 259, 216, 36);
		frame.getContentPane().add(montant);
		
		JLabel lbl€ = new JLabel("€");
		lbl€.setHorizontalAlignment(SwingConstants.LEFT);
		lbl€.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lbl€.setBounds(569, 259, 21, 36);
		frame.getContentPane().add(lbl€);
		
		JButton btnValider = new JButton("");
		btnValider.setBackground(new Color(192, 192, 192));
		btnValider.setIcon(new ImageIcon("image/button_valider 2.png"));
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!montant.getText().isEmpty()&&!paiement.getText().isEmpty()) {
					try {
						float a = Float.parseFloat(montant.getText());
						System.out.println("paiement : "+paiement.getText()+" montant : "+montant.getText());
						main.getM().creationTransaction(paiement.getText(),a);
						verif.setText("La transaction a bien été ajoutée.");
					} catch (NumberFormatException | SQLException e1) {
						e1.printStackTrace();
						verif.setText("Veuillez insérer un mode de paiement et un montant corrects.");
					}
				}
			}
		});
		btnValider.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnValider.setBounds(376, 353, 157, 46);
		frame.getContentPane().add(btnValider);
		btnValider.setOpaque(false);
		btnValider.setBorderPainted(false);
	}
}
