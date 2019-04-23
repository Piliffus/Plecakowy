public class Minimalist extends Strategy
{
    @Override
    protected Rod findRod(PriceList priceList, Length howLong)
    {
        for (int i = 0; i < priceList.getSize(); i++)
        {
            // we ordered rods from smallest to biggest before, so first one we find will be ok
            if (priceList.getRods()[i].getLength().getValue() >= howLong.getValue())
            {
                return priceList.getRods()[i];
            }
        }

        return null; // this would mean that problem is unsolvable
    }

    @Override
    protected void orderArrays(Plan plan, PriceList priceList)
    {
        priceList.sortRodsByLength();
        plan.sortLengths();
    }

    public Minimalist()
    {
        super();
    }
}
