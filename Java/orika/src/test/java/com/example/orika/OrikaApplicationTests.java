package com.example.orika;

import com.example.orika.dest.Dest;
import com.example.orika.source.Source;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.Assert.assertEquals;

@SpringBootTest
class OrikaApplicationTests {

	MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

	@Test
	public void givenSrcAndDest_whenMaps_thenCorrect() {
		mapperFactory.classMap(Source.class, Dest.class);
		MapperFacade mapper = mapperFactory.getMapperFacade();
		Source src = new Source("Capsys financial technologies", 10);
		Dest dest = mapper.map(src, Dest.class);

		assertEquals(dest.getAge(), src.getAge());
		assertEquals(dest.getName(), src.getName());
	}

	@Test
	public void givenSrcAndDest_whenMapsReverse_thenCorrect() {
		mapperFactory.classMap(Source.class, Dest.class).byDefault();
		MapperFacade mapper = mapperFactory.getMapperFacade();
		Dest src = new Dest("Capsystematic technologies", 12);
		Source dest = mapper.map(src, Source.class);

		assertEquals(dest.getAge(), src.getAge());
		assertEquals(dest.getName(), src.getName());
	}

}
