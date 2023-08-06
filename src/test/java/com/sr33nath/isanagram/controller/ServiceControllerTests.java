package com.sr33nath.isanagram.controller;

import com.sr33nath.isanagram.service.IsAnagramService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureWebTestClient
public class ServiceControllerTests {
    @MockBean
    private IsAnagramService isAnagramService;

    @Test
    void testValidAnagramOkResponse(@Autowired WebTestClient webClient){

        when(isAnagramService.check(anyString(), anyString())).thenReturn(true);

        webClient
                .post().uri("/isAnagram")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue("{\"firstString\":\"ABA\", \"secondString\":\"AAB\"}")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("true");
    }

    @Test
    void testInvalidAnagramOkResponse(@Autowired WebTestClient webClient){

        when(isAnagramService.check(anyString(), anyString())).thenReturn(false);

        webClient
                .post().uri("/isAnagram")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue("{\"firstString\":\"ABA\", \"secondString\":\"ABC\"}")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("false");
    }

    @Test
    void testBadRequest(@Autowired WebTestClient webClient){

        webClient
                .post().uri("/isAnagram")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue("{\"firstString\":\"ABA\", \"second\":\"AAB\"}")
                .exchange()
                .expectStatus().isBadRequest();
    }

    @Test
    void testInternalServerError(@Autowired WebTestClient webClient){

        when(isAnagramService.check(anyString(), anyString())).thenThrow(new RuntimeException("Unhandled Exception"));

        webClient
                .post().uri("/isAnagram")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue("{\"firstString\":\"ABA\", \"secondString\":\"AAB\"}")
                .exchange()
                .expectStatus().is5xxServerError();
    }
}
