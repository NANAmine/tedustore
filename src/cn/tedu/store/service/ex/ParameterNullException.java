package cn.tedu.store.service.ex;

//义务异常，没有传入参数
public class ParameterNullException extends RuntimeException {

	public ParameterNullException() {
	}

	public ParameterNullException(String message) {
		super(message);
	}

	public ParameterNullException(Throwable cause) {
		super(cause);
	}

	public ParameterNullException(String message, Throwable cause) {
		super(message, cause);
	}

	public ParameterNullException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}