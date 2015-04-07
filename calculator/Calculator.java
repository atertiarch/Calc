package calculator;
import java.util.*;


public class Calculator {	
	
	private static final String CLOSING_BRACKET = ")";
	private static final String OPENING_BRACKET = "(";

	private static final List<String> operators = new ArrayList<>();
	static{
		operators.addAll(ArithmeticCalculator.getSupportedOperatos());
		operators.add(OPENING_BRACKET);
		operators.add(CLOSING_BRACKET);
	}



	public static void main(String[] args) {
		try(Scanner user_input = new Scanner(System.in)){	
		System.out.println("What do you want to calculate dear sire?");
		String whatToCalc = user_input.nextLine();

		Vector<String> vSorted = calculations(whatToCalc);
	    
	    System.out.println("Results: " + vSorted.toString());
	    } 
	}
	

	public static Vector<String> calculations(String whatToCalc) {
		
		Vector<String> vString = putInputIntoVector(whatToCalc);
	    
	    System.out.println("Not sorted: " + vString.toString());   
	    
	    Vector<String> vSorted= sortInput(vString);
	
	    System.out.println("Sorted: " + vSorted.toString());   
	    
	    return ArithmeticCalculator.calculateExpression(vSorted);

    }




	private static Vector<String> putInputIntoVector(String whatToCalc) {
		Vector<String> vString = new Vector<String>(0, 3);	    
	    
	    //put everything into vector
	    String a ="";
	    for (int i=0; i<whatToCalc.length(); i++){
	    	if(a.isEmpty() && operators.contains(whatToCalc.substring(i,i+1))){
	    		vString.add(new String(whatToCalc.substring(i,i+1)));	
			}
			else if(a.length()>0 && operators.contains(whatToCalc.substring(i,i+1))){	
				vString.add(new String(a));
				vString.add(new String(whatToCalc.substring(i,i+1)));
				a="";
			}
	    	else {
	    		a = a.concat(whatToCalc.substring(i,i+1));
	    		if(i==(whatToCalc.length()-1)){
	    			vString.add(new String(a));
	    		}
			}
	    }
		return vString;
	}


	private static Vector<String> sortInput(Vector<String> vString) {
		
	    //sorting

		Vector<String> vSorted=new Vector<String>(0, 1);
	    String stos="";
	    
	    for(int i=0; i<vString.size(); i++){
	    	
	    	if(vString.get(i).equals(OPENING_BRACKET)){
	    	}
	    	
	    	else if(vString.get(i).equals(CLOSING_BRACKET)){
	    		if (!stos.isEmpty()){
	    			stos = emptyStos(vSorted, stos);
		    	}
	    		
	    	}
	    	
	    	//if value is an operator 
	    	else if(operators.contains(vString.get(i))){
		    	stos = stos.concat(vString.get(i));
		    	
		    	
	    		}
	    	
	    	//if number
	    	else {
	    		vSorted.add(vString.get(i));	
	    		
	    		if(i>2 && vString.get(i-2).equals(CLOSING_BRACKET)){
	    			vSorted.add(stos.substring(stos.length()-1, stos.length()));
		    		stos = stos.substring(0, stos.length()-1);
	    			}
	    		else if (i==vString.size()-1){
	    			stos = emptyStos(vSorted, stos);
		    	}
	    	}
	    
	    }
		return vSorted;
	}





	private static String emptyStos(Vector<String> vSorted, String stos) {
		while(!stos.isEmpty()){
			vSorted.add(stos.substring(stos.length()-1, stos.length()));
			stos = stos.substring(0, stos.length()-1);
			}
		return stos;
	}
}
