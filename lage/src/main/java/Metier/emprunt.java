package Metier;


public class emprunt {
	
	private int	id_emprunt ;
	private int	date_demprunt ;
	private int	date_retour ;
	private int	id_livre ;
	private int	id_membre ;
	
	
	public emprunt() {
		super();
	}
	
	public emprunt(int id_emprunt, int date_demprunt, int date_retour, int id_livre, int id_membre) {
		super();
		this.id_emprunt = id_emprunt;
		this.date_demprunt = date_demprunt;
		this.date_retour = date_retour;
		this.id_livre = id_livre;
		this.id_membre = id_membre;
	}
	
	
	public int getId_emprunt() {
		return id_emprunt;
	}
	public void setId_emprunt(int id_emprunt) {
		this.id_emprunt = id_emprunt;
	}
	public int getDate_demprunt() {
		return date_demprunt;
	}
	public void setDate_demprunt(int date_demprunt) {
		this.date_demprunt = date_demprunt;
	}
	public int getDate_retour() {
		return date_retour;
	}
	public void setDate_retour(int date_retour) {
		this.date_retour = date_retour;
	}
	public int getId_livre() {
		return id_livre;
	}
	public void setId_livre(int id_livre) {
		this.id_livre = id_livre;
	}
	public int getId_membre() {
		return id_membre;
	}
	public void setId_membre(int id_membre) {
		this.id_membre = id_membre;
	}


	@Override
	public String toString() {
		return "emprunt [id_emprunt=" + id_emprunt + ", date_demprunt=" + date_demprunt + ", date_retour=" + date_retour
				+ ", id_livre=" + id_livre + ", id_membre=" + id_membre + "]";
	}
	
	
	
	

}
/*
 * constructors
 *
*getters and setters 
*Declaration var from DB
**/