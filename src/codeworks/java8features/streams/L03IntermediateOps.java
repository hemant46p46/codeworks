package codeworks.java8features.streams;

import java.util.List;
import java.util.stream.Stream;

public class L03IntermediateOps {
	public static void main(String[] args) {
		u02Map();
	}
	protected void h() {
		System.out.print("Hii");
	}
	protected static void u01filter() {
		Stream.of(1,2,3,4).filter(n -> n % 2 == 0).forEach(System.out::println);
	}
	protected static void u02Map() {
		Stream.of("a","b","c").map(String::toUpperCase).forEach(System.out::println);
		Stream.of(List.of(1,2), List.of(3,4)).flatMap(List::stream).forEach(System.out::println);
	}
	protected static void usingDistinct() {
		Stream.of(1,2,2,3).distinct().forEach(System.out::println);
	}
	protected static void usingSorted() {
		Stream.of(4,1,3).sorted().forEach(System.out::println);
	}
	protected static void usingPeek() {
		Stream.of(1,2,3).peek(System.out::println).count();
	}
	protected static void usingSkip() {
		Stream.of(1,2,3,4).skip(2).forEach(System.out::println);
	}
	protected static void mapToNumber() {
		Stream.of("1","2","3")
	      .mapToInt(Integer::parseInt)
	      .sum();
		
		Stream.of("1","2")
	      .mapToLong(Long::parseLong)
	      .sum();
		
		Stream.of("1.5","2.5")
	      .mapToDouble(Double::parseDouble)
	      .sum();
		
		Stream.of(List.of(1,2), List.of(3))
	      .flatMapToInt(list -> list.stream().mapToInt(i -> i))
	      .sum();
	}
	
	protected static void j9Addition() {
		Stream.of(1,2,3,4,1)
	      .takeWhile(n -> n < 3)
	      .forEach(System.out::println);
		
		Stream.of(1,2,3,4,1)
	      .dropWhile(n -> n < 3)
	      .forEach(System.out::println);
	}
}