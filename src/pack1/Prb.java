/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pack1;


import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oscar
 */
public class Prb
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        //System.out.println(isAllowToChange("hydra"));
        // TODO code application logic here
        Subnet s = new Subnet();
        s.setIpPrin("192.168.0.0");
        int hosts[] =
        {
            20,21,22,23,24,25,26,27,28,29,30,31,2,2,2,2,2,2,2,2
        };
        s.setHosts(hosts);
        try
        {
            s.clasC();
        } catch (Exception ex)
        {
            Logger.getLogger(Prb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
