package com.example.jasperfxsample;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.swing.JRViewer;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

public class ReportService {

    public void generateReport() throws SQLException, JRException {
        System.out.println( "Hello World!" );
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost/ad","root","");

        HashMap hm = new HashMap<>();
        var jasperPrint = JasperFillManager.fillReport("informe.jasper",hm,c);

        var visor = new JRViewer(jasperPrint);

        JRViewer viewer = new JRViewer(jasperPrint);

        JFrame frame = new JFrame("Listado de Juegos");
        frame.getContentPane().add(viewer);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.pack();
        frame.setVisible(true);

        System.out.print("Done!");

        JRPdfExporter exp = new JRPdfExporter();
        exp.setExporterInput(new SimpleExporterInput(jasperPrint));
        exp.setExporterOutput(new SimpleOutputStreamExporterOutput("juegos.pdf"));
        exp.setConfiguration(new SimplePdfExporterConfiguration());
        exp.exportReport();

        System.out.print("Done!");
    }
}
