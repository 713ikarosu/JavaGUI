import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// ウィンドウを表すクラス
public class MyApplication extends JFrame {
  public MyApplication() {
    super("My Painter");

    JPanel jp = new JPanel();
    jp.setLayout(new BorderLayout());
    this.getContentPane().add(jp);

    MyCanvas canvas = new MyCanvas();
    // for (int i=0;i<8;i++){
    //   canvas.addDrawing(new MyRectangle(20 + i*40, 20 + i*30)); // 40,30ずつずらして描写

    // } 引数を指定し，楕円を生成
    canvas.addDrawing(new MyOval(60,60,60,30,Color.black,Color.blue));
    jp.add(BorderLayout.CENTER,canvas);

    // 多角形を生成
    canvas.addDrawing(new MyOctagonal(120,120,30));
    jp.add(BorderLayout.CENTER,canvas);

    // 立体的な短形を生成
    canvas.addDrawing(new My3DRect(180,180,60,60));
    jp.add(BorderLayout.CENTER,canvas);

    // WindowEvent リスナを設定(無名クラスを利用している)
    this.addWindowListener(
      new WindowAdapter(){
        // ウィンドウが閉じたら終了する処理
        public void windowClosing(WindowEvent e){
          System.exit(1);
        }
      }
    );
  }

  public static void main(String[] args) {
    MyApplication app = new MyApplication();
    app.setSize(400,300);
    app.setVisible(true);
  }
}
