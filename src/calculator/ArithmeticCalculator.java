package calculator;	

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class ArithmeticCalculator {
	
	private static final Map<String, Operation> map = new HashMap<>();
	static{
		map.put("+", ArithmeticCalculator::add);
		map.put("-", ArithmeticCalculator::substract);
		map.put("*", ArithmeticCalculator::multiply);
		map.put("/", ArithmeticCalculator::divide);
		map.put("^", ArithmeticCalculator::power);
	}
	
	public static Collection<String> getSupportedOperatos(){
		return map.keySet();
	}
	
	public static Vector<String> calculateExpression(Vector<String> vSorted) {
		//calculation
		int i=0;
	    
	    while(getSupportedOperatos().contains(vSorted.lastElement())){

	    	if(map.containsKey(vSorted.get(i))){
	    		i=map.get(vSorted.get(i)).doOperation(vSorted, i);	    		
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
