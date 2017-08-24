package component;
import java.awt.Button;
// Importing the Abstract Window Toolkit library
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class MyFrame extends Frame {
	Button closeBtn;
	public MyFrame() {
		// Initial configurations
		setTitle("Welcome to IFSP");
		setLayout(null);
		// Setting the size of the frame object
		setSize(300, 400);
		// Adding a Listener to Window component
		addWindowListener(new CloseableWindow());
		// Adding a button to close the form via button
		closeBtn = new Button("Close");
		closeBtn.setBounds(50, 50, 100, 50);
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		add(closeBtn);
		// Exhibiting the frame
		setVisible(true);
	}
}
// The 'WindowAdapter' class make it easier to manage the events from screen
class CloseableWindow extends WindowAdapter {
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}