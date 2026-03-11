package codeworks.java8features.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class L01Creation {
	public static void main(String[] args) {
		usingRandomClass();
	}
	protected static void usingCollection() {
		List<String> list1 = Arrays.asList("A","B","C");
		Stream<String> stream = list1.stream();
		Stream<String> pStream = list1.parallelStream();
	}
	protected static void usingArray() {
		String[] arr = {"A", "B", "C"};
		Stream<String> stream1 = Arrays.stream(arr);
		Stream<String> stream2 = Stream.of(arr);
	}
	protected static void streamOf() {
		Stream<Integer> stream = Stream.of(1, 2, 3, 4);
	}
	protected static void streamBuilder() {
		Stream<String> stream = Stream.<String>builder()
		        .add("A")
		        .add("B")
		        .add("C")
		        .build();
	}
	protected static void usingStreamGenerate() {
		Stream<Double> stream = Stream.generate(Math::random);
		Stream.generate(Math::random)
	      .limit(5)
	      .forEach(System.out::println);
//		stream.forEach(System.out::println);
	}
	protected static void usingStreamIterate() {
//		Infinite
//		Stream<Integer> stream = Stream.iterate(0, n -> n + 2);
//		stream.forEach(System.out::println);
		
//		Limit with a number
//		Stream.iterate(0, n -> n+2).limit(5).forEach(System.out::println);
		
//		limit with condition
		Stream.iterate(0, n -> n < 10, n -> n + 2).forEach(System.out::println);;
	}
	protected static void primitiveStream() {
		IntStream.range(1, 5).forEach(System.out::println);
		IntStream.rangeClosed(1, 5).forEach(System.out::println);
		LongStream.of(1L, 2L, 3L).forEach(System.out::println);
		DoubleStream.of(1.0, 2.0).forEach(System.out::println);
	}
	protected static void usingFiles() {
		try {
			Stream<String> lines = Files.lines(Paths.get("file.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	protected static void usingRandomClass() {
		Random random = new Random();
		IntStream stream = random.ints();
		stream.forEach(System.out::println);
	}
}