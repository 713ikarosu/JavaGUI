import java.util.Enumeration;

public class SelectState extends State {
  StateManager stateManager;
  MyRectangle rect;
  int x1, y1;
  boolean flag = false;

  public SelectState(StateManager stateManager) {
    this.stateManager = stateManager;
  }

  public void mouseDown(int x, int y) {
      // どの図形が選択されているかのための計算
      // 選択状態へ変更
      stateManager.mediator.setSelected(x,y);
      x1 = x;
      y1 = y;

      // drawingsでfor文回してcontainsがすべてfalseならそこにオブジェクトは存在しない
      for (MyDrawing d : stateManager.mediator.drawings){
        if(d.contains(x,y)) {
          flag = false;
          break;
        } else {
          flag = true;
        }
        // いなければ短径を用意
        // flag = true;
      }
      if(flag){
        rect = new MyRectangle(x,y);
        stateManager.addDrawing(rect);
      }
  }
  public void mouseUp(int x, int y) {
    if(flag){
      for (MyDrawing d : stateManager.mediator.drawings){
        if(rect.getX()<d.getX()&&d.getX()+d.getW()<rect.getX()+rect.getW()){
          if(rect.getY()<d.getY()&&d.getY()+d.getH()<rect.getY()+rect.getH()){
            stateManager.mediator.setSelectedDrawings(d);
            d.setSelected(true);
          }
        }
      }
      stateManager.mediator.removeDrawing(rect);
      stateManager.mediator.repaint();
      flag = false;
    }
  }
  public void mouseDrag(int x, int y) {
      // int dx = x - x1;
      // int dy = y - y1;
      // for (MyDrawing d : stateManager.mediator.selectedDrawings){
      //   d.move(dx,dy);
      // }
      // x1 = x;
      // y1 = y;
      // // stateManager.mediator.repaint();
      // for (MyDrawing d : stateManager.mediator.selectedDrawings){
      //   d.setRegion();
      // }

      if(flag){
        int w = x - x1;
        int h = y - y1;
        rect.setSize(w,h);
        rect.setRegion();
      } else {
        int dx = x - x1;
        int dy = y - y1;
        // for (MyDrawing d : stateManager.mediator.selectedDrawings){
        //   d.move(dx,dy);
        // }
        stateManager.mediator.move(dx,dy);
        x1 = x;
        y1 = y;
        // stateManager.mediator.repaint();
        for (MyDrawing d : stateManager.mediator.selectedDrawings){
          d.setRegion();
        }
      }
      // stateManager.mediator.selectedDrawings.setRegion();
  }
}
