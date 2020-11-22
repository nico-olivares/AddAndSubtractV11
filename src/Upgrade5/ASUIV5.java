package Upgrade5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.geom.Arc2D;
import java.awt.geom.GeneralPath;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

//This is the version with the picachu animation. Is the latest as of 7/29/2015

public class ASUIV5 extends JFrame implements ActionListener, ComponentListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel panel, northPanel, southPanel, centerPanel, centerScore, centerEq;
	public static newPanel2 centerPica;
	private JLabel title, equation, ansLabel, feedback, score, spaces1, spaces2, jumpLevel, admin;
	private JButton check;
	private JTextField answer, jumpLevelInput;
	private JPasswordField adminPass;
	public static int level, scoreNum;
	public static final int passingScore = 80;
	public static final int app_Width = 800;
	public static final int app_Height = 400;
	EquationV5 theEquation;
	static int xOffset, pWidth, pHeight, pInterval;
	static Random random;
	private char[] passwordKeeper;
	
	ASUIV5() {
		pWidth = 100;
		pHeight = (int) (pWidth * 0.7);
		pInterval = 170/((passingScore/5));
		level = 0;
		random = new Random();
		passwordKeeper = new char[] {'a', 'd', 'm', 'i', 'n'};
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(app_Width, app_Height));
		panel.setLayout(new BorderLayout(1,1));
		panel.setBackground(Color.white);
		panel.addComponentListener(this);
		northPanel = new JPanel();
		northPanel.setBackground(Color.yellow);
		southPanel = new JPanel();
		southPanel.setBackground(Color.orange);
		centerPanel = new JPanel();
		centerPanel.setBackground(Color.white);
		centerPica = new newPanel2();
		
		centerScore = new JPanel();
		centerScore.setBackground(Color.gray);
		centerEq = new JPanel();
		centerEq.setBackground(Color.red);
		
		GridBagLayout grid = new GridBagLayout();
		panel.setLayout(grid);
		GridBagConstraints cTitle = new GridBagConstraints();
		cTitle.gridx = 0;	//position in the x grid (0 being the first cell or column)
		cTitle.gridy = 0;	//position in the y grid (0 being the top most row)
		cTitle.gridwidth = 4;	//how many columns or cells will the item occupy
		cTitle.gridheight = 1;	//how many rows will the item occupy
		cTitle.weightx = 100;		//size relative to other components in the same row
		cTitle.weighty = 10; 	//size relative to other components in the same column
		cTitle.fill = GridBagConstraints.BOTH;	//determines if component expands horizontally or vertically to fill its cell
		cTitle.anchor = GridBagConstraints.CENTER;	//alignment within the cell
		
		
		GridBagConstraints cPica = new GridBagConstraints();
		cPica.gridx = 0;	//position in the x grid (0 being the first cell or column)
		cPica.gridy = 1;	//position in the y grid (0 being the top most row)
		cPica.gridwidth = 3;	//how many columns or cells will the item occupy
		cPica.gridheight = 2;	//how many rows will the item occupy
		cPica.weightx = 100;		//size relative to other components in the same row
		cPica.weighty = 100; 	//size relative to other components in the same column
		cPica.fill = GridBagConstraints.BOTH;	//determines if component expands horizontally or vertically to fill its cell
		cPica.anchor = GridBagConstraints.CENTER;	//alignment within the cell
		
		
		GridBagConstraints cScore = new GridBagConstraints();
		cScore.gridx = 3;	//position in the x grid (0 being the first cell or column)
		cScore.gridy = 1;	//position in the y grid (0 being the top most row)
		cScore.gridwidth = 1;	//how many columns or cells will the item occupy
		cScore.gridheight = 2;	//how many rows will the item occupy
		cScore.weightx = 10;		//size relative to other components in the same row
		cScore.weighty = 100; 	//size relative to other components in the same column
		cScore.fill = GridBagConstraints.BOTH;	//determines if component expands horizontally or vertically to fill its cell
		cScore.anchor = GridBagConstraints.EAST;	//alignment within the cell
		
		
		GridBagConstraints cEq = new GridBagConstraints();
		cEq.gridx = 0;	//position in the x grid (0 being the first cell or column)
		cEq.gridy = 3;	//position in the y grid (0 being the top most row)
		cEq.gridwidth = 4;	//how many columns or cells will the item occupy
		cEq.gridheight = 2;	//how many rows will the item occupy
		cEq.weightx = 100;		//size relative to other components in the same row
		cEq.weighty = 100; 	//size relative to other components in the same column
		cEq.fill = GridBagConstraints.BOTH;	//determines if component expands horizontally or vertically to fill its cell
		cEq.anchor = GridBagConstraints.CENTER;	//alignment within the cell
		
		
		GridBagConstraints cBottom = new GridBagConstraints();
		cBottom.gridx = 0;	//position in the x grid (0 being the first cell or column)
		cBottom.gridy = 5;	//position in the y grid (0 being the top most row)
		cBottom.gridwidth = 4;	//how many columns or cells will the item occupy
		cBottom.gridheight = 1;	//how many rows will the item occupy
		cBottom.weightx = 100;		//size relative to other components in the same row
		cBottom.weighty = 10; 	//size relative to other components in the same column
		cBottom.fill = GridBagConstraints.BOTH;	//determines if component expands horizontally or vertically to fill its cell
		cBottom.anchor = GridBagConstraints.CENTER;	//alignment within the cell
		
		
		title = new JLabel("Addition and Subtraction Rocks!");
		title.setHorizontalAlignment(JLabel.CENTER);
		
		equation = new JLabel("equation");
		equation.setHorizontalAlignment(JLabel.CENTER);
		equation.setVerticalAlignment(JLabel.CENTER);
		equation.setFont(new Font("Comic Sans MS", Font.PLAIN, 120));
		ansLabel = new JLabel("X = ");
		feedback = new JLabel("feedback");
		score = new JLabel("Score: ");
		score.setHorizontalAlignment(JLabel.CENTER);
		score.setVerticalAlignment(JLabel.CENTER);
		spaces1 = new JLabel("               ");
		spaces2 = new JLabel("               ");
		
		check = new JButton("check");
		check.addActionListener(this);
		
		answer = new JTextField(10);
		answer.setHorizontalAlignment(JTextField.CENTER);
		answer.addActionListener(this);
		
		jumpLevel = new JLabel("Jump to level: ");
		jumpLevelInput = new JTextField(3);
		jumpLevelInput.setHorizontalAlignment(JTextField.CENTER);
		jumpLevelInput.addActionListener(this);
		admin = new JLabel("Password: ");
		adminPass = new JPasswordField(6);
		adminPass.setEchoChar('*');
		adminPass.addActionListener(this);
		
		northPanel.add(title);
		centerPanel.add(equation);
		southPanel.add(ansLabel);
		southPanel.add(answer);
		southPanel.add(check);
		southPanel.add(spaces1);
		southPanel.add(feedback);
		southPanel.add(spaces2);
		southPanel.add(jumpLevel);
		southPanel.add(jumpLevelInput);
		southPanel.add(admin);
		southPanel.add(adminPass);
		
		grid.setConstraints(northPanel,  cTitle);
		panel.add(northPanel);
		grid.setConstraints(centerPica,  cPica);
		panel.add(centerPica);
		grid.setConstraints(score,  cScore);
		panel.add(score);
		grid.setConstraints(centerPanel,  cEq);
		panel.add(centerPanel);
		grid.setConstraints(southPanel,  cBottom);
		panel.add(southPanel);
		
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
		
		resetWidth();
		level = 0;
		
		
		setUp();
	}
	
	private void setUp() {
		theEquation = new EquationV5(level);
		equation.setText(theEquation.equation());
		title.setText(theEquation.title());
		centerPica.repaint();
	}
	
	private void eval(boolean correct) {
		if(correct) {
			if(scoreNum < passingScore) {
				scoreNum = scoreNum +5;
				pWidth = pWidth+pInterval;
				pHeight = (int) (pWidth * 0.7);
				pInterval = (int) ((centerPica.getHeight()*0.9)/(passingScore/5));
				score.setText(sC(scoreNum));
				centerPica.repaint();
			} else {
				scoreNum = 0;
				score.setText(sC(scoreNum));
				level++;
				setUp();
			}
		} else {
			if(scoreNum > 0) {
				scoreNum = scoreNum -5;
				pWidth = pWidth - pInterval;
				pHeight = (int) (pWidth * 0.7);
				score.setText(sC(scoreNum));
			}
		}
	}
	
	//Score to String (sC)
	private String sC(int s) {
		return ("Score: " + s + "   ");
	}
	
	public static void resetWidth() {
		pWidth = (int)(centerPica.getHeight()*0.8);
		pHeight = (int) (pWidth * 0.7);
		pInterval = (int) ((centerPica.getHeight()*0.8)/(passingScore/5));
		xOffset = (int)(1200*0.7);
		//xOffset = (int)(centerPica.getWidth()*0.4);
		xOffset = 10 + (int)(random.nextInt(centerPica.getWidth())*0.7);
	}
	
	public static void resizePica() {
		pInterval = (int) ((centerPica.getHeight()*0.8)/(passingScore/5));
		pWidth = (int)((centerPica.getHeight()*0.8)+(pInterval*(scoreNum/5)));
		pHeight = (int) (pWidth * 0.7);
		//xOffset = (int)(centerPica.getWidth()*0.4);
		xOffset = 10 + (int)(random.nextInt(centerPica.getWidth())*0.7);
		
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
			jumpLevelInput.setText("");
			adminPass.setText("");
			setUp();
		}
		if(e.getSource() == adminPass) {
			if(Arrays.equals(adminPass.getPassword(), passwordKeeper)) {
				System.out.println("arrays are recognized as equal");
				level = Integer.parseInt(jumpLevelInput.getText())-2;
				scoreNum = passingScore;
				feedback.setText("Feedback");
				eval(true);
				answer.setText("");
				jumpLevelInput.setText("");
				adminPass.setText("");
				setUp();
			}
		}
	}

	public static void main(String[] args) {
		ASUIV5 screen = new ASUIV5();
	}

	@Override
	public void componentHidden(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentMoved(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentResized(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println("width before resizing: " + pWidth);
		if(scoreNum == 0) {
			resetWidth();
			//System.out.println("reset did get called");
		} else {
			resizePica();
		}
		//System.out.println("width after resizing: " + pWidth);
		centerPica.repaint();
	}

	@Override
	public void componentShown(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

class newPanel2 extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//int widthPane;
	//int heightPane;
	Graphics2D gr;
	
	public void paintComponent(Graphics g) {
		gr = (Graphics2D)g;
		gr.setColor(Color.white);
		gr.fillRect(0, 0, ASUIV5.centerPica.getWidth(), ASUIV5.centerPica.getHeight());
		if(ASUIV5.scoreNum == 0 && ASUIV5.level != 0) {
			explode(ASUIV5.pWidth, ASUIV5.pHeight);
		} else {
			drawPicachu(ASUIV5.pWidth, ASUIV5.pHeight);
		}
	}
	
	private void drawPicachu(int w, int h) {
		float yPointOut = (float) ((h/3)*1.02);
		float yPointHigh = (float) ((h/5)*0.8);
		float yPointIn = (float) ((h/3)*0.9);
		
		gr.setColor(Color.yellow);
		gr.fillOval((ASUIV5.xOffset+(w/4)), h/4, w/2, (int)((h/2)*0.9));
		gr.setColor(Color.blue);
		GeneralPath ear1 = new GeneralPath();
		ear1.moveTo((int)(ASUIV5.xOffset+((w/4)*1.2)), yPointOut);
		ear1.lineTo((int)(ASUIV5.xOffset+((w/4)*1.1)), yPointHigh);
		ear1.lineTo((int)(ASUIV5.xOffset+((w/4)*1.4)), yPointIn);
		ear1.closePath();
		GeneralPath ear2 = new GeneralPath();
		ear2.moveTo((int)(ASUIV5.xOffset+((w/4)*2.8)), yPointOut);
		ear2.lineTo(ASUIV5.xOffset+((w/4)*2.9), yPointHigh);
		ear2.lineTo(ASUIV5.xOffset+((w/4)*2.6), yPointIn);
		ear2.closePath();
		gr.fill(ear1);
		gr.fill(ear2);
		gr.setColor(Color.white);
		gr.fillOval((int)(ASUIV5.xOffset+((w/4)*1.3)), (int)((h/4)*1.3), (int)(w/8), (int)(h/7));
		gr.fillOval((int)(ASUIV5.xOffset+((w/4)*2.2)), (int)((h/4)*1.3), (int)(w/8), (int)(h/7));
		gr.setColor(Color.black);
		gr.fillOval((int)(ASUIV5.xOffset+((w/4)*1.55)), (int)((h/4)*1.5), (int)(w/20), (int)(h/18));
		gr.fillOval((int)(ASUIV5.xOffset+((w/4)*2.45)), (int)((h/4)*1.5), (int)(w/20), (int)(h/18));
		gr.setColor(Color.red);
		gr.fillOval((int)(ASUIV5.xOffset+(w*0.4)), (int)(h*0.57), (int)(w*0.22), (int)(h*0.04));
		gr.setColor(Color.blue);
		Arc2D.Float tongue = new Arc2D.Float((float)(ASUIV5.xOffset+(w*0.55)), (float) (h*0.56), (float)(w*0.033), (float)(h*0.062), 180f, 180f, Arc2D.CHORD);
		gr.fill(tongue);
	}
	
	private void explode(int w, int h) {
		gr.setColor(Color.white);
		gr.clearRect(0, 0, ASUIV5.centerPica.getWidth(), ASUIV5.centerPica.getHeight());
		gr.setColor(Color.yellow);
		GeneralPath cl = new GeneralPath();
		cl.moveTo(ASUIV5.xOffset+(w*0.2), (h*0.3));
		cl.curveTo(ASUIV5.xOffset+(w*0.2), (h*0.2), ASUIV5.xOffset+(w*0.4), (h*0.1), ASUIV5.xOffset+(w*0.4), (h*0.27));
		cl.curveTo(ASUIV5.xOffset+(w*0.45), (h*0.1) , ASUIV5.xOffset+(w*0.6), (h*0.1), ASUIV5.xOffset+(w*0.6), (h*0.3));
		cl.curveTo(ASUIV5.xOffset+(w*0.7), (h*0.12), ASUIV5.xOffset+(w*0.9), (h*0.4), ASUIV5.xOffset+(w*0.8), (h*0.5));
		cl.curveTo(ASUIV5.xOffset+(w*0.9), (h*0.5), ASUIV5.xOffset+(w*0.8), (h*0.8), ASUIV5.xOffset+(w*0.7), (h*0.7));
		cl.curveTo(ASUIV5.xOffset+(w*0.75), (h*0.9), ASUIV5.xOffset+(w*0.4), (h*1), ASUIV5.xOffset+(w*0.4), (h*0.7));
		cl.curveTo(ASUIV5.xOffset+(w*0.38), (h*0.9), ASUIV5.xOffset+(w*0.1), (h*0.6), ASUIV5.xOffset+(w*0.2), (h*0.55));
		cl.curveTo(ASUIV5.xOffset+(w*0.1), (h*0.5), ASUIV5.xOffset+(w*0.18), (h*0.25), ASUIV5.xOffset+(w*0.2), (h*0.3));
				
		cl.closePath();
		gr.fill(cl);
		
		gr.setColor(Color.black);
		gr.setFont(new Font("Comic Sans MS", Font.PLAIN, (int)(ASUIV5.pWidth*0.1)));
		gr.drawString("BOOM!", (int)(ASUIV5.xOffset+(w*0.3)), (int)(h*0.6));
		
		ASUIV5.resetWidth();
	}
	
}




