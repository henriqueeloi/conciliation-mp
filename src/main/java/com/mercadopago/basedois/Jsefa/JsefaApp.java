package com.mercadopago.basedois.Jsefa;

import com.mercadopago.basedois.SettlementHeaderFileDTO;
import net.sf.jsefa.Serializer;
import net.sf.jsefa.flr.FlrIOFactory;

import java.io.StringWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class JsefaApp {
    public static void main(String[] args) {


        Serializer serializer = FlrIOFactory.createFactory(SettlementHeaderFileDTO.class).createSerializer();
        StringWriter writer = new StringWriter();


        serializer.open(writer);
        // call serializer.write for every object to serialize

        SettlementHeaderFileDTO header = new SettlementHeaderFileDTO();



        Person p = new Person();
        p.setName("Erwin Schmidt");
        p.setBirthDate(Calendar.getInstance().getTime());

        Person p1 = new Person();
        p1.setName("Erwin Schmidt");
        p1.setBirthDate(Calendar.getInstance().getTime());

        List<Person> plist = new ArrayList<>();
        
        plist.add(p);
        plist.add(p1);

        for (Person person:plist) {
            serializer.write(header);
        }

        System.out.println(writer.toString());


        serializer.close(true);
    }
}
