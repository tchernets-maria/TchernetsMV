package automat;

import java.util.ArrayList;

// Автомат
public class FSM {
    // Начальное состояние
    public String StartState;
    // Таблица переходов - выходов
    public ArrayList<RowTable> StateTable = new ArrayList<>();

    public FSM(String startState)
    {
        this.StartState = startState;
    }

    // Добавление строки в таблицу переходов - выходов
    public void addRowStateTable(RowTable row) {
        StateTable.add(row);
    }

    // Возвращает отображение таблицы переходов - выходов
    public ArrayList<RowTable> getStateTable() {
        return StateTable;
    }

    // Просмотр начального состояния
    public String getStartState() {
        return StartState;
    }

    // Функция перехода
    public String transit(String currentState, String event) {
        String nextState = null;
        for (RowTable desiredString : StateTable)
        {
            if (desiredString.getRowTable(currentState, event))
            {
                nextState = desiredString.row[2];
            }
        }
        return nextState;
    }

    // Функция выхода
    public String reaction(String currentState, String event) {
        String reaction = null;
        for (RowTable desiredString : StateTable)
        {
            if (desiredString.getRowTable(currentState, event))
            {
                reaction = desiredString.row[3];
                break;
            }
        }
        return reaction;
    }
}
