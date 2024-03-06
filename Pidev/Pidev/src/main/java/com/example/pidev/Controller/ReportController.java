package com.example.pidev.Controller;

import com.example.pidev.Models.Item;
import com.example.pidev.Service.JasperReportService;

import com.example.pidev.Service.ServiceOffreFournisseur;
import com.example.pidev.entities.OffreFournisseur;
import net.sf.jasperreports.engine.JRException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ReportController {


    @Autowired
    JasperReportService jasperReportService;
    @Autowired
    ServiceOffreFournisseur serviceOffreFournisseur;

    @GetMapping("item-report/{id}")
    public ResponseEntity<Resource> getItemReport(@PathVariable long id) throws JRException, IOException {

    OffreFournisseur l=serviceOffreFournisseur.getOffreById(id);



        byte[] reportContent = jasperReportService.getItemReport(l, "pdf");

        ByteArrayResource resource = new ByteArrayResource(reportContent);

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .contentLength(resource.contentLength())
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        ContentDisposition.attachment()
                                .filename("Facture." + "pdf")
                                .build().toString())
                .body(resource);
    }
}