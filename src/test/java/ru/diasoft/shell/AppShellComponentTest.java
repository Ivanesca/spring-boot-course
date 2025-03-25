package ru.diasoft.shell;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.diasoft.model.TestResult;
import ru.diasoft.service.impl.IOServiceImpl;
import ru.diasoft.service.impl.TestingServiceImpl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AppShellComponentTest {
    @InjectMocks
    private AppShellComponent shellComponent;

    @Mock
    private IOServiceImpl ioService;

    @Mock
    private TestingServiceImpl testingService;

    @Test
    void startTest() {
        TestResult testResult = new TestResult("Test", 1, 1);

        when(testingService.runTest()).thenReturn(testResult);
        doNothing().when(ioService).printString(any(), any(), any());

        shellComponent.startTest();

        verify(testingService, times(1)).runTest();
        verify(ioService, times(1)).printString(any(), any(), any());
    }
}
