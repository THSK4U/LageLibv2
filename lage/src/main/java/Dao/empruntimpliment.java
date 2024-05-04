package Dao;

import Metier.Membre; // Import the Membre class

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class empruntimpliment {

    public static Membre getMemberInfo(String memberName, int memberPhone) {
        Connection conn = connection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Membre member = null;
        try {
            String query = "SELECT * FROM members WHERE nom_mb = ? AND numérotéléphone = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, memberName);
            stmt.setInt(2, memberPhone);
            rs = stmt.executeQuery();

            if (rs.next()) {
                member = new Membre();
                member.setId_membre(rs.getLong("id_membre"));
                member.setNom_mb(rs.getString("nom_mb"));
                member.setLadresse(rs.getString("ladresse"));
                member.setNumérotéléphone(rs.getInt("numérotéléphone"));
                // Add other member information fields if needed
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return member;
    }

    // You can add more methods here for other functionalities related to borrows
}
