package org.example.DataProvider;

import com.opencsv.exceptions.CsvValidationException;
import org.example.POJO.LoginQKartUser;
import org.example.Pages.Qkart.LoginQKartPage;
import org.example.Utils.CSVReaderUtils;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.util.Iterator;

public class DataProviderGetData {


    @DataProvider(name="LOGINDATAFROMCSVFILE")
    public static Iterator<LoginQKartUser> getLoginDatafromCSV() throws FileNotFoundException, CsvValidationException {
        return CSVReaderUtils.readDatafromcsv();
    }


}
