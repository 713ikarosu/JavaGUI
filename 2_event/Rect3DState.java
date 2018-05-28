public class Rect3DState extends State {
  StateManager stateManager;

  public Rect3DState(StateManager stateManager){
    this.stateManager = stateManager;
  }

  public void mouseDown(int x,int y){
    stateManager.addDrawing(new My3DRect(x,y));
  }

  public void mouseUp(int x,int y){}
  public void mouseDrag(int x,int y){}
}
