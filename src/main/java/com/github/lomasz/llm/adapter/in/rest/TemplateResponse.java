package com.github.lomasz.llm.adapter.in.rest;

import com.github.lomasz.llm.application.domain.model.Result;

record TemplateResponse(
) {

    public static TemplateResponse fromDomain(Result result) {
        return new TemplateResponse();
    }
}
