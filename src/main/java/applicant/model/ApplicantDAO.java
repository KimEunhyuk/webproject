package applicant.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import applicant.model.dto.ApplicantDTO;
import applicant.util.DBUtil;

public class ApplicantDAO {
	
	public static boolean addApplicant(ApplicantDTO applicant) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try{
			con = DBUtil.getConnection();
			System.out.println("실행됐지롱22__22");
			
			pstmt = con.prepareStatement("insert into applicant values(?, ?, ?, ?)");
			pstmt.setString(1, applicant.getId());
			pstmt.setString(2, applicant.getPassword());
			pstmt.setString(3, applicant.getName());
			pstmt.setString(4, applicant.getPhone());
			System.out.println("실행됐지롱33");
			
			int result = pstmt.executeUpdate();
		
			if(result == 1){
				System.out.println("실행됐지롱44");
				return true;
			}

			
		}catch(Exception e){
			e.printStackTrace();
		}
			finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}

}
