package com.example.gestionforum.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class EmailService {
    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(String email, String subject, String content) throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom("forum-enterprise@esprit.tn", "Forum Entreprise");
        helper.setTo(email);

        helper.setSubject(subject);
        helper.setText(content, true);

        mailSender.send(message);
    }

    public String generateInterviewInvitationEmailContent(String intervieweeFirstName,
                                                          String intervieweeLastName,
                                                          String interviewType,
                                                          LocalDateTime interviewDate,
                                                          String interviewLink) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm a");

        String formattedDate = interviewDate.format(dateFormatter);
        String formattedTime = interviewDate.format(timeFormatter);

        return "<html>\n"
                + "<body>\n"
                + "<p><strong>Subject:</strong> Interview Invitation</p>\n\n"
                + "<p>Dear " + intervieweeFirstName + " " + intervieweeLastName + ",</p>\n\n"
                + "<p>We are excited to invite you for an interview with our company. Please find the details below:</p>\n\n"
                + "<ul>\n"
                + "<li><strong>Interview Type:</strong> " + interviewType + "</li>\n"
                + "<li><strong>Interview Date:</strong> " + formattedDate + "</li>\n"
                + "<li><strong>Interview Time:</strong> " + formattedTime + "</li>\n"
                + "<li><strong>Interview Link:</strong> <a href=\"" + interviewLink + "\">Click here</a></li>\n"
                + "</ul>\n\n"
                + "<p>We look forward to discussing your qualifications and getting to know you better.</p>\n\n"
                + "<p>Best regards,</p>\n"
                + "</body>\n"
                + "</html>";
    }
}
