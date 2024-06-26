package dao;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import metier.admin;
import metier.livers;

public class LivresDaoimpli implements ILiverdao{

	//login
	public List<admin> Admin() {
		List<admin> admin = new ArrayList<>();

		Connection connection = SConnection.getConnection();
					try {
						PreparedStatement preparedStatement = 
								connection.prepareStatement("SELECT * FROM adminn");
						ResultSet rs = preparedStatement.executeQuery();
						while (rs.next()) {
							int id = rs.getInt("id_admin");
							String  name = rs.getString("name_ad");
							
							String password = rs.getString("password");
							
							admin.add(new admin(id,name,password));
							//System.out.println(admin);
						}
						
						
					} catch (SQLException e) {
						e.printStackTrace();
					}

					return admin;

		}
	
	
	
	//select All
	@Override
	public List<livers> ALLlist() {
	List<livers> list = new ArrayList<>();

	Connection connection = SConnection.getConnection();
				try {
					PreparedStatement preparedStatement = 
							connection.prepareStatement("SELECT * FROM Livres");
					ResultSet rs = preparedStatement.executeQuery();
					while (rs.next()) {
						int id = rs.getInt("id_livre");
						String  titre = rs.getString("titre");
						//System.out.println(titre);
						String lauteur = rs.getString("lauteur");
						int  lannéepublication = rs.getInt("lannéepublication");
						String image = rs.getString("image");
						list.add(new livers(id,titre,lauteur,lannéepublication,image));
						System.out.println(list);
					}
					
					
				} catch (SQLException e) {
					e.printStackTrace();
				}

				return list;

	}
	
	//Recherch by titre
    @Override
    public livers getLivresbynom(String titre) {
    	Connection connection = SConnection.getConnection();
        livers livre = null;
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM Livres WHERE titre = ?");
            preparedStatement.setString(1, titre);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                int Id = rs.getInt("id_livre");
                String Titre = rs.getString("titre");
                String lauteur = rs.getString("lauteur");
                int lanneepublication = rs.getInt("lannéepublication");
                String image = rs.getString("image");

                livre = new livers(Id, Titre, lauteur, lanneepublication,image);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return livre;
    }

	//select by id
    @Override
    public livers getLivres(long id) {
    	Connection connection = SConnection.getConnection();
        livers livre = null;
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM Livres WHERE id_livre = ?");
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                int livreId = rs.getInt("id_livre");
                String titre = rs.getString("titre");
                String lauteur = rs.getString("lauteur");
                int lanneepublication = rs.getInt("lannéepublication");
                String image = rs.getString("image");

                livre = new livers(livreId, titre, lauteur, lanneepublication,image);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return livre;
    }
    
    
    //update
    @Override
    public livers update(livers p) {
    	Connection connection = SConnection.getConnection();
        livers updatedLivres = new livers();
        try {
            updatedLivres.setId_livre(p.getId_livre());
            updatedLivres.setTitre(p.getTitre());
            updatedLivres.setLauteur(p.getLauteur());
            updatedLivres.setLannéepublication(p.getLannéepublication());
            updatedLivres.setImage(p.getImage());

            
            PreparedStatement ps = connection.prepareStatement(
                "UPDATE Livres SET titre=?, lauteur=?, lannéepublication=?, image=? WHERE id_livre=?"
            );
            ps.setString(1, p.getTitre());
            ps.setString(2, p.getLauteur());
            ps.setInt(3, p.getLannéepublication());
            ps.setString(4, p.getImage());
            ps.setLong(5, p.getId_livre());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updatedLivres;
    }

    
    //delete
    @Override
    public livers deletLivres(long id) {
        Connection connection = SConnection.getConnection();

        try {
            PreparedStatement psDelete = connection.prepareStatement(
                    "DELETE FROM Livres WHERE id_livre=?"
            );
            psDelete.setLong(1, id);
            int rowsDeleted = psDelete.executeUpdate();
            psDelete.close();

            if (rowsDeleted > 0) {
                PreparedStatement psUpdate = connection.prepareStatement(
                        "UPDATE Livres SET id_livre = id_livre - 1 WHERE id_livre > ?"
                );
                psUpdate.setLong(1, id);
                psUpdate.executeUpdate();
                psUpdate.close();
            } else {
                System.out.println("The book with ID " + id + " was not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    
    //insert
	@Override
	public livers save(livers p) {
    	Connection connection = SConnection.getConnection();
		 try {
	            PreparedStatement stmt = connection.prepareStatement(
	                        "INSERT INTO Livres (titre, lauteur, lannéepublication, image) VALUES (?, ?, ?, ?)"
	                    );
	              stmt.setString(1, p.getTitre());
	              stmt.setString(2, p.getLauteur());
	              stmt.setInt(3, p.getLannéepublication());
	              stmt.setString(4, p.getImage());
	              stmt.executeUpdate();


	             PreparedStatement stmt2 = connection.prepareStatement("SELECT LAST_INSERT_ID() AS last_id");
	                ResultSet rs = stmt2.executeQuery();
	                if (rs.next()) {
	                     p.setId_livre(rs.getInt("last_id"));
	                }
	                stmt2.close();
	                stmt.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return p;
	    }


		/*
		 * PreparedStatement stmt2 =
		 * connection.prepareStatement("SELECT lastval() AS last_id"); ResultSet rs =
		 * stmt2.executeQuery(); if (rs.next()) { L.setId_livre(rs.getLong("last_id"));
		 * } stmt2.close(); stmt.close(); } catch (SQLException e) {
		 * e.printStackTrace(); } return p; }
		 */


}