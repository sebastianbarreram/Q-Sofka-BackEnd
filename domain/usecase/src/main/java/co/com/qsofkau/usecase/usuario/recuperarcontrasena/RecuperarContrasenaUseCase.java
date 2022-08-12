package co.com.qsofkau.usecase.usuario.recuperarcontrasena;
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
import reactor.core.publisher.Mono;
import co.com.qsofkau.model.usuario.Usuario;
import co.com.qsofkau.model.usuario.gateways.UsuarioRepository;

@RequiredArgsConstructor
public class RecuperarContrasenaUseCase {
    private final UsuarioRepository usuarioRepository; 
    private String numeros = "0123456789";
	private String mayusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private String minusculas = "abcdefghijklmnopqrstuvwxyz";

    public Mono<Usuario> recuperarContrasena(String id){								
		Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.ssl.protocols", "TLSv1.2");
		Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() { //inicio de sesion
                return new PasswordAuthentication("memelopersteam@gmail.com", "chnmkxkwkrzrauzs");
            }
        });
		//Lo que se va a enviar
        String password = getRandom(mayusculas, 2)+
        getRandom(minusculas, 4)+
        getRandom(numeros,1)+
        getRandom(mayusculas, 1)+
        getRandom(minusculas, 1);
        System.out.println(password);
        Usuario usuario = usuarioRepository.findById(id).toFuture().join();
        usuario.setContrasena(password);

        //Enviar el menssaje
        //Armado del correo
		try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("memelopersteam@gmail.com"));
            message.setRecipients(
                Message.RecipientType.TO, InternetAddress.parse(usuario.getCorreo()));
            message.setSubject("Recuperación de contraseña");
            
            // String msg = "This is my first email using JavaMailer";
            String msg = "<h2>Su nueva contraseña es:</h2><h1>"+password+"</h1>"; //Cuerpo del correo

            //No tocar de aquí pa abajo
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
        return usuarioRepository.save(usuario);
	}

    private String getRandom(String key, int length) {
		String random = "";
		for (int i = 0; i < length; i++) {
			random+=(key.charAt((int)(Math.random() * key.length())));
		}
		return random;
	}
    
}
