import java.util.Enumeration;

public class SelectState extends State {
  StateManager stateManager;
  MyRectangle rect;
  int x1, y1, x2, y2;
  boolean flag = false;

  public SelectState(StateManager stateManager) {
    this.stateManager = stateManager;
  }

  public void mouseDown(int x, int y) {
      // どの図形が選択されているかのための計算
      // 選択状態へ変更
      Enumeration<MyDrawing> e =   stateManager.mediator.drawingsElements();
      while(e.hasMoreElements()){
        MyDrawing drawing = e.nextElement();
        if(drawing.contains(x,y)){
          stateManager.mediator.setSelected(x,y);
          x1 = x;
          y1 = y;
          break;
        }
      } // 全部falseで出る(クリック位置に何も図形がない)
      flag = true;
      rect = new MyRectangle(x,y);
      x2 = x;
      y2 = y;
  }
  public void mouseUp(int x, int y) {}
  public void mouseDrag(int x, int y) {
    if (flag == false){
      int dx = x - x1;
      int dy = y - y1;
      stateManager.mediator.selectedDrawings.move(dx,dy);
      x1 = x;
      y1 = y;
      // stateManager.mediator.repaint();
      stateManager.mediator.selectedDrawings.setRegion();
    } else { // flag == true
      int w = x - x2;
      int h = y - y2;
      rect.setSize(w,h);
    }
  }
}
