package io.pepstore.swagger.utils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class Data {
    private  static ArrayList<Map<String, String>> dataUrl= new ArrayList<>();
    private  static ArrayList<Map<String, String>> dataPost= new ArrayList<>();
    private  static ArrayList<Map<String, String>> dataPut= new ArrayList<>();

    public static ArrayList<Map<String, String>> extractURL(){
        try {
            dataUrl= Excel.leerDatosDeHojaDeExcel("src/main/resources/UserDataExcel/ApiUserData.xlsx","URL_Server");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return dataUrl;
    }
    public static ArrayList<Map<String, String>> extractPost(){
        try {
            dataPost= Excel.leerDatosDeHojaDeExcel("src/main/resources/UserDataExcel/ApiUserData.xlsx","PostUserData");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return dataPost;
    }
    public static ArrayList<Map<String, String>> extractPut(){
        try {
            dataPut= Excel.leerDatosDeHojaDeExcel("src/main/resources/UserDataExcel/ApiUserData.xlsx","PutUserData");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return dataPut;
    }
}
