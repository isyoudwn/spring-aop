package isyoudwn.aop.order.aop;

import org.aspectj.lang.annotation.Pointcut;

public class PointCuts {

    @Pointcut("execution(* isyoudwn.aop.order..*(..))")
    public void allOrder() {};

    // 클래스 이름 패턴이 *Service 인 것
    @Pointcut("execution(* *..*Service.*(..))")
    public void allService() {};

    @Pointcut("allOrder() && allService()")
    public void orderAndService() {};
}
