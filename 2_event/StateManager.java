public class StateManager extends State{
  MyCanvas canvas;
  State state;
  int x, y;
  public StateManager(MyCanvas canvas){
    this.canvas = canvas;
    setState(new OvalState(this));
  }
  public void setState(State state){
    this.state = state;
  }
  public void mouseDown(int x,int y){
    state.mouseDown(x,y);
    canvas.repaint();
  }
  public void mouseUp(int x,int y){
    state.mouseUp(x,y);
  }
  public void mouseDrag(int x,int y){
    state.mouseDrag(x,y);
    canvas.repaint(); // 戦略2のため変更
  }

  public void addDrawing(MyDrawing d) {
    canvas.addDrawing(d);
  }
}
