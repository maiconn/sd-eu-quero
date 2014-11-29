package br.org.furb.controller.dao.util;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.Map;

/**
 * 
 * @author Maicon
 */
public abstract class MongoDBObject implements Serializable {
	private static final long serialVersionUID = 1L;

	public BasicDBObject getBasicDBObject() throws Exception {
		BasicDBObject obj = new BasicDBObject();

		Field[] field = getClass().getDeclaredFields();
		for (Field f : field) {
			if (f.getType().isEnum()) {
				String name = f.getName();
				f.setAccessible(true);
				Enum<?> enumerador = (Enum<?>) f.get(this);
				if (enumerador != null)
					obj.put(name, enumerador.ordinal());
				else
					obj.put(name, null);
			}
			if (f.getType().isPrimitive() || f.getType().equals(String.class)
					|| f.getType().equals(Double.class)
					|| f.getType().equals(Float.class)
					|| f.getType().equals(Short.class)
					|| f.getType().equals(Integer.class)
					|| f.getType().equals(Date.class)) {
				String name = f.getName();
				f.setAccessible(true);
				obj.put(name, f.get(this));
			}
		}

		return obj;
	}

	public void convertDBObjectToObject(DBObject object) throws Exception {
		Map<?, ?> objMap = object.toMap();
		for (Object nameField : objMap.keySet()) {
			if (nameField.toString().equals("_id")) {
				continue;
			}
			Field f = getClass().getDeclaredField(nameField.toString());
			if (f.getType().isEnum()) {
				f.setAccessible(true);
				if (objMap.get(nameField) != null) {
					Object itemInstance = f.getType().getEnumConstants()[(Integer) objMap
							.get(nameField)];
					f.set(this, itemInstance);
				}
			} else {
				f.setAccessible(true);
				f.set(this, objMap.get(nameField));
			}
		}
	}
}
