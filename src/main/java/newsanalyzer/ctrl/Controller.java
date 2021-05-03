package newsanalyzer.ctrl;

import downloader.SequentialDownloader;
import newsapi.NewsApi;
import newsapi.beans.Article;
import newsapi.beans.NewsReponse;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Collectors;

public class Controller {

	public static final String APIKEY = "a4a1aa5ca3644801bb74367e1447c738";


	public void process(NewsApi newsApi) throws MalformedURLException, AnalyzerException {
		System.out.println("Start process");

		NewsReponse newsResponse = newsApi.getNews();
		if(newsResponse != null) {
			List<Article> articles = newsResponse.getArticles();
			articles.forEach(article -> System.out.println(article.toString()));

			List<String> urls = articles.stream()
					.map(Article::getUrl)
					.filter(Objects::nonNull)
					.collect(Collectors.toList());
			SequentialDownloader sequentialDownloader = new SequentialDownloader();
			sequentialDownloader.process(urls);
		}
		//TODO implement Error handling

		//TODO load the news based on the parameters

		//TODO implement methods for analysis

		System.out.println("End process");
	}




	public Object getData() {
		
		return null;
	}
}
