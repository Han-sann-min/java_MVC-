package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.domain.Student;


@WebServlet("/two")
public class step02 extends HttpServlet {
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("text/html;charset=UTF-8");
//		PrintWriter out = response.getWriter(); // 화면에 출력하기 위한 객체
		
//		String[] vehicles = request.getParameterValues("vehicle");
//        Student student = (Student) request.getAttribute("name");

//        out.println("이름: " + student.getName());

//        if (vehicles != null) {
//            out.println("선택한 탈것:");
//            for (String vehicle : vehicles) {
//                out.println(vehicle);
//            }
//        } else {
//            out.println("탈것을 선택하지 않았습니다.");
//        }
//		
		
		//step01 - forward로만 이동된 상태에서 유효한 코드
//        request.getRequestDispatcher("endview.jsp").forward(request, response);

		// step02 - redirect로도 전달받을 수 있는(Client의 브라우저에 이미 저장된 쿠키 정보 획득)
		Cookie [] cs = request.getCookies();  // redirect로 받았으므로 저장할 때는 response, 가져올 때는 request에서 확인 
		
		for (Cookie c : cs) {
			if (c.getName().equals("key1")) {
			System.out.println(c.getValue());
			}
			
		}

//		response.sendRedirect("endview.jsp");
		
		 request.getRequestDispatcher("endview.jsp").forward(request, response);
	}

}
