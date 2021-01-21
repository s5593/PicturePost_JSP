package mvc.controller;

/**
 * 
 * @author s5593
 *사용자요청이 서비스를 실행 한 후에
 *결과뷰 페이지와 이동방식을 관리하는 클래스
 */
public class ModelAndView {
	private String viewName;	//결과뷰 페이지 이름
	private boolean isRedirect;	//false면 forward방식, true면 redirect방식
	
	public ModelAndView() {}

	public ModelAndView(String viewName, boolean isRedirect) {
		super();
		this.viewName = viewName;
		this.isRedirect = isRedirect;
	}
	
	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	public boolean isRedirect() {
		return isRedirect;
	}

	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}

	
}
