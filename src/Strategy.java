import java.util.ArrayList;

public abstract class Strategy
{
    protected int totalPrice;
    protected int totalWastage;
    protected ArrayList<ArrayList<Length>> usedRods;
    protected int howManyRods;

    protected abstract void orderArrays(Plan plan, PriceList priceList);

    protected void takeNewRod(PriceList priceList, IntReference remainder, Length howLong)
    {
        Rod rod = findRod(priceList, howLong);
        this.totalPrice += rod.getPrice().getValue();
        this.howManyRods++;
        usedRods.add(howManyRods-1, new ArrayList<>(1));
        usedRods.get(howManyRods-1).add(0, rod.getLength());

        remainder.setValue(rod.getLength().getValue());
    }

    protected abstract Rod findRod(PriceList priceList, Length howLong);

    public void solveProblem(Plan plan, PriceList priceList)
    {
        orderArrays(plan, priceList);

        IntReference remainder = new IntReference(0);

        for (int i = 0; i < plan.getSize(); i++)
        {
            if (plan.getLengths()[i].getValue() != 0)
            {
                if (remainder.getValue() < plan.getLengths()[i].getValue())
                {
                    tryNext(remainder, plan, i);
                    // we know that there is at least one piece not covered by tryNext
                    throwAway(remainder);
                    takeNewRod(priceList, remainder, plan.getLengths()[i]);
                }

                cutOff(remainder, plan.getLengths()[i].getValue(), plan.getLengths()[i]);
            }
        }

        throwAway(remainder);

        Output.readPrice(totalPrice);
        Output.readWastage(totalWastage);
        Output.readUsedRods(usedRods);
    }

    protected void tryNext(IntReference remainder, Plan plan, int i)
    {
        i++;
        if (i < plan.getSize())
        {
            if (remainder.getValue() >= plan.getLengths()[i].getValue())
            {
                cutOff(remainder, plan.getLengths()[i].getValue(), plan.getLengths()[i]);
                tryNext(remainder, plan, i);
            }
            else
            {
                tryNext(remainder, plan, i);
            }
        }

    }

    protected void cutOff(IntReference remainder, int howMuch, Length length)
    {
        remainder.setValue(remainder.getValue() - howMuch);
        usedRods.get(this.howManyRods-1).add(new Length(howMuch));
        length.setValue(0);
    }

    protected void throwAway(IntReference remainder)
    {
        this.totalWastage += remainder.getValue();
        remainder.setValue(0);
    }

    public Strategy()
    {
        this.totalPrice = 0;
        this.totalWastage = 0;
        this.howManyRods = 0;
        usedRods = new ArrayList<>(howManyRods);
    }
}
