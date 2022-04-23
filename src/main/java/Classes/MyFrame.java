package Classes;

import java.awt.*;

import javax.swing.*;

public class MyFrame extends JFrame
{

	public MyFrame(String frameName, Game g)
	{
		super(frameName);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
			pack();
	
		MyPanel p = new MyPanel(g);
			Insets frameInsets = getInsets();

		int frameWidth = p.getWidth()
			+ (frameInsets.left + frameInsets.right);
		int frameHeight = p.getHeight()
			+ (frameInsets.top + frameInsets.bottom);

		setPreferredSize(new Dimension(frameWidth, frameHeight));
		
		setLayout(null);
		add(p);
		pack();		
		setVisible(true);
	}
	
}