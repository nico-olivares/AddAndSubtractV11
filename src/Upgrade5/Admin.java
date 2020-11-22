package Upgrade5;

import java.awt.CardLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Admin extends ASUIV5 implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JFrame frame;
	JPanel teacherStudent, adminOptions, adminPass, roster, feedback;
	CardLayout card;
	JTabbedPane tabs;
	ASUIV5 problems;
	JButton teacherButton, studentButton, addStudent, removeChecked;

	Admin() {
		frame = new JFrame("Addition and Subtraction Rocks!");
		frame.setBounds(50, 50, ASUIV5.app_Width, ASUIV5.app_Height);
		
		//problems = new ASUIV5();
		
		card = new CardLayout();
		tabs = new JTabbedPane();
		teacherStudent = new JPanel();
		adminPass = new JPanel();
		adminOptions = new JPanel();
		roster = new JPanel();
		feedback = new JPanel();
		
		tabs.add("Class Roster", roster);
		tabs.add("Group Report", feedback);
		
		adminOptions.add(tabs);
		
		teacherStudent.setLayout(card);
		teacherStudent.add(adminPass, "Entry Page");
		//teacherStudent.add(problems, "Equations");
		teacherStudent.add(adminOptions, "Administrator");
		
		
		
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
	
	public static void main(String[] s) {
		Admin ad = new Admin();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		card.show(teacherStudent, "Entry Page");
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
}
