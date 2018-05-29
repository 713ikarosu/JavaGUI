public class OctaState extends State {
  StateManager stateManager;
  MyOctagonal octa;
  int x1, y1;

  public OctaState(StateManager stateManager){
    this.stateManager = stateManager;
  }

  public void mouseDown(int x,int y){
    octa = new MyOctagonal(x,y,0); // 戦略2-1: 外接半径０のインスタンス生成
    stateManager.addDrawing(octa);
    x1 = x;
    y1 = y;
  }

  public void mouseUp(int x,int y){}
  public void mouseDrag(int x,int y){
    int w = x - x1;
    int h = y - y1;
    double len = Math.sqrt(w*w + h*h);
    octa.setLen((int)len);
  }
}
