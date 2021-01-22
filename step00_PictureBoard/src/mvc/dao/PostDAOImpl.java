package mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import mvc.util.DbUtil;
import mvc.vo.PostDTO;

public class PostDAOImpl implements PostDAO {

	@Override
	public List<PostDTO> selectAll() throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<PostDTO> list = new ArrayList<PostDTO>();
		String sql = "select * from Post order by writeday desc";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);

			rs = ps.executeQuery();
			while(rs.next()) {
				PostDTO elec = new PostDTO(rs.getString(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getString(5), rs.getString(6));
				list.add(elec);
			}
			
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}

	@Override
	public List<PostDTO> selectCategory(String category) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<PostDTO> list = new ArrayList<PostDTO>();
		String sql = "select * from Post order by writeday desc where category=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, category);
			rs = ps.executeQuery();
			while(rs.next()) {
				PostDTO elec = new PostDTO(rs.getString(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getString(5), rs.getString(6));
				list.add(elec);
			}
			
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}

	@Override
	public int insert(PostDTO postDTO) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "insert into post values(?,?,?,?,?,sysdate)";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, postDTO.getPostNum());
			ps.setString(2, postDTO.getPostName());
			ps.setString(3, postDTO.getCategory());
			ps.setString(4, postDTO.getPicture());
			ps.setString(5, postDTO.getPassword());
			
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

	@Override
	public int delete(String postNum, String password) throws Exception {
		Connection con =DbUtil.getConnection();
		PreparedStatement ps =null;
		int result =0;
		try{
			ps = con.prepareStatement("delete post where model_num=? and password=?");
			ps.setString(1, postNum);
			ps.setString(2, password);
			result = ps.executeUpdate();
		}finally{
			DbUtil.dbClose( ps, con);
		}
		return result;
	}

	@Override
	public PostDTO selectByNum(String postNum) throws Exception{
		Connection con = DbUtil.getConnection();
		PreparedStatement ps =null;
		ResultSet rs =null;
		PostDTO elec =null;
		try{
			 ps = con.prepareStatement( "select * from post where model_num=?");
			 ps.setString(1, postNum);
			 rs = ps.executeQuery();
			 if(rs.next()){
				 elec = new PostDTO(rs.getString(1), rs.getString(2), rs.getString(3), 
							rs.getString(4), rs.getString(5), rs.getString(6));			 }
		}finally{
			DbUtil.dbClose(rs, ps, con);
		}
		return elec;
	}

}
