package com.example.springdemo.di.setter.ex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
    public static void main(String[] args){

        String configLocation = "classpath:applicationCTX.xml";
        AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
        MyInfo myInfo = ctx.getBean("myInfo", MyInfo.class);

        myInfo.getInfo();

        /* DI with Spring Config
        // classpath 는 무조건 써줘야하고 그 뒤는 내가 만든 xml 파일
        String configLocation = "classpath:applicationCTX.xml";
        // 빈즈 생성 코드
        AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
        // bean 가져오는 코드
        // xml 에서 MyCalculator 와 Calculator 의 객체를 생성하고
        // 조합한 후 가지고 있었다는 것을 알 수 있다.
        MyCalculator myCalculator = ctx.getBean("myCalculator", MyCalculator.class);
        */
        /* DI with setter
        MyCalculator myCalculator = new MyCalculator();
        // setter 를 통해서 객체를 주입해줌.
        myCalculator.setCalculator(new Calculator());

        myCalculator.setFirstNum(10);
        myCalculator.setSecondNum(2);
         */

        // 실행 코드
//        myCalculator.add();
//        myCalculator.sub();
//        myCalculator.mul();
//        myCalculator.div();

    }
}
