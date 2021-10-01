package br.dev.mfalm.springdataresterrorhandling.cntroller;

import br.dev.mfalm.springdataresterrorhandling.domain.Developer;
import br.dev.mfalm.springdataresterrorhandling.domain.Skill;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.java.Log;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@Log
class DeveloperTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void postTest() throws Exception {
        MvcResult result =  mockMvc.perform(MockMvcRequestBuilders
                .get("/api/skills/4e1a5cab-dadf-463b-8c39-040ea4815383")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        String content = result.getResponse().getContentAsString();
        Skill skill = objectMapper.readValue(content, Skill.class);
        List<Skill> skills = List.of(skill);

        Developer developer = new Developer(null, "carioca", "carioca@email.com.br", LocalDate.of(1995, 12, 1), skills);

        String devJson = objectMapper.writeValueAsString(developer);

        result = mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/developers")
                        .content(devJson)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.skills[0].uuid").exists())
                .andReturn();

        log.info(result.getResponse().getContentAsString());
    }

}