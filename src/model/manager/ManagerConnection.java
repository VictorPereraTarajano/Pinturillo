package model.manager;

import model.net.receiver.impl.TCPReceiver;
import model.net.receiver.interfaces.Receiver;
import model.net.sender.impl.TCPSender;
import model.net.sender.impl.UDPSender;
import model.net.sender.interfaces.Sender;
import model.player.Player;
import sun.net.util.IPAddressUtil;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ManagerConnection {

    public static final String DefaultIP= getDefaultIP();

    public static final int UDPort = 2000;
    public static final int TCPort = 2000;
    public static Receiver UDPreceiver;
    public static Receiver TCPreceiver;

    private static String getDefaultIP() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            return null;
        }
    }

    public static String getStatus () {
        if (UDPreceiver != null || TCPreceiver != null)
            return "CONNECTED";
        return "DISCONNECTED";
    }

    public static Sender []  TCPBroadcast (Player[] players) {
        Sender[] senders = new Sender[players.length];
        for (int i = 0; i < senders.length; i++)
            senders[i] = new TCPSender(players[i].getIp());
        return senders;
    }

    public static Sender []  UDPBroadcast (Player[] players) {
        Sender[] senders = new Sender[players.length];
        for (int i = 0; i < senders.length; i++)
            senders[i] = new UDPSender(players[i].getIp());
        return senders;
    }

    public static boolean isValidConnection (String IP) {
        return IPAddressUtil.isIPv4LiteralAddress(IP);
    }
}
