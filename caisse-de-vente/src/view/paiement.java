package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import controller.main;

import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.ImageIcon;

public class paiement {

	private JFrame frame;
	private JTextField montant;
	private JTextField personnalise;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					paiement window = new paiement(null);
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

	public paiement(BigDecimal totalttc) {
		initialize(totalttc);
		frame.setVisible(true);
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(BigDecimal totalttc) {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(102, 153, 204));
		frame.setBounds(100, 100, 636, 422);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Paiement");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel.setBounds(228, 11, 181, 40);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Montant à regler :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1.setBounds(318, 131, 166, 44);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton button_retour = new JButton("");
		button_retour.setBackground(new Color(192, 192, 192));
		button_retour.setIcon(new ImageIcon("image/button_precedent.png"));
		button_retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		button_retour.setFont(new Font("Tahoma", Font.PLAIN, 19));
		button_retour.setBounds(31, 293, 166, 46);
		frame.getContentPane().add(button_retour);
		button_retour.setOpaque(false);
		button_retour.setBorderPainted(false);
		
		JLabel verif = new JLabel("---");
		verif.setHorizontalAlignment(SwingConstants.CENTER);
		verif.setBounds(31, 62, 550, 44);
		frame.getContentPane().add(verif);
		
		personnalise = new JTextField();
		personnalise.setBackground(new Color(102, 153, 204));
		personnalise.setFont(new Font("Tahoma", Font.PLAIN, 13));
		personnalise.setEnabled(false);
		personnalise.setEditable(false);
		personnalise.setBounds(167, 211, 280, 31);
		frame.getContentPane().add(personnalise);
		personnalise.setColumns(10);
		personnalise.setVisible(false);
		personnalise.setOpaque(false);
		
		JLabel montant_1 = new JLabel("€");
		montant_1.setHorizontalAlignment(SwingConstants.CENTER);
		montant_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		montant_1.setBounds(558, 135, 23, 36);
		frame.getContentPane().add(montant_1);
		
		JLabel montant_1_1 = new JLabel("€");
		montant_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		montant_1_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		montant_1_1.setBounds(558, 171, 23, 36);
		frame.getContentPane().add(montant_1_1);
		
		JRadioButton espece = new JRadioButton("Espèce");
		espece.setBackground(new Color(102, 153, 204));
		espece.setFont(new Font("Tahoma", Font.PLAIN, 19));
		espece.setBounds(21, 174, 109, 23);
		frame.getContentPane().add(espece);
		
		JRadioButton perso = new JRadioButton("Personnalisé");
		perso.setBackground(new Color(102, 153, 204));
		perso.setFont(new Font("Tahoma", Font.PLAIN, 19));
		perso.setBounds(21, 201, 140, 45);
		frame.getContentPane().add(perso);
		
		JRadioButton carte_bleue = new JRadioButton("Carte Bleue");
		carte_bleue.setBackground(new Color(102, 153, 204));
		carte_bleue.setFont(new Font("Tahoma", Font.PLAIN, 19));
		carte_bleue.setBounds(21, 142, 130, 23);
		frame.getContentPane().add(carte_bleue);
		
		ButtonGroup group = new ButtonGroup();
		group.add(carte_bleue);
		group.add(perso);
		group.add(espece);
		
		JLabel montant_regler = new JLabel("--");
		montant_regler.setHorizontalAlignment(SwingConstants.CENTER);
		montant_regler.setFont(new Font("Tahoma", Font.PLAIN, 19));
		montant_regler.setBounds(472, 131, 86, 44);
		frame.getContentPane().add(montant_regler);
		
		montant = new JTextField();
		montant.setHorizontalAlignment(SwingConstants.CENTER);
		montant.setBounds(482, 175, 73, 36);
		frame.getContentPane().add(montant);
		montant.setColumns(10);
		
		verif.setText("Veuillez selectionner un mode de paiement.");
		
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				if(perso.isSelected()) {
					personnalise.setEnabled(true);
					personnalise.setEditable(true);
					personnalise.setVisible(true);
				}
				float total = 0;
				for (int i=0;i!=main.getM().getPaiement().size();i++) {
					total += main.getM().getPaiement().get(i).getMontant();
				}
				if (total==0) {
					montant_regler.setText(String.valueOf(totalttc));
				}
				else {
					// CONVERSION POUR CALCUL AVEC BIGDECIMAL
					BigDecimal ttc = totalttc;
					BigDecimal t = new BigDecimal(Float.toString(total));
					BigDecimal soustraction = ttc.subtract(t);
					montant_regler.setText(soustraction.toString());
				}
			};
			
		};
		timer.schedule(task, 100,100);
		
		JButton valider = new JButton("");
		valider.setBackground(new Color(192, 192, 192));
		valider.setIcon(new ImageIcon("image/button_valider 2.png"));
		valider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float m = Float.parseFloat(montant.getText());
				float aregler = Float.parseFloat(montant_regler.getText());
				if(!montant.getText().isEmpty()&&m<aregler||!montant.getText().isEmpty()&&m==aregler) {
					String paiement = "";
					if(espece.isSelected()) {
						paiement += "espece ";
						try {
							main.getM().paiementTransaction(paiement, m);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					else if (perso.isSelected()&&!personnalise.getText().isEmpty()) {
						paiement += perso.getText()+" ";
						try {
							main.getM().paiementTransaction(paiement, m);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					else if (carte_bleue.isSelected()) {
						paiement += "carte bleue ";
						try {
							main.getM().paiementTransaction(paiement, m);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					else {
						verif.setText("Veuillez selectionner un mode de paiement.");
					}
				}
				else {
					verif.setText("Veuillez ajouter un montant à payer correct.");
				}
			}
		});
		valider.setFont(new Font("Tahoma", Font.PLAIN, 19));
		valider.setBounds(254, 293, 166, 46);
		frame.getContentPane().add(valider);
		valider.setOpaque(false);
		valider.setBorderPainted(false);
		
	}
}
