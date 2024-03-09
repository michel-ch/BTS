package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicListUI.ListDataHandler;
import javax.swing.table.DefaultTableModel;

import controller.main;

import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.List;
import java.awt.ScrollPane;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.ImageIcon;
import java.awt.Color;

public class ajout_produit {

	private JFrame frame;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ajout_produit window = new ajout_produit();
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
	public ajout_produit() {
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
		
		JLabel lblNewLabel = new JLabel("Ajout de produit");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel.setBounds(243, 11, 216, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel verif = new JLabel("");
		verif.setHorizontalAlignment(SwingConstants.CENTER);
		verif.setFont(new Font("Tahoma", Font.PLAIN, 19));
		verif.setBounds(10, 52, 684, 30);
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
		button_retour.setBounds(38, 368, 166, 46);
		frame.getContentPane().add(button_retour);
		button_retour.setOpaque(false);
		button_retour.setBorderPainted(false);
		
		JLabel label = new JLabel("Quantité :");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label.setBounds(530, 167, 121, 30);
		frame.getContentPane().add(label);
		
		JComboBox quantite = new JComboBox();
		quantite.setMaximumRowCount(20);
		quantite.setBounds(530, 222, 121, 30);
		frame.getContentPane().add(quantite);
		for (int i=1;i!=21;i++) {
			quantite.addItem(i);
		}
		
		DefaultTableModel tableModel = new DefaultTableModel() {
			public boolean isCellEditable(int i, int i1) {
		        return false; //To change body of generated methods, choose Tools | Templates.
		    }
		};
		tableModel.addColumn("Id");
		tableModel.addColumn("Nom");
		tableModel.addColumn("Prix");
		
		JTable table = new JTable(tableModel);
		table.setBackground(new Color(255, 255, 255));
		
		table.setBounds(38, 93, 397, 253);
		frame.getContentPane().add(table);
		table.setRowHeight(25);
		table.setRowMargin(10);
		
		//System.out.println("size : "+main.getM().getListProduits().size());
		
		tableModel.getDataVector().removeAllElements();
		for (int i=0;i!=main.getM().getListProduits().size();i++) {
			String nom = main.getM().getListProduits().get(i).getNom();
			float prix = main.getM().getListProduits().get(i).getPrix();
			int id = main.getM().getListProduits().get(i).getId();
			// System.out.println("id : "+id+"nom : "+nom+" prix : "+prix);
			Object[] data = {id,nom,prix};
			tableModel.addRow(data);
		}
		
		if(main.getM().getListProduits().size()==0) {
			verif.setText("La base de données ne contient O produit.");
		}
		
		JButton btnValider = new JButton("");
		btnValider.setBackground(new Color(192, 192, 192));
		btnValider.setIcon(new ImageIcon("image/button_valider 2.png"));
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRowCount()!=1) {
					verif.setText("Veuillez selectionner un seul produit à ajouter.");
				}
				else if(table.getSelectedRowCount()==1) {
					// RECUPERATION DATA DE JTABLE
					String nom = table.getModel().getValueAt(table.getSelectedRow(),1).toString();
					//System.out.println(nom);
					float prix = Float.parseFloat(table.getModel().getValueAt(table.getSelectedRow(),2).toString());
					//System.out.println(prix);
					int q = Integer.parseInt(quantite.getSelectedItem().toString());
					// AJOUT TICKET DE CAISSE
					try {
						main.getM().ajoutticket(nom, q, prix);
						verif.setText("Le produit "+nom+" a été bien ajouté au prix de "+prix);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						verif.setText("Une ERREUR est survenue veuillez contacter le support.");
						e1.printStackTrace();
					}
				}
				
				//main.getM().ajoutticket(nom.getText(),Integer.parseInt(quantite.getSelectedItem().toString()),prixfloat);
			}
		});
		btnValider.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnValider.setBounds(278, 368, 157, 46);
		frame.getContentPane().add(btnValider);
		btnValider.setOpaque(false);
		btnValider.setBorderPainted(false);
		
		
	}
}
