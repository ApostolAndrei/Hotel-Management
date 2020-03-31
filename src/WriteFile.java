

import java.io.*;
import java.util.Scanner;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;


public class WriteFile {

        private static WriteFile single_instance = null;

        public static WriteFile getInstance() {
            if(single_instance == null)
                single_instance = new WriteFile();
            return single_instance;
        }

        private WriteFile() {
        }

        public void audit() {

            try {

                String methodName = new Throwable().getStackTrace()[1].getMethodName();

                FileWriter in = new FileWriter("C:\\Users\\Andrei\\Desktop\\ANUL 2.2\\PAO\\Tema\\src\\audit.csv",true);

                Timestamp timestamp = new Timestamp(System.currentTimeMillis());


                in.append(methodName + "  " + timestamp + "\n");
                in.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found!");
            }
            catch (IOException e){
                System.out.println("IOException error!");
            }
        }


}



