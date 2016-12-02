import com.bo.Plane;

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
    Image background;
    Plane plane1 = new Plane(250, 450, "resources/plane3.png", 100, 100);
    Plane plane2 = new Plane(400, 450, "resources/plane2.png", 100, 100);
    Plane enemyPlane = new Plane(350, 200, "resources/enemy-green-3.png", 50, 50);
    private int enemyPlaneX, enemyPlaneY;

    public GameWindow() {
        setTitle("Game 1945");
        setVisible(true);
        setSize(800, 600);
        setLocationRelativeTo(null);
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
                        if (plane1.getY() <= 15) {
                            break;
                        }
                        plane1.setY(plane1.getY() - 5);
                        repaint();
                        break;
                    case KeyEvent.VK_DOWN:
                        if (plane1.getY() >= 500) {
                            break;
                        }
                        plane1.setY(plane1.getY() + 5);
                        repaint();
                        break;
                    case KeyEvent.VK_RIGHT:
                        if (plane1.getX() >= 700) {
                            break;
                        }
                        plane1.setX(plane1.getX() + 5);
                        repaint();
                        break;
                    case KeyEvent.VK_LEFT:
                        if (plane1.getX() <= 0) {
                            break;
                        }
                        plane1.setX(plane1.getX() - 5);
                        repaint();
                        break;
                    case KeyEvent.VK_W:
                        if (plane2.getY() <= 15) {
                            break;
                        }
                        plane2.setY(plane2.getY() - 5);
                        repaint();
                        break;
                    case KeyEvent.VK_S:
                        if (plane2.getY() >= 500) {
                            break;
                        }
                        plane2.setY(plane2.getY() + 5);
                        repaint();
                        break;
                    case KeyEvent.VK_D:
                        if (plane2.getX() >= 700) {
                            break;
                        }
                        plane2.setX(plane2.getX() + 5);
                        repaint();
                        break;
                    case KeyEvent.VK_A:
                        if (plane2.getX() <= 0) {
                            break;
                        }
                        plane2.setX(plane2.getX() - 5);
                        repaint();
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("released");
            }
        });
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(background, 0, 0, 800, 600, null);
        g.drawImage(plane1.getImage(), plane1.getX(), plane1.getY(), plane1.getWidth(), plane1.getHeight(),null);
        g.drawImage(plane2.getImage(), plane2.getX(), plane2.getY(), plane2.getWidth(), plane2.getHeight(), null);
        g.drawImage(enemyPlane.getImage(), enemyPlane.getX(), enemyPlane.getY(), enemyPlane.getWidth(), enemyPlane.getHeight(), null);
    }
}