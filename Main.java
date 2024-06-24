import java.io.*;
import java.util.*;
import java.nio.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import javax.xml.transform.stream.StreamSource;

public class Main {
    static final Scanner input = new Scanner(System.in);
    static final String[][] fileName = {{"C:\\Users\\Dell\\Desktop\\CIA\\DATABASE\\AGENTS\\ACTIVE.txt", "C:\\Users\\Dell\\Desktop\\CIA\\DATABASE\\AGENTS\\ALLINFO.txt", "C:\\Users\\Dell\\Desktop\\CIA\\DATABASE\\AGENTS\\FINANCE.txt", "C:\\Users\\Dell\\Desktop\\CIA\\DATABASE\\AGENTS\\NAMES.txt", "C:\\Users\\Dell\\Desktop\\CIA\\DATABASE\\AGENTS\\OFFDUTY.txt", "C:\\Users\\Dell\\Desktop\\CIA\\DATABASE\\AGENTS\\STATS.txt"},
            {"C:\\Users\\Dell\\Desktop\\CIA\\DATABASE\\CRYPTO\\CIPHERHASHES.txt", "C:\\Users\\Dell\\Desktop\\CIA\\DATABASE\\CRYPTO\\MACHASHES.txt", "C:\\Users\\Dell\\Desktop\\CIA\\DATABASE\\CRYPTO\\HMACHASHES.txt"},
            {"C:\\Users\\Dell\\Desktop\\CIA\\DATABASE\\MISSSIONS\\DONE.txt", "C:\\Users\\Dell\\Desktop\\CIA\\DATABASE\\MISSSIONS\\FINANCE.txt", "C:\\Users\\Dell\\Desktop\\CIA\\DATABASE\\MISSSIONS\\NAME.txt", "C:\\Users\\Dell\\Desktop\\CIA\\DATABASE\\MISSSIONS\\MISSIONLEVEL.txt", "C:\\Users\\Dell\\Desktop\\CIA\\DATABASE\\MISSSIONS\\ON.txt"}};
    static int k;
    public static void main(String[] args) {
        
        System.out.println(".........COMSATS INTELLIGECE AGENCY........");
        System.out.println("1.AGENTS \n2.MISSIONS\n3.START NEW OPERATION\n4.DATABASE INFORMATION\n5.CONTINUE MISSION:");
        System.out.println("6.ENCRYPTION \n7.DECRYPTION:\n8.EXIT");
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                System.out.println("\t--------------AGENTS INFO----------------\n");
                agents();
                break;
            case 2:
                 System.out.println("\t---------------MISSIONS INFO---------------\n");
                missions();
                break;
            case 3:
                 System.out.println("\t---------------MISSION INFO---------------\n");
                takeMissionInfo();
                 System.out.println("\t---------------MISSION STARTED---------------\n");
                startMission();
                break;
            case 4:
                System.out.println("\t------DETAIL INFORMATION OF DATABASE-------");
                dataBase();
                break;
            case 5:System.out.println("\t----------CONTINUE MISSION----------\n");
                 startMission();break;
             case 6:
                boolean op = true;
                System.out.println("\t\t\t... AVAILABLE ALGORITHN ....\n\n");
                System.out.println("\t\t\tCHOOSE ALGORITHM FOR ENC/DEC");
                System.out.println("\n1.ROT13\n2.ONESHIFT\n3.FIVESHIFT\n4.REVERSESHIFT3\n5.DOUBLESHIFT\n6.CUSTOMIZE CIPHER\n7.DIGITAL SIGNATURE GENERATOR(MAC)\n8.ENCRYT ADVANCE CRYPTO(HMAC)\n9.DECRYT ADVANCE CRYPTO(HMAC)");
                int algo = input.nextInt();
                Crypto.excecuteAlgo(algo, op,input);
                break;
               
            case 7:
                boolean op1 = false;
                System.out.println("\t\t\t... AVAILABLE ALGORITHN ....\n\n");
                System.out.println("\t\t\tCHOOSE ALGORITHM FOR ENC/DEC");
                System.out.println("\n1.ROT13\n2.ONESHIFT\n3.FIVESHIFT\n4.REVERSESHIFT3\n5.DOUBLESHIFT\n6.CUSTOMIZE CIPHER\n7.DIGITAL SIGNATURE GENERATOR(MAC)\n8.ENCRYT ADVANCE CRYPTO(HMAC)\n9.DECRYT ADVANCE CRYPTO(HMAC)");
                int algo1 = input.nextInt();
                Crypto.excecuteAlgo(algo1, op1,input);
                break;
                 
            case 8:
                System.exit(0);
                break;
        }
                System.out.println("Enter  \t(1)for Home page   \t(0) for exit:");
                k = input.nextInt();
                if(k==1)
                main(args);
                else if(k==0)
                System.exit(0);
        
    }

    public static void dataBase(){
        for(int i =0;i<3;i++){
            for(int j =0;j<fileName[i].length;j++){
              
                File myObj = new File(fileName[i][j]);
                if (myObj.exists()) {
                System.out.println("File name: " + myObj.getName());
                System.out.println("File path: " +fileName[i][j]);
                System.out.println("Writeable: " + myObj.canWrite());
                System.out.println("Readable: " + myObj.canRead());
                System.out.println("File size in bytes: " + myObj.length());
                System.out.println();
                System.out.println();
                }}}
               }
    
    public static void agents() {
        System.out.println("1.Active agents\n2.Reserved agents\n3.Finance\n4.Stats\n5.All info\n6.Names\n7.Back");
        System.out.println("Enter your choice:");
        int s = input.nextInt();
        switch (s) {
            case 1:
                System.out.println("ACTIVE AGENTS");
                FileHandling.filer(fileName[0][0]);
                System.out.println("\n Enter (2) for back:");
                k=input.nextInt();
                if (k==2) 
                    agents();
                break;
            case 2:
                System.out.println("RESERVED AGENTS");
                FileHandling.filer(fileName[0][4]);
                 System.out.println("\n Enter (2) for back:");
                k=input.nextInt();
                if (k==2) 
                    agents();
                break;
            case 3:
                System.out.println("AGENTS FINANCE");
                FileHandling.filer(fileName[0][2]);
                 System.out.println("\n Enter (2) for back:");
                k=input.nextInt();
                if (k==2) 
                    agents();
                break;
            case 4:
              System.out.println("AGENTS STATS");
                FileHandling.filer(fileName[0][5]);
                 System.out.println("\n Enter (2) for back:");
                k=input.nextInt();
                if (k==2) 
                    agents();
                break;
                
            case 5:
                System.out.println("ALL INFO");
                FileHandling.filer(fileName[0][1]);
                 System.out.println("\n Enter (2) for back:");
                k=input.nextInt();
                if (k==2) 
                    agents();
                break;
            case 6:
                System.out.println("NAMES");
                FileHandling.filer(fileName[0][3]);
                System.out.println("\n Enter (2) for back:");
                k=input.nextInt();
                if (k==2) 
                    agents();
                break;
            case 7: 
               Main.main(null);
            default:
                System.out.println("INVALID CHOICE");
                break;
        }
        
    }
    
    public static void missions() {
        System.out.println("1.ON\n2.DONE\n3.FINANCE\n4.NAME\n5.MISSION LEVEL");
        System.out.println("Enter your choice:");
        int s = input.nextInt();
        switch (s) {
            case 1:
                System.out.println("ON MISSIONS");
                FileHandling.filer(fileName[2][4]);
                break;
            case 2:
                System.out.println("DONE MISSIONS");
                FileHandling.filer(fileName[2][0]);
                break;
            case 3:
                System.out.println("FINANCE MISSIONS");
                FileHandling.filer(fileName[2][1]);
                break;
            case 4:
                System.out.println("NAME MISSIONS");
                FileHandling.filer(fileName[2][2]);
                break;
            case 5:
                System.out.println("MISSIONS LEVE");
                FileHandling.filer(fileName[2][3]);
                break;
            default:
                System.out.println("INVALID CHOICE");
                break;
        }
    }

    public static void takeMissionInfo() {
        System.out.println("\tENTER INFORMATION OF NEW OPERATION:");

        // Read and handle mission name
        String nameM = "";
        while (nameM.isEmpty()) {
            System.out.println("NAME THE MISSION...");
            nameM = input.nextLine();
            if (nameM.isEmpty()) {
                System.out.println("Mission name cannot be empty. Please enter a valid name.");
            }
        }
        FileHandling.filer(fileName[2][2], nameM);

        // Read and handle mission level
        System.out.println("ENTER THE LEVEL OF MISSION...");
        String level = input.nextLine();
        String data1=nameM+"----------------------"+level;
        FileHandling.filer(fileName[2][3], data1);

        // Read and handle mission finance
        System.out.println("ENTER THE FINANCE OF MISSION...");
        String finance = input.nextLine();
        String data=nameM+"-----------------------"+finance;
        FileHandling.filer(fileName[2][1], data);

        // Add agents loop
        System.out.println("ADD AGENTS...");
        int a;
        while (true) {
            System.out.println("ENTER THE NAME OF AGENT...");
            String agentName = input.nextLine();
            FileHandling.filer(fileName[0][3], agentName);

            System.out.println("ENTER (1) for adding another agent otherwise enter (0)...");
            while (!input.hasNextInt()) {
                System.out.println("Invalid input. Please enter 1 to add another agent or 0 to finish.");
                input.next(); // Consume the invalid input
            }
            a = input.nextInt();
            if (a == 0) {
                break; // Exit the loop when 0 is entered
            }
            input.nextLine(); // Consume the newline character after the integer input
        }
    }

    public static void startMission() {
        System.out.println("..........................OPERATION HAS BEEN INITIATED..............................");
        System.out.println("YOU CAN USE FOLLOWING ADVANCE FEATURES TO LEAD AND COMMUNICATE WITH YOUR COMRADES.");
        System.out.println("1.ENCRYPT MESSAGES OR DOCUMENTS (8 ALGORITHMS ARE AVAILABLE).");
        System.out.println("2.DECRYPT THE MESSAGE OR FILES(8 ALGORITHMS ARE AVAILABLE)");
        System.out.println("3.HIGHLY STRONG PASSWORD GENERATOR.");
        System.out.println("4.DELETE ANY FILE FROM DATABASE.");
        System.out.println("5.MAKE NEW CONFIDENTIAL FILE.");
        System.out.println("6.EXTRACT DATA FROM ANY FILE.");
        System.out.println("7.DELETE DATA ANY FILE FROM DATABASE.");
        System.out.println("8.SEARCH DATA FROM FILE.");
        System.out.println("9.INFORMATION OF ALL FILES OF DATABASE.");
        System.out.println("10.FILES PATH.");
        System.out.println(".....ENTER YOUR CHOICE(1-10).....");
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                boolean op = true;
                System.out.println("\t\t\t... AVAILABLE ALGORITHN ....\n\n");
                System.out.println("\t\t\tCHOOSE ALGORITHM FOR ENC/DEC");
                System.out.println("\n1.ROT13\n2.ONESHIFT\n3.FIVESHIFT\n4.REVERSESHIFT3\n5.DOUBLESHIFT\n6.CUSTOMIZE CIPHER\n7.DIGITAL SIGNATURE GENERATOR(MAC)\n8.ENCRYT ADVANCE CRYPTO(HMAC)\n9.DECRYT ADVANCE CRYPTO(HMAC)");
                int algo = input.nextInt();
                Crypto.excecuteAlgo(algo, op,input);
                
                break;
            case 2:
                boolean op1 = false;
                System.out.println("\t\t\t... AVAILABLE ALGORITHN ....\n\n");
                System.out.println("\t\t\tCHOOSE ALGORITHM FOR ENC/DEC");
                System.out.println("\n1.ROT13\n2.ONESHIFT\n3.FIVESHIFT\n4.REVERSESHIFT3\n5.DOUBLESHIFT\n6.CUSTOMIZE CIPHER\n7.DIGITAL SIGNATURE GENERATOR(MAC)\n8.ENCRYT ADVANCE CRYPTO(HMAC)\n9.DECRYT ADVANCE CRYPTO(HMAC)");
                int algo1 = input.nextInt();
                Crypto.excecuteAlgo(algo1, op1,input);
                break;
            case 3:
                System.out.println("ENTER THE LENGTH OF PASSWORD");
                int n = input.nextInt();
                String pass = Crypto.keygenerator(n);
                System.out.println("PASSWORD: " + pass);
                break;
            case 4:
                System.out.println("ENTER FILE PATH:");
                String path = input.next();
                FileHandling.delFile(path);
                break;
            case 5:
                System.out.println("ENTER FILE PATH");
                String pa = input.next();
                FileHandling.mkFile(pa);
                break;
            case 6:
                System.out.println("ENTER PARH: ");
                String pa2 = input.next();
                System.out.println("ENTER HINT FOR DATA TO BE EXTRACT");
                String data2 = input.next();
                FileHandling.searchFile(pa2, data2);
                break;
            case 7:
                System.out.println("ENTER PARH: ");
                String pa1 = input.next();
                System.out.println("ENTER DATA TO BE DELETED");
                String data = input.next();
                FileHandling.delData(pa1, data);
                break;
            case 8:
                System.out.println("ENTER PATH: ");
                String pa3 = input.next();
                System.out.println("ENTER DATA TO BE SEARCHED");
                String data3 = input.next();
                FileHandling.searchFile(pa3, data3);
                break;
            case 9:
                System.out.println("\tINFORMATION");
                FileHandling.filer(fileName[0][1]);
                break;
            case 10:
                System.out.println("\tFiles path ");
            for(int i =0;i<3;i++){
            for(int j =0;j<Main.fileName[i].length;j++){
                File myObj = new File(Main.fileName[i][j]);
                if (myObj.exists()) {
                   System.out.println("File name: " + myObj.getName());
                   System.out.println(Main.fileName[i][j]);
                }}}
        }
         System.out.println("\n Enter (2) for back:");
         k=input.nextInt();
         if (k==2) 
            startMission();
                
    }
}

class FileHandling {

    public static void filer(String filename) {
        File file = new File(filename);
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
            Scanner reader = new Scanner(fileReader);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void filer(String filename, String data) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(filename, true);
            writer.write(data);
            writer.write("\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("File Writing Error");
            e.printStackTrace();
        }
    }

    public static void delData(String filename, String data) {
        String content = "";
        try {
            content = new String(Files.readAllBytes(Paths.get(filename)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String replace = "\\s*\\b" + data + "\\b\\s*";
        content = content.replaceAll(replace, "");
        try {
            Files.write(Paths.get(filename), content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void delFile(String filename) {
        File file = new File(filename);
        if (file.delete()) {
            System.out.println("Deleted the file: " + file.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }

    public static void mkFile(String filename) {
        try {
            File newFile = new File(filename);
            if (newFile.createNewFile()) {
                System.out.println("File created: " + newFile.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void searchFile(String filename, String searchContent) {
    File file = new File(filename);
    int i = 1;
    try (Scanner scanner = new Scanner(file)) {
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (line.contains(searchContent)) {
                System.out.println("Data exists in the file.");
                System.out.println(line);
                i = 0;
                break;
            }
        }
        if (i == 1) {
            System.out.println("Data does not exist in the file.");
        }
    } catch (FileNotFoundException e) {
        System.out.println("File not found error occurred. May be path is not correct.");
        e.printStackTrace();
    }
}

}

class Crypto {

public static void excecuteAlgo(int algor, boolean op,Scanner input) {
    String result = "";
    System.out.println("ENTER TEXT...");
    String txt = input.next();
    input.nextLine();
    String [] mac =new String[2];
    switch (algor) {
        case 1:
            result = rot13(txt, op);
            System.out.println("PROCESS HAS BEEN DONE...");
            System.out.println("OUTPUT:" + result);
            System.out.println("WAIT , OUTPUT IS BEING SAVE TO DATABASE..");
            mac =mac(txt,"13");
            String key = "------------13"+"-----"+mac[1];
            System.out.println("NOTE:  REMEMBER THE VALUE:"+mac[1]+" TO ACCESS HASH FROM DATABASE.");
            result = result + key;
            String f = Main.fileName[1][0];
            FileHandling.filer(f, result);
            System.out.println("SUCCESSFULY ,DATA HAS BEEN SAVED....");
           
            break;
        case 2:
            result = Crypto.oneShift(txt, op);
            System.out.println("PROCESS HAS BEEN DONE.");
            System.out.println("OUTPUT:" + result);
            System.out.println("WAIT , OUTPUT IS BEING SAVE TO DATABASE..");
            mac =mac(txt,"1");
            String key1 = "------------1"+"-----"+mac[1];
            System.out.println("NOTE:  REMEMBER THE VALUE:"+mac[1]+" TO ACCESS HASH FROM DATABASE.");
            result = result + key1;
            FileHandling.filer(Main.fileName[1][0], result);
            System.out.println("SUCCESSFULY ,DATA HAS BEEN SAVED....");
            break;
        case 3:
            result = Crypto.fiveShift(txt, op);
            System.out.println("PROCESS HAS BEEN DONE.");
            System.out.println("OUTPUT:" + result);
            System.out.println("WAIT , OUTPUT IS BEING SAVE TO DATABASE..");
              mac =mac(txt,"5");
            String key2 = "------------5"+"-----"+mac[1];
            System.out.println("NOTE:  REMEMBER THE VALUE:"+mac[1]+" TO ACCESS HASH FROM DATABASE.");
            result = result + key2;
            FileHandling.filer(Main.fileName[1][0], result);
            System.out.println("SUCCESSFULY ,DATA HAS BEEN SAVED....");
            break;
        case 4:
            result = Crypto.reverseshift3(txt, op);
            System.out.println("PROCESS HAS BEEN DONE.");
            System.out.println("OUTPUT:" + result);
            System.out.println("WAIT , OUTPUT IS BEING SAVE TO DATABASE..");
              mac =mac(txt,"-3");
            String key3 = "------------_3"+"-----"+mac[1];
            System.out.println("NOTE:  REMEMBER THE VALUE:"+mac[1]+" TO ACCESS HASH FROM DATABASE.");
            result = result + key3;
            FileHandling.filer(Main.fileName[1][0], result);
            System.out.println("SUCCESSFULY ,DATA HAS BEEN SAVED....");
            break;
        case 5:
            result = Crypto.doubleShift(txt, op);
            System.out.println("PROCESS HAS BEEN DONE.");
            System.out.println("OUTPUT:" + result);
            System.out.println("WAIT , OUTPUT IS BEING SAVE TO DATABASE..");
              mac =mac(txt,"2");
            String key4 = "------------"+"-----"+mac[1];
            System.out.println("NOTE:  REMEMBER THE VALUE:"+mac[1]+" TO ACCESS HASH FROM DATABASE.");
            result = result + key4;
            FileHandling.filer(Main.fileName[1][0], result);
            System.out.println("SUCCESSFULY ,DATA HAS BEEN SAVED....");
            break;
        case 6:
            System.out.println("ENTER SHIFT FOR CUSTOMIZATION(1-13)");
            int shift = input.nextInt();
            result = Crypto.customizeCipher(txt, shift, op);
            String Sif =String.valueOf(shift);
            System.out.println("PROCESS HAS BEEN DONE.");
            System.out.println("OUTPUT:" + result);
            System.out.println("WAIT , OUTPUT IS BEING SAVE TO DATABASE..");
            mac =mac(txt,Sif);
            String key5 = "------------"+Sif+"-----"+mac[1];
            System.out.println("NOTE:  REMEMBER THE VALUE:"+mac[1]+" TO ACCESS HASH FROM DATABASE.");
            
            result = result + key5;
            FileHandling.filer(Main.fileName[1][0], result);
            System.out.println("SUCCESSFULY ,DATA HAS BEEN SAVED....");
            break;
        case 7:
            System.out.println("NOTE:YOU WILL BE ABLE TO ACCESS THE DATA OR MSG BY MAC VALUE . \nENTER KEY:");
            String k = input.nextLine();
            String macValue = Crypto.mac(txt, k)[0];
            System.out.println("MAC of message '" + txt + "' is :" + macValue);
            System.out.println("WAIT , OUTPUT IS BEING SAVE TO DATABASE..");
            String key7 = "------------" + macValue;
            result = txt + key7;
            FileHandling.filer(Main.fileName[1][1], result);
            System.out.println("SUCCESSFULY ,DATA HAS BEEN SAVED....");
            break;
        case 8:
            System.out.println("NOTE:YOUR DATA WILL BE HASHED .YOU WILL BE ABLE TO ACCESS THE DATA'S HASH BY HASH VALUE OR KEY THAT WILL BE GIVEN AS OUTPUT . \nENTER KEY:");
            String k2 = input.nextLine();
            String[] hashArray = Crypto.hmac(txt, k2, true);
            String hash=hashArray[0];
            String hashValue = hashArray[1];
            System.out.println("HASH of message '" + txt + "' is :" + hash + " and its HASH VALUE is: " + hashArray[1]);
            System.out.println("WAIT , OUTPUT IS BEING SAVE TO DATABASE..");
            String key8 = "------------" + hashArray[1] + "---------" + k2 + "...false";
            result = hashValue + key8;
            FileHandling.filer(Main.fileName[1][2], result);
            System.out.println("SUCCESSFULY ,DATA HAS BEEN SAVED....");
            break;
        case 9:
            System.out.println("NOTE:YOUR DATA CAN BE DECRYPT .BUT YOU MUST HAVE HASH VALUE OR KEY  . \nENTER KEY/HASH VALUE:");
            String k3 = input.nextLine();
            String[] hashArray1 = Crypto.hmac(txt, k3, false);
            String hashValue1 = hashArray1[0];
            System.out.println("HASH of message '" + txt + "' is :" + hashValue1 + " and its HASH VALUE is: " + hashArray1[1]);
            System.out.println("WAIT , OUTPUT IS BEING SAVE TO DATABASE..");
            String key9 = "------------" + hashArray1[1] + "---------" + k3 + "...true";
            result = result + key9;
            FileHandling.filer(Main.fileName[1][2], result);
            System.out.println("SUCCESSFULY ,DATA HAS BEEN SAVED....");
            break;
    }
}

    public static String[] mac(String message, String key) {
        String hashvalue = hashsum(message, key);
        String[] Mac = {message, hashvalue};
        /* Store hashvalue----key in file */
        return Mac;
    }

    public static String[] hmac(String message, String key, boolean operation) {
        String hashvalue = hashsum(message, key);
        String hash = hashfunc(message, 4, operation);
        String[] Hmac = {hash, hashvalue};
        return Hmac;
    }

    public static String rot13(String text, boolean operation) {
         String rs =hashfunc(text, 13, operation);
        return rs;
    }

    public static String oneShift(String text, boolean operation) {
        return hashfunc(text, 1, operation);
    }

    public static String fiveShift(String text, boolean operation) {
        return hashfunc(text, 5, operation);
    }

    public static String reverseshift3(String text, boolean operation) {
        return hashfunc(text, 3, operation);
    }

    public static String doubleShift(String text, boolean operation) {
        return hashfunc(text, 2, operation);
    }

    public static String customizeCipher(String text, int shift, boolean operation) {
        return hashfunc(text, shift, operation);
    }

    public static String hashfunc(String plaintext, int key, boolean encrypt) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < plaintext.length(); i++) {
            char c = plaintext.charAt(i);
            if (Character.isLetter(c)) {
                int shift = encrypt ? key : -key;
                char shifted = (char) (c + shift);
                if (Character.isUpperCase(c)) {
                    if (shifted > 'Z') {
                        shifted -= 26;
                    } else if (shifted < 'A') {
                        shifted += 26;
                    }
                } else if (Character.isLowerCase(c)) {
                    if (shifted > 'z') {
                        shifted -= 26;
                    } else if (shifted < 'a') {
                        shifted += 26;
                    }
                }
                output.append(shifted);
            } else {
                output.append(c);
            }
        }
        return output.toString();
    }

    public static String keygenerator(int length) {
        StringBuilder key = new StringBuilder();
        for (int i = 0; i < length; i++)
            key.append((char) (33 + (int) (Math.random() * 125)));
        return key.toString();
    }

    public static String hashsum(String text,String key) {
        byte[] textbyte = text.getBytes();
        byte[] keybyte = key.getBytes();
        int sum = 0;
        int keyIndex = 0;
        for (int i = 0; i < textbyte.length; i++) {
            sum += textbyte[i] ^ keybyte[keyIndex];
            keyIndex = (keyIndex + 1) % keybyte.length;
        }
        return String.valueOf(sum);
    }
}