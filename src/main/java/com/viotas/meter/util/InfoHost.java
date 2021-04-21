package com.viotas.meter.util;

/*
- - - - - - - - - - - - - - - - - - - - - -
 Viotas Assessment
- - - - - - - - - - - - - - - - - - - - - -
 Candidate: Weverton de Souza Castanho
 Email: wevertonsc@gmail.com
 Data: 21.APRIL.2021
- - - - - - - - - - - - - - - - - - - - - -
*/

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InfoHost {
    public String getIpHost(){
        InetAddress ip;
        String hostname;
        try {
            ip = InetAddress.getLocalHost();
            hostname = ip.getHostName();
            return hostname;

        } catch (UnknownHostException e) {

            e.printStackTrace();
        }

        return null;
    }
}
