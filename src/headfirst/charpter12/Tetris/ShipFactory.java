package headfirst.charpter12.Tetris;

public class ShipFactory {

    private ShipPanel panel;

    public ShipPanel getPanel() {
        return panel;
    }

    public void setPanel(ShipPanel panel) {
        this.panel = panel;
    }

    public ShipFactory() {
        this.panel = new ShipPanel();
    }

    public ShipFactory(final int sizeLength, int x1loc) {
        int randomShipCategory = getRandomShipCategory();
        switch (randomShipCategory) {
            case 1:
                this.panel = new Ship1(sizeLength, x1loc);
                break;
            case 2:
                this.panel = new Ship2(sizeLength, x1loc);
                break;
            case 3:
                this.panel = new Ship3(sizeLength, x1loc);
                break;
            case 4:
                this.panel = new Ship4(sizeLength, x1loc);
                break;
            case 5:
                this.panel = new Ship5(sizeLength, x1loc);
                break;
            case 6:
                this.panel = new Ship6(sizeLength, x1loc);
                break;
            case 7:
                this.panel = new Ship7(sizeLength, x1loc);
                break;

            default:
                break;
        }
    }

    private int getRandomShipCategory() {
        // TODO Auto-generated method stub
        return (int) Math.ceil(Math.random() * 7);
    }
}
