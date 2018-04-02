package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import application.Accounts;
import files.Read;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField username_input;
	private JTextField password_input;
	
	public static String username = "";
	public static String password = "";
	
	private static login frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 337, 281);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel username_label = new JLabel("Username:");
		username_label.setBounds(55, 66, 93, 28);
		contentPane.add(username_label);
		
		JLabel password_label = new JLabel("Password:");
		password_label.setBounds(55, 117, 93, 28);
		contentPane.add(password_label);
	
		
		username_input = new JTextField();
		username_input.setBounds(150, 66, 142, 24);
		contentPane.add(username_input);
		username_input.setColumns(10);
		
		password_input = new JTextField();
		password_input.setBounds(150, 117, 142, 24);
		contentPane.add(password_input);
		password_input.setColumns(10);
		
		JLabel error = new JLabel("Couldn't log in");
		error.setForeground(Color.RED);
		error.setBounds(121, 217, 118, 14);
		
		contentPane.add(error);
		error.setVisible(false);
		
		JButton login = new JButton("Login");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				username = username_input.getText();
				password = password_input.getText();
				
				boolean success = Accounts.login(username, password);
				
				if(success) {
					if(Read.getRole(username).equals("Employee")) {
						employee e = new employee();
						e.setVisible(true);
						dispose();
					}
					else if(Read.getRole(username).equals("Manager")) {
						manager m = new manager();
						m.setVisible(true);
						dispose();
					}
				}
				else {
					error.setVisible(true);
				}
				
			}
		});
				
		login.setBounds(111, 179, 89, 23);
		contentPane.add(login);
		
		JLabel register = new JLabel("Register");
		register.setBounds(10, 217, 64, 14);
		
		register.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				create c = new create();
				c.setVisible(true);
				dispose();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			
		});
		
		contentPane.add(register);
				
	}
}
