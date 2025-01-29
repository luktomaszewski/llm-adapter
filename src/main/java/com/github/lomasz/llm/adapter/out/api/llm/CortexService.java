package com.github.lomasz.llm.adapter.out.api.llm;

import com.github.lomasz.llm.application.port.LlmPort;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
class CortexService implements LlmPort {

    private final WebClient cortextWebClient;

    CortexService(WebClient cortextWebClient) {
        this.cortextWebClient = cortextWebClient;
    }



}
