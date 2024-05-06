package web;

import java.io.IOException;
import java.util.List;

import dao.LivresDaoimpli;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import metier.admin;
import metier.livers;
import metier.statistic;
import dao.MembreDao;
import dao.MembreDaoImpl;
import dao.statisticDao;
import dao.statisticImpli;
import metier.Membre;
import metier.Membree;

@WebServlet("/")
public class Lservlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private LivresDaoimpli livresDaoimpli;
    private MembreDao membreDao;
    private statisticImpli StatisticImpli;
    private statisticDao statisticDAO;
  
    public Lservlet() {
        this.livresDaoimpli = new LivresDaoimpli();
        this.membreDao = new MembreDaoImpl();
        this.statisticDAO = new statisticImpli();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        process(request, response);
    }
    

    
    private void process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
       
        if (action == null) {
        	processLogin(request, response);
        } else {
            switch (action) {
                case "/edit":
                    processEdit(request, response);
                    break;
                case "/confirmation":
                	Deletform(request, response);
                    break;
                case "/delete":
                	processDelete(request, response);
                    break;
                case "/new":
                    processNew(request, response);
                    break;
                case "/update":
                    processUpdate(request, response);
                    break;
                case "/save" :
                	processSave(request, response);
                	break;
                case "/recherche" :
                	getLivresByNom(request, response);
                	break;
                case "/List" :
                	processRequest(request, response);
                	break;
                case "/Login" :
                	Login(request, response);
                	break;
                case "/" :
                	processLogin(request, response);
                	break;
                	
                	//-----------membre----
                case "/Member/new":
                	processNewmmb(request, response);
                    break;
                case "/Member/save" :
                    processSavemmb(request, response);
                    break;
                case "/Member/confirmation" :
                	Deletformmmb(request, response);
                	 break;
                case "/Member/delete" :
                	processdeletmmb(request, response);
                    break;
                case "/Member" :
                	processRequestmmb(request, response);
                    break;
                case "/Member/edit" :
                	processEditmm(request, response);
                    break;
                case "/Member/update" :
                	processUpdatemm(request, response);
                    break;
                    //------------Dashboard--------------------
                    
                case "/Dashboard" :
                	Dashboard(request, response);
                    break;
                    
                    //-----------------Books-------------------
                case "/livres" :
                	RequestLivres(request, response);
                	break;
                	
                case "/Information" :
                	pageinfo(request, response);
                	break;
                	//-----signup--------
                case "/register" :
                	Register(request, response);
                	break;
                case "/regi" :
                	regi(request, response);
                	break;
            }
        }
    }
    //--------------------register---------------------
    private void Register(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/register.jsp").forward(request, response);
    }
    private void regi(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	  String fullName = request.getParameter("fullname");
          String email = request.getParameter("email");
          int phone = Integer.parseInt(request.getParameter("phone"));
          String username = request.getParameter("username");
          String password = request.getParameter("password");
          
          Membre membr = new Membre(fullName, email, phone,username,password);
          membreDao.signup(membr);
          
          response.sendRedirect(request.getContextPath() + "/");
      }
    
    
//-------------------BOOKS---------------------------------
    private void RequestLivres(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<livers> livres = livresDaoimpli.ALLlist();
        request.setAttribute("Livre", livres);
        request.getRequestDispatcher("/WEB-INF/WEBPAGES/Listweb.jsp").forward(request, response);
    }
    private void pageinfo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
        livers livr = livresDaoimpli.getLivres(id);
        request.setAttribute("Livre", livr);

        List<livers> Last = livresDaoimpli.getlastLivres();
        request.setAttribute("Last", Last);
        
      request.getRequestDispatcher("/WEB-INF/WEBPAGES/Info.jsp").forward(request, response);
    }
    //-------------login-----------------------
    private void processLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response);
    }
    
    private void Login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("username");
        String password = request.getParameter("password");

        List<admin> admins = livresDaoimpli.Admin();
        List<Membre> members = livresDaoimpli.getMembers();

        boolean isAdmin = false;
        boolean isMember = false;

        for (admin admin : admins) {
            if (name.equals(admin.getName_ad()) && password.equals(admin.getPassword())) {
                isAdmin = true;
                break;
            }
        }

        for (Membre member : members) {
            if (name.equals(member.getUsername()) && password.equals(member.getPassword())) {
                isMember = true;
                break;
            }
        }

        if (isAdmin) {
            response.sendRedirect(request.getContextPath() + "/Dashboard");
        } else if (isMember) {
            request.setAttribute("members", members);
            response.sendRedirect(request.getContextPath() + "/livres");
        } else {
            request.getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response);
        }
    }

    
    
//------------Dashboard------------------------------

    private void Dashboard(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<statistic> statistic = statisticDAO.selectstatistic();
        request.setAttribute("statistic", statistic);
       request.getRequestDispatcher("/WEB-INF/Dashboard/Dashboard.jsp").forward(request, response);
    }
 
//---------------------Livers-----------------------------------------
    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<livers> livres = livresDaoimpli.ALLlist();
        request.setAttribute("Livre", livres);
        request.getRequestDispatcher("/WEB-INF/Admin/livres.jsp").forward(request, response);
    }
    
   
    private void Deletform(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Admin/Formdelet.jsp");
        dispatcher.forward(request, response);
    }
    
    private void getLivresByNom(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    String titre = request.getParameter("titre");
    
    List<livers> livres = (List<livers>) livresDaoimpli.getLivresbynom(titre); 
    request.setAttribute("Livres", livres);
    request.getRequestDispatcher("/WEB-INF/Admin/livres.jsp").forward(request, response);
    
}

    
    private void processDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
        livresDaoimpli.deletLivres(id);
        response.sendRedirect(request.getContextPath() + "/List");
    }

    private void processEdit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
        livers livr = livresDaoimpli.getLivres(id);
        request.setAttribute("Livre", livr);
      request.getRequestDispatcher("/WEB-INF/Admin/edit.jsp").forward(request, response);
    }
    
      private void processNew(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       request.getRequestDispatcher("/WEB-INF/Admin/new.jsp").forward(request, response);
    }
    
      
    private void processSave(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
        String image = request.getParameter("image");
        String titre = request.getParameter("titre");
        String lauteur = request.getParameter("lauteur");
        String description = request.getParameter("description");

        int lannéepublication = Integer.parseInt(request.getParameter("lannéepublication"));

        livers livr = new livers(titre, lauteur, lannéepublication,image,description);
        
        livresDaoimpli.save(livr);
        response.sendRedirect(request.getContextPath() + "/List");
   
        }

    
    private void processUpdate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
        String image = request.getParameter("image");
        String titre = request.getParameter("titre");
        String lauteur = request.getParameter("lauteur");
        String description = request.getParameter("description");

        int lannéepublication = Integer.parseInt(request.getParameter("lannéepublication"));

        livers livr = new livers(id,titre, lauteur, lannéepublication,image,description);
        livresDaoimpli.update(livr);

        response.sendRedirect(request.getContextPath() + "/List");
    }
    
    //----------------------member--------------------
    
    private void processRequestmmb(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Membre> membres = membreDao.selectAllMembres();
        request.setAttribute("membres", membres);
        request.getRequestDispatcher("/WEB-INF/membres/AfficherM.jsp").forward(request, response);
    }

    private void processNewmmb(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/membres/new.jsp").forward(request, response);
    }
    private void Deletformmmb(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/membres/Formdelet.jsp").forward(request, response);

    }
    private void processdeletmmb(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	int id = Integer.parseInt(request.getParameter("id"));
    	membreDao.deletMembre(id);
        response.sendRedirect(request.getContextPath() + "/Member");
    }
    
    private void processSavemmb(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nom_mb = request.getParameter("nom_mb");
        String ladresse = request.getParameter("ladresse");
        int numérotéléphone = Integer.parseInt(request.getParameter("numérotéléphone"));

        Membre membr = new Membre(nom_mb, ladresse, numérotéléphone);
        
        membreDao.save(membr);
        
        response.sendRedirect(request.getContextPath() + "/Member");
    }
    private void processEditmm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Membre membr = membreDao.getMembre(id);
        request.setAttribute("membr", membr);
      request.getRequestDispatcher("/WEB-INF/membres/EditMember.jsp").forward(request, response);

    }

    private void processUpdatemm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		long id = Integer.parseInt(request.getParameter("id"));
        String Nom = request.getParameter("Nom");
        String Ladresse = request.getParameter("Ladresse");
        int numerotelephone = Integer.parseInt(request.getParameter("numerotelephone"));

        Membre membr = new Membre(id,Nom, Ladresse, numerotelephone);
        membreDao.update(membr);

        response.sendRedirect(request.getContextPath() + "/Member");
    }
}