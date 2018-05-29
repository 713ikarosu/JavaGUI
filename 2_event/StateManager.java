public class StateManager extends State{
  MyCanvas canvas;
  State state;
  boolean shadowState; // ドロップシャドウの状態を保持
  int x, y;

  public StateManager(MyCanvas canvas){
    this.canvas = canvas;
    setState(new OvalState(this));
    setShadowState(false);
  }
  public void setState(State state){
    this.state = state;
  }
  public void setShadowState(boolean state) {
    shadowState = state;
  }
  public boolean getShadowState(){
    return shadowState;
  }
  public void mouseDown(int x,int y){
    state.mouseDown(x,y);
  }
  public void mouseUp(int x,int y){
    state.mouseUp(x,y);

  }
  public void mouseDrag(int x,int y){
    state.mouseDrag(x,y);
  }
  public void addDrawing(MyDrawing d) {
    canvas.addDrawing(d);
  }
}
