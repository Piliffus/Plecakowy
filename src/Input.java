import java.util.Scanner;

public class Input
{

    public int getNumber()
    {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public int getNumberEndl()
    {
        Scanner scanner = new Scanner(System.in);
        int temp = getNumber();
        scanner.nextLine();
        return temp;
    }
}