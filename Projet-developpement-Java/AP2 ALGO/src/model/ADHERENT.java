package model;

import java.util.ArrayList;
import java.util.Date;

public class ADHERENT {
	private String num;
	private String nom;
	private String prenom;
	private String email;
	
	private ArrayList <LIVRE> listelivres;
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public ArrayList<LIVRE> getListelivres() {
		return listelivres;
	}
	public void setListelivres(ArrayList<LIVRE> listelivres) {
		this.listelivres = listelivres;
	}
	public ADHERENT(String num,String nom, String prenom, String email) {
		super();
		this.num = num;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		listelivres = new ArrayList<LIVRE>();
	}
	
	public ADHERENT(String nom, String prenom, String email) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}
	
	public void AFFICHERADHERENT() {
		System.out.println("Nom de l'adhérent = "+nom);
		System.out.println("Prenom de l'adhérent = "+prenom);
		System.out.println("Email = "+email);
		System.out.println("Numero de carte de l'adhérent = "+num);
		System.out.println("");
	}
	public void AFFICHERMESLIVRES() {
		System.out.println("Liste livres empruntés = "+listelivres);
	}
	
	public void ajouterlivre(LIVRE livre) {
		listelivres.add(livre);
	}
	public void enleverlivre(LIVRE livre) {
		listelivres.remove(livre);
	}
}