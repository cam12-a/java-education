package ru.traning.modules;

import com.sun.tools.jconsole.JConsoleContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import ru.traning.Dao.HumanDao;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.Period;

import java.util.*;


public  class HumanCrowd implements HumanDao {
    protected  List<Human> humanCrowd=new ArrayList<Human>();

    @Override
    public String addHuman(Human human) {
        if(this.requeriedFields(human))
            return "Все поле обязательны кроме поля age";

        if(this.checkGender(human))
            return "неправильное значение Gender";
        this.calculAge(human);
        if(!this.humanExist(human)) {
            this.humanCrowd.add(human);
            System.out.println("no if "+this.humanExist(human));
        }
        else
        {
            System.out.println("true else "+this.humanExist(human));
            return "Human с именни "+human.getFirst_name()
                    +" , фамилией "+human.getLast_name()+" и датой рождения "+human.getDate_birth()+" уже существует ";
        }
        return null;
    }
    @Override
    public List<Human> findAll() {
        return this.humanCrowd;
    }
    @Override
    public Object findById(int id) {
        try {
            return this.humanCrowd.get(id);
        }catch (IndexOutOfBoundsException ex)
        {
            return "Human c "+id+" не существует";
        }
    }

    @Override
    public String changeHumanInfo(int id, Human human) {
        if(this.requeriedFields(human))
            return "Все поле обязательны кроме поля age";

        if(this.checkGender(human))
            return "неправильное значение Gender";
        this.calculAge(human);
        if(!this.humanExist(human)) {

            if(!this.humanExist(id,human)) {
                try {
                    this.humanCrowd.get(id).setAge(human.getAge());
                    this.humanCrowd.get(id).setDate_birth(human.getDate_birth());
                    this.humanCrowd.get(id).setGender(human.getGender());
                    this.humanCrowd.get(id).setFirst_name(human.getFirst_name());
                    this.humanCrowd.get(id).setLast_name(human.getLast_name());
                }catch (IndexOutOfBoundsException ex){
                    return "Human c "+id+" не существует";
                }
            }
            else{
                return "Нельзя добавить human которого не существует ";
            }

        }
        else
        {
            return "Human с именни "+human.getFirst_name()
                    +" , фамилией "+human.getLast_name()+" и датой рождения "+human.getDate_birth()+" уже существует ";
        }

        return null;
    }

    @Override
    public boolean humanExist(int id,Human human) {
        try {
            if (this.humanCrowd.get(id).getAge() == human.getAge() && this.humanCrowd.get(id).getFirst_name().equals(human.getFirst_name()) && this.humanCrowd.get(id).getLast_name().equals(human.getLast_name()) && this.humanCrowd.get(id).getDate_birth().equals(human.getDate_birth()) && this.humanCrowd.get(id).getGender() == human.getGender())
                return true;
            else
                return false;
        }catch (IndexOutOfBoundsException ex){
            return false;
        }
    }
    public void calculAge(Human human){
        String[] parseDate=human.getDate_birth().split("\\.");
       //System.out.println(human.getDate_birth()+" "+Arrays.toString(parseDate));

        LocalDate birthdate=LocalDate.of(Integer.parseInt(parseDate[2]),Integer.parseInt(parseDate[1]),Integer.parseInt(parseDate[0]));
       LocalDate currentdate =  LocalDate.now();
       human.setAge(Period.between(birthdate, currentdate).getYears());
    }

    public boolean checkGender(Human human){
        if(human.getGender()!=0 && human.getGender()!=1)
            return true;
        return false;
    }
    public boolean requeriedFields(Human human){

            if(Objects.isNull(human.getGender()) || Objects.isNull(human.getDate_birth()) || Objects.isNull(human.getFirst_name())
            || Objects.isNull(human.getLast_name()))
            {
                return true;
            }

        return false;
    }


    @Override
    public boolean humanExist(Human human) {
        for(int i=0;i<this.humanCrowd.size();i++){

            if(
                    this.humanCrowd.get(i).getAge()==human.getAge()
                            && this.humanCrowd.get(i).getFirst_name().equals(human.getFirst_name())
                            && this.humanCrowd.get(i).getLast_name().equals(human.getLast_name())
                            && this.humanCrowd.get(i).getDate_birth().equals(human.getDate_birth())
                    && this.humanCrowd.get(i).getGender()==human.getGender()
            )
                return true;
        }
        return false;
    }
}
