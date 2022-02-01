package java_fundamentals.streams_process_analyze_data_memory.four;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class StreamFromTextFile {

	final static   String pathName="src/java_fundamentals/streams_process_analyze_data_memory/four/data/";

	public static void main(String[] args) {

		Path path = Path.of(pathName+"first-names.txt");
		
		try (Stream<String> lines = Files.lines(path);) {
			
			long count = lines.count();
			System.out.println("Count = " + count);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}








