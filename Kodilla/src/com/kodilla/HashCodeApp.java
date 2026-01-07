package com.kodilla;

public class HashCodeApp {
    public static void main(String[] args) {
        MyObject obj = new MyObject();
        int result = obj.hashCode();

        System.out.println(result);
    }
}
class MyObject {

}
