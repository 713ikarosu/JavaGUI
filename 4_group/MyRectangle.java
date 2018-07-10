import java.awt.*;

public class MyRectangle extends MyDrawing {
	public MyRectangle(int xpt, int ypt) {
		super();
		setLocation(xpt,ypt);
	}

	public void draw(Graphics g) {
		int x = getX();
		int y = getY();
		int w = getW();
		int h = getH();

		// 高さや横幅が負のときの処理
		if (w < 0) {
			x += w;
			w *= -1;
		} if (h  < 0) {
			y += h;
			h *= -1;
		}

		Graphics2D g2 = (Graphics2D) g;

		// 破線か否かでストロークを変更
		// if (getDashed()){
		// 	g2.setStroke(new MyDashStroke(getLineWidth()));
		// } else {
		// 	g2.setStroke(new BasicStroke(getLineWidth()));
		// }

		// g2.setStroke(new BasicStroke(getLineWidth()));
		g2.setStroke(new MyDashStroke(getLineWidth()));

		g2.setColor(getFillColor());
		g2.fillRect(x,y,w,h);
		g2.setColor(getLineColor());
		g2.drawRect(x,y,w,h);
	}
}
