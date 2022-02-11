package applicant.model.dto;

import java.sql.SQLException;

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
	
	public static ApplicantDTO getApplicant(String applicantId) throws SQLException, NotExistException{
		ApplicantDTO applicant = ApplicantDAO.getApplicant(applicantId);
		if(applicant == null){
			throw new NotExistException("로그인 정보를 제대로 입력해주세요.");
		}
		return applicant;
	}
	
	
}
