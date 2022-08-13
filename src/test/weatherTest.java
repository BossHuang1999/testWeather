package test;

import weather.WeatherWebService;
import weather.WeatherWebServiceLocator;
import weather.WeatherWebServiceSoap_PortType;

import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;

public class weatherTest {

    public static void main(String[] args) throws ServiceException, RemoteException {
        WeatherWebServiceLocator wwsl = new WeatherWebServiceLocator();
        WeatherWebServiceSoap_PortType wp = wwsl.getWeatherWebServiceSoap();
        String [] nj = wp.getWeatherbyCityName("南京");
        System.out.println(nj[6]);
    }

    public String cloud() throws ServiceException, RemoteException {
        WeatherWebServiceLocator wwsl = new WeatherWebServiceLocator();
        WeatherWebServiceSoap_PortType wp = wwsl.getWeatherWebServiceSoap();
        String [] nj = wp.getWeatherbyCityName("南京");
        return nj[6];
    }
}
