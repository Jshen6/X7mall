package content.service;

import java.util.List;

import common.pojo.EasyUITreeNode;
import common.utils.MallResult;

public interface ContentCategoryService {

	List<EasyUITreeNode> getContentCatList(long parentId);
	MallResult addContentCategory(long parentId, String name);
}
