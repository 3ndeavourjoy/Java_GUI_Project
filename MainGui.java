import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

// Main GUI class
public class MainGui {
    private JFrame frame;
    private JTextField consultancyNameField;
    private JTextField consultancyIdField;
    private JTextField consultancyEmaField;
    private JTextField consultancyPhonField;
    private JComboBox<ConsultancyType> consultancyTypeComboBox;
    private JTextField consultancyOrgNameField;
    private JTextArea consultancyInfoArea;

    // Constructor
    public MainGui() {
        initialize();
    }

    // Initialize GUI components
    private void initialize() {
        // Create the main frame
        frame = new JFrame();
        frame.setBounds(300, 100, 500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        // Set the background image
        ImageIcon backgroundImage = new ImageIcon("download.jpg");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, 500, 500);
        frame.getContentPane().add(backgroundLabel);

        // Set the font
        Font setFont = new Font("Arial", Font.BOLD, 14);

        // Consultancy Type ComboBox
        JLabel lblNewLabel_2 = new JLabel("Consultancy Type:");
        lblNewLabel_2.setBounds(29, 200, 150, 14);
        lblNewLabel_2.setFont(setFont);
        lblNewLabel_2.setForeground(Color.black);
        frame.getContentPane().add(lblNewLabel_2);

        consultancyTypeComboBox = new JComboBox<>(ConsultancyType.values());
        consultancyTypeComboBox.setBounds(170, 197, 200, 28);
        frame.getContentPane().add(consultancyTypeComboBox);

        // Consultancy ID TextField
        JLabel lblConsultancyId = new JLabel("Consultancy ID:");
        lblConsultancyId.setBounds(29, 240, 150, 14);
        lblConsultancyId.setFont(setFont);
        lblConsultancyId.setForeground(Color.black);
        frame.getContentPane().add(lblConsultancyId);

        consultancyIdField = new JTextField();
        consultancyIdField.setBounds(150, 237, 200, 28);
        frame.getContentPane().add(consultancyIdField);

        // Consultancy Email TextField
        JLabel lblConsultancyEma = new JLabel("Consultancy Email:");
        lblConsultancyEma.setBounds(29, 280, 150, 14);
        lblConsultancyEma.setFont(setFont);
        lblConsultancyEma.setForeground(Color.black);
        frame.getContentPane().add(lblConsultancyEma);

        consultancyEmaField = new JTextField();
        consultancyEmaField.setBounds(170, 277, 200, 28);
        frame.getContentPane().add(consultancyEmaField);

        // Consultancy Phone TextField
        JLabel lblConsultancyPhon = new JLabel("Consultancy Phone:");
        lblConsultancyPhon.setBounds(29, 320, 150, 14);
        lblConsultancyPhon.setFont(setFont);
        lblConsultancyPhon.setForeground(Color.black);
        frame.getContentPane().add(lblConsultancyPhon);

        consultancyPhonField = new JTextField();
        consultancyPhonField.setBounds(170, 317, 200, 28);
        frame.getContentPane().add(consultancyPhonField);

        // Consultancy Name TextField
        JLabel lblConsultancyName = new JLabel("Consultancy Name:");
        lblConsultancyName.setBounds(29, 360, 150, 14);
        lblConsultancyName.setFont(setFont);
        lblConsultancyName.setForeground(Color.black);
        frame.getContentPane().add(lblConsultancyName);

        consultancyNameField = new JTextField();
        consultancyNameField.setBounds(170, 357, 200, 28);
        frame.getContentPane().add(consultancyNameField);

        // Consultancy Organization Name TextField
        JLabel lblConsultancyOrgName = new JLabel("Consultancy Organization Name:");
        lblConsultancyOrgName.setBounds(29, 540, 200, 14);
        lblConsultancyOrgName.setFont(setFont);
        lblConsultancyOrgName.setForeground(Color.black);
        frame.getContentPane().add(lblConsultancyOrgName);

        consultancyOrgNameField = new JTextField();
        consultancyOrgNameField.setBounds(220, 537, 200, 28);
        frame.getContentPane().add(consultancyOrgNameField);

        // Consultancy Info TextArea
        JLabel lblConsultancyInfo = new JLabel("Consultancy Info:");
        lblConsultancyInfo.setBounds(29, 400, 150, 14);
        lblConsultancyInfo.setFont(setFont);
        lblConsultancyInfo.setForeground(Color.black);
        frame.getContentPane().add(lblConsultancyInfo);

        consultancyInfoArea = new JTextArea();
        consultancyInfoArea.setBounds(170, 397, 200, 100);
        frame.getContentPane().add(consultancyInfoArea);

        // Save Button
        JButton btnSave = new JButton("Save to File");
        btnSave.setBounds(29, 580, 150, 25);
        btnSave.setBackground(Color.GREEN);
        frame.getContentPane().add(btnSave);
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveToFile();
            }
        });

        // Retrieve Button
        JButton btnRetrieve = new JButton("Retrieve from File");
        btnRetrieve.setBounds(200, 580, 150, 25);
        btnRetrieve.setBackground(Color.BLUE);
        btnRetrieve.setForeground(Color.black);
        frame.getContentPane().add(btnRetrieve);
        btnRetrieve.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                retrieveFromFile();
            }
        });

        // Set frame visibility
        frame.setVisible(true);
    }

    // Save data to file
    private void saveToFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("consultancy_data.txt"))) {
            // Create Consultancy object
            Consultancy consultancy = new Consultancy(
                    consultancyNameField.getText(),
                    consultancyIdField.getText(),
                    (ConsultancyType) consultancyTypeComboBox.getSelectedItem(),
                    consultancyEmaField.getText(),
                    consultancyPhonField.getText(),
                    consultancyOrgNameField.getText(),
                    consultancyInfoArea.getText()
            );
            // Write Consultancy object to file
            out.writeObject(consultancy);
            JOptionPane.showMessageDialog(frame, "Consultancy data saved to file successfully.");
        } catch (IOException | NumberFormatException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error saving data to file." + ex.getMessage());
        }
    }

    // Retrieve data from file
    private void retrieveFromFile() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("consultancy_data.txt"))) {
            // Read Consultancy object from file
            Consultancy savedConsultancy = (Consultancy) in.readObject();
            System.out.println(savedConsultancy);
            // Display Consultancy details
            displayConsultancyDetails(savedConsultancy);
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error retrieving data from file." + ex.getMessage());
        }
    }

    // Display Consultancy details
    private void displayConsultancyDetails(Consultancy consultancy) {
        JOptionPane.showMessageDialog(frame, "Consultancy Details:\n" +
                "Consultancy Name: " + consultancy.getConsultancyName() + "\n" +
                "Consultancy ID: " + consultancy.getConsultancyId() + "\n" +
                "Email: " + consultancy.getConsultancyEmail() + "\n" +
                "Phone: " + consultancy.getConsultancyPhoneNumber() + "\n" +
                "Consultancy Type: " + consultancy.getConsultancyType() + "\n" +
                "Organization Name: " + consultancy.getConsultancyOrgName() + "\n" +
                "Consultancy Info: " + consultancy.getConsultancyInfo());
    }

    // Main method
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainGui window = new MainGui();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
