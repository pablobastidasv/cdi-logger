package co.pablobastidas.log.boundary;

import co.pablobastidas.log.control.LoggerDefaultImpl;
import co.pablobastidas.log.entity.Logger;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

/**
 * Created by DELL on 17/01/2017.
 */
public class LoggerExposer {

    @Produces
    @Log
    public Logger producesLogger(InjectionPoint ip){
        return new LoggerDefaultImpl(ip.getMember().getDeclaringClass());
    }

}
