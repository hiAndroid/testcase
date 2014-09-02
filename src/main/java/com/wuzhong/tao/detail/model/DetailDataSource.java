package com.wuzhong.tao.detail.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuzhong on 14-9-2.
 */
public class DetailDataSource {

    public List<Unit> dataSource = new ArrayList<Unit>();

    public DetailDataSource() {

        //主图
        this.dataSource.add(new Unit("http://gw.alicdn.com/bao/uploaded/i3/TB1RruhGXXXXXbPXXXXXXXXXXXX_!!0-item_pic.jpg_200x200.jpg",0));

        this.dataSource.add(new Unit("商品卖点",1));

        this.dataSource.add(new Unit("测试商品",2));

        this.dataSource.add(new Unit("￥1000",3));

        this.dataSource.add(new Unit("卖家包邮",4));

        this.dataSource.add(new Unit("相关推荐",5));

        this.dataSource.add(new Unit("sku入口",6));

        this.dataSource.add(new Unit("评价入口",7));

        this.dataSource.add(new Unit("图文入口",8));

    }
}
