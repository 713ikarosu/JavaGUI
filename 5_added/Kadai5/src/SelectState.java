import java.awt.Cursor;

public class SelectState extends State {
  StateManager stateManager;
  MyRectangle rect;
  int x1, y1;
  boolean flag = false;
  public static int DEFAULT_CURSOR = 0;
  public static int MOVE_CURSOR = 13;
  Cursor defCursor = new Cursor(DEFAULT_CURSOR);
  Cursor moveCursor = new Cursor(MOVE_CURSOR);

  public SelectState(StateManager stateManager) {
    this.stateManager = stateManager;
  }

  public void mouseDown(int x, int y) {
      // どの図形が選択されているかのための計算
      // 選択状態へ変更
      // -------
      // boolean flagMini = true;
      // for(MyDrawing d : stateManager.mediator.drawings){
      //   // なんかおる→false, なんもおらん→true
      //   if(d.contains(x,y)) {
      //     flagMini = false;
      //     break;
      //   }
      // }

      x1 = x;
      y1 = y;

      // drawingsでfor文回してcontainsがすべてfalseならそこにオブジェクトは存在しない
      for (MyDrawing d : stateManager.mediator.drawings){
        if(d.contains(x,y)) { // 存在
          flag = false;
          break;
        } else { // 存在しない
          flag = true;
        }
        // いなければ短径を用意
      }
      if(flag){ // 何も存在しない
        for(int i = 0;i < stateManager.mediator.selectedDrawings.size();i++){ // 全部の選択解除
        	MyDrawing e = stateManager.mediator.selectedDrawings.elementAt(0);
        	e.setSelected(false);
        	stateManager.mediator.selectedDrawings.removeElementAt(0);
        }
        rect = new MyRectangle(x,y);
        stateManager.addDrawing(rect);
      } else {
        if(stateManager.mediator.selectedDrawings.size()<=1){ // ||!d.contains(x,y)
          stateManager.mediator.setSelected(x,y);
        }
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
  public void mouseMoved(int x, int y) {
	  for(MyDrawing d : stateManager.mediator.drawings) {
			if(d.contains(x,y)){
				stateManager.mediator.canvas.setCursor(moveCursor);
				break;
			}
			stateManager.mediator.canvas.setCursor(defCursor);
		}
  }
}
