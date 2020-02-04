package ioc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AntIoc {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(UserIoc.class);
        User bean = ctx.getBean(User.class);
        System.out.println(bean);

        //使用注册的方式获取上下文
        AnnotationConfigApplicationContext ctx2 = new AnnotationConfigApplicationContext();
        ctx2.register(UserIoc.class);
        ctx2.refresh();
        System.out.println(ctx2.getBean(User.class));

        //使用扫包的方式获取上下文
        AnnotationConfigApplicationContext ctx3 = new AnnotationConfigApplicationContext();
        ctx3.scan("ioc");
        ctx3.refresh();
        System.out.println(ctx3.getBean(User.class));
    }
}
