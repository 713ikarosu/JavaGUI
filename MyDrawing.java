import java.awt.*;
import javax.swing.*;

// メインウィンドウを表すクラス
// public class SimpleDrawings extends JFrame{
// 	// SimpleDrawings のコンストラクタ
// 	public SimpleDrawings() {
// 		super("My Painter");
//
// 		JPanel jp = new JPanel(new BorderLayout());
// 		getContentPane().add(jp);
//
// 		MyCanvas canvas = new MyCanvas();
// 		jp.add(BorderLayout.CENTER,canvas);
//
// 		setSize(new Dimension(360,280));
// 		setVisible(true);
// 	}
//
// 	public static void main(String[] args) {
// 		// TODO 自動生成されたメソッド・スタブ
// 		new SimpleDrawings();
// 	}
// }

public class MyDrawing {
	private int x, y, w, h; // X座標, Y座標, 幅, 高さ
	private Color lineColor, fillColor; //線の色, 塗り色
	private int lineWidth; // 線の太さ

	public MyDrawing() {
		x = y = 0;
		w = h = 40;
		lineColor = Color.black;
		fillColor = Color.white;
		lineWidth = 1;
	}

	public void draw(Graphics g) {

	}

	public void move(int dx, int dy) {
		// オブジェクトを移動する処理を書く
		this.x += dx;
		this.y += dy;
	}

	public void setLocation(int x, int y) {
		// オブジェクトの位置を変更する処理を書く
		this.x = x;
		this.y = y;
	}

	public void setSize(int w, int h) {
		// オブジェクトのサイズを変更する処理を書く
		this.w = w;
		this.h = h;
	}

	public int getX() {
		// オブジェクトの X 位置を取得する処理を書く
		return this.x;
	}

	public int getY() {
		// オブジェクトの Y 位置を取得する処理を書く
		return this.y;
	}

	public int getW() {
		// オブジェクトの幅を取得する処理を書く
		return this.w;
	}

	public int getH() {
		// オブジェクトの高さを取得する処理を書く
		return this.h;
	}

	public int getLineWidth() {
		// 線の太さ
		return this.lineWidth;
	}

	public void setLineColor(Color a) {
		// lineColor を設定
		this.lineColor = a;
	}

	public void setfillColor(Color b) {
		// fillColor を設定
		this.fillColor = b;
	}

	public Color getLineColor() {
		// lineColor を取得
		return lineColor;
	}

	public Color getFillColor() {
		// fillColor を取得
		return fillColor;
	}
}



// public class MyOval extends MyDrawing{
// 	public MyOval(int xpt, int ypt) {
// 		super();
// 		setLocation(xpt,ypt);
// 	}
//
// 	public void draw(Graphics g) {
// 		int x = getX();
// 		int y = getY();
// 		int w = getW();
// 		int h = getH();
//
// 		// 高さや横幅が負の時の為の処理
// 		if (w < 0) {
// 			x += w;
// 			w *= -1;
// 		}
// 		if (h < 0 ) {
// 			y += h;
// 			h *= -1;
// 		}
//
// 		Graphics2D g2 = (Graphics2D) g;
// 		g2.setStroke(new BasicStroke(getLineWidth()));
// 		g2.setColor(getFillCollor());
// 		g2.fillOval(x, y, w, h);
// 		g2.setColor(getLineColor());
// 		g2.drawOval(x, y, w, h);
// 	}
// }

// class MyOctagonal extends MyDrawing{
// 	public MyOctagonal(int xpt, int ypt) {
// 		super();
// 		setLocation(xpt,ypt);
// 	}


	// public void draw(Graphics g) {
	// 	int x = getX();
	// 	int y = getY();
	// 	int w = getW();
	// 	int h = getH();
	// 	int n = 8; // 角の数
	// 	int xw[] = new int[n];
	// 	int yw[] = new int[n];

// 		// 高さや横幅が負の時の為の処理
// 		if (w < 0) {
// 			x += w;
// 			w *= -1;
// 		}
// 		if (h < 0 ) {
// 			y += h;
// 			h *= -1;
// 		}
//
// 		double Del = Math.PI/2;
// 		for (int i = 0;i < n;i++) {
// 			xw[i] = (int)(r * Math.cos(2.0 * i * Math.PI / n + Del) + x);
// 			yw[i] = - (int)(r * Math.sin(2.0 * i Math.PI / n + Del)) + y;
// 		}
//
//
// 		Graphoics2D g2 = (Graphics2D) g;
// 		g2.setStroke(new BasicStroke(getLineWidth()));
// 		g2.setColor(getFillColor());
// 		g2.fillPolygon(xw,yw,n);
// 		g2.setColor(getLineColor());
// 		g2.drawPolygon(xw,yw,n);
//
// 	}
// }
