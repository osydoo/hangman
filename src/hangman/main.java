package hangman;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.ArrayList;

public class main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("./resource/words.txt"));
		String s = br.readLine();
		ArrayList<String> list = new ArrayList<>();
		while(s != null) {
			list.add(s);
			s = br.readLine();
		}
		new Hpanel(list);
		br.close();
	}

}
