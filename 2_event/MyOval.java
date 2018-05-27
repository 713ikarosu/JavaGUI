import java.awt.*;

public class MyOval extends MyDrawing{
	public MyOval(int xpt, int ypt, int wpt, int hpt, Color lcolor, Color fcolor) {
		super();
		setLocation(xpt,ypt);
		setSize(wpt,hpt);
		setLineColor(lcolor); // 線の色を指定
    setfillColor(fcolor); // 塗りつぶしの色を指定
	}

	public void draw(Graphics g) {
		int x = getX();
		int y = getY();
		int w = getW();
		int h = getH();

		// 高さや横幅が負の時の為の処理
		if (w < 0) {
			x += w;
			w *= -1;
		} if (h < 0 ) {
			y += h;
			h *= -1;
		}

		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(getLineWidth()));
		g2.setColor(getFillColor());
		g2.fillOval(x, y, w, h);
		g2.setColor(getLineColor());
		g2.drawOval(x, y, w, h);
	}
}
