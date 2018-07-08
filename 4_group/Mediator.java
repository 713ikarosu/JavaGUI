import java.util.Enumeration;
import java.util.Vector;
import java.awt.*;
import javax.swing.*;

public class Mediator implements Cloneable{
  Vector<MyDrawing> drawings;
  MyCanvas canvas;
  // Vector<MyDrawing> selectDrawings = new Vector<MyDrawing>();
  MyDrawing selectedDrawings = null;
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
    buffer = selectedDrawings.clone();
  }

  public void cut(){
    // バッファをクリア
    clearBuffer();
    buffer = selectedDrawings.clone();
    removeDrawing(selectedDrawings); // drawings からselectedDrawings を削除
    repaint();
  }

  public void paste(int x, int y ){
    MyDrawing clone = (MyDrawing)buffer.clone();
    clone.setLocation(x,y);
    addDrawing(clone);
    clone.setRegion();
    repaint();
  }

  public Enumeration<MyDrawing> drawingsElements() {
    return drawings.elements();
  }

  public void addDrawing(MyDrawing d) {
    drawings.add(d);
    setselectedDrawings(d);
  }

  public void removeDrawing(MyDrawing d) {
    drawings.remove(d);
  }

  public MyDrawing getselectedDrawings() {
    return selectedDrawings;
  }

  public void move(int dx, int dy) {
    if (selectedDrawings != null) {
      selectedDrawings.move(dx,dy);
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
        setselectedDrawings(drawing); //drawingを選択された MyDrawing として設定
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

  public void setselectedDrawings(MyDrawing d){
    this.selectedDrawings = d;
    // d.setSelected(true);
  }

  public void setColor(Color color){
    if(selectedDrawings != null){
      selectedDrawings.setLineColor(color);
      repaint();
    }
  }

  public void setfColor(Color color){
    if(selectedDrawings != null){
      selectedDrawings.setfillColor(color);
      repaint();
    }
  }

  public void setLWidth(int width){
    if(selectedDrawings != null){
      selectedDrawings.setLineWidth(width);
      repaint();
    }
  }
}
