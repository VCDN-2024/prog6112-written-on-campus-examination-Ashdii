
package movieticketsales;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.FileWriter;
import java.io.IOException;

public class MovieTicketSales extends JFrame {

    private JComboBox<String> movieCombo;
    private JTextField ticketCountField, ticketPriceField;
    private JTextArea reportArea;
    private MovieTickets movieTickets;

    public static void main(String[] args) {
        new MovieTicketSales().setVisible(true);
    }

    public MovieTicketSales() {
        setTitle("Movie Ticket Sales");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);

        // Create menu bar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        // Online site
         //Title: Java Swing | JMenuBar
         //Author: Geeksforgeeks 
         //Date: 2022
         //URL:https://www.geeksforgeeks.org/java-swing-jmenubar/
         //Accessed: 12 November 2024

        // File menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);

        // Tools menu
        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem processItem = new JMenuItem("Process");
        JMenuItem clearItem = new JMenuItem("Clear");
        toolsMenu.add(processItem);
        toolsMenu.add(clearItem);
        menuBar.add(toolsMenu);

        // Main panel with BoxLayout for vertical stacking
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // Movie panel
        JPanel moviePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        moviePanel.add(new JLabel("MOVIE:"));
        movieCombo = new JComboBox<>(new String[]{"Napoleon", "Oppenheimer", "Damsel"});
        movieCombo.setPreferredSize(new Dimension(200, 25));
        moviePanel.add(movieCombo);

        // Ticket count panel
        JPanel countPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        countPanel.add(new JLabel("NUMBER OF TICKETS:"));
        ticketCountField = new JTextField();
        ticketCountField.setPreferredSize(new Dimension(200, 25));
        countPanel.add(ticketCountField);

        // Ticket price panel
        JPanel pricePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pricePanel.add(new JLabel("TICKET PRICE:"));
        ticketPriceField = new JTextField();
        ticketPriceField.setPreferredSize(new Dimension(200, 25));
        pricePanel.add(ticketPriceField);

        // Report panel
        JPanel reportPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        reportPanel.add(new JLabel("MOVIE SALES REPORT:"));
        reportArea = new JTextArea(5, 30);
        reportArea.setEditable(false);
        reportPanel.add(new JScrollPane(reportArea));

        // Add panels to the main panel
        mainPanel.add(moviePanel);
        mainPanel.add(countPanel);
        mainPanel.add(pricePanel);
        mainPanel.add(reportPanel);

        // Add main panel to the frame
        add(mainPanel);

        // Online site
         //Title: Java AWT Panel
         //Author: Geeksforgeeks 
         //Date: 2023
         //URL:https://www.geeksforgeeks.org/java-awt-panel/
         //Accessed: 12 November 2024


        // Event listeners
        exitItem.addActionListener(e -> System.exit(0));
        processItem.addActionListener(e -> processReport());
        clearItem.addActionListener(e -> clearFields());

        movieTickets = new MovieTickets();
    }

    private void processReport() {
        String movie = (String) movieCombo.getSelectedItem();
        String ticketCount = ticketCountField.getText();
        String ticketPrice = ticketPriceField.getText();

        Data data = new Data(movie, ticketCount, ticketPrice);

        if (movieTickets.validateData(data)) {
            double totalAmount = movieTickets.calculateTotal(ticketCount, ticketPrice);

            reportArea.setText("MOVIE: " + movie + "\n" +
                    "NUMBER OF TICKETS: " + ticketCount + "\n" +
                    "TICKET PRICE: R" + ticketPrice + "\n" +
                    "TOTAL (incl. VAT): R" + totalAmount);

            saveReport(reportArea.getText());
        } else {
            JOptionPane.showMessageDialog(this, "Invalid data entered. Please check the input fields.");
        }
    }

    private void saveReport(String reportText) {
        try (FileWriter writer = new FileWriter("report.txt")) {
            writer.write(reportText);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving report: " + e.getMessage());
        }
    }

    private void clearFields() {
        movieCombo.setSelectedIndex(0);
        ticketCountField.setText("");
        ticketPriceField.setText("");
        reportArea.setText("");
    }

    // Data class to hold movie data
    class Data {
        private String movie;
        private String ticketCount;
        private String ticketPrice;

        public Data(String movie, String ticketCount, String ticketPrice) {
            this.movie = movie;
            this.ticketCount = ticketCount;
            this.ticketPrice = ticketPrice;
        }
        
        // Online site
         //Title: How to generate data classes in Java
         //Author: freeCampCode
         //Date: 2018
         //URL:https://www.freecodecamp.org/news/how-to-generate-data-classes-in-java-fead8fa354a2/
         //Accessed: 12 November 2024 

        public String getMovie() {
            return movie;
        }

        public String getTicketCount() {
            return ticketCount;
        }

        public String getTicketPrice() {
            return ticketPrice;
        }
    }
}
