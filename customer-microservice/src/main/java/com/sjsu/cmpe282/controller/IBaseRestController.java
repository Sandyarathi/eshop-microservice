/**
 * 
 */
package com.sjsu.cmpe282.controller;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sandyarathidas
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@RestController
@RequestMapping("/customer")
public @interface IBaseRestController {
	/*This will serve as the base 
	 * controller that defines the base url for the rest controllers
	 */

}
