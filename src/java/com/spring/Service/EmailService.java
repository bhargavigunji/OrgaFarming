package com.spring.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.andromeda.commons.model.Response;
import com.andromeda.commons.util.FileNDirUtils;
import com.spring.Model.Email;

import com.spring.Model.User;

@Service
public class EmailService
{
	@Autowired
	private JavaMailSender mailSender;
	Response response = new Response();

	public boolean sendHtmlMsg(Email email)
	{
		boolean status = false;
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		try
		{
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
			if ((email != null) && (email.getTo() != null) && (email.getTo().length != 0)
					&& (!StringUtils.isEmpty(email.getFrom()))
					&& (!StringUtils.isEmpty(email.getText())))
			{
				helper.setFrom(email.getFrom());
				helper.setTo(email.getTo());
				helper.setSubject(email.getSubject());
				String text =
						"<html><body>&nbsp;"
								+ "<br><p>"
								+ email.getText()
								+ "</p><br>"
								+ "<b>Thanks & Regards,</b><br>"
								+ " "
								+ "<b>Orga-Farms Team</b><br>"
								
								+ "<html><body>";
				helper.setText(text, true);
			}
			if ((email != null) && (email.getCc() != null) && (email.getCc().length != 0))
			{
				helper.setCc(email.getCc());
			}
			
			if (email.getAttachments() != null)
			{
				Iterator iterator = email.getAttachments().iterator();
				while (iterator.hasNext())
				{
					FileSystemResource file =
							new FileSystemResource(new File((String) iterator.next()));
					helper.addAttachment(file.getFilename(), file);
				}
			}
			Date date = new Date();
			helper.setSentDate(date);
			try
			{
				this.mailSender.send(mimeMessage);
				status = true;
			}
			catch (Exception ex)
			{
				status = false;
				System.err.println(ex.getMessage());
			}
		}
		catch (Exception e)
		{
			status = false;
		}
		return status;
	}
}
