import java.io.IOException;

public class Executer implements Runnable {
	private String cmd = "cmd.exe /c cd pythonsrc && start " ;

	public Executer(String subnetMask, String defaultGateway, String startIp,
			String limit, String retry, String maxthread, String filename) {
		// Command for execution
		cmd += "python main.py " + subnetMask + " " + defaultGateway + " "
				+ startIp + " " + limit + " " + retry + " " + maxthread + " "
				+ filename;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			System.out.println("Executing...");
			Process p = Runtime.getRuntime().exec(cmd);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
