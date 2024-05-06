package dao;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

public class FilterLogin implements Filter{



	    public void init(FilterConfig filterConfig) throws ServletException {
	    }

	    private boolean authenticate(String username, String password) {
	        try (Connection conn = SConnection.getConnection();
	             PreparedStatement stmt = conn.prepareStatement("SELECT count(*) FROM adminn WHERE name_ad = ? AND password = ?");
	             PreparedStatement stmtM = conn.prepareStatement("SELECT count(*) FROM Membres WHERE username = ? AND password = ?")) {

	            stmt.setString(1, username);
	            stmt.setString(2, password);
	            stmtM.setString(1, username);
	            stmtM.setString(2, password);

	            try (ResultSet rs = stmt.executeQuery(); ResultSet rsM = stmtM.executeQuery()) {
	                if (rs.next() && rsM.next()) {
	                    return rs.getInt(1) > 0 || rsM.getInt(1) > 0;
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }
	    
	    
	    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	            throws IOException, ServletException {

	        HttpServletRequest req = (HttpServletRequest) request;
	        HttpServletResponse res = (HttpServletResponse) response;
	        
	        String username = req.getParameter("username");
	        String password = req.getParameter("password");

	        if (authenticate(username, password)) {
	            chain.doFilter(request, response);
	        } else {
	            res.sendRedirect("Login");
	        }
	    }
	    
	    public void destroy() {
	    }
	}

