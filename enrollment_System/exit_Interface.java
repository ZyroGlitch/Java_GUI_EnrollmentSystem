package enrollment_System;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

public interface exit_Interface {

	
	static void exitProgram(Component exit) {
		exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exit.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				exit.setForeground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				int x = JOptionPane.showConfirmDialog(null,"You want to close the program?", "EXIT", JOptionPane.YES_NO_OPTION);
				if(x == 0) {
					System.exit(0);
				}
			}
		});
		
	}
	
	
	static void exitWithForeGround(Component exit) {
		exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exit.setForeground(Color.BLACK);
				exit.setBackground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				exit.setForeground(Color.WHITE);
				exit.setBackground(Color.DARK_GRAY);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				int x = JOptionPane.showConfirmDialog(null,"You want to close the program?", "EXIT", JOptionPane.YES_NO_OPTION);
				if(x == 0) {
					System.exit(0);
				}
			}
		});
		
		
	}
	
	
	static void exitAdmin(Component exit) {
		exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exit.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				exit.setForeground(Color.BLACK);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				int x = JOptionPane.showConfirmDialog(null,"You want to close the program?", "EXIT", JOptionPane.YES_NO_OPTION);
				if(x == 0) {
					System.exit(0);
				}
			}
		});
		
		
	}
}
