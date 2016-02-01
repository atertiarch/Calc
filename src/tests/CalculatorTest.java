package tests;

import java.util.Vector;

import static org.junit.Assert.*;
import org.junit.Test;

import calculator.Calculator;

public class CalculatorTest {

	@Test
	public void shouldAdd(){
		//given
		String equation = "2+2";
		//when
		Vector<String> calculations = Calculator.calculations(equation);
		//then
		assertTrue(4.0 == Double.valueOf(calculations.get(0)));
	}
	
	@Test
	public void shouldSubstract(){
		//given
		String equation = "5-2";
		//when
		Vector<String> calculations = Calculator.calculations(equation);
		//then
		assertTrue(3.0 == Double.valueOf(calculations.get(0)));
	}
	
	@Test
	public void shouldMultiply(){
		//given
		String equation = "2*3";
		//when
		Vector<String> calculations = Calculator.calculations(equation);
		//then
		assertTrue(6.0 == Double.valueOf(calculations.get(0)));
	}
	
	@Test
	public void shouldDivide(){
		//given
		String equation = "6/3";
		//when
		Vector<String> calculations = Calculator.calculations(equation);
		//then
		assertTrue(2.0 == Double.valueOf(calculations.get(0)));
	}
	
	@Test
	public void shouldMadeEquationsInCorrectOrder(){
		//given
		String equation = "2+2*2";
		//when
		Vector<String> calculations = Calculator.calculations(equation);
		//then
		assertTrue(6.0 == Double.valueOf(calculations.get(0)));
	}
	
	@Test
	public void shouldHonourBrances(){
		//given
		String equation = "2*(2+2)-2";
		//when
		Vector<String> calculations = Calculator.calculations(equation);
		//then
		assertTrue( 6.0 == Double.valueOf(calculations.get(0)));
	}
	
	@Test(expected = ArithmeticException.class )
	public void shouldProperlyHandleDivisionBy0(){
		//given
		String equation = "1/0";
		//when
		Vector<String> calculations = Calculator.calculations(equation);
		
		//then
		System.out.println(calculations.get(0));
		
		
	}
	
	@Test
	public void shouldRaisePower(){
		//given
		String equation = "2^3";
		//when
		Vector<String> calculations = Calculator.calculations(equation);
		//then
		assertTrue( 8.0 == Double.valueOf(calculations.get(0)));
	}
		
}
