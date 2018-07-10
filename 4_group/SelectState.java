import java.util.Enumeration;

public class SelectState extends State {
  StateManager stateManager;
  MyRectangle rect;
  int x1, y1;

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
      // いなければ以下で短径を用意
      rect = new MyRectangle(x,y);
  }
  public void mouseUp(int x, int y) {}
  public void mouseDrag(int x, int y) {
      int dx = x - x1;
      int dy = y - y1;
      for (MyDrawing d : stateManager.mediator.selectedDrawings){
        d.move(dx,dy);
      }
      x1 = x;
      y1 = y;
      // stateManager.mediator.repaint();
      for (MyDrawing d : stateManager.mediator.selectedDrawings){
        d.setRegion();
      }
      // stateManager.mediator.selectedDrawings.setRegion();
  }
}
