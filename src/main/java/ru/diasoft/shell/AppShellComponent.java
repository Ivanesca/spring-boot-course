package ru.diasoft.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.diasoft.model.TestResult;
import ru.diasoft.service.IOService;
import ru.diasoft.service.TestingService;

@ShellComponent
@RequiredArgsConstructor
public class AppShellComponent {
    private final TestingService testingService;
    private final IOService ioService;

    @ShellMethod(key = "start")
    public void startTest() {
        TestResult testResult = testingService.runTest();
        ioService.printString("your.result", String.valueOf(testResult.correctAnswers()),
                "/" + testResult.totalQuestions()
        );
    }
}
