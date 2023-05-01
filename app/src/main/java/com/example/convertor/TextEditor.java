package com.example.convertor;

public class TextEditor {
    public static boolean on_edit = false;
    public static String edit(String str) {
        on_edit = true;
        str = str.replaceFirst(",", "."); //Заменяет запятую на точку, потому что с запятой код не работает
        str = str.replaceFirst("^0*", ""); //Убирает нули в начале, но можно сделать это чуть проще, потому что много нулей всё равно не получится сделать,
        // так как этот код выполняется после каждого символа
        if (str.length() == 0) {
            str = "0";
        }
        if (str.substring(0, 1).contains(".")) {
            str = str.replaceFirst(".", "0."); //Ставит 0 в начале, если после него идет точка (иначе выходили числа типа .1 вместо 0.1)
        }
        if (str.substring(1).contains("-")) {
            if (!str.substring(0, 1).contains("-")) {
                str = str.replaceAll("-", "");
                str = ("-" + str);
            } else {
                str = str.replaceAll("-", ""); //если ты ставишь минус, этот минус убирается и добавляется в начале строки (или убирается, если он уже был)
            }
        }
        return str; //Возвращает готовую строку
    }
}
