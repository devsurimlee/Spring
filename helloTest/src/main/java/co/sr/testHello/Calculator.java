package co.sr.testHello;

public class Calculator {
	public void add(int n, int m) {
		System.out.println("두 수의 합: " + (n+m));
	}
	
	public void sub(int n, int m) {
		System.out.println("두 수의 차: " + (n-m));
	}
	
	public void mul(int n, int m) {
		System.out.println("두 수의 곱: " + (n*m));
	}
	
	public void div(int n, int m) {
		System.out.println("두 수의 나눔: " + (n/m));
	}
}
