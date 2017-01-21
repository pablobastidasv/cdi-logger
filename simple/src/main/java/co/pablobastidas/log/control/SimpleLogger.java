package co.pablobastidas.log.control;

import co.pablobastidas.log.entity.Logger;

import java.text.MessageFormat;
import java.util.logging.Level;

/**
 * Implementation of our logger contract ussing java Logger
 *
 * @see java.util.logging.Logger
 *
 * @author pablobastidasv
 */
public class SimpleLogger implements Logger {

    private java.util.logging.Logger logger;

    public SimpleLogger(Class clazz) {
        this.logger = java.util.logging.Logger.getLogger(clazz.getName());
    }

    /**
     * Gets logger
     *
     * @return value of logger
     */
    public java.util.logging.Logger getLogger() {
        return logger;
    }

    @Override
    public void info(String msg, Object... args) {
        log(Level.INFO, msg, args);
    }

    @Override
    public void info(String msg, Throwable t, Object... args) {
        log(Level.INFO, msg, t, args);
    }

    @Override
    public void debug(String msg, Object... args) {
        log(Level.FINE, msg, args);
    }

    @Override
    public void debug(String msg, Throwable t, Object... args) {
        log(Level.FINE, msg, t, args);
    }

    @Override
    public void warn(String msg, Object... args) {
        log(Level.WARNING, msg, args);
    }

    @Override
    public void warn(String msg, Throwable t, Object... args) {
        log(Level.WARNING, msg, t, args);
    }

    @Override
    public void error(String msg, Object... args) {
        log(Level.SEVERE, msg, args);
    }

    @Override
    public void error(String msg, Throwable t, Object... args) {
        log(Level.SEVERE, msg, t, args);
    }

    private void log(Level level, String message, Object... args){
        String msg = MessageFormat.format(message, args);
        logger.log(level, msg);
    }

    private void log(Level level, String message, Throwable t, Object... args){
        String msg = MessageFormat.format(message, args);
        logger.log(level, msg, t);
    }
}
