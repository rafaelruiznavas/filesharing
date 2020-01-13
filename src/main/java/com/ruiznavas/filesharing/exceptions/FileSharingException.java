package com.ruiznavas.filesharing.exceptions;

public class FileSharingException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String msg;

	public FileSharingException(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

}
