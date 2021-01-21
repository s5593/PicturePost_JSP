package mvc.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 사용자의 모든 요청을 중앙집중적으로 관리해줄 진입점
 * Controller 역할을 한다.
 */
@WebServlet(urlPatterns = "/front", loadOnStartup=1)
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Controller> map = new HashMap<String, Controller>();
	private Map<String, Class<?>> clsMap = new HashMap<String, Class<?>>();
      
	@Override
		public void init(ServletConfig config) throws ServletException {
			//ResourceBundle은 ~.properties 파일을 로딩하는 전용클래스로서
			//파일명을 설정할 때 확장자는 생략합니다.
			ResourceBundle rb = 
//					ResourceBundle.getBundle("sku/mvc/controller/actionMapping");
					ResourceBundle.getBundle("actionMapping");
			
			for(String key : rb.keySet()){
				String value = rb.getString(key);
//				System.out.println(key+" = "+value);
				try {
				//문자열인 클래스를 객체로 생성한다.
					Class<?> cls = Class.forName(value);//forName 메소드는 인수로 전달된 문자열을 하나의 객체로 만들 수 있도록 도와주는 메소드
					Controller controller = (Controller)cls.newInstance();//객체생성
					System.out.println(controller);
					map.put(key, controller);
					clsMap.put(key, cls);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String key = request.getParameter("key");
		String methodName = request.getParameter("methodName");
		if(key==null || key.equals("")) {
			key = "elec";
			methodName="select";
		}
		System.out.println("front 진입.... key = "+key);
		System.out.println("front 진입.... methodName = "+methodName);

		Controller controller= map.get(key);
		Class<?> cls = clsMap.get(key);
		try {
			Method method =  cls.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
			
			ModelAndView mv = (ModelAndView)method.invoke(controller, request, response);
	//		if(key.equals("select")) {
	//			//select 기능
	//			controller = new SelectController();
	//		}
	//		else if(key.equals("update")) {
	//			controller = new UpdateController();
	//			//update 기능
	//		}
	//		else if(key.equals("delete")) {
	//			//delete 기능
	//			controller = new DeleteController();			
	//		}
			
			
			if(mv.isRedirect()) {
				response.sendRedirect(mv.getViewName());
			}
			else {
				request.getRequestDispatcher(mv.getViewName()).forward(request, response);
			}
		}catch(InvocationTargetException e){
			request.setAttribute("errorMsg", e.getCause().getMessage());	//예외가 발생한 근본적인 원인 예외를 반환
			request.getRequestDispatcher("errorView/error.jsp").forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
			request.getRequestDispatcher("errorView/error.jsp").forward(request, response);
		}
		
		
		
	}

}
