
//package name
package com.dispatch.fmi.mor;

//imports
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author: Ishaan Kapoor
 * @version: 1.0
 * @since: 06/15/2022
 * <h1>Dispatch Troubleshooting Software (DTS)</h1>
 * <p>This software automates the work of a dispatch engineer in a lot of ways by following the SOP mentioned in the Dispatch Troubleshooting Matrix</p>
 */


@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
