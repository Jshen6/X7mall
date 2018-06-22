package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转Controller
 */
@Controller
public class PageController {

	@RequestMapping("/")
	public String showIndex() {
		return "index";
	}

	//这样就不用再一个个写处理index.jsp页面跳转请求的方法了
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page) {
		return page;
	}
}
