//package mvc.filter;
//
//import java.io.IOException;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
///**
// * Servlet Filter implementation class SessionCheckFilter
// */
//@WebFilter({"/front", "/postView/write.jsp"})
//public class SessionCheckFilter implements Filter {
//
//    
//	public void doFilter(ServletRequest req, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//		//사전처리
//		HttpServletRequest request = (HttpServletRequest)req;
//		String key = request.getParameter("key");
//		if(key==null)key="post";
//		
//		if(request.getParameter("key").equals("post")) {
//			
//			HttpSession session = request.getSession();
//			if(session.getAttribute("loginUser") == null) {
//				request.setAttribute("errorMsg", "로그인하고 이용해주세요.. :)");
//				request.getRequestDispatcher("/errorView/error.jsp").forward(request, response);
//				return;
//			}
//		}
//		
//		
//		chain.doFilter(request, response);	//타겟대상 호출
//		//사후처리
//		
//		
//	}
//
//	
//
//}
