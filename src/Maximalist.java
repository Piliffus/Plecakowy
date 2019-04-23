public class Maximalist extends Strategy
{
    @Override
    protected Rod findRod(PriceList priceList, Length howLong)
    {
        return priceList.getRods()[0]; // Maximalist: only longest rod, and we ordered them biggest to smallest before
    }

    @Override
    protected void orderArrays(Plan plan, PriceList priceList)
    {
        priceList.sortRodsByLengthReverseOrder();
        plan.sortLengths();
    }

    public Maximalist()
    {
        super();
    }
}
