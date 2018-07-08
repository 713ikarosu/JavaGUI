import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Rect3DButton extends JButton {
  StateManager stateManager;

  public Rect3DButton(StateManager stateManager){
    super("3DRectangle");

    addActionListener(new Rect3DListener());

    this.stateManager = stateManager;
  }

  class Rect3DListener implements ActionListener {
    public void actionPerformed(ActionEvent e){
      stateManager.setState(new Rect3DState(stateManager));
    }
  }
}
