package ex2.geo;

import java.util.Comparator;

import ex2.ex2.Ex2_Const;
import ex2.gui.GUI_Shape;

/**
 * This class represents a Comparator over GUI_Shapes - 
 * as a linear order over GUI_Shapes.
 * Ex2: you should implement this class!
 * @author I2CS
 *
 */
public class ShapeComp implements Comparator<GUI_Shape>{

	public static final ShapeComp CompByArea = new ShapeComp(Ex2_Const.Sort_By_Area);
	public static final ShapeComp CompByAntiArea = new ShapeComp(Ex2_Const.Sort_By_Anti_Area);
	public static final ShapeComp CompByToString = new ShapeComp(Ex2_Const.Sort_By_toString);
	public static final ShapeComp CompByAntiToString = new ShapeComp(Ex2_Const.Sort_By_Anti_toString);

	public static final ShapeComp CompByPerimeter = new ShapeComp(Ex2_Const.Sort_By_Perimeter);
	public static final ShapeComp CompByAntiPerimeter = new ShapeComp(Ex2_Const.Sort_By_Anti_Perimeter);
	public static final ShapeComp CompByTag = new ShapeComp(Ex2_Const.Sort_By_Tag);
	public static final ShapeComp CompByAntiTag = new ShapeComp(Ex2_Const.Sort_By_Anti_Tag);



	private int _flag;
	public ShapeComp(int flag) {
		_flag = flag;
	}

	/**
	 * Make sure you implement the basic code below
	 * @param o1 the first object to be compared.
	 * @param o2 the second object to be compared.
	 * @return 1 iff o1 is grater than o1, -1 iff o1 is smaller than o2,
	 * and 0 iff o1 and o2 are equals.
	 */
	@Override
	public int compare(GUI_Shape o1, GUI_Shape o2) {
		int tagO1 = o1.getTag();
		int tagO2 = o2.getTag();
		double a1=-1, a2 = -1;
		GeoShape s1 = o1.getShape(), s2 = o2.getShape();
		int ans =0;
		// Compare based on area if that's the chosen criteria.
		if (_flag == Ex2_Const.Sort_By_Area) {
			a1 = s1.area();
			a2 = s2.area();
			if (a1 > a2) { ans = 1; }
			if (a1 < a2) { ans = -1; }
		}

		// Compare based on the inverse of area if that's the chosen criteria.
		if (_flag == Ex2_Const.Sort_By_Anti_Area) {
			a1 = s1.area();
			a2 = s2.area();
			if (a1 < a2) { ans = 1; }
			if (a1 > a2) { ans = -1; }
		}

		// Compare based on the string representation if that's the chosen criteria.
		if (_flag == Ex2_Const.Sort_By_toString) {
			ans = o1.toString().compareTo(o2.toString());
		}

		// Compare based on the inverse of string representation if that's the chosen criteria.
		if (_flag == Ex2_Const.Sort_By_Anti_toString) {
			ans = o1.toString().compareTo(o2.toString());
			if (ans == 1) { ans = -1; } // Invert the results for anti-sorting.
			if (ans == -1) { ans = 1; }
		}

		// Compare based on perimeter if that's the chosen criteria.
		if (_flag == Ex2_Const.Sort_By_Perimeter) {
			a1 = s1.perimeter();
			a2 = s2.perimeter();
			if (a1 < a2) { ans = 1; }
			if (a1 > a2) { ans = -1; }
		}

		// Compare based on the inverse of perimeter if that's the chosen criteria.
		if (_flag == Ex2_Const.Sort_By_Anti_Perimeter) {
			a1 = s1.perimeter();
			a2 = s2.perimeter();
			if (a1 > a2) { ans = 1; }
			if (a1 < a2) { ans = -1; }
		}

		// Compare based on tag if that's the chosen criteria.
		if (_flag == Ex2_Const.Sort_By_Tag) {
			if (tagO1 < tagO2) { ans = 1; }
			if (tagO2 > tagO1) { ans = -1; }
		}

		// Compare based on the inverse of tag if that's the chosen criteria.
		if (_flag == Ex2_Const.Sort_By_Anti_Tag) {
			if (tagO1 > tagO2) { ans = 1; }
			if (tagO2 < tagO1) { ans = -1; }
		}

		return ans;
	}
}
