package model;

public class TAXE {
	private int id;
	private float tva;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getTva() {
		return tva;
	}
	public void setTva(float tva) {
		this.tva = tva;
	}
	public TAXE(int id, float tva) {
		super();
		this.id = id;
		this.tva = tva;
	}
}

