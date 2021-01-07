package propets.email.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import propets.email.dto.EmailListAndPostDto;

@Service
public class EmailNotifConsumer {
	
	@Autowired
	EmailService emailService;
	
		
	//@KafkaListener(topics = "${spring.cloud.stream.bindings.input.destination}")
	@KafkaListener(topics = "${topicName}")
	public void sendEmails(@Payload EmailListAndPostDto emailListAndPostDto,
						   @Headers MessageHeaders headers) {
		
		headers.keySet().forEach(key -> {
			System.out.println(key + " " + headers.get(key));
		});
		
		
		System.out.println("Consumer " + emailListAndPostDto);
		
		if(emailListAndPostDto != null) {
			List<String> emails = emailListAndPostDto.getEmails();
			
			String subject = "ProPetsService: You may be interested in!";
			String body = "Hello! Just now new post was added to our service and it contains data about pet, " + 
						  "that is very similar to data from your post. Maybe it is your pet!!! \n\n" + 
						  "Link to post: " + "https://zh-propets.herokuapp.com/post/" + emailListAndPostDto.getPostId();
			System.out.println(body);
			
			for(String email : emails) {
				System.out.println(email);
				emailService.sendSimpleMessage(email, subject, body);
			}
		}
	}

}
