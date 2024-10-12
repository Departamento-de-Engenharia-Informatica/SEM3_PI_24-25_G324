package prodPlanSimulator.utils;

import prodPlanSimulator.models.ItemModel;
import prodPlanSimulator.models.MachineModel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class CSVParser {

    /**
     * Parse a CSV file into a list of ItemModel or MachineModel objects
     *
     * @param path The path to the CSV file
     * @return A list of ItemModel or MachineModel objects
     * @throws IOException If an error occurs while reading the file
     */
    public Object parseCSV(String path) throws IOException {
        if (!path.endsWith(".csv")) {
            throw new IllegalArgumentException("Invalid file format. Please use a CSV file.");
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String headerLine = reader.readLine(); // Read the header
            while (headerLine == null) {
                throw new IllegalArgumentException("The CSV file is empty.");
            }


            String[] headers = headerLine.split(",");
            // Check if the CSV file has enough columns
            if (headers.length < 3) {
                throw new IllegalArgumentException("Invalid CSV format. Not enough columns.");
            }

            // Check if the file is an item or machine CSV
            if (isItemCSV(headers)) {
                return parseItems(reader);
            } else if (isMachineCSV(headers)) {
                return parseMachines(reader);
            } else {
                throw new IllegalArgumentException("Unrecognized CSV format.");
            }
        } catch (IOException e) {
            System.err.println("Error reading the csv file: " + e.getMessage());
            throw e;
        }
    }


    /**
     * Check if the CSV file is an item CSV
     *
     * @param headers The headers of the CSV file
     * @return True if the CSV file is an item CSV, false otherwise
     */
    private boolean isItemCSV(String[] headers) {
        return headers[0].equals("code") && headers[1].equals("name") && headers[2].equals("description") && headers[3].equals("price") && headers[4].equals("productionTime") && headers[5].equals("machine") && headers[6].equals("quantity");
    }

    /**
     * Check if the CSV file is a machine CSV
     *
     * @param headers The headers of the CSV file
     * @return True if the CSV file is a machine CSV, false otherwise
     */
    private boolean isMachineCSV(String[] headers) {
        return headers[0].equals("name") && headers[1].equals("model") && headers[2].equals("year");
    }

    /**
     * Parse a list of ItemModel objects from a CSV file
     *
     * @param reader The BufferedReader to read the CSV file
     * @return A list of ItemModel objects
     * @throws IOException If an error occurs while reading the file
     */
    private List<ItemModel> parseItems(BufferedReader reader) throws IOException {
        List<ItemModel> items = new LinkedList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            String[] values = line.split(",");
            // Check if the line has the correct number of columns
            if (values.length != 7) {
                System.out.println("Invalid CSV format in line: " + line);
                continue;
            }
            ItemModel item = new ItemModel(values[0], values[1], values[2], Double.parseDouble(values[3]), Integer.parseInt(values[4]), null, Integer.parseInt(values[6]));
            items.add(item);
        }
        return items;
    }

    /**
     * Parse a list of MachineModel objects from a CSV file
     *
     * @param reader The BufferedReader to read the CSV file
     * @return A list of MachineModel objects
     * @throws IOException If an error occurs while reading the file
     */
    private List<MachineModel> parseMachines(BufferedReader reader) throws IOException {
        List<MachineModel> machines = new LinkedList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            String[] values = line.split(",");
            // Check if the line has the correct number of values
            if (values.length != 3) {
                System.out.println("Invalid CSV format in line: " + line);
                continue;
            }
            MachineModel machine = new MachineModel(values[0], values[1], Integer.parseInt(values[2]));
            machines.add(machine);
        }
        return machines;
    }
}
