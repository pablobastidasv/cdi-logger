package co.pablobastidas.log.boundary;

import co.pablobastidas.log.control.SimpleLogger;
import co.pablobastidas.log.entity.Logger;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

/**
 * Logger exposer, presented as a basic logging using java logging
 * @see java.util.logging.Logger
 *
 * @author pablobastidasv
 */
public class LoggerExposer {

    @Produces
    public Logger producesLogger(InjectionPoint ip){
        return new SimpleLogger(ip.getMember().getDeclaringClass());
    }

}
