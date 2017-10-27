public class SafeRange {
	private double upperBound;
	private double lowerBound;
	
	public SafeRange(double u, double l){
		this.upperBound = u;
		this.lowerBound = l;
	}
	
	public double getUpperBound() {
		return upperBound;
	}
	public double getLowerBound() {
		return lowerBound;
	}
}