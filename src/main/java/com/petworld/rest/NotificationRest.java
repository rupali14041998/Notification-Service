package com.petworld.rest;

import com.petworld.model.EmailRequest;
import com.petworld.model.NotificationRequest;
import com.petworld.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notification")
public class NotificationRest {

    @Autowired
    private NotificationService notificationService;

    @PostMapping("send-email")
    public String sendEmail(@RequestBody EmailRequest emailRequest) throws Exception {
        return notificationService.sendEmail(emailRequest);
    }

    @PostMapping("/send-otp")
    public void sendOtp(@RequestBody NotificationRequest notificationRequest) {
        notificationService.sendNotification(notificationRequest.getPhone(), notificationRequest.getOtp());
    }

}
