package model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// DTO 생성중 - 규격화된 방식으로 데이터를 관리하기 위한 Bean 객체
// DTO는 멤버변수에 대한 직접 접근을 금지합니다. 

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Student {
	private String name;
	private int age;
	
	//생성자, 개터, 세터, toString 등등 만들어야 할 것이 너무 많다.

}
