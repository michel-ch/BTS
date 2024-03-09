package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import controller.main;
import model.model;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import java.awt.List;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ImageIcon;

public class accueil {

	public JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					accueil window = new accueil();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public accueil() throws SQLException {
		try {
			initialize();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frame.setVisible(true);
		main.getM().creationCA();
	}
	

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	private void initialize() throws SQLException {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(102, 153, 204));
		frame.setBounds(100, 100, 1031, 1080);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("TOTAL");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(354, 850, 67, 22);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("TOTAL TTC");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1_1.setBounds(354, 900, 117, 22);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel total_sanstva = new JLabel("---");
		total_sanstva.setFont(new Font("Tahoma", Font.PLAIN, 22));
		total_sanstva.setBounds(533, 850, 67, 22);
		frame.getContentPane().add(total_sanstva);
		
		JLabel total_tva = new JLabel("---");
		total_tva.setFont(new Font("Tahoma", Font.PLAIN, 22));
		total_tva.setBounds(533, 900, 67, 22);
		frame.getContentPane().add(total_tva);
		
		JLabel lblNewLabel_2 = new JLabel("€");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_2.setBounds(608, 850, 26, 22);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("€");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_2_1.setBounds(608, 900, 26, 22);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JButton btnParamtres = new JButton("");
		btnParamtres.setIcon(new ImageIcon("image/button_parametres.png"));
		btnParamtres.setBackground(new Color(192, 192, 192));
		btnParamtres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parametres vca = new parametres();
			}
		});
		btnParamtres.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnParamtres.setBounds(706, 115, 236, 62);
		frame.getContentPane().add(btnParamtres);
		btnParamtres.setOpaque(false);
		btnParamtres.setBorderPainted(false);
		
		JLabel verif = new JLabel("");
		verif.setFont(new Font("Tahoma", Font.PLAIN, 19));
		verif.setBounds(689, 288, 265, 134);
		frame.getContentPane().add(verif);
		
		JButton button_ajoutlistmanuel = new JButton("");
		button_ajoutlistmanuel.setIcon(new ImageIcon("image/button_ajout-manuel.png"));
		button_ajoutlistmanuel.setBackground(new Color(50, 205, 50));
		button_ajoutlistmanuel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ajout_manuel vca = new ajout_manuel();
			}
		});
		button_ajoutlistmanuel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		button_ajoutlistmanuel.setBounds(706, 540, 236, 62);
		frame.getContentPane().add(button_ajoutlistmanuel);
		button_ajoutlistmanuel.setOpaque(false);
		button_ajoutlistmanuel.setBorderPainted(false);

		
		JLabel lblNewLabel_1_1_1 = new JLabel("TOTAL A PAYER");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1_1_1.setBounds(354, 950, 166, 22);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("€");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_2_1_1.setBounds(608, 950, 26, 22);
		frame.getContentPane().add(lblNewLabel_2_1_1);
		
		JLabel total_payer = new JLabel("---");
		total_payer.setFont(new Font("Tahoma", Font.PLAIN, 22));
		total_payer.setBounds(533, 950, 65, 22);
		frame.getContentPane().add(total_payer);
		
		JButton btnAjout = new JButton("");
		btnAjout.setIcon(new ImageIcon("image/button_ajout.png"));
		btnAjout.setBackground(new Color(50, 205, 50));
		btnAjout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				frame.setVisible(true);
				ajout_produit vca = new ajout_produit();
			}
		});
		btnAjout.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnAjout.setBounds(706, 440, 236, 62);
		frame.getContentPane().add(btnAjout);
		btnAjout.setOpaque(false);
		btnAjout.setBorderPainted(false);
		
		JButton button_deduction = new JButton("");
		button_deduction.setIcon(new ImageIcon("image/button_deduction.png"));
		button_deduction.setBackground(new Color(255, 99, 71));
		button_deduction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deduction vca = new deduction();
			}
		});
		button_deduction.setFont(new Font("Tahoma", Font.PLAIN, 19));
		button_deduction.setBounds(706, 740, 236, 62);
		frame.getContentPane().add(button_deduction);
		button_deduction.setOpaque(false);
		button_deduction.setBorderPainted(false);
		
		JButton button_ca = new JButton("");
		button_ca.setIcon(new ImageIcon("image/button_chiffre-daffaire.png"));
		button_ca.setBackground(new Color(192, 192,192));
		button_ca.setForeground(new Color(0, 0, 0));
		button_ca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ca vca = new ca();
			}
		});
		button_ca.setFont(new Font("Tahoma", Font.PLAIN, 19));
		button_ca.setBounds(706, 215, 236, 62);
		frame.getContentPane().add(button_ca);
		button_ca.setOpaque(false);
		button_ca.setBorderPainted(false);
		
		// DONNEES TESTS
		//main.getM().ajoutticket("produit1", 1,11);
		//main.getM().ajoutticket("produit2", 1,22);
		
		
		// en tete tableau
		
		DefaultTableModel tableModel = new DefaultTableModel() {
			public boolean isCellEditable(int i, int i1) {
		        return false; //To change body of generated methods, choose Tools | Templates.
		    }
		};
		tableModel.addColumn("Nom");
		tableModel.addColumn("Quantite");
		tableModel.addColumn("Prix");
		
		JTable table = new JTable(tableModel);
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFont(new Font("Arial", Font.PLAIN, 15));
		table.setBounds(64, 56, 587, 719);
		frame.getContentPane().add(table);
		//table.setBackground(new Color(230, 218, 198));
		table.setRowHeight(25);
		table.setRowMargin(10);
		
		//données pour JTable dans un tableau 2D
		tableModel.getDataVector().removeAllElements();
		for (int i=0;i!=main.getM().getTicket().size();i++) {
			String nom = main.getM().getTicket().get(i).getNom();
			float prix = main.getM().getTicket().get(i).getPrix();
			int quantite = main.getM().getTicket().get(i).getQuantite();
			//System.out.println("nom : "+nom+" quantite : "+quantite+" prix : "+prix);
			Object[] data = {nom,quantite,prix};
			tableModel.addRow(data);
		}
		
		JButton button_supprimerlist = new JButton("");
		button_supprimerlist.setIcon(new ImageIcon("image/button_supprimer.png"));
		button_supprimerlist.setBackground(new Color(255, 0, 0));
		button_supprimerlist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()>=0) {
					//System.out.println("selected : "+table.getSelectedRow());
					main.getM().getTicket().remove(table.getSelectedRow());
					tableModel.removeRow(table.getSelectedRow());
					verif.setText("<html>La suppression a bien <br> été effectuée.</html>");
					//System.out.println("size : "+main.getM().getTicket().size());
				}
				else {
					verif.setText("<html>Veuillez selectionner <br>un élément à supprimer.</html>");
				}
			}
		});
		button_supprimerlist.setFont(new Font("Tahoma", Font.PLAIN, 19));
		button_supprimerlist.setBounds(706, 640, 236, 62);
		frame.getContentPane().add(button_supprimerlist);
		button_supprimerlist.setOpaque(false);
		button_supprimerlist.setBorderPainted(false);
		
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				if(main.getM().getTicket().size()==0){
					tableModel.getDataVector().removeAllElements();
				}
				if(tableModel.getRowCount()!=main.getM().getTicket().size()) {
					// DELETE ROWS OF TABLE
					tableModel.getDataVector().removeAllElements();
					// ADD ROWS INT TABLE
					for (int i=0;i!=main.getM().getTicket().size();i++) {
						String nom = main.getM().getTicket().get(i).getNom();
						float prix = main.getM().getTicket().get(i).getPrix();
						int quantite = main.getM().getTicket().get(i).getQuantite();
						Object[] data = {nom,quantite,prix};
						tableModel.addRow(data);
					}
				}
				if(main.getM().getPaiement().size()!=0) {
					float asoustraire = 0;
					for (int i=0;i!=main.getM().getPaiement().size();i++) {
						asoustraire += main.getM().getPaiement().get(i).getMontant();
					}
					float c = Float.parseFloat(total_tva.getText())-asoustraire;
					total_payer.setText(String.valueOf(c));
				}
				
			};
			
		};
		timer.schedule(task, 100,100);
		
		JButton button_paiement = new JButton("");
		button_paiement.setIcon(new ImageIcon("image/button_paiement.png"));
		button_paiement.setBackground(new Color(30, 144, 255));
		button_paiement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// CALCUL DU TOTAL + INSERTION DANS LES LABELS
				BigDecimal total = BigDecimal.ZERO;
				for(int i=0;i!=table.getModel().getRowCount();i++) {
					BigDecimal quantite = new BigDecimal(table.getModel().getValueAt(i,1).toString());
					BigDecimal prix = new BigDecimal(table.getModel().getValueAt(i,2).toString());
					//System.out.println("quantite : "+quantite+" prix : "+prix);//
					BigDecimal ajout = prix.multiply(quantite);
					System.out.println("ajout : "+ajout);
					total = total.add(ajout);
					System.out.println(total);
				}
				System.out.println("total : "+total);
				total_sanstva.setText(String.valueOf(total));
				//System.out.println("TVA : "+main.getM().findTVA(1).getTva());
				BigDecimal tva = new BigDecimal(String.valueOf(main.getM().findTVA(1).getTva()/100));
				BigDecimal aj = total.multiply(tva);
				BigDecimal totalttc = total.add(aj);
				total_tva.setText(String.valueOf(totalttc));
				System.out.println("total ttc : "+totalttc);//
				
				total_payer.setText(String.valueOf(totalttc));
				
				paiement vca = new paiement(totalttc);
			}
		});
		button_paiement.setFont(new Font("Tahoma", Font.PLAIN, 19));
		button_paiement.setBounds(706, 840, 236, 62);
		frame.getContentPane().add(button_paiement);
		button_paiement.setOpaque(false);
		button_paiement.setBorderPainted(false);
		
		JButton valider = new JButton("");
		valider.setIcon(new ImageIcon("image/button_valider.png"));
		valider.setBackground(new Color(0, 128, 0));
		valider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// RECUPERATION DATA FROM PAIEMENT ET COMPARAISON -> ADDITION POUR VERIFICATION
				float totalv = 0;
				float totalttc = Float.parseFloat(total_tva.getText());
				String paiement = "";
				for (int i=0;i!=main.getM().getPaiement().size();i++) {
					totalv += main.getM().getPaiement().get(i).getMontant();
					if(i>=1) {
						paiement += "+ "+main.getM().getPaiement().get(i).getPaiement();
					}
					else {
						paiement += main.getM().getPaiement().get(i).getPaiement();
					}
				}
				if(totalttc==totalv){
					//System.out.println(totalv);
					//System.out.println(paiement);
					// CREATION TRANSACTION AVEC LA DATA
					try {
						main.getM().creationTransaction(paiement, totalttc);
						int retour = main.getM().rechercheIDTransaction(paiement, totalttc);
						for(int i=0;i!=main.getM().getTicket().size();i++) {
							//System.out.println("Id Transaction = "+retour+" nom = "+main.getM().getTicket().get(i).getNom()+" prix = "+main.getM().getTicket().get(i).getPrix());
							main.getM().creationProduitdeTicket(retour, main.getM().getTicket().get(i).getNom(),main.getM().getTicket().get(i).getPrix(),main.getM().getTicket().get(i).getQuantite());
						}
						
						//System.out.println("ticket = "+main.getM().getTicket().size());
						if(main.getM().getTicket().size()>=0) {
							main.getM().getTicket().clear();
							tableModel.getDataVector().removeAllElements();
						}
						
						main.getM().getPaiement().clear();
						//main.getM().getTicket().clear();
						main.getM().majTransaction();
						
						//System.out.println("paiement "+main.getM().getPaiement().size()+" ticket "+main.getM().getTicket().size()+" transaction "+main.getM().getListTransaction().size());
						
						total_payer.setText(null);
						total_sanstva.setText(null);
						total_tva.setText(null);
						frame.setVisible(false);
						frame.setVisible(true);
						
						
						
					} catch (SQLException e1) {
						verif.setText("<html>Une erreur est survenue.<br>Veuillez contacter le support.</html>");
						e1.printStackTrace();
					}
				}
			}
		});
		valider.setFont(new Font("Tahoma", Font.PLAIN, 19));
		valider.setBounds(706, 940, 236, 62);
		frame.getContentPane().add(valider);
		valider.setOpaque(false);
		valider.setBorderPainted(false);
		
	}
}
