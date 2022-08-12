package co.com.qsofkau.usecase.aspirante.generarCodigo;

import co.com.qsofkau.model.aspirante.Aspirante;
import co.com.qsofkau.model.aspirante.gateways.AspiranteRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

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

@RequiredArgsConstructor
public class GenerarCodigoUseCase {
    private String mayusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String numeros = "0123456789";
    private final AspiranteRepository aspiranteRepository;

    public Mono<Aspirante> generarCodigo(Aspirante aspirante){
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

        String codigo = getRandom(mayusculas, 4)
        +"-"+getRandom(numeros, 4);
        System.out.println(codigo);
        //Aspirante aspirante = aspiranteRepository.findById(id).toFuture().join();
        aspirante.setCodigoVerificacion(codigo);

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("memelopersteam@gmail.com"));
            message.setRecipients(
                Message.RecipientType.TO, InternetAddress.parse(aspirante.getCorreo()));
            message.setSubject("Código de verificación");
            
            // String msg = "This is my first email using JavaMailer";
            String msg = "<h2>Su código de verificación para presentar la prueba es:</h2><h1>"+codigo+"</h1>";
            
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

        return aspiranteRepository.save(aspirante);
    }


    private String getRandom(String key, int length) {
		String random = "";
		for (int i = 0; random.length() < length; i++) {
            char newChar=(key.charAt((int)(Math.random() * key.length())));
            if(!random.contains(String.valueOf(newChar))){
                random+=newChar;
            }
		}
		return random;
	}
}
