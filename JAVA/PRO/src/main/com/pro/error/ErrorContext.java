package main.com.pro.error;

public class ErrorContext {
	
	
	String message;
	
	Throwable t;
	
	private ErrorContext(String message,Throwable t) {
		this.message = message;
		this.t = t;
	}
	
	private static ErrorContext newInstance(String message,Throwable t){
		return new ErrorContext(message,t);
	}
	
	public String ErrorToStr(){
		return "";
	}
	
	

}
