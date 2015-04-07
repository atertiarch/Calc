package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class ArithmeticCalculator {
	
	private static final List<String> operators = Arrays.asList(new String[]{"+","-","*","/","(",")","^"});

	public static List<String> getSupportedOperatos(){
		return operators;
	}
	
	public static Vector<String> calculateExpression(Vector<String> vSorted) {
		//calculation
		int i=0;
	    
	    while(operators.contains(vSorted.lastElement())){
	    	if(vSorted.get(i).equals("-")){
			    i = substract(vSorted, i);
			}
		    else if(vSorted.get(i).equals("+")){
			    i = add(vSorted, i);
			}
		    else if(vSorted.get(i).equals("*")){
		    	i = multiply(vSorted, i);
		    }
		    else if(vSorted.get(i).equals("/")){
		    	i = divide(vSorted, i);
		    }
		    else if(vSorted.get(i).equals("^")){
		    	i = power(vSorted, i);
		    }
		    else i++;	
	    	
	    }
		return vSorted;
	}

	private static int power(Vector<String> vSorted, int i) {
		double c;
		double d;
		double x;
		c=Double.parseDouble(vSorted.get(i-1));
		d=Double.parseDouble(vSorted.get(i-2));
		x=Math.pow(d, c);
		i = removeValuesFromVector(vSorted, i, x);
		return i;
	}

	private static int divide(Vector<String> vSorted, int i) {
		double c;
		double d;
		double x;
		c=Double.parseDouble(vSorted.get(i-1));
		d=Double.parseDouble(vSorted.get(i-2));
		if (c!=0)	{
			x=d/c;
			i = removeValuesFromVector(vSorted, i, x);
			}
		else	{
			throw new ArithmeticException("Nigdy cholero nie dziel przez 0!");
		}
		return i;
	}

	private static int multiply(Vector<String> vSorted, int i) {
		double c;
		double d;
		double x;
		c=Double.parseDouble(vSorted.get(i-1));
		d=Double.parseDouble(vSorted.get(i-2));
		x=d*c;
		i = removeValuesFromVector(vSorted, i, x);
		return i;
	}

	private static int add(Vector<String> vSorted, int i) {
		double c;
		double d;
		double x;
		c=Double.parseDouble(vSorted.get(i-1));
		d=Double.parseDouble(vSorted.get(i-2));
		x=d+c;
		i = removeValuesFromVector(vSorted, i, x);
		return i;
	}

	private static int substract(Vector<String> vSorted, int i) {
		double c;
		double d;
		double x;
		c=Double.parseDouble(vSorted.get(i-1));
		d=Double.parseDouble(vSorted.get(i-2));
		x=d-c;
		i = removeValuesFromVector(vSorted, i, x);
		return i;
	}

	private static int removeValuesFromVector(Vector<String> vSorted, int i,
			double x) {
		vSorted.set(i, String.valueOf(x));
		vSorted.remove(i-1);
		vSorted.remove(i-2);  
		i=0;
		return i;
	}
}
