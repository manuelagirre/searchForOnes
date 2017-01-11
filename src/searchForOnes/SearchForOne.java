package searchForOnes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class SearchForOne {

	public static void main(String[] args) throws IOException {
		FileReader file = new FileReader ("input.txt");
		BufferedReader buf = new BufferedReader(file);
		String line = null;
		int startIndex = 0;
		int startIndexOld = 0;
		int finishIndex = 0;
		int finishIndexOld = 0;
		int numberOfOnes = 0;
		int numberOfOnesOld = 0;
		try {
			line = buf.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		char c[] = line.toCharArray();
		for (int i = 1; i < c.length; i++){
			if (c[i-1] == '0' && c[i] == '1'){
				//start of sequence
				startIndex = i;
				numberOfOnes++;
			} else if (c[i-1] == '1' && c[i] == '0'){
				// end of sequence
				finishIndex = i-1;
				if (numberOfOnesOld < numberOfOnes) {
					numberOfOnesOld = numberOfOnes;
					startIndexOld = startIndex;
					finishIndexOld = finishIndex;
				}
				numberOfOnes = 0;
				if (numberOfOnesOld > (c.length - i)) {
					PrintWriter p = new PrintWriter("output.txt");
					for (int j = startIndexOld; j < finishIndexOld+1; j++){
						p.write(c[j]);
					}
					p.close();
					return;
				}
			} else if (c[i-1] == '1' && c[i] == '1'){
				//sequence continues
				numberOfOnes++;
			} else if (c[i-1] == '0' && c[i] == '0'){
				//do nothing
			} else {
				System.out.println("Wrong data " + i);
			}
			
		}
		buf.close();
		PrintWriter p = new PrintWriter("output.txt");
		for (int i = startIndexOld; i < finishIndexOld+1; i++){
			p.write(c[i]);
		}
		p.close();
	}

}
