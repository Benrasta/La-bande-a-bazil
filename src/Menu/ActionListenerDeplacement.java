package Menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Autre.Jeu;
import Ile.Ile;

public class ActionListenerDeplacement {

	public ActionListenerDeplacement(JButton j, int i, Ile ile, Jeu jeu ){
		j.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jeu.Deplacement(ile.getlistperso().get(i), ile);
			}
		});
	}
}
