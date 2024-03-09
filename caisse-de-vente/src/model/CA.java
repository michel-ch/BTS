package model;

public class CA {
	private int id;
	private float cajour;
	private String date;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getCajour() {
		return cajour;
	}
	public void setCajour(float cajour) {
		this.cajour = cajour;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public CA(int id, float cajour) {
		super();
		this.id = id;
		this.cajour = cajour;
	}
	public CA(int id, float cajour, String date) {
		super();
		this.id = id;
		this.cajour = cajour;
		this.date = date;
	}
}
