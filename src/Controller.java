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
        makePlan();
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

    private void makePlan()
    {
        Plan plan = new Plan();
        int size = userInput.getNumberEndl();
        plan.setSize(size);

        for (int i = 0; i < size-1; i++)
        {
            plan.setPiece(i, userInput.getNumber());
        }

        plan.setPiece(size-1, userInput.getNumberEndl());
    }
}
