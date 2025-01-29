package com.github.lomasz.llm.adapter.in.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;

interface ApiDoc {

    @Operation(summary = "Process", description = "Process")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", content = @Content(schema = @Schema(implementation = TemplateResponse.class))),
            @ApiResponse(responseCode = "400", content = @Content(schema = @Schema(implementation = ProblemDetail.class))),
            @ApiResponse(responseCode = "500", content = @Content(schema = @Schema(implementation = ProblemDetail.class))),
    })
    ResponseEntity<TemplateResponse> process(TemplateRequest request);

}
