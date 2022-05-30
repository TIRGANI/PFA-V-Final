package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import static java.io.File.separator;

@RestController
public class FileImageUploadController {
    @PostMapping("load-ferme")
    public String uploadImageFerme(@RequestParam("file")MultipartFile file) throws Exception {

        String Path_Directory="src\\main\\resources\\static\\img\\fermes";
        String namef = "img/fermes/"+file.getOriginalFilename();
        Files.copy(file.getInputStream(), Paths.get(Path_Directory+ File.separator+file.getOriginalFilename()));
        return namef;
    }
    @PostMapping("load-parcelle")
    public String uploadImageParcelle(@RequestParam("file")MultipartFile file) throws Exception {

        String Path_Directory="src\\main\\resources\\static\\img\\parcelles";
        String namef = "img/parcelles/"+file.getOriginalFilename();
        Files.copy(file.getInputStream(), Paths.get(Path_Directory+ File.separator+file.getOriginalFilename()));
        return namef;
    }
    @PostMapping("load-plantes")
    public String uploadImagePlantes(@RequestParam("file")MultipartFile file) throws Exception {

        String Path_Directory="src\\main\\resources\\static\\img\\plantes";
        String namef = "img/plantes/"+file.getOriginalFilename();
        Files.copy(file.getInputStream(), Paths.get(Path_Directory+ File.separator+file.getOriginalFilename()));
        return namef;
    }
}
