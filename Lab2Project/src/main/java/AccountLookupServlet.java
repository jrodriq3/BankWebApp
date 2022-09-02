
import Business.Account;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *  Jason Rodriguez
 *  Lab #6
 *  Aug 29, 2022
 *  CIST 2373
 *  I promise I wrote this code
 */
@WebServlet(urlPatterns = {"/AccountLookupServlet"})
public class AccountLookupServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Creating the account object and selecting the account that matches the account typed in the text box
        int actNo = Integer.parseInt(request.getParameter("account-number"));
        Account a1 = new Account();
        a1.selectDB(actNo);
        // Displaying to system log the account selected
        a1.display();
        
        
        // TODO MAKE ANOTHER PAGE THAT IT GOES TO IF ACCOUNT NUMBER ENTERED IS NOT IN SYSTEM
        
        
        
        // Adding the account object to the session
        HttpSession ses1 = request.getSession();
        ses1.setAttribute("a1", a1);
        
        RequestDispatcher rd = request.getRequestDispatcher("/DisplayAccount.jsp");
        rd.forward(request, response);
        
        
        
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
