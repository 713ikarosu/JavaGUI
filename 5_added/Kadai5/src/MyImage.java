import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MyImage extends MyDrawing {
	File file;
	Image image;

	public MyImage(File file, int xpt, int ypt, int wpt, int hpt) {
		super();
		this.file = file;
		setLocation(xpt,ypt);
		setSize(wpt,hpt);
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
		} if (h < 0 ) {
			y += h;
			h *= -1;
		}

		Graphics2D g2 = (Graphics2D) g;

		try {
			BufferedImage image = ImageIO.read(file);
//			g2.drawImage(image, null,10,10);
			g2.drawImage(image, x, y, w, h, null);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
