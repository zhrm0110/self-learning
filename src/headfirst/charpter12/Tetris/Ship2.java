package headfirst.charpter12.Tetris;

/*
 * The first kind of ship: square
 * |=|=|
 * |=|=|
 * Note that: there is no direction concept for the square, since it is same for any
 * direction.
 */

public class Ship2 extends ShipPanel {

    public Ship2() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Ship2(final int sizeLength, final int x1) {
        super(sizeLength, x1);
    }

    @Override
    public void assemble2() {
        this.setX2(this.getX1() + this.getSizeLength());
        this.setY2(this.getY1());
    }

    @Override
    public void assemble3() {
        this.setX3(this.getX1());
        this.setY3(this.getY1() + this.getSizeLength());
    }

    @Override
    public void assemble4() {
        this.setX4(this.getX1() + this.getSizeLength());
        this.setY4(this.getY1() + this.getSizeLength());
    }

    /**
     * Rotate with the clock direction according to rotation point the (x3,y3) and 90 degree each time.
     */
    @Override
    public Ship2 rotation() {
        this.setX1(this.getX3());
        this.setY1(this.getY3());
        this.compose();
        return this;
    }

}
