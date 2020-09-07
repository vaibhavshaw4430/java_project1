package com.asijit;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Teacher extends User {

    public boolean createCousre(String name,int duration, String subject)
    {
        File file= new File("courses.txt");

        try{
            file.createNewFile();
            FileWriter writer =new FileWriter("courses.txt",true);
            writer.append("<"+ name + ","+ duration +","+subject + ">\n");
            writer.close();

            return true;
        }catch(IOException e)
        {
            e.printStackTrace();
            return false;
        }
    }

}