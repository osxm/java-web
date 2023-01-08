/**  
* @Title: CsrfServlet.java
* @Package com.osxm.jw.servlet
* @Description: TODO
* @author XM
* @date 2022年12月25日 下午5:23:02
* @Copyright: 2022
* @version V1.0  
*/
package com.osxm.jw.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName CsrfServlet
 * @Description TODO
 * @author XM 
 * @date 2022年12月25日
 * 
 */
public class CsrfServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2214369087330239230L;

	/**
	 * 
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {	
		String csrfTokenSession =  req.getSession().getAttribute("csrfToken")!=null?req.getSession().getAttribute("csrfToken").toString():"";
		String csrfTokenParam = req.getParameter("csrfToken");
		String amount = req.getParameter("amount");
		String msg = "";
		if(csrfTokenSession.equals(csrfTokenParam)) {
			// 进行转账
			msg = "successful.";
		}else {
			msg = "invalid csrf token, maybe CSRF Attach。";
		}
		req.setAttribute("msg",msg);
		req.getRequestDispatcher("result.jsp").forward(req,resp);
	}
}
