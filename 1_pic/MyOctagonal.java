import java.awt.*;

class MyOctagonal extends MyDrawing{
	public MyOctagonal(int xpt, int ypt, int len, Color lcolor, Color fcolor) {
		super();
		setLocation(xpt,ypt);
		setLen(len);
		setLineColor(lcolor); // 線の色を指定
    setfillColor(fcolor); // 塗りつぶしの色を指定
	}

	public void draw(Graphics g) {
		int x = getX(); // 中央座標として利用
		int y = getY();
		int len = getLen(); // 多角形の外接円の半径
		int n = 8; // 角の数
		int xw[] = new int[n];
		int yw[] = new int[n];

		// 負の時の為の処理
		if (len < 0) {
			len *= -1;
		}

		// double rad = 360/n;
		// for (int i = 0;i < n;i++) {
		// 	xw[i] = x + (int)(len*Math.cos((i+1)*rad));
		// 	yw[i] = y + (int)(len*Math.sin((i+1)*rad));
		// 	System.out.println("(x,y)"+xw[i]+" "+yw[i]);
		// }
		for (int i = 0;i < n;i++){
			xw[i] = x + (int)(len*Math.cos(i*2*Math.PI/n - n/2));
			yw[i] = y + (int)(len*Math.sin(i*2*Math.PI/n - n/2));
		}

		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(getLineWidth()));
		g2.setColor(getFillColor());
		g2.fillPolygon(xw,yw,n);
		g2.setColor(getLineColor());
		g2.drawPolygon(xw,yw,n);
	}
}
