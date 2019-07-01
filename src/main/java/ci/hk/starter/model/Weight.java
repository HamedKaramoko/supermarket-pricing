package ci.hk.starter.model;

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
	
	public abstract double toOunce(double unit);
	
	public abstract double toPound(double unit);
	
	public abstract double convert(double unit, Weight w);
}
