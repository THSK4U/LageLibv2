package Web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Dao.empruntimpliment;
import Metier.Membre;

@WebServlet("/EmpruntServlet")
public class EmpruntServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public EmpruntServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String memberName = request.getParameter("MemberName");
        String memberPhoneStr = request.getParameter("MembersPhone");
        int memberPhone = Integer.parseInt(memberPhoneStr);

        Membre member = empruntimpliment.getMemberInfo(memberName, memberPhone);

        if (member != null) {
            request.setAttribute("member", member);
            request.getRequestDispatcher("borrowConfirmation.jsp").forward(request, response);
        } else {
            // Handle case where member is not found
            // You can redirect to an error page or display an error message
        }
    }
}
