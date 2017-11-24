import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Display {

	private JFrame frame;
	private JPanel panel;
	private GridBagConstraints c = new GridBagConstraints();
	private String filename;

	/**
	 * Create the application.
	 */
	public Display(String filename) {
		this.filename = filename;
		initialize();
	}

	public void run() {
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame();
		setheader();
		setList();
	}

	private void setFrame() {
		frame = new JFrame();
		frame.setBounds(100, 100, 640, 480);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		JScrollPane scrollPanel = new JScrollPane(panel);
		frame.add(scrollPanel);
	}

	private void setheader() {
		JLabel lblIp = new JLabel("IP");
		lblIp.setFont(new Font("Arial", Font.BOLD, 18));
		lblIp.setHorizontalAlignment(JLabel.CENTER);
		lblIp.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		c.gridx = 1;
		c.gridy = 1;
		c.weightx = 0.33;
		c.weighty = 0.2;
		c.fill = GridBagConstraints.BOTH;
		panel.add(lblIp, c);

		JLabel lblMacaddress = new JLabel("MAC Address");
		lblMacaddress.setFont(new Font("Arial", Font.BOLD, 18));
		lblMacaddress.setHorizontalAlignment(JLabel.CENTER);
		lblMacaddress.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		c.gridx = 2;
		c.gridy = 1;
		c.weightx = 0.33;
		c.weighty = 0.2;
		c.fill = GridBagConstraints.BOTH;
		panel.add(lblMacaddress, c);

		JLabel lblManufacturer = new JLabel("Manufacturer");
		lblManufacturer.setFont(new Font("Arial", Font.BOLD, 18));
		lblManufacturer.setHorizontalAlignment(JLabel.CENTER);
		lblManufacturer.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		c.gridx = 3;
		c.gridy = 1;
		c.weightx = 0.33;
		c.weighty = 0.2;
		c.fill = GridBagConstraints.BOTH;
		panel.add(lblManufacturer, c);

	}

	private void setList() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(
					"pythonsrc/" + filename + ".csv"));
			String line = reader.readLine();
			line = reader.readLine();
			for (int i = 1; line != null; i++) {
				String[] split = line.split(",");
				JLabel append;
				for (int j = 0; j < split.length; j++) {
					String currtxt = "";
					if (j == 2) {
						currtxt = "";
						while (j < split.length) {
							currtxt += split[j];
							if(j<split.length-1)
								currtxt+=",";
							j++;
						}
					} else {
						currtxt = split[j];
					}
					append = new JLabel("    " + currtxt);
					append.setFont(new Font("Arial", Font.PLAIN, 16));
					append.setBorder(BorderFactory
							.createLineBorder(Color.BLACK));
					if (j<2)
						c.gridx = j + 1;
					else
						c.gridx = 3;
					c.gridy = i + 1;
					c.weightx = 0.33;
					c.weighty = 0.5;
					c.fill = GridBagConstraints.BOTH;
					panel.add(append, c);
				}
				line = reader.readLine();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
