package ci.hk.starter.model;

/**
 * Represent a reference unit.
 * 
 * @author hamedkaramoko
 *
 */
public enum Weight {
	
	OUNCE {
		
		public double toOunce(double unit) { return unit;}
		
		public double toPound(double unit) { return unit / 16;}
		
		public double convert(double unit, Weight w) { return w.toOunce(unit); }
		
	}, POUND {
		
		public double toOunce(double unit) { return unit * 16;}
		
		public double toPound(double unit) { return unit;}
		
		public double convert(double unit, Weight w) { return w.toPound(unit); }
	};
	
	/**
	 * Converts to Ounce.
	 * 
	 * @param unit
	 * @return the result as Ounce.
	 */
	public abstract double toOunce(double unit);
	
	/**
	 * Converts to Pound.
	 * 
	 * @param unit
	 * @return the result as Pound.
	 */
	public abstract double toPound(double unit);
	
	/**
	 * Converts to supplied type.
	 * 
	 * @param unit
	 * @param w Unit onto convert.
	 * @return the result as argument Type.
	 */
	public abstract double convert(double unit, Weight w);
}
