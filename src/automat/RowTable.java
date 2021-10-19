package automat;

// Одна строка таблицы переходов - выходов
public class RowTable {
    String[] row = new String[4];

    public RowTable(String currentState, String event, String nextState, String reaction)
    {
        this.row[0] = currentState;
        this.row[1] = event;
        this.row[2] = nextState;
        this.row[3] = reaction;
    }

    // Найти строку по текущему состоянию и входному символу
    public boolean getRowTable(String currentState, String event)
    {
        return currentState.equals(this.row[0]) && event.equals(this.row[1]);
    }
}
