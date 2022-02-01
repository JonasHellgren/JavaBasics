package java_fundamentals.streams_process_analyze_data_memory.four;

public class StreamFromString {

	public static void main(String[] args) {

		String sentence = "the quick brown fox jumps over the lazy dog";
		
		sentence.chars()
			.mapToObj(codePoint -> Character.toString(codePoint))
			.filter(letter -> !letter.equals(" "))
			.distinct()
			.sorted()
			.forEach(letter -> System.out.print(letter));

		/***
		 * Following does not work because sentence is not a collection
		 sentence.stream()
		 .filter(letter -> !letter.equals(" "))
		 .distinct()
		 .sorted()
		 .forEach(letter -> System.out.print(letter));
		 */

		
	}
}
