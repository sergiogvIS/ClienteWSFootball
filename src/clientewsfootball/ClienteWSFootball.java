/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientewsfootball;

import java.util.List;

/**
 *
 * @author entrar
 */
public class ClienteWSFootball {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Yellow cards: " + yellowCardsTotal());
        defensasPais();
    }
    private static void defensasPais(){
        List<TCountryInfo> paises = countryNames(true).getTCountryInfo();
        for(TCountryInfo tCountryInfo : paises){
            System.out.println("Defensas de: " + tCountryInfo.sName);
            List<String> defensasp = allDefenders(tCountryInfo.sName).getString();
            for(int i = 0;i < defensasp.size(); i++){
                System.out.println(defensasp.get(i));
            }
            System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
        }
        List<String> defensas = allDefenders("Spain").getString();
        System.out.println("Defensas de España:");
        for(int i = 0;i < defensas.size(); i++){
            System.out.println("Defensa:" + defensas.get(i));
        }   
    }
    private static int yellowCardsTotal() {
        clientewsfootball.Info service = new clientewsfootball.Info();
        clientewsfootball.InfoSoapType port = service.getInfoSoap();
        return port.yellowCardsTotal();
    }

    private static ArrayOfString allDefenders(java.lang.String sCountryName) {
        clientewsfootball.Info service = new clientewsfootball.Info();
        clientewsfootball.InfoSoapType port = service.getInfoSoap();
        return port.allDefenders(sCountryName);
    }

    private static ArrayOftCountryInfo countryNames(boolean bWithCompetitors) {
        clientewsfootball.Info service = new clientewsfootball.Info();
        clientewsfootball.InfoSoapType port = service.getInfoSoap();
        return port.countryNames(bWithCompetitors);
    }
    
}
