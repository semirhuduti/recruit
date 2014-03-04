/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * A Validator responisble for validating the SSN submitted to the app.
 * 
 * @author Semir, Dan, Milos
 */
@FacesValidator("util.validators.SSNValidator")
public class SSNValidator implements Validator{
 
	private static final String PATTERN = "\\b(((20)((0[0-9])|(1[0-1])))|(([1][^0-8])?\\d{2}))((0[1-9])|1[0-2])((0[1-9])|(2[0-9])|(3[01]))[-+]?\\d{4}[,.]?\\b";
 
	private Pattern pattern;
	private Matcher matcher;
 
        /**
         * The constructor.
         */
	public SSNValidator(){
		  pattern = Pattern.compile(PATTERN);
	}
 
        /**
         * Validates the value in the component from which the value then will 
         * be submitted.
         * 
         * @param context       The JSF context.
         * @param component     The UIComponent to validate.
         * @param value         The value of the component.
         * @throws ValidatorException 
         */
	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
 
		matcher = pattern.matcher(value.toString());
		if(!matcher.matches()){
 
			FacesMessage msg = 
				new FacesMessage("SSN validation failed.", 
						"Invalid SSN format.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
 
		}
 
	}
}