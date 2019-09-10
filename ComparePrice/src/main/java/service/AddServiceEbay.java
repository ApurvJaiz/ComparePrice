package service;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import Entities.Product;

public class AddServiceEbay
{
	public Product add(String i) throws Exception
	{
		Product p=new Product();
		String[] split=i.split(" ");
		String key=split[0];
		i=processURL(i);
		String url="https://www.ebay.com/sch/i.html?_from=R40&_trksid=m570.l1313&_nkw="+i+"&_sacat=0";
		Document html = null;
		try
		{
			html = Jsoup.connect(url).timeout(6000).get();
		}
		catch (IOException e)
		{
			p.setName("Failed to connect to eBay: "+e.getMessage());
		}		
		Elements h3= html.select("h3.s-item__title");
		for (Element element : h3) {
			String str=element.text();
			if(str.toLowerCase().contains(key.toLowerCase()))
			{
				p.setProduct(str);
				//System.out.println(str);
				break;
			}
		}
		String price=html.select("span.s-item__price").first().text();
		price=price.replaceAll("INR","");
		p.setPrice(price);
		//System.out.println(price);
		p.setUrl(url);
		return p;
	}
	private static String processURL(String str)
	{
		String res="";
		String[] split=str.split(" ");
		int l=split.length;
		res=split[0];
		for(int i=1;i<l;i++)
		{
			res=res+"%20"+split[i];
		}
		return res;
	}
}