import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyButton extends JFrame {
  public MyButton() {
    super("MyButton");

    // FlowLayout を使って部品を左から配置するパネルを作成
    JPanel jp = new JPanel();
    jp.setLayout(new FlowLayout());
    getContentPane().add(jp);

    Button rectButton = new Button("Rectangle");
    // ボタンにイベントを登録
    rectButton.addActionListener(new RectButtonListener());
    jp.add(rectButton);

    Button circleButton = new Button("Circle");
    circleButton.addActionListener(new CircleButtonListener());
    jp.add(circleButton);

    Button threeDRectangleButton = new Button("threeDRectangel");
    threeDRectangleButton.addActionListener(new threeDRectangleButtonListener());
    jp.add(threeDRectangleButton);

    setSize(350,300);
  }

  public static void main(String[] args){
    MyButton myapp = new MyButton();
    myapp.setVisible(true);
  }
}

// Rect ボタンのイベントリスナ
class RectButtonListener implements ActionListener {
  // Rect ボタンが押されたときの処理
  public void actionPerformed(ActionEvent e) {
    JOptionPane.showMessageDialog(null, "Rect is pressed!");
  }
}

// Circle ボタンのイベントリスナ
class CircleButtonListener implements ActionListener {
  // Circle ボタンが押されたときの処理
  public void actionPerformed(ActionEvent e) {
    JOptionPane.showMessageDialog(null, "Circle is pressed!");
  }
}

// Triangle ボタンのイベントリスナ
class threeDRectangleButtonListener implements ActionListener {
  // Triangle ボタンが押されたときの処理
  public void actionPerformed(ActionEvent e) {
    JOptionPane.showMessageDialog(null, "3DRectangle is pressed!");
  }
}
