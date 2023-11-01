import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.border.LineBorder;

public class calculator {

	private JFrame frame;
	private JLabel lblNewLabel;
	private float result;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					calculator window = new calculator();
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
	public calculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(105, 105, 105));
		frame.setBackground(new Color(204, 153, 102));
		frame.setBounds(100, 100, 300, 335);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton button = new JButton("1");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNewLabel.setText(lblNewLabel.getText()+"1");
			}
		});
		button.setFont(new Font("DialogInput", Font.BOLD, 20));
		button.setBackground(new Color(255, 255, 255));
		button.setBounds(12, 88, 55, 30);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("2");
		button_1.setFont(new Font("DialogInput", Font.BOLD, 20));
		button_1.setBackground(new Color(255, 255, 255));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNewLabel.setText(lblNewLabel.getText()+"2");
			}
		});
		button_1.setBounds(79, 88, 55, 30);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("3");
		button_2.setFont(new Font("DialogInput", Font.BOLD, 20));
		button_2.setBackground(new Color(255, 255, 255));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNewLabel.setText(lblNewLabel.getText()+"3");
			}
		});
		button_2.setBounds(146, 88, 55, 30);
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("4");
		button_3.setFont(new Font("DialogInput", Font.BOLD, 20));
		button_3.setBackground(new Color(255, 255, 255));
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNewLabel.setText(lblNewLabel.getText()+"4");
			}
		});
		button_3.setBounds(12, 130, 55, 30);
		frame.getContentPane().add(button_3);
		
		JButton button_4 = new JButton("7");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNewLabel.setText(lblNewLabel.getText()+"7");
			}
		});
		button_4.setFont(new Font("DialogInput", Font.BOLD, 20));
		button_4.setBackground(new Color(255, 255, 255));
		button_4.setBounds(12, 172, 55, 30);
		frame.getContentPane().add(button_4);
		
		JButton button_5 = new JButton("5");
		button_5.setFont(new Font("DialogInput", Font.BOLD, 20));
		button_5.setBackground(new Color(255, 255, 255));
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNewLabel.setText(lblNewLabel.getText()+"5");
			}
		});
		button_5.setBounds(79, 130, 55, 30);
		frame.getContentPane().add(button_5);
		
		JButton button_6 = new JButton("6");
		button_6.setFont(new Font("DialogInput", Font.BOLD, 20));
		button_6.setBackground(new Color(255, 255, 255));
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNewLabel.setText(lblNewLabel.getText()+"6");
			}
		});
		button_6.setBounds(146, 130, 55, 30);
		frame.getContentPane().add(button_6);
		
		JButton button_7 = new JButton("8");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNewLabel.setText(lblNewLabel.getText()+"8");
			}
		});
		button_7.setFont(new Font("DialogInput", Font.BOLD, 20));
		button_7.setBackground(new Color(255, 255, 255));
		button_7.setBounds(79, 172, 55, 30);
		frame.getContentPane().add(button_7);
		
		JButton button_8 = new JButton("9");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNewLabel.setText(lblNewLabel.getText()+"9");
			}
		});
		button_8.setFont(new Font("DialogInput", Font.BOLD, 20));
		button_8.setBackground(new Color(255, 255, 255));
		button_8.setBounds(146, 172, 55, 30);
		frame.getContentPane().add(button_8);
		
		JButton button_9 = new JButton("0");
		button_9.setFont(new Font("DialogInput", Font.BOLD, 18));
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNewLabel.setText(lblNewLabel.getText()+"0");
			}
		});
		button_9.setBounds(12, 214, 55, 30);
		frame.getContentPane().add(button_9);
		
		JButton button_10 = new JButton(".");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNewLabel.setText(lblNewLabel.getText()+".");
			}
		});
		button_10.setFont(new Font("DialogInput", Font.BOLD, 18));
		button_10.setBounds(79, 214, 55, 30);
		frame.getContentPane().add(button_10);
		
		JButton button_11 = new JButton("00");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNewLabel.setText(lblNewLabel.getText()+"00");
			}
		});
		button_11.setFont(new Font("DialogInput", Font.BOLD, 16));
		button_11.setBounds(146, 214, 55, 30);
		frame.getContentPane().add(button_11);
		
		JButton btnAc = new JButton("AC");
		btnAc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNewLabel.setText("");
			}
		});
		btnAc.setBackground(new Color(255, 102, 0));
		btnAc.setFont(new Font("DialogInput", Font.BOLD, 15));
		btnAc.setBounds(223, 88, 65, 30);
		frame.getContentPane().add(btnAc);
		
		JButton btnAc_2 = new JButton("+");
		btnAc_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNewLabel.setText(lblNewLabel.getText()+"+");
			}
		});
		btnAc_2.setBackground(new Color(204, 51, 0));
		btnAc_2.setFont(new Font("DialogInput", Font.BOLD, 24));
		btnAc_2.setBounds(223, 172, 65, 30);
		frame.getContentPane().add(btnAc_2);
		
		JButton btnX = new JButton("-");
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNewLabel.setText(lblNewLabel.getText()+"-");
			}
		});
		btnX.setBackground(new Color(204, 51, 0));
		btnX.setFont(new Font("DialogInput", Font.BOLD, 24));
		btnX.setBounds(223, 214, 65, 30);
		frame.getContentPane().add(btnX);
		
		JButton btnAc_5 = new JButton("/");
		btnAc_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNewLabel.setText(lblNewLabel.getText()+"/");
			}
		});
		btnAc_5.setBackground(new Color(204, 51, 0));
		btnAc_5.setFont(new Font("DialogInput", Font.BOLD, 21));
		btnAc_5.setBounds(146, 256, 62, 30);
		frame.getContentPane().add(btnAc_5);
		
		JButton btnAc_6 = new JButton("=");
		btnAc_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String tem = lblNewLabel.getText();
				int len = tem.length();
				try {
					if(tem.contains("sq")) {
						if(tem.endsWith("sq")) {
							float a = Float.valueOf(tem.substring(0,len-2));
							result = (float)Math.pow(a, 2);
							lblNewLabel.setText(Float.toString(result));
						}
						else
							lblNewLabel.setText("ERROR!!");
					}
					else if(tem.contains("+")) {
						int index = tem.indexOf('+');
						float a = Float.valueOf(tem.substring(0, index));
						float b = Float.valueOf(tem.substring(index+1));
						result = a+b;
						lblNewLabel.setText(Float.toString(result));
					}
					else if(tem.contains("-")) {
						int index = tem.indexOf('-');
						float a = Float.valueOf(tem.substring(0, index));
						float b = Float.valueOf(tem.substring(index+1));
						result = a-b;
						lblNewLabel.setText(Float.toString(result));
					}
					else if(tem.contains("x")) {
						int index = tem.indexOf('x');
						float a = Float.valueOf(tem.substring(0, index));
						float b = Float.valueOf(tem.substring(index+1));
						result = a*b;
						lblNewLabel.setText(Float.toString(result));
					}
					else if(tem.contains("/")) {
						int index = tem.indexOf('/');
						float a = Float.valueOf(tem.substring(0, index));
						float b = Float.valueOf(tem.substring(index+1));
						result = a/b;
						lblNewLabel.setText(Float.toString(result));
					}
					else if(tem.indexOf("sq")==-1 && tem.indexOf('+')==-1 && tem.indexOf('-')==-1 && tem.indexOf('x')==-1 && tem.indexOf('/')==-1) {
						lblNewLabel.setText(tem);
					}
				}
				catch ( Exception e){
					lblNewLabel.setText("ERROR!!");
				}
				}
		});
		btnAc_6.setFont(new Font("DialogInput", Font.BOLD, 20));
		btnAc_6.setBackground(new Color(107, 142, 35));
		btnAc_6.setBounds(223, 256, 65, 30);
		frame.getContentPane().add(btnAc_6);
		
		JButton btnDel = new JButton("DEL");
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int len = lblNewLabel.getText().length();
				if(len==0) lblNewLabel.setText("");
				if(lblNewLabel.getText().endsWith("sq")) {
					String tem = lblNewLabel.getText().substring(0,len-2);
					lblNewLabel.setText(tem);
				}
				else {
					String tem = lblNewLabel.getText().substring(0,len-1);
					lblNewLabel.setText(tem);
				}

			}
		});
		btnDel.setBackground(new Color(255, 102, 0));
		btnDel.setFont(new Font("DialogInput", Font.BOLD, 15));
		btnDel.setBounds(223, 130, 65, 30);
		frame.getContentPane().add(btnDel);
		
		JButton btnXy = new JButton("sq");
		btnXy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNewLabel.setText(lblNewLabel.getText()+"sq");
			}
		});
		btnXy.setBackground(new Color(204, 51, 0));
		btnXy.setFont(new Font("DialogInput", Font.BOLD, 18));
		btnXy.setBounds(12, 256, 62, 30);
		frame.getContentPane().add(btnXy);
		
		JButton btnAc_1 = new JButton("X");
		btnAc_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNewLabel.setText(lblNewLabel.getText()+"x");
			}
		});
		btnAc_1.setBackground(new Color(204, 51, 0));
		btnAc_1.setFont(new Font("DialogInput", Font.BOLD, 18));
		btnAc_1.setBounds(79, 256, 62, 30);
		frame.getContentPane().add(btnAc_1);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(143, 240, 164));
		lblNewLabel.setFont(new Font("DialogInput", Font.BOLD, 25));
		lblNewLabel.setBorder(new LineBorder(null, 3, true));
		lblNewLabel.setBounds(12, 35, 276, 41);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Powered By Krishna");
		lblNewLabel_1.setToolTipText("");
		lblNewLabel_1.setBounds(68, 290, 151, 15);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
