package cn.tedu.store.bean;

import java.io.Serializable;

/**
 * 响应结果，一般经常用于ajax异步请求到服务器，服务器响应时，用该类型封装结果
 *
 */
public class ResponseResult<T> implements Serializable {

	private Integer state;
	private String message;
	private T data;

	public ResponseResult() {
	}

	public ResponseResult(Integer state, String message, T data) {
		super();
		this.state = state;
		this.message = message;
		this.data = data;
	}

	public ResponseResult(Integer state, String message) {
		super();
		this.state = state;
		this.message = message;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ResponseResult [state=" + state + ", message=" + message + ", data=" + data + "]";
	}

}
