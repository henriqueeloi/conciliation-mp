package com.mercadopago.basedois.Jsefa;

import net.sf.jsefa.flr.annotation.FlrDataType;
import net.sf.jsefa.flr.annotation.FlrField;
import net.sf.jsefa.flr.lowlevel.Align;

import java.util.Date;

@FlrDataType()
public class Person {

    @FlrField(pos = 1, length = 30)
    String name;

    @FlrField(pos = 2, length = 10, format = "dd.MM.yyyy", align = Align.RIGHT)
    Date birthDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}


