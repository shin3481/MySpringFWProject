package mylab.order.di.xml;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import org.junit.jupiter.api.Test;
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations ="classpath:mylab-order-di.xml")
public class OrderSpringTest {
//	@Autowired
//	@Qualifier("product1")
//	Product product1; 
//	@Autowired
//	@Qualifier("product2")
//	Product product2; 
	
	@Autowired
	@Qualifier("shoppingCart")
	ShoppingCart shoppingCart; 
	
	@Autowired
	@Qualifier("orderService")
	OrderService orderService; 
	
//	@Test 
//	void productsettor() {
//		System.out.println(product2.toString());
//	}
	
	@Test 
	void shoppingCartTest() {
		if(shoppingCart != null) {
			System.out.println("shoppingCart 객체 생성 성공!");

		}else {
			System.out.println("shoppingCart 객체가 null입니다.");
		}
		//assertEquals(2, shoppingCart.getProducts().size());
		//assertEquals("노트북", shoppingCart.getProducts().get(0).getName());
		//assertEquals("스마트폰", shoppingCart.getProducts().get(1).getName());
		assertEquals(900000.0, shoppingCart.getTotalPrice());
	}
	@Test @Disabled
	void orderServiceTest() {
		assertEquals(900000.0,orderService.calculateOrderTotal());
	}
}
