
public class InnerClass {
	public static void main(String[] args){
		new Test();
	}
}

class Test{
	Test() {
		b(4);
	}

	Test(int a) {
		System.out.print(a);
	}
	void b(int a){
		System.out.print(a);
	}
}

