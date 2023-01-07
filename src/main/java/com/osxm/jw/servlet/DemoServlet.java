/**  
* @Title: DemoServlet.java
* @Package com.osxm.jw.servlet
* @Description: TODO
* @author XM
* @date 2022年12月17日 上午11:38:02
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
 * @ClassName DemoServlet
 * @Description TODO
 * @author XM 
 * @date 2022年12月17日
 * 
 */
public class DemoServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {	
	    resp.getWriter().println("Hello World, HttpServlet Get Response");
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {	
		//伪代码
		//1. 检查访问来源。 Referer
		/*String referer = req.getHeader("Referer");
		if(referer.startsWith("https://mysite")) {
			//
		}else {
			resp.getWriter().println("非法访问，可能存在CSRF攻击");
		}*/
		
		//2. 检查CSRF Token
        String sessionCsrfToken = "";
        if(req.getSession().getAttribute("csrfToken")!=null) {
        	sessionCsrfToken = req.getSession().getAttribute("csrfToken").toString();
        	String paramCsrfToken = req.getParameter("csrfToken");
        	if(sessionCsrfToken.equals(paramCsrfToken)) {
        		resp.getWriter().println("成功访问");
        	}else {
        		resp.getWriter().println("非法访问，可能存在CSRF攻击");
        	}
        	
        }else {
        	String csrfToken = UUID.randomUUID().toString();
        	req.getSession().setAttribute("csrfToken",csrfToken);
        	resp.getWriter().println("增加csrfToken进行访问，csrfToken="+csrfToken);
        }
	}

}