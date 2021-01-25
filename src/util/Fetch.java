package util;

import java.io.BufferedReader;
import java.io.IOException;

public class Fetch {
	public static final String readBody(BufferedReader reader) {
		String body = "";
		String linea;
		try {
			while((linea = reader.readLine()) != null) {
				body += linea;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return body;
	}
}
