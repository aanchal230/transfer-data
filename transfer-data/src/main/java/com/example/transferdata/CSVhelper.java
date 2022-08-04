package com.example.transferdata;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.Objects;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.QuoteMode;
import org.springframework.web.multipart.MultipartFile;

public class CSVhelper {
    public static String TYPE = "text/csv";
    static String[] HEADERs = { "internal_id", "to_id", "to_number", "fulfillment_date","fulfillment_id","fulfillment_number","line_unique_key","item","quantity","length(MM)","width(MM)","height(MM)","unit_weight","carton_weight","type" };
    private static Object user;

    public static boolean hasCSVFormat(MultipartFile file) {
        if (TYPE.equals(file.getContentType())
                ||  (file.getContentType()).equals("application/vnd.ms-excel")) {
            return true;
        }

        return false;
    }

//    for reading csv file data
    public static List<User> csvToTutorials(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim())) {

            List<User> userList = new ArrayList();
//            userList.removeAll(Collections.singletonList(null));

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                User user1 = new User(
                        Long.parseLong(csvRecord.get("internal_id")),
                        Integer.parseInt(csvRecord.get("to_id")),
                        Integer.parseInt(csvRecord.get("to_number")),
                        csvRecord.get("fulfillment_date"),
                        Integer.parseInt(csvRecord.get("fulfillment_id")),
                        Integer.parseInt(csvRecord.get("fulfillment_number")),
                        Integer.parseInt(csvRecord.get("line_unique_key")),
                        csvRecord.get("item"),
                        Integer.parseInt(csvRecord.get("quantity")),
                        Integer.parseInt(csvRecord.get("length(MM)")),
                        Integer.parseInt(csvRecord.get("width(MM)")),
                        Integer.parseInt(csvRecord.get("height(MM)")),
                        Double.parseDouble(csvRecord.get("unit_weight")),
                        Double.parseDouble(csvRecord.get("carton_weight")),
                        csvRecord.get("type")
                );
                userList.add(user1);
            }

            return userList;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }
//    used to write the data in the csv file
    public static ByteArrayInputStream dataToCSV(List<User> userList) {
        final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
             CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
            for (User user1 : userList) {
                List<? extends Serializable> data = Arrays.asList(
                        String.valueOf(user1.getInternal_id()),
                        String.valueOf(user1.getTo_id()),
                        String.valueOf(user1.getTo_number()),
                        user1.getFulfillment_date(),
                        String.valueOf(user1.getFulfillment_id()),
                        String.valueOf(user1.getFulfillment_number()),
                        String.valueOf(user1.getLine_unique_key()),
                        user1.getItem(),
                        String.valueOf(user1.getQuantity()),
                        String.valueOf(user1.getLength()),
                        String.valueOf(user1.getWidth()),
                        String.valueOf(user1.getHeight()),
                        user1.getUnit_weight(),
                        String.valueOf(user1.getCarton_weight()),
                        user1.getType()

                );

                csvPrinter.printRecord(data);
            }

            csvPrinter.flush();
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
        }
    }
}

