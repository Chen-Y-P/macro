package com.taotao.portal.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.taotao.portal.pojo.FloorItem;
import com.taotao.portal.pojo.QuickReportItem;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.HttpClientUtil;
import com.taotao.pojo.TbContent;
import com.taotao.portal.service.ContentService;
import org.springframework.util.FileCopyUtils;

@Service
public class ContentServiceImpl implements ContentService {
	
	@Value("${SERVICE_BASE_URL}")
	private String SERVICE_BASE_URL ;
	@Value("${INDEX_AD1_URL}")
	private String INDEX_AD1_URL ;

	@Override
	public List<TbContent> getContentList(long categoryId) {
		//调用服务层的服务
		String resStr = HttpClientUtil.doGet(SERVICE_BASE_URL + INDEX_AD1_URL + categoryId);
		//把字符串转换成java对象
		TaotaoResult result = TaotaoResult.formatToList(resStr, TbContent.class);
		if (result.getStatus() == 200) {
			List<TbContent> listContent = (List<TbContent>) result.getData();
			return listContent;
		}
		return null;
	}

	//根据classPath下的文件路径获取json信息
	@Override
	public String getJsonContent(String filePath) {
		Resource resource = new ClassPathResource(filePath);
		EncodedResource encodedResource = new EncodedResource(resource,"UTF-8");
		String content = null;
		try {
			content = FileCopyUtils.copyToString(encodedResource.getReader());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content;
	}

	@Override
	public List<FloorItem> getFloorItemList() {
		List<FloorItem> floorItemList = new ArrayList<>();
		for(int i=1;i<=5;i++){
			FloorItem floorItem = new FloorItem();
			floorItem.setFloorId(i);
			floorItem.setCateName("家电通讯"+i);
			List<FloorItem.LeftCate> leftCateList = getLeftCateList();
			floorItem.setLeftCateList(leftCateList);
			List<FloorItem.TabCate> tabCateList = getTabCateList();
			floorItem.setTabCateList(tabCateList);
			List<FloorItem.BrandAd> brandAdList = getBrandAdList();
			floorItem.setBrandAdList(brandAdList);
			floorItemList.add(floorItem);
		}
		return floorItemList;
	}

	@Override
	public List<QuickReportItem> getQuickReportItemList() {
		List<QuickReportItem> quickReportList = new ArrayList<>();
		quickReportList.add(new QuickReportItem("38女人节得3800理财金","http://club.jr.jd.com/girls/jingxuan"));
		quickReportList.add(new QuickReportItem("开学季音像299减99","http://sale.jd.com/act/U0jwsxIFrmO.html"));
		quickReportList.add(new QuickReportItem("情定金生相约钻石婚","http://sale.jd.com/act/Kz4QnjJMuL.html"));
		quickReportList.add(new QuickReportItem("爆款造型品 扮靓美人计","http://sale.jd.com/act/Z5o4RNyF2Uv.html"));
		return quickReportList;
	}

	private List<FloorItem.BrandAd> getBrandAdList() {
		List<FloorItem.BrandAd> brandAdList = new ArrayList<>();
		brandAdList.add(new FloorItem.BrandAd("",
				"http://c.fa.jd.com/adclick?sid=2&cid=601&aid=3627&bid=0&unit=36279&advid=50662&guv=&url=http://jmall.jd.com/p150919.html",
				"http://img10.360buyimg.com/da/g10/M00/0E/0D/rBEQWVFQLqgIAAAAAAAFbgvhBqMAAC0MAP_3cIAAAWG414.gif"));
		brandAdList.add(new FloorItem.BrandAd("TCL",
				"http://c.fa.jd.com/adclick?sid=2&cid=601&aid=3627&bid=0&unit=36462&advid=50921&guv=&url=http://jmall.jd.com/shop/tcl/index.html",
				"http://img14.360buyimg.com/da/jfs/t31/292/4886889003/2722/effa53e/537b3138N3205302e.jpg"));
		brandAdList.add(new FloorItem.BrandAd("",
				"http://c.fa.jd.com/adclick?sid=2&cid=601&aid=3627&bid=0&unit=36275&advid=50658&guv=&url=http://jmall.jd.com/p110650.html",
				"http://img10.360buyimg.com/da/jfs/t166/298/186961078/4892/5c38ed68/53829f6eNa98427dc.jpg"));
		brandAdList.add(new FloorItem.BrandAd("手机新品馆",
				"http://c.fa.jd.com/adclick?sid=2&cid=601&aid=3627&bid=0&unit=36464&advid=50923&guv=&url=http://sale.jd.com/act/w78AxhytLrVelbs.html",
				"http://img10.360buyimg.com/da/g13/M06/01/0D/rBEhUlHmCN0IAAAAAAASpGQ8IDYAABK2AP_yHEAABK8207.jpg"));
		brandAdList.add(new FloorItem.BrandAd("",
				"http://c.fa.jd.com/adclick?sid=2&cid=601&aid=3627&bid=0&unit=36274&advid=50657&guv=&url=http://jmall.jd.com/p117514.html",
				"http://img13.360buyimg.com/da/jfs/t127/70/4777056813/2910/3f9a0b8f/537b316bN35574fff.jpg"));
		brandAdList.add(new FloorItem.BrandAd("",
				"http://c.fa.jd.com/adclick?sid=2&cid=601&aid=3627&bid=0&unit=36276&advid=50659&guv=&url=http://jmall.jd.com/p151132.html",
				"http://img12.360buyimg.com/da/jfs/t31/321/4838856059/2979/140e8a02/537b3173Ne74bf3cf.jpg"));
		brandAdList.add(new FloorItem.BrandAd("九阳",
				"http://c.fa.jd.com/adclick?sid=2&cid=601&aid=3627&bid=0&unit=36277&advid=50660&guv=&url=http://jmall.jd.com/p150747.html",
				"http://img14.360buyimg.com/da/jfs/t148/165/47500775/3882/678642c9/537b314aN909ae4cf.jpg"));
		brandAdList.add(new FloorItem.BrandAd("",
				"http://c.fa.jd.com/adclick?sid=2&cid=601&aid=3627&bid=0&unit=36461&advid=50920&guv=&url=http://jmall.jd.com/shop/lg/index.html",
				"http://img11.360buyimg.com/da/jfs/t16/30/4820028970/2355/12a12118/537b3130N7591211b.jpg"));
		brandAdList.add(new FloorItem.BrandAd("康佳",
				"http://c.fa.jd.com/adclick?sid=2&cid=601&aid=3627&bid=0&unit=36278&advid=50661&guv=&url=http://jmall.jd.com/p58164.html?erpad_source=erpad",
				"http://img10.360buyimg.com/da/jfs/t181/331/49355616/2960/f8717425/537b3152Nf0573a0d.jpg"));
		brandAdList.add(new FloorItem.BrandAd("努比亚专卖店",
				"http://c.fa.jd.com/adclick?sid=2&cid=601&aid=3627&bid=0&unit=36463&advid=50922&guv=&url=http://jmall.jd.com/shop/nubia/index.html?erpad_source=erpad",
				"http://img10.360buyimg.com/da/g16/M00/0A/18/rBEbRlN5zCsIAAAAAAALfFfJRv8AACGGgO__3sAAAuU660.jpg"));
		return brandAdList;
	}

	private List<FloorItem.TabCate> getTabCateList() {
		List<FloorItem.TabCate> tabCateList = new ArrayList<>();
		tabCateList.add(new FloorItem.TabCate("大家电",1622));
		tabCateList.add(new FloorItem.TabCate("小家电",1623));
		tabCateList.add(new FloorItem.TabCate("手机通讯",1624));
		tabCateList.add(new FloorItem.TabCate("汽车五金",1625));
		tabCateList.add(new FloorItem.TabCate("智能设备",1618));
		return tabCateList;
	}

	private List<FloorItem.LeftCate> getLeftCateList() {
		List<FloorItem.LeftCate> leftCateList = new ArrayList<>();
		leftCateList.add(new FloorItem.LeftCate("手机","http://www.360buy.com/products/652-653-000.html"));
		leftCateList.add(new FloorItem.LeftCate("空调","http://www.jd.com/products/737-794-870-0-0-0-0-0-0-0-1-1-1-1-33.html"));
		leftCateList.add(new FloorItem.LeftCate("手机配件","http://www.360buy.com/products/652-830-000.html"));
		leftCateList.add(new FloorItem.LeftCate("平板电脑","http://www.jd.com/products/737-794-798-0-0-0-0-0-0-0-1-1-1-1-72-33.html"));
		leftCateList.add(new FloorItem.LeftCate("话费补贴","http://channel.jd.com/yunyingshang.html"));
		leftCateList.add(new FloorItem.LeftCate("冰箱","http://www.jd.com/products/737-794-878-0-0-0-0-0-0-0-1-1-1-1-72-33.html"));
		leftCateList.add(new FloorItem.LeftCate("生活电器","http://www.jd.com/products/737-738-000.html"));
		leftCateList.add(new FloorItem.LeftCate("洗衣机","http://www.jd.com/products/737-794-878-0-0-0-0-0-0-0-1-1-1-1-72-33.html"));
		leftCateList.add(new FloorItem.LeftCate("厨房电器","http://www.jd.com/products/737-752-000.html"));
		leftCateList.add(new FloorItem.LeftCate("热水器","http://www.jd.com/products/737-794-878-0-0-0-0-0-0-0-1-1-1-1-72-33.html"));
		leftCateList.add(new FloorItem.LeftCate("个护健康","http://www.jd.com/products/737-1276-000.html"));
		leftCateList.add(new FloorItem.LeftCate("烟机/灶具","http://www.jd.com/products/737-794-878-0-0-0-0-0-0-0-1-1-1-1-72-33.html"));
		leftCateList.add(new FloorItem.LeftCate("五金家装","http://www.jd.com/products/737-1277-000.html"));
		leftCateList.add(new FloorItem.LeftCate("家庭影院","http://www.jd.com/products/737-794-823-0-0-0-0-0-0-0-1-1-1-1-72-33.html"));
		leftCateList.add(new FloorItem.LeftCate("酒柜冷柜","http://www.jd.com/products/737-794-1707-0-0-0-0-0-0-0-1-1-1-1-72-33.html"));
		leftCateList.add(new FloorItem.LeftCate("汽车用品","http://channel.jd.com/auto.html"));
		return leftCateList;
	}

}
