package codeworks.java8features.streams;

import java.util.IntSummaryStatistics;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class L02TerminalOps {
	public static void main(String[] args) {
		usingMin();
	}
	protected static void usingForEach() {
		Stream.of("A", "B", "C").forEach(System.out::println);
	}
	protected static void usingForEachOrdered() {
		Stream.of("A", "B", "C").parallel().forEachOrdered(System.out::println);
	}
	protected static void usingToArray() {
		Object[] arr = Stream.of(1, 2, 3).toArray();
		Stream.of(arr).forEach(System.out::println);
	}
	protected static void usingReduce() {
		int sum = Stream.of(1, 2, 3, 4)
                .reduce(0, Integer::sum);
		System.out.println(sum);
	}
	protected static void usingCollect() {
		List<Integer> list = Stream.of(1, 2, 3, 4, 5).collect(Collectors.toList());
		list.stream().forEach(System.out::println);
	}
	protected static void usingMin() {
		Optional<Integer> min = Stream.of(2, 3, 6).min(Integer::compareTo);
		Optional<Integer> max= Stream.of(5, 7, 2, 8).max(Integer::compareTo);
		System.out.println("min: " + min + ", max: " + max);
		
		long count = Stream.of("A", "B", "C").count();
		
//		There are 5 short-circuit terminal operations:
		boolean result1 = Stream.of(1, 2, 3).anyMatch(n -> n > 2);
		boolean result2 = Stream.of(1, 2, 3).allMatch(n -> n > 0);
		boolean result3 = Stream.of(1, 2, 3).noneMatch(n -> n < 0);
		Optional<Integer> first = Stream.of(1, 2, 3).findFirst();
		Optional<Integer> any = Stream.of(1, 2, 3).parallel().findAny();
		
		
		Iterator<Integer> it = Stream.of(1, 2, 3).iterator();
		List<Integer> list = Stream.of(1, 2, 3).toList();
		
		int sum = IntStream.of(1,2,3).sum();
		OptionalDouble avg = IntStream.of(1,2,3).average();
		IntSummaryStatistics stats = IntStream.of(1,2,3).summaryStatistics();
	}
}