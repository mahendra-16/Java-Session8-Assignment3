package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class SessionTracker extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String start = "<html><body>";
	private static final String end = "</html></body>";  
    
    public SessionTracker() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		out.println(start + "<h2 align = center> Welcome Back to Website</h2>" + end);
		out.println(start + "<h2 align = center> Session Information</h2>" + end);

		HttpSession session = request.getSession(true);

		Date creationTime = new Date(session.getCreationTime());
		Date lastAccess = new Date(session.getLastAccessedTime());

		String title = "Welcome Back to my website";
		Integer visitCount = new Integer(0);
		String visitCountKey = new String("visitCount");
		String userIDKey = new String("userID");
		String userID = new String("ABCD");

		// Check if this is new comer on your web page.
		if (session.isNew()) {
			title = "Welcome to my website";
			session.setAttribute(userIDKey, userID);
			session.setAttribute(visitCountKey, visitCount);
		}
		visitCount = (Integer) session.getAttribute(visitCountKey);
		visitCount = visitCount + 1;
		userID = (String) session.getAttribute(userIDKey);
		session.setAttribute(visitCountKey, visitCount);

		out.println("<TABLE border = 1 border-collapse = collapse align=center>\n+" + "<tr><TH>Session info</TH>"
				+ "<TH>value</TH></tr>\n+" + "<tr>\n" + "  <TD>id</TD>\n" + "  <td>" + session.getId() + "</td></tr>\n"
				+ "<tr>\n" + "  <td>Creation Time</td>\n" + "  <td>" + creationTime + "  </td></tr>\n" + "<tr>\n"
				+ "  <td>Time of Last Access</td>\n" + "  <td>" + lastAccess + "  </td></tr>\n" + "<tr>\n"
				+ "  <td>User ID</td>\n" + "  <td>" + userID + "  </td></tr>\n" + "<tr>\n"
				+ "  <td>Number of visits</td>\n" + "  <td>" + visitCount + "</td></tr>\n" + "</TABLE>\n" + end);

		
		
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
