package headfirst.charpter12.Tetris;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class ShipPanel extends JPanel {
    private int sizeLength;
    private int x1, y1;// first chunck
    private int x2, y2;
    private int x3, y3;// rotation point
    private int x4, y4;

    public ShipPanel() {
        super();
    }

    public ShipPanel(int sizeLength, int x1) {
        super();
        this.sizeLength = sizeLength;
        this.x1 = x1;
        this.y1 = 0;
        this.getDirect();
        this.compose();
    }

    protected void getDirect() {
        // TODO Auto-generated method stub

    }

    public void compose() {
        this.assemble2();
        this.assemble3();
        this.assemble4();
    }

    public void assemble2() {
        this.setX2(this.getX1());
        this.setY2(this.getY1());
    }

    public void assemble3() {
        this.setX3(this.getX1());
        this.setY3(this.getY1());
    }

    public void assemble4() {
        this.setX4(this.getX1());
        this.setY4(this.getY1());
    }

    @Override
    public void paintComponent(Graphics graphics) {
        /**
         * Ther first two line used for clear last paint mark.
         */
        graphics.setColor(Color.white);
        graphics.clearRect(0, 0, this.getWidth(), this.getHeight());

        graphics.setColor(Color.GRAY);
        graphics.fillRect(x1, y1, sizeLength, sizeLength);
        graphics.fillRect(x2, y2, sizeLength, sizeLength);
        graphics.fillRect(x3, y3, sizeLength, sizeLength);
        graphics.fillRect(x4, y4, sizeLength, sizeLength);
    }

    public ShipPanel rmove() {
        this.x1++;
        this.x2++;
        this.x3++;
        this.x4++;
        return this;
    }

    public ShipPanel lmove() {
        this.x1--;
        this.x2--;
        this.x3--;
        this.x4--;
        return this;
    }

    public ShipPanel dmove() {
        this.y1++;
        this.y2++;
        this.y3++;
        this.y4++;
        return this;
    }

    public ShipPanel rotation() {
        return this;
    }

    public int getSizeLength() {
        return sizeLength;
    }

    public void setSizeLength(int sizeLength) {
        this.sizeLength = sizeLength;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public int getX3() {
        return x3;
    }

    public void setX3(int x3) {
        this.x3 = x3;
    }

    public int getY3() {
        return y3;
    }

    public void setY3(int y3) {
        this.y3 = y3;
    }

    public int getX4() {
        return x4;
    }

    public void setX4(int x4) {
        this.x4 = x4;
    }

    public int getY4() {
        return y4;
    }

    public void setY4(int y4) {
        this.y4 = y4;
    }
}
