package com.codetogive.webapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class PdfUploadController {

    @Autowired
    private UserService userService;

    @GetMapping("/upload")
    public String showUploadForm(Model model) {
        model.addAttribute("user", new User());
        return "pdfUploadForm";
    }

    @PostMapping("/upload")
    public String uploadPdf(@ModelAttribute User user, @RequestParam("pdf") MultipartFile pdfFile) throws IOException {
        byte[] pdfBytes = pdfFile.getBytes();
        user.setPdf(pdfBytes);
        userService.createUser(user);
        return "pdfUploadSuccess";
    }
}

