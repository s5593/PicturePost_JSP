package mvc.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/downLoad")
public class DownLoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. �Ѿ���� ������ �̸��� �ޱ�
		String fName = request.getParameter("file");
		System.out.println("fName = " + fName);
		
		//2. ���������� ���� ��θ� ������
		String saveDir=request.getServletContext().getRealPath("C:\\Users\\s5593\\Desktop\\myGitHub\\PicturePost_JSP\\save");
		System.out.println("saveDir = " + saveDir);
		
		File file = new File(saveDir, fName);
		
		//�ΰ����� �ɼ�!!!
		//��û�� ������ mimeType�� �����Ѵ�(������ ���¼���)
		String mimeType = getServletContext().getMimeType(file.toString());
		
		if(mimeType==null){
			response.setContentType("application/octet-stream");
		}
		
		//������ �� �����̸������� �ѱ����ڵ�����
		if (request.getHeader("user-agent").indexOf("MSIE") == -1) {// IE�� �ƴѰ��
			fName = new String(file.getName().getBytes("UTF-8"), "8859_1");
		} else {
			fName = new String(file.getName().getBytes("euc-kr"), "8859_1");
		}
		
		//�������� �ؼ��Ҽ� �ִ� ������ �ؼ����� �ʰ� �ٿ�ε�!!!
		response.setHeader("Content-Disposition", "attachment;filename=\""+ fName + "\";");
		
		//3. �������� �����̸��� �ش��ϴ� ������ �о 
		//Ŭ���̾�Ʈ ���������� �ٿ�ε�(���=����)
		
		FileInputStream  fi = new FileInputStream(file);
		ServletOutputStream so = response.getOutputStream();
		
		byte b [] = new byte [1024];
	   
		int i=0;
		while((i = fi.read(b) ) != -1){
			so.write(b);
		}
		
		so.flush();
		fi.close();
		so.close();
		
	}

}






