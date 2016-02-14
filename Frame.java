import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/* Takes care of the frames (GUI).
 * @author : Azmain Amin
 * 
 */

@SuppressWarnings("serial")
public class Frame extends JFrame {
	
	static JTextField inputNames;
	static JTextArea showTeams;
	static JRadioButton rb_wudc;
	static JRadioButton rb_wsdc;
	static JFrame f;
	
	public Frame(Dimension size, String name){
		
		f = new JFrame(name);
		int panelWidth = (int)size.getWidth()/2;
		int panelHeight = (int)size.getHeight()/2;
		Dimension panelSize = new Dimension(panelWidth, panelHeight);
		f.setSize(size);
		f.setLayout(new BorderLayout());
		
		
		//Panels
		JPanel upperPanel = new JPanel(new BorderLayout());
		JPanel lowerPanel = new JPanel(new BorderLayout());
		JPanel buttonPanel = new JPanel();
		
		upperPanel.setPreferredSize(panelSize);

		lowerPanel.setPreferredSize(panelSize);


	// INPUT
		buttonPanel.setBackground(Color.DARK_GRAY);
		buttonPanel.setPreferredSize(new Dimension(panelWidth/2, panelHeight/4));
		rb_wudc = new JRadioButton("WUDC", false);
		rb_wsdc = new JRadioButton("WSDC", false);
		
		// To enforce selection of one button.
		ButtonGroup bg = new ButtonGroup();
		bg.add(rb_wsdc);
		bg.add(rb_wudc);
	    
		// Add buttons to panel		
		buttonPanel.add(rb_wsdc);
		buttonPanel.add(rb_wudc);

		//TextBox-Input names
		JPanel inputPanel = new JPanel();
		inputPanel.setBackground(Color.DARK_GRAY);
		
		inputNames = new JTextField("Add debaters' names, separated by a comma.");
		inputNames.setPreferredSize(new Dimension(600, 30));
		inputPanel.add(inputNames);
		
		//Make text disappear when you click on it.
		inputNames.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				inputNames.setText("");
			}
		});
		
		//Button
		JButton b = new JButton("Make Teams!");
		b.setPreferredSize(new Dimension(200,40));
		b.setVisible(true);
		inputPanel.add(b);
		b.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				MakeTeams.displayTeams();
			}
		});
		//Adding Panels to Upper Panels.
		upperPanel.add(BorderLayout.NORTH,buttonPanel);
		upperPanel.add(BorderLayout.CENTER, inputPanel);


	//OUTPUT: To Display Teams
		showTeams = new JTextArea();
		showTeams.setPreferredSize(new Dimension(400,300));
		Font font = new Font("Verdana",10, 20);
		showTeams.setFont(font);
		lowerPanel.add(showTeams);
	
		//Adding panels to frame.
		f.add(BorderLayout.NORTH,upperPanel);
		f.add(BorderLayout.CENTER,lowerPanel);
		
		try{
		ImageIcon icon = new ImageIcon("C:\\Eclipse Workspace\\SimpleDebateTab\\src\\debate.jpg");
		f.setIconImage(icon.getImage());
		}
		catch (Exception e){
			System.out.println("Image file not found.");
			
		}
		
		f.setVisible(true);	
		
	}
}
