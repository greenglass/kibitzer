package kibitzer.client;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.EmptyBorder;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = downloadHTML("http://world4.runescape.com/");
		System.out.println(test);
	}

	private static String downloadHTML(String address) {
        try {
            URL url = new URL(address);
            URLConnection conn = url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            //Firefox didn't set anything important that java didn't set by default, besides the useragent
            //this useragent is for your browser, modify at will
		    //conn.addRequestProperty("User-Agent",useragent == null ? USER_AGENT : useragent);
		    conn.connect();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder builder = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                builder.append(inputLine).append("\n");
            }
            in.close();
            return builder.toString();
        } catch (Exception e) {
            return null;
        }
    }
	
}
