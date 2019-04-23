import java.util.ArrayList;

public abstract class ComplexStrategy extends Strategy
{
    private ArrayList<ArrayList<Length>> copyRods(ArrayList<ArrayList<Length>> usedRods)
    {
        ArrayList<ArrayList<Length>> usedRodsCopy = new ArrayList<>(usedRods.size());
        for (int i = 0; i < usedRods.size(); i++)
        {
            usedRodsCopy.add(i, new ArrayList<>(usedRods.get(i).size()));
            for (int y = 0; y < usedRods.get(i).size(); y++)
            {
                usedRodsCopy.get(i).add(y, new Length(usedRods.get(i).get(y).getValue()));
            }
        }

        return usedRodsCopy;
    }

    @Override
    public void solveProblem(Plan plan, PriceList priceList)
    {
        ArrayList<ComplexStrategy> solutions = new ArrayList<>();
        this.howManyRods = -1;
        solveProblemRecurrent(plan, priceList, new IntReference(0), 0,
                new Length(0), new Price(0), solutions);
        sortSolutions(solutions);

        Output.readPrice(solutions.get(0).totalPrice);
        Output.readWastage(solutions.get(0).totalWastage);
        Output.readUsedRods(solutions.get(0).usedRods);
    }

    protected abstract void sortSolutions(ArrayList<ComplexStrategy> solutions);

    private void takeNewRod(Plan plan, PriceList priceList, Length howLong, int i, ArrayList<ComplexStrategy> solutions)
    {
        for (Rod rod : priceList.getRods())
        {
            if (rod.getLength().getValue() >= howLong.getValue())
            {
                Economic newWay = new Economic(this.totalPrice, this.totalWastage, this.usedRods, this.howManyRods);
                newWay.solveProblemRecurrent(new Plan(plan), priceList, new IntReference(rod.getLength().getValue()),
                        i, rod.getLength(), rod.getPrice(), solutions);
            }
        }
    }

    protected void solveProblemRecurrent(Plan plan, PriceList priceList, IntReference remainder, int i, Length rodLength,
                                      Price whatWeBought, ArrayList<ComplexStrategy> solutions)
    {
        this.howManyRods++;
        this.totalPrice += whatWeBought.getValue();

        if (this.howManyRods > 0)
        {
            usedRods.add(howManyRods - 1, new ArrayList<>(1));
            usedRods.get(howManyRods - 1).add(0, rodLength);
        }

        for (; i < plan.getSize(); i++)
        {
            if (plan.getLengths()[i].getValue() != 0)
            {
                if (remainder.getValue() < plan.getLengths()[i].getValue())
                {
                    tryNext(remainder, plan, i);
                    // we know that there is at least one piece not covered by tryNext
                    throwAway(remainder);
                    takeNewRod(plan, priceList, plan.getLengths()[i], i, solutions);
                    return;
                }

                cutOff(remainder, plan.getLengths()[i].getValue(), plan.getLengths()[i]);
            }
        }

        throwAway(remainder);

        if (this.howManyRods > 0)
        {
            solutions.add(this);
        }
    }

    @Override
    protected Rod findRod(PriceList priceList, Length howLong)
    {
        return null;
    }

    @Override
    protected void orderArrays(Plan plan, PriceList priceList)
    {
        plan.sortLengths();
        priceList.sortRodsByLength();
    }

    public ComplexStrategy(int totalPrice, int totalWastage, ArrayList<ArrayList<Length>> usedRods, int howManyRods)
    {
        this.totalPrice = totalPrice;
        this.totalWastage = totalWastage;
        this.usedRods = copyRods(usedRods);
        this.howManyRods = howManyRods;
    }

    public ComplexStrategy()
    {
        super();
    }
}
