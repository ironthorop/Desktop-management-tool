package Container;
import javax.swing.*;
public class View extends JFrame implements Runnable{
    JLabel L1;
    Thread t1;
    int i=0;
    public View()
    {
        setVisible(true);
        setSize(400,400);setDefaultCloseOperation((JFrame.DISPOSE_ON_CLOSE));
        L1= new JLabel();
        getContentPane().add(L1);
        t1=new Thread(this);
        t1.start();
    }
    public void run()
    {
        for(;;)
        {
            try
            {
                ImageIcon ico =new ImageIcon("C:\\\\Users\\\\Public\\\\Pictures\\\\"+i+".jpg");
                L1.setIcon(ico);
                i++;
                t1.sleep(400);
            }
            catch(Exception ex)
            {
                
            }
        }
    }
    public static void main(String args[])
    {
      new View();  
    }
    
}
