import java.util.*;

public class SumUsingAutoboxing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();

        System.out.println("Enter integers separated by spaces:");
        String input = sc.nextLine();

        // Split input and parse each number
        String[] tokens = input.split(" ");
        for (String token : tokens) {
            // Parsing String → int, then autoboxed into Integer
            Integer num = Integer.parseInt(token);
            numbers.add(num);
        }

        // Calculate sum (Unboxing happens here)
        int sum = 0;
        for (Integer n : numbers) {
            sum += n;  // unboxing Integer → int
        }

        System.out.println("Numbers: " + numbers);
        System.out.println("Sum = " + sum);

        sc.close();
    }
}
