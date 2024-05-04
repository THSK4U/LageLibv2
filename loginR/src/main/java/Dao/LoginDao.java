package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
	
	  public static MembreDaoImpl authenticate(String username, String password) {
	  MembreDaoImpl Membre = null; Connection connection =
	  connectJDBC.getConnection(); try ( PreparedStatement pst = connection.
	  prepareStatement("SELECT id,FROM Membres WHERE  username = ? AND password = ? "
	  )) {
	  
	  pst.setString(1, username); pst.setString(2, password); ResultSet rs =
	  pst.executeQuery(); if (rs.next()) { Membre = new MembreDaoImpl(); }
	  rs.close(); } catch (SQLException e) { System.out.print(e); } return Membre;
	  }
	 
}
