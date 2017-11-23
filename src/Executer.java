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
	private String cmd = "cmd.exe /c cd pythonsrc" ;
	private String filename;

	public Executer(String subnetMask, String defaultGateway, String startIp,
			String limit, String retry, String maxthread, String filename) {
		// Command for execution
		cmd += " && python main.py " + subnetMask + " " + defaultGateway + " "
				+ startIp + " " + limit + " " + retry + " " + maxthread + " "
				+ filename;
		this.filename = filename;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			System.out.println("Executing: " + cmd);
			Process p = Runtime.getRuntime().exec(cmd);
			File f = new File("pythonsrc/"+filename+".csv");
			while (!f.exists()) {
				p.waitFor(1,TimeUnit.SECONDS);
				System.out.println("Now Loading...");
			}
			
			Display display = new Display(filename);
			display.run();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
