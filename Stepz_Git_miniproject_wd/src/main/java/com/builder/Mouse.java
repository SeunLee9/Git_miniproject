package com.builder;

public class Mouse {
	private String name;
	private String address;
	private String color;
	private int age;
	private int height;
	
public Mouse(Builder builder) {
	this.name = builder.name;
	this.address = builder.address;
	this.color = builder.color;
	this.age = builder.age;
	this.height = builder.height;
	//빌더가 마우스 인스턴스 만들어준다
	System.out.println("sdfsdf");
	
	}


//	// 기본 생성자
//	public Mouse() {
//		
//	}
//	
//	// 이름만 알고있을 때
//	public Mouse(String name) {
//		//나머지는 기본값들을 초기화 해야겠다는데
////		this.name = name; // this : 인스턴스 자기 자신
////		this(); // this() : 생성자
//		this(name, null, null, 0, 0); //생성자임 알지?
//	}
//	
//	//이름과 주소를 알고 있을때
//	public Mouse(String name, String address) {
//		this(name, address, null, 0, 0) //이거까지 점층적 생성자 패턴 오버로딩이랑 똑같죠? 좋은점은 인스턴스를 생성할때는 가독성이 좋아짐 근데 클래스부분에서는 클래스가 계속 늘어난다 지금 만드는것처럼 //세터메서드로 만들면 기본생성자로 setter를 활용한패턴
//		
//	}
//	
//	//이렇게 만드는게 정해진게 아니다라는걸 느꼈으면한다고하심
//	public Mouse(String name, String address, String color, int age, int height) {
//		super();
//		this.name = name;
//		this.address = address;
//		this.color = color;
//		this.age = age;
//		this.height = height;
//	}
//
//	@Override
//	public String toString() {
//		return "Mouse [name=" + name + ", address=" + address + ", color=" + color + ", age=" + age + ", height="
//				+ height + "]";
//	}
	
	
	//여기부터 빌더패턴임
	// 별도의 정적 클래스 생성
	public static class Builder {
		private String name;
		private String address;
		private String color;
		private int age;
		private int height;
		
		// name이 필수로 작성해야하는 필드일 경우
		public Builder(String name) {
			this.name = name;
		}
		
		public Builder address(String address) {
			this.address = address;
			return this; //this는 인스턴스 자기자신 타입이 Builder라는 타입
		}
		
		public Builder color(String color) {
			this.color = color;
			return this;
		}
		
		public Builder age(int age) {
			this.age = age;
			return this;
		}
		
		public Builder height(int height) {
			this.height = height; //여기있는 address color age height는 맨위쪽에있는 address인가 아니면 빌더안에있는 address인가 Builder안에있는 address다
			return this;
		}
		
		public Mouse Build() { //Build를 일반적으로 하는거지 다른걸로 해도상관없음
			return new Mouse(this); //아무값도없다 인자값으로 위에있는 this를 넣는다 그런 메서드 없다고 뜨는데 만들거다 위쪽에 public Mouse어쩌고가 만들어짐 //클래스이름이랑 똑같은게 생성자 호출되는거 
		}
	}


	@Override //얘 안쓰면 주소값이 나오니깐 확인하려고 
	public String toString() {
		return "Mouse [name=" + name + ", address=" + address + ", color=" + color + ", age=" + age + ", height="
				+ height + "]";
	}
	//tostring을 만들어준이유는 문자열로 만들어주기위해 그런건가? 
	
	
}
