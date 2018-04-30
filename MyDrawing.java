import java.awt.*;
import javax.swing.*;

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
