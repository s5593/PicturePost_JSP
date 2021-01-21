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
 * ������� ��� ��û�� �߾����������� �������� ������
 * Controller ������ �Ѵ�.
 */
@WebServlet(urlPatterns = "/front", loadOnStartup=1)
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Controller> map = new HashMap<String, Controller>();
	private Map<String, Class<?>> clsMap = new HashMap<String, Class<?>>();
      
	@Override
		public void init(ServletConfig config) throws ServletException {
			//ResourceBundle�� ~.properties ������ �ε��ϴ� ����Ŭ�����μ�
			//���ϸ��� ������ �� Ȯ���ڴ� �����մϴ�.
			ResourceBundle rb = 
//					ResourceBundle.getBundle("sku/mvc/controller/actionMapping");
					ResourceBundle.getBundle("actionMapping");
			
			for(String key : rb.keySet()){
				String value = rb.getString(key);
//				System.out.println(key+" = "+value);
				try {
				//���ڿ��� Ŭ������ ��ü�� �����Ѵ�.
					Class<?> cls = Class.forName(value);//forName �޼ҵ�� �μ��� ���޵� ���ڿ��� �ϳ��� ��ü�� ���� �� �ֵ��� �����ִ� �޼ҵ�
					Controller controller = (Controller)cls.newInstance();//��ü����
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
		System.out.println("front ����.... key = "+key);
		System.out.println("front ����.... methodName = "+methodName);

		Controller controller= map.get(key);
		Class<?> cls = clsMap.get(key);
		try {
			Method method =  cls.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
			
			ModelAndView mv = (ModelAndView)method.invoke(controller, request, response);
	//		if(key.equals("select")) {
	//			//select ���
	//			controller = new SelectController();
	//		}
	//		else if(key.equals("update")) {
	//			controller = new UpdateController();
	//			//update ���
	//		}
	//		else if(key.equals("delete")) {
	//			//delete ���
	//			controller = new DeleteController();			
	//		}
			
			
			if(mv.isRedirect()) {
				response.sendRedirect(mv.getViewName());
			}
			else {
				request.getRequestDispatcher(mv.getViewName()).forward(request, response);
			}
		}catch(InvocationTargetException e){
			request.setAttribute("errorMsg", e.getCause().getMessage());	//���ܰ� �߻��� �ٺ����� ���� ���ܸ� ��ȯ
			request.getRequestDispatcher("errorView/error.jsp").forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
			request.getRequestDispatcher("errorView/error.jsp").forward(request, response);
		}
		
		
		
	}

}
