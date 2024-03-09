package view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.main;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class deduction {

	private JFrame frame;
	private JTextField montant;
	private JTextField motif;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deduction window = new deduction();
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
	public deduction() {
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
		
		JLabel lblNewLabel = new JLabel("Déduction ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel.setBounds(289, 40, 216, 30);
		frame.getContentPane().add(lblNewLabel);
		
		montant = new JTextField();
		montant.setBounds(289, 255, 216, 36);
		frame.getContentPane().add(montant);
		montant.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Montant :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1.setBounds(144, 251, 99, 36);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Motif :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1_1.setBounds(144, 164, 70, 36);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		motif = new JTextField();
		motif.setColumns(10);
		motif.setBounds(289, 164, 216, 36);
		frame.getContentPane().add(motif);
		
		JLabel verif = new JLabel("");
		verif.setFont(new Font("Tahoma", Font.PLAIN, 19));
		verif.setBounds(54, 95, 594, 30);
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
		button_retour.setBounds(38, 335, 166, 46);
		frame.getContentPane().add(button_retour);
		button_retour.setOpaque(false);
		button_retour.setBorderPainted(false);
		
		JButton btnValider = new JButton("");
		btnValider.setBackground(new Color(192, 192, 192));
		btnValider.setIcon(new ImageIcon("image/button_valider 2.png"));
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					float a = Float.parseFloat(montant.getText());
					float nega = -1;
					float b = nega*a;
					main.getM().ajoutticket(motif.getText(), 1,b);
					verif.setText("La déduction sur le ticket à hauteur de "+montant.getText()+" pour "+motif.getText()+" a été bien faite");
				} catch (NumberFormatException | SQLException e1) {
					verif.setText("Veuillez saisir un motif et un prix correct.");
					e1.printStackTrace();
				}
			}
		});
		btnValider.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnValider.setBounds(321, 335, 157, 46);
		frame.getContentPane().add(btnValider);
		btnValider.setOpaque(false);
		btnValider.setBorderPainted(false);
	}

}
