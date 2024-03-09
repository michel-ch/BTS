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

import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.ImageIcon;

public class ca {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ca window = new ca();
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
	public ca() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(102, 153, 204));
		frame.setBounds(100, 100, 1080, 656);
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
		button_retour.setBounds(57, 531, 166, 46);
		frame.getContentPane().add(button_retour);
		button_retour.setOpaque(false);
		button_retour.setBorderPainted(false);
		
		JLabel lblParamtres = new JLabel("Chiffre d'affaires");
		lblParamtres.setHorizontalAlignment(SwingConstants.CENTER);
		lblParamtres.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblParamtres.setBounds(433, 46, 216, 30);
		frame.getContentPane().add(lblParamtres);
		
		JLabel lblDateDeTransaction = new JLabel("Date de la transaction :");
		lblDateDeTransaction.setHorizontalAlignment(SwingConstants.LEFT);
		lblDateDeTransaction.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblDateDeTransaction.setBounds(239, 214, 197, 36);
		frame.getContentPane().add(lblDateDeTransaction);
		
		JLabel lblChiffreDuJour = new JLabel("Chiffre du jour :");
		lblChiffreDuJour.setHorizontalAlignment(SwingConstants.LEFT);
		lblChiffreDuJour.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblChiffreDuJour.setBounds(239, 273, 177, 36);
		frame.getContentPane().add(lblChiffreDuJour);
		
		JLabel date = new JLabel("--");
		date.setHorizontalAlignment(SwingConstants.CENTER);
		date.setFont(new Font("Tahoma", Font.PLAIN, 19));
		date.setBounds(472, 214, 177, 36);
		frame.getContentPane().add(date);
		
		JLabel ca = new JLabel("--");
		ca.setHorizontalAlignment(SwingConstants.CENTER);
		ca.setFont(new Font("Tahoma", Font.PLAIN, 19));
		ca.setBounds(472, 273, 177, 36);
		frame.getContentPane().add(ca);
		
		JComboBox combo = new JComboBox();
		
		combo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				date.setText(main.getM().getListCA().get(combo.getSelectedIndex()).getDate());
				ca.setText(String.valueOf(main.getM().getListCA().get(combo.getSelectedIndex()).getCajour()));
			}
		});
		
		combo.setBounds(346, 113, 398, 36);
		frame.getContentPane().add(combo);
		
		for(int i=0;i!=main.getM().getListCA().size();i++) {
			combo.addItem(main.getM().getListCA().get(i).getDate());
		}
		
		
		JButton ticketsjour = new JButton("");
		ticketsjour.setBackground(new Color(192, 192, 192));
		ticketsjour.setIcon(new ImageIcon("image/button_voir-tickets-du-jour.png"));
		ticketsjour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a = main.getM().getListCA().get(combo.getSelectedIndex()).getDate();
				try {
					ticketsjour date = new ticketsjour(a);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		ticketsjour.setFont(new Font("Tahoma", Font.PLAIN, 19));
		ticketsjour.setBounds(659, 273, 243, 36);
		frame.getContentPane().add(ticketsjour);
		ticketsjour.setOpaque(false);
		ticketsjour.setBorderPainted(false);
	}
}
