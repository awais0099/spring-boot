package com.example.springbootJUnit;

import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.springbootJUnit.services.CalculatorService;

public class CalculatorServiceTestJUnit5 {

	@BeforeAll
	public static void init() {
		System.out.println("Before all test case: ");
		System.out.println("Started test: " + new Date().toString());
	}

	@BeforeEach
	public void eachone() {
		System.out.println("before each");
	}
	
	@AfterEach
	public void aftereachone() {
		System.out.println("after each");
	}

	@Test
	public void addTwoNumbersTest() {
		System.out.println("addTwoNumbersTest");
		int result = CalculatorService.addTwoNumbers(2, 5);
		int expected = 7;
		Assertions.assertEquals(expected, result);
	}

	@Test
	public void productTwoNumbersTest() {
		System.out.println("productTwoNumbersTest");
		int result = CalculatorService.productTwoNumbers(2, 5);
		int expected = 10;
		Assertions.assertEquals(expected, result);
	}

	@Test
	public void dividTwoNumbersTest() {
		System.out.println("dividTwoNumbersTest");
		double result = CalculatorService.dividTwoNumbers(2, 10);
		int expected = 5;
		Assertions.assertEquals(expected, result);
	}

	@Test
	public void sumAnyNumbersTest() {
		System.out.println("sumAnyNumbersTest");
		double result = CalculatorService.sumAnyNumbers(2, 10);
		int expected = 12;
		Assertions.assertEquals(expected, result);
	}

	@AfterAll
	static void cleanup() {
		System.out.println("cleanup, AfterAll");
	}
}
