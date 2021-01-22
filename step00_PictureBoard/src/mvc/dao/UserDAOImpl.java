package mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mvc.util.DbUtil;
import mvc.vo.UserDTO;

public class UserDAOImpl implements UserDAO {

	@Override
	public UserDTO loginCheck(UserDTO userDTO) throws SQLException {
	//�ε�, ����, ����, �ݱ�
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserDTO dbDTO = null;
		String sql = "select user_id, pwd, name from users where user_id=? and pwd=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			//?�� �ִٸ� ?�� ������� setXxx()�ʿ��ϴ�
			ps.setString(1, userDTO.getUserId());
			ps.setString(2, userDTO.getPwd());
			rs = ps.executeQuery();
			if(rs.next()) {//Ŀ���� ������(��) �̵�
				dbDTO = new UserDTO(rs.getString(1), rs.getString(2), rs.getString(3));
			}
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return dbDTO;
	}
}

