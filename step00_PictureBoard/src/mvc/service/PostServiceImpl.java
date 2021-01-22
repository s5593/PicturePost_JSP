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
			throw new SQLException("등록되지 않았습니다");
		}
		return result;
	}

	@Override
	public int delete(String postNum, String password) throws Exception {
		PostDTO dbElec = postDAO.selectByNum(postNum);
		if(!dbElec.getPassword().equals(password)){
			throw new SQLException("비밀번호 오류입니다.");
		}
		int result = postDAO.delete(postNum, password);
		if (result == 0) throw new SQLException("삭제되지 않았습니다");
		return result;
	}

	@Override
	public PostDTO selectByNum(String postNum) throws Exception{
		PostDTO post = postDAO.selectByNum(postNum);
		if(post == null) {
			throw new SQLException(postNum+"에 해당하는 정보를 검색할 수 없습니다.");
		}
		return post;
	}

}
