package co.com.qsofkau.usecase.aspirante.enviarcorreoaspirante;

import co.com.qsofkau.model.aspirante.Aspirante;
import co.com.qsofkau.model.aspirante.Mensaje;
import co.com.qsofkau.model.aspirante.gateways.AspiranteRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.plaf.basic.BasicTreeUI;
import java.util.Properties;

@RequiredArgsConstructor
public class EnviarCorreoAspiranteUseCase {

    private final AspiranteRepository aspiranteRepository;

    public Mono<Aspirante> enviarCorreo(String id, Mensaje mensaje){

        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("memelopersteam@gmail.com", "chnmkxkwkrzrauzs");
            }
        });

        Aspirante aspirante = aspiranteRepository.findById(id).toFuture().join();

        String mensajeEnviar = "<h2>" + mensaje.getNombre() +", tu valoracion fue de: "+ mensaje.getValoracion() +"% <br>\n" +
                "    Buen trabajo, eres un candidato para: <br>" + mensaje.getFase() + "</h2>";

        try {
            Message message = new MimeMessage(session);
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(aspirante.getCorreo()));
            message.setSubject("Resultados Prueba Admisión Sofka");
            String msj = "<h1>" + mensajeEnviar + "</h1>";

            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(msj, "text/html; charset=utf-8");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);

            message.setContent(multipart);

            Transport.send(message);
            System.out.println("Email Sent Successfully!!");

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return aspiranteRepository.save(aspirante);

    }


}
