import java.awt.Color;
import java.util.Enumeration;
import java.util.Vector;
//import javax.swing.*;

public class Mediator implements Cloneable{
  Vector<MyDrawing> drawings;
  MyCanvas canvas;
  // Vector<MyDrawing> selectDrawings = new Vector<MyDrawing>();
  Vector<MyDrawing> selectedDrawings;
  Vector<MyDrawing> buffer; // Cut,Copyバッファ

  public Mediator(MyCanvas canvas) {
    this.canvas = canvas;
    drawings = new Vector<MyDrawing>();
    selectedDrawings = new Vector<MyDrawing>();
    buffer = new Vector<MyDrawing>();
  }

  public void clearBuffer(){
    // buffer = null;
    buffer.clear();
    // for(MyDrawing d : buffer){
    //   d = null;
    // }
  }

  public void copy(){
    // バッファをクリア
    clearBuffer();
    for (int i = 0; i < selectedDrawings.size(); i++){
      MyDrawing d = selectedDrawings.elementAt(i);
      buffer.add(d);
    }
    // for (MyDrawing d : selectedDrawings){
    //   buffer.add(d.clone());
    // }
    // buffer = selectedDrawings.clone();
  }

  public void cut(){
    // バッファをクリア
    clearBuffer();
    for(int i = 0; i < selectedDrawings.size();i++){
      MyDrawing d = selectedDrawings.elementAt(i);
      buffer.add(d);
    }
    // buffer = selectedDrawings.clone();
    for(MyDrawing d : selectedDrawings){
      removeDrawing(d);
    }
    // removeDrawing(selectedDrawings); // drawings からselectedDrawings を削除
    repaint();
  }

  public void paste(int x, int y){
    // Vector<MyDrawing> clone = buffer.clone();
    // clone.setLocation(x,y);
    for (MyDrawing d : buffer){
      MyDrawing clone = d.clone();
      clone.setLocation(x,y);
      addDrawing(clone);
      clone.setRegion();
    }
    // addDrawing(clone);
    // clone.setRegion();
    repaint();
  }

  public Enumeration<MyDrawing> drawingsElements() {
    return drawings.elements();
  }

  public void addDrawing(MyDrawing d) {
    drawings.add(d);
    // setSelectedDrawings(d);
  }

  public void removeDrawing(MyDrawing d) {
    drawings.remove(d);
  }

  public Vector<MyDrawing> getSelectedDrawings() {
    return selectedDrawings;
  }

  public void move(int dx, int dy) {
    for (MyDrawing d : selectedDrawings){
      if (d != null) {
        d.move(dx,dy);
      }
    }
  }

  public void repaint() {
    canvas.repaint();
  }

  public void setSelected(int x, int y) {
    // setSelected(int x, int y)メソッドは、点(x, y)にある図形を選択状態にするためのものです。 drawingsに図形を追加する順番と表示される順番を考慮して、点(x, y)を含む図形が複数ある場合は一番手前にある図形を選択状態にできるように注意して実装する必要があるでしょう。
    // 一番手前→より後に追加された方
    // Vector 格納されている図形のうち，contains(x,y)→true となり，なおかつその中で一番後に Vector に格納されたものを selectDrawing へ格納
    // for (MyDrawing d : drawings){
    //   if(d.contains(x,y)){
    //     setSelectedDrawings(d);
    //     d.setSelected(true);
    //     for (MyDrawing s : drawings){
    //       if (s.equals(d)) continue;
    //       s.setSelected(false);
    //       for (int i=0; i < selectedDrawings.size();i++){ // 書き換え
    //         MyDrawing t = selectedDrawings.elementAt(i);
    //         if(t.equals(d)) continue;
    //         selectedDrawings.removeElementAt(i);
    //       }
    //       // for (MyDrawing t : selectedDrawings){
    //       //   if(t.equals(d)) continue;
    //       //   t.removeDrawing();
    //       // }
    //     }
    //     repaint();
    //   } else {
    //     d.setSelected(false);
    //     repaint();
    //   }
      // -----
      for (int i=drawings.size()-1;i >= 0;i--){
        MyDrawing d = drawings.elementAt(i);
        if(d.contains(x,y)){
          if(!selectedDrawings.contains(d)) setSelectedDrawings(d); // 連続で選択されても大丈夫なように
          for(int j = 0;j < selectedDrawings.size();j++){
            MyDrawing e = selectedDrawings.elementAt(j);
            if(!e.equals(d)) {
              selectedDrawings.removeElementAt(j);
              e.setSelected(false);
            }
          }
          break;
        }
      }
      repaint();

    // ----

    // アホな書き方をしていたのでリファクタリング(笑)
    // Enumeration<MyDrawing> e = drawingsElements();
    // while(e.hasMoreElements()){
    //   MyDrawing drawing = e.nextElement();
    //   if (drawing.contains(x,y)){
    //     setSelectedDrawings(drawing); //drawingを選択された MyDrawing として設定
    //     drawing.setSelected(true);
    //     // ---- 選ばれたもの以外を非選択状態へ
    //     Enumeration<MyDrawing> e1 = drawingsElements();
    //     while(e1.hasMoreElements()){
    //       MyDrawing drawing1 = e1.nextElement();
    //       if(drawing1.equals(drawing)){
    //         continue;
    //       }
    //       drawing1.setSelected(false);
    //     }
    //     repaint();
    //   } else {
    //     drawing.setSelected(false);
    //     repaint();
    //   }
    // }
    // 結果として，１番後に追加された drawing が selected
  }

  public void setSelectedDrawings(MyDrawing d){
    // this.selectedDrawings = d;
    this.selectedDrawings.add(d);
    d.setSelected(true);
    // d.setSelected(true);
  }

  public void setColor(Color color){
    for (MyDrawing d : selectedDrawings){
      if(d != null){
        d.setLineColor(color);
      }
    }
    repaint();
    // if(selectedDrawings != null){
    //   selectedDrawings.setLineColor(color);
    //   repaint();
    // }
  }

  public void setfColor(Color color){
    for (MyDrawing d : selectedDrawings){
      if(d != null){
        d.setfillColor(color);
      }
    }
    repaint();
  }

  public void setLWidth(int width){
    for (MyDrawing d : selectedDrawings){
      if(d != null){
        d.setLineWidth(width);
      }
    }
    repaint();
  }

  public void setAlpha(int a) {
	  for (MyDrawing d : selectedDrawings) {
		  if(d != null) {
			  d.setAlpha(a);
		  }
	  }
	  repaint();
  }
}
