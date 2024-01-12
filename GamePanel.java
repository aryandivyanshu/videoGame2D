import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements  Runnable {

    // SCREEN SETTINGS
    final int originalTileSize = 16; //16 x 16 retro tile
    final int scale = 3; // to scale up the tiles for modern screens

    final int tileSize = originalTileSize * scale; //48 x 48 tile
    //the actual tile size

    final int maxScreenCol = 16;
    final int maxScreenRow = 12;

    final int screenWidth = tileSize * maxScreenCol; // 768 pixels
    final int screenHeight = tileSize * maxScreenRow; // 576 pixels
    // screen size for the game

    int FPS = 120;


    KeyHandler keyH = new KeyHandler();
    Thread gameThread;

    // Set player's position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4; //player speed 4 means movement of 4 pixels


    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);

    }

    public void startGameThread() {

        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        // buffering the draw time
        double drawInterval = 1000000000/FPS; // 1 billion nano seconds or 1 seconds/60 = 60 FPS
        double nextDrawTime = System.nanoTime() + drawInterval;

        while (gameThread != null){ // as long as gameThread exists
            //System.out.println("game loop is running");

            long currentTime = System.nanoTime();
            //long currentTime2 = System.currentTimeMillis();
            System.out.println("current Time: " + currentTime);

            // 1 UPDATE : update information such as character position
            update();
            // 2 DRAW : draw the screen with updated information
            repaint();
            // if fps is 60, we do update & draw 60 times per second

            // addition to coordinate points when key is pressed shall happen


            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;

                if (remainingTime < 0) {
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime);

                nextDrawTime = nextDrawTime + drawInterval;

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }


    }



    public void update (){
        if(keyH.upPressed == true){
            playerY = playerY - playerSpeed;
            /* in java, upper left corner is 0,0
            x value increases to right
            y value increases as they go down
            

            ---------------------------------------
            |(0.0)                  ----> x increases
            |
            |
            |
            |
            |    |
            |    |
            |   \ /
            |    '
            |  y value increases as they go down
            |

             */


        }

        else if (keyH.downPressed == true) {
            playerY += playerSpeed;
        }
        else if (keyH.leftPressed == true) {
            playerX -= playerSpeed;
        }
        else if (keyH.rightPressed == true) {
            playerX += playerSpeed;
        }

    }
    public void paintComponent (Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        g2.setColor(Color.white);
        g2.fillRect(playerX, playerY, tileSize, tileSize);
        g2.dispose();
    }



    }

