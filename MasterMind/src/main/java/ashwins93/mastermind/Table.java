package ashwins93.mastermind;

import java.util.LinkedList;
import java.util.List;

public class Table {
    final ColorManager manager;
    final int nrColumns;
    final List<Row> rows = new LinkedList<>();

    public Table(ColorManager manager, int nrColumns) {
        this.manager = manager;
        this.nrColumns = nrColumns;
    }

    public void addRow(Row row) {
        this.rows.add(row);
    }
}
