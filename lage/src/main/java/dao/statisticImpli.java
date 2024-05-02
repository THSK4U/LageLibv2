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
	public List<statistic> selectstatistic() {
		List<statistic> list = new ArrayList<>();

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

	        list.add(new statistic(countLivres,countEmprunts,countMembres));
	        
	    } catch (SQLException e) {
			e.printStackTrace();
	    }

					return list;
		}

	}
	

