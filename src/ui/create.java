package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import application.Accounts;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;

public class create extends JFrame {

	private JPanel contentPane;
	private JTextField create_username;
	private JTextField create_password;
	private JTextField create_role;
	
	private static create frame;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new create();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public create() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		create_username = new JTextField();
		create_username.setBounds(169, 73, 142, 20);
		contentPane.add(create_username);
		create_username.setColumns(10);
		
		create_password = new JTextField();
		create_password.setBounds(169, 103, 142, 20);
		contentPane.add(create_password);
		create_password.setColumns(10);
		
		create_role = new JTextField();
		create_role.setBounds(169, 160, 142, 20);
		contentPane.add(create_role);
		create_role.setColumns(10);
		
		JButton create = new JButton("Create");
		
		JLabel error = new JLabel("Job role must be either 'Employee' or 'Manager'");
		error.setForeground(Color.RED);
		error.setBounds(71, 202, 286, 14);
		
		contentPane.add(error);
		error.setVisible(false);
		
		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = create_username.getText();
				String password = create_password.getText();
				String role = create_role.getText();
				
				if(role.equals("Employee") || role.equals("Manager")) {
					boolean success = Accounts.create(username, password, role);
					
					if(success) {
						login l = new login();
						l.setVisible(true);
						dispose();
					}
					else {
						error.setText("Already an account with that name");
						error.setVisible(true);
					}
				}
				else {
					error.setText("Job role must be either 'Employee' or 'Manager'");
					error.setVisible(true);
				}
				
			}
		});
		
		create.setBounds(159, 227, 89, 23);
		contentPane.add(create);
		
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login l = new login();
				l.setVisible(true);
				dispose();
			}
		});
		
		back.setBounds(10, 11, 63, 20);
		contentPane.add(back);
		
		JLabel username_label = new JLabel("Username:");
		username_label.setBounds(78, 75, 63, 14);
		contentPane.add(username_label);
		
		JLabel password_label = new JLabel("Password:");
		password_label.setBounds(78, 106, 63, 14);
		contentPane.add(password_label);
		
		JLabel role_label = new JLabel("Job Role:");
		role_label.setBounds(78, 163, 63, 14);
		contentPane.add(role_label);
		
	}
}
