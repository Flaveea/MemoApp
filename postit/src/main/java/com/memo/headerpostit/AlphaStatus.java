package com.memo.headerpostit;

public class AlphaStatus {
    private boolean transparent = false;

    public boolean isTransparent(){
        return transparent;
    }

    public void toggle(){
        transparent = !transparent;
    }

    public void setTransparent(boolean transparent){
        this.transparent = transparent;
    }
}