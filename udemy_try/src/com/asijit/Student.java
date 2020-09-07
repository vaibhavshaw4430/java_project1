package com.asijit;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Student extends User {
    public String viewCourses() {


        try {
            FileReader freader = new FileReader("courses.txt");
            Scanner reader = new Scanner(freader);

            StringBuffer sb = new StringBuffer();

            while (reader.hasNextLine()) {
                sb.append(reader.nextLine());
            }
            String blob = sb.toString();

            return blob;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
