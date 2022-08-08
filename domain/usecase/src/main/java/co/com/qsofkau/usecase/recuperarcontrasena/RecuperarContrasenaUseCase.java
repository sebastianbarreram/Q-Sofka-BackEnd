package co.com.qsofkau.usecase.recuperarcontrasena;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import co.com.qsofkau.model.usuario.Usuario;
import co.com.qsofkau.model.usuario.gateways.UsuarioRepository;

@RequiredArgsConstructor
public class RecuperarContrasenaUseCase {
    private final UsuarioRepository usuarioRepository; 
    public Flux<Usuario> recuperarContrasena(){								
		Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.ssl.protocols", "TLSv1.2");
		Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("memelopersteam@gmail.com", "chnmkxkwkrzrauzs");
            }
        });
		
		try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("memelopersteam@gmail.com"));
            message.setRecipients(
                Message.RecipientType.TO, InternetAddress.parse("sebama96@gmail.com"));
            message.setSubject("Mail Subject");
            
            // String msg = "This is my first email using JavaMailer";
            String msg = "This is my <b style='color:red;'>bold-red email</b> using JavaMailer <h1>Esto manda hasta html</h1>";
            
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(msg, "text/html; charset=utf-8");
            
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);
            
            message.setContent(multipart);
            
            Transport.send(message);
	        System.out.println("Email Sent Successfully!!");
		}catch(Exception e) {
			
			System.out.println("Exception message " + e.getMessage());
		}


        return usuarioRepository.findAll();
	}
    
}
