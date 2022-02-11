package applicant.model2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	
	//수정  
	//기부자 id로 주요 기부 내용 수정하기
	public static boolean updateApplicant(String applicantId, String name) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			
			pstmt = con.prepareStatement("update applicant set name=? where applicant_id=?");
			pstmt.setString(1, name);
			pstmt.setString(2, applicantId);
			
			int result = pstmt.executeUpdate();
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	//??? 삭제
	//sql - delete from activist where activist_id=?
	public static boolean deleteApplicant(String applicantId) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("delete from applicant where applicant_id=?");
			pstmt.setString(1, applicantId);
			int result = pstmt.executeUpdate();
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	//id로 해당 기부자의 모든 정보 반환
	public static ApplicantDTO getApplicant(String applicantId) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ApplicantDTO applicant = null;
		
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from applicant where applicant_id=?");
			pstmt.setString(1, applicantId);
			rset = pstmt.executeQuery();
			if(rset.next()){
				applicant = new ApplicantDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return applicant;
	}
	
	//???모든 기부자 검색해서 반환
	//sql - select * from activist
	public static ArrayList<ApplicantDTO> getAllApplicant() throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ApplicantDTO> list = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from applicant");
			rset = pstmt.executeQuery();
			
			list = new ArrayList<ApplicantDTO>();
			while(rset.next()){
				list.add(new ApplicantDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4)) );
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}

}