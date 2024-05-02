package Doa;

import java.util.List;

import Metier.commenter;

public interface AvisDao {
	
	public commenter save(commenter A);
	public List<String> getCommentairesByLivre(int idLivre);
}
