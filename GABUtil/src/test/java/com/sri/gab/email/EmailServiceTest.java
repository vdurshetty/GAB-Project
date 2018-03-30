package com.sri.gab.email;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import org.junit.Assert;
import org.junit.Test;

public class EmailServiceTest {

	private Email getEmailObject() {
		Email email=new Email();
		email.setFrom("vdurshetty@gmail.com");
 		// Comma delimeter for multiple email addresses
		email.setTo("vdurshetty@yahoo.com");
    	String htmlMsg = "<html> <body> <font color=red> VENUGOPAL  Durshetty </font> <table border=1>  <tr> <td> Hello </td> <td> Venu</td> </tr></table> </body></html>";
    	//String plainTxt = "Test";
    	email.setMsg_body(htmlMsg);
    	email.setSubject("Test");
		return email;
	}
	
	private List<EmailAttachment> getAttachements() {
		
	  	String fileName1 = "D:/Venu/samples/RELIANCE.xlsx";
    	String fileName2 = "D:/Venu/samples/Spencer.xlsx";
    	File f1 = new File(fileName1);
    	File f2 = new File(fileName2);
    	
    	EmailAttachment attachment = new EmailAttachment();
    	
    	FileDataSource fds = new FileDataSource(f1);
    	DataHandler dh = new DataHandler(fds);
    	
    	attachment.setDataHandler(dh);
    	attachment.setFileName(f1.getName());
    	
    	
    	List<EmailAttachment> attachments = new ArrayList<>();
    	attachments.add(attachment);
    	
    	attachment = new EmailAttachment();
    	
    	fds = new FileDataSource(f2);
    	dh = new DataHandler(fds);
    	
    	attachment.setDataHandler(dh);
    	attachment.setFileName(f2.getName());
    	
    	attachments.add(attachment);
    	
 		
		return attachments;
	}
	
	@Test
	public void SendEmail() throws Exception{
    	EmailService es =new EmailService();
   		Assert.assertEquals(true,es.sendEmail(getEmailObject()));
	}
	
	@Test
	public void SendEmailWithAttachments() throws Exception{
    	EmailService es =new EmailService();
    	Email email = getEmailObject();
    	email.setAttachments( getAttachements());
   		Assert.assertEquals(true,es.sendEmail(email));
	}
	
	

}
