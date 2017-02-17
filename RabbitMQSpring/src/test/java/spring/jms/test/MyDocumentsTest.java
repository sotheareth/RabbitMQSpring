package spring.jms.test;

import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.UUID;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import model.Document;
import model.Type;
import spring.jms.RabbitMQProducer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/spring/mydocuments-context.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MyDocumentsTest {

	private static final Logger log = LoggerFactory.getLogger(MyDocumentsTest.class);

	@Autowired
	RabbitMQProducer rabbitmqProducer;

	@Test
	public void testSpringRabbitMQ_1() {

		log.debug("Testing RabbitMQ producer...");
		assertNotNull(rabbitmqProducer);

		Document document = new Document();
		document.setCreated(new Date());
		document.setDescription("test");
		document.setDocumentId(UUID.randomUUID().toString());
		document.setLocation("http://www.apress.com");
		document.setModified(new Date());
		document.setName("Apress Books");
		Type type = new Type();
		type.setTypeId("4980d2e4-a424-4ff4-a0b2-476039682f43");
		type.setName("WEB");
		type.setExtension(".url");
		type.setDesc("APRESS BOOk");
		document.setType(type );
		rabbitmqProducer.send(document );
		
	}
	
	@Test
	public void testSpringRabbitMQ_2() throws InterruptedException {
		Thread.sleep(5000);
	}
}
