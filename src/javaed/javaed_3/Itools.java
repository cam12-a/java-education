package javaed.javaed_3;

public interface Itools {
    public default void tools(){
       System.out.println("ok");
    }
    Object Copy();
    public String toString();
    public int hashCode();

}
