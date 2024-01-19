import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean upPressed, downPressed, leftPressed, rightPressed;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        //this method sets value of variables like upPressed, leftPressed, etc. to 'true' when particular keys are pressed 
        
        int code = e.getKeyCode();
        /*
        https://stackoverflow.com/questions/15313469/java-keyboard-keycodes-list
         */

        if (code == KeyEvent.VK_W){
            upPressed = true; 
        }

        if (code == KeyEvent.VK_A){
            leftPressed = true;
        }

        if (code == KeyEvent.VK_S){
            downPressed = true;
        }

        if (code == KeyEvent.VK_D){
            rightPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //this method sets value of variables like upPressed, leftPressed, etc. to 'false' when particular keys are pressed 

        int code = e.getKeyCode();


        if (code == KeyEvent.VK_W){
            upPressed = false;
        }

        if (code == KeyEvent.VK_A){
            leftPressed = false;
        }

        if (code == KeyEvent.VK_S){
            downPressed = false;
        }

        if (code == KeyEvent.VK_D){
            rightPressed = false;
        }


    }
}
