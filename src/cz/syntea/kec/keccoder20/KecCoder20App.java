/*
 * KecCoder20App.java
 */
package cz.syntea.kec.keccoder20;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;

/**
 * The main class of the application.
 */
public class KecCoder20App extends SingleFrameApplication {

  /**
   * At startup create and show the main frame of the application.
   */
  @Override
  protected void startup() {
	try {
	  for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		if ("Nimbus".equals(info.getName())) {
		  UIManager.setLookAndFeel(info.getClassName());
		  break;
		}
	  }
	} catch (UnsupportedLookAndFeelException e) {
	  // handle exception
	} catch (ClassNotFoundException e) {
	  // handle exception
	} catch (InstantiationException e) {
	  // handle exception
	} catch (IllegalAccessException e) {
	  // handle exception
	}
	show(new KecCoder20View(this));
  }

  /**
   * This method is to initialize the specified window by injecting resources.
   * Windows shown in our application come fully initialized from the GUI
   * builder, so this additional configuration is not needed.
   */
  @Override
  protected void configureWindow(java.awt.Window root) {
  }

  /**
   * A convenient static getter for the application instance.
   * @return the instance of KecCoder20App
   */
  public static KecCoder20App getApplication() {
	return Application.getInstance(KecCoder20App.class);
  }

  /**
   * Main method launching the application.
   */
  public static void main(String[] args) {
	launch(KecCoder20App.class, args);
  }
}
