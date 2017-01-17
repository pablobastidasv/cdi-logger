package co.pablobastidas.log.boundary;

import co.pablobastidas.log.entity.Logger;
import org.apache.deltaspike.testcontrol.api.junit.CdiTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

/**
 * Created by DELL on 17/01/2017.
 */
@RunWith(CdiTestRunner.class)
public class LogProducerTest {

    @Inject
    @Log
    private Logger log;

    @Test
    public void test(){
        log.info("hola que hace!!!");
    }
    @Test
    public void testArgs(){
        log.info("hola que hace {0} ó {1}!!!", "esto", "lo otro");
    }
}