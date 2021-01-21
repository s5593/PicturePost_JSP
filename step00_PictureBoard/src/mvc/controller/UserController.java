package mvc.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.service.UserService;
import mvc.vo.UserDTO;
import sku.mvc.service.UserServiceImpl;

public class UserController implements Controller {
  private UserService userService = new UserServiceImpl();
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return null;
	}
	
	/**
	 * �α���
	 */
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException{
		System.out.println("User�� logIn ȣ��");
		//���� -> dao
		String userId = request.getParameter("userId");
		String pwd = request.getParameter("pwd");
		
		UserDTO dbDTO = userService.loginCheck(new UserDTO(userId, pwd));
		
		//���ǿ� ������ ����
		HttpSession session = request.getSession();
		session.setAttribute("loginUser", dbDTO.getUserId());
		session.setAttribute("loginName", dbDTO.getName());
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index.jsp");
		mv.setRedirect(true);
		
		return mv;
			}

	/**
	 * �α׾ƿ�
	 */
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//��� ���� ���� ����
		HttpSession session = request.getSession();
		session.invalidate();
		//������ �̵��Ѵ�.
		System.out.println("User�� logout ȣ��");
		return new ModelAndView("index.jsp", true);
			}
}
