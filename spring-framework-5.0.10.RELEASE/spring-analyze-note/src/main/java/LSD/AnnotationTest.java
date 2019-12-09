package LSD;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext=
				new AnnotationConfigApplicationContext(AppConfig.class);
		DemoDao bean = applicationContext.getBean(DemoDao.class);
		bean.query();
		System.out.println("我太难了吧啊啊啊");
	}
}
