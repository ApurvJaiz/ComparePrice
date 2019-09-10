package service;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import Entities.Product;

public class AddServiceFlipkart 
{
	public Product add(String i) throws Exception
	{
		Product f=new Product();
		if(i.isEmpty())
			return f;
		i=processURL(i);
		String url="https://www.flipkart.com/search?q="+i+"&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=on&as=off";
		
		Document d = null;
		try {
			d = Jsoup.connect(url).timeout(6000).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			f.setName("Failed to connect to Flipkart: "+e.getMessage());
		}		
		
		Element data=d.select("div[data-id]").first();
		String dataid=data.attr("data-id");
		
		Element specs=data.select("img._1Nyybr").first();
		String specid=specs.attr("alt");
		//System.out.println(specid);
		f.setProduct(specid);
		
		String price=d.select("div[data-id="+dataid+"] div._1vC4OE").text();
		price=price.substring(1);
		//System.out.println("Price is Rs."+price);
		f.setPrice(price);
		f.setUrl(url);
		return f;
	}

	private String processURL(String str) 
	{
		// TODO Auto-generated method stub
		String res="";
		String[] split=str.split(" ");
		int l=split.length;
		res=split[0];
		for(int i=1;i<l;i++)
		{
			res=res+"%20"+split[i];
		}
		//System.out.println(res);
		return res;
	}
}
