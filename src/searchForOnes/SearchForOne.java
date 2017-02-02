package searchForOnes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class SearchForOne {

	public static void main(String[] args) throws IOException {
		//open the file with the input data
		FileReader file = new FileReader ("input.txt");
		BufferedReader buf = new BufferedReader(file);
		String line = null;
		try {
			line = buf.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//close the resource
		buf.close();
		char c[] = line.toCharArray();
		//main method to search for the number of longest "1" sequence
		char toFind = '1';
		int answer = getLongestSequenceOfChar(c, toFind);
		System.out.println("Longest " + "\'" + toFind + "\'" + " sequence is " + answer);
	}
	private static int getLongestSequenceOfChar(char[] c, char toFind) throws FileNotFoundException{
		int out = 0;
		int current = 0;
		//start to find the start and finish index of the sequence
		for (int i = 0; i < c.length; i++){
			if (c[i] == toFind) {
				current++;
			} else {
				if (out < current){
					out = current;
					current = 0;
				} else {
					current = 0;
				}
			}
		}
		//write the answer to the file
		PrintWriter p = new PrintWriter("output.txt");
		p.write("Longest " + "\'" + toFind + "\'" + " sequence is " + out);
		p.close();
		return out;
	}

}
