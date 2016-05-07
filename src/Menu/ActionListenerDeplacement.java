package Menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Autre.Jeu;

public class ActionListenerDeplacement {
	private int cpt;

	public ActionListenerDeplacement(JButton j, int i, final Jeu jeu){
		cpt=i;
		j.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jeu.Deplacement(jeu.getIle().getlistperso().get(cpt));
			}
		});
	}
}
