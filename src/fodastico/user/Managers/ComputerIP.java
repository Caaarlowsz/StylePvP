package fodastico.user.Managers;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ComputerIP {
	public static byte[] computerip;

	public static void main(final String[] args) {
		try {
			final InetAddress ip = InetAddress.getLocalHost();
			System.out.println("Current IP address : " + ip.getHostAddress());
			final NetworkInterface network = NetworkInterface.getByInetAddress(ip);
			ComputerIP.computerip = network.getHardwareAddress();
			final byte[] mac = network.getHardwareAddress();
			System.out.print("Current MAC address : ");
			final StringBuilder sb = new StringBuilder();
			for (int i = 0; i < mac.length; ++i) {
				sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
			}
			System.out.println(sb.toString());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (SocketException e2) {
			e2.printStackTrace();
		}
	}
}
