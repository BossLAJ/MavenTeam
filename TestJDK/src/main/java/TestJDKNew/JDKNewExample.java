package TestJDKNew;

//jdk新特性 扩展方法
public interface JDKNewExample {
	interface Formula{
		double cal(int a);
		default double sqrt(int a ) {
			return Math.sqrt(a);
		}
	}
}
