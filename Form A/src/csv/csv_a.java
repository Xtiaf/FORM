package csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class csv_a {

    public static void main(String[] args) throws IOException {
        // Create a BufferedReader to read the CSV file
        BufferedReader reader = new BufferedReader(new FileReader("K:\\csv.txt"));

        // Create a List to store the parsed CSV data
        List<List<String>> csvData = new ArrayList<>();

        // Read each line of the CSV file
        String line;
        while ((line = reader.readLine()) != null) {
            // Split the line into tokens using the comma delimiter
            String[] tokens = line.split(",");

            // Create a new List to store the tokens for this line
            List<String> rowData = new ArrayList<>();

            // Add each token to the rowData List
            for (String token : tokens) {
                rowData.add(token);
            }

            // Add the rowData List to the csvData List
            csvData.add(rowData);
        }

        // Close the BufferedReader
        reader.close();

        // Process the CSV data here

        // For example, you could print the CSV data to the console:
        for (List<String> rowData : csvData) {
            for (String token : rowData) {
                System.out.print(token + ",");
            }
            System.out.println();
        }
    }
}