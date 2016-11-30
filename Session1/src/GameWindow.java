import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;

/**
 * Created by Khuong Duy on 11/30/2016.
 */
public class GameWindow extends Frame {
    Image background, plane;
    private int planeX;
    private int planeY;

    public GameWindow() {
        setVisible(true);
        setSize(800, 600);
        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("java.awt.event.WindowListener.windowOpened");

            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("windowClosing");
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("windowClosed");
            }

            @Override
            public void windowIconified(WindowEvent e) {
                System.out.println("windowIconified");
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                System.out.println("windowDeiconified");
            }

            @Override
            public void windowActivated(WindowEvent e) {
                System.out.println("windowActivated");
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                System.out.println("windowDeactivated");
            }
        });
        try {
            background = ImageIO.read(new File("resources/background.png"));
            plane = ImageIO.read(new File("resources/plane3.png"));
        } catch (IOException e) {
            System.out.println("Not found image");
            e.printStackTrace();
        }
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("Type");
            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        if(planeY<=15){
                            break;
                        }
                        planeY-=5;
                        repaint();
                        break;
                    case KeyEvent.VK_DOWN:
                        if(planeY>=500){
                            break;
                        }
                        planeY+=5;
                        repaint();
                        break;
                    case KeyEvent.VK_RIGHT:
                        if(planeX>=700){
                            break;
                        }
                        planeX+=5;
                        repaint();
                        break;
                    case KeyEvent.VK_LEFT:
                        if(planeX<=0){
                            break;
                        }
                        planeX-=5;
                        repaint();
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("released");
            }
        });
        planeX=350;
        planeY=450;
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(background, 0, 0, 800, 600, null);

        g.drawImage(plane, planeX, planeY, 100, 100, null);
    }
}