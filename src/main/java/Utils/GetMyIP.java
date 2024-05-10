package Utils;

import java.net.*;
import java.util.Enumeration;
import java.util.regex.*;

public class GetMyIP {
public String returnMyIP() {
    String myAddress = "0.0.0.0";
    try {
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
        while (interfaces.hasMoreElements()) {
            NetworkInterface iface = interfaces.nextElement();
            if (iface.isLoopback() || !iface.isUp()) continue;
            Enumeration<InetAddress> addresses = iface.getInetAddresses();
            while (addresses.hasMoreElements()) {
                InetAddress addr = addresses.nextElement();

                if (isValidIPAddress(addr.getHostAddress())) {
                    System.out.println(iface.getDisplayName() + " " + addr.getHostAddress());
                    myAddress = addr.getHostAddress();
                }
            }
        }
    } catch (SocketException e) {
        throw new RuntimeException(e);
    }

    return myAddress;
}

public static boolean isValidIPAddress(String ip) {
    String zeroTo255 = "(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])";
    String regex = zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255;

    Pattern p = Pattern.compile(regex);
    if (ip == null) {
        return false;
    }

    Matcher m = p.matcher(ip);
    return m.matches();
}
}
