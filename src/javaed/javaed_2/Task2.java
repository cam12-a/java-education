package javaed.javaed_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Task2 {
    protected List Names= new ArrayList(10);
    protected List manNames=new ArrayList(1000);
    protected List womanNames=new ArrayList(1000);
    protected List  A=new ArrayList(10);
    protected List  B=new ArrayList(10);
    protected List  C=new ArrayList(10);
    protected List  D=new ArrayList(10);


    protected Random r=new Random();
    public Task2()
    {
        Names.add("Арсений");
        Names.add("Артем");
        Names.add("Андриан");
        Names.add("Азарий");
        Names.add("Андрей");

        Names.add("Александр");
        Names.add("Амос");
        Names.add("Анатолий");
        Names.add("Ананий");
        Names.add("Аркадий");

        Names.add("Арина");
        Names.add("Анна");
        Names.add("Анастасия");
        Names.add("Алиса");
        Names.add("Виктория");

        Names.add("Ангелина");
        Names.add("Алисия");
        Names.add("Аманда");
        Names.add("Асель");
        Names.add("Гузаль ");


        for(int i=0;i<1000;i++) {
            this.manNames.add(this.Names.get(this.r.nextInt(9)));
            this.womanNames.add(this.Names.get(this.r.nextInt(10)+10));
        }
        for (int i=0;i<10;i++) {
            this.A.add(this.getManNames().get(r.nextInt(i + 1)));
            this.B.add(this.getWomanNames().get(r.nextInt(i + 1)));
            this.C.add(this.getManNames().get(r.nextInt(i + 1)));
            this.D.add(this.getWomanNames().get(r.nextInt(i + 1)));
        }
        this.A.set(1,"Alseny");
        this.B.set(5,"Alseny");
    }

    public List getA(){
        return this.A;
    }
    public List getB(){
        return this.B;
    }
    public List getC(){
        return this.C;
    }
    public List getD(){
        return this.D;
    }
    public List getManNames(){
        return this.manNames;
    }
    public  List getWomanNames(){ return  this.womanNames; }


    public List alternName(int n){
        List alterne= new ArrayList(n);
        for(int i=1;i<=n;i++){
            if(i%2==0)
                alterne.add(this.manNames.get(i));
            else
                alterne.add(this.womanNames.get(i));
        }
        return alterne;
    }

    public List InitTwoArray(){

        this.A.retainAll(this.B);
        return this.A.stream().toList();
    }



    public List isNotInArray(){
        List list=new ArrayList(10);

        for(int i=0;i<this.C.size();i++){
            if(!D.contains(this.C.get(i))){
                list.add(this.C.get(i));
            }
        }
        return list;
    }


}
