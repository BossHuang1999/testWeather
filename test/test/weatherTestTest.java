package test;

import org.junit.Test;

import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;

import static org.junit.jupiter.api.Assertions.*;

class weatherTestTest {

    @org.junit.jupiter.api.Test
    void cloud() throws ServiceException, RemoteException {
        weatherTest wt = new weatherTest();

        assertEquals(wt.cloud(),"8月11日 多云");
    }
}