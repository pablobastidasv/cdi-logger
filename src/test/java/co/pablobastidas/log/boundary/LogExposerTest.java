package co.pablobastidas.log.boundary;

import co.pablobastidas.log.control.LoggerDefaultImpl;
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

    @Inject
    public void setLog(@Log Logger log) {
        this.log = log;
    }

    @Before
    public void setUp(){

        LoggerDefaultImpl log = (LoggerDefaultImpl) this.log;

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

    @Test
    public void testInfoMessage(){
        String msg = "hola que hace!!!";
        log.info(msg);

        validateMessage(msg, Level.INFO);
    }

    @Test
    public void testDebugMessage(){
        String msg = "hola que hace!!!";
        log.debug(msg);

        validateMessage(msg, Level.FINE);
    }

    @Test
    public void testInfoMessageWithArg(){
        String expectedMessage = "hola que hace esto ó lo otro!!!";
        log.info("hola que hace {0} ó {1}!!!", "esto", "lo otro");

        validateMessage(expectedMessage, Level.INFO);
    }
}