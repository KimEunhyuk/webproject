package applicant.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import applicant.model.dto.ApplicantDTO;
import applicant.model.dto.ApplicantService;

@WebServlet("/controller")
public class ApplicantController extends HttpServlet {
	
	public ApplicantController() {
        super();
    }
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//요청 정보에 한해서 한글인 경우에 인코딩 처리하는 설정
		request.setCharacterEncoding("utf-8");
	
		//command pattern
		String command = request.getParameter("command");
		
		try{
			if(command.equals("applicantInsert")){//재능 기부자 추가 등록
				applicantInsert(request, response);
			}else if(command.equals("applicant")) {
				applicant(request, response);
			}
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
			request.getRequestDispatcher("showError.jsp").forward(request, response);
			s.printStackTrace();
		}
	}
	
	
	// activistInsert :재능 기부자 가입 메소드
		protected void applicantInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String url = "showError.jsp";	// *** 일단 실패로 만들어줌
			
			String applicant_id = request.getParameter("id");
			String password = request.getParameter("password");
			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			
			System.out.println(phone);
			
			//해킹등으로 불합리하게 요청도 될수 있다는 가정하에 모든 데이터가 제대로 전송이 되었는지를 검증하는 로직
			//if(id != null && id.length() !=0 && name != null) {
				
			
			ApplicantDTO applicant = new ApplicantDTO(applicant_id, password, name, phone);
			try{
				System.out.println("실행됐지롱11");
				boolean result = ApplicantService.addApplicant(applicant);
				
				if(result){
					request.setAttribute("applicant", applicant);
					request.setAttribute("successMsg", "가입 완료");
					url = "applicantDetail.jsp";	// *** 제대로 applicant insert를 했을 때 url 수정해줌
				}else{
					request.setAttribute("errorMsg", "다시 시도하세요");
				}
			}catch(Exception s){
				request.setAttribute("errorMsg", s.getMessage());
			}
			request.getRequestDispatcher(url).forward(request, response);
		}
		
		
		
		
		// applicant : 재능 기부자 검색 
		public void applicant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String url = "showError.jsp";
			try {
				
				ApplicantDTO applicant = ApplicantService.getApplicant(request.getParameter("id"));
				HttpSession session = request.getSession();
				
				session.setAttribute("applicant",applicant);
				
				url = "index.jsp";
				
			}catch(Exception s){
				request.setAttribute("errorMsg", s.getMessage());
				s.printStackTrace();
			}
			request.getRequestDispatcher(url).forward(request, response);
		}
		
	
}
