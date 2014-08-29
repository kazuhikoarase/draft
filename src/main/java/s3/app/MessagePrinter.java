package s3.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import s3.service.MessageService;

@Component
public class MessagePrinter {

    final private MessageService service;

    @Autowired
    public MessagePrinter(MessageService service) {
        this.service = service;
    }

    public void printMessage() {
        System.out.println(this.service.getMessage());
    }
}
