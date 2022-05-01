/*
Необходимо создать класс Person с полями: Имя, Фамилия, возраст, телефон. Записать в формате CSV
(Загуглите как он выглядит) в файл таблицу с указанными выше данными (человек 5 и заголовки).
Написать парсер CSV файлов, который должен создать массив объектов класса Person, прочитав данные их csv файла.
*/

package lesson6;

import javax.swing.*;
import java.io.*;

public class Persons {

    public static void main(String[] args) throws IOException {


        //вызовы методов
        saveData("Adam", "Markull", "26", "123456789");
        readData("./src/lesson6/person.CSV");

    }


    //метод для записи данных в CSV файл
    public static void saveData(String name, String lastname, String age, String tel){

        try {
            FileWriter fw = new FileWriter("./src/lesson6/person.CSV", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.println(name+","+lastname+","+age+","+tel);
            pw.flush();
            pw.close();

            JOptionPane.showConfirmDialog(null, "saveData");
        }catch (Exception e){

        }

    }

    //метод для чтения и вывода в массив из CSV файла
    public static void readData(String name) throws IOException {

        String line = "";
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(name));
            while ((line = reader.readLine()) != null){
                String[] row = line.split(",");
                for(String index: row){
                    System.out.printf("%-10s", index);
                }
                System.out.println();
            }


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            reader.close();
        }

    }

}
