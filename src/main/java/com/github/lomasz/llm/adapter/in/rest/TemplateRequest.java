package com.github.lomasz.llm.adapter.in.rest;

import com.github.lomasz.llm.application.domain.model.Template;

record TemplateRequest(

) {

    public Template toDomain() {
        return new Template();
    }
}
