import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyApplication3 extends JFrame{
  StateManager stateManager;
  MyCanvas canvas;
  Mediator mediator;

  public MyApplication3(){
    super("My PainterApp");

    canvas = new MyCanvas();
    mediator = canvas.getMediator();
    canvas.setBackground(Color.white);

    JPanel jp = new JPanel();
    jp.setLayout(new FlowLayout());

    stateManager = new StateManager(canvas, mediator);

    // ボタン配置
    OvalButton ovalButton = new OvalButton(stateManager);
    jp.add(ovalButton);
    Rect3DButton rect3DButton = new Rect3DButton(stateManager);
    jp.add(rect3DButton);
    OctaButton octaButton = new OctaButton(stateManager);
    jp.add(octaButton);

    // // checkbox 追加
    // JCheckBox shadowCheck = new JCheckBox("dropShadow");
    // shadowCheck.addItemListener(new ShadowCheckListener(stateManager));
    // jp.add(shadowCheck);

    getContentPane().setLayout(new BorderLayout());
    getContentPane().add(jp, BorderLayout.NORTH);
    getContentPane().add(canvas, BorderLayout.CENTER);

    canvas.addMouseListener(new MouseAdapter(){
      // 現在の状態の mouseDown 処理の呼び出し
      public void mousePressed(MouseEvent e){
        stateManager.mouseDown(e.getX(),e.getY());
      }
    });

    canvas.addMouseMotionListener(new MouseMotionAdapter(){
      // 現在の状態の mouseDrag 処理の呼び出し
      public void mouseDragged(MouseEvent e){
        stateManager.mouseDrag(e.getX(),e.getY());
        mediator.repaint(); // 再描画
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
    return new Dimension(550,450);
  }

  public static void main(String[] args){
    MyApplication3 app = new MyApplication3();
    app.pack();
    app.setVisible(true);
  }
}
