package com.huzhiyi.housereadily.biz.impl;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.htmlparser.Node;
import org.htmlparser.Parser;
import org.htmlparser.filters.AndFilter;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.nodes.TextNode;
import org.htmlparser.tags.DefinitionListBullet;
import org.htmlparser.tags.Div;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.tags.Span;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

import com.huzhiyi.housereadily.biz.IBrokerService;
import com.huzhiyi.housereadily.biz.impl.broker.Area;
import com.huzhiyi.housereadily.biz.impl.broker.SubArea;
import com.huzhiyi.housereadily.entity.Broker;
import com.huzhiyi.util.StringUtils;
import com.huzhiyi.utils.HttpHelper;

public class BrokerServiceImpl extends AbstractBrokerServiceImpl implements IBrokerService {

	private static final String basePath = "http://esf.sz.soufun.com";
	private List<Area> areaList;

	@Override
	public boolean existsBrokerByNameAndMobile(String name, String moblie) {
		return getBrokerDAO().findBrokerByNameAndMobile(name, moblie).getList().size() > 0;
	}

	@Override
	public void add(Broker broker) {
		if (!existsBrokerByNameAndMobile(broker.getName(), broker.getMobile())) {
			super.add(broker);
		}
	}

	@Override
	public boolean executeSouFun() {
		boolean result = true;
		try {
			areaList = new ArrayList<Area>();
			processAreaNode();
			processSubAreaNode();
			processBrokerNode();
		} catch (ParserException e) {
			result = false;
		}
		return result;
	}

	/**
	 * @Title: processAreaNode
	 * @Description: 解析大区
	 *               <p>
	 * @author willter
	 * @throws ParserException
	 * @date 2013-3-8
	 *       <p>
	 */
	private void processAreaNode() throws ParserException {
		String url = basePath + "/agenthome/";
		Map params = new HashMap<String, String>();
		String htmlContent = HttpHelper.doGet(url, params, "GB2312", false);

		Parser parser = Parser.createParser(htmlContent, "utf-8");
		AndFilter filter = new AndFilter(new TagNameFilter("dl"), new HasAttributeFilter("id", "dl_quxian"));
		NodeList list = parser.parse(filter);

		NodeList childList = list.elementAt(0).getChildren();
		for (int i = 0, size = childList.size(); i < size; i++) {
			// 去掉区域，不限两个标签
			if (i >= 5 && childList.elementAt(i) instanceof DefinitionListBullet) {
				Node link = childList.elementAt(i).getChildren().elementAt(0);
				if (link instanceof LinkTag) {
					LinkTag linkTag = (LinkTag) link;
					if (!linkTag.getChildrenHTML().equals("惠州") && !linkTag.getChildrenHTML().equals("东莞")) {
						// 保存大区信息
						Area area = new Area();
						area.setName(StringUtils.trim(linkTag.getChildrenHTML(), ' '));
						area.setUrl(linkTag.getLink());
						areaList.add(area);
					}
				}
			}
		}
	}

	/**
	 * @Title: processSubAreaNode
	 * @Description: 解析小区
	 *               <p>
	 * @author willter
	 * @date 2013-3-11
	 *       <p>
	 * @throws ParserException
	 */
	private void processSubAreaNode() throws ParserException {
		Area area = null;
		String url = null;
		Map params = new HashMap<String, String>();
		String htmlContent = null;
		for (int i = 0, size = areaList.size(); i < size; i++) {
			area = areaList.get(i);
			url = basePath + area.getUrl();
			htmlContent = HttpHelper.doGet(url, params, "GB2312", false);
			Parser parser = Parser.createParser(htmlContent, "utf-8");
			AndFilter filter = new AndFilter(new TagNameFilter("div"), new HasAttributeFilter("id", "tagContent0"));
			NodeList list = parser.parse(filter);

			NodeList childList = list.elementAt(0).getChildren();
			for (int j = 0, size$ = childList.size(); j < size$; j++) {
				// 去掉区域标签
				if (j >= 3 && childList.elementAt(j) instanceof LinkTag) {
					LinkTag linkTag = (LinkTag) childList.elementAt(j);
					// 保存小区信息
					SubArea subArea = new SubArea();
					subArea.setName(StringUtils.trim(linkTag.getChildrenHTML(), ' '));
					subArea.setUrl(linkTag.getLink());
					area.getSubAreas().add(subArea);
					//System.out.println(subArea.getUrl());
				}
			}
		}
	}

	/**
	 * @Title: processBrokerNode
	 * @Description: 解析经纪人节点
	 *               <p>
	 * @author willter
	 * @date 2013-3-12
	 *       <p>
	 * @throws ParserException
	 */
	private void processBrokerNode() throws ParserException {
		List<SubArea> subAreaList = null;
		String url = null;
		Map params = new HashMap<String, String>();
		String htmlContent = null;
		Broker broker = null;
		for (Area area : areaList) {
			subAreaList = area.getSubAreas();
			for (SubArea subArea : subAreaList) {
				url = basePath + subArea.getUrl();
				url = url.replaceAll("-i31", "-i3{0}");

				// 取100页
				for (int j = 1; j <= 100; j++) {
					htmlContent = HttpHelper.doGet(MessageFormat.format(url, j), params, "GB2312", false);
					Parser parser = Parser.createParser(htmlContent, "utf-8");
					AndFilter filter = new AndFilter(new TagNameFilter("div"), new HasAttributeFilter("class", "agent_pic"));
					NodeList list = parser.parse(filter);

					NodeList childList = list.elementAt(0).getChildren();
					for (int i = 0, size = childList.size(); i < size; i++) {
						if (childList.elementAt(i) instanceof Div) {
							// 获取<div class="house">节点
							Div houseDiv = (Div) childList.elementAt(i).getChildren().elementAt(1).getChildren().elementAt(5);
							NodeList pList = houseDiv.getChildren().elementAt(1).getChildren().elementAt(1).getChildren();

							broker = new Broker();
							int m = 1;

							// 姓名
							LinkTag linkTag = (LinkTag) pList.elementAt(m).getChildren().elementAt(1);
							broker.setName(StringUtils.trim(linkTag.getChildrenHTML(), ' '));

							// 公司
							if (pList.elementAt(3).getChildren().elementAt(1) instanceof Span) {
								m += 2;
								Span span = (Span) pList.elementAt(m).getChildren().elementAt(1);
								broker.setCompany(StringUtils.trim(span.getChildrenHTML(), ' '));
							}

							// 电话
							m += 2;
							TextNode textNode = (TextNode) pList.elementAt(m).getChildren().elementAt(2);
							broker.setMobile(StringUtils.trim(textNode.getText(), ' '));

							// 服务商圈
							m += 2;
							StringBuffer subAreaStr = new StringBuffer();
							NodeList saList = pList.elementAt(m).getChildren();
							for (int k = 0; k < saList.size(); k++) {
								if (saList.elementAt(k) instanceof LinkTag) {
									if (subAreaStr.length() > 0) {
										subAreaStr.append(",");
									}
									LinkTag saLinkTag = (LinkTag) saList.elementAt(k);
									subAreaStr.append(saLinkTag.getChildrenHTML());
								}
							}
							broker.setSubareas(StringUtils.trim(subAreaStr.toString(), ' '));

							// 新增经纪人
							add(broker);
							//System.out.println(MessageFormat.format(url, j) + "====" + subArea.getName() + "====" + i + "====" + broker);
						}
					}
				}
			}
		}
	}
}