package com.mk.shopping.Exception;

public class InputException extends RuntimeException {

	private String errorMsg;
	private String reason;

	public InputException(String errorMsg, String reason) {
		super();
		this.errorMsg = errorMsg;
		this.reason = reason;

	};

	@Override
	public String getMessage() {
		return this.errorMsg;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

}
