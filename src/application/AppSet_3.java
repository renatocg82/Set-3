package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

import entities.LogEntry;

public class AppSet_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Locale.setDefault(Locale.US);
		Scanner scStr = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter file full path: ");
		String path = sc.nextLine();
		Set<LogEntry> logEntrSet = new HashSet<>();
		
		
		try (FileReader fr = new FileReader(path) ; BufferedReader br = new BufferedReader(fr)){
			
			String line = br.readLine();
			
			while(line != null) {
				String[] fields = line.split(" ");
				String tempName = fields[0];
				Date tempDate = Date.from(Instant.parse(fields[1])); // Date.from(Instant inst) - returns a date representing the same point on the timeline as the passing instant.
				logEntrSet.add(new LogEntry(tempName, tempDate));
				
				line = br.readLine();
			}
			
			System.out.println("Total users: " + logEntrSet.size());
			
	
		} catch (FileNotFoundException e) {
			
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {

			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
		
	}

}
