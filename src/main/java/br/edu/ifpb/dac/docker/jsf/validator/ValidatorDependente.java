/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.docker.jsf.validator;

import br.edu.ifpb.dac.docker.jsf.domain.Dependente;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author JuliermeH
 */
public class ValidatorDependente implements Validator {

    @Override
    public void validate(
            FacesContext context,
            UIComponent component,
            Object value) throws ValidatorException {
        Dependente dependente = (Dependente) value;

        if (dependente.dataInvalida() && dependente.nomeInvalido()) {
            FacesMessage facesMessage = new FacesMessage("nome inválido");
        }
    }
    
}
