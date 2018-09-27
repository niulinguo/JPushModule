package com.niles.jpush;

/**
 * Created by Niles
 * Date 2018/9/26 17:49
 * Email niulinguo@163.com
 */
public class NotificationReceivedModel {

    private final String mTitle;
    private final String mContent;
    private final String mExtras;
    private final int mNotificationID;
    private final String mFileHtml;
    private final String[] mFileNames;
    private final String mMsgID;
    private final String mBigText;
    private final String mBigPicPath;
    private final String mInboxJson;
    private final String mPrio;
    private final String mCate;

    private NotificationReceivedModel(String title, String content, String extras, int notificationID, String fileHtml, String[] fileNames, String msgID, String bigText, String bigPicPath, String inboxJson, String prio, String cate) {
        mTitle = title;
        mContent = content;
        mExtras = extras;
        mNotificationID = notificationID;
        mFileHtml = fileHtml;
        mFileNames = fileNames;
        mMsgID = msgID;
        mBigText = bigText;
        mBigPicPath = bigPicPath;
        mInboxJson = inboxJson;
        mPrio = prio;
        mCate = cate;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getTitle() {
        return mTitle;
    }

    public String getContent() {
        return mContent;
    }

    public String getExtras() {
        return mExtras;
    }

    public int getNotificationID() {
        return mNotificationID;
    }

    public String getFileHtml() {
        return mFileHtml;
    }

    public String[] getFileNames() {
        return mFileNames;
    }

    public String getMsgID() {
        return mMsgID;
    }

    public String getBigText() {
        return mBigText;
    }

    public String getBigPicPath() {
        return mBigPicPath;
    }

    public String getInboxJson() {
        return mInboxJson;
    }

    public String getPrio() {
        return mPrio;
    }

    public String getCate() {
        return mCate;
    }

    public static final class Builder {
        private String mTitle;
        private String mContent;
        private String mExtras;
        private int mNotificationID;
        private String mFileHtml;
        private String[] mFileNames;
        private String mMsgID;
        private String mBigText;
        private String mBigPicPath;
        private String mInboxJson;
        private String mPrio;
        private String mCate;

        public String getTitle() {
            return mTitle;
        }

        public Builder setTitle(String title) {
            mTitle = title;
            return this;
        }

        public String getContent() {
            return mContent;
        }

        public Builder setContent(String content) {
            mContent = content;
            return this;
        }

        public String getExtras() {
            return mExtras;
        }

        public Builder setExtras(String extras) {
            mExtras = extras;
            return this;
        }

        public int getNotificationID() {
            return mNotificationID;
        }

        public Builder setNotificationID(int notificationID) {
            mNotificationID = notificationID;
            return this;
        }

        public String getFileHtml() {
            return mFileHtml;
        }

        public Builder setFileHtml(String fileHtml) {
            mFileHtml = fileHtml;
            return this;
        }

        public String[] getFileNames() {
            return mFileNames;
        }

        public Builder setFileNames(String[] fileNames) {
            mFileNames = fileNames;
            return this;
        }

        public String getMsgID() {
            return mMsgID;
        }

        public Builder setMsgID(String msgID) {
            mMsgID = msgID;
            return this;
        }

        public String getBigText() {
            return mBigText;
        }

        public Builder setBigText(String bigText) {
            mBigText = bigText;
            return this;
        }

        public String getBigPicPath() {
            return mBigPicPath;
        }

        public Builder setBigPicPath(String bigPicPath) {
            mBigPicPath = bigPicPath;
            return this;
        }

        public String getInboxJson() {
            return mInboxJson;
        }

        public Builder setInboxJson(String inboxJson) {
            mInboxJson = inboxJson;
            return this;
        }

        public String getPrio() {
            return mPrio;
        }

        public Builder setPrio(String prio) {
            mPrio = prio;
            return this;
        }

        public String getCate() {
            return mCate;
        }

        public Builder setCate(String cate) {
            mCate = cate;
            return this;
        }

        public NotificationReceivedModel build() {
            return new NotificationReceivedModel(
                    mTitle,
                    mContent,
                    mExtras,
                    mNotificationID,
                    mFileHtml,
                    mFileNames,
                    mMsgID,
                    mBigText,
                    mBigPicPath,
                    mInboxJson,
                    mPrio,
                    mCate
            );
        }
    }
}
