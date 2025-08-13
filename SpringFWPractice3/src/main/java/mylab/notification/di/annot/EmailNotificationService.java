package mylab.notification.di.annot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EmailNotificationService implements NotificationService {

	private String smtpServer;
    private int port;
    
    public EmailNotificationService(@Value("${email.smtpServe}") String smtpServer,@Value("${email.port}") int port) {
        
        this.smtpServer = smtpServer;
        this.port = port;
    }
    
    public String getSmtpServer() { return smtpServer; }
    public int getPort() { return port; }
    
    @Override
    public void sendNotification(String message) {
        System.out.println("이메일 알림 전송: " + message + " (서버: " + smtpServer + ":" + port + ")");
    }
}
