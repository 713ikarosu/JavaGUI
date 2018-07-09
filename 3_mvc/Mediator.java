import java.util.Enumeration;
import java.util.Vector;
import java.awt.*;
import javax.swing.*;

public class Mediator implements Cloneable{
  Vector<MyDrawing> drawings;
  MyCanvas canvas;
  MyDrawing selectedDrawing = null;
  MyDrawing buffer = null; // Cut,Copyバッファ

  public Mediator(MyCanvas canvas) {
    this.canvas = canvas;
    drawings = new Vector<MyDrawing>();
  }

  public void clearBuffer(){
    buffer = null;
  }

  public void copy(){
    // バッファをクリア
    clearBuffer();
    buffer = selectedDrawing.clone();
  }

  public void cut(){
    // バッファをクリア
    clearBuffer();
    buffer = selectedDrawing.clone();
    removeDrawing(selectedDrawing); // drawings からselectedDrawing を削除
    repaint();
  }

  public void paste(int x, int y ){
    MyDrawing clone = (MyDrawing)buffer.clone();
    clone.setLocation(x,y);
    addDrawing(clone);
    repaint();
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

    Enumeration<MyDrawing> e = drawingsElements();
    while(e.hasMoreElements()){
      MyDrawing drawing = e.nextElement();
      if (drawing.contains(x,y)){
        setSelectedDrawing(drawing); //drawingを選択された MyDrawing として設定
        drawing.setSelected(true);
        // ---- 選ばれたもの以外を非選択状態へ
        Enumeration<MyDrawing> e1 = drawingsElements();
        while(e1.hasMoreElements()){
          MyDrawing drawing1 = e1.nextElement();
          if(drawing1.equals(drawing)){
            continue;
          }
          drawing1.setSelected(false);
        }
        repaint();
      } else {
        drawing.setSelected(false);
        repaint();
      }
    }
    // 結果として，１番後に追加された drawing が selected
  }

  public void setSelectedDrawing(MyDrawing d){
    this.selectedDrawing = d;
    // d.setSelected(true);
  }

  public void setColor(Color color){
    if(selectedDrawing != null){
      selectedDrawing.setLineColor(color);
      repaint();
    }
  }

  public void setfColor(Color color){
    if(selectedDrawing != null){
      selectedDrawing.setfillColor(color);
      repaint();
    }
  }

  public void setLWidth(int width){
    if(selectedDrawing != null){
      selectedDrawing.setLineWidth(width);
      repaint();
    }
  }
}
