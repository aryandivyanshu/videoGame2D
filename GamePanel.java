import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements  Runnable{

    // SCREEN SETTINGS
    final  int originalTileSize = 16; //16 x 16 retro tile
    final int scale = 3; // to scale up the tiles for modern screens

    final int tileSize = originalTileSize * scale; //48 x 48 tile
    //the actual tile size

    final int maxScreenCol = 16;
    final int maxScreenRow = 12;

    final int screenWidth = tileSize * maxScreenCol; // 768 pixels
    final int screenHeight = tileSize * maxScreenRow; // 576 pixels
    // screen size for the game

    Thread gameThread;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);

    }

    public  void  startGameThread() {

        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        while(gameThread != null) // as long as gameThread exists{
           // System.out.println("game loop is running");

            // 1 UPDATE : update information such as character position
            // 2 DRAW : draw the screen with updated information
            // addition to coordinate points when key is pressed shall happen


        }

    }

