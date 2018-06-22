package sso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import common.utils.MallResult;
import pojo.TbUser;
import sso.service.RegisterService;

/**
 * 注册功能Controller
 */
@Controller
public class RegitsterController {
	
	@Autowired
	private RegisterService registerService;

	@RequestMapping("/page/register")
	public String showRegister() {
		return "register";
	}
	
	@RequestMapping("/user/check/{param}/{type}")
	@ResponseBody
	public MallResult checkData(@PathVariable String param, @PathVariable Integer type) {
        MallResult mallResult = registerService.checkData(param, type);
		return mallResult;
	}
	
	@RequestMapping(value="/user/register", method=RequestMethod.POST)
	@ResponseBody
	public MallResult register(TbUser user) {
        MallResult mallResult = registerService.register(user);
		return mallResult;
	}
}
