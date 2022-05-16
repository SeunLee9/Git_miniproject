package dev.sample;

// person�̶�� Ŭ���� ����
public class Person {
	
	// 5. ����� �̸��� ���̸� ���� �ʵ�(������Ƽ in JS) ����
	private String name;
	private int age;
	
	// 6. name�� age�� �Է¹޴� ������ �Լ�(Constructor) �ۼ�
	// ������ �Լ��� Ư¡ : Ŭ���� �̸��� �����ϴ�.
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
		//person
	}
	
//	int yooo = new Person("���缮, 48");  //������ Ÿ���� ���� yooo�� Person ��ü �ʱ�ȭ �Ұ�
	//���ʿ��� �׻� Ÿ���� ����Ѵ� 
	//Ÿ�� ������ = new Ŭ������()
	//������ �̷������� ��������Ѵ�
	Person yooo = new Person("���缮", 48); //Person Ÿ��
	//new Person�� �츮�� 12��°�ٿ��� ���� Person�̶�� �������Լ��� ���������

	
//	System.out.println(yooo,getName());// �̰� �ȵǴ�������?
// getName�̶�� �޼��尡 ���ǰ� �ȵƱ⶧���̴�
	
}
