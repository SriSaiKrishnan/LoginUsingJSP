/**
 * 
 */
package com.sai.jsp;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author sv
 *
 */
@WebServlet("/login")
public class Login extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String name = request.getParameter("uname");
		String password = request.getParameter("password");
		
		LoginDao dao = new LoginDao();
		
		if (dao.checkUserExist(name, password)) {

			HttpSession session = request.getSession();
			session.setAttribute("username", name);
			response.sendRedirect("welcome.jsp");
		} else {
			response.sendRedirect("login.jsp");
		}
	}

}
