import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Lambda {

	//Declarative approach
	private static boolean isPrime(int number) {		
		return number > 1
				&& IntStream.range(2, number).noneMatch(
						index -> number % index == 0);
	}


	private static boolean isPrimeNum(int number) {
		IntPredicate isDivisible = index -> number % index == 0;

		return number > 1
				&& IntStream.range(2, number).noneMatch(
						isDivisible);
	}


	public static double sumWithCondition(List<Integer> numbers, Predicate<Integer> predicate) {
		return numbers.parallelStream()
				.filter(predicate)
				.mapToInt(i -> i)
				.sum();
	}

	public static double sumWithConditionSeq(List<Integer> numbers, Predicate<Integer> predicate) {
		return numbers.stream()
				.filter(predicate)
				.mapToInt(i -> i)
				.sum();
	}

	private static double sumNormal(List<Integer> numbers) {		
		int sum=0;
		for(int i=0; i<numbers.size(); i++){
			sum+=numbers.get(i);
		}
		return sum;
	}



	public static int findSquareOfMaxOdd(List<Integer> numbers) {
		return numbers.stream()
				.filter(Lambda::isOdd) 		//Predicate is functional interface and
				.filter(Lambda::isGreaterThan3)	// we are using lambdas to initialize it
				.filter(Lambda::isLessThan11)	// rather than anonymous inner classes
				.max(Comparator.naturalOrder())
				.map(i -> i * i)
				.get();
	}

	public static boolean isOdd(int i) {
		return i % 2 != 0;
	}

	public static boolean isGreaterThan3(int i){
		return i > 3;
	}

	public static boolean isLessThan11(int i){
		return i < 11;
	}


	private static int findSquareOfMaxOddNormal(List<Integer> numbers) {
		int max = 0;
		for (int i : numbers) {
			if (i % 2 != 0 && i > 3 && i < 11 && i > max) {
				max = i;
			}
		}
		return max * max;
	}

	public static void main(String aa[])
	{
		System.out.println(Lambda.isPrime(4));
		System.out.println(Lambda.isPrimeNum(4));

		List<Integer> numbers= new ArrayList<>();
		for(int i=1;i<9999999;i++)
		{
			numbers.add(i);	
		}
		System.out.println("adding done.");
		//sum of all numbers
		long st =System.currentTimeMillis();
		System.out.println(sumWithCondition(numbers, n -> true));
		long ed =System.currentTimeMillis();
		System.out.println("duration: "+ (ed-st));
		/*st =System.currentTimeMillis();	
		System.out.println(sumWithConditionSeq(numbers, n -> true));
		ed =System.currentTimeMillis();
		System.out.println("duration: "+ (ed-st));

*/		st =System.currentTimeMillis();	
		System.out.println(sumNormal(numbers));
		ed =System.currentTimeMillis();
		System.out.println("duration: "+ (ed-st));

		System.out.println("Range:");

		st =System.currentTimeMillis();	
		System.out.println(findSquareOfMaxOdd(numbers));
		ed =System.currentTimeMillis();
		System.out.println("duration: "+ (ed-st));


		st =System.currentTimeMillis();	
		System.out.println(findSquareOfMaxOddNormal(numbers));
		ed =System.currentTimeMillis();
		System.out.println("duration: "+ (ed-st));

		//sum of all even numbers
		System.out.println(sumWithCondition(numbers, i -> i%2==0));
		//sum of all numbers greater than 5
		System.out.println(sumWithCondition(numbers, i -> i>5));

	}
}
