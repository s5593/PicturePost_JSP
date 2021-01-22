package mvc.service;

import mvc.dao.UserDAO;
import mvc.dao.UserDAOImpl;
import mvc.vo.UserDTO;

public class UserServiceImpl implements UserService {
	private UserDAO userDAO = new UserDAOImpl();

	@Override
	public UserDTO loginCheck(UserDTO userDTO) throws Exception {
		// TODO Auto-generated method stub
		
		UserDTO dbDTO = userDAO.loginCheck(userDTO);
		if(dbDTO == null) {
			throw new Exception("정보가 일치하지 않습니다.");
		}
		return dbDTO;
	}

}
