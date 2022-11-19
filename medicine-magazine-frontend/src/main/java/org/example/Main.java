package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Magazyn Apteki Szpitalnej");
        frame.setMinimumSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        MedicineWebClient medicineWebClient = new MedicineWebClient();
        List<Medicine> medicines = new ArrayList<>();
        MedicineTableModel tableModel = new MedicineTableModel(medicines);
        JTable table = new JTable(tableModel);
        table.setAutoCreateRowSorter(true);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        JButton loadDataButton = new JButton("Wczytaj dane");
        loadDataButton.addActionListener(e -> {
            try {
                medicines.clear();
                medicines.addAll(medicineWebClient.getMedicines());
                tableModel.fireTableDataChanged();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Wystąpił błąd w czasie pobierania danych!",
                        "Wystąpił błąd!", JOptionPane.ERROR_MESSAGE);
            }
        });

        frame.getContentPane().add(loadDataButton, BorderLayout.NORTH);
        frame.pack();
        frame.setVisible(true);
    }
}