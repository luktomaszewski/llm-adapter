package com.github.lomasz.llm.adapter.in.rest;

import com.github.lomasz.llm.application.usecase.ProcessUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
@RequiredArgsConstructor
class RestController implements ApiDoc {

    private final ProcessUseCase processUseCase;

    @PostMapping
    public ResponseEntity<TemplateResponse> process(@RequestBody @Valid TemplateRequest request) {
        ProcessUseCase.Output output = processUseCase.execute(new ProcessUseCase.Input(request.toDomain()));
        return ResponseEntity.ok(TemplateResponse.fromDomain(output.result()));
    }

}
