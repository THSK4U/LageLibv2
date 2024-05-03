package Metier;

public class Membree {

	private Long id_membre;
	private String prenom_mb;
    private String nom_mb;
    private String username;
    private String password;
    private String ladresse;
    private int numérotéléphone;
    
    
    
	public Membree() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Membree(String prenom_mb, String nom_mb, String username, String password, String ladresse,
			int numérotéléphone) {
		super();
		this.prenom_mb = prenom_mb;
		this.nom_mb = nom_mb;
		this.username = username;
		this.password = password;
		this.ladresse = ladresse;
		this.numérotéléphone = numérotéléphone;
	}
	
	@Override
	public String toString() {
		return "Membre [id_membre=" + id_membre + ", prenom_mb=" + prenom_mb + ", nom_mb=" + nom_mb + ", username="
				+ username + ", password=" + password + ", ladresse=" + ladresse + ", numérotéléphone="
				+ numérotéléphone + "]";
	}
	public Long getId_membre() {
		return id_membre;
	}
	public void setId_membre(Long id_membre) {
		this.id_membre = id_membre;
	}
	public String getPrenom_mb() {
		return prenom_mb;
	}
	public void setPrenom_mb(String prenom_mb) {
		this.prenom_mb = prenom_mb;
	}
	public String getNom_mb() {
		return nom_mb;
	}
	public void setNom_mb(String nom_mb) {
		this.nom_mb = nom_mb;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLadresse() {
		return ladresse;
	}
	public void setLadresse(String ladresse) {
		this.ladresse = ladresse;
	}
	public int getNumérotéléphone() {
		return numérotéléphone;
	}
	public void setNumérotéléphone(int numérotéléphone) {
		this.numérotéléphone = numérotéléphone;
	}
    
   
    
}