package OS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.TextArea;
import java.awt.Font;
import java.awt.event.TextListener;
import java.awt.event.TextEvent;
import java.awt.Button;

public class GUI {
	public TextArea textArea, textArea_1;
	public JLabel lblNewLabel_1, lblNewLabel_2;
	private JFrame frame;
	private Manager manager = new Manager(10);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
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
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 572, 468);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Finished");
		lblNewLabel.setBounds(407, 28, 54, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblActiveProcesses = new JLabel("Active");
		lblActiveProcesses.setBounds(407, 10, 46, 14);
		frame.getContentPane().add(lblActiveProcesses);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(471, 10, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(471, 28, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		TextArea textArea = new TextArea();
		/*
		 * TEXT AREA FOR PROCCES IN PROGRESS
		 */
		textArea.setRows(60);
		textArea.setColumns(100);
		textArea.setFont(new Font("Dialog", Font.PLAIN, 12));
		textArea.setEditable(false);
		textArea.setBounds(23, 10, 201, 277);
		frame.getContentPane().add(textArea);
		
		TextArea textArea_1 = new TextArea();
		/*
		 * TEXT AREA FOR FINISHED PROCESSES LISTING
		 */
		textArea_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		textArea_1.setRows(60);
		textArea_1.setEditable(false);
		textArea_1.setColumns(100);
		textArea_1.setBounds(236, 10, 165, 277);
		frame.getContentPane().add(textArea_1);
		
		JButton GO = new JButton("Step");
		/*
		 * BUTTON THAT IS STARTING SIMULATION
		 */
		GO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.doSmth();
				textArea.setText(manager.toString());
				textArea_1.setText(manager.showDone());
				lblNewLabel_1.setText(Integer.toString(manager.how_much_acvite()));
				lblNewLabel_2.setText(Integer.toString(manager.how_much_done()));

			}
		});
		GO.setBounds(59, 321, 70, 22);
		frame.getContentPane().add(GO);
		GO.setBounds(59, 321, 70, 22);
		frame.getContentPane().add(GO);
		
		JButton btnNewButton = new JButton("Add process");
		/*
		 * THIS BUTTON IS ADDING NEW PROCES TO THE QUEUE
		 */
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.add_process();
				textArea.setText(manager.toString());
				lblNewLabel_1.setText(Integer.toString(manager.how_much_acvite()));
			}
		});
		btnNewButton.setBounds(164, 321, 107, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Made by Radek Lejba DWARFSOFT        v0.3");
		lblNewLabel_3.setBounds(206, 404, 311, 14);
		frame.getContentPane().add(lblNewLabel_3);
	}
}
