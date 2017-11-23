import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class GUI {
	private JFrame frame;
	private JPanel panel;
	private GridBagConstraints c = new GridBagConstraints();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setResizable(false);
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
		setFrame();
		setHeader();
		setInputField();
	}
	private void setFrame() {
		frame = new JFrame();
		frame.setBounds(100, 100, 640, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		panel.setBackground(Color.BLACK);
		frame.add(panel);
	}
	private void setHeader() {
		JLabel lblHeader = new JLabel("");
		lblHeader.setIcon(new ImageIcon("src/header.jpg"));
		c.gridx = 1;
		c.gridy = 1;
		c.weightx = 0;
		c.weighty = 0.3;
		c.fill = GridBagConstraints.HORIZONTAL;
		panel.add(lblHeader,c);
	}
	private void setInputField() {
		JPanel inputPanel = new JPanel();
		inputPanel.setOpaque(false);
		inputPanel.setLayout(new GridLayout(7, 2, 0, 0));
		c.gridx = 1;
		c.gridy = 2;
		c.weightx = 1;
		c.weighty = 0.6;
		c.fill = GridBagConstraints.BOTH;
		panel.add(inputPanel,c);

		JLabel lblSubnetMask = new JLabel("Subnet Mask    ");
		lblSubnetMask.setHorizontalAlignment(JLabel.RIGHT);
		lblSubnetMask.setFont(new Font("Arial", Font.BOLD, 18));
		lblSubnetMask.setForeground(Color.WHITE);
		inputPanel.add(lblSubnetMask);

		JTextField txtSubnetMask = new JTextField();
		txtSubnetMask.setFont(new Font("Arial", Font.BOLD, 18));
		inputPanel.add(txtSubnetMask);

		JLabel lblDefaultGateway = new JLabel("Default Gateway    ");
		lblDefaultGateway.setHorizontalAlignment(JLabel.RIGHT);
		lblDefaultGateway.setFont(new Font("Arial", Font.BOLD, 18));
		lblDefaultGateway.setForeground(Color.WHITE);
		inputPanel.add(lblDefaultGateway);

		JTextField txtDefaultGateway = new JTextField();
		txtDefaultGateway.setFont(new Font("Arial", Font.BOLD, 18));
		inputPanel.add(txtDefaultGateway);

		JLabel lblStartIp = new JLabel("Start IP    ");
		lblStartIp.setHorizontalAlignment(JLabel.RIGHT);
		lblStartIp.setFont(new Font("Arial", Font.BOLD, 18));
		lblStartIp.setForeground(Color.WHITE);
		inputPanel.add(lblStartIp);

		JTextField txtStartIp = new JTextField();
		txtStartIp.setFont(new Font("Arial", Font.BOLD, 18));
		inputPanel.add(txtStartIp);

		JLabel lblLimit = new JLabel("Limit    ");
		lblLimit.setHorizontalAlignment(JLabel.RIGHT);
		lblLimit.setFont(new Font("Arial", Font.BOLD, 18));
		lblLimit.setForeground(Color.WHITE);
		inputPanel.add(lblLimit);

		JTextField txtLimit = new JTextField();
		txtLimit.setFont(new Font("Arial", Font.BOLD, 18));
		inputPanel.add(txtLimit);

		JLabel lblRetry = new JLabel("Retry    ");
		lblRetry.setHorizontalAlignment(JLabel.RIGHT);
		lblRetry.setFont(new Font("Arial", Font.BOLD, 18));
		lblRetry.setForeground(Color.WHITE);
		inputPanel.add(lblRetry);

		JTextField txtRetry = new JTextField();
		txtRetry.setFont(new Font("Arial", Font.BOLD, 18));
		inputPanel.add(txtRetry);

		JLabel lblMaxthread = new JLabel("Max Thread    ");
		lblMaxthread.setHorizontalAlignment(JLabel.RIGHT);
		lblMaxthread.setFont(new Font("Arial", Font.BOLD, 18));
		lblMaxthread.setForeground(Color.WHITE);
		inputPanel.add(lblMaxthread);

		JTextField txtMaxthread = new JTextField();
		txtMaxthread.setFont(new Font("Arial", Font.BOLD, 18));
		inputPanel.add(txtMaxthread);

		JLabel lblFilename = new JLabel("Output File Name    ");
		lblFilename.setHorizontalAlignment(JLabel.RIGHT);
		lblFilename.setFont(new Font("Arial", Font.BOLD, 18));
		lblFilename.setForeground(Color.WHITE);
		inputPanel.add(lblFilename);

		JTextField txtFilename = new JTextField();
		txtFilename.setFont(new Font("Arial", Font.BOLD, 18));
		inputPanel.add(txtFilename);
		
		JButton btnScan = new JButton("");
		btnScan.setIcon(new ImageIcon("src/scanbtn.jpg"));
		btnScan.setContentAreaFilled(false);
		btnScan.setBorderPainted(false);
		btnScan.setPreferredSize(new Dimension(300,50));
		btnScan.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Executer executer = new Executer(txtSubnetMask.getText(),
						txtDefaultGateway.getText(), txtStartIp.getText(),
						txtLimit.getText(), txtRetry.getText(), txtMaxthread
								.getText(), txtFilename.getText());
				executer.run();
			}
		});
		c.gridx = 1;
		c.gridy = 3;
		c.weighty = 0.2;
		c.weightx = 1;
		c.fill = GridBagConstraints.BOTH;
		panel.add(btnScan,c);
	}
}
