package edu.towson.cis.cosc603.project4.rectangle;

// TODO: Auto-generated Javadoc
/**
 * The Class Rectangle.
 */
public class Rectangle {
	
	/** The p2. */
	private Point p1, p2;
	private Double xLength, yLength;
	
	
	/**
	 * Instantiates a new rectangle.
	 *
	 * @param p1 the p1
	 * @param p2 the p2
	 */
	Rectangle(Point p1, Point p2) {
		this.setP1(p1);
		this.setP2(p2);
	}
	
	private void caclulateLengths() {
		if((p1!=null) && (p2!=null)) {
			xLength = Math.abs(p2.x - p1.x);
			yLength = Math.abs(p2.y - p1.y);	
		}
	}
		
	/**
	 * @return the p1
	 */
	public Point getP1() {
		return p1;
	}

	/**
	 * @param p1 the p1 to set
	 */
	public void setP1(Point p) {
		this.p1 = p;
		this.caclulateLengths();
	}

	/**
	 * @return the p2
	 */
	public Point getP2() {
		return p2;
	}

	/**
	 * @param p2 the p2 to set
	 */
	public void setP2(Point p) {
		this.p2 = p;
		this.caclulateLengths();
	}

	/**
	 * Gets the area.
	 *
	 * @return the area
	 */
	public Double getArea() {
		Double area;
		area = xLength * yLength;
		return area;
	}
	
	/**
	 * Gets the diagonal.
	 *
	 * @return the diagonal
	 */
	public Double getDiagonal() {
		Double diagonal;
		diagonal = Math.sqrt(Math.pow(xLength, 2) + Math.pow(yLength, 2));
		return diagonal;
	}
}
