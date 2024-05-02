package Doa;

import java.util.List;
import Metier.commenter;


public class TestDao {

	public static void main(String[] args) {
		
		 AvisDaoImpl mebDao = new  AvisDaoImpl();
		 
			/*
			 * //add Member
			 * 
			 * commenter M3 = mebDao.save(new
			 * commenter(4,"htooopgshdjkqjqijdqhj  nsqhjhgvdhsbsb"));
			 * 
			 * System.out.println(M3.toString());
			 */
			 

		    // Supposons que l'ID du livre soit 1
	        int idLivre =4;

	        // Récupérer les commentaires pour le livre spécifique
	        List<String> commentaires = mebDao.getCommentairesByLivre(idLivre);

	        // Afficher les commentaires
	        System.out.println("Commentaires pour le livre avec l'ID " + idLivre + ":");
	        for (String commentaire : commentaires) {
	            System.out.println(commentaire);
	        }
	    }
}
