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
	 * 로그인
	 */
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException{
		System.out.println("User의 logIn 호출");
		//서비스 -> dao
		String userId = request.getParameter("userId");
		String pwd = request.getParameter("pwd");
		
		UserDTO dbDTO = userService.loginCheck(new UserDTO(userId, pwd));
		
		//세션에 정보를 저장
		HttpSession session = request.getSession();
		session.setAttribute("loginUser", dbDTO.getUserId());
		session.setAttribute("loginName", dbDTO.getName());
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index.jsp");
		mv.setRedirect(true);
		
		return mv;
			}

	/**
	 * 로그아웃
	 */
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//모든 세션 정보 제거
		HttpSession session = request.getSession();
		session.invalidate();
		//폼으로 이동한다.
		System.out.println("User의 logout 호출");
		return new ModelAndView("index.jsp", true);
			}
}
