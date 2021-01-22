package mvc.service;

import java.sql.SQLException;
import java.util.List;

import mvc.dao.PostDAO;
import mvc.dao.PostDAOImpl;
import mvc.vo.PostDTO;

public class PostServiceImpl implements PostService {
	private PostDAO postDAO = new PostDAOImpl();
	@Override
	public List<PostDTO> selectAll() throws Exception {
		List<PostDTO> postDTO = postDAO.selectAll();
		return postDTO;
	}

	@Override
	public List<PostDTO> selectCategory(String category) throws Exception {
		List<PostDTO> postDTO = postDAO.selectCategory(category);	
		return postDTO;
	}

	@Override
	public int insert(PostDTO postDTO) throws Exception {
		int result = postDAO.insert(postDTO);
		if(result == 0) {
			throw new SQLException("��ϵ��� �ʾҽ��ϴ�");
		}
		return result;
	}

	@Override
	public int delete(String postNum, String password) throws Exception {
		PostDTO dbElec = postDAO.selectByNum(postNum);
		if(!dbElec.getPassword().equals(password)){
			throw new SQLException("��й�ȣ �����Դϴ�.");
		}
		int result = postDAO.delete(postNum, password);
		if (result == 0) throw new SQLException("�������� �ʾҽ��ϴ�");
		return result;
	}

	@Override
	public PostDTO selectByNum(String postNum) throws Exception{
		PostDTO post = postDAO.selectByNum(postNum);
		if(post == null) {
			throw new SQLException(postNum+"�� �ش��ϴ� ������ �˻��� �� �����ϴ�.");
		}
		return post;
	}

}
