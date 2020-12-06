package propets.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import propets.email.dto.EmailDto;
import propets.email.service.EmailService;

@RestController
@RequestMapping("/mail")
public class EmailController {
	
	@Autowired
	EmailService emailService;
	
	@PostMapping
	public void sendEmail(@RequestBody EmailDto emailDto) {
		emailService.sendSimpleMessage(emailDto.getTo(), emailDto.getSubject(), emailDto.getText());
	}

}
