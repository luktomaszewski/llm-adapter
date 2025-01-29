package com.github.lomasz.llm.usecase;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.lomasz.llm.application.domain.model.Template;
import com.github.lomasz.llm.application.usecase.ProcessUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProcessUseCaseTest {


    private ProcessUseCase sut;

    @BeforeEach
    void setUp() {
        sut = new ProcessUseCase();
    }

    @Test
    @DisplayName("should: process")
    void shouldCreate() {
        // given
        Template template = new Template();

        // when
        ProcessUseCase.Output output = sut.execute(new ProcessUseCase.Input(template));

        // then
        assertThat(output.result()).isNotNull();

    }
}
