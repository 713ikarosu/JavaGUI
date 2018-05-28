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
    Rect3DButton rect3DButton = new Rect3DButton(stateManager);
    jp.add(rect3DButton);

    getContentPane().setLayout(new BorderLayout());
    getContentPane().add(jp, BorderLayout.NORTH);
    getContentPane().add(canvas, BorderLayout.CENTER);

    canvas.addMouseListener(new MouseAdapter(){
      // 現在の状態の mouseDown 処理の呼び出し
      public void mousePressed(MouseEvent e){
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
