package mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import mvc.service.PostService;
import mvc.service.PostServiceImpl;
import mvc.vo.PostDTO;

public class PostController implements Controller{

	PostService postService = new PostServiceImpl();
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		return null;
	}
	/**
	 * 전체 검색
	 */

	public ModelAndView selectAll(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<PostDTO> postList = postService.selectAll();
		request.setAttribute("list", postList);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("elecView/list.jsp");
		return mv;
	}
	
	/**
	 * 카테고리별로 검색
	 */
	public ModelAndView selectCategory(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<PostDTO> postList = postService.selectCategory("");
		request.setAttribute("list", postList);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName(null);
		return mv;
	}
	
	/**
	 * 포스트 추가
	 */
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println(2.-1);
		String saveDir=request.getServletContext().getRealPath("/save");
		int maxSize = 1024*1024*100;
		String encoding="UTF-8";
		System.out.println(2.0);
		System.out.println("============ uploadFilePath = " + saveDir);
		MultipartRequest m = new MultipartRequest(request, saveDir , maxSize, encoding, new DefaultFileRenamePolicy());
		System.out.println(2.1);
		String postNum = m.getParameter("post_num");
		String postName = m.getParameter("post_name");
		String category = m.getParameter("category");
		String password = m.getParameter("password");
		System.out.println(2.2);
		PostDTO post = new PostDTO(postNum, postName, category, password);
		System.out.println(2.3+" = " +post);
		m.getFilesystemName("picture");
		postService.insert(post);
		System.out.println(2.4);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("front?key=post&methodName=selectAll");
		mv.setRedirect(true);
		System.out.println(2.5);
		return mv;
	}
	
	/**
	 * 포스트 삭제
	 */
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String postNum = request.getParameter("post_num");
		String password = request.getParameter("password");

		postService.delete(postNum, password);

		ModelAndView mv = new ModelAndView("front", true);
		return mv;
	}
	
	/**
	 * 사진 업로드
	 * */
	public ModelAndView upload(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String saveDir=request.getServletContext().getRealPath("/save");
		int maxSize = 1024*1024*100;
		String encoding="UTF-8";
		
		MultipartRequest m = new MultipartRequest(request, saveDir , maxSize, encoding, new DefaultFileRenamePolicy());
		
		String postNum = m.getParameter("post_num");
		String postName = m.getParameter("post_name");
		String category = m.getParameter("category");
		String password = m.getParameter("password");
		
		PostDTO post = new PostDTO(postNum, postName, category, password);

		m.getFilesystemName("picture");
		postService.insert(post);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("front?key=post&methodName=selectAll");
		mv.setRedirect(true);
		return mv;
	}
}

	