import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class OctaButton extends JButton {
  StateManager stateManager;

  public OctaButton(StateManager stateManager){
    super("Octagonal");

    addActionListener(new OctaListener());

    this.stateManager = stateManager;
  }

  class OctaListener implements ActionListener {
    public void actionPerformed(ActionEvent e){
      stateManager.setState(new OctaState(stateManager));
    }
  }
}
