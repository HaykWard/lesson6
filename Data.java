package lesson6;
import java.io.*;
public class Data {

    public static void main(String[] args) throws IOException {

        File data = new File("./src/lesson6/data.txt");
        FileWriter fw = new FileWriter(data);
        char ch;

            System.out.println("Введите символ: ");
            ch = (char) System.in.read();
            fw.write(ch);
        if(ch == 'q'){
            System.out.println("The end!");
        }else {
            while (ch != 'q') {
                ch = (char) System.in.read();
                fw.write(ch);
            }
        }
        System.out.println("Выход из операции!");
        fw.close();
    }
}