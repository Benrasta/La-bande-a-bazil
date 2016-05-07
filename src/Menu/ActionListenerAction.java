package Menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Autre.Jeu;

public class ActionListenerAction {

	private int cpt;
	
	public ActionListenerAction(JButton j, int i, final Jeu jeu ){
		cpt=i;
		j.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jeu.Action(jeu.getIle().getlistperso().get(cpt));
			}
		});
	}
}
