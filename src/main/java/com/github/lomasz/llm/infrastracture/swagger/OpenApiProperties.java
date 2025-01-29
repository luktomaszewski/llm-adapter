package com.github.lomasz.llm.infrastracture.swagger;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "info.app")
class OpenApiProperties {

    private String name;
    private String version;

}
