package demoPack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author youchao.wen
 * @date 2019/9/18.
 */
public class ListVerify
{
	public static void main(String[] args)
	{
		List<Object> list1 = new ArrayList<>();
		list1.add(null);
		System.out.println("isEmpty -> " + list1.isEmpty());
		System.out.println("size -> " + list1.size());
		list1.removeAll(Collections.singleton(null));
		System.out.println("after remove null, isEmpty -> " + list1.isEmpty());
		System.out.println("after remove null, size -> " + list1.size());
	}
}
