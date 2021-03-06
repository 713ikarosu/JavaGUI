import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

class My3DRect extends MyDrawing {
  public My3DRect(int xpt, int ypt, int wpt, int hpt) {
		super();
		setLocation(xpt,ypt);
		setSize(wpt,hpt); // 大きさを指定
		figId = 2;
    // setLineColor(lcolor); // 線の色を指定
    // setfillColor(fcolor); // 塗りつぶしの色を指定
	}

  public void draw(Graphics g) {
    super.draw(g);

		int x = getX();
		int y = getY();
		int w = getW();
		int h = getH();

		// 高さや横幅が負の時の為の処理
		if (w < 0) {
			x += w;
			w *= -1;
		} if (h < 0) {
			y += h;
			h *= -1;
		}

		Graphics2D g2 = (Graphics2D) g;
    if(getShadow()){
      int x2 = x+10;
			int y2 = y+10;
      g2.setStroke(new BasicStroke(getLineWidth()));
  		g2.setColor(Color.black);
  		g2.fill3DRect(x2, y2, w, h, true);
  		g2.setColor(Color.black);
  		g2.draw3DRect(x2, y2, w, h, true);
    }
		g2.setStroke(new BasicStroke(getLineWidth()));
		g2.setColor(getFillColor());
		g2.fill3DRect(x, y, w, h, true);
		g2.setColor(getLineColor());
		g2.draw3DRect(x, y, w, h, true);
	}
}
