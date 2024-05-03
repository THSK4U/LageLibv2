package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Metier.Membree;




public class MembreDaoImpl implements MembreDAO {

	@Override
	public Membree registerEmployee(Membree M) {
		Connection connection =connectJDBC.getConnection();
	    try {
	    	 PreparedStatement preparedStatement = connection.prepareStatement(
	        		 " INSERT INTO Membres (prenom_mb, nom_mb, username,password,ladresse,numérotéléphone) VALUES (?, ?, ?, ?, ?, ?)");

               preparedStatement.setString(1, M.getPrenom_mb());
               preparedStatement.setString(2, M.getNom_mb());
               preparedStatement.setString(3, M.getUsername());
               preparedStatement.setString(4, M.getPassword());
               preparedStatement.setString(5, M.getLadresse());
               preparedStatement.setInt(6, M.getNumérotéléphone());
               preparedStatement.executeUpdate();
	          PreparedStatement PreSt2 = connection.prepareStatement("SELECT LAST_INSERT_ID() AS last_id");
	          ResultSet rs = PreSt2.executeQuery();
	        if (rs.next()) {
	            M.setId_membre(rs.getLong("last_id"));
	        }
	        PreSt2.close();
	        preparedStatement.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		return M;
	}
	
}
