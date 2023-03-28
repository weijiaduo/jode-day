package com.wjd.algorithm.strings.search.impl;

import com.wjd.algorithm.strings.search.Search;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KMPPmtSearchTest {

    @Test
    void search() {
        String[][] inputs = {
                {"abracadabra", "abacadabrabracabracadabrabrabracad"},
                {"rab", "abacadabrabracabracadabrabrabracad"},
                {"bcara", "abacadabrabracabracadabrabrabracad"},
                {"rabrabracad", "abacadabrabracabracadabrabrabracad"},
                {"abacad", "abacadabrabracabracadabrabrabracad"},
                {"ABABAC", "BCBAABACAABABACAA"},
                {"aabaaaba", "ccaabaabaabaaabaab"},
                {"aabaaabb", "ccaabaabaabaaabaab"},
        };
        Integer[] expects = {
                14,
                8,
                -1,
                23,
                0,
                9,
                8,
                -1
        };
        Search kmp = new KMPPmtSearch();
        for (int i = 0; i < inputs.length; i++) {
            assertEquals(expects[i], kmp.search(inputs[i][0], inputs[i][1]));
        }
    }
}