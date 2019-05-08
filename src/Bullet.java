import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Bullet extends JPanel implements ActionListener, KeyListener
{
    Timer tm = new Timer(5, this);
    int x = 180, y = 240, velX = 0, velY  = 0;

    public Bullet()
    {
        tm.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillOval(x, y, 5, 5);
    }


    public void actionPerformed(ActionEvent e)
    {
        x = x + velX;
        y = y + velY;
        repaint();
    }

    public void keyPressed(KeyEvent e)
    {
        int c = e.getKeyCode();
        if(c == KeyEvent.VK_LEFT)
        {
            velX = -1;
            velY = 0;
        }
        if(c == KeyEvent.VK_RIGHT)
        {
            velX = 1;
            velY = 0;
        }
        if(c == KeyEvent.VK_UP)
        {
            velY = -1;
            velX = 0;
        }
        if(c == KeyEvent.VK_DOWN)
        {
            velY = 1;
            velX = 0;
        }
    }

    public void keyTyped(KeyEvent e){}
    public void keyReleased(KeyEvent e)
    {
        velX = 0;
        velY = 0;
    }

    public static void main(String[] args)
    {
        Bullet bullet = new Bullet();
        JFrame frame = new JFrame();
        frame.setTitle("Bullet");
        frame.setSize(360, 480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(bullet);
        frame.setVisible(true);
    }
}
