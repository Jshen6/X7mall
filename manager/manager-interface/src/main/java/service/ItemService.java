package service;

import common.pojo.EasyUIDataGridResult;
import common.utils.MallResult;
import pojo.TbItem;
import pojo.TbItemDesc;

public interface ItemService {

	TbItem getItemById(long itemId);
	EasyUIDataGridResult getItemList(int page, int rows);
	MallResult addItem(TbItem item, String desc);
	TbItemDesc getItemDescById(long itemId);
}
