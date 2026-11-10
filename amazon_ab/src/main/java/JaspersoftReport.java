import net.sf.jasperreports.engine.*;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;

public class JaspersoftReport extends DatabaseConnection {
    public JaspersoftReport(Connection C) {

        {
            try (InputStream ls = Main.class.getResourceAsStream("amazonin.jrxml")) {
                System.out.println("amazonin.jrmxl file loaded successfully");

                // compile jrxml file into jasper Report
                JasperReport report = JasperCompileManager.compileReport(ls);
                System.out.println("Compied");
                JasperPrint print = JasperFillManager.fillReport(report, new HashMap<>(),C);
                JasperExportManager.exportReportToPdfFile("amazon.pdf");

            } catch (IOException | JRException e) {
                System.err.println("jrxml connection failed");
                System.out.print("Error" + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}




