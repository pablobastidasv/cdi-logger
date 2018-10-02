package co.pablobastidas.log.boundary;

import co.pablobastidas.log.control.SimpleLogger;
import co.pablobastidas.log.entity.Logger;
import org.apache.deltaspike.testcontrol.api.junit.CdiTestRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.StreamHandler;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Unit test for LoggerExposer and example of how to use.
 *
 * @author pablobastidasv
 */
@RunWith(CdiTestRunner.class)
public class LogExposerTest {

    private Logger log;

    private OutputStream logOut;
    private StreamHandler testLogHandler;

    String errorMessage = "Error Message";
    IllegalArgumentException error = new IllegalArgumentException(errorMessage);

    @Inject
    public void setLog(Logger log) {
        this.log = log;
    }

    @Before
    public void setUp(){

        SimpleLogger log = (SimpleLogger) this.log;

        logOut = new ByteArrayOutputStream();
        Handler[] handlers = log.getLogger().getParent().getHandlers();
        testLogHandler = new StreamHandler(logOut, handlers[0].getFormatter());
        testLogHandler.setLevel(Level.FINEST);
        log.getLogger().addHandler(testLogHandler);
        log.getLogger().setLevel(Level.FINEST);

    }

    private void validateMessage(String msg, Level level) {
        testLogHandler.flush();
        assertThat(logOut.toString()).
                contains(level.getName()).
                contains(msg);
    }

    private void validateMessage(String msg, Level level, Throwable t) {
        validateMessage(msg, level);
        assertThat(logOut.toString())
                .contains(t.getMessage());
    }

    @Test
    public void testInfoMessage(){
        String msg = "hola que hace!!!";
        log.info(msg);

        validateMessage(msg, Level.INFO);
    }

    @Test
    public void testInfoMessageWithException(){
        String msg = "hola que hace!!!";
        log.info(msg, error);

        validateMessage(msg, Level.INFO, error);
    }

    @Test
    public void testDebugMessage(){
        String msg = "hola que hace!!!";
        log.debug(msg);

        validateMessage(msg, Level.FINE);
    }

    @Test
    public void testDebugMessageMessage(){
        String msg = "hola que hace!!!";
        log.debug(msg, error);

        validateMessage(msg, Level.FINE, error);
    }

    @Test
    public void testInfoMessageWithArg(){
        String expectedMessage = "hola que hace esto o lo otro!!!";
        log.info("hola que hace {0} o {1}!!!", "esto", "lo otro");

        validateMessage(expectedMessage, Level.INFO);
    }

    @Test
    public void testWarnMessage(){
        String msg = "hola que hace!!!";
        log.warn(msg);

        validateMessage(msg, Level.WARNING);
    }

    @Test
    public void testWarnMessageWithException(){
        String msg = "hola que hace!!!";
        log.warn(msg, error);

        validateMessage(msg, Level.WARNING, error);
    }

    @Test
    public void testErrorMessage(){
        String msg = "hola que hace!!!";
        log.error(msg);

        validateMessage(msg, Level.SEVERE);
    }

    @Test
    public void testErrorMessageWithException(){
        String msg = "hola que hace!!!";
        log.error(msg, error);

        validateMessage(msg, Level.SEVERE, error);
    }
}