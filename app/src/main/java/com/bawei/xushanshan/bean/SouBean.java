package com.bawei.xushanshan.bean;

import java.util.List;

/**
 * FileName: SouBean
 * Author: 徐姗姗
 * Date: 2019/11/18 9:14
 */
public class SouBean {

    /**
     * result : [{"id":38,"releaseTime":1539397684000,"source":"汽车AI科技","title":"汽车AI科技日报 | 长安汽车正开发L3级自动驾驶技术，预计2020年量产"},{"id":34,"releaseTime":1539395910000,"source":"砍柴网","title":"到2020年全球1/3的消费者将使用VR"}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * id : 38
         * releaseTime : 1539397684000
         * source : 汽车AI科技
         * title : 汽车AI科技日报 | 长安汽车正开发L3级自动驾驶技术，预计2020年量产
         */

        private int id;
        private long releaseTime;
        private String source;
        private String title;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public long getReleaseTime() {
            return releaseTime;
        }

        public void setReleaseTime(long releaseTime) {
            this.releaseTime = releaseTime;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
