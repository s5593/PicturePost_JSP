package mvc.service;

import java.util.List;

import mvc.vo.PostDTO;

public interface PostService {
	
	/**
	 *  전체 포스트를 보여줌
	 */
	List<PostDTO> selectAll() throws Exception;
	
	/**
	 * 카테고리별 포스트를 보여줌
	 */
	List<PostDTO> selectCategory(String category) throws Exception;
	
	/**
	 * 포스트번호에 해당하는 포스트 검색
	 */
	PostDTO selectByNum(String postNum) throws Exception;
	
	
	/**
	 * 사진 포스트 추가
	 */
	int insert(PostDTO postDTO) throws Exception;
	
	/**
	 * 사진 포스트 제거
	 */
	int delete(String postNum, String password) throws Exception;
	
}
