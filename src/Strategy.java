import java.util.ArrayList;

public abstract class Strategy
{
    protected int totalPrice;
    protected int totalWastage;
    protected ArrayList<ArrayList<Length>> usedRods;
    protected int howManyRods;

    protected abstract void orderArrays(Plan plan, PriceList priceList);

    protected void takeNewRod(PriceList priceList, IntReference remainder, IntReference howManyPieces, Length howLong)
    {
        Rod rod = findRod(priceList, howLong);
        this.totalPrice += rod.getPrice().getValue();
        this.howManyRods++;
        howManyPieces.setValue(1);
        usedRods.add(howManyRods-1, new ArrayList<>(1));
        usedRods.get(howManyRods-1).add(howManyPieces.getValue()-1, rod.getLength());

        remainder.setValue(rod.getLength().getValue());
    }

    protected abstract Rod findRod(PriceList priceList, Length howLong);

    public void solveProblem(Plan plan, PriceList priceList)
    {
        orderArrays(plan, priceList);

        IntReference remainder = new IntReference(0);
        IntReference howManyPieces = new IntReference(0);

        for (int i = 0; i < plan.getSize(); i++)
        {
            if (plan.getLengths()[i].getValue() != 0)
            {
                if (remainder.getValue() < plan.getLengths()[i].getValue())
                {
                    tryNext(remainder, howManyPieces, plan, i);
                    // we know that there is at least one piece not covered by tryNext
                    throwAway(remainder);
                    takeNewRod(priceList, remainder, howManyPieces, plan.getLengths()[i]);
                }

                cutOff(remainder, plan.getLengths()[i].getValue(), howManyPieces, plan.getLengths()[i]);
            }
        }

        throwAway(remainder);

        Output.readPrice(totalPrice);
        Output.readWastage(totalWastage);
        Output.readUsedRods(usedRods);
    }

    private void tryNext(IntReference remainder, IntReference howManyPieces, Plan plan, int i)
    {
        i++;
        if (i < plan.getSize())
        {
            if (remainder.getValue() >= plan.getLengths()[i].getValue())
            {
                cutOff(remainder, plan.getLengths()[i].getValue(), howManyPieces, plan.getLengths()[i]);
                tryNext(remainder, howManyPieces, plan, i);
            }
            else
            {
                tryNext(remainder, howManyPieces, plan, i);
            }
        }

    }

    private void cutOff(IntReference remainder, int howMuch, IntReference howManyPieces, Length length)
    {
        howManyPieces.setValue(howManyPieces.getValue()+1);
        remainder.setValue(remainder.getValue() - howMuch);
        usedRods.get(this.howManyRods-1).add(howManyPieces.getValue() - 1, new Length(howMuch));
        length.setValue(0);
    }

    private void throwAway(IntReference remainder)
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
