package com.github.lomasz.llm.application.usecase;

@FunctionalInterface
interface UseCase<IN extends UseCase.Input, OUT extends UseCase.Output> {

    OUT execute(IN input);

    interface Input {
    }

    interface Output {
    }
}
