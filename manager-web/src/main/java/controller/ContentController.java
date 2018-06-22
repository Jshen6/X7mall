package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import common.utils.MallResult;
import content.service.ContentService;
import pojo.TbContent;

/**
 * 内容管理Controller
 */
@Controller
public class ContentController {
	
	@Autowired
	private ContentService contentService;

	@RequestMapping(value="/content/save", method=RequestMethod.POST)
	@ResponseBody
	public MallResult addContent(TbContent content) {
		//调用服务把内容数据保存到数据库
        MallResult mallResult = contentService.addContent(content);
		return mallResult;
	}
}
