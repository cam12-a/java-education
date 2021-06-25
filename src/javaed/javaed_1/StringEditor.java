package javaed.javaed_1;
import java.util.Locale;
public class StringEditor {

    public static String toChangeCase(String inputString, String Case,int start,int end){
        StringBuilder mysubstr=new StringBuilder(inputString);
        if(!"UpperCase".equals(Case) && !"LowerCase".equals(Case) )
            return "Входящие параметры не правильны";
        else {
            if (start > end)
                return "Входящие параметры не правильны";
            else {
                // String mysubstr;
                end=end==inputString.length()?inputString.length():end;
                end=end+1>inputString.length()?inputString.length():end+1;
                if (Case == "LowerCase")
                    mysubstr=mysubstr.replace(start,end, mysubstr.substring(start,end).toLowerCase());
                if (Case == "UpperCase")
                    mysubstr=mysubstr.replace(start,end, mysubstr.substring(start,end).toUpperCase());

            }
        }
        return mysubstr.toString();
    }
}

