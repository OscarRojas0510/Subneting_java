/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pack1;

import java.util.HashMap;

/**
 *
 * @author oscar
 */
public class Subnet
{

    private String ipPrin;
    private int hosts[];

    public HashMap<String, String> clasC() throws Exception
    {
        HashMap<String, String> map = new HashMap<>();
        int rango, cifra, host, bit;
        String ipRed, ipInit = null, ipFin = null, ipBroad = null, mask = null;
        ipRed = ipPrin;
        System.out.println("host\tbit\trango\tipred\t\tip inicial\tip final\t\tip broad\t\tmascara\t\tcifra");
        for (int i = 0; i < getHosts().length; i++)
        {
            host = getHosts()[i];
            System.out.print(host + "\t");
            bit = 0;
            while (((int) Math.pow(2, bit)) - 1 <= host)
            {
                bit++;
            }
            System.out.print(bit + "\t");
            rango = ((int) Math.pow(2, bit)) - 1;
            System.out.print(rango + "\t");
            int octetosipRed[] = separaOctetos(ipRed);
            if (ipBroad != null)
            {
                int octetosipBroad[] = separaOctetos(ipBroad);
                octetosipRed = sumaHosts(octetosipBroad, 1);
            }
            ipRed = "";
            for (int j = 0; j < octetosipRed.length; j++)
            {
                ipRed += octetosipRed[j];
                if (j < octetosipRed.length - 1)
                {
                    ipRed += ".";
                }
            }
            System.out.print(ipRed + "\t");

            int octetosipInit[] = sumaHosts(octetosipRed.clone(), 1);
            ipInit = "";
            for (int j = 0; j < octetosipInit.length; j++)
            {
                ipInit += octetosipInit[j];
                if (j < octetosipInit.length - 1)
                {
                    ipInit += ".";
                }
            }
            System.out.print(ipInit + "\t");

            int octetosipFin[] = sumaHosts(octetosipRed.clone(), rango - 1);
            ipFin = "";
            for (int j = 0; j < octetosipFin.length; j++)
            {
                ipFin += octetosipFin[j];
                if (j < octetosipFin.length - 1)
                {
                    ipFin += ".";
                }
            }
            System.out.print(ipFin + "\t");

            int octetosipBroad[] = sumaHosts(octetosipRed.clone(), rango);
            ipBroad = "";
            for (int j = 0; j < octetosipBroad.length; j++)
            {
                ipBroad += octetosipBroad[j];
                if (j < octetosipBroad.length - 1)
                {
                    ipBroad += ".";
                }
            }
            System.out.print(ipBroad + "\t");

            mask = "255.255.255.255";
            int octetosMask[] = restaMask(separaOctetos(mask), rango);
            mask = "";
            for (int j = 0; j < octetosMask.length; j++)
            {
                mask += octetosMask[j];
                if (j < octetosMask.length - 1)
                {
                    mask += ".";
                }
            }
            System.out.print(mask + "\t");

            cifra = 32 - bit;
            System.out.print(cifra + "\t");
            System.out.println();

        }
        return map;
    }

    private int[] separaOctetos(String ip)
    {
        if (ip != null)
        {
            int octetos[] = new int[4];
            int punto = ip.indexOf(".");
            int i = 0;
            while (punto != -1)
            {
                octetos[i] = Integer.parseInt(ip.substring(0, punto));
                i++;
                ip = ip.substring(punto + 1);
                punto = ip.indexOf(".");
            }
            octetos[i] = Integer.parseInt(ip);
            return octetos;
        } else
        {
            return null;
        }
    }

    public int[] sumaHosts(int octetos[], int cant) throws Exception
    {
        octetos[3] += cant;
        while (octetos[3] > 255)
        {
            octetos[3] = octetos[3] - 256;
            octetos[2]++;
            while (octetos[2] > 255)
            {
                octetos[2] = octetos[2] - 256;
                octetos[1]++;
                while (octetos[1] > 255)
                {
                    octetos[1] = octetos[1] - 256;
                    octetos[0]++;
                    if (octetos[0]>255)
                    {
                        throw new Exception("Exception message");
                    }

                }
            }
        }
        return octetos;
    }

    private int[] restaMask(int octetos[], int cant)
    {
        octetos[3] -= cant;
        if (octetos[3] < 0)
        {
            int residuo = -octetos[3];
            octetos[3] = 0;
            int j = 2;
            while (residuo > 0)
            {
                octetos[j] -= residuo;
                if (octetos[j] < 0)
                {
                    octetos[j] = 0;
                    j--;
                    residuo = -octetos[j];
                } else
                {
                    residuo = 0;
                }
            }
        }
        return octetos;
    }

    /**
     * @return the ipPrin
     */
    public String getIpPrin()
    {
        return ipPrin;
    }

    /**
     * @param ipPrin the ipPrin to set
     */
    public void setIpPrin(String ipPrin)
    {
        this.ipPrin = ipPrin;
    }

    /**
     * @return the hosts
     */
    public int[] getHosts()
    {
        return hosts;
    }

    /**
     * @param hosts the hosts to set
     */
    public void setHosts(int[] hosts)
    {
        this.hosts = hosts;
    }

}
