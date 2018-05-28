public class StateManager extends State{
  MyCanvas canvas;
  State state;
  public StateManager(MyCanvas canvas){
    this.canvas = canvas;
    setState(new RectState(this.state));
  }
  public void setState(State state){
    this.state = state;
  }
  public void mouseDown(int x,int y){
    this.state.mouseDown(x,y);
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
