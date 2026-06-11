package com.mns.cda.filsrouge.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.mns.cda.filsrouge.model.Event;
import com.mns.cda.filsrouge.model.EventType;
import com.mns.cda.filsrouge.model.Sport;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RequiredArgsConstructor
class FilsRougeApplicationTestsVote {

    private final WebApplicationContext context;
    private ObjectMapper mapper = JsonMapper.builder().build();
    private MockMvc mvc;


    @BeforeEach
    void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @Test
    public void callCountryList_shouldReturn200() throws Exception {

        mvc.perform(get("/country/list"))
                .andExpect(status().isOk());
    }

//    @Test
//    public void callEventlight_shouldReturn403() throws Exception {
//        mvc.perform(get("/light/1"))
//                .andExpect(status().isForbidden());
//    }
//
//    @Test
//    @WithMockUser(roles = "USER")
//    public void callEventlight_shouldReturn200() throws Exception {
//        mvc.perform(get("/eventlight/list"))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    @WithMockUser(roles = "ADMIN")
//    public void callEventLight_shouldReturn200() throws Exception {
//        mvc.perform(get("/eventlight/list"))
//                .andExpect(status().isOk());
//    }

//    @Test
//    @WithMockUser(roles = {"ADMIN"})
//    public void callDeleteEvent_shouldReturn204() throws Exception {
//        mvc.perform(delete("/event/2"))
//                .andExpect(status().isNoContent());
//    }

    @Test
    @WithMockUser(username = "claire.martin", roles = "ADMIN")
    public void callUpdateEvent_shouldReturn204() throws Exception {

        EventType eventType = new EventType();
        eventType.setIdEventType(1);
        Sport sport = new Sport();
        sport.setIdSport(1);

        Event newEvent = new Event(1,
                "Match de Football",
                "Rencontre amicale entre deux équipes locales",
                null,
                eventType,
                sport,
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>());

        String jsonEvent = mapper.writeValueAsString(newEvent);

        mvc.perform(put("/event/1", newEvent)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonEvent))
                .andExpect(status().isOk());
    }
}
