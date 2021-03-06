package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import common.utils.MallResult;
import search.service.SearchItemService;

/**
 * 导入商品数据到索引库
 */
@Controller
public class SearchItemController {
	
	@Autowired
	private SearchItemService searchItemService;

	@RequestMapping("/index/item/import")
	@ResponseBody
	public MallResult importItemList() {
        MallResult mallResult = searchItemService.importAllItems();
		return mallResult;
		
	}
}
