import Time.IPAddress;
import Utils.GetMyIP;


public class Main {
    public static void main(String[] args)
    {
        System.out.println("Test");
        IPAddress test = new IPAddress();
        GetMyIP iipp = new GetMyIP();
        test.GetTimeByIPAddress(iipp.returnMyIP());
    }
}
