import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.pojo.TbItemExample.Criteria;


public class TestPageHelper {
	@Test
	public void testpageHelper() {
		//创建一个spring容器
		ApplicationContext applicationContext  = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		//从spring获取mapper代理对象
		TbItemMapper tbItemMapper = applicationContext.getBean(TbItemMapper.class);
		//执行查询并进行分页
		TbItemExample example = new TbItemExample();
		//执行分页
		PageHelper pageHelper = new PageHelper();
		pageHelper.startPage(1, 10);
		List<TbItem> list = tbItemMapper.selectByExample(example);
		for (TbItem tbItem : list) {
			System.out.println(tbItem.getTitle());
		}
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		Long count =  pageInfo.getTotal();
		System.out.println("总共的条数是："+count);
	}
}
