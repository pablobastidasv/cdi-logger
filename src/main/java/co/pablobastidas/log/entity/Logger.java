package co.pablobastidas.log.entity;

/**
 * Created by DELL on 17/01/2017.
 */
public interface Logger {

    void info(String msg, Object... args);
    void info(String msg, Throwable t, Object... args);
    void debug(String msg, Object... args);
    void debug(String msg, Throwable t, Object... args);
    void warn(String msg, Object... args);
    void warn(String msg, Throwable t, Object... args);
    void error(String msg, Object... args);
    void error(String msg, Throwable t, Object... args);

}
