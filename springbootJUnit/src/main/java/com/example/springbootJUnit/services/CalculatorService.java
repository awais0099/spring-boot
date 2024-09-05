package com.example.springbootJUnit.services;

public class CalculatorService {
	public static int addTwoNumbers(int a, int b) {
		return a + b;
	}

	public static int productTwoNumbers(int a, int b) {
		return a * b;
	}

	public static double dividTwoNumbers(int a, int b) {
		return b/a;
	}

	public static int sumAnyNumbers(int ...numbers) {
		int s = 0;
		
		for (int i : numbers) {
			s += i;
		}
		
		return s;
	}
}
