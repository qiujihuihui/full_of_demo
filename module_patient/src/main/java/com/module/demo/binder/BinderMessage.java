package com.module.demo.binder;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author Shenhui
 * @version 1.0
 * @since 2021/3/3  9:21
 */
public class BinderMessage implements Parcelable
{
    private int messageId;
    private String message;

    public BinderMessage() {
    }

    protected BinderMessage(Parcel in) {
        messageId = in.readInt();
        message = in.readString();
    }

    public static final Creator<BinderMessage> CREATOR = new Creator<BinderMessage>()
    {
        @Override
        public BinderMessage createFromParcel(Parcel in) {
            return new BinderMessage(in);
        }

        @Override
        public BinderMessage[] newArray(int size) {
            return new BinderMessage[size];
        }
    };

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(messageId);
        dest.writeString(message);
    }

    @Override
    public String toString() {
        return "BinderMessage{" +
                "messageId=" + messageId +
                ", message='" + message + '\'' +
                '}';
    }
}
