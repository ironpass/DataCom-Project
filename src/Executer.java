import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.util.concurrent.TimeUnit;

public class Executer implements Runnable {
	private String cmd = "cmd.exe /c cd pythonsrc";
	private String filename;

	public Executer(String subnetMask, String defaultGateway, String startIp,
			String limit, String retry, String maxthread, String filename) {
		// Command for execution
		cmd += " && start python main.py " + subnetMask + " " + defaultGateway
				+ " " + startIp + " " + limit + " " + retry + " " + maxthread
				+ " " + filename;
		this.filename = filename;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			System.out.println("Executing: " + cmd);
			Runtime.getRuntime().exec(cmd);
			File f = new File("pythonsrc/" + filename + ".csv");
			while (!f.exists()) {
				TimeUnit.SECONDS.sleep(3);
				System.out.println("Now Loading...");
			}
			System.out.println("Done!");

			Display display = new Display(filename);
			display.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
