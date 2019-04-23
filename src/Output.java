import java.util.ArrayList;

public class Output
{
    public static void readRod(Rod rod)
    {
        System.out.println(rod.toString());
    }

    public static void readLength(Length length)
    {
        System.out.println(length.toString());
    }

    public static void readPrice(int totalPrice)
    {
        System.out.println(totalPrice);
    }

    public static void readWastage(int totalWastage)
    {
        System.out.println(totalWastage);
    }

    public static void readUsedRods(ArrayList<ArrayList<Length>> usedRods)
    {
        for (ArrayList<Length> rod: usedRods)
        {
            for (Length pieces : rod)
            {
                System.out.print(pieces.getValue() + " ");
            }
            System.out.print("\n");
        }
    }
}
