package calculator.example;

public class PassingArguments {

	static class ExampleObject{

		Integer integer;
	}
	
	public static void main(String[] args){
		int i = 1;
		System.out.println("i:"+i);
		changePrimitiveInside(i);
		System.out.println("i:"+i);
		
		ExampleObject object=new ExampleObject();
		object.integer=1;
		System.out.println("integer: "+object.integer);
		changeObjectInside(object);
		System.out.println("integer: "+object.integer);
		
	}

	private static void changeObjectInside(ExampleObject object) {
		object.integer=2;
	}

	private static void changePrimitiveInside(int i) {
		i=2;
	}
	
}
