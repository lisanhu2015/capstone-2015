package org.lsh.utils;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by lsh on 15/3/4.
 */
public class MessageQueue extends  HashMap<Object, ArrayList<Message>> {

    private int count = 0;

    public void add(Object key, String message, Object target) {
        add(key, null, message, target);
    }

    public void add(Object key, String errorCode, String message, Object target) {
        Message msg = new Message(target, errorCode, message);
        ArrayList<Message> list = this.get(key);
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(msg);
        this.put(key, list);
        count++;
    }

    private ArrayList<Message> getErrorsByKey(Object key) {
        ArrayList<Message> errors = this.remove(key);
        if (errors != null) {
            count -= errors.size();
        }
        return errors == null ? new ArrayList<>() : errors;
    }

    public boolean hasErrors() {
        return count == 0;
    }

    public static void add(MessageQueue queue, String key, String message) {
        if (queue != null) {
            queue.add(key, message, null);
        }
    }

    @Override
    public ArrayList<Message> get(Object key) {
        return getErrorsByKey(key);
    }
}
