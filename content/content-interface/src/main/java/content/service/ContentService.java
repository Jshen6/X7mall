package content.service;

import java.util.List;

import common.utils.MallResult;
import pojo.TbContent;

public interface ContentService {

	MallResult addContent(TbContent content);
	List<TbContent> getContentListByCid(long cid);
}
