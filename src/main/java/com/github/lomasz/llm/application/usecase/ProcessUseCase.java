package com.github.lomasz.llm.application.usecase;

import com.github.lomasz.llm.application.domain.model.Result;
import com.github.lomasz.llm.application.domain.model.Template;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProcessUseCase implements UseCase<ProcessUseCase.Input, ProcessUseCase.Output> {


    @Override
    public Output execute(Input input) {
        return new Output(new Result());
    }

    public record Input(Template template) implements UseCase.Input {
    }

    public record Output(Result result) implements UseCase.Output {
    }

}
