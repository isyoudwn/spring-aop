package isyoudwn.aop;


import isyoudwn.aop.order.OrderRepository;
import isyoudwn.aop.order.OrderService;
import isyoudwn.aop.order.aop.AspectV1;
import isyoudwn.aop.order.aop.AspectV2;
import isyoudwn.aop.order.aop.AspectV3;
import isyoudwn.aop.order.aop.AspectV4;
import isyoudwn.aop.order.aop.AspectV5;
import isyoudwn.aop.order.aop.AspectV6Advice;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Slf4j
@SpringBootTest
@Import({AspectV6Advice.class})
public class AopTest {

    @Autowired
    OrderService orderService;

    @Autowired
    OrderRepository orderRepository;

    @Test
    void aopInfo() {
        log.info("isAopProxy, orderService={}", AopUtils.isAopProxy(orderService));
        log.info("isAopProxy, orderRepository={}", AopUtils.isAopProxy(orderRepository));
    }

    @Test
    void success() {
        orderService.orderItem("itemA");
    }

    @Test
    void exception() {
        Assertions.assertThatThrownBy(()
                        -> orderService.orderItem("ex"))
                .isInstanceOf(IllegalStateException.class);
    }
}
