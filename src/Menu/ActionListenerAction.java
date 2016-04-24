package Menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Autre.Jeu;
import Ile.Ile;

public class ActionListenerAction {

	public ActionListenerAction(JButton j, int i, Ile ile, Jeu jeu ){
		j.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jeu.Action(ile.getlistperso().get(i), ile);
			}
		});
	}
}
