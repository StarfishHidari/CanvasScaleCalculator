package canvasScaleCalculator;

public class Calculations {
	
	double calculation = 0;
	boolean xSmaller;
	
	public double calculateCanvasScale ( double x, double y ) {
		
		if ( x < y ) {
			xSmaller = true;
			calculation = ( ( (x/y) * 4 ) - 1 ) / 3;
		} else {
			xSmaller = false;
			calculation = ( ( (y/x) * 4 ) - 1 ) / 3;
		}
		
		return calculation;
	}
	
	
	public double calculateCanvasScaleDownX ( double xScale, double scale) {
		
		if (xSmaller == true) {
			calculation = ( ( ( xScale + (1/3) ) * scale) - (1/3) );
		} else {
			calculation = ( ( ( 1.0 + (1/3) ) * scale) - (1/3) );
		}
		
		return calculation;
	}
	
	public double calculateCanvasScaleDownY ( double yScale, double scale) {
		
		if (xSmaller == true) {
			calculation = ( ( ( 1.0 + (1/3) ) * scale) - (1/3) );
		} else {
			calculation = ( ( ( yScale + (1/3) ) * scale) - (1/3) );
		}
		
		return calculation;
	}
}
