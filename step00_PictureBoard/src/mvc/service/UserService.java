 package mvc.service;

import java.sql.SQLException;

import mvc.vo.UserDTO;

public interface UserService {
	/**
	 * �α��� üũ
	 * */
   UserDTO loginCheck(UserDTO userDTO)throws SQLException;
}
