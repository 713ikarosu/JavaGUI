public class StateManager implements State{
  MyCanvas canvas;
  public void StateManager(MyCanvas canvas){
    this.canvas = canvas;
  }
  // マウスが押されたとき
  public void mouseDown(int x,int y){}
  // マウスが離されたとき
  public void mouseUp(int x,int y){}
  // マウスがドラッグされたとき
  public void mouseDrag(int x,int y){}
  public void setState(State state){}
  // public void addDrawing()
}
