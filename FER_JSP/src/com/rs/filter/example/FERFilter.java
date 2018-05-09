package com.rs.filter.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FERFilter implements Filter{
	
	

	@Override
	public void init(FilterConfig filterconfig) throws ServletException {
		// TODO Auto-generated method stub
		


	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterchain)
			throws IOException, ServletException {
		 System.out.println("FERFilter.doFilter()");
		boolean isSpecCharExist=false;
		
		Enumeration<String> parameterNames=request.getParameterNames();
		while(parameterNames.hasMoreElements()){
			String parameterName=parameterNames.nextElement();
			 
			String parameterValue=request.getParameter(parameterName);
			if(parameterValue.contains("*")){
				isSpecCharExist = true;
				break;
			}
		}
		if(isSpecCharExist){
			PrintWriter out=response.getWriter();
			out.println("<html><body>");
			out.println("Special character * is not allowed. Please go back to correct and proceed further");
			out.println("<a href=\"javascript:history.go(-1)\">Back</a>");
			out.println("</body></html>");
		}
		else{
			filterchain.doFilter(request,response);
		}
	}
		@Override
		public void destroy() {
			
	}

	}
	


