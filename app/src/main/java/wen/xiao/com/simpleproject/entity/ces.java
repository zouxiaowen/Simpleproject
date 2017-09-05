package wen.xiao.com.simpleproject.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrator on 2017/5/26.
 */
@Entity(generateConstructors = false)
public class ces {
    @Id
    long id;
    String test;
    String image_url;
    public ces() {
    }
    public ces(long id,String test,String image_url) {
        this.id=id;
        this.test=test;
        this.image_url=image_url;
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getTest() {
        return this.test;
    }
    public void setTest(String test) {
        this.test = test;
    }
    public String getImage_url() {
        return this.image_url;
    }
    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
    
    
}
