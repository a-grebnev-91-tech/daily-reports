package a.grebnev.dailyreports.controller;

import a.grebnev.dailyreports.dto.ReportDto;
import a.grebnev.dailyreports.service.ReportService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(controllers = ReportController.class)
class ReportControllerTest {
    private static final String PATH = "/api/v1/reports";

    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper mapper;
    @MockBean
    private ReportService service;

    private ReportDto inputDto;

    @BeforeEach
    void setUp() {
        inputDto = new ReportDto(1L, LocalDate.now(), "accident", "gmo", "powerSupply",
                "APCS", "spun", "highway", "dispInspect", "dispatcher");
    }

    @Test
    void test1_shouldCreateValidReport() throws Exception {
        inputDto.setId(null);
        when(service.createReport(any())).thenReturn(inputDto);

        mvc.perform(post(PATH)
                        .content(mapper.writeValueAsString(inputDto))
                        .characterEncoding(StandardCharsets.UTF_8)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.accident", is(inputDto.getAccident())))
                .andExpect(jsonPath("$.gmo", is(inputDto.getGmo())))
                .andExpect(jsonPath("$.powerSupply", is(inputDto.getPowerSupply())))
                .andExpect(jsonPath("$.apcs", is(inputDto.getApcs())))
                .andExpect(jsonPath("$.spun", is(inputDto.getSpun())))
                .andExpect(jsonPath("$.highway", is(inputDto.getHighway())))
                .andExpect(jsonPath("$.dispatcherInspection", is(inputDto.getDispatcherInspection())))
                .andExpect(jsonPath("$.dispatcher", is(inputDto.getDispatcher())));
    }

    @Test
    void test2_shouldNotCreateReportWithId() throws Exception {
        mvc.perform(post(PATH)
                        .content(mapper.writeValueAsString(inputDto))
                        .characterEncoding(StandardCharsets.UTF_8)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void test3_shouldNotCreateReportWithEmptyAccident() throws Exception {
        inputDto.setId(null);
        inputDto.setAccident(" ");

        mvc.perform(post(PATH)
                        .content(mapper.writeValueAsString(inputDto))
                        .characterEncoding(StandardCharsets.UTF_8)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void test4_shouldNotCreateReportWithEmptyGmo() throws Exception {
        inputDto.setId(null);
        inputDto.setGmo(" ");

        mvc.perform(post(PATH)
                        .content(mapper.writeValueAsString(inputDto))
                        .characterEncoding(StandardCharsets.UTF_8)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void test5_shouldNotCreateReportWithEmptyPowerSupply() throws Exception {
        inputDto.setId(null);
        inputDto.setPowerSupply(" ");

        mvc.perform(post(PATH)
                        .content(mapper.writeValueAsString(inputDto))
                        .characterEncoding(StandardCharsets.UTF_8)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void test6_shouldNotCreateReportWithEmptyApcs() throws Exception {
        inputDto.setId(null);
        inputDto.setApcs(" ");

        mvc.perform(post(PATH)
                        .content(mapper.writeValueAsString(inputDto))
                        .characterEncoding(StandardCharsets.UTF_8)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void test7_shouldNotCreateReportWithEmptySpun() throws Exception {
        inputDto.setId(null);
        inputDto.setSpun(" ");

        mvc.perform(post(PATH)
                        .content(mapper.writeValueAsString(inputDto))
                        .characterEncoding(StandardCharsets.UTF_8)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void test8_shouldNotCreateReportWithNullDate() throws Exception {
        inputDto.setId(null);
        inputDto.setReportDate(null);

        mvc.perform(post(PATH)
                        .content(mapper.writeValueAsString(inputDto))
                        .characterEncoding(StandardCharsets.UTF_8)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void test9_shouldNotCreateReportWithEmptyHighway() throws Exception {
        inputDto.setId(null);
        inputDto.setHighway(" ");

        mvc.perform(post(PATH)
                        .content(mapper.writeValueAsString(inputDto))
                        .characterEncoding(StandardCharsets.UTF_8)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void test10_shouldNotCreateReportWithEmptyDispInspec() throws Exception {
        inputDto.setId(null);
        inputDto.setDispatcherInspection(" ");

        mvc.perform(post(PATH)
                        .content(mapper.writeValueAsString(inputDto))
                        .characterEncoding(StandardCharsets.UTF_8)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void test11_shouldNotCreateReportWithEmptyDispatcher() throws Exception {
        inputDto.setId(null);
        inputDto.setDispatcher(" ");

        mvc.perform(post(PATH)
                        .content(mapper.writeValueAsString(inputDto))
                        .characterEncoding(StandardCharsets.UTF_8)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void test12_shouldUpdateReportWithId() throws Exception {
        when(service.updateReport(any())).thenReturn(inputDto);

        mvc.perform(put(PATH)
                        .content(mapper.writeValueAsString(inputDto))
                        .characterEncoding(StandardCharsets.UTF_8)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.accident", is(inputDto.getAccident())))
                .andExpect(jsonPath("$.gmo", is(inputDto.getGmo())))
                .andExpect(jsonPath("$.powerSupply", is(inputDto.getPowerSupply())))
                .andExpect(jsonPath("$.apcs", is(inputDto.getApcs())))
                .andExpect(jsonPath("$.spun", is(inputDto.getSpun())))
                .andExpect(jsonPath("$.highway", is(inputDto.getHighway())))
                .andExpect(jsonPath("$.dispatcherInspection", is(inputDto.getDispatcherInspection())))
                .andExpect(jsonPath("$.dispatcher", is(inputDto.getDispatcher())));
    }

    @Test
    void test13_shouldNotUpdateReportWithoutId() throws Exception {
        inputDto.setId(null);

        mvc.perform(put(PATH)
                        .content(mapper.writeValueAsString(inputDto))
                        .characterEncoding(StandardCharsets.UTF_8)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void test14_shouldNotUpdateReportWithEmptyAccident() throws Exception {
        inputDto.setId(null);
        inputDto.setAccident(" ");

        mvc.perform(put(PATH)
                        .content(mapper.writeValueAsString(inputDto))
                        .characterEncoding(StandardCharsets.UTF_8)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void test15_shouldNotUpdateReportWithEmptyGmo() throws Exception {
        inputDto.setId(null);
        inputDto.setGmo(" ");

        mvc.perform(put(PATH)
                        .content(mapper.writeValueAsString(inputDto))
                        .characterEncoding(StandardCharsets.UTF_8)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void test16_shouldNotUpdateReportWithEmptyPowerSupply() throws Exception {
        inputDto.setId(null);
        inputDto.setPowerSupply(" ");

        mvc.perform(put(PATH)
                        .content(mapper.writeValueAsString(inputDto))
                        .characterEncoding(StandardCharsets.UTF_8)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void test17_shouldNotUpdateReportWithEmptyApcs() throws Exception {
        inputDto.setId(null);
        inputDto.setApcs(" ");

        mvc.perform(put(PATH)
                        .content(mapper.writeValueAsString(inputDto))
                        .characterEncoding(StandardCharsets.UTF_8)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void test18_shouldNotUpdateReportWithEmptySpun() throws Exception {
        inputDto.setId(null);
        inputDto.setSpun(" ");

        mvc.perform(put(PATH)
                        .content(mapper.writeValueAsString(inputDto))
                        .characterEncoding(StandardCharsets.UTF_8)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void test19_shouldNotUpdateReportWithNullDate() throws Exception {
        inputDto.setId(null);
        inputDto.setReportDate(null);

        mvc.perform(put(PATH)
                        .content(mapper.writeValueAsString(inputDto))
                        .characterEncoding(StandardCharsets.UTF_8)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void test20_shouldNotUpdateReportWithEmptyHighway() throws Exception {
        inputDto.setId(null);
        inputDto.setHighway(" ");

        mvc.perform(put(PATH)
                        .content(mapper.writeValueAsString(inputDto))
                        .characterEncoding(StandardCharsets.UTF_8)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void test21_shouldNotUpdateReportWithEmptyDispInspec() throws Exception {
        inputDto.setId(null);
        inputDto.setDispatcherInspection(" ");

        mvc.perform(put(PATH)
                        .content(mapper.writeValueAsString(inputDto))
                        .characterEncoding(StandardCharsets.UTF_8)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void test22_shouldNotUpdateReportWithEmptyDispatcher() throws Exception {
        inputDto.setId(null);
        inputDto.setDispatcher(" ");

        mvc.perform(put(PATH)
                        .content(mapper.writeValueAsString(inputDto))
                        .characterEncoding(StandardCharsets.UTF_8)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}