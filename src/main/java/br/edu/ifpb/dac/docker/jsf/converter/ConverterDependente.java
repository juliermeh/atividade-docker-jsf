package br.edu.ifpb.dac.docker.jsf.converter;

import br.edu.ifpb.dac.docker.jsf.domain.Dependente;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author JuliermeH
 */
@FacesConverter(value = "converter.dependente")
public class ConverterDependente implements Converter {
    
    @Override
    public Object getAsObject(
        FacesContext context,
        UIComponent component,
        String value) {

        return new Dependente();

    }

    @Override
    public String getAsString(
        FacesContext context,
        UIComponent component,
        Object value) {
        
        Dependente dependente = (Dependente) value;
        return dependente.toString();

    }
    
}
