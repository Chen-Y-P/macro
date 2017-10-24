<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>淘淘网上商城-综合网购首选（JD.COM）-正品低价、品质保障、货到付款、配送及时、放心服务、轻松购物！</title>
<meta name="description" content="淘淘JD.COM-专业的综合网上购物商城，在线销售家电、数码通讯、电脑、家居百货、服装服饰、母婴、图书、食品、在线旅游等数万个品牌千万种优质商品。便捷、诚信的服务，为您提供愉悦的网上商城购物体验! ">
<meta name="Keywords" content="网上购物,网上商城,手机,笔记本,电脑,MP3,CD,VCD,DV,相机,数码,配件,手表,存储卡,淘淘商城">
<link href="/css/taotao.css" rel="stylesheet"/>
<script type="text/javascript">
	window.pageConfig={
	compatible:true,
	navId:"home",
	enableArea: true
	};
</script>
<style type="text/css">
#categorys-2013 .mc {
	display: block;
}
#categorys-2013 .mt {
	background: 0
}
</style>
</head>
<body>
<!-- header start -->
<jsp:include page="commons/header.jsp" />
<!-- header end -->
<div class="w">
<div id="o-slide">
<div class="slide" id="slide">
<script type="text/javascript">
;(function(cfg, doc) {
    if ( !cfg.DATA_MSlide ) {
        cfg.DATA_MSlide=[];
    }
	var dataMSlide = ${dataMSlide};
    cfg.DATA_MSlide = dataMSlide;
    // 初始化一个广告信息
    if ( cfg.DATA_MSlide.length > 1 ) {
    	var first = pageConfig.FN_GetCompatibleData( cfg.DATA_MSlide[0] );
        var TPL = ''
            +'<ul class="slide-items">'
            +'<li clstag="homepage|keycount|home2013|09a1">'
            +'<a href="'+ first.href +'" target="_blank" title="'+ first.alt +'">'
            +'<img src="'+ first.src +'" width="'+ first.width +'" height="'+ first.height +'" >'
            +'</a>'
            +'</li>'
            +'</ul><div class="slide-controls"><span class="curr">1</span></div>';
        doc.write(TPL);
    }
})(pageConfig, document);;</script>
</div><!--slide end-->
<div class="jscroll" id="mscroll">
<div class="ctrl" id="mscroll-ctrl-prev"><b></b></div>
<div class="ctrl" id="mscroll-ctrl-next"><b></b></div>
<div class="o-list">
<div class="list" id="mscroll-list"></div>
</div>
</div><!--mscroll end-->
<script type="text/javascript">
	//大广告下的滑动广告
	var dataMScroll=${dataMScroll};
pageConfig.DATA_MScroll = dataMScroll;
(function(object, data) {
    var a = data, b = [], c = [], d, h;
    a.sort(function(a, b) {
        return a.ext - b.ext
    });
    while (a.length > 0) {
        d = a.shift();
        if (d.ext) {
            b.push(d)
        } else {
            c.push(d)
        }
    }
    c.sort(function() {
        return 0.5 - Math.random()
    });
    h = b.length;
    if (h >= 3) {
        for (var i = 0; i < 3; i++) {
            a.push(b.shift())
        }
    } else {
        for (var i = 0; i < h; i++) {
            a.push(b.shift())
        }
    }
    var f = a.length, g = c.length;
    for (var i = 0; i < 18 - f; i++) {
        if (i > g - 1) {
            continue;
        }
        a.push(c.shift())
    }
    var e = [], x;
    e.push("<ul class=\"lh\">");
    for (var i = 0; i < 3; i++) {
        x = pageConfig.FN_GetCompatibleData(a[i]);
        e.push("<li class=\"item\"><a href=\"");
        e.push(x.href);
        e.push("\"><img src=\"/images/blank.gif\" style=\"background:url(");
        e.push(x.src);
        e.push(") no-repeat #fff center 0;\" alt=\"");
        e.push(x.alt);
        e.push("\" width=\"");
        e.push(x.width);
        e.push("\" height=\"");
        e.push(x.height);
        e.push("\" /></a></li>")
    }
    e.push("</ul>");
    document.getElementById(object).innerHTML = e.join("");
    pageConfig.DATA_MScroll = a
})("mscroll-list", pageConfig.DATA_MScroll);
</script>
</div>
<div class="m fr da0x70" clstag="homepage|keycount|home2013|10a">
<script>
// 右上方小广告位
(function() {
	var dataTopRight = ${dataTopRight};
    var ad = pageConfig.FN_GetRandomData(dataTopRight);
    ad = pageConfig.FN_GetCompatibleData(ad);
    document.write("<a href=\"" + ad.href + "\" target=\"_blank\"><img data-img=\"2\" src=\"" + ad.src + "\" width=\"" + ad.width + "\" height=\"" + ad.height + "\" alt=\"" + ad.alt + "\" /></a>");
})();
</script>
</div><!--da end-->
<div id="jdnews" class="m m1" >
<div class="mt">
<h2>淘淘快报</h2>
<div class="extra" clstag="homepage|keycount|home2013|11a"><a href="http://www.jd.com/moreSubject.aspx" target="_blank">更多快报&nbsp;&gt;</a></div>
</div>
<div class="mc">
	<ul>
		<li class="odd" clstag="homepage|keycount|home2013|11b1"><a href="http://club.jr.jd.com/girls/jingxuan" target="_blank" title="38女人节得3800理财金">38女人节得3800理财金</a></li>
				<li clstag="homepage|keycount|home2013|11b1"><a href="http://sale.jd.com/act/U0jwsxIFrmO.html" target="_blank" title="开学季音像299减99">开学季音像299减99</a></li>
				<li class="odd" clstag="homepage|keycount|home2013|11b1"><a href="http://sale.jd.com/act/Kz4QnjJMuL.html" target="_blank" title="情定金生相约钻石婚">情定金生相约钻石婚</a></li>
				<li clstag="homepage|keycount|home2013|11b1"><a href="http://sale.jd.com/act/Z5o4RNyF2Uv.html" target="_blank" title="爆款造型品 扮靓美人计">爆款造型品 扮靓美人计</a></li>
	</ul>
</div>
</div>
<!--新闻结束-->

<div data-widget="tabs" class="m _520_a_lifeandjourney_1" id="virtuals-2014">
<div class="mt">
<ul class="fore1 lh">
<li class="fore1 abtest_huafei" data-iframe="http://chongzhi.jd.com/index-newEntry.htm" clstag = "homepage|keycount|home2013|12a"><a target="_blank" href="http://chongzhi.jd.com/"><s></s>话费<i></i></a></li>
<li class="fore2 abtest_lvxing" data-iframe="http://trip.jd.com/html/newTravel.html" clstag = "homepage|keycount|home2013|12b"><a target="_blank" href="http://trip.jd.com/"><s></s>旅行<i></i></a></li>
<li class="fore3 abtest_caipiao" data-iframe="http://caipiao.jd.com/caipiao-jd.htm"	 clstag = "homepage|keycount|home2013|12c"><a target="_blank" href="http://caipiao.jd.com/"><s></s>彩票<i></i></a></li>
<li class="fore4 abtest_youxi" data-iframe="http://card.jd.com/html/card-jdIndex.html" clstag = "homepage|keycount|home2013|12d"><a target="_blank" href="http://game.jd.com/"><s></s>游戏<i></i></a></li>
</ul>
<ul class="fore2 lh">
<li class="fore5 abtest_jipiao"	clstag = "homepage|keycount|home2013|12e"><a target="_blank" href="http://jipiao.jd.com/"><s></s>机票</a></li>
<li class="fore6 abtest_dianyingpiao" clstag = "homepage|keycount|home2013|12f"><a target="_blank" href="http://movie.jd.com/"><s></s>电影票</a></li>
<li class="fore7 abtest_yanchupiao" clstag = "homepage|keycount|home2013|12g"><a target="_blank" href="http://licai.jd.com/"><s></s>理财</a></li>
<li class="fore8 abtest_shuidianmei" clstag = "homepage|keycount|home2013|12h"><a target="_blank" href="http://jiaofei.jd.com/"><s></s>水电煤</a></li>
</ul>
</div>
<div class="mc">
<a href="#none" class="close">×</a>
<div class="virtuals-iframes hide">
<iframe width="100%" scrolling="no" height="139px" frameborder="0"></iframe>
</div>
<div class="virtuals-iframes hide">
<iframe width="100%" scrolling="no" height="139px" frameborder="0"></iframe>
</div>
<div class="virtuals-iframes hide">
<iframe width="100%" scrolling="no" height="139px" frameborder="0"></iframe>
</div>
<div class="virtuals-iframes hide">
<iframe width="100%" scrolling="no" height="139px" frameborder="0"></iframe>
</div>
</div>
</div>

<!--virtuals end-->
<span class="clr"></span>
</div>
<!-- 幻灯片, 公信力, 淘淘快报, 虚拟产品 end -->

<div id="floors-list">
	<!-- 家电通讯楼层 start-->
    <c:forEach var="floorItem" items="${floorItemList}">
	<div class="w w1" data-fid="0" id="electronics">
		<div class="m m1 catalogue" data-lazyload="1">
			<div class="mt ld">
				<div class="floor"><b class="fixpng b b1"></b><b class="fixpng b b2"></b><b class="b b3">${floorItem.floorId}F</b><b
						class="fixpng b4"></b></div>
				<h2>${floorItem.cateName}</h2>
			</div>
			<div class="mc">
				<div class="style1">
                    <!--左侧分类显示-->
					<ul class="lh" clstag="homepage|keycount|home2013|18a">
                        <c:forEach var="leftCate" items="${floorItem.leftCateList}">
                            <li><a href="${leftCate.url}">${leftCate.name}</a></li>
                        </c:forEach>
					</ul>
					<span clstag="homepage|keycount|home2013|18b">
						<!-- 广告信息 -->
						<a target="_blank" title=""
						   href="http://c.fa.jd.com/adclick?sid=2&cid=601&aid=3624&bid=0
						   &unit=35989&advid=105087&guv=&url=http://sale.jd.com/act/PzKvRu4Ld5YnG1Ej.html">
							<img data-img="2" data-lazyload="/images/543b4d75N686689d7.jpg" width="209" height="155" alt=""/>
						</a>
					</span>
				</div>
			</div>
		</div>
		<!--楼层tab数据显示区-->
		<div class="m plist">
			<div class="tab-arrow"><b></b></div>
            <c:forEach items="${floorItem.tabCateList}" var="tabCate" varStatus="status">
                <div class="sm sm2 fore${status.index+1} ${status.index==0?"curr":""}" data-widget="tab-item" data-tag="${tabCate.tabId}"
                     clstag="homepage|keycount|home2013|18d">
                    <div class="smt">
                        <h3>${tabCate.name}</h3>
                    </div>
                    <div class="smc" data-widget="tab-content">
                        <div class="loading-style1"><b></b>加载中，请稍候...</div>
                    </div>
                </div>
            </c:forEach>
		</div>
		<div class="sm sm1 brands" clstag="homepage|keycount|home2013|19a">
			<div class="smt">
				<h3>品牌旗舰店</h3>
			</div>
			<div class="smc">
                <!--右侧品牌广告显示-->
                <ul class="lh">
                    <c:forEach items="${floorItem.brandAdList}" var="brandAd" varStatus="brandStatus">
                    <li class="fore${brandStatus.index+1}">
                        <a target="_blank" title="${brandAd.title}" href="${brandAd.url}">
                            <img height="35" width="98" alt="" data-img="2" src="${brandAd.imageUrl}">
                            <!--data-lazyload="brand.imageUrl"无法显示-->
                        </a>
                        </li>
                    </c:forEach>
                </ul>
			</div>
		</div>
		<div class="fr da209x180" clstag="homepage|keycount|home2013|19b">
			<div class="slide" data-lazyload="8"></div>
		</div>
		<span class="clr"></span>
	</div>
    </c:forEach>
</div>

<!-- 绑定显示数据到页面 -->
<script type="text/javascript">
    var dataTabs = ${dataTabs};
    pageConfig.DATA_Tabs = dataTabs;
</script>
<script type="text/javascript">
	pageConfig.DATA_FSlide={};
	var dataFSlideF8 = ${dataFSlideF8};
	pageConfig.DATA_FSlide.F8=dataFSlideF8;
</script>

<!-- footer start -->
<jsp:include page="commons/footer.jsp" />
<!-- footer end -->

<script type="text/javascript" src="/js/home.js" charset="utf-8"></script>
</body>
</html>