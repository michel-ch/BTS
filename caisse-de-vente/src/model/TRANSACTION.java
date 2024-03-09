package model;

public class TRANSACTION {
	private int id;
	private String paiement;
	private float montant;
	private String date;
	// private Image image;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPaiement() {
		return paiement;
	}
	public void setPaiement(String paiement) {
		this.paiement = paiement;
	}
	public float getMontant() {
		return montant;
	}
	public void setMontant(float montant) {
		this.montant = montant;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public TRANSACTION(int id, String paiement, float montant, String date) {
		super();
		this.id = id;
		this.paiement = paiement;
		this.montant = montant;
		this.date = date;
	}
	public TRANSACTION(String paiement, float montant) {
		super();
		this.paiement = paiement;
		this.montant = montant;
	}
	
}
