import javaed.javaed_1.Calc;
import javaed.javaed_1.StringEditor;
import javaed.javaed_2.Task2;
import javaed.javaed_2.Task2;
import javaed.javaed_3.House;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
        public static void main(String[] args) {

            House house=new House();

            house.setHeight(12);
            house.setWidth(12);
            house.setNumberWindows(2);
            System.out.println(house.getHeight()+" "+house.getWidth()+" "+house.getNumberWindows());
            System.out.println(house.calcArea()+" "+house.calcPerimeter()+" "+house.calcVolume());
            System.out.println(house.hashCode());

        }
        public static void printArray(List A){
            for(int i=0;i<A.size();i++)
                System.out.println(A.get(i));
        }



}
