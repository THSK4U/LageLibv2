package metier;

import java.io.Serializable;

public class statistic implements Serializable {

	private int id_statistic ;
	public int getId_statistic() {
		
		return id_statistic;
	}
	public void setId_statistic(int id_statistic) {
		this.id_statistic = id_statistic;
	}
	@Override
	public String toString() {
		return "statistic [id_statistic=" + id_statistic + ", Livres=" + Livres + ", Emprunts=" + Emprunts
				+ ", Membres=" + Membres + "]";
	}
	private int Livres ;
	private int Emprunts ;
	private int Membres ;
	
	public int getLivres() {
		return Livres;
	}
	public void setLivres(int livres) {
		this.Livres = livres;
	}
	public int getEmprunts() {
		return Emprunts;
	}
	public void setEmprunts(int emprunts) {
		this.Emprunts = emprunts;
	}
	public int getMembres() {
		return Membres;
	}
	public void setMembres(int membres) {
		this.Membres = membres;
	}
	
	public statistic(int id_statistic, int livres, int emprunts, int membres) {
		super();
		this.id_statistic = id_statistic;
		this.Livres = livres;
		this.Emprunts = emprunts;
		this.Membres = membres;
	}
	public statistic(int livres, int emprunts, int membres) {
		super();
		this.Livres = livres;
		this.Emprunts = emprunts;
		this.Membres = membres;
	}
	public statistic() {
		super();
		
	}
	
	
}
