package java_fundamentals.streams_process_analyze_data_memory.four;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SkippingAndLimiting {

	final static   String pathName="src/java_fundamentals/streams_process_analyze_data_memory/four/data/";

	public static void main(String[] args) {
		IntStream.range(0,  30)
			.skip(10)
			.limit(10)
			.forEach(index -> System.out.print(index + " "));

		System.out.println("");
		
		Path path = Path.of(pathName+"first-names.txt");
		try (Stream<String> lines = Files.lines(path);) {
			
			lines.skip(20).limit(10).forEach(System.out::println);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
