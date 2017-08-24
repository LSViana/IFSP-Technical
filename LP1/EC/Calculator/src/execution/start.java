package execution;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import operator.Operator;

public class start {
	static Operator operator = new Operator();

	public static void main(String[] args) {
		showScreen();
	}

	static void showScreen() {
		try {
			char[] operators = new char[] { '+', '-', '*', '/', '0', '1', '2', '3', '4', '5', '6', '7', '9' };
			//
			JTextField operationsField = new JTextField();
			operationsField.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyTyped(java.awt.event.KeyEvent evt) {
					for (char c : operators) {
						if (c == evt.getKeyChar())
							return;
					}
					evt.consume();
				}
			});
			//
			Object[] components = new Object[] { "Operações: ", operationsField };
			//
			Object[] options = new Object[] { "Calcular", "Sair" };
			//
			int choice = JOptionPane.showOptionDialog(null, components, "Calculadora", JOptionPane.NO_OPTION,
					JOptionPane.PLAIN_MESSAGE, null, options, null);
			//
			if (choice == 1)
				System.exit(0);
			Number result = operator.Operate(operationsField.getText());
			if(result == null || operationsField.getText().isEmpty())
				System.exit(0);
			JOptionPane.showMessageDialog(null, "Resultado: " + String.format("%.0f", result.doubleValue()));
		} catch (Exception exc) {
			System.out.println("OI");
			return;
		}
	}
}
