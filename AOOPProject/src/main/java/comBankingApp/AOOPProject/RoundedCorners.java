package comBankingApp.AOOPProject;

import java.awt.*;
import javax.swing.*;

public class RoundedCorners extends JPanel {

	private Color backgroundcolor;
	private int cornerRadius = 15;
	
	public RoundedCorners(LayoutManager layout, int radius) {
		super(layout);
		cornerRadius = radius;
	}
	
	public RoundedCorners(LayoutManager layout, int radius, Color bgColor) {
		super(layout);
		cornerRadius = radius;
		backgroundcolor = bgColor;
	}
	
	public RoundedCorners(int radius) {
		super();
		cornerRadius = radius;
	}
	
	public RoundedCorners(int radius, Color bgColor) {
		super();
		cornerRadius = radius;
		backgroundcolor = bgColor;
	}
	
	protected void paintComponent(Graphics graphics) {
		super.paintComponents(graphics);
		Dimension dimension = new Dimension(cornerRadius, cornerRadius);
		int width = getWidth();
		int height = getHeight();
		Graphics2D graphics2d = (Graphics2D) graphics;
		graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		//draws the rounded panel with borders
		if(backgroundcolor != null) {
			graphics2d.setColor(backgroundcolor);
		}
		else {
			graphics2d.setColor(getBackground());
		}
		graphics2d.fillRoundRect(0, 0, width-1, height-1, dimension.width, dimension.height);
		graphics2d.setColor(getForeground());
	}
}