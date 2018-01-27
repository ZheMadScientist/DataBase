package wrapper.model.storage.content;

import wrapper.model.enums.ContentType;

import java.net.URL;

public class ContentURL extends Content {

    public URL url;

    public ContentURL(ContentType contentType) {
        super(contentType);
    }
}
