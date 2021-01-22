package mvc.service;

import java.util.List;

import mvc.vo.PostDTO;

public interface PostService {
	
	/**
	 *  ��ü ����Ʈ�� ������
	 */
	List<PostDTO> selectAll() throws Exception;
	
	/**
	 * ī�װ��� ����Ʈ�� ������
	 */
	List<PostDTO> selectCategory(String category) throws Exception;
	
	/**
	 * ����Ʈ��ȣ�� �ش��ϴ� ����Ʈ �˻�
	 */
	PostDTO selectByNum(String postNum) throws Exception;
	
	
	/**
	 * ���� ����Ʈ �߰�
	 */
	int insert(PostDTO postDTO) throws Exception;
	
	/**
	 * ���� ����Ʈ ����
	 */
	int delete(String postNum, String password) throws Exception;
	
}
