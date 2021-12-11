package com.github.design.dynamic_proxy;

import java.lang.reflect.Proxy;

/**
 * @Description:
 * @Author: CHONG
 * @CreateTime: 2021/12/11 19:51
 * @Email: chongzhao66@gmail.com
 */
public class Car implements Moveable {
    @Override
    public void move() {
        System.out.println("Driver a car.....");
    }


    public static void main(String[] args) {

        Car car = new Car();

        Moveable moveable = (Moveable) Proxy.newProxyInstance(Car.class.getClassLoader(), Car.class.getInterfaces(), (proxy, method, args1) -> {
            System.out.println("Engine start.....");
            Object o = method.invoke(car, args1);
            System.out.println("Kill engine......");
            return o;
        });

        moveable.move();

        Stop stop = (Stop)Proxy.newProxyInstance(Stop.class.getClassLoader(),new Class<?>[]{Stop.class},((proxy, method, args1) -> {
           System.out.println("Engine shutdown......");
           if(method.getName().equals("stop")){
               System.out.println("Stopped......");
           }
           return null;
        }));

        stop.stop();
    }

}
