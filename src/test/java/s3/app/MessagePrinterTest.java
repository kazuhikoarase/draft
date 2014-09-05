package s3.app;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import s3.service.MessageService;

@Configuration
@ComponentScan
public class MessagePrinterTest {

	@Bean
    public MessageService mockMessageService() {
        return new MessageService() {
            public String getMessage() {
              return "Hello World!";
            }
        };
    }

	ApplicationContext context = 
			new AnnotationConfigApplicationContext(MessagePrinterTest.class);
	@Test
	public void test1() {
		MessageService service = context.getBean(MessageService.class);
		Assert.assertEquals("Hello World!", service.getMessage() );
	}

	@Test
	public void test2() {
		MessagePrinter printer = context.getBean(MessagePrinter.class);
		printer.printMessage();
         
	}
}