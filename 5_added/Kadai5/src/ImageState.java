import java.io.File;

public class ImageState extends State {
	StateManager stateManager;
	MyImage image;
	File file;
	int x1, y1;

	public ImageState(StateManager stateManager, File file) {
		this.stateManager = stateManager;
		this.file = file;
	}

	public void mouseDown(int x, int y) {
		image = new MyImage(file, x, y, 0,0);
		image.isShadow = stateManager.shadowState;
		stateManager.addDrawing(image);
		x1 = x;
		y1 = y;
	}

	public void mouseUp(int x, int y) {
		stateManager.setState(new SelectState(stateManager));
	}

	public void mouseDrag(int x, int y) {
		int w = x - x1;
		int h = y - y1;
		image.setSize(w, h);
		image.setRegion();
	}
}
