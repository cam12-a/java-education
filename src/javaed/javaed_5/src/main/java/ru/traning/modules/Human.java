package ru.traning.modules;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Human {
    private String first_name;
    private String last_name;
    private int gender;
    private String date_birth;
    private int age;

    public Human(){};
    public Human(String first_name,String last_name,int gender, String date_birth, int age) {
        this.age=age;
        this.date_birth=date_birth;
        this.first_name=first_name;
        this.gender=gender;
        this.last_name=last_name;
    }

    public int getAge() {
        return age;
    }



    public String getFirst_name() {
        return first_name;
    }

    public String getDate_birth() {
        return date_birth;
    }

    public int getGender() {
        return gender;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDate_birth(String date_birth) {
        this.date_birth = date_birth;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    @Override
    public String toString() {
        return "Human{" +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", gender='" + gender + '\'' +
                ", date_birth='" + date_birth + '\'' +
                ", age=" + age + '\''+

                '}';
    }
}
