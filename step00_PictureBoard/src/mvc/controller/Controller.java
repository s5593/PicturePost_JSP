package mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 * @author s5593
 *��� ��û�� �������� ....
 */
public interface Controller {
	ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException;
}
