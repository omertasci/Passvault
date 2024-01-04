package com.omertasci.passvault;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.omertasci.passvault.dto.EntryDto;
import com.omertasci.passvault.entity.Entry;
import com.omertasci.passvault.util.CustomLocalDateTimeSerializer;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DateTest {

    @Test
    public void test_DateConversion() {

        EntryDto expectedEntryDto = EntryDto.builder().title("Gmail").build();

        Entry actualEntry = new Entry();
        actualEntry.setTitle("Gmail");

        ObjectMapper objectMapper = new ObjectMapper();
        EntryDto actualEntryDto = objectMapper.convertValue(actualEntry, EntryDto.class);
    }

   /* @Test
    public void whenSettingObjectMapperDateFormat_thenCorrect()
            throws JsonProcessingException, ParseException {

        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm");

        String toParse = "20-12-2014 02:30";
        Date date = df.parse(toParse);
        Event event = new Event("party", date);

        ObjectMapper mapper = new ObjectMapper();
        mapper.setDateFormat(df);

        String result = mapper.writeValueAsString(event);
        assertThat(result, containsString(toParse));
    }*/

    @Test
    public void whenSerializingJava8Date_thenCorrect()
            throws JsonProcessingException {
        LocalDateTime date = LocalDateTime.of(2014, 12, 20, 2, 30);

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        String result = mapper.writeValueAsString(date);
        assertThat(result, containsString("2014-12-20T02:30"));
    }

/*    @Test
    public void whenSerializingJava8DateWithCustomSerializer_thenCorrect()
            throws JsonProcessingException {

        LocalDateTime date = LocalDateTime.of(2014, 12, 20, 2, 30);
        Event event = new Event("party", date);

        ObjectMapper mapper = new ObjectMapper();
        String result = mapper.writeValueAsString(event);
        assertThat(result, containsString("2014-12-20 02:30"));
    }*/

    @Test
    public void whenDeserializingDateWithJackson_thenCorrect()
            throws JsonProcessingException, IOException {

        String json = "{\"name\":\"party\",\"eventDate\":\"20-12-2014 02:30:00\"}";

        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        ObjectMapper mapper = new ObjectMapper();
        mapper.setDateFormat(df);

        Event event = mapper.readerFor(Event.class).readValue(json);
        assertEquals("20-12-2014 02:30:00", df.format(event.eventDate));
    }
}

class Event{

    public String name;
    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    public LocalDateTime  eventDate;
    public Event(String name, LocalDateTime  eventDate){
        this.name= name;
        this.eventDate= eventDate;
    }
}