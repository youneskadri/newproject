package com.example.pidev.Service;

import com.example.pidev.Models.Item;
import com.example.pidev.entities.LigneOffre;
import com.example.pidev.entities.OffreFournisseur;
import com.example.pidev.entities.Produit;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JasperReportService {
    public byte[] getItemReport(OffreFournisseur items, String format) throws JRException, IOException {

        File file = ResourceUtils.getFile("classpath:item-report.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

        //Set report data
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(items.getOffres());
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("title", "Facture");
        parameters.put("eventNom", items.getProposition().getEvenement().getNom());
        parameters.put("NomFournisseur",items.getNomFornisseur());
        parameters.put("totalAmount", String.valueOf(prixTotale(items.getOffres())) );
        BufferedImage image = ImageIO.read(getClass().getResource("/images/ESPRIT.png"));
        parameters.put("logo", image );

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

        byte[] reportContent = JasperExportManager.exportReportToPdf(jasperPrint);

        return reportContent;

    }
    public double prixTotale(List<LigneOffre> produits){
        double x=0;
        for (LigneOffre p:
             produits) {
            x=x+(p.getPrixUnitaire()*p.getQuantite());
        }
        return x;
    }
}
