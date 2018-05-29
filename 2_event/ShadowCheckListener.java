import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ShadowCheckListener implements ItemListener {
  StateManager stateManager;

  public ShadowCheckListener(StateManager stateManager){
    this.stateManager = stateManager;
  }

  public void itemStateChanged(ItemEvent e) {
    int state = e.getStateChange();
    if(state == ItemEvent.SELECTED){
      // check されたとき
      stateManager.setShadowState(true);
    } else {
      // uncheck されたとき
      stateManager.setShadowState(false);
    }
  }
}
