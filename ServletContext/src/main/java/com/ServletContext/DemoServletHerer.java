package com.ServletContext;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DemoServletHerer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   static {
	   System.out.println("Servlet Loading....");
   }
    public DemoServletHerer() {
        super();
        System.out.println("servlet instantiation");
    }

	public void init() throws ServletException{
		System.out.println("servlet initialization!!");
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context=getServletContext();
		
		//Attribute Data which is dynamic
		context.setAttribute("name","gopika");
		context.setAttribute("age","20");
		context.setAttribute("class","3 btech");
		context.setAttribute("section","it-b");
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		pw.print("<html><head><title>ServletContext</title></head>");
		pw.print("<body align='center'>");
		pw.print("<table>");
		pw.print("<tr><th>ParameterName</th><th>ParameterValue</th></tr>");
		
		Enumeration<String> paranames=context.getInitParameterNames();
		while(paranames.hasMoreElements()) {
			String pname=(String)paranames.nextElement();
			String pvalue=context.getInitParameter(pname);
			pw.print("<tr>");
			pw.print("<td>"+pname+"</td><td>"+pvalue+"</td>");
			pw.print("</tr>");
		}
		
		pw.print("<tr><th>AttributeNAme</th><th>AttributeValue</th></tr>");
		Enumeration<String> attributenames=context.getAttributeNames();
		while(attributenames.hasMoreElements()) {
			String attributename=(String)attributenames.nextElement();
			Object attributeValue=context.getAttribute(attributename);
			pw.print("<tr>");
			pw.print("<td>"+attributename+"</td><td>"+attributeValue+"</td>");
			pw.print("</tr>");
		}
		
		pw.print("</table>");
		pw.print("</body></html>");
		
		
		
		
		
	}

	
	

}
