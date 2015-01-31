package org.jasig.cas.web.flow;

import org.jasig.cas.web.support.WebUtils;
import org.springframework.webflow.action.AbstractAction;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

import com.octo.captcha.service.CaptchaServiceException;
import com.octo.captcha.service.image.ImageCaptchaService;

public final class CaptchaValidateAction extends AbstractAction {
	
	private ImageCaptchaService captchaService;
	private String captchaValidationParameter = "j_captcha_response";

	protected Event doExecute(final RequestContext context) {
		String captcha_response = context.getRequestParameters().get(captchaValidationParameter);
		boolean valid = false;

		if (captcha_response != null) {
			String id = WebUtils.getHttpServletRequest(context).getSession().getId();
			if (id != null) {
				try {
					valid = captchaService.validateResponseForID(id, captcha_response).booleanValue();
				} catch (CaptchaServiceException cse) {
				}
			}
		}

		if (valid) {
			return success();
		}
		context.getRequestScope().put("captchaValidatorError", "bad");
		return error();
	}

	public void setCaptchaService(ImageCaptchaService captchaService) {
		this.captchaService = captchaService;
	}

	public void setCaptchaValidationParameter(String captchaValidationParameter) {
		this.captchaValidationParameter = captchaValidationParameter;
	}
}
