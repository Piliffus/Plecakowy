import java.util.ArrayList;

public class Controller
{
    Input userInput;
    Output userOutput;

    public void start()
    {
        Input userInput = new Input();
        Output userOutput = new Output();
        solveRodProblem();
    }

    private void solveRodProblem()
    {
        makeRods();
    }

    private void makeRods()
    {
        int howManyRods = userInput.getNumberEndl();
        Rod[] rods = new Rod[howManyRods];

        for (int i = 0; i < howManyRods; i++)
        {
            rods[i] = new Rod(userInput.getNumber(), userInput.getNumberEndl());
        }
    }
}
