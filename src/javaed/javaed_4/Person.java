import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class Person {
    protected String lastName;
    protected String name;
    protected String gender;
    protected String dateBirth;
    protected int age;
    public Person parseJSON(JSONObject myrequest, JSONArray JSONarray){

        for (int i = 0; i < JSONarray.length(); i++)
        {
            this.lastName=JSONarray.getJSONObject(i).getJSONObject("name").getString("last");
            this.name=JSONarray.getJSONObject(i).getJSONObject("name").getString("first");
            this.dateBirth=JSONarray.getJSONObject(i).getJSONObject("dob").getString("date").substring(0,10);
            this.age=Integer.parseInt(JSONarray.getJSONObject(i).getJSONObject("dob").get("age").toString()   );
            this.gender=JSONarray.getJSONObject(i).getString("gender");

        }
        return this;
    }


}
