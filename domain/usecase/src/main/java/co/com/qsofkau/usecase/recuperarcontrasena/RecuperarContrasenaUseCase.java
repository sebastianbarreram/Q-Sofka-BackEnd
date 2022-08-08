package co.com.qsofkau.usecase.recuperarcontrasena;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import co.com.qsofkau.model.usuario.Usuario;
import co.com.qsofkau.model.usuario.gateways.UsuarioRepository;

@RequiredArgsConstructor
public class RecuperarContrasenaUseCase {
    private final UsuarioRepository usuarioRepository; 
    public Flux<Usuario> recuperarContrasena(){
        // Mention the Recipient's email addess
        String to = "sebama96@gmail.com";

        // Mention the Sender's email address
        String from = "memelopersteam@gmail.com";
        String password = "Memelopersteam1";
								
		String host = "smtp.gmail.com"; 						
		String port = "587";									
		
		String user = "memelopersteam@gmail.com";	
        System.out.println("se crearon las variables");									
		
		Properties properties = System.getProperties();						
		properties.setProperty("mail.smtp.auth", "true");		
		properties.setProperty("mail.smtp.host", host);			
		properties.setProperty("mail.smtp.port", port);			
		properties.setProperty("mail.smtp.user", user);			
		properties.setProperty("mail.smtp.password", password);	
		
		
		properties.setProperty("mail.smtp.starttls.enable", "true");	
		
		Session session = Session.getDefaultInstance(properties);		
		
		try {
			System.out.println("try");
			MimeMessage message = new MimeMessage(session);				
			message.setFrom(new InternetAddress(from));
			
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			
			message.setSubject("Demo Mail");
			message.setText("This is a demo mail from spring boot app");
			
			Transport transport = session.getTransport("smtp");
			transport.connect(host, from, password);					
			transport.sendMessage(message, message.getAllRecipients());			
			transport.close();
		}catch(Exception e) {
			
			System.out.println("Exception message " + e.getMessage());
		}


        return usuarioRepository.findAll();
	}
    
}
