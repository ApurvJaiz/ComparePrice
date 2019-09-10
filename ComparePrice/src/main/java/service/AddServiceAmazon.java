package service;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import Entities.Product;

public class AddServiceAmazon
{
	public Product add(String i) throws Exception
	{
		i=processURL(i);
		String url="https://www.amazon.in/s?k="+i+"&ref=nb_sb_noss_2";
		Product p=new Product();
		Document html = null;
		try
		{
			html = Jsoup.connect(url).timeout(6000).get();
		}
		catch (IOException e)
		{
			p.setName("Failed to connect to Amazon: "+e.getMessage());
		}		
		
		String h1= html.body().getElementsByTag("h2").first().text();
		String price = html.body().getElementsByClass("a-offscreen").first().text();

		String product="";
		for(int j=0;j<h1.length();j++)
		{
			if(h1.charAt(j)!=')')
				product=product+h1.charAt(j);
			else
			{
				product=product+h1.charAt(j);
				break;
			}
		}
		Element image=html.select("div.s-image-fixed-height img.s-image").first();
		String img=image.attr("src");
		p.setImage(img);
		p.setPrice(price.substring(1));
		p.setProduct(product);
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
		//System.out.println(res);
		return res;
	}
}