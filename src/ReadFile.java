import java.io.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ReadFile {

        private static ReadFile single_instance = null;

        public static ReadFile getInstance() {
            if(single_instance == null)
                single_instance = new ReadFile();
            return single_instance;
        }

        private ReadFile() {
        }


        public List <String[]> read(String path) {

            try{
            List<String[]> lines = new ArrayList<>();
            File read = new File(path);
            Scanner inRead = new Scanner(read);

            while (inRead.hasNextLine()) {
                String temp = inRead.nextLine();
                String[] data = temp.split(",");
                lines.add(data);
            }
           return lines;}

            catch (FileNotFoundException e) {
                System.out.println(e);
                return null;
            }
        }



        public void audit() {

            try {

                String methodName = new Throwable().getStackTrace()[1].getMethodName();

                FileWriter in = new FileWriter("C:\\Users\\Andrei\\Desktop\\ANUL 2.2\\PAO\\Tema\\src\\audit.csv",true);

                Timestamp timestamp = new Timestamp(System.currentTimeMillis());


                in.append(methodName + "  " + timestamp + "\n");
                in.close();

            } catch (FileNotFoundException e) {
                System.out.println(e);
            }

            catch (IOException e){
                System.out.println(e);
            }
        }

}



