import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyApplication2 extends JFrame{
  StateManager stateManager;
  MyCanvas canvas;

  public MyApplication2(){
    super("My Painter");

    canvas = new MyCanvas();
    canvas.setBackground(Color.white);

    JPanel jp = new JPanel();
    jp.setLayout(new FlowLayout());

    stateManager = new StateManager(canvas);

    RectButton rectButton = new RectButton(stateManager);
    jp.add(rectButton);
    OvalButton ovalButton = new OvalButton(stateManager);
    jp.add(ovalButton);

    getContentPane().setLayout(new BorderLayout());
    getContentPane().add(jp, BorderLayout.NORTH);
    getContentPane().add(canvas, BorderLayout.CENTER);

    canvas.addMouseListener(new MouseAdapter(){
      // 現在の状態の mouseDown 処理の呼び出し
      public void mousePressed(MouseEvent e){
        System.out.println("Pressed");
        stateManager.mouseDown(e.getX(),e.getY());
      }
    });

    this.addWindowListener(new WindowAdapter(){
      // ウィンドウ閉じたら終わり
      public void windowClosing(WindowEvent e){
        System.exit(0);
      }
    });
  }

  public Dimension getPreferredSize(){
    return new Dimension(300,400);
  }

  public static void main(String[] args){
    MyApplication2 app = new MyApplication2();
    app.pack();
    app.setVisible(true);
  }
}

// // マウスイベントを扱うクラス
// class MyMouseAdapter extends MouseAdapter{
//   private MyCanvas canvas;
//
//   public MyMouseAdapter(MyCanvas canvas){
//     this.canvas = canvas;
//   }
//
//   // マウスがクリックされたときの処理
//   public void mousePressed(MouseEvent e){
//     // canvas.addDrawing(new MyRectangle(e.getX(),e.getY()));
//     canvas.addDrawing(new My3DRect(e.getX(),e.getY()));
//
//     // キャンパスの再描画命令
//     canvas.repaint();
//   }
// }
// // MyApplication2〜以前の姿〜
// import java.awt.*;
// import java.awt.event.*;
// import javax.swing.*;
//
// public class MyApplication2 extends JFrame{
//   public MyApplication2(){
//     super("My Painter");
//     JPanel jp = new JPanel();
//     jp.setLayout(new BorderLayout());
//     MyCanvas canvas = new MyCanvas();
//
//     jp.add(BorderLayout.CENTER, canvas);
//     getContentPane().add(jp);
//
//     MyMouseAdapter ma = new MyMouseAdapter(canvas);
//     canvas.addMouseListener(ma);
//
//     addWindowListener(
//       new WindowAdapter(){
//         public void windowClosing(WindowEvent e){
//           System.exit(1);
//         }
//       });
//   }
//
//   public static void main(String[] args){
//     MyApplication2 ma = new MyApplication2();
//     ma.setSize(400,300);
//     ma.setVisible(true);
//   }
// }
//
// // マウスイベントを扱うクラス
// class MyMouseAdapter extends MouseAdapter{
//   private MyCanvas canvas;
//
//   public MyMouseAdapter(MyCanvas canvas){
//     this.canvas = canvas;
//   }
//
//   // マウスがクリックされたときの処理
//   public void mousePressed(MouseEvent e){
//     // canvas.addDrawing(new MyRectangle(e.getX(),e.getY()));
//     canvas.addDrawing(new My3DRect(e.getX(),e.getY()));
//
//     // キャンパスの再描画命令
//     canvas.repaint();
//   }
// }
