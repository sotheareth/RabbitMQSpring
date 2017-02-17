package spring.jms;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import model.Document;
import utils.XmlUtils;

@Component("rabbitmqProducer")
public class RabbitMQProducer {
	
	@Value("classpath:META-INF/data/rabbit.xml")
	private Resource jmstxt;
	
	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void send(Document document) {
		MessageProperties messageProperties = new MessageProperties();
		messageProperties.setContentType("text/xml");
		byte[] body = XmlUtils.toXML(document).getBytes();
		
		Message message = new Message(body, messageProperties);
		rabbitTemplate.send(message);
	}
	
	public void send() {
		MessageProperties messageProperties = new MessageProperties();
		messageProperties.setContentType("text/xml");
		byte[] body = XmlUtils.toXML(getMessage()).getBytes();
		
		Message message = new Message(body, messageProperties);
		rabbitTemplate.send(message);
	}
	
	private String getMessage() {
		StringBuilder str = new StringBuilder();
		try {
			InputStream stream = jmstxt.getInputStream();
			Scanner scanner = new Scanner(stream);
			while (scanner.hasNext()) {
				str.append(scanner.nextLine());
			}
			scanner.close();
			stream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str.toString();
	}
}
