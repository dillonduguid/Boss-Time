package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import files.Read;
import timedata.Calendar;

import timedata.Calendar;

import javax.swing.JTextArea;
import javax.swing.JLabel;

public class manager extends JFrame {

	private JPanel contentPane;

	private static manager frame;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new manager();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public manager() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton logOut = new JButton("Log out");
		logOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login l = new login();
				l.setVisible(true);
				dispose();
			}
		});
		
		contentPane.setLayout(null);
		logOut.setBounds(635, 342, 89, 23);
		contentPane.add(logOut);
		
		JTextArea output = new JTextArea();
		output.setBounds(38, 51, 587, 314);
		contentPane.add(output);
		output.setVisible(true);
		
		JLabel username_label = new JLabel("Username: " + login.username);
		username_label.setBounds(38, 24, 116, 14);
		contentPane.add(username_label);
		
		JLabel role_label = new JLabel("Role: " + Read.getRole(login.username));
		role_label.setBounds(176, 24, 104, 14);
		contentPane.add(role_label);
		
		JButton clock_button = new JButton("Clock ");
		clock_button.setBounds(635, 52, 89, 23);
		clock_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calendar.clock();
			}
		});
		
		contentPane.add(clock_button);
		
	}
}
