import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MyApplication extends JFrame implements ActionListener{
  StateManager stateManager;
  MyCanvas canvas;
  Mediator mediator;
  FileStream filest; // ファイル入出力
  FileStream filest2; // 画像入力用


  private JMenuBar menuBar; //追加
  private JMenu colorMenu;
  private JMenu fcolorMenu;
  private JMenu lineWidthMenu;
  private JMenu copyCutMenu;
  private JMenu alphaMenu;
  private JMenu overlapMenu;
  private JMenuItem redItem, blueItem, greenItem;
  private JMenuItem fredItem, fblueItem, fgreenItem;
  private JMenuItem firstItem, secondItem, thirdItem;
  private JMenuItem lowItem, middleItem, highItem;
  private JMenuItem copyItem, cutItem;
  private JMenuItem foremostItem, lastItem;

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

    alphaMenu = new JMenu("Trancparency");
    lowItem = new JMenuItem("64");
    middleItem = new JMenuItem("128");
    highItem = new JMenuItem("255");
    alphaMenu.add(lowItem);
    alphaMenu.add(middleItem);
    alphaMenu.add(highItem);
    lowItem.addActionListener(this);
    middleItem.addActionListener(this);
    highItem.addActionListener(this);

    copyCutMenu = new JMenu("Copy&Cut");
    copyItem = new JMenuItem("Copy");
    cutItem = new JMenuItem("Cut");
    copyCutMenu.add(copyItem);
    copyCutMenu.add(cutItem);
    copyItem.addActionListener(this);
    cutItem.addActionListener(this);

    overlapMenu = new JMenu("OverLap");
    foremostItem = new JMenuItem("ForeMost");
    lastItem = new JMenuItem("Last");
    overlapMenu.add(foremostItem);
    overlapMenu.add(lastItem);
    foremostItem.addActionListener(this);
    lastItem.addActionListener(this);

    // ボタン配置
    SelectButton selectButton = new SelectButton(stateManager);
    jp.add(selectButton);
    OvalButton ovalButton = new OvalButton(stateManager);
    jp.add(ovalButton);
    Rect3DButton rect3DButton = new Rect3DButton(stateManager);
    jp.add(rect3DButton);
    Button deleteButton = new Button("Delete");
    deleteButton.addActionListener(new DeleteButtonListener());
    jp.add(deleteButton);
    Button shadowButton = new Button("Shadow");
    shadowButton.addActionListener(new ShadowButtonListener());
    jp.add(shadowButton);
    Button saveButton = new Button("Save");
    saveButton.addActionListener(new SaveButtonListener());
    jp.add(saveButton);
    Button loadButton = new Button("Load");
    loadButton.addActionListener(new LoadButtonListener());
    jp.add(loadButton);
    Button pictureButton = new Button("Pic");
    pictureButton.addActionListener(new PictureButtonListener());
    jp.add(pictureButton);

    // // checkbox 追加
    // JCheckBox shadowCheck = new JCheckBox("dropShadow");
    // shadowCheck.addItemListener(new ShadowCheckListener(stateManager));
    // jp.add(shadowCheck);

    menuBar.add(colorMenu); //追加
    menuBar.add(fcolorMenu); //追加
    menuBar.add(alphaMenu); //追加
    menuBar.add(lineWidthMenu); // 追加
    menuBar.add(copyCutMenu); // 追加
    menuBar.add(overlapMenu);

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

    canvas.addMouseListener(new MouseAdapter(){
      public void mouseReleased(MouseEvent e){
        stateManager.mouseUp(e.getX(),e.getY());
      }
    });

    canvas.addMouseMotionListener(new MouseMotionAdapter(){
      // 現在の状態の mouseDrag 処理の呼び出し
      public void mouseDragged(MouseEvent e){
        stateManager.mouseDrag(e.getX(),e.getY());
        mediator.repaint(); // 再描画
      }
    });

    canvas.addMouseMotionListener(new MouseMotionAdapter() { // カーソル変化
    	public void mouseMoved(MouseEvent e) {
    		stateManager.mouseMoved(e.getX(), e.getY());
    		mediator.repaint();
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
    } else if(e.getSource() == lowItem) {
      mediator.setAlpha(64);
    } else if(e.getSource() == middleItem) {
      mediator.setAlpha(128);
    } else if(e.getSource() == highItem) {
      mediator.setAlpha(255);
    } else if(e.getSource() == foremostItem) {
      mediator.setForemost();  // 最前列へ
    } else if(e.getSource() == lastItem) {
      mediator.setLast(); // 最後列へ
    }
  }

  public Dimension getPreferredSize(){
    return new Dimension(650,550);
  }

  public static void main(String[] args){
    MyApplication app = new MyApplication();
    app.pack();
    app.setVisible(true);
  }

  class DeleteButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      for (MyDrawing d : mediator.selectedDrawings){
        mediator.removeDrawing(d);
      }
      mediator.repaint();
    }
  }

  class ShadowButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      for (MyDrawing d : mediator.selectedDrawings){
        if(d.isShadow != true){
          d.isShadow = true;
        } else {
          d.isShadow = false;
        }
      }
      mediator.repaint();
    }
  }

  class SaveButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      JFileChooser fc = new JFileChooser();

      int returnVal = fc.showOpenDialog(null);

      if(returnVal == JFileChooser.APPROVE_OPTION){
        filest = new FileStream();
        File file = fc.getSelectedFile();
        filest.fileOutput(mediator.drawings,file);
      }
    }
  }

  class LoadButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      JFileChooser fc = new JFileChooser();

      int returnVal = fc.showOpenDialog(null);

      if(returnVal == JFileChooser.APPROVE_OPTION){
        File file = fc.getSelectedFile();
        mediator.drawings = filest.fileInput(file);
        mediator.repaint();
      }

    }
  }

  class PictureButtonListener implements ActionListener {
	  public void actionPerformed(ActionEvent e) {
		  JFileChooser fc = new JFileChooser();

		  int returnVal = fc.showOpenDialog(null);

		  if(returnVal == JFileChooser.APPROVE_OPTION) {
			  File file = fc.getSelectedFile();
			  mediator.drawings.addElement(filest2.fileInput2(file));
			  mediator.drawings.lastElement().setLocation(10,10);
			  mediator.repaint();
		  }
	  }
  }

}
