import java.awt.*;

class MyOctagonal extends MyDrawing{
	public MyOctagonal(int xpt, int ypt) {
		super();
		setLocation(xpt,ypt);
	}


	public void draw(Graphics g) {
		int x = getX();
		int y = getY();
		int w = getW();
		int h = getH();
		int n = 8; // 角の数
		int xw[] = new int[n];
		int yw[] = new int[n];

		// 高さや横幅が負の時の為の処理
		if (w < 0) {
			x += w;
			w *= -1;
		}
		if (h < 0 ) {
			y += h;
			h *= -1;
		}

		double Del = Math.PI/2;
		for (int i = 0;i < n;i++) {
			xw[i] = (int)(r * Math.cos(2.0 * i * Math.PI / n + Del) + x);
			yw[i] = - (int)(r * Math.sin(2.0 * i Math.PI / n + Del)) + y;
		}


		Graphoics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(getLineWidth()));
		g2.setColor(getFillColor());
		g2.fillPolygon(xw,yw,n);
		g2.setColor(getLineColor());
		g2.drawPolygon(xw,yw,n);

	}
}
