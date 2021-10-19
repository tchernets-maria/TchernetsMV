package automat;

// Работа автомата
public class WorkFSM
{
    // Последовательность состояний
    public String StringState;
    // Выходная последовательность
    public String StringOutput;
    // Автомат
    public FSM machine;

    // Нахождение последовательности состояний
    public String sequenceOfStates(String inputs)
    {
        String currentState = machine.getStartState();
        String tek;
        StringState = currentState;
        for (int i = 0; i < inputs.length(); i++)
        {
            tek = currentState;
            StringState += " " + machine.transit(tek, String.valueOf(inputs.charAt(i)));
            currentState = machine.transit(tek, String.valueOf(inputs.charAt(i)));
        }
        return StringState;
    }

    // Нахождение выходной последовательности
    public String sequenceOfOutputs(String inputs, String stringStates)
    {
        String[] result = stringStates.split(" ");

        StringOutput = machine.reaction(result[0], String.valueOf(inputs.charAt(0)));
        for (int i = 1; i < inputs.length(); i++)
        {
            String tekInput = String.valueOf(inputs.charAt(i));
            StringOutput += machine.reaction(result[i], tekInput);
        }
        return StringOutput;
    }
}
