package java_fundamentals.streams_process_analyze_data_memory.three_map_filter_reduce_algorithm_flatmap;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import java_fundamentals.streams_process_analyze_data_memory.three_map_filter_reduce_algorithm_flatmap.model.City;
import java_fundamentals.streams_process_analyze_data_memory.three_map_filter_reduce_algorithm_flatmap.model.Person;


public class PlayWithFlatMap {

	public static void main(String[] args) {
		
		Person p01 = new Person("Paul", 25);
		Person p02 = new Person("Sarah", 27);
		Person p03 = new Person("James", 31);
		Person p04 = new Person("Julie", 25);
		Person p05 = new Person("Charles", 22);
		Person p06 = new Person("Charlotte", 31);
		Person p07 = new Person("Ann", 27);
		Person p08 = new Person("Boris", 29);
		Person p09 = new Person("Emily", 34);
		
		City newYork = new City("New York", p01, p02, p03);
		City paris   = new City("New York", p04, p05, p06);
		City london  = new City("New York", p07, p08, p09);
		
		List<City> cities = List.of(newYork, paris, london);

		Function <City, Stream<Person>> flatMapper =   // a function that returns a stream
				city -> city. getPeople().stream();
		
		long count = 
		cities.stream()
			.flatMap(flatMapper)
			.count();
		
		System.out.println("Count = " + count);
		
		cities.stream()
			.flatMap(city -> city.getPeople().stream())
			.map(p -> p.getName())
			.forEach(name -> System.out.println(name));
	}
}
