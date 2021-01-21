package game;

import java.awt.*;

public class GameTile {

    public static final int TILE_SIZE = 100;

    private int row;
    private int col;

    public GameTile(int row, int col) {

        this.row      = row;
        this.col      = col;
    }

    //Този метод изобразява полетата на игралната дъска
    public void render(Graphics g) {

        int tileX = this.col * TILE_SIZE;
        int tileY = this.row * TILE_SIZE;

        if ((this.row == 0 && this.col == 0) || (this.row == 0 && this.col == 4) || (this.row == 4 && this.col == 3) || (this.row == 4 && this.col == 1)) {
            g.setColor(Color.orange);
            g.fillRect(tileX, tileY, TILE_SIZE, TILE_SIZE);
        } else if ((this.row == 0 && this.col == 1) || (this.row == 4 && this.col == 4) || (this.row == 0 && this.col == 3) || (this.row == 4 && this.col == 0)) {
            g.setColor(Color.BLACK);
            g.fillRect(tileX, tileY, TILE_SIZE, TILE_SIZE);
        } else if ((this.row == 1 && this.col == 1) || (this.row == 1 && this.col == 0) || (this.row == 1 && this.col == 3) || (this.row == 1 && this.col == 4) ||
                   (this.row == 3 && this.col == 1) || (this.row == 3 && this.col == 0) || (this.row == 3 && this.col == 3) || (this.row == 3 && this.col == 4)) {
            g.setColor(Color.GRAY);
            g.fillRect(tileX, tileY, TILE_SIZE, TILE_SIZE);
        } else {
            g.setColor(Color.WHITE);
            g.fillRect(tileX, tileY, TILE_SIZE, TILE_SIZE);
        }
            g.setColor(Color.GRAY);
            g.fillOval(225,225,50,50);
    }
}