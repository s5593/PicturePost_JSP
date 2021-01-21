package mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 * @author s5593
 *모든 요청에 공통으로 ....
 */
public interface Controller {
	ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException;
}
