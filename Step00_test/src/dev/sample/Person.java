package dev.sample;

// person이라는 클래스 정의
public class Person {
	
	// 5. 사람의 이름과 나이를 갖는 필드(프로퍼티 in JS) 정의
	private String name;
	private int age;
	
	// 6. name과 age를 입력받는 생성자 함수(Constructor) 작성
	// 생성자 함수의 특징 : 클래스 이름과 동일하다.
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
		
	}
	
//	int yooo = new Person("유재석, 48");  //정수형 타입의 변수 yooo에 Person 객체 초기화 불가
	//앞쪽에는 항상 타입을 써야한다 
	//타입 변수명 = new 클래스명()
	//위에걸 이런식으로 고쳐줘야한다
	Person yooo = new Person("유재석", 48); //Person 타입
	//new Person은 우리가 12번째줄에서 만든 Person이라는 생성자함수가 만들어진다

	
//	System.out.println(yooo,getName());// 이게 안되는이유는?
// getName이라는 메서드가 정의가 안됐기때문이다
	
}
