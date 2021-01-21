package piece;

import game.GameTile;

import java.awt.*;

public class Guard {

    public int row;
    public int col;

    public Guard(int row, int col) {
        this.row = row;
        this.col = col;
    }

    //Този метод изобразява гардовете на игралната дъска
    public void render(Graphics g) {
        g.setColor(Color.yellow);
        g.fillOval(27, 35, 50, 50);
        g.fillOval(125, 35, 50, 50);
        g.fillOval(225, 35, 50, 50);
        g.fillOval(325, 35, 50, 50);

        g.setColor(Color.green);
        g.fillOval(125, 425, 50, 50);
        g.fillOval(225, 425, 50, 50);
        g.fillOval(325, 425, 50, 50);
        g.fillOval(421, 425, 50, 50);

        g.setColor(Color.green);
        g.drawOval(27, 35, 50, 50);
        g.drawOval(125, 35, 50, 50);
        g.drawOval(225, 35, 50, 50);
        g.drawOval(325, 35, 50, 50);

        g.setColor(Color.yellow);
        g.drawOval(125, 425, 50, 50);
        g.drawOval(225, 425, 50, 50);
        g.drawOval(325, 425, 50, 50);
        g.drawOval(421, 425, 50, 50);

        int x = this.col * GameTile.TILE_SIZE;
        int y = this.row * GameTile.TILE_SIZE;
    }

    public boolean isMoveValid(int moveRow, int moveCol) {

        int rowCoefficient = Math.abs(moveRow - this.row);
        int colCoefficient = moveCol - this.col;

        return  rowCoefficient == 1 &&
                colCoefficient == 0;
    }

    public boolean isAttackValid(int attackRow, int attackCol) {
        return false;
    }

    public void move(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
