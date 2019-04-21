public class Controller
{
    private PriceList priceList;
    private Plan plan;
    private Strategy strategy;

    public void start()
    {
        solveRodProblem();
    }

    private void solveRodProblem()
    {
        preparePriceList();
        Test.priceListTest(priceList);
        preparePlan();
        Test.planTest(plan);
        askForStrategy();
        strategy.solveProblem(plan, priceList);
        Test.priceListTest(priceList);
        Test.planTest(plan);
    }

    private void preparePriceList()
    {
        priceList = new PriceList(Input.getNumber());
    }

    private void preparePlan()
    {
        plan = new Plan(Input.getNumber());
    }

    private void askForStrategy()
    {
        switch (Input.getString())
        {
            case "minimalistyczna":
                strategy = new Minimalist();
                break;
            case "ekologiczna":
                strategy = new Ecologic();
                break;
            case "maksymalistyczna":
                strategy = new Maximalist();
                break;
            case "ekonomiczna":
                strategy = new Economic();
                break;
        }
    }
}
