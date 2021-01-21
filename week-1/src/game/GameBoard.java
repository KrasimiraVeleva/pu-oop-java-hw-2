package game;

import piece.Leader;
import piece.Guard;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameBoard extends JFrame implements MouseListener {

    public static final int TILE_SIDE_COUNT = 5;

    private Guard[][] pieceCollection;
    private Guard selectedPiece;

    public GameBoard() {

        this.pieceCollection = new Guard[TILE_SIDE_COUNT][TILE_SIDE_COUNT];

        this.pieceCollection[0][0] = (new Guard(0, 0));
        this.pieceCollection[0][1] = (new Guard(0, 1));
        this.pieceCollection[0][2] = (new Guard(0, 2));
        this.pieceCollection[0][3] = (new Guard(0, 3));
        this.pieceCollection[0][4] = (new Guard(0, 4));

        this.pieceCollection[4][0] = (new Guard(4, 0));
        this.pieceCollection[4][1] = (new Guard(4, 1));
        this.pieceCollection[4][2] = (new Guard(4, 2));
        this.pieceCollection[4][3] = (new Guard(4, 3));
        this.pieceCollection[4][4] = (new Guard(4, 4));

        this.setSize(500,500);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        int row = this.getBoardDimensionBasedOnCoordinates(e.getY());
        int col = this.getBoardDimensionBasedOnCoordinates(e.getX());

        if(this.selectedPiece != null) {

            Guard g1 = (Guard)this.selectedPiece;
            g1.move(row, col);
            this.selectedPiece = null;
            this.repaint();
        }

        if(this.hasBoardPiece(row, col)) {
            this.selectedPiece = (Guard)this.getBoardPiece(row, col);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    //@Author Красимира Велева
    //Този метод изобразява игралната дъска
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for(int row = 0; row < 5; row++) {
            for(int col = 0; col < 5; col++) {

                GameTile tile = new GameTile(row, col);
                tile.render(g);

                Leader l = new Leader(row, col);
                l.render(g);

                Guard g1 = new Guard(row, col);
                g1.render(g);

            }
        }
    }

    private Guard getBoardPiece(int row, int col) {
        return this.pieceCollection[row][col];
    }

    private boolean hasBoardPiece(int row, int col) {
        return this.getBoardPiece(row, col) != null;
    }

    private int getBoardDimensionBasedOnCoordinates(int coordinates) {
        return coordinates / GameTile.TILE_SIZE;
    }
}


