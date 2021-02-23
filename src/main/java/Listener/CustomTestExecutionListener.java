package Listener;

import org.junit.platform.commons.logging.LoggerFactory;
import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestIdentifier;

import java.util.logging.Logger;

public class CustomTestExecutionListener implements TestExecutionListener {
    private static final Logger log = (Logger) LoggerFactory.getLogger(CustomTestExecutionListener.class);

    @Override
    public void executionStarted(TestIdentifier testIdentifier) {
        log.info("Start Test: "+ testIdentifier.getDisplayName());
    }

    @Override
    public void executionFinished(TestIdentifier testIdentifier, TestExecutionResult testExecutionResult) {
        log.info("Finished Test: "+testIdentifier.getDisplayName() +" with result:"+testExecutionResult.toString());
    }
}
