package calculator;
import java.util.*;


public class Calculator {	
	
	public static void main(String[] args) {
		Scanner user_input = new Scanner(System.in);	
		System.out.println("What do you want to calculate dear sire?");
		String whatToCalc = user_input.nextLine();

		Vector<String> vSorted = calculations(whatToCalc);
	    
	    System.out.println("Results: " + vSorted.toString()); 
	}

	public static Vector<String> calculations(String whatToCalc) {
		List<String> operators = Arrays.asList(new String[]{"+","-","*","/","(",")"});
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
	    
	    System.out.println("Not sorted: " + vString.toString());   
	    
	    //sorting
	    Vector<String> vSorted = new Vector<String>(0, 1);
	    String stos="";
	    
	    for(int i=0; i<vString.size(); i++){

	    	if(vString.get(i).equals("(")){
	    	}
	    	else if(vString.get(i).equals(")")){
	    		if(stos.length()==1){
	    			vSorted.add(stos);
	    			stos="";
	    		}
	    		else if(!stos.isEmpty()){
	    		vSorted.add(stos.substring(stos.length()-1, stos.length()));
	    		stos = stos.substring(0, stos.length()-1);

	    		if(stos.substring(stos.length()-1, stos.length()).equals("*") || stos.substring(stos.length()-1, stos.length()).equals("/")){
		    		vSorted.add(stos.substring(stos.length()-1, stos.length()));
		    		stos = stos.substring(0, stos.length()-1);
		    		}
	    		if(i==vString.size()-1){
		    		for (int m = 0; m<stos.length(); m++){
		    			vSorted.add(stos.substring(m, m+1));
		    			}
		    		}
		    	}
	    		}
	    	else if(operators.contains(vString.get(i))){
	    		stos = stos.concat(vString.get(i));
	    	}
	    	else if(i==vString.size()-1 && !operators.contains(vString.get(i))){
	    		vSorted.add(vString.get(i));
	    		for (int m = stos.length()-1; m>=0; m--){
	    			vSorted.add(stos.substring(m, m+1));
	    		}
			}
	    	else if(!operators.contains(vString.get(i))){
	    		vSorted.add(vString.get(i));
	    		
	    		if(stos.length()==1){
	    			vSorted.add(stos);
	    			stos="";
	    		}
	    		else if (!stos.isEmpty()){
		    		vSorted.add(stos.substring(stos.length()-1, stos.length()));
		    		stos = stos.substring(0, stos.length()-1);
		    	}
	    	}
	    }
	
	    System.out.println("Sorted: " + vSorted.toString());   
	    

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
			    vSorted.set(i, String.valueOf(x));
			    vSorted.remove(i-1);
			    vSorted.remove(i-2);  
			    i=0;
			}
		    else if(vSorted.get(i).equals("+")){
			    c=Double.parseDouble(vSorted.get(i-1));
			    d=Double.parseDouble(vSorted.get(i-2));
			    x=d+c;
			    vSorted.set(i, String.valueOf(x));
			    vSorted.remove(i-1);
			    vSorted.remove(i-2);  
			    i=0;
			}
		    else if(vSorted.get(i).equals("*")){
		    	c=Double.parseDouble(vSorted.get(i-1));
		    	d=Double.parseDouble(vSorted.get(i-2));
		    	x=d*c;
		    	vSorted.set(i, String.valueOf(x));
		    	vSorted.remove(i-1);
		    	vSorted.remove(i-2);  
		    	i=0;
		    }
		    else if(vSorted.get(i).equals("/")){
		    	c=Double.parseDouble(vSorted.get(i-1));
		    	d=Double.parseDouble(vSorted.get(i-2));
		    	x=d/c;
		    	vSorted.set(i, String.valueOf(x));
		    	vSorted.remove(i-1);
		    	vSorted.remove(i-2);  
		    	i=0;
		    }
		    else i++;	    	
	    }
		return vSorted;
	}	
}       
