import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyApplication extends JFrame implements ActionListener{
  StateManager stateManager;
  MyCanvas canvas;
  Mediator mediator;

  private JMenuBar menuBar; //追加
  private JMenu colorMenu;
  private JMenu fcolorMenu;
  private JMenu lineWidthMenu;
  private JMenu copyCutMenu;
  private JMenuItem redItem, blueItem, greenItem;
  private JMenuItem fredItem, fblueItem, fgreenItem;
  private JMenuItem firstItem, secondItem, thirdItem;
  private JMenuItem copyItem, cutItem;

  public MyApplication(){
    super("My PainterApp");

    menuBar = new JMenuBar(); // 追加
    setJMenuBar(menuBar);

    canvas = new MyCanvas();
    mediator = canvas.getMediator();
    canvas.setBackground(Color.white);

    JPanel jp = new JPanel();
    jp.setLayout(new FlowLayout());

    stateManager = new StateManager(canvas);

    // メニュー配置(追加)
    colorMenu = new JMenu("LineColor");
    redItem = new JMenuItem("Red");
    blueItem = new JMenuItem("Blue");
    greenItem = new JMenuItem("Green");
    colorMenu.add(redItem);
    colorMenu.add(blueItem);
    colorMenu.add(greenItem);
    redItem.addActionListener(this);
    blueItem.addActionListener(this);
    greenItem.addActionListener(this);

    fcolorMenu = new JMenu("FillColor");
    fredItem = new JMenuItem("Red");
    fblueItem = new JMenuItem("Blue");
    fgreenItem = new JMenuItem("Green");
    fcolorMenu.add(fredItem);
    fcolorMenu.add(fblueItem);
    fcolorMenu.add(fgreenItem);
    fredItem.addActionListener(this);
    fblueItem.addActionListener(this);
    fgreenItem.addActionListener(this);

    lineWidthMenu = new JMenu("LineWidth");
    firstItem = new JMenuItem("1");
    secondItem = new JMenuItem("3");
    thirdItem = new JMenuItem("5");
    lineWidthMenu.add(firstItem);
    lineWidthMenu.add(secondItem);
    lineWidthMenu.add(thirdItem);
    firstItem.addActionListener(this);
    secondItem.addActionListener(this);
    thirdItem.addActionListener(this);

    copyCutMenu = new JMenu("Copy&Cut");
    copyItem = new JMenuItem("Copy");
    cutItem = new JMenuItem("Cut");
    copyCutMenu.add(copyItem);
    copyCutMenu.add(cutItem);
    copyItem.addActionListener(this);
    cutItem.addActionListener(this);



    // ボタン配置
    SelectButton selectButton = new SelectButton(stateManager);
    jp.add(selectButton);
    OvalButton ovalButton = new OvalButton(stateManager);
    jp.add(ovalButton);
    Rect3DButton rect3DButton = new Rect3DButton(stateManager);
    jp.add(rect3DButton);
    // OctaButton octaButton = new OctaButton(stateManager);
    // jp.add(octaButton);
    Button deleteButton = new Button("Delete");
    deleteButton.addActionListener(new DeleteButtonListener());
    jp.add(deleteButton);
    Button shadowButton = new Button("Shadow");
    shadowButton.addActionListener(new ShadowButtonListener());
    jp.add(shadowButton);

    // // checkbox 追加
    // JCheckBox shadowCheck = new JCheckBox("dropShadow");
    // shadowCheck.addItemListener(new ShadowCheckListener(stateManager));
    // jp.add(shadowCheck);

    menuBar.add(colorMenu); //追加
    menuBar.add(fcolorMenu); //追加
    menuBar.add(lineWidthMenu); // 追加
    menuBar.add(copyCutMenu); // 追加

    getContentPane().setLayout(new BorderLayout());
    getContentPane().add(jp, BorderLayout.NORTH);
    getContentPane().add(canvas, BorderLayout.CENTER);



    canvas.addMouseListener(new MouseAdapter(){
      // 現在の状態の mouseDown 処理の呼び出し
      public void mousePressed(MouseEvent e){
        int modi = e.getModifiersEx(); // getModifiersは非推奨
        if((modi&MouseEvent.BUTTON1_DOWN_MASK)!=0){
          stateManager.mouseDown(e.getX(),e.getY());
        }
        if((modi&MouseEvent.BUTTON3_DOWN_MASK)!=0){
          stateManager.mediator.paste(e.getX(),e.getY());
        }
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

  public void actionPerformed(ActionEvent e){
    if(e.getSource() == redItem){
      mediator.setColor(Color.red);
    } else if(e.getSource() == blueItem){
      mediator.setColor(Color.blue);
    } else if(e.getSource() == greenItem){
      mediator.setColor(Color.green);
    } else if(e.getSource() == fredItem){
      mediator.setfColor(Color.red);
    } else if(e.getSource() == fblueItem){
      mediator.setfColor(Color.blue);
    } else if(e.getSource() == fgreenItem){
      mediator.setfColor(Color.green);
    } else if(e.getSource() == firstItem){
      mediator.setLWidth(1);
    } else if(e.getSource() == secondItem){
      mediator.setLWidth(3);
    } else if(e.getSource() == thirdItem){
      mediator.setLWidth(5);
    } else if(e.getSource() == copyItem){
      mediator.copy();
    } else if(e.getSource() == cutItem){
      mediator.cut();
    }
  }

  public Dimension getPreferredSize(){
    return new Dimension(550,450);
  }

  public static void main(String[] args){
    MyApplication app = new MyApplication();
    app.pack();
    app.setVisible(true);
  }

  class DeleteButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      mediator.removeDrawing(mediator.selectedDrawings);
      mediator.repaint();
    }
  }

  class ShadowButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      if(mediator.selectedDrawings.isShadow != true){
        mediator.selectedDrawings.isShadow = true;
      } else {
        mediator.selectedDrawings.isShadow = false;
      }
      mediator.repaint();
    }
  }

}
