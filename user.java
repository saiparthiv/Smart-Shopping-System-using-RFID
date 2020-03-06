import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/** * * @author vinodh */
public class User extends HttpServlet
/** * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
* methods. * * @param request servlet request * @param response servlet response *
@throws ServletException if a servlet-specific error occurs * @throws IOException if
an I/O error occurs */
protected void processRequest(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException response.setContentType("text/html;charset=UTF-
8");
try (PrintWriter out = response.getWriter())
String rf=request.getParameter("user");
Smart s=new Smart();
// s.rf(rf);
// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign
on the left to edit the code."> /** * Handles the HTTP <code>GET</code> method. * *
@param request servlet request * @param response servlet response * @throws ServletException
if a servlet-specific error occurs * @throws IOException if an I/O error
occurs */ @Override protected void doGet(HttpServletRequest request, HttpServletResponse
response)
throws ServletException, IOException processRequest(request, response);
/** * Handles the HTTP <code>POST</code> method. * * @param request servlet
request * @param response servlet response * @throws ServletException if a servletspecific
error occurs * @throws IOException if an I/O error occurs */ @Override protected
void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException processRequest(request, response);
/** * Returns a short description of the servlet. * * @return a String containing servlet
description */
@Override
public String getServletInfo()
return "Short description";
// </editor-fold>
Cloud Upload
import Cloudme.CloudmeUser;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
/** * * @author stigmata */
public class cloudUpload extends HttpServlet
/** * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
* methods. * * @param request servlet request * @param response servlet response *
@throws ServletException if a servlet-specific error occurs * @throws IOException if
an I/O error occurs */
protected void processRequest(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException response.setContentType("text/html;charset=UTF-
8");
try (PrintWriter out = response.getWriter())
String path="D:/myprojects/SmartCard/port.txt";
try
encryption1e = newencryption1();
e.encr(path);
CloudmeUser user=new CloudmeUser("suresh12345","suresh12345");
user.getFileManager().uploadFile(path,"/port/");
user.killUser();
RequestDispatcher rd=request.getRequestDispatcher("View.jsp");
rd.forward(request, response);
catch(Exception e)
JOptionPane.showMessageDialog(null, e);
