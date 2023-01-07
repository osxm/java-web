/**  
* @Title: LoginServlet.java
* @Package com.osxm.jw.servlet
* @Description: TODO
* @author XM
* @date 2022年12月25日 下午4:34:31
* @Copyright: 2022
* @version V1.0  
*/
package com.osxm.jw.servlet;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName LoginServlet
 * @Description TODO
 * @author XM 
 * @date 2022年12月25日
 * 
 */
public class LoginServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -904294297729391057L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {	
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		if("oscar".equals(username)&&"123456".equals(password)) {
			String csrfToken = UUID.randomUUID().toString();
	    	req.getSession().setAttribute("csrfToken",csrfToken);
	    	resp.sendRedirect("home.jsp");  	
		}else {
			req.getSession().setAttribute("errmsg","invalid username/password");
			resp.sendRedirect("login.jsp"); 
		}

	}

}
