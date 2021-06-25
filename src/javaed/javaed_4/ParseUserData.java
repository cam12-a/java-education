import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.jshell.execution.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;


public class ParseUserData {
    public static void main(String [] args) throws JsonProcessingException {
        PersonCrow personCrow=new PersonCrow();
        personCrow.countItems();
        personCrow.SortByAge();
    }


}

