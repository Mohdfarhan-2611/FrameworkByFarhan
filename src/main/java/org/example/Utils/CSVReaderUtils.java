package org.example.Utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.example.POJO.LoginQKartUser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CSVReaderUtils {

    private static final String CSV_FILE_PATH = System.getProperty("user.dir")+"/src/main/resources/LoginDataQKart.csv";


    public static Iterator<LoginQKartUser> readDatafromcsv() throws CsvValidationException {
        File csvFilePath;
        FileReader fileReader;
        CSVReader csvReader;
        String[] line;
        List<LoginQKartUser> userslist= new ArrayList<LoginQKartUser>();
        LoginQKartUser usersdata;

        try {
        csvFilePath = new File(CSV_FILE_PATH);
        fileReader = new FileReader(csvFilePath);
        csvReader = new CSVReader(fileReader);
        csvReader.readNext();   //Skips first row
        while ((line= csvReader.readNext())!=null)
        {
            usersdata = new LoginQKartUser(line[0], line[1], line[2], line[3]);
            userslist.add(usersdata);
        }
    } catch (IOException e) {
        throw new RuntimeException(e);
    } catch (CsvValidationException e) {
        throw new RuntimeException(e);
    }

   return userslist.iterator();

}




}
