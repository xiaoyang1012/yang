package com.yang.util;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 小仰自定义的相应类型，小仰网站通用
 */
public class YangResult {


	private static final ObjectMapper MAPPER = new ObjectMapper();

	// 状态
	private Integer status;

	// 消息
	private String msg;

	// 相应的数据
	private Object data;

	public static YangResult build(Integer status, String msg, Object data) {
		return new YangResult(status, msg, data);
	}

	public static YangResult ok(Object data) {
		return new YangResult(data);
	}

	public static YangResult ok() {
		return new YangResult(null);
	}

	public YangResult() {

	}

	public static YangResult build(Integer status, String msg) {
		return new YangResult(status, msg, null);
	}

	public YangResult(Integer status, String msg, Object data) {
		this.status = status;
		this.msg = msg;
		this.data = data;
	}

	public YangResult(Object data) {
		this.status = 200;
		this.msg = "OK";
		this.data = data;
	}

	// public Boolean isOK() {
	// return this.status == 200;
	// }

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * 将json转换成pojo
	 * 
	 * @param jsonData
	 *            json
	 * @param clazz
	 *            
	 * @return
	 */
	public static YangResult formatToPojo(String jsonData, Class<?> clazz) {
		try {
			if (clazz == null) {
				return MAPPER.readValue(jsonData, YangResult.class);
			}
			JsonNode jsonNode = MAPPER.readTree(jsonData);
			JsonNode data = jsonNode.get("data");
			Object obj = null;
			if (clazz != null) {
				if (data.isObject()) {
					obj = MAPPER.readValue(data.traverse(), clazz);
				} else if (data.isTextual()) {
					obj = MAPPER.readValue(data.asText(), clazz);
				}
			}
			return build(jsonNode.get("status").intValue(), jsonNode.get("msg")
					.asText(), obj);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 将json装换成YangResult
	 * 
	 * @param json
	 * @return
	 */
	public static YangResult format(String json) {
		try {
			return MAPPER.readValue(json, YangResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Object�Ǽ���ת��
	 * 
	 * @param jsonData
	 *            json���
	 * @param clazz
	 *            �����е�����
	 * @return
	 */
	public static YangResult formatToList(String jsonData, Class<?> clazz) {
		try {
			JsonNode jsonNode = MAPPER.readTree(jsonData);
			JsonNode data = jsonNode.get("data");
			Object obj = null;
			if (data.isArray() && data.size() > 0) {
				obj = MAPPER.readValue(data.traverse(), MAPPER.getTypeFactory()
						.constructCollectionType(List.class, clazz));
			}
			return build(jsonNode.get("status").intValue(), jsonNode.get("msg")
					.asText(), obj);
		} catch (Exception e) {
			return null;
		}
	}

}
