package org.example;

import javax.swing.table.AbstractTableModel;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class MedicineTableModel extends AbstractTableModel {

    private final String[] COLUMN_NAMES = {"Id", "Nazwa leku", "Data ważności", "Liczba opakowań w magazynie"};
    private List<Medicine> medicines;

    public MedicineTableModel(List<Medicine> medicines) {
        this.medicines = medicines;
    }

    @Override
    public int getRowCount() {
        if (medicines == null) {
            return 0;
        }
        return medicines.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return medicines.get(rowIndex).getId();
        } else if (columnIndex == 1) {
            return medicines.get(rowIndex).getName();
        } else if (columnIndex == 2) {
            return medicines.get(rowIndex).getExpirationDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } else if (columnIndex == 3) {
            return medicines.get(rowIndex).getPackagesNumberInMagazine();
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }

    @Override
    public Class<?> getColumnClass(int column) {
        if (column == 0) {
            return Long.class;
        } else if (column == 3) {
            return Integer.class;
        } else {
            return String.class;
        }
    }

}
