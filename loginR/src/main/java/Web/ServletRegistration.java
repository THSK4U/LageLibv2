package Web;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import Dao.MembreDaoImpl;
import Metier.Membree;

/**
 * Servlet implementation class ServletRegistration
 */
@WebServlet("/")
public class ServletRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MembreDaoImpl membreDaoImpl;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRegistration() {
    	membreDaoImpl = new MembreDaoImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub 
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Registration.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String prenom_mb = request.getParameter("prenom_mb");
		String nom_mb = request.getParameter("nom_mb");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String ladresse = request.getParameter("ladresse");
	    int  numérotéléphone =Integer.parseInt(request.getParameter("numérotéléphone"));
		
		Membree membre = new Membree();
		membre.setPrenom_mb(prenom_mb);
		membre.setNom_mb(nom_mb);
		membre.setUsername(username);
		membre.setPassword(password);
		membre.setLadresse(ladresse);
		membre.setNumérotéléphone(numérotéléphone);
		

		try {
			membreDaoImpl.registerEmployee(membre);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Registrationdetails.jsp");
		dispatcher.forward(request, response);
	}

}
