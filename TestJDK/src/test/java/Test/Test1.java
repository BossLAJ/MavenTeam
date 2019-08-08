package Test;


import TestJDKNew.JDKNewExample;

//扩展方法的测试
public class Test1 implements JDKNewExample{
	public static void main(String[] args) {
		Formula formula = new Formula() {
			@Override
			public double cal(int a) {
				
				return sqrt(a*100);
			}
		};
		System.out.println(formula.cal(100));
		System.out.println(formula.sqrt(16));
	}
}
