package com.company;

import java.util.regex.Pattern;
import java.io.*;
import java.util.regex.Matcher;

public class Program {
    public static void main(String[] args)
    {
        getLex(fileRead("turboPascal.pas"));
    }

    public static String fileRead(String fileName)
    {
        BufferedReader reader = null;
        String result = "";

        try {
            reader = new BufferedReader( new FileReader(fileName));

            String temp;

            while((temp = reader.readLine()) != null)
            {
                result = result + '\n' + temp;
            }

            result = result.toLowerCase();
            result = result.replaceAll("  ", " ");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static void getLex(String text)
    {
        ColorText color = new ColorText();
        RegexPatterns regPtrn = new RegexPatterns();
        

        text = writeLex(text, regPtrn.Directive, "Директива препроцесора", color.ANSI_YELLOW);
        text = writeLex(text, regPtrn.Comment, "Коментар", color.ANSI_RESET);
        text = writeLex(text, regPtrn.CharConst, "Символьна константа", color.ANSI_CYAN);
        text = writeLex(text, regPtrn.StringConst, "Рядкова константа", color.ANSI_GREEN);
        text = writeLex(text, regPtrn.Keyword, "Зарезервовані слова", color.ANSI_YELLOW);
        text = writeLex(text, regPtrn.Operator, "Оператор", color.ANSI_WHITE);
        text = writeLex(text, regPtrn.Delimiter, "Розділові знаки", color.ANSI_CYAN);
        text = writeLex(text, regPtrn.Number, "Числа", color.ANSI_BLUE);
        text = writeLex(text, regPtrn.Ident, "Ідентифікатори", color.ANSI_CYAN);

        text = text.replaceAll(" |\\n|\\t", "");
        text = writeLex(text, "(?:.*[^$])", "Errors", color.ANSI_RED);
    }

    public static String writeLex(String text, String regexp, String lexClass, String color)
    {
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(text);
        while(matcher.find())
        {
            System.out.println(color + "<" +lexClass + "> | <" + matcher.group().trim() + ">");
        }

        text = text.replaceAll(regexp, " ");
        text = text.replaceAll("  ", " ");

        return text;
    }
}
