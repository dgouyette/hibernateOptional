package com.cestpasdur.editors;

import fj.data.Option;

import java.beans.PropertyEditorSupport;

public class OptionEditorSupport extends PropertyEditorSupport {


    @Override
    public void setAsText(String text) {
        super.setValue(Option.fromNull(text));
    }


    @Override
    public String getAsText() {
        return super.getAsText();
    }

}
