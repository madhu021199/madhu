package democode;

import java.util.stream.Stream;

import org.testng.annotations.Test;

public class StreamConcept {

	@Test()
	public void streamMap()
	{
		Stream.of("Azya","Abishek","Ramya","Diya","Rama").filter(s->s.startsWith("A")).map(a ->a.toUpperCase()).sorted().forEach(s-> System.out.println(s));
		
	}
}
