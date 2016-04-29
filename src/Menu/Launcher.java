package Menu;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import Autre.Jeu;

public class Launcher extends JPanel {

	private JFrame f;
	private JSpinner dimension;
	private JSpinner obstacles;

	public Launcher(){	
		f = new JFrame("Launcher");
		Containerz();

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		f.setLocation((int)((dim.width-f.getSize().width)/2.5), (dim.height-f.getSize().height)/3);

		f.getContentPane().add(this);
		f.pack();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	public void Containerz (){
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		FirstPanel();
		JButton bu1=new JButton("Humain VS Humain");
		JButton bu2=new JButton("Humain VS IA");
		JButton bu3=new JButton("IA VS IA");
		bu1.setPreferredSize(new Dimension(50,50));
		bu2.setPreferredSize(new Dimension(50,50));
		bu3.setPreferredSize(new Dimension(50,50));
		bu1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				new Jeu().LancementHVH((int)(dimension.getValue()),(int)(obstacles.getValue()));
			}
		});
		Box bx1=Box.createHorizontalBox();
		bx1.add(bu1);
		this.add(bx1);
		Box bx2=Box.createHorizontalBox();
		bx2.add(bu2);
		this.add(bx2);
		Box bx3=Box.createHorizontalBox();
		bx3.add(bu3);
		this.add(bx3);
	}

	public void FirstPanel(){
		JPanel fp=new JPanel();
		fp.setLayout(new BoxLayout(fp, BoxLayout.X_AXIS));
		JPanel p1 =new JPanel();
		JPanel p2 =new JPanel();
		p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));
		p2.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS));
		SpinnerNumberModel model1 = new SpinnerNumberModel(10, 7, 50, 1); 
		SpinnerNumberModel model2 = new SpinnerNumberModel(30, 10, 50, 5); 
		dimension= new JSpinner(model1);
		obstacles= new JSpinner(model2);
		dimension.setPreferredSize(new Dimension (100,20));
		obstacles.setPreferredSize(new Dimension (100,20));
		p1.add(new JLabel("Taille du plateau:"));
		p1.add(dimension);
		p2.add(new JLabel("Pourcentage de rocher:"));
		p2.add(obstacles);
		fp.add(p1);
		fp.add(p2);
		this.add(fp);
	}
}
