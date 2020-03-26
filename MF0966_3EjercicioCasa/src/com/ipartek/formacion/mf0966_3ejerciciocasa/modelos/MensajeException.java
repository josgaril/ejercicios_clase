package com.ipartek.formacion.mf0966_3ejerciciocasa.modelos;

public class MensajeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MensajeException() {
	}

	public MensajeException(String message) {
		super(message);
	}

	public MensajeException(Throwable cause) {
		super(cause);
	}

	public MensajeException(String message, Throwable cause) {
		super(message, cause);
	}

	public MensajeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
