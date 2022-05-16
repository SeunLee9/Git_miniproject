package com.builder;

public class MouseTest {

	public static void main(String[] args) {
		
//		//제리가 키가 몇센치였더라? 제리가 어디살았더라?
//		Mouse jerry = new Mouse("제리", null, "갈색", 2, 0);//내가 제리의 키는 잘 모르겠어 그런데 생성자가 저거 하나라면? 기본값 0으로 넣어둘수도있겠지만 미국도 생각안나서 String이니깐 null 이라고 적어두는데 
//		//그런데 나중에 저 값들을보면 저게 뭔지 헷갈린다 즉 가독성이 떨어진다
//		
//		//이걸해결하기위해 아까 점층적 생성자 패턴을 썼는데
//		
//		//점층적 생성자 패턴
//		Mouse jay = new Mouse();
//		System.out.println(jay);
//		
//		//이름만 알고있을때
//		Mouse jamie = new Mouse("제이미");
//		System.out.println(jamie);
//		
//		//이름과 주소를 알고있을때
//		Mouse jayz = new Mouse("제이지", "5");
//		System.out.println(jayz);
		
		// 빌더 패턴
		//세터랑 뭐 장점만 결합한거라는데 뭐였지
		//생성자를 오버로딩할필요가없어진다 원하는필드만 세팅할수있다
		
		// Builder 클래스로 생성한 인스턴스
		new Mouse.Builder("제리").address("하와이").age(5).Build();
		
		//이것도 빌더 클래스로 생성한 인스턴스(반환타입이 this니까)
//		new Mouse.Builder("제리");
		
		//이것도 빌더클래스로 생성한 인스턴스
		Mouse jerry = new Mouse.Builder("제리").address("하와이")
								.height(50)
								.Build();
		//장점은? 각각의 값들로 직관적으로 알수있음 보통 개행해서씀
		
		System.out.println(jerry);
		
	}

}
