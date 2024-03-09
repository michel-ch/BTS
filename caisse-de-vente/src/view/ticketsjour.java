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
import javax.swing.table.DefaultTableModel;

import controller.main;

import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.ImageIcon;

public class ticketsjour {

	private JFrame frame;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ticketsjour window = new ticketsjour();
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
	public ticketsjour() {
		initialize();
		frame.setVisible(true);
	}

	public ticketsjour(String a) throws SQLException {
		if(main.getM().getListTransaction().size()!=0) {
			for (int i=0;i!=main.getM().getListTransaction().size();i++) {
				main.getM().getListTransaction().remove(i);
			}
		}
		main.getM().consulterCAJOUR(a);
		initialize();
		frame.setVisible(true);
		//System.out.println("date selectionnée: "+a);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(102, 153, 204));
		frame.setBounds(100, 100, 1080, 656);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton button_retour = new JButton("");
		button_retour.setBackground(new Color(192, 192, 192));
		button_retour.setIcon(new ImageIcon("image/button_precedent.png"));
		button_retour.setBounds(57, 531, 166, 46);
		button_retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		frame.getContentPane().setLayout(null);
		button_retour.setFont(new Font("Tahoma", Font.PLAIN, 19));
		frame.getContentPane().add(button_retour);
		button_retour.setOpaque(false);
		button_retour.setBorderPainted(false);
		
		
		JLabel lblParamtres = new JLabel("Tickets du jour");
		lblParamtres.setBounds(433, 46, 216, 30);
		lblParamtres.setHorizontalAlignment(SwingConstants.CENTER);
		lblParamtres.setFont(new Font("Tahoma", Font.PLAIN, 19));
		frame.getContentPane().add(lblParamtres);
		
		JLabel lblDateDeTransaction = new JLabel("Date de la transaction :");
		lblDateDeTransaction.setBounds(57, 214, 197, 36);
		lblDateDeTransaction.setHorizontalAlignment(SwingConstants.LEFT);
		lblDateDeTransaction.setFont(new Font("Tahoma", Font.PLAIN, 19));
		frame.getContentPane().add(lblDateDeTransaction);
		
		JLabel lblChiffreDuJour = new JLabel("Montant ticket :");
		lblChiffreDuJour.setBounds(57, 273, 177, 36);
		lblChiffreDuJour.setHorizontalAlignment(SwingConstants.LEFT);
		lblChiffreDuJour.setFont(new Font("Tahoma", Font.PLAIN, 19));
		frame.getContentPane().add(lblChiffreDuJour);
		
		JLabel date = new JLabel("--");
		date.setBounds(264, 214, 286, 36);
		date.setHorizontalAlignment(SwingConstants.CENTER);
		date.setFont(new Font("Tahoma", Font.PLAIN, 19));
		frame.getContentPane().add(date);
		
		JLabel cajour = new JLabel("--");
		cajour.setBounds(264, 273, 286, 36);
		cajour.setHorizontalAlignment(SwingConstants.CENTER);
		cajour.setFont(new Font("Tahoma", Font.PLAIN, 19));
		frame.getContentPane().add(cajour);
		
		JLabel lblTypeDePaiement = new JLabel("Type de paiement :");
		lblTypeDePaiement.setBounds(57, 339, 177, 36);
		lblTypeDePaiement.setHorizontalAlignment(SwingConstants.LEFT);
		lblTypeDePaiement.setFont(new Font("Tahoma", Font.PLAIN, 19));
		frame.getContentPane().add(lblTypeDePaiement);
		
		JLabel paiement = new JLabel("--");
		paiement.setBounds(264, 339, 286, 36);
		paiement.setHorizontalAlignment(SwingConstants.CENTER);
		paiement.setFont(new Font("Tahoma", Font.PLAIN, 19));
		frame.getContentPane().add(paiement);
		
		
		DefaultTableModel tableModel = new DefaultTableModel() {
			public boolean isCellEditable(int i, int i1) {
		        return false; //To change body of generated methods, choose Tools | Templates.
		    }
		};
		tableModel.addColumn("Nom");
		tableModel.addColumn("Quantite");
		tableModel.addColumn("Prix");
		
		JTable table = new JTable(tableModel);
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		table.setBounds(520, 214, 478, 363);
		table.setBackground(new Color(51, 204, 204));
		frame.getContentPane().add(table);
		
		JComboBox combo = new JComboBox();
		combo.setBounds(346, 112, 398, 36);
		combo.setBackground(new Color(51, 204, 204));
		
		System.out.println("size : "+main.getM().getListTransaction().size());
		
		for(int i=0;i!=main.getM().getListTransaction().size();i++) {
			combo.addItem(main.getM().getListTransaction().get(i).getDate());
		}
		
		combo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cajour.setText(String.valueOf(main.getM().getListTransaction().get(combo.getSelectedIndex()).getMontant()));
				paiement.setText(main.getM().getListTransaction().get(combo.getSelectedIndex()).getPaiement());
				date.setText(main.getM().getListTransaction().get(combo.getSelectedIndex()).getDate());
				
				try {
					System.out.println("ID = "+main.getM().getListTransaction().get(combo.getSelectedIndex()).getId());
					main.getM().produitticket(main.getM().getListTransaction().get(combo.getSelectedIndex()).getId());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				tableModel.getDataVector().removeAllElements();
				for (int i=0;i!=main.getM().getListProduitsTransaction().size();i++) {
					String nom = main.getM().getListProduitsTransaction().get(i).getNom();
					float prix = main.getM().getListProduitsTransaction().get(i).getPrix();
					int quantite = main.getM().getListProduitsTransaction().get(i).getQuantite();
					System.out.println("nom = "+nom+" quantite = "+quantite+" prix = "+prix);
					Object[] data = {nom,quantite,prix};
					tableModel.addRow(data);
				}
				System.out.println("Table count row = "+tableModel.getRowCount());
			}
		});
		frame.getContentPane().add(combo);
		
		JLabel lblNewLabel = new JLabel("Nom du produit");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(520, 200, 115, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblQuantit = new JLabel("Quantité");
		lblQuantit.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblQuantit.setBounds(678, 200, 115, 14);
		frame.getContentPane().add(lblQuantit);
		
		JLabel lblPrix = new JLabel("Prix");
		lblPrix.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPrix.setBounds(842, 200, 115, 14);
		frame.getContentPane().add(lblPrix);
		
		
		
	}
}
