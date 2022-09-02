import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/************************************************************************
 *  Jason Rodriguez
 *  Lab 3 Part 4 Aug 21, 2022
 *  I promise I wrote this code
 ***********************************************************************/
@WebServlet(urlPatterns = {"/LoginServletDB"})
public class LoginServletDB extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String id;
        id = request.getParameter("customerId");
        String password;
        password = request.getParameter("password");
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String conURL = "jdbc:ucanaccess:///Users/jasonwilsonrodriguez/Desktop/DESKDOCS/CIST2373/Labs/Lab3/ChattBankACCDB.accdb";
            Connection con = DriverManager.getConnection(conURL);
            //System.out.println("Connected");
            Statement stmt = con.createStatement();
            String sql = "select * from customers;";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String currentCustomerId = rs.getString(1);
                String currentPassword = rs.getString(2);
                if (currentCustomerId.equals(id)) {
                    if (currentPassword.equals(password)) {
                        out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<title>LoginServlet</title>");            
                        out.println("</head>");
                        out.println("<body>");
                        out.println("<h1>Login Success!</h1>");
                        out.println("</body>");
                        out.println("</html>");
                        return;
                    }
                    else {
                        out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<title>LoginServlet</title>");            
                        out.println("</head>");
                        out.println("<body>");
                        out.println("<h1>Invalid Password!</h1>");
                        out.println("</body>");
                        out.println("</html>");
                        return;
                    }
                }
            }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>LoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Invalid Customer ID</h1>");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
            e.printStackTrace();
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
