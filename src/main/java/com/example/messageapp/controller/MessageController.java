package com.example.messageapp.controller;

import com.example.messageapp.model.Message;
import com.example.messageapp.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messageService")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/getAllMessages")
    public List<Message> list(){
        return messageService.getAllMessages();
    }

    @PostMapping("/saveMessage")
    public Message createMessage(@RequestBody Message message) {
        return messageService.saveMessage(message);
    }

    @PutMapping("/updateMessage/{id}")
    public Message updateMessage(@PathVariable Long id, @RequestBody Message message) {
        return messageService.updateMessage(id, message);
    }

    @DeleteMapping("/deleteMessage/{id}")
    public void deleteMessage(@PathVariable Long id){
        messageService.deleteMessage(id);
    }
}
