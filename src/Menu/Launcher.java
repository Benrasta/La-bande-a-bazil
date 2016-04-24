package Menu;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Launcher {
	
	private JFrame f;
	private Containerz con;
	
	public Launcher(){	
		f = new JFrame("Launcher");
		con = new Containerz(f);
		
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        f.setLocation((int)((dim.width-f.getSize().width)/2.5), (dim.height-f.getSize().height)/3);
        
		f.getContentPane().add(con);
		f.pack();
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    f.setVisible(true);
	}
}
