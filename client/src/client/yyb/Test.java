package client.yyb;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Test {

	public static void main(String[] args) {
		OutputStreamWriter osw =null;
		try {
			BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
			String text = buffer.readLine();
			osw = new OutputStreamWriter(new FileOutputStream("/Users/yubin/a"));
			osw.write(text);
			osw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				osw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	

	}

}
