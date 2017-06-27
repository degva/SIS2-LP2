/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupox.pokemonv.controller;

import java.awt.Container;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author USUARIO
 */
public class reporte {
    public void verReporte(){
        try{
            JFrame jf = new JFrame();
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://quilla.lab.inf.pucp.edu.pe:3306/inf282gx", "inf282gx", "m8h53r9A6xBfeOe6");
            System.out.println("Se ha realizado la conexión");
            Map mapa = new HashMap();
            //mapa.put("logo",this.getClass().getResourceAsStream("reportes/pok.jpg"));
            //mapa.put("player_id", "4");
            JasperPrint impresion = JasperFillManager.fillReport(
            reporte.class.getResource("/reports/newReport.jasper").getFile(),
                    mapa, con);
            JRViewer viewer = new JRViewer(impresion);
            Container c = jf.getContentPane();
            c.add(viewer);
            jf.setVisible(true);
            jf.setExtendedState(JFrame.MAXIMIZED_BOTH);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
