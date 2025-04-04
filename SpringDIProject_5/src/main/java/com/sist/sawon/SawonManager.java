package com.sist.sawon;

import org.springframework.stereotype.Component;

@Component("sa")
/* <bean id="sa" class="com.sist.sawon.SawonManager"/> */
public class SawonManager {

	public void display()
	{
		System.out.println("SawonManager:display() call...");
	}
}
