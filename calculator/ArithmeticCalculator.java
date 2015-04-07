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
	    
    	double c;
	    double d;
	    double x;

	    while(operators.contains(vSorted.lastElement())){
	    	if(vSorted.get(i).equals("-")){
			    c=Double.parseDouble(vSorted.get(i-1));
			    d=Double.parseDouble(vSorted.get(i-2));
			    x=d-c;
			    i = removeValuesFromString(vSorted, i, x);

			}
		    else if(vSorted.get(i).equals("+")){
			    c=Double.parseDouble(vSorted.get(i-1));
			    d=Double.parseDouble(vSorted.get(i-2));
			    x=d+c;
			    i = removeValuesFromString(vSorted, i, x);
			}
		    else if(vSorted.get(i).equals("*")){
		    	c=Double.parseDouble(vSorted.get(i-1));
		    	d=Double.parseDouble(vSorted.get(i-2));
		    	x=d*c;
		    	i = removeValuesFromString(vSorted, i, x);
		    }
		    else if(vSorted.get(i).equals("/")){
		    	c=Double.parseDouble(vSorted.get(i-1));
		    	d=Double.parseDouble(vSorted.get(i-2));
		    	if (c!=0)	{
			    	x=d/c;
			    	i = removeValuesFromString(vSorted, i, x);
			    	}
		    	else	{
		    		throw new ArithmeticException("Nigdy cholero nie dziel przez 0!");
		    	}
		    }
		    else if(vSorted.get(i).equals("^")){
		    	c=Double.parseDouble(vSorted.get(i-1));
		    	d=Double.parseDouble(vSorted.get(i-2));
		    	x=Math.pow(d, c);
		    	i = removeValuesFromString(vSorted, i, x);
		    }
		    else i++;	
	    	
	    }
		return vSorted;
	}

	private static int removeValuesFromString(Vector<String> vSorted, int i,
			double x) {
		vSorted.set(i, String.valueOf(x));
		vSorted.remove(i-1);
		vSorted.remove(i-2);  
		i=0;
		return i;
	}
}
