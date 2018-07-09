import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SelectButton extends JButton {
  StateManager stateManager;

  public SelectButton(StateManager stateManager){
    super("Select");

    addActionListener(new SelectListener());

    this.stateManager = stateManager;
  }

  class SelectListener implements ActionListener {
    public void actionPerformed(ActionEvent e){
      stateManager.setState(new SelectState(stateManager));
    }
  }
}
