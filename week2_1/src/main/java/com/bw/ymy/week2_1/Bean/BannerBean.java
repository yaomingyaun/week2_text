package com.bw.ymy.week2_1.Bean;

import java.util.List;

public class BannerBean {

    /**
     * code : 200
     * msg : success
     * newslist : [{"ctime":"2018-12-07","title":"酷乐百科 | 恶魔Z，死刑！VQ引擎，死刑！","description":"CLauto酷乐汽车","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/YCnx3D50VcFWxZMYatRcfAGyHUVTPP7ax8PpygLgynrlibvrgs2vRTEBEsTFTNBMRUyZCGibiax97b0bgFYxrfLRQ/0?wx_fmt=jpeg","url":"https://mp.weixin.qq.com/s?src=11&timestamp=1544227208&ver=1283&signature=pEgQBGFDfTM8aUOVpDX-rT5ePmiC1JRQox-HBkQXaopsoZYSvvRJqtrd8R03PBsVEtRMnZtY1JEoc5mDEvNP82oWLvXw*ovVyuu4u6T83eWIQiR92zMZSQx6UimlJiRU&new=1"},{"ctime":"2018-12-07","title":"中国移动尚冰：5G扑面而来，推动2.6GHz和4.9GHz的5G网络试验(附PPT和演讲稿)","description":"黄海峰的通信生活","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/gL0GByFsp5unvMTwELDlphTya7lib3PODXHezCh0dhAOxUribCj3a5vMgwK5nM9TicliccT4Luiac6g2qjOkrQCZHeA/0?wx_fmt=jpeg","url":"https://mp.weixin.qq.com/s?src=11&timestamp=1544227206&ver=1283&signature=rrP3uzGbjWNY4GJDP6yJI1KxcjzLBhlymSNteb0mQ**Xe9OFni46eX*ECUmycNlQRVR-yIx-cU5CPrwqyzawAa42T0DI7e6rXXJHCU6cW6duszqJet1x9Zslpp3quLB7&new=1"},{"ctime":"2018-12-08","title":"给人生留点余地","description":"掌中生活","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/wUBucvARnlTZ9uia7aMk0qRxUWzUmfZY2ZauTZuEueYrr1ibqW1HCiaICo0THz5y6w7zVpwHSI1aTzianCJgpUQybQ/0?wx_fmt=jpeg","url":"https://mp.weixin.qq.com/s?src=11&timestamp=1544227214&ver=1283&signature=iwx-WAWez*Q-oVXCdu568M0DoeTmy-9bcYQUyjwFXk-wp8xno7euwtBoGJampkHfWLDVAQ*3z2ddp6OzRaUdLXVaFYgMHlMd7glfn-0AeNBB6v4niAF4TDo4A1SR*knm&new=1"},{"ctime":"2018-12-07","title":"750人！河北省公安厅高速交警总队集中招聘来了","description":"河北日报","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/RcBe45KsHnicyPXkZLbjkDR4hbSwKY3BF5pUqdrBTMoVRibnns1KOyBjiaVFmR0ib8nNJSeXGjauFXO7iah0yGuPWtQ/0?wx_fmt=jpeg","url":"https://mp.weixin.qq.com/s?src=11&timestamp=1544227214&ver=1283&signature=CBG-fKV9FyXnLZ9HJsMDPJ*zHLZAA8HH02QatJKzbop-Fj99G1PnsXq2QFfgWuQF*GtPwO41zO*JXUZmQadggOgQylBmp-oGG2JK9oF-zDcko7fgvyI6XP6Vao0p-R1X&new=1"},{"ctime":"2018-12-07","title":"上海移动全家桶好拼！","description":"放毒","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/hicY0rYFoDW5icghdz3Il70yfibPWYSauziarn41VeArfZFrmmJvibgGpg4e6ZacYefJfC2icrABdVkPVZUeKicNFvicRQ/0?wx_fmt=jpeg","url":"https://mp.weixin.qq.com/s?src=11&timestamp=1544227206&ver=1283&signature=64PzCf5NTnlp17QkhGQH0BvI5HJ4m5xRb*v2J7AcWH2*7mYnzmgev2sI07uAMeZSVaVXf33fhv9LEWg-UUdEB*aEdMf2nKz*urPa0gvnzTEfAt8zZY6yZdn64SFXcW*6&new=1"},{"ctime":"2018-12-07","title":"Edge 与 Chromium：我们的愿景","description":"21CTO","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/X1wOHbVRDnzp2t46oJecia8cc2Zicm5l34CXib0icnvicJaoacrQ1cKxeib67iaSoAGgIvpro5ibhmAicMe5Cof4ia27ibLDg/0?wx_fmt=jpeg","url":"https://mp.weixin.qq.com/s?src=11&timestamp=1544227206&ver=1283&signature=-OoeGBUkifWuSkQrL2eEcU42OSSqctdMY-SjKJERxIatX*-H8mrn468k5Me5JhqU3fcg7OIq*3VWgW*Q681-egVo9gXeMA0rHXC*yd7NiFHdPAtO8BZDzhVOe4RQecEI&new=1"}]
     */

    private int code;
    private String msg;
    private List<NewslistBean> newslist;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<NewslistBean> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<NewslistBean> newslist) {
        this.newslist = newslist;
    }

    public static class NewslistBean {
        /**
         * ctime : 2018-12-07
         * title : 酷乐百科 | 恶魔Z，死刑！VQ引擎，死刑！
         * description : CLauto酷乐汽车
         * picUrl : http://mmbiz.qpic.cn/mmbiz_jpg/YCnx3D50VcFWxZMYatRcfAGyHUVTPP7ax8PpygLgynrlibvrgs2vRTEBEsTFTNBMRUyZCGibiax97b0bgFYxrfLRQ/0?wx_fmt=jpeg
         * url : https://mp.weixin.qq.com/s?src=11&timestamp=1544227208&ver=1283&signature=pEgQBGFDfTM8aUOVpDX-rT5ePmiC1JRQox-HBkQXaopsoZYSvvRJqtrd8R03PBsVEtRMnZtY1JEoc5mDEvNP82oWLvXw*ovVyuu4u6T83eWIQiR92zMZSQx6UimlJiRU&new=1
         */

        private String ctime;
        private String title;
        private String description;
        private String picUrl;
        private String url;

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
