package com.github.lomasz.llm.adapter.in.rest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class TemplateControllerTest {

    private static final String API_PATH = "/api";

    @Autowired
    private WebTestClient webTestClient;

    @Test
    @DisplayName("should: {}, when: {}")
    void should() {
        // given

        // when
        callApi(new TemplateRequest())
                .expectStatus()
                .isOk();
        // th

    }

    private WebTestClient.ResponseSpec callApi(TemplateRequest templateRequest) {
        return webTestClient.post()
                .uri(API_PATH)
                .body(templateRequest, TemplateRequest.class)
                .accept(MediaType.APPLICATION_JSON).exchange();
    }
}
