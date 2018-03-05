import java.applet.*;
import java.util.Date;
import java.io.*;
import java.awt.*;
public class LOGO extends Applet implements Runnable{  
    Font font;
    Color blueColor;
    Color bgColor;
    Color weirdColor;
    Thread time;
    public void init() {
        font = new Font("Lato",Font.BOLD,16);
        blueColor = Color.blue;
        //weirdColor = new Color(60,60,122);
        bgColor = new Color(199, 232, 199);
        setBackground(bgColor);
    }
	public void start() {
		time = new Thread(this);   //this is runnable target
		time.start();
	}
	public void stop() {
		if (time == null)
			return;
		time.stop();
		time = null;
	}
 
	/* Runnable interface method */
	public void run() {
		while (time != null) {
			repaint();	    // request a redraw
			try {
				time.sleep(1000);
			} catch (Exception e){ System.out.println("Error:\t" +e );}
		}
    }
     
	public void paint(Graphics g) {
        Date d = new Date();
        g.setColor(Color.red);
        g.drawString("Current Time:", 450, 150);
        g.setColor(Color.blue);
        g.setFont(font);
        g.drawString(d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds(), 460, 170);
        g.setColor(Color.red);
        g.fillOval(20, 20, 300, 300);
        g.setColor(bgColor);
        g.fillRect(94, 20, 25, 160);
        g.fillOval(94, 100, 150,150);
        g.setColor(Color.red);
        g.fillOval(120, 125, 100, 100);
        g.setFont(font);
        g.drawString("This is the logo of BuzzFeed", 65, 350);
	}
}