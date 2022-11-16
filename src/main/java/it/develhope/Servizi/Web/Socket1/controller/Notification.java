package it.develhope.Servizi.Web.Socket1.controller;

import it.develhope.Servizi.Web.Socket1.entities.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping
public class Notification {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @PostMapping("/notification")
    public ResponseEntity sendMessage(@Payload MessageDTO message) {
         simpMessagingTemplate.convertAndSend("/broadcast/message",message);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
