import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
/**
*
* @author PURU
*/
public class UserLogin extends HttpServlet {
/**
* Processes requests for both HTTP <code>GET</code> and <code>POST</code>
* methods.

* @param request servlet request
* @param response servlet response
* @throws ServletException if a servlet-specific error occurs
* @throws IOException if an I/O error occurs
*/
protected void processRequest(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException { response.setContentType("text/html;charset=UTF-
8");
try (PrintWriter out = response.getWriter()) {
/* TODO output your page here. You may use following sample code. */
String name = request.getParameter("uname");
String pass = request.getParameter("pass");
HttpSession s=request.getSession(); s.setAttribute("name", name);
try {
int x = 0;
Class.forName("com.mysql.jdbc.Driver");
Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/trol",
"root", "root");
PreparedStatement ps = con.prepareStatement("select * from user where name=? and
pass=?");
ps.setString(1, name);
ps.setString(2, pass);
ResultSet rs=ps.executeQuery();
while(rs.next()){
x++;
}
if (x != 0) {
JOptionPane.showMessageDialog(null, "Success");
RequestDispatcher rd = request.getRequestDispatcher("UserHome.jsp"); rd.forward(request,
response);
} else { JOptionPane.showMessageDialog(null, "Failed"); RequestDispatcher rd = request.
getRequestDispatcher("contact.html"); rd.forward(request, response); }
} catch (Exception e) {
JOptionPane.showMessageDialog(null, e);
}
}
}

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign
on the left to edit the code.">
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
throws ServletException, IOException { processRequest(request, response);
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
throws ServletException, IOException
processRequest(request, response);
/**
* Returns a short description of the servlet.
*
* @return a String containing servlet description
*/
@Override
public String getServletInfo()
return "Short description";
// </editor-fold>
