package headfirst.charpter12.Tetris;

/*
 * The first kind of ship:
 *   |=|
 *   |=|
 * |=|=|
 * Note that: this ship also has two direction.
 */

public class Ship7 extends ShipPanel {

    private int direct;

    public Ship7() {
        super();
    }

    /**
     * Here is a bug: What I want is that the random direct make since on the ship direction. However supper constructor
     * must call before other code. At that time, the compose has been executed before the random direct. So each time
     * we will see the ship with default direct 0 (int init default as 0) Then the first rotate may not the rotation as
     * we expect because the random direct not equals with default 0.
     */
    public Ship7(final int sizeLength, final int x1) {
        super(sizeLength, x1);
        // this.direct = (int) Math.floor(Math.random() * 4);
    }

    @Override
    protected void getDirect() {
        // TODO Auto-generated method stub
        this.direct = (int) Math.floor(Math.random() * 4);
    }

    @Override
    public void assemble2() {
        switch (direct % 4) {
            case 0:
                this.setX2(this.getX1());
                this.setY2(this.getY1() + this.getSizeLength());
                break;
            case 1:
                this.setX2(this.getX1() - this.getSizeLength());
                this.setY2(this.getY1());
                break;
            case 2:
                this.setX2(this.getX1());
                this.setY2(this.getY1() - this.getSizeLength());
                break;
            default:
                // Eaques to case 3
                this.setX2(this.getX1() + this.getSizeLength());
                this.setY2(this.getY1());
                break;
        }
    }

    @Override
    public void assemble3() {
        switch (direct % 4) {
            case 0:
                this.setX3(this.getX1());
                this.setY3(this.getY1() + 2 * this.getSizeLength());
                break;
            case 1:
                this.setX3(this.getX1() - 2 * this.getSizeLength());
                this.setY3(this.getY1());
                break;
            case 2:
                this.setX3(this.getX1());
                this.setY3(this.getY1() - 2 * this.getSizeLength());
                break;
            default:
                // Eaques to case 3
                this.setX3(this.getX1() + 2 * this.getSizeLength());
                this.setY3(this.getY1());
                break;
        }

    }

    @Override
    public void assemble4() {
        switch (direct % 4) {
            case 0:
                this.setX4(this.getX1() - this.getSizeLength());
                this.setY4(this.getY1() + 2 * this.getSizeLength());
                break;
            case 1:
                this.setX4(this.getX1() - 2 * this.getSizeLength());
                this.setY4(this.getY1() - this.getSizeLength());
                break;
            case 2:
                this.setX4(this.getX1() + this.getSizeLength());
                this.setY4(this.getY1() - 2 * this.getSizeLength());
                break;
            default:
                // Eaques to case 3
                this.setX4(this.getX1() + 2 * this.getSizeLength());
                this.setY4(this.getY1() + this.getSizeLength());
                break;
        }
    }

    /**
     * Rotate with the clock direction according to rotation point the (x3,y3) and 90 degree each time.
     */
    @Override
    public Ship7 rotation() {
        switch (direct % 4) {
            case 0:
                this.setX1(this.getX3() + 2 * this.getSizeLength());
                this.setY1(this.getY3());
                break;
            case 1:
                this.setX1(this.getX3());
                this.setY1(this.getY3() + 2 * this.getSizeLength());
                break;
            case 2:
                this.setX1(this.getX3() - 2 * this.getSizeLength());
                this.setY1(this.getY3());
            default:
                this.setX1(this.getX3());
                this.setY1(this.getY3() - 2 * this.getSizeLength());
                break;
        }
        direct++;
        this.compose();
        return this;
    }

}
