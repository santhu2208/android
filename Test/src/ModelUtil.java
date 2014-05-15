
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ModelUtil {

	public static void main(String[] args) {
		Mp3VO m = new Mp3VO();
		m.setId("1");
		m.setMp3Name("asd");
		m.setPm3Size("12");
		try {
			Map<String, String> result = ModelUtil.model2Map(m);
			for (Entry<String, String> s : result.entrySet()) {
				System.out.println(s.getKey() + ":" + s.getValue());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Map<String, String> model2Map(Object obj) throws Exception {
		Map<String, String> result = new HashMap<String, String>();
		Class class1 = obj.getClass();
		Field[] fields = class1.getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			result.put(field.getName(), field.get(obj) == null ? null : field.get(obj).toString());

		}

		return result;
	}

}
