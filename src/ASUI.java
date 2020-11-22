import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ASUI extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel panel, northPanel, southPanel;
	private JLabel title, equation, ansLabel, feedback, score, spaces1;
	private JButton check;
	private JTextField answer;
	private int level, scoreNum;
	private final int passingScore = 15;
	Equation theEquation;
	
	ASUI() {
		level = 0;
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(800, 400));
		panel.setLayout(new BorderLayout(1,1));
		panel.setBackground(Color.white);
		northPanel = new JPanel();
		northPanel.setBackground(Color.yellow);
		southPanel = new JPanel();
		southPanel.setBackground(Color.orange);
		
		title = new JLabel("Addition and Subtraction Rocks!");
		title.setHorizontalAlignment(JLabel.CENTER);
		
		equation = new JLabel("equation");
		equation.setHorizontalAlignment(JLabel.CENTER);
		equation.setVerticalAlignment(JLabel.CENTER);
		equation.setFont(new Font("Comic Sans MS", Font.PLAIN, 120));
		ansLabel = new JLabel("X = ");
		feedback = new JLabel("feedback");
		score = new JLabel("Score: ");
		score.setHorizontalAlignment(JLabel.LEFT);
		score.setVerticalAlignment(JLabel.TOP);
		spaces1 = new JLabel("               ");
		
		check = new JButton("check");
		check.addActionListener(this);
		
		answer = new JTextField(10);
		answer.setHorizontalAlignment(JTextField.CENTER);
		answer.addActionListener(this);
		
		panel.add(equation,  BorderLayout.CENTER);
		northPanel.add(title);
		panel.add(northPanel, BorderLayout.NORTH);
		panel.add(score, BorderLayout.EAST);
		southPanel.add(ansLabel);
		southPanel.add(answer);
		southPanel.add(check);
		southPanel.add(spaces1);
		southPanel.add(feedback);
		panel.add(southPanel,  BorderLayout.SOUTH);
		
		getContentPane().add(panel);
		setTitle("Additon and Subtraction Rocks!");
		WindowListener l = new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		};
		addWindowListener(l);
		pack();
		setVisible(true);
		
		setUp();
	}
	
	private void setUp() {
		theEquation = new Equation(level);
		equation.setText(theEquation.equation());
	}
	
	private void eval(boolean correct) {
		if(level == 0) {
			title.setText(theEquation.title());
		}
		if(correct) {
			if(scoreNum < passingScore) {
				scoreNum = scoreNum +5;
				score.setText(sC(scoreNum));
			} else {
				scoreNum = 0;
				score.setText(sC(scoreNum));
				level++;
				title.setText(theEquation.title());
			}
		} else {
			if(scoreNum > 0) {
				scoreNum = scoreNum -5;
				score.setText(sC(scoreNum));
			}
		}
	}
	
	//Score to String (sC)
	private String sC(int s) {
		return ("" + s + "   ");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == answer || e.getSource() == check) {
			if(theEquation.feedback(Integer.parseInt(answer.getText()))) {
				feedback.setText("correct!");
				eval(true);
			} else {
				feedback.setText("incorrect");
				eval(false);
			}
			answer.setText("");
			setUp();
		}
	}

	public static void main(String[] args) {
		ASUI screen = new ASUI();
	}
}
