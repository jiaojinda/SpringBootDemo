package com.jiao;

import com.jiao.vo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SpringBootDemoApplication {

	@Value(value = "${author}")
	private String author;

	@Autowired
	private Book book;

	public static void main(String[] args) {

		//修改Banner的模式为OFF
//		SpringApplicationBuilder builder = new SpringApplicationBuilder(Application.class);
//		builder.bannerMode(Banner.Mode.OFF).run(args);

		SpringApplication.run(SpringBootDemoApplication.class, args);


	}

	@RequestMapping(value = "/",produces = "text/plain;charset=UTF-8")
	String index(){
		return "Hello Spring Boot! author is:"+author;
	}

	@RequestMapping("/book")
	public String book() {
		return "Hello Spring Boot! The BookName is "+book.getName()+";and Book Author is "+book.getAuthor()+";and Book price is "+book.getPrice();
	}
}
