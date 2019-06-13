package com.example.android.miwokapp;

public class MiwokArray {
        private String mDefaultTranslation;
        private String mMiwok;
        private int ImageResourceID ;
        private int mAudioResourseID ;

         MiwokArray(String mDefaultTranslation , String f , int ImageResourceID , int a){
            this.mDefaultTranslation=mDefaultTranslation;
            this.ImageResourceID = ImageResourceID;
            this.mMiwok=f;
            this.mAudioResourseID = a;
        }

        public String getmDefaultTranslation(){

             return mDefaultTranslation;
        }

        public String getmMiwokTranslation() {

             return mMiwok;
        }
        public int getImageResourceID(){
             return ImageResourceID;
        }
        public int getmAudioResourseID(){
             return mAudioResourseID;
        }

}
