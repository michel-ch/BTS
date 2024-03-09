package model;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import controller.mainMVC;
import view.bibliothecaire;
import view.listelivre;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;


public class model {
	private Connection con;
	private ArrayList<LIVRE> ListLivre;
	private ArrayList<AUTEUR> ListAuteur;
	private ArrayList<ADHERENT> ListAdherent;
	
	public model() {
		ListLivre=new ArrayList<LIVRE> ();
		ListAuteur=new ArrayList<AUTEUR> ();
		ListAdherent=new ArrayList<ADHERENT> ();
		String BDD = "ap2prof";
		String url = "jdbc:mysql://localhost:3306/" + BDD;
		String user = "root";
		String passwd = "";

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection conn;
		try {
			conn = DriverManager.getConnection(url, user, passwd);
			this.con = conn;
			System.out.println("Connection OK");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<LIVRE> getListLivre() {
		return ListLivre;
	}

	public ArrayList<ADHERENT> getListAdherent() {
		return ListAdherent;
	}

	public ArrayList<AUTEUR> getListAuteur() {
		return ListAuteur;
	}

	public void getAll() throws SQLException {
		ListAdherent.clear();
		ListAuteur.clear();
		ListLivre.clear();
		ListLivre=new ArrayList<LIVRE> ();
		ListAuteur=new ArrayList<AUTEUR> ();
		ListAdherent=new ArrayList<ADHERENT> ();

		ResultSet resultats;
		String requete;
		//*********************************************
		//CREATION DES AUTEURS
		//*********************************************
		requete = "SELECT * FROM auteur";


		Statement stmt = con.createStatement();
		resultats = stmt.executeQuery(requete);

		while (resultats.next()) {
			AUTEUR a=new AUTEUR(resultats.getInt(1), resultats.getString(2), resultats.getString(3), resultats.getString(4),resultats.getString(5));
			ListAuteur.add(a);
		}



		//*********************************************
		//CREATION DES LIVRES
		//*********************************************
		requete = "SELECT * FROM livre";


		stmt = con.createStatement();
		resultats = stmt.executeQuery(requete);

		while (resultats.next()) {
			LIVRE l=new LIVRE(resultats.getString(1), resultats.getString(2), resultats.getInt(3));
			ListLivre.add(l);
		}



		//*********************************************
		//CREATION DES ADHERENTS
		//*********************************************
		requete = "SELECT * FROM adherent";


		stmt = con.createStatement();
		resultats = stmt.executeQuery(requete);

		while (resultats.next()) {
			ADHERENT ad=new ADHERENT(resultats.getString(1), resultats.getString(2),  resultats.getString(3), resultats.getString(4));
			ListAdherent.add(ad);
		}

		//*********************************************
		//AJOUT liste de livre e ADHERENT
		//AJOUT de l'emprunteur e LIVRE
		//*********************************************
		requete = "SELECT ISBN,adherent FROM livre, adherent WHERE livre.adherent = adherent.num";


		stmt = con.createStatement();
		resultats = stmt.executeQuery(requete);
		String ISBN,numadherent ;
		while (resultats.next()) {
			ISBN= resultats.getString(1);
			numadherent=resultats.getString(2);
			findlivre(ISBN).setEmprunteur(findadherent(numadherent));
			findadherent(numadherent).ajouterlivre(findlivre(ISBN));
		}



		//*********************************************
		//Ajout de l'auteur au LIVRE
		//*********************************************
		requete = "SELECT ISBN,auteur FROM livre, auteur WHERE livre.auteur = auteur.num";


		stmt = con.createStatement();
		resultats = stmt.executeQuery(requete);
		String numauteur ;
		while (resultats.next()) {
			ISBN= resultats.getString(1);
			numauteur=resultats.getString(2);
			findlivre(ISBN).setAuteur(findauteur(numauteur));

		}


		/*

		System.out.println("nb Livre :"+ListLivre.size());
		System.out.println("nb Adherent :"+ListAdherent.size());
		System.out.println("nb Auteur :"+ListAuteur.size());
		 */
		System.out.println("chargement BDD OK");

	}
	
	
	public AUTEUR findauteur(String num)
	{
		for(int i=0;i<ListAuteur.size();i++)
		{
			if(ListAuteur.get(i).getNum()==Integer.parseInt(num))
			{
				return ListAuteur.get(i);
			}
		}

		return null;
	}

	public LIVRE findlivre(String ISBN)
	{
		for(int i=0;i<ListLivre.size();i++)
		{
			if(ListLivre.get(i).getISBN().equals(ISBN))
			{
				return ListLivre.get(i);
			}
		}

		return null;
	}
	public ADHERENT findadherent(String num)
	{
		for(int i=0;i<ListAdherent.size();i++)
		{
			if(ListAdherent.get(i).getNum().equals(num))
			{
				return ListAdherent.get(i);
			}
		}

		return null;
	}
	
	public AUTEUR findlAuteur(int num) {
		for (int i=0;i<ListAuteur.size();i++) {	
			if (ListAuteur.get(i).getNum()==num) {
				return ListAuteur.get(i);
			}
		}
		return null;
	}

	//***************************************************
	//Ajout d'un nouveau adhérent
	//***************************************************
	public void creationAdherent(String num, String nom, String prenom, String email) throws SQLException {

		Statement command = con.createStatement();
		command.execute("INSERT INTO `adherent` (`num`, `nom`, `prenom`, `email`) VALUES ('"+num+"',' "+nom+"', '"+prenom+"', '"+email+"')");
	}

	//***************************************************
	//Ajout d'un nouveau auteur
	//***************************************************
	public void creationAuteur(String nom, String prenom, String date_naissance, String description) throws SQLException {

		Statement command = con.createStatement();
		command.execute("INSERT INTO `auteur` (`num`, `nom`, `prenom`, `date_naissance`,`description`) VALUES ( null,'"+nom+"', '"+prenom+"', '"+date_naissance+"', '"+description+"')");
	}

	//***************************************************
	//Ajout d'un nouveau livre
	//***************************************************
	public void creationlivre(String ISBN, String titre, Float prix, AUTEUR auteur) throws SQLException {

		Statement command = con.createStatement();
		command.execute("INSERT INTO `livre` (`ISBN`, `titre`, `prix`, `adherent`,`auteur`) VALUES ("+ISBN+",' "+titre+"',"+prix+",null,'"+auteur.getNum()+"')");
	}
	//***************************************************
	//Retour livre
	//***************************************************
	public void retour(String ISBN) throws SQLException {
		Statement command = con.createStatement();
		command.execute("UPDATE livre SET adherent = null WHERE ISBN="+ISBN);
		//System.out.println("UPDATE livre SET adherent = null WHERE ISBN="+emprunteur);
		LIVRE l = mainMVC.getM().findlivre(ISBN);
		mainMVC.getM().ListLivre.remove(l);
	}
	
	
	
	//***************************************************
	//Emprunt livre
	//***************************************************
	public void emprunt(String ISBN,String emprunteur) throws SQLException {
		Statement command = con.createStatement();
		command.execute("UPDATE livre SET adherent = "+emprunteur+" WHERE ISBN= "+ISBN );
		//System.out.println("UPDATE livre SET adherent ="+emprunteur+"WHERE ISBN="+ISBN);
		LIVRE l = mainMVC.getM().findlivre(ISBN);
		ADHERENT a = mainMVC.getM().findadherent(emprunteur);
		l.setEmprunteur(a);
		a.ajouterlivre(l);
	}
	
	//***************************************************
	//Hashage SHA256
	//***************************************************
	public static String hashageSHA256(String entree) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(entree.getBytes());

        byte[] digest = md.digest();
        StringBuffer sb = new StringBuffer();
        for (byte b : digest){
            sb.append(String.format("%02x", b & 0xff));
        }
        String sortie = sb.toString();
		return sortie;
	}
	
	//***************************************************
	//Connexion bibliothecaire
	//***************************************************
	public void connexionbiblio(String login,String motdepasse) throws SQLException, NoSuchAlgorithmException {
		if (login!=null || motdepasse!=null) {
			java.sql.PreparedStatement precommande = con.prepareStatement("SELECT * FROM `bibliothecaire` WHERE login=? AND motdepasse=?");
			precommande.setString(1, login);
			String motdepassehash = hashageSHA256(motdepasse);
			precommande.setString(2, motdepassehash);
			System.out.println(precommande);
			ResultSet resultat= precommande.executeQuery();

			if (resultat.next()) {
				bibliothecaire vca = new bibliothecaire();
				resultat = null;
			}
			else {
				System.out.println("Identifiant ou mot de passe incorrect");
			}
		}
		else {
			System.out.println("Aucun identifiant ou mot de passe n'a été saisi");
		}
	}
	
	public void setListLivre(ArrayList<LIVRE> listLivre) {
		ListLivre = listLivre;
	}

	public void getListAdherent(ArrayList<ADHERENT> listAdherent) {
		ListAdherent = listAdherent;
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	//***************************************************
	//Verification disponibilité livre
	//***************************************************
		public String verif(String ISBN) throws SQLException {
			
			if(mainMVC.getM().findlivre(ISBN)!=null) {
				if (mainMVC.getM().findlivre(ISBN).getEmprunteur()!=null) {
					String verif ="dejaemprunte";
					return verif;
				}
				else if(mainMVC.getM().findlivre(ISBN).getEmprunteur()==null) {
					String verif ="libre";
					return verif;
				}
			}

			else {
				String verif ="erreur";
				return verif;
			}
			return "";
		}
	
		
		
}


