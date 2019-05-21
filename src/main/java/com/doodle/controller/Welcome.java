/**
 * 
 */
package com.doodle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author sunil
 *
 */
@Controller
public class Welcome {

	@RequestMapping(value="welcome")
	public String welcome() {
		return "dashboard";
	}
	
}
