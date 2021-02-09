//Created by Dagger -- https://github.com/gavazquez
//With the help of ArSi -- https://github.com/arsi-apli

package org.cliner;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws UnknownHostException, IOException {
       check("s1.kiks.pro","c3d9c470", "fb9e27fd", 31000);
       check("s2.kiks.pro","c3d9c470", "fb9e27fd", 32000);
       check("s3.kiks.pro","c3d9c470", "fb9e27fd", 33000);
       check("s4.kiks.pro","c3d9c470", "fb9e27fd", 34000);
       check("s5.kiks.pro","c3d9c470", "fb9e27fd", 35000);
       check("s6.kiks.pro","c3d9c470", "fb9e27fd", 36000);
       check("s7.kiks.pro","c3d9c470", "fb9e27fd", 37000);
       check("s8.kiks.pro","c3d9c470", "fb9e27fd", 38000);
    }

    public static void check(String host, String user, String password, int port) {
       CcData.SetNodeId();
        List<CcCardData> cards = new ArrayList<>();

        try {
            cards = new CCcamConnector(host, port, user, password).TestCline();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (!cards.isEmpty()) {
            System.out.println("CCLine is valid");
            for (int i = 0; i < cards.size(); i++) {
                CcCardData card = cards.get(i);
                System.out.println(" caid " + DESUtil.intToHexString(card.getCaId(), 4) + " uphops " + card.getUpHops());

            }
        } else {
            System.out.println("CCLine is NOT valid");
        }
    }
}

