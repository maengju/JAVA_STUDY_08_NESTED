package nested;

public class Outer {
	private String name;
	
	public void output() {
		System.out.println("이름은 "+this.name+"\t"+new Inner().age); //밖에있는 클래스는 new로 생성해야지만 내부클래스로 접근가능
	}
	
	class Inner {
		private int age;
		
		public void disp() {
			System.out.println("이름은 "+Outer.this.name+"\t"+this.age);
		}
	}//member inner
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Outer ou = new Outer();
		ou.name="홍길동";
		ou.output();
		
		Outer.Inner in = ou.new Inner();
		in.age=25;
		in.disp();
		
		Outer.Inner in2 = ou.new Inner();
		in2.age=30;
		in2.disp();
		
		Outer.Inner in3 = new Outer().new Inner();
		
		in3.age=30;
		in3.disp();
		
	}

}
