public class OvalState extends State {
  StateManager stateManager;
  MyOval oval;
  int x1, y1;

  public OvalState(StateManager stateManager){
    this.stateManager = stateManager;
  }

  public void mouseDown(int x,int y){

    oval = new MyOval(x,y,0,0); // 戦略2-1:幅，高さ０のインスタンス生成
    oval.isShadow = stateManager.shadowState; // isShadow 更新
    stateManager.addDrawing(oval);
    x1 = x;
    y1 = y;
  }

  public void mouseUp(int x,int y){}

  public void mouseDrag(int x,int y){
    int w = x - x1;
    int h = y - y1;
    oval.setSize(w,h);
    oval.setRegion();
  }
}
