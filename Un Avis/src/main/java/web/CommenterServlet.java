package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.util.List;

import Doa.AvisDao;
import Doa.AvisDaoImpl;
import Metier.commenter;

/**
 * Servlet implementation class CommenterServlet
 */
@WebServlet("/")
public class CommenterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AvisDao AvisDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommenterServlet() {
       this.AvisDao = new AvisDaoImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	@SuppressWarnings("unused")
	private void processSave(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        int id_livre = Integer.parseInt(request.getParameter("id_livre"));
	        String commenter = request.getParameter("commenter");

	        commenter Comm = new commenter(id_livre, commenter);
	        
	        AvisDao.save(Comm);
	        response.sendRedirect(request.getContextPath() + "/avis");
	   
	        }
	
	 @SuppressWarnings("unused")
	private void processRequest(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        List<String> Comment = AvisDao.getCommentairesByLivre(0);
	        request.setAttribute("commenter", Comment);
	        request.getRequestDispatcher("/WEB-INF/avis.jsp").forward(request, response);
	    }
}
