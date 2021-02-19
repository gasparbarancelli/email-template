package com.gasparbarancelli.emailtemplate;

import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.template.PebbleTemplate;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class TemplateCompra {

    public static void main(String[] args) throws IOException {
        PebbleEngine engine = new PebbleEngine.Builder().build();
        PebbleTemplate compiledTemplate = engine.getTemplate("templates/oferta.html");

        Map<String, Object> context = new HashMap<>();
        context.put("name", "Gaspar Barancelli");
        context.put("cupom", "1234");
        context.put("desconto", "30");
        context.put("valor", "1.000,00");

        Writer writer = new StringWriter();
        compiledTemplate.evaluate(writer, context);

        String output = writer.toString();
        System.out.println(output);
    }


}
