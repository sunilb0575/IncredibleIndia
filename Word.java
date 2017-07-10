package com.incredibleindia.android.incredibleindia;



public class Word {
    private String mLangWord;
    private String mWordDescription;
    private int mImageResourceId = NO_IMAGE_PROVIDER;
    private int mAudioResourceID;


    private static final int NO_IMAGE_PROVIDER = -1;


    //constructor with word description and image
    public Word(String wordDescription, int imageResourceId){
        mWordDescription = wordDescription;
        mImageResourceId = imageResourceId;
    }

    //second construcotr word description, image, audio
    public Word(String wordDescription, int imageResourceId, int audioResourceID){
        mWordDescription = wordDescription;
        mImageResourceId = imageResourceId;
        mAudioResourceID = audioResourceID;
    }


    //third constructor with langWord, word description, image, audio
    public Word(String langWord, String wordDescription, int audioResourceID){
        mLangWord = langWord;
        mWordDescription = wordDescription;
        mAudioResourceID = audioResourceID;
    }



    //third constructor with langWord, word description, image, audio
    public Word(String langWord, String wordDescription, int imageResourseId, int audioResourceID){
        mLangWord = langWord;
        mWordDescription = wordDescription;
        mImageResourceId = imageResourseId;
        mAudioResourceID = audioResourceID;
    }

   //return lang word
    public String getmLangWord(){
        return mLangWord;
    }

    //return word Description

    public String getmWordDescription(){
        return mWordDescription;
    }

    //return Image resource id
    public int getmImageResourceId(){
        return mImageResourceId;
    }

    //return audio resource ID
    public int getmAudioResourceID(){
        return mAudioResourceID;
    }


    //return whether an object has an image
    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDER;
    }


    @Override
    public String toString() {
        return "Word{" +
                "mLangWord='" + mLangWord + '\'' +
                ", mWordDescription='" + mWordDescription + '\'' +
                ", mImageResourceId=" + mImageResourceId +
                ", mAudioResourceID=" + mAudioResourceID +
                '}';
    }

}
