package com.asijit;

import java.io.*;
import java.sql.SQLOutput;
import java.util.Scanner;

public class User {
    private static int userId = 1;
    private String name;
    private String email;
    private String password;

    public boolean register(String name, String email, String password) {
        User.userId++;
        this.name = name;
        this.email = email;
        this.password = password;

        File userRecord = new File("user_record.txt");
        try{
            userRecord.createNewFile();

            FileWriter writer= new FileWriter("user_record.txt",true);
            writer.append("<" + "," + this.name + "," + this.email + "," + this.password + ">\n");
            writer.close();
            return true;
        } catch(IOException e){
            System.out.println("Error in creating file. Try again");
            return false;
        }
    }
    public boolean login(String email, String password)
    {
        try {
            FileReader freader=new FileReader("user_record.txt");
            Scanner reader= new Scanner(freader);

            StringBuffer sb=new StringBuffer();

            while(reader.hasNextLine()){
                sb.append(reader.nextLine());
            }
            String blob=sb.toString();

            if(blob.contains("," + email + "," + password + ">"))
            {
                System.out.println("welcome");
                return true;
            }
            else
            {
                System.out.println("Incorrect");
                return false;
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }

    }

}
