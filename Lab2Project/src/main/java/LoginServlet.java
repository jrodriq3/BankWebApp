import Business.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/****************************************************
 *  Jason Rodriguez
 *  Lab 8 - Aug 29, 2022
 *  I promise that I wrote this code.
 ****************************************************/

@WebServlet(urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("customerId"));
        String password = request.getParameter("password");
        Customer c1 = new Customer();
        RequestDispatcher rd;
        c1.selectDB(id);
        
        // Getting the session
        HttpSession ses1 = request.getSession();
        
        
        
        if (password.equals(c1.getPassword())) {
            // adding c1 object to session
            ses1.setAttribute("c1", c1);
            // forwarding control to accountLookup page
            rd = request.getRequestDispatcher("/DisplayAccounts.jsp");
            rd.forward(request, response);
        }
        else {
            // adding c1 to session but giving it the id typed in the textbox otherwise it will be given the default value of 0
            // by setting the id, when the error page loads i can have it display the c1 objects id from the session giving an error for that id
            c1.setId(id);
            ses1.setAttribute("c1", c1);
            // forwarding control to ErrorPage page
            rd = request.getRequestDispatcher("/ErrorPage.jsp");
            rd.forward(request, response);
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
