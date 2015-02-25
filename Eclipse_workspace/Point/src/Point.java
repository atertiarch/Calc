public class Point {
    private double x;
    private double y;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void print() {
        System.out.println("(" + x + "," + y + ")");
    }
    
    public void scale() {
        System.out.println("(" + x/2 + "," + y/2 + ")");
    }
    
    public void center(double a, double b) {
    	double c=(x+a)/2;
    	double d=(y+b)/2;
        System.out.println("(" + c + "," + d + ")");
    }

public static void main(String[] args){
		Point p = new Point(32, 32);
	    p.print();
	    p.center(3,2);
	    p.scale();
	    }
}
