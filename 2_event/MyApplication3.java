import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyApplication3 extends JFrame{
  StateManager stateManager;
  MyCanvas canvas;

  public MyApplication3(){
    super("My Painter");

    canvas = new MyCanvas();
    canvas.setBackground(Color.white);

    JPanel jp = new JPanel();
    jp.setLayout(new FlowLayout());

    stateManager = new StateManager(canvas);

    // RectButton rectButton = new RectButton(stateManager);
    // jp.add(rectButton);
    // OvalButton ovalButton = new OvalButton(stateManager);
    // jp.add(ovalButton);
    // Rect3DButton rect3DButton = new Rect3DButton(stateManager);
    // jp.add(rect3DButton);

    getContentPane().setLayout(new BorderLayout());
    getContentPane().add(jp, BorderLayout.NORTH);
    getContentPane().add(canvas, BorderLayout.CENTER);

    canvas.addMouseListener(new MouseAdapter(){
      // 現在の状態の mouseDown 処理の呼び出し
      public void mousePressed(MouseEvent e){
        stateManager.mouseDown(e.getX(),e.getY());
        System.out.println("clicked.");
      }
    });

    canvas.addMouseListener(new MouseAdapter(){
      // 現在の状態の mouseDrag 処理の呼び出し
      public void mouseDragged(MouseEvent e){
        stateManager.mouseDrag(e.getX(),e.getY());
        System.out.println("dragged.");
      }
    });

    // class MyMouseAdapter2 extends MouseAdapter {
    //   private MyCanvas canvas;
    //
    //   public MyMouseAdapter2(MyCanvas canvas) {
    //     this.canvas = canvas;
    //   }
    //
    //   // 現在の状態の mouseDown 処理の呼び出し
    //   public void mousePressed(MouseEvent e){
    //     stateManager.mouseDown(e.getX(),e.getY());
    //   }
    //
    //   // 現在の状態の mouseDrag 処理の呼び出し
    //   public void mouseDragged(MouseEvent e){
    //     stateManager.mouseDrag(e.getX(),e.getY());
    //     System.out.println("dragged.");
    //   }
    // }
    //
    // MyMouseAdapter2 ma = new MyMouseAdapter2(canvas);
    // canvas.addMouseListener(ma);

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
    MyApplication3 app = new MyApplication3();
    app.pack();
    app.setVisible(true);
  }
}
