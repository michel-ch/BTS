package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.List;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class suppression_transaction {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					suppression_transaction window = new suppression_transaction();
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
	public suppression_transaction() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 720, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton button_retour = new JButton("Précédent");
		button_retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		button_retour.setFont(new Font("Tahoma", Font.PLAIN, 19));
		button_retour.setBounds(46, 342, 166, 46);
		frame.getContentPane().add(button_retour);
		
		JLabel lblNewLabel = new JLabel("Suppression de transaction");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel.setBounds(188, 25, 343, 23);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel verif = new JLabel("infos");
		verif.setFont(new Font("Tahoma", Font.PLAIN, 15));
		verif.setBounds(58, 81, 583, 23);
		frame.getContentPane().add(verif);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(275, 164, 386, 36);
		frame.getContentPane().add(comboBox);
		
		JLabel lblProduitSupprimer = new JLabel("Transaction à supprimer :");
		lblProduitSupprimer.setHorizontalAlignment(SwingConstants.CENTER);
		lblProduitSupprimer.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblProduitSupprimer.setBounds(46, 164, 205, 36);
		frame.getContentPane().add(lblProduitSupprimer);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnValider.setBounds(374, 342, 157, 46);
		frame.getContentPane().add(btnValider);
	}
}
