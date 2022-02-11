package applicant.model.dto;

import java.sql.SQLException;
import java.util.ArrayList;

import applicant.exception.MessageException;
import applicant.exception.NotExistException;
import applicant.model.ApplicantDAO;

public class ApplicantService {
	
	public static boolean addApplicant(ApplicantDTO applicant) throws MessageException{
		boolean result = false;
		try{
			System.out.println("실행됐지롱22");
			result = ApplicantDAO.addApplicant(applicant);
		}catch(SQLException s){
			throw new MessageException("이미 존재하는 ID입니다 다시 시도 하세요");
		}
		return result;
	}
	
	public static ApplicantDTO getApplicant(String activistId) throws SQLException, NotExistException{
		ApplicantDTO activist = ApplicantDAO.getApplicant(activistId);
		if(activist == null){
			throw new NotExistException("검색하는 재능 기부자가 미 존재합니다.");
		}
		return activist;
	}
	
	public static ArrayList<ApplicantDTO> getAllApplicant() throws SQLException{
		return ApplicantDAO.getAllApplicant();
	}
	
	//재능 기부자 삭제 메소드[ ActivistDAO.deleteActivist()]
	public static boolean deleteApplicant(String applicant_id) throws SQLException, NotExistException{
		notExistApplicant(applicant_id);
		boolean result = ApplicantDAO.deleteApplicant(applicant_id);
		if(!result){
			throw new NotExistException("재능 기부자 정보 삭제 실패");
		}
		return result;
	}
	
	//Activist - CRUD
	public static void notExistApplicant(String applicant_id) throws NotExistException, SQLException{
		ApplicantDTO applicant = ApplicantDAO.getApplicant(applicant_id);
		if(applicant == null){
			throw new NotExistException("검색하는 재능 기부자가 미 존재합니다.");
		}
	}

}
