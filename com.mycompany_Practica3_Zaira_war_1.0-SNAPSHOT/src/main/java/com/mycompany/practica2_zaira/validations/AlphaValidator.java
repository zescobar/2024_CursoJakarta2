/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica2_zaira.validations;


import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.component.html.HtmlInputText;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.ValidatorException;
import jakarta.inject.Named;
import org.apache.commons.lang3.StringUtils;

@Named
@RequestScoped
public class AlphaValidator {

  public void validateAlpha(FacesContext facesContext, UIComponent uiComponent,
          Object value) throws ValidatorException {
    if (!StringUtils.isAlphaSpace((String) value)) {
      HtmlInputText htmlInputText = (HtmlInputText) uiComponent;
      FacesMessage facesMessage = new FacesMessage(
              htmlInputText.getLabel() + ": only alphabetic characters are allowed.");
      throw new ValidatorException(facesMessage);
    }
  }
}