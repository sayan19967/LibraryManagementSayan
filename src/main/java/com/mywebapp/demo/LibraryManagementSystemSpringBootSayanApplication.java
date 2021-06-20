package com.mywebapp.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mywebapp.demo.model.BorrowBook;

@Controller
@SpringBootApplication
public class LibraryManagementSystemSpringBootSayanApplication {
	
	@GetMapping(path="/")
	public ModelAndView homeAPIGuide() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home.jsp");
		return mv;
	}

	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementSystemSpringBootSayanApplication.class, args);
		
		String s = "27/05/2022";
        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
        Date date1 = null;
		try {
			date1 = sd.parse(s);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
	 BorrowBook bb3 = new BorrowBook(1,2,date1,50.0,4);

	 try {
		 byte[] iJson4 = toJson(bb3);
		 System.out.println(Arrays.toString(iJson4));
	 	} catch (Exception e) {
	 		// TODO Auto-generated catch block
	 		e.printStackTrace();
		}
	 	
	}
	
	private static byte[] toJson(Object r) throws Exception {
        ObjectMapper map = new ObjectMapper();
        return map.writeValueAsString(r).getBytes();
        }

}
