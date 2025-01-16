import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonGenerator {
    public static void main(String[] args)
    {
        boolean doneInput = false;

        String ID = "";
        String firstName = "";
        String lastName = "";
        String title = "";
        String rec ="";
        int YOB = 0;
        ArrayList<String> people = new ArrayList<String>();


        Scanner in = new Scanner(System.in);

        //Create a loop to input the person data
        do{
            ID = SafeInput.getNonZeroLenString(in, "Enter your ID [######]");
            firstName = SafeInput.getNonZeroLenString(in, "Enter your first name");
            lastName = SafeInput.getNonZeroLenString(in, "Enter your last name");
            title = SafeInput.getNonZeroLenString(in, "Enter your title");
            YOB = SafeInput.getRangedInt(in, "Enter your year of birth", 1000, 9999);

            rec = (ID + ", " + firstName + ", " + lastName + ", " + title + ", " + YOB);
            System.out.println(rec);

            people.add(rec);

            doneInput = SafeInput.getYNConfirm(in,"Are you done? [Y/N]");

        }while(!doneInput);

        try {
            OutputStream out = new BufferedOutputStream(Files.newOutputStream(file, StandardOpenOption.CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

            for(String person : people) {
                writer.write(people, 0, people.length());
                writer.newLine();
            }

            writer.close();
            System.out.println("Data file written!");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
