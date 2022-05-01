/*
#3 Реализовать класс Car, с полями присущими автомобилю (скорость, цвет и тд).
Создать метод, который бы сохранял указанный объект на диск и
статический метод класса, который бы читал файл и создавал объект*/

/*сохдать объект и схоранить его на диск
* чиать файл  и создать обьект*/

package lesson6;

import java.io.*;

public class Car implements Serializable {

    String country;
    String model;
    String color;

    Car(String country, String model, String color){
        this.country = country;
        this.model = model;
        this.color = color;
    }

    public static void main(String [] args){

        Car toyota = new Car("Japan", "Mazda", "Black");
        Car lexus = new Car("USA", "IS300", "White");

        byte[] bytes = convertObjectToBytes(toyota);

        Car c = (Car) convertBytesToObject(bytes);

        System.out.println(c);

    }

    public static byte[] convertObjectToBytes(Object obj) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            oos.writeObject(obj);
            return baos.toByteArray();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }throw new RuntimeException();
    }

    public static Object convertBytesToObject(byte [] bytes){
        InputStream is = new ByteArrayInputStream(bytes);
        try(ObjectInputStream ois = new ObjectInputStream(is)){
            return ois.readObject();
        }catch (IOException | ClassNotFoundException ioe){
            ioe.printStackTrace();
        }throw new RuntimeException();
    }







}
