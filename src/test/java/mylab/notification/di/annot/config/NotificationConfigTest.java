package mylab.notification.di.annot.config;

import static org.junit.jupiter.api.Assertions.*;

import mylab.notification.di.annot.NotificationManager;
import mylab.notification.di.annot.SmsNotificationService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = NotificationConfig.class)
public class NotificationConfigTest {

    @Autowired
    private NotificationManager manager;

    @Test
    public void testNotificationManagerDI() {
        // DI 검증
        assertNotNull(manager, "NotificationManager should not be null");
        assertNotNull(manager.getEmailService(), "EmailNotificationService should not be null");
        assertNotNull(manager.getSmsService(), "SmsNotificationService should not be null");
        SmsNotificationService smsService = (SmsNotificationService) manager.getSmsService();
        assertEquals("SKT", smsService.getProvider());
        // 메서드 실행 테스트
        
        manager.sendNotificationByEmail("테스트 이메일 메시지");
        manager.sendNotificationBySms("테스트 SMS 메시지");
    }
}
