import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Gui extends JFrame {
    static final String[][] fileName = {
            {"C:\\Users\\Dell\\Desktop\\CIA\\DATABASE\\AGENTS\\ACTIVE.txt", "C:\\Users\\Dell\\Desktop\\CIA\\DATABASE\\AGENTS\\ALLINFO.txt", "C:\\Users\\Dell\\Desktop\\CIA\\DATABASE\\AGENTS\\FINANCE.txt", "C:\\Users\\Dell\\Desktop\\CIA\\DATABASE\\AGENTS\\NAMES.txt", "C:\\Users\\Dell\\Desktop\\CIA\\DATABASE\\AGENTS\\OFFDUTY.txt", "C:\\Users\\Dell\\Desktop\\CIA\\DATABASE\\AGENTS\\STATS.txt"},
            {"C:\\Users\\Dell\\Desktop\\CIA\\DATABASE\\CRYPTO\\CIPHERHASHES.txt", "C:\\Users\\Dell\\Desktop\\CIA\\DATABASE\\CRYPTO\\MACHASHES.txt", "C:\\Users\\Dell\\Desktop\\CIA\\DATABASE\\CRYPTO\\HMACHASHES.txt"},
            {"C:\\Users\\Dell\\Desktop\\CIA\\DATABASE\\MISSSIONS\\DONE.txt", "C:\\Users\\Dell\\Desktop\\CIA\\DATABASE\\MISSSIONS\\FINANCE.txt", "C:\\Users\\Dell\\Desktop\\CIA\\DATABASE\\MISSSIONS\\NAME.txt", "C:\\Users\\Dell\\Desktop\\CIA\\DATABASE\\MISSSIONS\\MISSIONLEVEL.txt", "C:\\Users\\Dell\\Desktop\\CIA\\DATABASE\\MISSSIONS\\ON.txt"}
    };
    public static void main(String[] args) {
        // Simplified main method
        SwingUtilities.invokeLater(() -> new Gui());
    }
    public Gui() {
        setTitle("COMSATS Intelligence Agency");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new CardLayout());

        JPanel mainPanel = new JPanel(new GridLayout(8, 1, 10, 10));
        mainPanel.add(createButton("1. AGENTS", e -> agents()));
        mainPanel.add(createButton("2. MISSIONS", e -> missions()));
        mainPanel.add(createButton("3. START NEW OPERATION", e -> {
            takeMissionInfo();
            startMission();
        }));
        mainPanel.add(createButton("4. DATABASE INFORMATION", e -> dataBase()));
        mainPanel.add(createButton("5. CONTINUE MISSION", e -> startMission()));
        mainPanel.add(createButton("6. ENCRYPTION", e -> encryption(true)));
        mainPanel.add(createButton("7. DECRYPTION", e -> encryption(false)));
        mainPanel.add(createButton("8. EXIT", e -> System.exit(0)));
        mainPanel.setBackground(Color.DARK_GRAY);
        add(mainPanel);
        setVisible(true);
    }

    private JButton createButton(String text, ActionListener actionListener) {
        JButton button = new JButton(text);
        button.addActionListener(actionListener);
        button.setBackground(Color.LIGHT_GRAY);
        return button;
    }

    private void dataBase() {
        JFrame frame = new JFrame("Database Information");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < fileName[i].length; j++) {
                File myObj = new File(fileName[i][j]);
                if (myObj.exists()) {
                    textArea.append("File name: " + myObj.getName() + "\n");
                    textArea.append("File path: " + fileName[i][j] + "\n");
                    textArea.append("Writeable: " + myObj.canWrite() + "\n");
                    textArea.append("Readable: " + myObj.canRead() + "\n");
                    textArea.append("File size in bytes: " + myObj.length() + "\n\n");
                }
            }
        }
        frame.add(new JScrollPane(textArea));
        frame.setVisible(true);
    }

    private void agents() {
        JFrame frame = new JFrame("Agents");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JPanel panel = new JPanel(new GridLayout(6, 1, 10, 10));

        panel.add(createButton("1. Active Agents", e -> FileHandling.filer(fileName[0][0])));
        panel.add(createButton("2. Reserved Agents", e -> FileHandling.filer(fileName[0][4])));
        panel.add(createButton("3. Finance", e -> FileHandling.filer(fileName[0][2])));
        panel.add(createButton("4. Stats", e -> FileHandling.filer(fileName[0][5])));
        panel.add(createButton("5. All Info", e -> FileHandling.filer(fileName[0][1])));
        panel.add(createButton("6. Names", e -> FileHandling.filer(fileName[0][3])));

        frame.add(panel);
        frame.setVisible(true);
    }

    private void missions() {
        JFrame frame = new JFrame("Missions");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JPanel panel = new JPanel(new GridLayout(5, 1, 10, 10));

        panel.add(createButton("1. On", e -> FileHandling.filer(fileName[2][4])));
        panel.add(createButton("2. Done", e -> FileHandling.filer(fileName[2][0])));
        panel.add(createButton("3. Finance", e -> FileHandling.filer(fileName[2][1])));
        panel.add(createButton("4. Name", e -> FileHandling.filer(fileName[2][2])));
        panel.add(createButton("5. Mission Level", e -> FileHandling.filer(fileName[2][3])));

        frame.add(panel);
        frame.setVisible(true);
    }

    private void takeMissionInfo() {
        JFrame frame = new JFrame("New Operation");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JPanel panel = new JPanel(new GridLayout(6, 1, 10, 10));

        JTextField nameField = new JTextField();
        JTextField levelField = new JTextField();
        JTextField financeField = new JTextField();
        JTextField agentField = new JTextField();

        panel.add(new JLabel("Mission Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Mission Level:"));
        panel.add(levelField);
        panel.add(new JLabel("Mission Finance:"));
        panel.add(financeField);
        panel.add(new JLabel("Agent Name:"));
        panel.add(agentField);

        JButton addButton = new JButton("Add Agent");
        JButton finishButton = new JButton("Finish");
        panel.add(addButton);
        panel.add(finishButton);

        addButton.addActionListener(e -> {
            String agentName = agentField.getText();
            FileHandling.filer(fileName[0][3], agentName);
            agentField.setText("");
        });

        finishButton.addActionListener(e -> {
            String nameM = nameField.getText();
            FileHandling.filer(fileName[2][2], nameM);

            String level = levelField.getText();
            String data1 = nameM + "----------------------" + level;
            FileHandling.filer(fileName[2][3], data1);

            String finance = financeField.getText();
            String data = nameM + "-----------------------" + finance;
            FileHandling.filer(fileName[2][1], data);

            frame.dispose();
        });

        frame.add(panel);
        frame.setBackground(Color.RED);
        frame.setVisible(true);
    }

    private void startMission() {
        JFrame frame = new JFrame("Start Mission");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JPanel panel = new JPanel(new GridLayout(10, 1, 10, 10));

        panel.add(createButton("1. Encrypt Messages", e -> encryption(true)));
        panel.add(createButton("2. Decrypt Messages", e -> encryption(false)));
        panel.add(createButton("3. Strong Password Generator", e -> generatePassword()));
        panel.add(createButton("4. Delete File", e -> deleteFile()));
        panel.add(createButton("5. Make Confidential File", e -> makeFile()));
        panel.add(createButton("6. Extract Data from File", e -> extractData()));
        panel.add(createButton("7. Delete Data from File", e -> deleteData()));
        panel.add(createButton("8. Search Data from File", e -> searchData()));
        panel.add(createButton("9. Database Information", e -> dataBase()));
        panel.add(createButton("10. Files Path", e -> showFilesPath()));

        frame.add(panel);
        frame.setVisible(true);
    }

    private void encryption(boolean encrypt) {
        JFrame frame = new JFrame(encrypt ? "Encryption" : "Decryption");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JPanel panel = new JPanel(new GridLayout(10, 1, 10, 10));

        String[] algorithms = {"ROT13", "ONESHIFT", "FIVESHIFT", "REVERSESHIFT3", "DOUBLESHIFT", "CUSTOMIZE CIPHER", "DIGITAL SIGNATURE GENERATOR (MAC)", "ENCRYPT ADVANCE CRYPTO (HMAC)", "DECRYPT ADVANCE CRYPTO (HMAC)"};
        for (int i = 0; i < algorithms.length; i++) {
            final int index = i;
            panel.add(createButton((i + 1) + ". " + algorithms[i], e -> performEncryption(encrypt, index)));
        }

        frame.add(panel);
        frame.setVisible(true);
    }

    private void performEncryption(boolean encrypt, int index) {
        String message = encrypt ? "Enter text to encrypt:" : "Enter text to decrypt:";
        String inputText = JOptionPane.showInputDialog(this, message);
        if (inputText != null && !inputText.isEmpty()) {
            String result = "";
            switch (index) {
                case 0:
                    result = rot13(inputText);
                    break;
                case 1:
                    result = shift(inputText, 1);
                    break;
                case 2:
                    result = shift(inputText, 5);
                    break;
                case 3:
                    result = reverseShift(inputText, 3);
                    break;
                case 4:
                    result = shift(inputText, 2);
                    break;
                case 5:
                    String shiftValueStr = JOptionPane.showInputDialog(this, "Enter shift value:");
                    int shiftValue = Integer.parseInt(shiftValueStr);
                    result = shift(inputText, shiftValue);
                    break;
                case 6:
                    result = generateMAC(inputText);
                    break;
                case 7:
                    result = encryptHMAC(inputText);
                    break;
                case 8:
                    result = decryptHMAC(inputText);
                    break;
                default:
                    result = "Operation not implemented.";
                    break;
            }
            JOptionPane.showMessageDialog(this, result);
        }
    }

    private String rot13(String input) {
        StringBuilder result = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                result.append((char) ('a' + (c - 'a' + 13) % 26));
            } else if (c >= 'A' && c <= 'Z') {
                result.append((char) ('A' + (c - 'A' + 13) % 26));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    private String shift(String input, int shift) {
        StringBuilder result = new StringBuilder();
        for (char c : input.toCharArray()) {
            result.append((char) (c + shift));
        }
        return result.toString();
    }

    private String reverseShift(String input, int shift) {
        StringBuilder result = new StringBuilder();
        for (char c : input.toCharArray()) {
            result.append((char) (c - shift));
        }
        return result.toString();
    }

    private String generateMAC(String input) {
        // Placeholder for actual MAC generation logic
        return "MAC: " + input.hashCode();
    }

    private String encryptHMAC(String input) {
        // Placeholder for actual HMAC encryption logic
        return "Encrypted HMAC: " + new StringBuilder(input).reverse().toString();
    }

    private String decryptHMAC(String input) {
        // Placeholder for actual HMAC decryption logic
        return "Decrypted HMAC: " + new StringBuilder(input).reverse().toString();
    }

    private void generatePassword() {
        JFrame frame = new JFrame("Strong Password Generator");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));

        JTextField passwordField = new JTextField();
        panel.add(passwordField);
        JButton generateButton = new JButton("Generate Password");
        panel.add(generateButton);
        generateButton.addActionListener(e -> passwordField.setText(generateStrongPassword()));

        frame.add(panel);
        frame.setVisible(true);
    }

    private String generateStrongPassword() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(12);
        for (int i = 0; i < 12; i++) {
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        }
        return sb.toString();
    }

    private void deleteFile() {
        String fileName = JOptionPane.showInputDialog(this, "Enter file name to delete:");
        if (fileName != null && !fileName.isEmpty()) {
            File file = new File(fileName);
            if (file.exists() && file.delete()) {
                JOptionPane.showMessageDialog(this, "File deleted successfully.");
            } else {
                JOptionPane.showMessageDialog(this, "File not found or deletion failed.");
            }
        }
    }

    private void makeFile() {
        String fileName = JOptionPane.showInputDialog(this, "Enter new file name:");
        if (fileName != null && !fileName.isEmpty()) {
            File file = new File(fileName);
            try {
                if (file.createNewFile()) {
                    JOptionPane.showMessageDialog(this, "File created successfully.");
                } else {
                    JOptionPane.showMessageDialog(this, "File already exists.");
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "An error occurred: " + e.getMessage());
            }
        }
    }

    private void extractData() {
        String fileName = JOptionPane.showInputDialog(this, "Enter file name to extract data from:");
        if (fileName != null && !fileName.isEmpty()) {
            FileHandling.filer(fileName);
        }
    }

    private void deleteData() {
        String fileName = JOptionPane.showInputDialog(this, "Enter file name to delete data from:");
        if (fileName != null && !fileName.isEmpty()) {
            try {
                FileWriter writer = new FileWriter(fileName);
                writer.write("");
                writer.close();
                JOptionPane.showMessageDialog(this, "Data deleted successfully.");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "An error occurred: " + e.getMessage());
            }
        }
    }

    private void searchData() {
        String fileName = JOptionPane.showInputDialog(this, "Enter file name to search data in:");
        if (fileName != null && !fileName.isEmpty()) {
            String searchTerm = JOptionPane.showInputDialog(this, "Enter search term:");
            if (searchTerm != null && !searchTerm.isEmpty()) {
                try {
                    String content = new String(Files.readAllBytes(Paths.get(fileName)), StandardCharsets.UTF_8);
                    if (content.contains(searchTerm)) {
                        JOptionPane.showMessageDialog(this, "Data found.");
                    } else {
                        JOptionPane.showMessageDialog(this, "Data not found.");
                    }
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(this, "An error occurred: " + e.getMessage());
                }
            }
        }
    }

    private void showFilesPath() {
        JFrame frame = new JFrame("Files Path");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < fileName[i].length; j++) {
                textArea.append(fileName[i][j] + "\n");
            }
        }
        frame.add(new JScrollPane(textArea));
        frame.setVisible(true);
    }

   

    static class FileHandling {
        static void filer(String filePath) {
            JFrame frame = new JFrame("File Content");
            frame.setSize(600, 400);
            frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            JTextArea textArea = new JTextArea();
            textArea.setEditable(false);
            try {
                String content = new String(Files.readAllBytes(Paths.get(filePath)), StandardCharsets.UTF_8);
                textArea.setText(content);
            } catch (IOException e) {
                textArea.setText("Error reading file: " + e.getMessage());
            }
            frame.add(new JScrollPane(textArea));
            frame.setVisible(true);
        }

        static void filer(String filePath, String data) {
            try (FileWriter writer = new FileWriter(filePath, true)) {
                writer.write(data + System.lineSeparator());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
