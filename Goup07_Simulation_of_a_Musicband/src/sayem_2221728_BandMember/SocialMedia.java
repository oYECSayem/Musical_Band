package sayem_2221728_BandMember;

import java.io.Serializable;


public class SocialMedia implements Serializable{
    String name, fb, ig, yt, tw;

    public SocialMedia(String name, String fb, String ig, String yt, String tw) {
        this.name = name;
        this.fb = fb;
        this.ig = ig;
        this.yt = yt;
        this.tw = tw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFb() {
        return fb;
    }

    public void setFb(String fb) {
        this.fb = fb;
    }

    public String getIg() {
        return ig;
    }

    public void setIg(String ig) {
        this.ig = ig;
    }

    public String getYt() {
        return yt;
    }

    public void setYt(String yt) {
        this.yt = yt;
    }

    public String getTw() {
        return tw;
    }

    public void setTw(String tw) {
        this.tw = tw;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SocialMedia: ");
        sb.append("\nname=").append(name);
        sb.append("\n fb=").append(fb);
        sb.append("\n ig=").append(ig);
        sb.append("\n yt=").append(yt);
        sb.append("\n tw=").append(tw);
        sb.append("\n");
        return sb.toString();
    }
    
}
