package Doa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Metier.commenter;

public class AvisDaoImpl implements AvisDao {

	public commenter save(commenter A) {
		Connection connection = ConnectionJDBC.getConnection();
	    try {
	         PreparedStatement PreSt = connection.prepareStatement(
	        		 " INSERT INTO commenter (id_livre,commenter) VALUES (?,?)");
	        PreSt.setInt(1, A.getId_livre());
	        PreSt.setString(2, A.getCommenter());
	        PreSt.executeUpdate();
	        PreparedStatement PreSt2 = connection.prepareStatement("SELECT LAST_INSERT_ID() AS last_id");
	        ResultSet rs = PreSt2.executeQuery();
	        if (rs.next()) {
	            A.setId_livre(rs.getLong("last_id"));;
	        }
	        PreSt2.close();
	        PreSt.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return A;
	}

    // Méthode pour récupérer uniquement les commentaires associés à un livre spécifique
    public List<String> getCommentairesByLivre(int idLivre) {
        List<String> commentaires = new ArrayList<>();
        Connection connection = ConnectionJDBC.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT commenter FROM commenter     WHERE id_livre = ?");
            statement.setInt(1, idLivre);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String commentaire = rs.getString("commenter");
                commentaires.add(commentaire);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return commentaires;
    }

	


}

