package SwingTutorial;

import javax.swing.*;
import java.awt.*;

public class JavaLessonTwenty extends JFrame {
	
	public static void main(String[] args) {
		
		new JavaLessonTwenty();
	}
	
	public JavaLessonTwenty () {
		this.setSize(400, 400);
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		
		Dimension dim = tk.getScreenSize();
		
		int xPos = (dim.width / 2) - (this.getWidth() / 2);
		int yPos = (dim.height / 2) - (this.getHeight() / 2);
		
		this.setLocation(xPos, yPos);
		this.setResizable(false);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setTitle("My First Frame");
		
		JPanel thePanel = new JPanel();
		JLabel label1 = new JLabel("Tell me something");
		label1.setText("New Text");
		label1.setToolTipText("Doesn't do anything");
		thePanel.add(label1);
		
		JButton button1 = new JButton("Send");
		button1.setText("New Button");
		button1.setToolTipText("It's a button");
		thePanel.add(button1);
		
		JTextField textField1 = new JTextField("Type here", 15);
		textField1.setColumns(10);
		textField1.setText("Type again");
		textField1.setToolTipText("It's a field");
		thePanel.add(textField1);
		
		JTextArea textArea1 = new JTextArea(15, 20);
		textArea1.setText("Just a whole bunch of text that is important\n");
		textArea1.setLineWrap(true);
		textArea1.setWrapStyleWord(true);
		
		int numOfLines = textArea1.getLineCount();
		
		textArea1.append("number of lines: " + numOfLines);
		
		JScrollPane scrollbar1 = new JScrollPane(textArea1, JScrollPane
				.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane
				.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		thePanel.add(scrollbar1);
		
		this.add(thePanel);
		this.setVisible(true);
		
		textField1.requestFocus();
		
	}
}
