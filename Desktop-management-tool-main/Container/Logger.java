package Container;
import java.awt.Rectangle;
import java.awt.Robot;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Logger extends JFrame implements Runnable{
    
    JButton b1, b2;
    JPanel p1;
    Thread t1;
    int i = 0;
    
    public Logger() {
        setVisible(true);
        setSize(200, 100);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        b1 = new JButton("Start");
        b2 = new JButton("Stop");
        p1 = new JPanel();
        p1.add(b1);
        p1.add(b2);
        getContentPane().add(p1);
        b1.addActionListener(e -> click(e));
        b2.addActionListener(e -> click(e));
    }
    
    public void click(ActionEvent e) {
        if (e.getSource() == b1) {
            t1 = new Thread(this);
            t1.start();
        } else {
            System.exit(0);
        }
        
    }
    
    public void run() {
        for (;;) {
            try {
                
                Robot r = new Robot();
                BufferedImage img = r.createScreenCapture(new Rectangle(getToolkit().getScreenSize()));
                ImageIO.write(img, "jpg", new File("C:\\Users\\Public\\Pictures\\" + i + ".jpg"));
                i++;
                t1.sleep(400);
            } catch (Exception ex) {
                
            }
        }
    }    
    
    public static void main(String args[]) {
        new Logger();
    }
}
