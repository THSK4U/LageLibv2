package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.statistic;

public class statisticImpli implements statisticDao{

	@Override
	public void save() {
	    Connection connection = SConnection.getConnection();
	    try {
	        PreparedStatement Livres = connection.prepareStatement("SELECT COUNT(*) FROM Livres");
	        ResultSet rsLivres = Livres.executeQuery();
	        rsLivres.next();
	        int countLivres = rsLivres.getInt(1);

	        PreparedStatement Emprunts = connection.prepareStatement("SELECT COUNT(*) FROM Emprunts");
	        ResultSet rsEmprunts = Emprunts.executeQuery();
	        rsEmprunts.next();
	        int countEmprunts = rsEmprunts.getInt(1);

	        PreparedStatement Membres = connection.prepareStatement("SELECT COUNT(*) FROM Membres");
	        ResultSet rsMembres = Membres.executeQuery();
	        rsMembres.next();
	        int countMembres = rsMembres.getInt(1);

	        PreparedStatement PreSt = connection.prepareStatement("INSERT INTO statistic (Livres, Emprunts, Membres) VALUES (?,?,?)");
	        PreSt.setInt(1, countLivres);
	        PreSt.setInt(2, countEmprunts);
	        PreSt.setInt(3, countMembres);
	        PreSt.executeUpdate();
	        
	    } catch (SQLException e) {
			e.printStackTrace();
	    }
	    
	}

	@Override
	public List<statistic> selectstatistic() {
		List<statistic> list = new ArrayList<>();
		Connection connection = SConnection.getConnection();
					try {
		            PreparedStatement preparedStatement = 
								connection.prepareStatement("select * from statistic ORDER BY id_statistic DESC LIMIT 1");
						ResultSet rs = preparedStatement.executeQuery();
						while (rs.next()) {
							int Livres = rs.getInt("Livres");
							int Emprunts = rs.getInt("Emprunts");
							int  Membres = rs.getInt("Membres");
							
							list.add(new statistic(Livres,Emprunts,Membres));
						}
						
						
					} catch (SQLException e) {
						e.printStackTrace();
					}

					return list;

		}

	@Override
	public statistic save(statistic M) {
		// TODO Auto-generated method stub
		return null;
	}

	}
	

