package com.cestpasdur.editors;

import com.cestpasdur.usertype.OptionUserType;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

public class GlobalBindingInitializer implements WebBindingInitializer {

    public void initBinder(WebDataBinder binder, WebRequest request) {
        binder.registerCustomEditor(OptionUserType.class, new OptionEditorSupport());
    }

}