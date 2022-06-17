public class Scratch {


    public static void cvt(Object obj) {
        System.out.println("*** entering cvt...");
     if (obj instanceof Point3) {
        Point3 pt = new Point3(13, 15, 17);
        System.out.println(obj.equals(pt));
    } else if (obj instanceof Point2) {
         Point2 pt = new Point2(13, 15);
         System.out.println(obj.equals(pt));
     }
    } // cvt()

    public static void main(String[] args) {

        Point3 pta = new Point3(3, 5, 7);
        Point3 ptb = new Point3(3, 5, 7);
        System.out.println(pta.equals(ptb));

        System.out.println();

        Point3 ptc = new Point3(2, 4, 7);
        Point3 ptd = new Point3(3, 5, 7);
        System.out.println(ptc.equals(ptd));

        System.out.println();

        Point3 pte = new Point3(2, 4, 7);
        Point3 ptf = new Point3(2, 4, 9);
        System.out.println(pte.equals(ptf));

        System.out.println();

        Point2 pt2d = new Point2(3, 5);
        cvt(pt2d);

        System.out.println();

        Point3 pt3d = new Point3(3, 5, 7);
        cvt(pt3d);

    } // main()
} // class Scratch


class Point2 {
    private int x, y;

    Point2() {
        this.x = 0;
        this.y = 0;
    } // Point2() default constructor

    Point2(int x, int y) {
        this.x = x;
        this.y = y;
    } // Point2() constructor

    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    } // set()

    public int getX() {
        return this.x;
    } // setX()

    public int getY() {
        return this.y;
    } // getY()

    @Override
    public boolean equals(final Object obj) {
        System.out.println("entering Point2.equals(final Object obj)");
        if (obj == null) return false;
        if (obj == this) return true;  // comparing to itself
        if (obj instanceof Point2 pt) {
            return this.equals(pt);
        } // if
        return false;
    } // equals()

    public boolean equals(final Point2 pt) {
        System.out.println("entering Point2.equals(final Point2 pt)");
        if (pt == null) return false;
        if (pt == this) return true;  // comparing to itself
        return (pt.x == this.x) && (pt.y == this.y);
    } // equals()

    @Override
    public int hashCode() {
        String s = this.toString();
        return s.hashCode();
    } // hashCode()

    @Override
    public String toString() {
        String str = "[" + this.x + "," + this.y + "]";
        return str;
    } // toString()

} // class Point2

class Point3 extends Point2 {
    private final int z;

    Point3() {
        this.set(0, 0);
        this.z = 0;
    } // Point3() default constructor

    Point3(int x, int y, int z) {
        this.set(x, y);
        this.z = z;
    } // Point3() constructor

    public int getZ() {
        return this.z;
    } // getZ()

    @Override
    public int hashCode() {
        String s = this.toString();
        return s.hashCode();
    } // hashCode()

    @Override
    public boolean equals(final Object obj) { // overriding definition
        System.out.println("entering Point3.equals(final Object obj)");
        if (obj instanceof Point3) return equals((Point3) obj);
        return super.equals(obj);
    }

    @Override
    public boolean equals(final Point2 pt) { // overriding definition
        System.out.println("entering Point3.equals(final Point2 pt)");
        if (pt instanceof Point3) return equals((Point3) pt);
        return super.equals(pt);
    }

    public boolean equals(final Point3 pt3) { // extra definition
        System.out.println("entering Point3.equals(final Point3 pt3)");
        if ((pt3 == null) || (this.z != pt3.z)) return false;
        return super.equals(pt3);
    }

    @Override
    public String toString() {
        String str = "[" + this.getX() + "," + this.getY() + "," + this.z + "]";
        return str;
    } // toString()


} // class Point3