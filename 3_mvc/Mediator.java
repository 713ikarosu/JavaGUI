import java.util.Enumeration;
import java.util.Vector;

public class Mediator {
  Vector<MyDrawing> drawings;
  MyCanvas canvas;
  MyDrawing selectedDrawing = null;

  public Mediator(MyCanvas canvas) {
    this.canvas = canvas;
    drawings = new Vector<MyDrawing>();
  }

  public Enumeration<MyDrawing> drawingsElements() {
    return drawings.elements();
  }

  public void addDrawing(MyDrawing d) {
    drawings.add(d);
    setSelectedDrawing(d);
  }

  public void removeDrawing(MyDrawing d) {
    drawings.remove(d);
  }

  public MyDrawing getSelectedDrawing() {
    return selectedDrawing;
  }

  public void move(int dx, int dy) {
    if (selectedDrawing != null) {
      selectedDrawing.move(dx,dy);
    }
  }

  public void repaint() {
    canvas.repaint();
  }

  public void setSelected(int x, int y) {
    // setSelected(int x, int y)メソッドは、点(x, y)にある図形を選択状態にするためのものです。 drawingsに図形を追加する順番と表示される順番を考慮して、点(x, y)を含む図形が複数ある場合は一番手前にある図形を選択状態にできるように注意して実装する必要があるでしょう。
    // 一番手前→より後に追加された方
    // Vector 格納されている図形のうち，contains(x,y)→true となり，なおかつその中で一番後に Vector に格納されたものを selectDrawing へ格納

    Enumeration<MyDrawing> e = drawings.elements();
    while(e.hasMoreElements()){
      MyDrawing drawing = e.nextElement(); 
      if (drawing.contains(x,y)){
        setSelectedDrawing(drawing);
      }
    }
    // 結果として，１番後に追加された drawing が selected される
  }

  public void setSelectedDrawing(MyDrawing d){
    this.selectedDrawing = d;
  }
}
