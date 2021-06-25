import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.function.ToIntFunction;

public class PersonCrow {
    protected int n;
    protected List<Person> arrayPerson;

    public PersonCrow(){
        this.arrayPerson= new ArrayList<Person>(100);
    }
    public List<Person> generePerson() {
        this.arrayPerson=new ArrayList<Person>(100);
        for (int i = 0; i < 100; i++) {
            Person person = new Person();
            JSONObject myrequest = this.senHTTPRequest("https://randomuser.me/api");
            JSONArray myJSONArray = this.JSONarray(myrequest);
            this.arrayPerson.add(person.parseJSON(myrequest, myJSONArray));

        }

        return this.arrayPerson;
    }

    public void showGeneratedPerson() {
        List<Person> a = this.generePerson();
        for (int i = 0; i < a.size(); i++) {
            System.out.println("lastName " + a.get(i).lastName + " Name " + a.get(i).name + " Gender " + a.get(i).gender + " DateBirth " + a.get(i).dateBirth + " age " + a.get(i).age);

        }
    }


    private JSONArray JSONarray(JSONObject a) {
        return a.getJSONArray("results");
    }

    public void countItems() {
        List<Person> p = this.generePerson();
        int man = 0;
        int woman = 0;
        this.showGeneratedPerson();
        for (int i = 0; i < p.size(); i++) {
            if (p.get(i).gender.equals("female"))
                woman++;
            else
                man++;
        }
        System.out.println("There are " + man + " man and " + woman + " woman");
    }

    private JSONObject senHTTPRequest(String urlToSend) {
        StringBuffer response = new StringBuffer();
        try {
            URL obj = new URL(urlToSend);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            JSONObject myResponse = new JSONObject(response.toString());

        } catch (Exception ex) {
            ex.getMessage();
        }
        return new JSONObject(response.toString());
    }
    public void SortByAge(){

        List<Person> list = this.generePerson();
        Comparator<Person> comparator = new Comparator<Person>() {
            @Override
            public int compare(Person a, Person b) {
                return a.age - b.age; // use your logic
            }
        };

        Collections.sort(list, comparator); // use the comparator as much as u want
        for(int i=0;i<list.size();i++)
            System.out.println("lastName " + list.get(i).lastName + " Name " + list.get(i).name + " Gender " + list.get(i).gender + " DateBirth " + list.get(i).dateBirth + " age " + list.get(i).age);

    }

}



