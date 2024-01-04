package com.omertasci.passvault;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.omertasci.passvault.dto.EntryDto;
import com.omertasci.passvault.entity.Entry;
import com.omertasci.passvault.util.MapUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PassVaultApplicationTests {


	@Test
	void test_entryEntityToDtoConversion() {


		EntryDto expectedEntryDto = EntryDto.builder().title("Gmail").build();

		Entry actualEntry = new Entry();
		actualEntry.setTitle("Gmail");

		ObjectMapper objectMapper = new ObjectMapper();
		EntryDto actualEntryDto = objectMapper.convertValue(actualEntry, EntryDto.class);

		/*MapUtil mu = new MapUtil();
		EntryDto actualEntryDto = mu.map(actualEntry, EntryDto.class);*/

		System.out.println("expectedEntryDto.title : " + expectedEntryDto.getTitle());
		System.out.println("actualEntryDto.title : " + actualEntryDto.getTitle());

		assertEquals(expectedEntryDto.getTitle(), actualEntryDto.getTitle());
	}


	@Test
	void test_entryEntityListToDtoListConversion() {

		ObjectMapper objectMapper = new ObjectMapper();
		Collection<EntryDto> expectedEntryDtos = new ArrayList<EntryDto>();

		EntryDto expectedEntryDto = EntryDto.builder().title("Gmail").build();
		expectedEntryDtos.add(expectedEntryDto);

		Collection<Entry> actualEntries = new ArrayList<Entry>();
		Entry actualEntry = new Entry();
		actualEntry.setTitle("Gmail");
		actualEntries.add(actualEntry);

		MapUtil mu = new MapUtil();
		List<EntryDto> actualEntryDtos = mu.typeCastList(actualEntries, EntryDto.class);


		System.out.println("expectedEntryDtos(0).title : " + expectedEntryDtos.stream().findFirst().get().getTitle());
		System.out.println("actualEntryDtos(0).title : " + actualEntryDtos.get(0).getTitle());

		assertEquals(expectedEntryDtos.stream().findFirst().get().getTitle(), actualEntryDtos.get(0).getTitle());
	}
}
