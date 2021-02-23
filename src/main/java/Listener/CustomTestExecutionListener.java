package Listener;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestIdentifier;

public class CustomTestExecutionListener implements TestExecutionListener {
    static Logger log = LogManager.getLogger(CustomTestExecutionListener.class);

    @Override
    public void executionStarted(TestIdentifier testIdentifier) {
        log.info("Start Test: " + testIdentifier.getDisplayName());
    }

    @Override
    public void executionFinished(TestIdentifier testIdentifier, TestExecutionResult testExecutionResult) {
        if (testIdentifier.isTest()) {
            log.info("TEST: " + testIdentifier.getDisplayName() + " -> RESULT:" + testExecutionResult.getStatus());
        }

        if (testExecutionResult.getStatus().toString().equals("FAILED".toUpperCase())) {
            log.error("*** REASON: " + testExecutionResult.getThrowable().toString());
        }
    }
}
