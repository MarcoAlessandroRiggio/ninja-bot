package org.pubcoding.ninjacli.util;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

@Component
public class WordUtils {

    public Collection<String> truncateIntoList(final String content) {
        var phrase = extractLine(content);
        var text = content.replace(phrase, "");
        var result = new ArrayList<String>();
        result.add(phrase.trim());
        if(!text.isBlank()) {
            result.addAll(truncateIntoList(text));
        }
        return result;
    }

    public String extractLine(final String content) {return extractLine(content, 80);}
    public String extractLine(final String content, final int lastIndex) {
        if (content.length() < lastIndex) return content;

        var result = content.substring(0, lastIndex);
        if (content.charAt(lastIndex) != ' ') {
            result = result.substring(0, result.lastIndexOf(" "));
        }
        return result;
    }

}
