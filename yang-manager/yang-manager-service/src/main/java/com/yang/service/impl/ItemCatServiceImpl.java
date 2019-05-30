package com.yang.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yang.dao.TbItemCatMapper;
import com.yang.pojo.TbItemCat;
import com.yang.service.ItemCatService;
import com.yang.util.EasyUITreeNode;
import com.yang.util.YangResult;
@Service
public class ItemCatServiceImpl implements ItemCatService {
	
	Logger logger = Logger.getLogger(ItemCatServiceImpl. class );
	
	@Autowired
	private TbItemCatMapper itemcatmapper;

	@Override
	public List<EasyUITreeNode> getItemCatList(long parentId) {
	
		List<TbItemCat> list=itemcatmapper.selectByParentId(parentId);
		logger.info("getItemCatList---size:"+list.size());

		List<EasyUITreeNode> result=new ArrayList<EasyUITreeNode>();
		for(TbItemCat itemcat:list){
			EasyUITreeNode node=new EasyUITreeNode();
			node.setId(itemcat.getId());
			
			node.setState(itemcat.getIsParent()?"closed":"open");
			node.setText(itemcat.getName());
			result.add(node);
			
			
		}
		return result;
	}

	@Override
	public YangResult insertCat(Long parentId, String name) {
		// create a pojo 
		TbItemCat itemCat=new TbItemCat();
		//add undefined ...
		itemCat.setIsParent(false);
		itemCat.setName(name);
		//1:正常  2：删除
		itemCat.setStatus(1);
		itemCat.setParentId(parentId);
		itemCat.setCreated(new Date());
		itemCat.setUpdated(new Date());
		//insert data
		itemcatmapper.insert(itemCat);
		logger.info("insert cat");
		//区返回的主键
		Long id=itemCat.getId();
		//判断父节点是否是叶子节点，如果是，设置为非叶子节点
		TbItemCat parentNode=itemcatmapper.selectByPrimaryKey(parentId);
		if(parentNode.getIsParent()==false){
			parentNode.setIsParent(true);
			//更新父节点
			itemcatmapper.updateByPrimaryKey(parentNode);
		}
		
		return YangResult.ok(id);
	}

	@Override
	public YangResult updateCat(Long id, String name) {
		// create a pojo 
		TbItemCat itemCat=itemcatmapper.selectByPrimaryKey(id);
		//add undefined ...
		itemCat.setName(name);
		itemCat.setUpdated(new Date());
		//insert data
		itemcatmapper.updateByPrimaryKey(itemCat);
		logger.info("updateByPrimaryKey cat");
		return YangResult.ok();
	}

	/**
	 * 删除文章分类分组的方法
	 */
	@Override
	public void deleteCat(Long id) {
		// 删除的时候必须要判断一下，是否是叶子节点，如果不是的话要连带删除下面的叶子节点
		//另外，在删除以后，要判断删除对象是否有父节点，如果有，那么在删除以后
		//该父节点受否还有其他的子节点，如果没有了，就要将父节点的isParent属性改为false
		TbItemCat itemCat=itemcatmapper.selectByPrimaryKey(id);
		//判断该对象的parentId是否为0，如果是0的话，就代表没有父节点
		long parentId=itemCat.getParentId();
		if(parentId!=0){
			//有父节点，判断父节点是否只有唯一的子节点，如果是的话，将父节点的isParent属性该为false
			List<TbItemCat> list=itemcatmapper.selectByParentId(parentId);
			if(list.size()==1){
				//获取父节点对象
				TbItemCat parent_itemCat=itemcatmapper.selectByPrimaryKey(parentId);
				parent_itemCat.setIsParent(false);
				//更新记录
				itemcatmapper.updateByPrimaryKey(parent_itemCat);
			}
		}
		//判断是否有子节点，以及子节点是否还有子节点，因为这些都要删除
		//需要使用到递归方法
		haveChildren(id);
	}
	//查询是否有子节点的递归方法
	public void haveChildren(Long id){
		//根据id查询记录
		TbItemCat item=itemcatmapper.selectByPrimaryKey(id);
		//isParent属性
		if(item.getIsParent()==false){
			//没有子节点，删除
			itemcatmapper.deleteByPrimaryKey(id);
		}else{
			//有子节点，先删除当前节点，然后得到子节点记录
			itemcatmapper.deleteByPrimaryKey(id);
			List<TbItemCat> list=itemcatmapper.selectByParentId(id);
			for(TbItemCat cat:list){
				haveChildren(cat.getId());
			}
		}
	}

}
