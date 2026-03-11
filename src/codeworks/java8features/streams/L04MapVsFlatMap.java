package codeworks.java8features.streams;

import java.util.List;

public class L04MapVsFlatMap {
	public static void main(String[] args) {
		mapEx3();
	}
	protected static void mapEx1() {
		List<String> names = List.of("alice", "Bob","Charlie");
		names.stream().map(String::toUpperCase).forEach(System.out::println);
		System.out.println();
		names.stream().map(String::length).forEach(System.out::println);
	}
	protected static void mapEx2() {
		List<List<Integer>> list = List.of(
		        List.of(1, 2),
		        List.of(3, 4)
		);
		list.stream().flatMap(List::stream).forEach(System.out::println);
	}
	protected static void mapEx3() {
		List<String> words = List.of("Java", "API");
		words.stream()
		     .flatMap(word -> word.chars()
		                          .mapToObj(c -> (char)c))
		     .forEach(System.out::println);
	}
}
