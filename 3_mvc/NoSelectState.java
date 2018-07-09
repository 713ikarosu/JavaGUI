public class NoSelectState extends State {
  StateManager stateManager;
  int x1, y1;

  public NoSelectState(StateManager stateManager) {
    this.stateManager = stateManager;
  }

  public void mouseDown(int x, int y) {
      // どの図形が選択されているかのための計算
      stateManager.mediator.setSelected(x,y);
      // 選択状態へ変更
  }
  public void mouseUp(int x, int y) {}
  public void mouseDrag(int x, int y) {}
}
