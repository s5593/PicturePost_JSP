 package mvc.service;

import java.sql.SQLException;

import mvc.vo.UserDTO;

public interface UserService {
	/**
	 * 로그인 체크
	 * */
   UserDTO loginCheck(UserDTO userDTO)throws SQLException;
}
