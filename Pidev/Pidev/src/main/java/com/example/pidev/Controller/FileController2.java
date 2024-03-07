package com.example.pidev.Controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.pidev.Service.FileStorageService;
import com.example.pidev.entities.FileDB;
import com.example.pidev.entities.Livrable;
import com.example.pidev.message.ResponseFile;
import com.example.pidev.message.ResponseMessage;



@Controller
@CrossOrigin("*")
public class FileController2 {

    @Autowired
    private FileStorageService storageService;

   /* @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";
        try {
            storageService.store(file);

            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }*/

   /* @PostMapping("/upload")
    public ResponseEntity<String> handleFileUpload(
            @RequestParam("file") MultipartFile file,
            @RequestParam("besoinId") Long besoinId
    ) {
        try {
            FileDB savedFile = storageService.store(file, besoinId);
            return ResponseEntity.ok("File uploaded successfully with ID: " + savedFile.getId());
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception based on your application's requirements
            return ResponseEntity.status(500).body("Error uploading the file");
        }

    }*/

    @PostMapping("/upload/{besoinId}")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file, @PathVariable Long besoinId) {
        String message = "";
        try {
            storageService.store(file,besoinId);

            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }


    @GetMapping("/files")
    public ResponseEntity<List<ResponseFile>> getListFiles() {
        List<ResponseFile> files = storageService.getAllFiles().map(dbFile -> {
            String fileId = dbFile.getId();
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/files/")
                    .path(fileId)
                    .toUriString();
            Livrable livrable = dbFile.getLivrable();
            return new ResponseFile(
                    dbFile.getName(),
                    fileDownloadUri,
                    dbFile.getType(),
                    dbFile.getData().length,
                    livrable,
                    fileId
            );
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(files);
    }

    @GetMapping("/files/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable String id) {
        FileDB fileDB = storageService.getFile(id);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
                .body(fileDB.getData());
    }
    @PutMapping("/files/{fileId}/updateLivrableNote")
    public ResponseEntity<String> updateLivrableNote(
            @PathVariable String fileId,
            @RequestParam int newNote) {
        try {
            // Log parameters for debugging
            System.out.println("File ID: " + fileId);
            System.out.println("New Note: " + newNote);

            storageService.updateLivrableNote(fileId, newNote);
            return ResponseEntity.ok("Livrable Note updated successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update Livrable Note.");
        }
    }

}
