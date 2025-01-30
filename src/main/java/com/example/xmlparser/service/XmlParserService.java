package com.example.xmlparser.service;

import com.example.xmlparser.model.Entry;
import com.example.xmlparser.model.Feed;
import org.springframework.stereotype.Service;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;
import java.util.List;

@Service
public class XmlParserService {
    
    public List<Entry> parseXml(InputStream inputStream) throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(Feed.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Feed feed = (Feed) unmarshaller.unmarshal(inputStream);
        return feed.getEntries();
    }
    
    public boolean hasNumber(String text) {
        return text != null && text.matches(".*\\d+.*");
    }
    
    public String extractYoutubeLink(String content) {
        if (content == null) return "";
        // Enhanced regex to match more YouTube URL formats
        String regex = "https?://(?:www\\.)?(?:youtube\\.com/watch\\?v=|youtu\\.be/)[\\w-]+";
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex);
        java.util.regex.Matcher matcher = pattern.matcher(content);
        return matcher.find() ? matcher.group() : "";
    }
} 