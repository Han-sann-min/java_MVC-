package Controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.domain.Student;

/*
 * Scope Object 
 * - 컨테이너는 서블릿 관리를 위해 몇몇 객체를 자동으로 생성하고 유지함
 * - 이들 중 속성 관리 기능을 제공하며 특정 범위 동안 유지되는 객체를 Scope Object라고 부름
 * - 이러한 객체는 각각 생성, 소멸 시기가 정해져 있어 서로 다른 JSP, 서블릿 간의 데이터 전달이나 공유를 위해 활용됨
 * - 이들은 공동적으로 키-값(Map)형태의 자료구조를 가지며, 활용해 페이지/사용자 간 데이터 공유가 가능
 * - page, request, session, application이 이에 해당됨
 *   - page : 한 번의 웹브라우저(클라이언트)의 요청에 대해 하나의 JSP 페이지가 호출되며 웹브라우저의 요청이 들어오면 이때 단 한 개의 페이지만 대응 된다. 
 *   		  service()를 벗어나면 소멸. 
 *   v - request : 현재 페이지가 요청될 때 생성, 다른 페이지로 이동할 때 소멸. 가져가려면 forwarding 해줘야 함
 *   v - session : 클라이언트가 서버에 접속할 때 생성, 일정 시간이 지나거나 브라우저가 종료될 때 소멸. 동일 클라이언트에 대해 다른 페이지에서도 참조 가능
 *   - application : 웹 어플리케이션이 시작될 때 생성. 웹 어플리케이션으 종료될 때 소멸. 모든 클라이언트에서 참조 가능
 *    
 *   임의 속성(attribute) 값을 저장하고 읽을 수 있는 다음의 메서드를 공통 제공 
 *   	- void setAttribute( String  key, Object  value ): 주어진 key속성의 값을 value로 지정.
 *   	- Object getAttribute( String  key ): 주어진  key속성의 값을 참조
 *   	- void removeAttribute( String  key ): 주어진  key속성의 값을 제거.
 *   
 *   
 *   JSP(Jasper) 
 *   	-  5가지 스크립트
 *   	- action tag 
 *   		- forward 태그 - request.getRequestDispatcher와 같은 역할 
 *   		- include 태그 - 다른 jsp나 Servlet을 현재 페이지에 포함하는 태그
 *   			<%@ include file="파일 위치" %>
 *   
 */

@WebServlet("/rideto")
public class Step01 extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 하나의 값을 꺼내올 때 
//		String value = request.getParameter("vehicle"); // 단수 - 첫번째 값만 파싱해옴
//		System.out.println(value);

		// 여러개의 값을 꺼내올 때 - getParameterValues
		System.out.println("value1-------------------");
		String[] value1 = request.getParameterValues("Vehicle");
		for (String val : value1) {
			System.out.println(val);
		}
		
		// 여러개의 값을 꺼내올 때 - stream api
//		System.out.println("Stream value1-------------------");
//		Arrays.asList(value1).forEach(System.out::println);
		
		// 누가 이 vehicle들을 타고 왔는지 추가해서 view로 전달하고 싶습니다.
		request.setAttribute("vehicle", value1);
		request.setAttribute("name", new Student("짱구", 5)); // 추가
		
		// 받은 요청을 전달할 때 
		// -1. 요청 자체만 전달 (redirect)
		// -2. 요청과 데이터를 함께 전달 (forward)
		

//		request.getRequestDispatcher("two").forward(request, response);
		
		
		// 쿠키(Cookie - 클라이언트에게 생겨납니다. 브라우저가 보관합니다. 내장 객체가 아닙니다.)
		// 얼마동안 보관할 것인지를 선택할 수 있습니다.
		Cookie msg1 = new Cookie("key1", "fisa");
		Cookie msg2 = new Cookie("key2", "쿠키");

		msg1.setMaxAge(60 * 3); // 기본값 - 초 단위 3분 
		response.addCookie(msg1);
		response.addCookie(msg2);

		
		// 세션(Session - httpServelet의 내장 객체. 서버에 생겨납니다. 클라이언트를 위한 메모리 공간이)  
		HttpSession session = request.getSession(); // 내장객체라서 new 생성자 X
		session.setAttribute("key3", "세션");
		session.setAttribute("key4", "fisa session");
		
//		response.sendRedirect("two");
		request.getRequestDispatcher("two").forward(request, response);
	}
	
}