import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RectButton extends JButton {
  StateManager stateManager;

  public RectButton(StateManager stateManager){
    super("Rectangle");

    addActionListener(new RectListener());

    this.stateManager = stateManager;
  }

  class RectListener implements ActionListener {
    public void actionPerformed(ActionEvent e){
      stateManager.setState(new RectState(stateManager()));
    }
  }
}

public class RectState implements State {
  StateManager stateManager;

  public RectState(StateManager stateManager){
    this.stateManager = stateManager;
  }

  public void mouseDown(int x,int y){
    stateManager.addDrawing(new MyRectangle(x.y));
  }

  public void mouseUp(int x,int y){}
  public void mouseDrag(int x,int y){}
}
