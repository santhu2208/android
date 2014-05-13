package client.yyb;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;


public class TcpClient {

	public static void main(String[] args) {
		try {
			Socket socket =new Socket("10.0.2.2",4567);
		    InputStream is =new FileInputStream("/Users/yubin/a");
			OutputStream os = socket.getOutputStream();
			byte[] b=new byte[1024*4];
			int temp;
			while ((temp=is.read(b))!=-1) {
				os.write(b,0,temp);
			}
	
//			BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
//			String text = buffer.readLine();
//			os.write(text.getBytes());
			os.flush();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
