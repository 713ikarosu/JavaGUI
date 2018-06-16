import java.awt.*;

public class MyDrawing{
  private int x, y, w, h; // X 座標,　Y 座標,　幅,　高さ
  private Color lineColor, fillCollor; // 線の色、塗り絵
  private int LineWidth; // 線の太さ

  private boolean isDashed = false; // 破線であるかどうか

  // 破線状態の切り替え
  public void setDashed(boolean b){
    isDashed = b;
  }

  // 破線状態の取
  public boolean getDashed(){
    return isDashed;
  }
}
