package sys;

import com.alibaba.fastjson.JSON;
import com.zxcv.portal.utils.ConvertUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test
{
	public static void main(String[] args)
	{
		/******************************************* String ******************************************************/
		String key = "userName";
		System.out.println(key);

		String s = ConvertUtil.humpToLine(key);
		System.out.println(s);

		/******************************************* Map ******************************************************/
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id",1);
		map.put("userName", "tom");
		map.put("userPwd", "wsd");
		String strmap = JSON.toJSONString(map); // Map转json

		System.out.println(strmap);

		String smap = ConvertUtil.humpToLineMap(strmap);
		System.out.println(smap);
		
		/******************************************* List<Map> ******************************************************/
		
		List<Map<String, Object>>  list = new ArrayList<Map<String, Object>>();
		list.add(new HashMap<String, Object>(){
			{
				put("id",1);
				put("userName", "tom");
				put("userPwd", "wsd");
			}
		});
		list.add(new HashMap<String, Object>(){
			{
				put("id",2);
				put("userName", "qwe");
				put("userPwd", "asd");
			}
		});
		String strlist = JSON.toJSONString(list); // List转json

		System.out.println(strlist);

		String slist = ConvertUtil.humpToLineList(strlist);
		System.out.println(slist);
	}
}
