package es.uji.al415716;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CSV {
    public Table readTable(String filePath) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filePath));
        Table table = new Table();
        table.setHeaders(List.of(scanner.nextLine().split(",")));
        while (scanner.hasNextLine()) {
            table.addRow(List.of(scanner.nextLine().split(",")));
        }

        return table;
    }

    public TableWithLabels readTableWithLabels(String filePath) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filePath));
        TableWithLabels tableWithLabels = new TableWithLabels();
        tableWithLabels.setHeaders(List.of(scanner.nextLine().split(",")));

        String stringClass;

        while (scanner.hasNextLine()) {
            String read = scanner.nextLine();
            int lastComa = read.lastIndexOf(',');
            stringClass = read.substring(lastComa + 1);
            List<String> list = List.of(read.substring(0, lastComa).split(","));

            tableWithLabels.addRowWithLabel(list, stringClass);
        }

        return tableWithLabels;
    }
}
