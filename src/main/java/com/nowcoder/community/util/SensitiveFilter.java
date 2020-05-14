package com.nowcoder.community.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
public class SensitiveFilter {

    private static final Logger logger = LoggerFactory.getLogger(SensitiveFilter.class);

    //前缀树
    private class TrieNode {

        //关键词结束标志
        private boolean isKeywordEnd = false;

        // 子节点 (key为下级字符，value为下级节点)
        private Map<Character, TrieNode> subNodes = new HashMap<>();


    }
}
