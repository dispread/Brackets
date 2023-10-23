package brackets;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class Brackets {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Brackets window = new Brackets();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Brackets() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(23, 123, 244, 63);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lbl = new JLabel("");
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl.setBounds(28, 72, 78, 29);
		frame.getContentPane().add(lbl);
		
		JButton btnNewButton = new JButton("Check");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String txt = textField.getText();
				if(checkVariedBrackets(txt)) {
					lbl.setText("good");
				} else {
					lbl.setText("bad");
				}
			}
		});
		btnNewButton.setBounds(299, 147, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}

	protected boolean checkBrackets(String txt) {
		int indent = 0;
		for(int i = 0; i < txt.length(); i++) {
			char c = txt.charAt(i);
			if(c != '(' && c != ')') {
				continue;
			}
			
			if(c == '(') {
				indent++;
			}
			if(c == ')') {
				indent--;
			}
			
			if(indent < 0) {
				return false;
			}
		}
		if(indent > 0) {
			return false;
		}
		return true;
	}
	
	public static boolean checkVariedBrackets(String txt) {
		int normal = 0;
		
		boolean square = false;
		boolean vSquare = false;
		
		boolean curly = false;
		boolean vCurly = false;
		
		boolean vSign = true;

		for(int i = 0; i < txt.length(); i++) {
			char c = txt.charAt(i);
			
			if(c == '+' || c == '-' || c == '*' || c == '/') {
				vSign = true;
			}
			
			if(c == '(' || c == '[' || c == '{') {
				if(!vSign) {
					return false;
				}
			}
			
			if(c == ')' || c == ']' || c =='}') {
				vSign = false;
			}
			
			if(c == '(') {
				if(square) {
					vSquare = true;
				}
				normal++;
			}
			if(c == '[') {
				if(square || normal > 0) {
					return false;
				}
				if(curly) {
					vCurly = true;
				}
				square = true;
			}
			if(c == '{') {
				if(square || curly || normal > 0) {
					return false;
				}
				curly = true;
			}
			
			
			if(c == ')') {
				if(normal == 0) {
					return false;
				}
				normal--;
			}
			if(c == ']') {
				if(!square) {
					return false;
				} else if(!vSquare) {
					return false;
				}
				square = false;
				vSquare = false;
			}
			if(c == '}') {
				if(!curly) {
					return false;
				} else if(!vCurly) {
					return false;
				}
				curly = false;
				vCurly = false;
			}
		}
		if(normal>0 || square || curly) {
			return false;
		}
		
		return true;
	}
}
