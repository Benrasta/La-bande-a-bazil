package Menu;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class FirstPanel extends JPanel{

	private JPanel p1;
	private JPanel p2;
	private SpinnerNumberModel model1;
	private SpinnerNumberModel model2;
	private JSpinner dimension;
	private JSpinner obstacles;
	
	public FirstPanel(){
		super();
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		p1 =new JPanel();
		p2 =new JPanel();
		p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));
		p2.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS));
		model1 = new SpinnerNumberModel(10, 7, 50, 1); 
		model2 = new SpinnerNumberModel(30, 10, 50, 5); 
		dimension= new JSpinner(model1);
		obstacles= new JSpinner(model2);
        dimension.setPreferredSize(new Dimension (100,20));
        obstacles.setPreferredSize(new Dimension (100,20));
		p1.add(new JLabel("Taille du plateau:"));
		p1.add(dimension);
		p2.add(new JLabel("Pourcentage de rocher:"));
		p2.add(obstacles);
		add(p1);
		add(p2);
	}

	public int getdimension(){
		return (int) dimension.getValue();
	}

	public int getobstacles(){
		return (int) obstacles.getValue();
	}
}
