public class Rect3DState extends State {
  StateManager stateManager;
  My3DRect rect3d;
  int x1, y1;

  public Rect3DState(StateManager stateManager){
    this.stateManager = stateManager;
  }

  public void mouseDown(int x,int y){
    rect3d = new My3DRect(x,y,0,0);
    rect3d.isShadow = stateManager.shadowState; // isShadow 更新
    stateManager.addDrawing(rect3d);
    x1 = x;
    y1 = y;
  }

  public void mouseUp(int x,int y){}
  public void mouseDrag(int x,int y){
    int w = x - x1;
    int h = y - y1;
    rect3d.setSize(w,h);
    rect3d.setRegion();
  }
}
