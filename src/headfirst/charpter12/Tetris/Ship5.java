package headfirst.charpter12.Tetris;

/*
 * The first kind of ship:
 *   |=|=|
 * |=|=|
 * Note that: this ship also has two direction.
 */

public class Ship5 extends ShipPanel {

    private int direct;

    public Ship5() {
        super();
    }

    public Ship5(final int sizeLength, final int x1) {
        super(sizeLength, x1);
        // this.direct = (int) Math.floor(Math.random() * 2);
    }

    @Override
    protected void getDirect() {
        // TODO Auto-generated method stub
        this.direct = (int) Math.floor(Math.random() * 2);
    }

    @Override
    public void assemble2() {
        if (direct % 2 == 0) {
            this.setX2(this.getX1());
            this.setY2(this.getY1() + this.getSizeLength());
        } else {
            this.setX2(this.getX1() - this.getSizeLength());
            this.setY2(this.getY1());
        }
    }

    @Override
    public void assemble3() {
        if (direct % 2 == 0) {
            this.setX3(this.getX1() + this.getSizeLength());
            this.setY3(this.getY1() + this.getSizeLength());
        } else {
            this.setX3(this.getX1() - this.getSizeLength());
            this.setY3(this.getY1() + this.getSizeLength());
        }

    }

    @Override
    public void assemble4() {
        if (direct % 2 == 0) {
            this.setX4(this.getX1() + this.getSizeLength());
            this.setY4(this.getY1() + 2 * this.getSizeLength());
        } else {
            this.setX4(this.getX1() - 2 * this.getSizeLength());
            this.setY4(this.getY1() + this.getSizeLength());
        }
    }

    /**
     * Rotate with the clock direction according to rotation point the (x3,y3) and 90 degree each time.
     */
    @Override
    public Ship5 rotation() {
        if (direct % 2 == 0) {
            this.setX1(this.getX3());
            this.setY1(this.getY3() - this.getSizeLength());
        } else {
            this.setX1(this.getX3() + this.getSizeLength());
            this.setY1(this.getY3() - this.getSizeLength());
        }
        direct++;
        this.compose();
        return this;
    }

}
