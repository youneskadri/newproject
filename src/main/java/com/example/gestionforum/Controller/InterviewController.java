package com.example.gestionforum.Controller;

import com.example.gestionforum.Dto.InterviewEmailDto;
import com.example.gestionforum.Service.EmailService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class InterviewController {

    @Autowired
    EmailService emailService;

    @PostMapping("/interview/send-email")
    public String sendInterviewEmail(@RequestBody InterviewEmailDto interviewEmailDto) {
        String recipientEmail =  interviewEmailDto.getEmail();
        String subject = "Interview";
        String content = emailService.generateInterviewInvitationEmailContent(interviewEmailDto.getFirstName(), interviewEmailDto.getLastName(), interviewEmailDto.getType(), interviewEmailDto.getDate(), interviewEmailDto.getLink());
        try {
            emailService.sendEmail(recipientEmail, subject, content);
            return "Email sent successfully.";
        } catch (MessagingException | UnsupportedEncodingException e) {
            return "Failed to send email. Error: " + e.getMessage();
        }
    }
}
