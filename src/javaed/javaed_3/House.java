package javaed.javaed_3;

import java.util.Objects;

public class House extends Figures implements Itools {
    protected double width;
    protected double height;
    protected int numberWindows;
    public void setWidth(double width){
        this.width=width;

    }
    public void setHeight(double height){
        this.height=height;

    }
    public void setNumberWindows(int numberWindows){
        this.numberWindows=numberWindows;

    }
    public double getWidth(){return this.width;}
    public double getHeight(){return  this.height;}
    public int getNumberWindows(){return this.numberWindows;}

    @Override
    public double calcArea() {
        return this.width *this.height ;
    }
    @Override
    public double calcVolume(){
        return this.height *this.width *this.width;
    }

    @Override
    public double calcPerimeter() {
        return this.height+this.width;
    }

    @Override
     public Object Copy() {
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return Double.compare(house.width, width) == 0 && Double.compare(house.height, height) == 0 && numberWindows == house.numberWindows;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height, numberWindows);
    }

    @Override
    public String toString() {
        return "House{" +
                "width=" + width +
                ", height=" + height +
                ", numberWindows=" + numberWindows +
                '}';
    }
}
