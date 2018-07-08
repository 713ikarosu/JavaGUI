public class SelectState extends State {
  StateManager stateManager;
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
  }
  public void mouseUp(int x, int y) {}
  public void mouseDrag(int x, int y) {
    int dx = x - x1;
    int dy = y - y1;
    stateManager.mediator.selectedDrawing.move(dx,dy);
    x1 = x;
    y1 = y;
    // stateManager.mediator.repaint();
    stateManager.mediator.selectedDrawing.setRegion();
  }
}
