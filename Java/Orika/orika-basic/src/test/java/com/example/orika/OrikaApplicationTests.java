package com.example.orika;

import com.example.orika.listmapandarraymapping.PersonNameList;
import com.example.orika.listmapandarraymapping.PersonNameMap;
import com.example.orika.listmapandarraymapping.PersonNameParts;
import com.example.orika.mapnestedfields.Name;
import com.example.orika.mapnestedfields.PersonContainer;
import com.example.orika.personmapping.personnedest.Personne;
import com.example.orika.personmapping.personsource.Person;
import com.example.orika.simplemapping.dest.Dest;
import com.example.orika.simplemapping.source.Source;
import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

@SpringBootTest
class OrikaApplicationTests {

	MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

	MapperFactory mapperFactoryWithoutNulls = new DefaultMapperFactory.Builder()
			.mapNulls(false).build();

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
		Dest dest = new Dest("Capsystematic technologies", 12);
		Source src = mapper.map(dest, Source.class);

		assertEquals(src.getAge(), dest.getAge());
		assertEquals(src.getName(), dest.getName());
	}

	@Test
	public void givenSrcAndDest_whenMapsUsingBoundMapper_thenCorrect() {
		BoundMapperFacade<Source, Dest>
				boundMapper = mapperFactory.getMapperFacade(Source.class, Dest.class);
		Source src = new Source("Vrushank Patel", 98);
		Dest dest = boundMapper.map(src);

		assertEquals(dest.getAge(), src.getAge());
		assertEquals(dest.getName(), src.getName());
	}

	@Test
	public void givenSrcAndDest_whenMapsUsingBoundMapperInReverse_thenCorrect() {
		BoundMapperFacade<Source, Dest>
				boundMapper = mapperFactory.getMapperFacade(Source.class, Dest.class);
		Dest src = new Dest("Demo Name", 76);
		Source dest = boundMapper.mapReverse(src);

		assertEquals(dest.getAge(), src.getAge());
		assertEquals(dest.getName(), src.getName());
	}

	// Now, we'll map the classes those have similar variable with different names
	// Here, person class has name where personne class has nom, similarly nickname is to surnom.
	// We've to tell the mapperFactory that which variables needs to be mapped to which one exactly.
	@Test
	public void givenSrcAndDestWithDifferentFieldNames_whenMaps_thenCorrect() {
		// Here, we're declaring how the field should be mapped.
		mapperFactory.classMap(Personne.class, Person.class)
				.field("nom", "name").field("surnom", "nickname")
				.field("age", "age").register();
		// Don't forget to call the register() API method in order to register the configuration with the MapperFactory.
		MapperFacade mapper = mapperFactory.getMapperFacade();
		Personne frenchPerson = new Personne("Pragya", "Saxena", 25);
		Person englishPerson = mapper.map(frenchPerson, Person.class);

		assertEquals(englishPerson.getName(), frenchPerson.getNom());
		assertEquals(englishPerson.getNickname(), frenchPerson.getSurnom());
		assertEquals(englishPerson.getAge(), frenchPerson.getAge());
	}

	// In above case, we showed the conf for age which was not needed, because age variable was same for both the classes.
	// What if we've 300 vars to map and we want to tell orika that only 5 fields names are different, other should be mapped by default.
	// for that, we can use byDefault() method before register.
	// take a look at example below.
	@Test
	public void givenSrcAndDestWithTwoDifferentFieldNamesOneSameName() {
		// Here, we're declaring how the field should be mapped.
		mapperFactory.classMap(Personne.class, Person.class)
				.field("nom", "name").field("surnom", "nickname")
				.byDefault().register();
		// above, byDefault will register the age as default and for other fields, it'll use the custom fields names we provided.
		MapperFacade mapper = mapperFactory.getMapperFacade();
		Personne frenchPerson = new Personne("Pragya", "Saxena", 25);
		Person englishPerson = mapper.map(frenchPerson, Person.class);

		assertEquals(englishPerson.getName(), frenchPerson.getNom());
		assertEquals(englishPerson.getNickname(), frenchPerson.getSurnom());
		assertEquals(englishPerson.getAge(), frenchPerson.getAge());
	}

	// Let's assume that we don't want to map the nom field here, we can do it in exclude method
	// test needed to fixed
	@Test
	public void givenSrcAndDest_whenCanExcludeField_thenCorrect() {
		mapperFactory.classMap(Personne.class, Person.class)
				.exclude("nom")
				.constructorB()
				.field("surnom", "nickname").field("age", "age").register();
		MapperFacade mapper = mapperFactory.getMapperFacade();
		Personne frenchPerson = new Personne("Claire", "cla", 25);
		Person englishPerson = mapper.map(frenchPerson, Person.class);

		assertEquals(null, englishPerson.getName());
		assertEquals(englishPerson.getNickname(), frenchPerson.getSurnom());
		assertEquals(englishPerson.getAge(), frenchPerson.getAge());
	}

	// Here we'll map the PersonNameList to PersonNameParts
	// Here, list will be mapped to class which have two vars firstname and lastname.
	@Test
	public void givenSrcWithListAndDestWithPrimitiveAttributes_whenMaps_thenCorrect() {
		mapperFactory.classMap(PersonNameList.class, PersonNameParts.class)
				.field("nameList[0]", "firstName")
				.field("nameList[1]", "lastName").register();
		// in above, we're providing index of list and then to which variable it should be mapped.
		MapperFacade mapper = mapperFactory.getMapperFacade();
		List<String> nameList = Arrays.asList(new String[] { "Vrushank", "Patel" });
		PersonNameList src = new PersonNameList(nameList);
		PersonNameParts dest = mapper.map(src, PersonNameParts.class);

		assertEquals(dest.getFirstName(), "Vrushank");
		assertEquals(dest.getLastName(), "Patel");
	}

	// Now, we'll map the PersonNameMap where key is firstname and value is lastname.
	// we'll map this PersonNameMap to PersonNameParts class in individual variables firstname and lastname.
	@Test
	public void givenSrcWithMapAndDestWithPrimitiveAttributes_whenMaps_thenCorrect() {
		mapperFactory.classMap(PersonNameMap.class, PersonNameParts.class)
				.field("nameMap['first']", "firstName")
				.field("nameMap[\"last\"]", "lastName")
				.register();
		// in above line, we provided map's key and the variable name where it should be mapped.
		MapperFacade mapper = mapperFactory.getMapperFacade();
		Map<String, String> nameMap = new HashMap<>();
		nameMap.put("first", "Vrushank");
		nameMap.put("last", "Patel");
		PersonNameMap src = new PersonNameMap(nameMap);
		PersonNameParts dest = mapper.map(src, PersonNameParts.class);

		assertEquals(dest.getFirstName(), "Vrushank");
		assertEquals(dest.getLastName(), "Patel");
	}

	// Now, we'll map the PersonContainer class's nested class (Name class) to PersonNameParts class.
	@Test
	public void givenSrcWithNestedFields_whenMaps_thenCorrect() {
		mapperFactory.classMap(PersonContainer.class, PersonNameParts.class)
				.field("name.firstName", "firstName")
				.field("name.lastName", "lastName").register();
		// above syntax is : field("nestedClassObject.it'sField", "destinationField");

		MapperFacade mapper = mapperFactory.getMapperFacade();
		PersonContainer src = new PersonContainer(new Name("Mukesh", "Kumar"));
		PersonNameParts dest = mapper.map(src, PersonNameParts.class);

		assertEquals(dest.getFirstName(), "Mukesh");
		assertEquals(dest.getLastName(), "Kumar");
	}

	// In some cases, you may wish to control whether nulls are mapped or ignored when they are encountered.
	// By default, Orika will map null values when encountered:
	@Test
	public void givenSrcWithNullField_whenMapsThenCorrect() {
		mapperFactory.classMap(Source.class, Dest.class).byDefault();
		MapperFacade mapper = mapperFactory.getMapperFacade();
		Source src = new Source(null, 10);
		Dest dest = mapper.map(src, Dest.class);

		assertEquals(dest.getAge(), src.getAge());
		assertEquals(dest.getName(), src.getName());
	}

	// In above case, null was mapped and asserted also.
	// What if we don't want to map the null values.
	// for that, we've created mapperFactoryWithoutNulls in class as a global configuration.
	// check the mapperFactoryWithoutNulls declaration where we've added mapNulls(false).
	// this is Global configuration.
	// so we can prevent orika to map  nulls.

	@Test
	public void givenSrcWithNullAndGlobalConfigForNoNull_whenFailsToMap_ThenCorrect() {
		mapperFactoryWithoutNulls.classMap(Source.class, Dest.class);
		MapperFacade mapper = mapperFactoryWithoutNulls.getMapperFacade();
		Source src = new Source(null, 10);
		Dest dest = new Dest("Clinton", 55);
		mapper.map(src, dest);

		// now, here, age is mapped, but name is not mapped. because it is null in src so name will be ignored..
		// So, in dest object, name field will be ignored while mapping because source object has null in that field.
		// name field is not going to mapped, so we'll assert the name field by directly Clinton.
		// because if we compare dest.getName and src.getName then test will fail because one is null and another is not.
		assertEquals(dest.getAge(), src.getAge());
		assertEquals(dest.getName(), "Clinton");
	}

	// What if we don't want to create mapperFactoryWithoutNulls object as a global config.
	// We can use local configuration for that with mapperFactory.
	// below is the same test case as above excepting the mapperFactory object.
	// here we'll use simple mapperFactory insted of mapperFactoryWithoutNulls.
	// We'll set mapNulls to false in classMap field registration.
	@Test
	public void givenSrcWithNullAndLocalConfigForNoNull_whenFailsToMap_ThenCorrect() {
		mapperFactory.classMap(Source.class, Dest.class)
				.field("age", "age")
				.mapNulls(false)
				.field("name", "name")
				.byDefault()
				.register();

		MapperFacade mapper = mapperFactory.getMapperFacade();
		Source src = new Source(null, 10);
		Dest dest = new Dest("Clinton", 55);
		mapper.map(src, dest);

		assertEquals(dest.getAge(), src.getAge());
		assertEquals(dest.getName(), "Clinton");
	}

	// in above test, Notice how we call mapNulls just before registering name field,
	// this will cause all fields following the mapNulls call to be ignored when they have null value.

	// below test shows that Bi-directional mapping also accepts mapped null values.
	@Test
	public void givenDestWithNullReverseMappedToSource_whenMapsByDefault_thenCorrect() {
		mapperFactory.classMap(Source.class, Dest.class).byDefault();
		MapperFacade mapper = mapperFactory.getMapperFacade();
		Dest src = new Dest(null, 10);
		Source dest = new Source("Vrushank", 23);
		mapper.map(src, dest);

		assertEquals(dest.getAge(), src.getAge());
		assertEquals(dest.getName(), src.getName());
	}

	// We can prevent the null acceptance in bi-directional mapping by  calling mapNullsInReverse and passing in false.
	@Test
	public void
	givenDestWithNullReverseMappedToSourceAndLocalConfigForNoNull_whenFailsToMap_thenCorrect() {
		mapperFactory.classMap(Source.class, Dest.class)
				.field("age", "age")
				.mapNullsInReverse(false)
				.field("name", "name")
				.byDefault()
				.register();
		MapperFacade mapper = mapperFactory.getMapperFacade();
		Dest src = new Dest(null, 10);
		Source dest = new Source("Vrushank", 44);
		mapper.map(src, dest);

		assertEquals(dest.getAge(), src.getAge());
		assertEquals(dest.getName(), "Vrushank");
	}

	// what if we don't want to map nulls for some specific fields.
	// that's where we've to use field level configuration.
	@Test
	public void givenSrcWithNullAndFieldLevelConfigForNoNull_whenFailsToMap_ThenCorrect() {
		mapperFactory.classMap(Source.class, Dest.class)
				.field("age", "age")
				.fieldMap("name", "name")
				.mapNulls(false)
				.add()
				.byDefault()
				.register();
		// here, mapper will consider mapNulls to false for name field only.
		// So name field will be ignored will remain Clinton.
		MapperFacade mapper = mapperFactory.getMapperFacade();
		Source src = new Source(null, 10);
		Dest dest = new Dest("Clinton", 55);
		mapper.map(src, dest);

		assertEquals(dest.getAge(), src.getAge());
		assertEquals(dest.getName(), "Clinton");
	}

}
