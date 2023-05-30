package com.mydieu.tindin.utils;

import java.util.List;

public class TFIDF {
    public static double getScore(List<String> doc, List<String> docs, String term) {
        return tf(doc, term) * idf(docs, term);

    }

    private static double tf(List<String> doc, String term) {
        double result = 0;
        for (String word : doc) {
            if (term.equalsIgnoreCase(word))
                result++;
        }
        return result / doc.size();
    }

    private static double idf(List<String> docs, String term) {
        double result = 0;
        for (String word : docs) {
            if (term.equalsIgnoreCase(word)) {
                result++;
                break;
            }
        }
        return Math.log(docs.size() / result);
    }
}
