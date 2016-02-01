package calculator;

import java.util.Vector;

@FunctionalInterface
public interface Operation {

	public int doOperation(Vector<String> vSorted, int i);
	
}
