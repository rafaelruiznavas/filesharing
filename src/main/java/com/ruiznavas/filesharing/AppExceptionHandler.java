package com.ruiznavas.filesharing;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ruiznavas.filesharing.exceptions.FileSharingException;

@ControllerAdvice
public class AppExceptionHandler {
	@ExceptionHandler(FileSharingException.class)
	public ModelAndView handleException(FileSharingException exception, RedirectAttributes redirectAttributes) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", exception.getMsg());
		mav.setViewName("error");
		return mav;
	}
}
